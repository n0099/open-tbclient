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
/* loaded from: classes3.dex */
public class a {
    private static a bKQ;
    private Thread bKR;
    private Handler bKS;
    private ExecutorService bKT;
    private LinkedList<Runnable> bKU;
    private LruCache<String, Bitmap> bKV;
    private Semaphore bKW = new Semaphore(0);
    private Semaphore bKX;

    private a(int i) {
        en(i);
    }

    public static a RI() {
        if (bKQ == null) {
            synchronized (a.class) {
                if (bKQ == null) {
                    bKQ = new a(3);
                }
            }
        }
        return bKQ;
    }

    private void en(int i) {
        this.bKR = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.bKS = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.bKT.execute(a.this.RJ());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.bKU.size());
                        try {
                            a.this.bKX.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.bKW.release();
                Looper.loop();
            }
        };
        this.bKR.start();
        this.bKX = new Semaphore(i);
        this.bKT = Executors.newFixedThreadPool(i);
        this.bKU = new LinkedList<>();
        this.bKV = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
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
            Integer valueOf = Integer.valueOf(b.aT(context).a(emotionType, group));
            if (valueOf != null) {
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap ha = ha(group);
                if (ha == null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, valueOf.intValue());
                    if (decodeResource != null) {
                        ha = Bitmap.createScaledBitmap(decodeResource, textSize, textSize, true);
                        f(group, ha);
                    }
                    createScaledBitmap = ha;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(ha, textSize, textSize, true);
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

    private Bitmap ha(String str) {
        if (this.bKV != null) {
            return this.bKV.get(str);
        }
        return null;
    }

    private void f(String str, Bitmap bitmap) {
        if (ha(str) == null && bitmap != null) {
            this.bKV.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable RJ() {
        return this.bKU.removeLast();
    }
}
