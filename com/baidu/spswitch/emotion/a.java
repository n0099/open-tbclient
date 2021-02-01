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
    private static a cAO;
    private Thread cAP;
    private Handler cAQ;
    private ExecutorService cAR;
    private LruCache<String, Bitmap> cAS;
    private Semaphore cAT = new Semaphore(0);
    private Semaphore cAU;
    private LinkedList<Runnable> mTasks;

    private a(int i) {
        init(i);
    }

    public static a afH() {
        if (cAO == null) {
            synchronized (a.class) {
                if (cAO == null) {
                    cAO = new a(3);
                }
            }
        }
        return cAO;
    }

    private void init(int i) {
        this.cAP = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.cAQ = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.cAR.execute(a.this.afI());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.mTasks.size());
                        try {
                            a.this.cAU.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.cAT.release();
                Looper.loop();
            }
        };
        this.cAP.start();
        this.cAU = new Semaphore(i);
        this.cAR = Executors.newFixedThreadPool(i);
        this.mTasks = new LinkedList<>();
        this.cAS = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
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
            Integer valueOf = Integer.valueOf(b.bQ(context).a(emotionType, group));
            if (valueOf != null) {
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap jJ = jJ(group);
                if (jJ == null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, valueOf.intValue());
                    if (decodeResource != null) {
                        jJ = Bitmap.createScaledBitmap(decodeResource, textSize, textSize, true);
                        e(group, jJ);
                    }
                    createScaledBitmap = jJ;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(jJ, textSize, textSize, true);
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

    private Bitmap jJ(String str) {
        if (this.cAS != null) {
            return this.cAS.get(str);
        }
        return null;
    }

    private void e(String str, Bitmap bitmap) {
        if (jJ(str) == null && bitmap != null) {
            this.cAS.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable afI() {
        return this.mTasks.removeLast();
    }
}
