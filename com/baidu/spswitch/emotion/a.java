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
/* loaded from: classes24.dex */
public class a {
    private static a bSr;
    private Thread bSs;
    private Handler bSt;
    private ExecutorService bSu;
    private LruCache<String, Bitmap> bSv;
    private Semaphore bSw = new Semaphore(0);
    private Semaphore bSx;
    private LinkedList<Runnable> mTasks;

    private a(int i) {
        gu(i);
    }

    public static a Ym() {
        if (bSr == null) {
            synchronized (a.class) {
                if (bSr == null) {
                    bSr = new a(3);
                }
            }
        }
        return bSr;
    }

    private void gu(int i) {
        this.bSs = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.bSt = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.bSu.execute(a.this.Yn());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.mTasks.size());
                        try {
                            a.this.bSx.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.bSw.release();
                Looper.loop();
            }
        };
        this.bSs.start();
        this.bSx = new Semaphore(i);
        this.bSu = Executors.newFixedThreadPool(i);
        this.mTasks = new LinkedList<>();
        this.bSv = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
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
            Integer valueOf = Integer.valueOf(b.aX(context).a(emotionType, group));
            if (valueOf != null) {
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap iO = iO(group);
                if (iO == null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, valueOf.intValue());
                    if (decodeResource != null) {
                        iO = Bitmap.createScaledBitmap(decodeResource, textSize, textSize, true);
                        f(group, iO);
                    }
                    createScaledBitmap = iO;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(iO, textSize, textSize, true);
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

    private Bitmap iO(String str) {
        if (this.bSv != null) {
            return this.bSv.get(str);
        }
        return null;
    }

    private void f(String str, Bitmap bitmap) {
        if (iO(str) == null && bitmap != null) {
            this.bSv.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable Yn() {
        return this.mTasks.removeLast();
    }
}
