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
/* loaded from: classes6.dex */
public class a {
    private static a cym;
    private Thread cyn;
    private Handler cyo;
    private ExecutorService cyp;
    private LruCache<String, Bitmap> cyq;
    private Semaphore cyr = new Semaphore(0);
    private Semaphore cys;
    private LinkedList<Runnable> mTasks;

    private a(int i) {
        hG(i);
    }

    public static a ahS() {
        if (cym == null) {
            synchronized (a.class) {
                if (cym == null) {
                    cym = new a(3);
                }
            }
        }
        return cym;
    }

    private void hG(int i) {
        this.cyn = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.cyo = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.cyp.execute(a.this.ahT());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.mTasks.size());
                        try {
                            a.this.cys.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.cyr.release();
                Looper.loop();
            }
        };
        this.cyn.start();
        this.cys = new Semaphore(i);
        this.cyp = Executors.newFixedThreadPool(i);
        this.mTasks = new LinkedList<>();
        this.cyq = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
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
            Integer valueOf = Integer.valueOf(b.bJ(context).a(emotionType, group));
            if (valueOf != null) {
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap kJ = kJ(group);
                if (kJ == null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, valueOf.intValue());
                    if (decodeResource != null) {
                        kJ = Bitmap.createScaledBitmap(decodeResource, textSize, textSize, true);
                        f(group, kJ);
                    }
                    createScaledBitmap = kJ;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(kJ, textSize, textSize, true);
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

    private Bitmap kJ(String str) {
        if (this.cyq != null) {
            return this.cyq.get(str);
        }
        return null;
    }

    private void f(String str, Bitmap bitmap) {
        if (kJ(str) == null && bitmap != null) {
            this.cyq.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable ahT() {
        return this.mTasks.removeLast();
    }
}
