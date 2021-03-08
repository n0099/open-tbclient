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
    private static a cCo;
    private Thread cCp;
    private Handler cCq;
    private ExecutorService cCr;
    private LruCache<String, Bitmap> cCs;
    private Semaphore cCt = new Semaphore(0);
    private Semaphore cCu;
    private LinkedList<Runnable> mTasks;

    private a(int i) {
        init(i);
    }

    public static a afK() {
        if (cCo == null) {
            synchronized (a.class) {
                if (cCo == null) {
                    cCo = new a(3);
                }
            }
        }
        return cCo;
    }

    private void init(int i) {
        this.cCp = new Thread() { // from class: com.baidu.spswitch.emotion.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                Looper.prepare();
                a.this.cCq = new Handler() { // from class: com.baidu.spswitch.emotion.a.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        a.this.cCr.execute(a.this.afL());
                        Log.d("EmotionLoader", "thread poop execute one task, task queue size: " + a.this.mTasks.size());
                        try {
                            a.this.cCu.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.this.cCt.release();
                Looper.loop();
            }
        };
        this.cCp.start();
        this.cCu = new Semaphore(i);
        this.cCr = Executors.newFixedThreadPool(i);
        this.mTasks = new LinkedList<>();
        this.cCs = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.baidu.spswitch.emotion.a.2
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
            Integer valueOf = Integer.valueOf(b.bP(context).a(emotionType, group));
            if (valueOf != null) {
                int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
                Bitmap jQ = jQ(group);
                if (jQ == null) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, valueOf.intValue());
                    if (decodeResource != null) {
                        jQ = Bitmap.createScaledBitmap(decodeResource, textSize, textSize, true);
                        e(group, jQ);
                    }
                    createScaledBitmap = jQ;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(jQ, textSize, textSize, true);
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

    private Bitmap jQ(String str) {
        if (this.cCs != null) {
            return this.cCs.get(str);
        }
        return null;
    }

    private void e(String str, Bitmap bitmap) {
        if (jQ(str) == null && bitmap != null) {
            this.cCs.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable afL() {
        return this.mTasks.removeLast();
    }
}
