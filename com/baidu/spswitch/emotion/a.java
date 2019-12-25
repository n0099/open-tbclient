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
/* loaded from: classes11.dex */
public class a {
    private static a aUf;
    private Thread aUg;
    private Handler aUh;
    private ExecutorService aUi;
    private LinkedList<Runnable> aUj;
    private LruCache<String, Bitmap> aUk;
    private Semaphore aUl = new Semaphore(0);
    private Semaphore aUm;

    private a(int i) {
        init(i);
    }

    public static a Dw() {
        if (aUf == null) {
            synchronized (a.class) {
                if (aUf == null) {
                    aUf = new a(3);
                }
            }
        }
        return aUf;
    }

    private void init(int i) {
        this.aUg = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.aUh = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.aUi.execute(a.this.Dx());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.aUj.size());
                        try {
                            a.this.aUm.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.aUl.release();
                Looper.loop();
            }
        };
        this.aUg.start();
        this.aUm = new Semaphore(i);
        this.aUi = Executors.newFixedThreadPool(i);
        this.aUj = new LinkedList<>();
        this.aUk = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
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
            Integer valueOf = Integer.valueOf(b.aY(context).a(emotionType, group));
            if (valueOf != null) {
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap eF = eF(group);
                if (eF == null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, valueOf.intValue());
                    if (decodeResource != null) {
                        eF = Bitmap.createScaledBitmap(decodeResource, textSize, textSize, true);
                        f(group, eF);
                    }
                    createScaledBitmap = eF;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(eF, textSize, textSize, true);
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

    private Bitmap eF(String str) {
        if (this.aUk != null) {
            return this.aUk.get(str);
        }
        return null;
    }

    private void f(String str, Bitmap bitmap) {
        if (eF(str) == null && bitmap != null) {
            this.aUk.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable Dx() {
        return this.aUj.removeLast();
    }
}
