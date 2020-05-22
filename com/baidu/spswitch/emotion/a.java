package com.baidu.spswitch.emotion;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.util.Log;
import android.util.LruCache;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.spswitch.emotion.d;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes13.dex */
public class a {
    private static a bFG;
    private Thread bFH;
    private Handler bFI;
    private ExecutorService bFJ;
    private LinkedList<Runnable> bFK;
    private LruCache<String, Bitmap> bFL;
    private Semaphore bFM = new Semaphore(0);
    private Semaphore bFN;

    private a(int i) {
        dF(i);
    }

    public static a Qn() {
        if (bFG == null) {
            synchronized (a.class) {
                if (bFG == null) {
                    bFG = new a(3);
                }
            }
        }
        return bFG;
    }

    private void dF(int i) {
        this.bFH = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.bFI = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.bFJ.execute(a.this.Qo());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.bFK.size());
                        try {
                            a.this.bFN.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.bFM.release();
                Looper.loop();
            }
        };
        this.bFH.start();
        this.bFN = new Semaphore(i);
        this.bFJ = Executors.newFixedThreadPool(i);
        this.bFK = new LinkedList<>();
        this.bFL = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: g */
            public int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }

    public SpannableString a(EmotionType emotionType, Context context, CharSequence charSequence, TextView textView) {
        Bitmap createScaledBitmap;
        Object aVar;
        Log.d("EmotionLoader", "parseEmotion in UI thread, use cache");
        SpannableString spannableString = new SpannableString(charSequence);
        Resources resources = context.getResources();
        Matcher matcher = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(spannableString);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            Integer valueOf = Integer.valueOf(b.aR(context).a(emotionType, group));
            if (valueOf != null) {
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap gU = gU(group);
                if (gU == null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, valueOf.intValue());
                    if (decodeResource != null) {
                        gU = Bitmap.createScaledBitmap(decodeResource, textSize, textSize, true);
                        f(group, gU);
                    }
                    createScaledBitmap = gU;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(gU, textSize, textSize, true);
                }
                if (createScaledBitmap != null) {
                    if (textView instanceof EditText) {
                        aVar = new d.b(context.getApplicationContext(), createScaledBitmap);
                    } else {
                        aVar = new d.a(context.getApplicationContext(), createScaledBitmap);
                    }
                    spannableString.setSpan(aVar, start, group.length() + start, 33);
                }
            }
        }
        return spannableString;
    }

    private Bitmap gU(String str) {
        if (this.bFL != null) {
            return this.bFL.get(str);
        }
        return null;
    }

    private void f(String str, Bitmap bitmap) {
        if (gU(str) == null && bitmap != null) {
            this.bFL.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable Qo() {
        return this.bFK.removeLast();
    }
}
