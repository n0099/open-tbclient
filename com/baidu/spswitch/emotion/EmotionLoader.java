package com.baidu.spswitch.emotion;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.util.Log;
import android.util.LruCache;
import android.widget.TextView;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.spswitch.emotion.SpanStringUtils;
import com.baidu.spswitch.utils.SPConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class EmotionLoader {
    public static final boolean CACHE_DEBUG = false;
    public static final boolean DEBUG = SPConfig.isDebug();
    public static final float SIZE_RATIO = 1.15f;
    public static final String TAG = "EmotionLoader";
    public static final long WAITING_FOR_LOAD_MS = 350;
    public static EmotionLoader sInstance;
    public LruCache<String, Bitmap> mLruCache;
    public Handler mUIHandler;

    /* loaded from: classes2.dex */
    public class SpannableBeanHolder {
        public String content;
        public SpannableString ss;

        /* renamed from: tv  reason: collision with root package name */
        public TextView f10385tv;

        public SpannableBeanHolder() {
        }
    }

    public EmotionLoader() {
        init();
    }

    private void addBitmapToLruCache(String str, Bitmap bitmap) {
        LruCache<String, Bitmap> lruCache = this.mLruCache;
        if (lruCache == null || bitmap == null) {
            return;
        }
        lruCache.put(str, bitmap);
    }

    private Bitmap getBitmapFromLruCache(String str) {
        LruCache<String, Bitmap> lruCache = this.mLruCache;
        if (lruCache != null) {
            return lruCache.get(str);
        }
        return null;
    }

    public static EmotionLoader getInstance() {
        if (sInstance == null) {
            synchronized (EmotionLoader.class) {
                if (sInstance == null) {
                    sInstance = new EmotionLoader();
                }
            }
        }
        return sInstance;
    }

    private void init() {
        this.mLruCache = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 16) { // from class: com.baidu.spswitch.emotion.EmotionLoader.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.LruCache
            public int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }

    public void invalidCache() {
        LruCache<String, Bitmap> lruCache = this.mLruCache;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    public SpannableString parseEmotion(EmotionType emotionType, Context context, CharSequence charSequence, TextView textView, float f2) {
        Bitmap bitmap;
        EmotionUtils.getInstance().waitForEmotionLoadedIfNeeded(350L);
        SpannableString spannableString = new SpannableString(charSequence);
        Matcher matcher = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(spannableString);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int textSize = (int) (textView.getTextSize() * f2);
            Bitmap bitmapFromLruCache = getBitmapFromLruCache(group);
            if (bitmapFromLruCache == null && (bitmapFromLruCache = EmotionUtils.getInstance().getEmotionBitmapByName(emotionType, group)) != null) {
                addBitmapToLruCache(group, bitmapFromLruCache);
            }
            if (bitmapFromLruCache != null && ((bitmapFromLruCache.getHeight() != textSize || bitmapFromLruCache.getWidth() != textSize) && (bitmapFromLruCache = EmotionUtils.getInstance().getEmotionBitmapByName(emotionType, group)) != null)) {
                try {
                    bitmap = Bitmap.createScaledBitmap(bitmapFromLruCache, textSize, textSize, true);
                } catch (Throwable unused) {
                    bitmap = null;
                }
                bitmapFromLruCache = bitmap;
                if (bitmapFromLruCache != null) {
                    addBitmapToLruCache(group, bitmapFromLruCache);
                }
            }
            if (bitmapFromLruCache != null) {
                spannableString.setSpan(new SpanStringUtils.CenterImageSpan(context.getApplicationContext(), bitmapFromLruCache), start, group.length() + start, 33);
            }
        }
        return spannableString;
    }

    public void parseEmotionAsync(final EmotionType emotionType, final Context context, final String str, final TextView textView) {
        textView.setTag(str);
        if (this.mUIHandler == null) {
            this.mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.spswitch.emotion.EmotionLoader.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    SpannableBeanHolder spannableBeanHolder = (SpannableBeanHolder) message.obj;
                    TextView textView2 = spannableBeanHolder.f10385tv;
                    SpannableString spannableString = spannableBeanHolder.ss;
                    String str2 = spannableBeanHolder.content;
                    if (EmotionLoader.DEBUG) {
                        Log.d(EmotionLoader.TAG, "parseEmotionAsync UIHandler handleMessage, content: " + str2);
                    }
                    if (textView2.getTag().toString().equals(str2)) {
                        textView2.setText(spannableString);
                    }
                }
            };
        }
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.spswitch.emotion.EmotionLoader.3
            @Override // java.lang.Runnable
            public void run() {
                if (EmotionLoader.DEBUG) {
                    Log.d(EmotionLoader.TAG, "parseEmotionAsync postOnElastic, content: " + str);
                }
                SpannableString parseEmotion = EmotionLoader.this.parseEmotion(emotionType, context, str, textView);
                SpannableBeanHolder spannableBeanHolder = new SpannableBeanHolder();
                spannableBeanHolder.ss = parseEmotion;
                spannableBeanHolder.f10385tv = textView;
                spannableBeanHolder.content = str;
                Message obtain = Message.obtain();
                obtain.obj = spannableBeanHolder;
                EmotionLoader.this.mUIHandler.sendMessage(obtain);
            }
        }, "parseEmotionAsync", 1);
    }

    public SpannableString parseEmotion(EmotionType emotionType, Context context, CharSequence charSequence, TextView textView) {
        return parseEmotion(emotionType, context, charSequence, textView, 1.15f);
    }
}
