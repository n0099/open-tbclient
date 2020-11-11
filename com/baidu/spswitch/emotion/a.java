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
/* loaded from: classes19.dex */
public class a {
    private static a cta;
    private Thread ctb;
    private Handler ctc;
    private ExecutorService ctd;
    private LruCache<String, Bitmap> cte;
    private Semaphore ctf = new Semaphore(0);
    private Semaphore ctg;
    private LinkedList<Runnable> mTasks;

    private a(int i) {
        hm(i);
    }

    public static a afs() {
        if (cta == null) {
            synchronized (a.class) {
                if (cta == null) {
                    cta = new a(3);
                }
            }
        }
        return cta;
    }

    private void hm(int i) {
        this.ctb = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.ctc = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.ctd.execute(a.this.aft());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.mTasks.size());
                        try {
                            a.this.ctg.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.ctf.release();
                Looper.loop();
            }
        };
        this.ctb.start();
        this.ctg = new Semaphore(i);
        this.ctd = Executors.newFixedThreadPool(i);
        this.mTasks = new LinkedList<>();
        this.cte = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
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
            Integer valueOf = Integer.valueOf(b.bd(context).a(emotionType, group));
            if (valueOf != null) {
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap ki = ki(group);
                if (ki == null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, valueOf.intValue());
                    if (decodeResource != null) {
                        ki = Bitmap.createScaledBitmap(decodeResource, textSize, textSize, true);
                        f(group, ki);
                    }
                    createScaledBitmap = ki;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(ki, textSize, textSize, true);
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

    private Bitmap ki(String str) {
        if (this.cte != null) {
            return this.cte.get(str);
        }
        return null;
    }

    private void f(String str, Bitmap bitmap) {
        if (ki(str) == null && bitmap != null) {
            this.cte.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable aft() {
        return this.mTasks.removeLast();
    }
}
