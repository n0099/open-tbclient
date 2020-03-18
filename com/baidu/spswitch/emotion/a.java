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
    private static a aZy;
    private Handler aZA;
    private ExecutorService aZB;
    private LinkedList<Runnable> aZC;
    private LruCache<String, Bitmap> aZD;
    private Semaphore aZE = new Semaphore(0);
    private Semaphore aZF;
    private Thread aZz;

    private a(int i) {
        init(i);
    }

    public static a Go() {
        if (aZy == null) {
            synchronized (a.class) {
                if (aZy == null) {
                    aZy = new a(3);
                }
            }
        }
        return aZy;
    }

    private void init(int i) {
        this.aZz = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.aZA = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.aZB.execute(a.this.Gp());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.aZC.size());
                        try {
                            a.this.aZF.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.aZE.release();
                Looper.loop();
            }
        };
        this.aZz.start();
        this.aZF = new Semaphore(i);
        this.aZB = Executors.newFixedThreadPool(i);
        this.aZC = new LinkedList<>();
        this.aZD = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
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
            Integer valueOf = Integer.valueOf(b.bb(context).a(emotionType, group));
            if (valueOf != null) {
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap eW = eW(group);
                if (eW == null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, valueOf.intValue());
                    if (decodeResource != null) {
                        eW = Bitmap.createScaledBitmap(decodeResource, textSize, textSize, true);
                        f(group, eW);
                    }
                    createScaledBitmap = eW;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(eW, textSize, textSize, true);
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

    private Bitmap eW(String str) {
        if (this.aZD != null) {
            return this.aZD.get(str);
        }
        return null;
    }

    private void f(String str, Bitmap bitmap) {
        if (eW(str) == null && bitmap != null) {
            this.aZD.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable Gp() {
        return this.aZC.removeLast();
    }
}
