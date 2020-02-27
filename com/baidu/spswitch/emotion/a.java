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
    private static a aZj;
    private Thread aZk;
    private Handler aZl;
    private ExecutorService aZm;
    private LinkedList<Runnable> aZn;
    private LruCache<String, Bitmap> aZo;
    private Semaphore aZp = new Semaphore(0);
    private Semaphore aZq;

    private a(int i) {
        init(i);
    }

    public static a Gh() {
        if (aZj == null) {
            synchronized (a.class) {
                if (aZj == null) {
                    aZj = new a(3);
                }
            }
        }
        return aZj;
    }

    private void init(int i) {
        this.aZk = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.aZl = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.aZm.execute(a.this.Gi());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.aZn.size());
                        try {
                            a.this.aZq.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.aZp.release();
                Looper.loop();
            }
        };
        this.aZk.start();
        this.aZq = new Semaphore(i);
        this.aZm = Executors.newFixedThreadPool(i);
        this.aZn = new LinkedList<>();
        this.aZo = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
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
        if (this.aZo != null) {
            return this.aZo.get(str);
        }
        return null;
    }

    private void f(String str, Bitmap bitmap) {
        if (eX(str) == null && bitmap != null) {
            this.aZo.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable Gi() {
        return this.aZn.removeLast();
    }
}
