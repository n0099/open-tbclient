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
    private static a bKu;
    private Semaphore bKA = new Semaphore(0);
    private Semaphore bKB;
    private Thread bKv;
    private Handler bKw;
    private ExecutorService bKx;
    private LinkedList<Runnable> bKy;
    private LruCache<String, Bitmap> bKz;

    private a(int i) {
        dS(i);
    }

    public static a Rt() {
        if (bKu == null) {
            synchronized (a.class) {
                if (bKu == null) {
                    bKu = new a(3);
                }
            }
        }
        return bKu;
    }

    private void dS(int i) {
        this.bKv = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.bKw = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.bKx.execute(a.this.Ru());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.bKy.size());
                        try {
                            a.this.bKB.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.bKA.release();
                Looper.loop();
            }
        };
        this.bKv.start();
        this.bKB = new Semaphore(i);
        this.bKx = Executors.newFixedThreadPool(i);
        this.bKy = new LinkedList<>();
        this.bKz = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
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
            Integer valueOf = Integer.valueOf(b.aS(context).a(emotionType, group));
            if (valueOf != null) {
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap hc = hc(group);
                if (hc == null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, valueOf.intValue());
                    if (decodeResource != null) {
                        hc = Bitmap.createScaledBitmap(decodeResource, textSize, textSize, true);
                        f(group, hc);
                    }
                    createScaledBitmap = hc;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(hc, textSize, textSize, true);
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

    private Bitmap hc(String str) {
        if (this.bKz != null) {
            return this.bKz.get(str);
        }
        return null;
    }

    private void f(String str, Bitmap bitmap) {
        if (hc(str) == null && bitmap != null) {
            this.bKz.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable Ru() {
        return this.bKy.removeLast();
    }
}
