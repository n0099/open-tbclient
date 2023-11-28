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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.spswitch.emotion.SpanStringUtils;
import com.baidu.spswitch.utils.SPConfig;
import com.baidu.tieba.w30;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class EmotionLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean CACHE_DEBUG = false;
    public static final boolean DEBUG;
    public static final float SIZE_RATIO = 1.15f;
    public static final String TAG = "EmotionLoader";
    public static final long WAITING_FOR_LOAD_MS = 350;
    public static EmotionLoader sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public LruCache<String, Bitmap> mLruCache;
    public Handler mUIHandler;

    /* loaded from: classes4.dex */
    public class SpannableBeanHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public SpannableString ss;
        public final /* synthetic */ EmotionLoader this$0;

        /* renamed from: tv  reason: collision with root package name */
        public TextView f1067tv;

        public SpannableBeanHolder(EmotionLoader emotionLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = emotionLoader;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2103967439, "Lcom/baidu/spswitch/emotion/EmotionLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2103967439, "Lcom/baidu/spswitch/emotion/EmotionLoader;");
                return;
            }
        }
        DEBUG = SPConfig.isDebug();
    }

    public EmotionLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init();
    }

    public static EmotionLoader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (sInstance == null) {
                synchronized (EmotionLoader.class) {
                    if (sInstance == null) {
                        sInstance = new EmotionLoader();
                    }
                }
            }
            return sInstance;
        }
        return (EmotionLoader) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mLruCache = new LruCache<String, Bitmap>(this, ((int) Runtime.getRuntime().maxMemory()) / 16) { // from class: com.baidu.spswitch.emotion.EmotionLoader.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EmotionLoader this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.util.LruCache
                public int sizeOf(String str, Bitmap bitmap) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bitmap)) == null) {
                        return bitmap.getRowBytes() * bitmap.getHeight();
                    }
                    return invokeLL.intValue;
                }
            };
        }
    }

    public void invalidCache() {
        LruCache<String, Bitmap> lruCache;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (lruCache = this.mLruCache) != null) {
            lruCache.evictAll();
        }
    }

    private Bitmap getBitmapFromLruCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            LruCache<String, Bitmap> lruCache = this.mLruCache;
            if (lruCache != null) {
                return lruCache.get(str);
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    private void addBitmapToLruCache(String str, Bitmap bitmap) {
        LruCache<String, Bitmap> lruCache;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, bitmap) == null) && (lruCache = this.mLruCache) != null && bitmap != null) {
            lruCache.put(str, bitmap);
        }
    }

    public SpannableString parseEmotion(EmotionType emotionType, Context context, CharSequence charSequence, TextView textView) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionType, context, charSequence, textView)) == null) {
            return parseEmotion(emotionType, context, charSequence, textView, 1.15f);
        }
        return (SpannableString) invokeLLLL.objValue;
    }

    public SpannableString parseEmotion(EmotionType emotionType, Context context, CharSequence charSequence, TextView textView, float f) {
        InterceptResult invokeCommon;
        int i;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{emotionType, context, charSequence, textView, Float.valueOf(f)})) == null) {
            if (!w30.a()) {
                EmotionUtils.getInstance().waitForEmotionLoadedIfNeeded(350L);
            }
            if (charSequence == null) {
                charSequence = "";
            }
            SpannableString spannableString = new SpannableString(charSequence);
            Matcher matcher = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(spannableString);
            while (matcher.find()) {
                if (w30.a()) {
                    EmotionUtils.getInstance().waitForEmotionLoadedIfNeeded(350L);
                }
                String group = matcher.group();
                int start = matcher.start();
                if (textView != null) {
                    i = (int) (textView.getTextSize() * f);
                } else {
                    i = 0;
                }
                Bitmap bitmapFromLruCache = getBitmapFromLruCache(group);
                if (bitmapFromLruCache == null && (bitmapFromLruCache = EmotionUtils.getInstance().getEmotionBitmapByName(emotionType, group)) != null) {
                    addBitmapToLruCache(group, bitmapFromLruCache);
                }
                if (bitmapFromLruCache != null && ((bitmapFromLruCache.getHeight() != i || bitmapFromLruCache.getWidth() != i) && (bitmapFromLruCache = EmotionUtils.getInstance().getEmotionBitmapByName(emotionType, group)) != null)) {
                    try {
                        bitmap = Bitmap.createScaledBitmap(bitmapFromLruCache, i, i, true);
                    } catch (Exception unused) {
                        bitmap = null;
                    }
                    bitmapFromLruCache = bitmap;
                    if (bitmapFromLruCache != null) {
                        addBitmapToLruCache(group, bitmapFromLruCache);
                    }
                }
                if (bitmapFromLruCache != null) {
                    spannableString.setSpan(new SpanStringUtils.CenterImageSpan(AppRuntime.getAppContext(), bitmapFromLruCache), start, group.length() + start, 33);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public void parseEmotionAsync(EmotionType emotionType, Context context, String str, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, emotionType, context, str, textView) == null) {
            textView.setTag(str);
            if (this.mUIHandler == null) {
                this.mUIHandler = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.spswitch.emotion.EmotionLoader.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ EmotionLoader this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super((Looper) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                            SpannableBeanHolder spannableBeanHolder = (SpannableBeanHolder) message.obj;
                            TextView textView2 = spannableBeanHolder.f1067tv;
                            SpannableString spannableString = spannableBeanHolder.ss;
                            String str2 = spannableBeanHolder.content;
                            if (EmotionLoader.DEBUG) {
                                Log.d(EmotionLoader.TAG, "parseEmotionAsync UIHandler handleMessage, content: " + str2);
                            }
                            if (textView2.getTag().toString().equals(str2)) {
                                textView2.setText(spannableString);
                            }
                        }
                    }
                };
            }
            ExecutorUtilsExt.postOnElastic(new Runnable(this, str, emotionType, context, textView) { // from class: com.baidu.spswitch.emotion.EmotionLoader.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EmotionLoader this$0;
                public final /* synthetic */ String val$content;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ TextView val$textView;
                public final /* synthetic */ EmotionType val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, emotionType, context, textView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$content = str;
                    this.val$type = emotionType;
                    this.val$context = context;
                    this.val$textView = textView;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (EmotionLoader.DEBUG) {
                            Log.d(EmotionLoader.TAG, "parseEmotionAsync postOnElastic, content: " + this.val$content);
                        }
                        SpannableString parseEmotion = this.this$0.parseEmotion(this.val$type, this.val$context, this.val$content, this.val$textView);
                        SpannableBeanHolder spannableBeanHolder = new SpannableBeanHolder();
                        spannableBeanHolder.ss = parseEmotion;
                        spannableBeanHolder.f1067tv = this.val$textView;
                        spannableBeanHolder.content = this.val$content;
                        Message obtain = Message.obtain();
                        obtain.obj = spannableBeanHolder;
                        this.this$0.mUIHandler.sendMessage(obtain);
                    }
                }
            }, "parseEmotionAsync", 1);
        }
    }
}
