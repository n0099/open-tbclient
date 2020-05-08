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
    private static a byd;
    private Thread bye;
    private Handler byf;
    private ExecutorService byg;
    private LinkedList<Runnable> byh;
    private LruCache<String, Bitmap> byi;
    private Semaphore byj = new Semaphore(0);
    private Semaphore byk;

    private a(int i) {
        dz(i);
    }

    public static a Oa() {
        if (byd == null) {
            synchronized (a.class) {
                if (byd == null) {
                    byd = new a(3);
                }
            }
        }
        return byd;
    }

    private void dz(int i) {
        this.bye = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.byf = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.byg.execute(a.this.Ob());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.byh.size());
                        try {
                            a.this.byk.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.byj.release();
                Looper.loop();
            }
        };
        this.bye.start();
        this.byk = new Semaphore(i);
        this.byg = Executors.newFixedThreadPool(i);
        this.byh = new LinkedList<>();
        this.byi = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
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
            Integer valueOf = Integer.valueOf(b.aH(context).a(emotionType, group));
            if (valueOf != null) {
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap gi = gi(group);
                if (gi == null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, valueOf.intValue());
                    if (decodeResource != null) {
                        gi = Bitmap.createScaledBitmap(decodeResource, textSize, textSize, true);
                        f(group, gi);
                    }
                    createScaledBitmap = gi;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(gi, textSize, textSize, true);
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

    private Bitmap gi(String str) {
        if (this.byi != null) {
            return this.byi.get(str);
        }
        return null;
    }

    private void f(String str, Bitmap bitmap) {
        if (gi(str) == null && bitmap != null) {
            this.byi.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable Ob() {
        return this.byh.removeLast();
    }
}
