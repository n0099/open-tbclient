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
    private static a aZl;
    private Thread aZm;
    private Handler aZn;
    private ExecutorService aZo;
    private LinkedList<Runnable> aZp;
    private LruCache<String, Bitmap> aZq;
    private Semaphore aZr = new Semaphore(0);
    private Semaphore aZs;

    private a(int i) {
        init(i);
    }

    public static a Gj() {
        if (aZl == null) {
            synchronized (a.class) {
                if (aZl == null) {
                    aZl = new a(3);
                }
            }
        }
        return aZl;
    }

    private void init(int i) {
        this.aZm = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.aZn = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.aZo.execute(a.this.Gk());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.aZp.size());
                        try {
                            a.this.aZs.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.aZr.release();
                Looper.loop();
            }
        };
        this.aZm.start();
        this.aZs = new Semaphore(i);
        this.aZo = Executors.newFixedThreadPool(i);
        this.aZp = new LinkedList<>();
        this.aZq = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
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
            Integer valueOf = Integer.valueOf(b.bc(context).a(emotionType, group));
            if (valueOf != null) {
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap eX = eX(group);
                if (eX == null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, valueOf.intValue());
                    if (decodeResource != null) {
                        eX = Bitmap.createScaledBitmap(decodeResource, textSize, textSize, true);
                        f(group, eX);
                    }
                    createScaledBitmap = eX;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(eX, textSize, textSize, true);
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

    private Bitmap eX(String str) {
        if (this.aZq != null) {
            return this.aZq.get(str);
        }
        return null;
    }

    private void f(String str, Bitmap bitmap) {
        if (eX(str) == null && bitmap != null) {
            this.aZq.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable Gk() {
        return this.aZp.removeLast();
    }
}
