package com.baidu.spswitch.emotion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.FontSizeConfig;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.spswitch.emotion.SpanStringUtils;
import com.baidu.spswitch.emotion.bean.EmotionItemModel;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class Emoticons {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DISPLAY_SIZE_1080 = 1080;
    public static final String EMOTICONS_REGEX = "\\[\\w+\\]";
    public static final String KEY_ATTR = "attr";
    public static final String KEY_CONTENT_RICH = "content_rich";
    public static final String KEY_ID = "id";
    public static final String KEY_LENGTH = "length";
    public static final String KEY_START = "start";
    public static final String KEY_TEXT = "text";
    public static final String KEY_TYPE = "type";
    public static final String KEY_URL = "url";
    public static final int MARGIN_SIDE = 8;
    public static final int MEMORY_WEIGHT = 16;
    public static final int NIGHT_MASK = 128;
    public static final float RESCALE = 0.66f;
    public static final float SCALE_BIG = 1.0f;
    public static final float SCALE_MIDDLE = 0.87f;
    public static final float SCALE_SMALL = 0.8f;
    public static final float SCALE_VERY_BIG = 1.1f;
    public static final String TAG = "Emoticons";
    public static final int TYPE_EMOTICONS = 5;
    public static Emoticons mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public LruCache<String, Bitmap> mLruCache;

    /* loaded from: classes4.dex */
    public interface BitmapCallback {
        void processBitmap(@NonNull Bitmap bitmap);
    }

    /* loaded from: classes4.dex */
    public static class PaddingImageSpan extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap mBitmap;
        public int mPaddingLeftPx;
        public int mPaddingRightPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaddingImageSpan(@NonNull Context context, @NonNull Bitmap bitmap, int i, int i2) {
            super(context, bitmap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bitmap, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (Bitmap) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPaddingLeftPx = i;
            this.mPaddingRightPx = i2;
            this.mBitmap = bitmap;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
                Drawable drawable = getDrawable();
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                int i6 = this.mPaddingLeftPx;
                if (i6 <= 0) {
                    i6 = 0;
                }
                int i7 = ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
                canvas.save();
                canvas.translate(f + i6, i7);
                if (NightModeHelper.getNightModeSwitcherState()) {
                    drawable.setAlpha(128);
                }
                drawable.draw(canvas);
                canvas.restore();
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
                return this.mBitmap.getWidth() + this.mPaddingLeftPx + this.mPaddingRightPx;
            }
            return invokeCommon.intValue;
        }
    }

    public Emoticons() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init();
    }

    public static Emoticons getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (mInstance == null) {
                synchronized (Emoticons.class) {
                    if (mInstance == null) {
                        mInstance = new Emoticons();
                    }
                }
            }
            return mInstance;
        }
        return (Emoticons) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mLruCache = new LruCache<String, Bitmap>(this, ((int) Runtime.getRuntime().maxMemory()) / 16) { // from class: com.baidu.spswitch.emotion.Emoticons.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Emoticons this$0;

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

    /* JADX INFO: Access modifiers changed from: private */
    public void addBitmapToLruCache(String str, Bitmap bitmap) {
        LruCache<String, Bitmap> lruCache;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, bitmap) == null) && (lruCache = this.mLruCache) != null && bitmap != null) {
            lruCache.put(str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceSpanImage(Spannable spannable, ImageSpan imageSpan, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, this, spannable, imageSpan, bitmap) == null) {
            int spanStart = spannable.getSpanStart(imageSpan);
            int spanEnd = spannable.getSpanEnd(imageSpan);
            if (spanStart != -1 && spanEnd != -1) {
                spannable.removeSpan(imageSpan);
                spannable.setSpan(new SpanStringUtils.CenterImageSpan(AppRuntime.getAppContext(), bitmap), spanStart, spanEnd, 33);
            }
        }
    }

    private void getBitmapFromFresco(@NonNull String str, @Nullable BitmapCallback bitmapCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, str, bitmapCallback) == null) {
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build(), AppRuntime.getAppContext()).subscribe(new BaseBitmapDataSubscriber(this, str, bitmapCallback) { // from class: com.baidu.spswitch.emotion.Emoticons.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Emoticons this$0;
                public final /* synthetic */ BitmapCallback val$callback;
                public final /* synthetic */ String val$url;

                @Override // com.facebook.datasource.BaseDataSubscriber
                public void onFailureImpl(@NonNull DataSource<CloseableReference<CloseableImage>> dataSource) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dataSource) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, bitmapCallback};
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
                    this.val$url = str;
                    this.val$callback = bitmapCallback;
                }

                @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
                public void onNewResultImpl(@Nullable Bitmap bitmap) {
                    Bitmap copy;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) && bitmap != null && !bitmap.isRecycled()) {
                        try {
                            if (bitmap.getConfig() == null) {
                                copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                            } else {
                                copy = bitmap.copy(bitmap.getConfig(), true);
                            }
                            this.this$0.addBitmapToLruCache(this.val$url, copy);
                            if (this.val$callback != null) {
                                this.val$callback.processBitmap(copy);
                            }
                        } catch (OutOfMemoryError unused) {
                            System.gc();
                        }
                    }
                }
            }, UiThreadImmediateExecutorService.getInstance());
        }
    }

    private Bitmap getBitmapFromLruCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            LruCache<String, Bitmap> lruCache = this.mLruCache;
            if (lruCache != null) {
                return lruCache.get(str);
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    private void preLoadEmoticon(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, str) == null) && !TextUtils.isEmpty(str) && this.mLruCache.get(str) == null) {
            getBitmapFromFresco(str, null);
        }
    }

    private float getScaleRatio() {
        InterceptResult invokeV;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int fontSize = FontSizeConfig.getFontSize(AppRuntime.getAppContext());
            if (fontSize != 0) {
                if (fontSize != 2) {
                    if (fontSize != 3) {
                        f = 0.87f;
                    } else {
                        f = 1.1f;
                    }
                } else {
                    f = 1.0f;
                }
            } else {
                f = 0.8f;
            }
            if (DeviceUtils.ScreenInfo.getDisplayWidth(AppRuntime.getAppContext()) < 1080) {
                return f * 0.66f;
            }
            return f;
        }
        return invokeV.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap scaleImageIfNeeded(@NonNull Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, bitmap)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float scaleRatio = getScaleRatio();
            float f = width;
            if (f == f * scaleRatio) {
                float f2 = height;
                if (f2 == f2 * scaleRatio) {
                    return bitmap;
                }
            }
            Matrix matrix = new Matrix();
            matrix.postScale(scaleRatio, scaleRatio);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    @Nullable
    public String find(String str) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Matcher matcher = Pattern.compile(EMOTICONS_REGEX).matcher(str);
            while (matcher.find()) {
                try {
                    String group = matcher.group();
                    int start = matcher.start();
                    EmotionItemModel emotionTextModel = GlobalOnItemClickListenerManager.getInstance().getEmotionTextModel(group);
                    if (emotionTextModel != null && !TextUtils.isEmpty(emotionTextModel.getUrl())) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("start", start);
                        if (emotionTextModel.getText() == null) {
                            length = 0;
                        } else {
                            length = emotionTextModel.getText().length();
                        }
                        jSONObject2.put("length", length);
                        jSONObject2.put("type", 5);
                        jSONObject2.put("id", emotionTextModel.getId());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("url", emotionTextModel.getKey());
                        jSONObject3.put("text", emotionTextModel.getText());
                        jSONObject2.put(KEY_ATTR, jSONObject3);
                        jSONArray.put(jSONObject2);
                        preLoadEmoticon(emotionTextModel.getDynamicUrl());
                    }
                } catch (JSONException unused) {
                    return null;
                }
            }
            if (jSONArray.length() <= 0) {
                return null;
            }
            jSONObject.put(KEY_CONTENT_RICH, jSONArray);
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void parse(Spannable spannable, CharSequence charSequence, Context context, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, spannable, charSequence, context, map) == null) && spannable != null && charSequence != null && context != null) {
            Matcher matcher = Pattern.compile(EMOTICONS_REGEX).matcher(charSequence);
            while (matcher.find()) {
                String group = matcher.group();
                int start = matcher.start();
                int length = group.length() + start;
                EmotionItemModel emotionTextModel = GlobalOnItemClickListenerManager.getInstance().getEmotionTextModel(group);
                String str = null;
                if (emotionTextModel != null) {
                    str = emotionTextModel.getUrl();
                } else if (map != null) {
                    str = map.get(group);
                }
                if (!TextUtils.isEmpty(str)) {
                    Bitmap bitmapFromLruCache = getBitmapFromLruCache(str);
                    if (bitmapFromLruCache == null) {
                        PaddingImageSpan paddingImageSpan = new PaddingImageSpan(context, scaleImageIfNeeded(BitmapFactory.decodeResource(context.getResources(), R.drawable.emoticon_hold_img)), 8, 8);
                        spannable.setSpan(paddingImageSpan, start, length, 33);
                        getBitmapFromFresco(str, new BitmapCallback(this, spannable, paddingImageSpan) { // from class: com.baidu.spswitch.emotion.Emoticons.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Emoticons this$0;
                            public final /* synthetic */ PaddingImageSpan val$placeholderSpan;
                            public final /* synthetic */ Spannable val$spannable;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, spannable, paddingImageSpan};
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
                                this.val$spannable = spannable;
                                this.val$placeholderSpan = paddingImageSpan;
                            }

                            @Override // com.baidu.spswitch.emotion.Emoticons.BitmapCallback
                            public void processBitmap(@NonNull Bitmap bitmap) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bitmap) == null) {
                                    Emoticons emoticons = this.this$0;
                                    emoticons.replaceSpanImage(this.val$spannable, this.val$placeholderSpan, emoticons.scaleImageIfNeeded(bitmap));
                                }
                            }
                        });
                    } else {
                        spannable.setSpan(new PaddingImageSpan(context, scaleImageIfNeeded(bitmapFromLruCache), 8, 8), start, length, 33);
                    }
                }
            }
        }
    }
}
