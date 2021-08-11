package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public class TextLayer extends BaseLayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LongSparseArray<String> codePointCache;
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> colorCallbackAnimation;
    public final LottieComposition composition;
    public final Map<FontCharacter, List<ContentGroup>> contentsForCharacter;
    public final Paint fillPaint;
    public final LottieDrawable lottieDrawable;
    public final Matrix matrix;
    public final RectF rectF;
    public final StringBuilder stringBuilder;
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> strokeColorCallbackAnimation;
    public final Paint strokePaint;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> strokeWidthCallbackAnimation;
    public final TextKeyframeAnimation textAnimation;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> textSizeAnimation;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> textSizeCallbackAnimation;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> trackingAnimation;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> trackingCallbackAnimation;

    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-268842061, "Lcom/airbnb/lottie/model/layer/TextLayer$3;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-268842061, "Lcom/airbnb/lottie/model/layer/TextLayer$3;");
                    return;
                }
            }
            int[] iArr = new int[DocumentData.Justification.values().length];
            $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableColorValue animatableColorValue;
        AnimatableColorValue animatableColorValue2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lottieDrawable, layer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((LottieDrawable) objArr2[0], (Layer) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.stringBuilder = new StringBuilder(2);
        this.rectF = new RectF();
        this.matrix = new Matrix();
        this.fillPaint = new Paint(this, 1) { // from class: com.airbnb.lottie.model.layer.TextLayer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextLayer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(this, 1) { // from class: com.airbnb.lottie.model.layer.TextLayer.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextLayer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                setStyle(Paint.Style.STROKE);
            }
        };
        this.contentsForCharacter = new HashMap();
        this.codePointCache = new LongSparseArray<>();
        this.lottieDrawable = lottieDrawable;
        this.composition = layer.getComposition();
        TextKeyframeAnimation createAnimation = layer.getText().createAnimation();
        this.textAnimation = createAnimation;
        createAnimation.addUpdateListener(this);
        addAnimation(this.textAnimation);
        AnimatableTextProperties textProperties = layer.getTextProperties();
        if (textProperties != null && (animatableColorValue2 = textProperties.color) != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation2 = animatableColorValue2.createAnimation();
            this.colorAnimation = createAnimation2;
            createAnimation2.addUpdateListener(this);
            addAnimation(this.colorAnimation);
        }
        if (textProperties != null && (animatableColorValue = textProperties.stroke) != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation3 = animatableColorValue.createAnimation();
            this.strokeColorAnimation = createAnimation3;
            createAnimation3.addUpdateListener(this);
            addAnimation(this.strokeColorAnimation);
        }
        if (textProperties != null && (animatableFloatValue2 = textProperties.strokeWidth) != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation4 = animatableFloatValue2.createAnimation();
            this.strokeWidthAnimation = createAnimation4;
            createAnimation4.addUpdateListener(this);
            addAnimation(this.strokeWidthAnimation);
        }
        if (textProperties == null || (animatableFloatValue = textProperties.tracking) == null) {
            return;
        }
        BaseKeyframeAnimation<Float, Float> createAnimation5 = animatableFloatValue.createAnimation();
        this.trackingAnimation = createAnimation5;
        createAnimation5.addUpdateListener(this);
        addAnimation(this.trackingAnimation);
    }

    private void applyJustification(DocumentData.Justification justification, Canvas canvas, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{justification, canvas, Float.valueOf(f2)}) == null) {
            int i2 = AnonymousClass3.$SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[justification.ordinal()];
            if (i2 == 2) {
                canvas.translate(-f2, 0.0f);
            } else if (i2 != 3) {
            } else {
                canvas.translate((-f2) / 2.0f, 0.0f);
            }
        }
    }

    private String codePointToString(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, str, i2)) == null) {
            int codePointAt = str.codePointAt(i2);
            int charCount = Character.charCount(codePointAt) + i2;
            while (charCount < str.length()) {
                int codePointAt2 = str.codePointAt(charCount);
                if (!isModifier(codePointAt2)) {
                    break;
                }
                charCount += Character.charCount(codePointAt2);
                codePointAt = (codePointAt * 31) + codePointAt2;
            }
            long j2 = codePointAt;
            if (this.codePointCache.containsKey(j2)) {
                return this.codePointCache.get(j2);
            }
            this.stringBuilder.setLength(0);
            while (i2 < charCount) {
                int codePointAt3 = str.codePointAt(i2);
                this.stringBuilder.appendCodePoint(codePointAt3);
                i2 += Character.charCount(codePointAt3);
            }
            String sb = this.stringBuilder.toString();
            this.codePointCache.put(j2, sb);
            return sb;
        }
        return (String) invokeLI.objValue;
    }

    private void drawCharacter(String str, Paint paint, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, this, str, paint, canvas) == null) || paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void drawCharacterAsGlyph(FontCharacter fontCharacter, Matrix matrix, float f2, DocumentData documentData, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{fontCharacter, matrix, Float.valueOf(f2), documentData, canvas}) == null) {
            List<ContentGroup> contentsForCharacter = getContentsForCharacter(fontCharacter);
            for (int i2 = 0; i2 < contentsForCharacter.size(); i2++) {
                Path path = contentsForCharacter.get(i2).getPath();
                path.computeBounds(this.rectF, false);
                this.matrix.set(matrix);
                this.matrix.preTranslate(0.0f, (-documentData.baselineShift) * Utils.dpScale());
                this.matrix.preScale(f2, f2);
                path.transform(this.matrix);
                if (documentData.strokeOverFill) {
                    drawGlyph(path, this.fillPaint, canvas);
                    drawGlyph(path, this.strokePaint, canvas);
                } else {
                    drawGlyph(path, this.strokePaint, canvas);
                    drawGlyph(path, this.fillPaint, canvas);
                }
            }
        }
    }

    private void drawCharacterFromFont(String str, DocumentData documentData, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, str, documentData, canvas) == null) {
            if (documentData.strokeOverFill) {
                drawCharacter(str, this.fillPaint, canvas);
                drawCharacter(str, this.strokePaint, canvas);
                return;
            }
            drawCharacter(str, this.strokePaint, canvas);
            drawCharacter(str, this.fillPaint, canvas);
        }
    }

    private void drawFontTextLine(String str, DocumentData documentData, Canvas canvas, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, documentData, canvas, Float.valueOf(f2)}) == null) {
            int i2 = 0;
            while (i2 < str.length()) {
                String codePointToString = codePointToString(str, i2);
                i2 += codePointToString.length();
                drawCharacterFromFont(codePointToString, documentData, canvas);
                canvas.translate(this.fillPaint.measureText(codePointToString) + f2, 0.0f);
            }
        }
    }

    private void drawGlyph(Path path, Paint paint, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, this, path, paint, canvas) == null) || paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void drawGlyphTextLine(String str, DocumentData documentData, Matrix matrix, Font font, Canvas canvas, float f2, float f3) {
        float floatValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{str, documentData, matrix, font, canvas, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                FontCharacter fontCharacter = this.composition.getCharacters().get(FontCharacter.hashFor(str.charAt(i2), font.getFamily(), font.getStyle()));
                if (fontCharacter != null) {
                    drawCharacterAsGlyph(fontCharacter, matrix, f3, documentData, canvas);
                    float width = ((float) fontCharacter.getWidth()) * f3 * Utils.dpScale() * f2;
                    float f4 = documentData.tracking / 10.0f;
                    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingCallbackAnimation;
                    if (baseKeyframeAnimation != null) {
                        floatValue = baseKeyframeAnimation.getValue().floatValue();
                    } else {
                        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.trackingAnimation;
                        if (baseKeyframeAnimation2 != null) {
                            floatValue = baseKeyframeAnimation2.getValue().floatValue();
                        }
                        canvas.translate(width + (f4 * f2), 0.0f);
                    }
                    f4 += floatValue;
                    canvas.translate(width + (f4 * f2), 0.0f);
                }
            }
        }
    }

    private void drawTextGlyphs(DocumentData documentData, Matrix matrix, Font font, Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, this, documentData, matrix, font, canvas) == null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.textSizeCallbackAnimation;
            if (baseKeyframeAnimation != null) {
                f2 = baseKeyframeAnimation.getValue().floatValue();
            } else {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.textSizeAnimation;
                if (baseKeyframeAnimation2 != null) {
                    f2 = baseKeyframeAnimation2.getValue().floatValue();
                } else {
                    f2 = documentData.size;
                }
            }
            float f3 = f2 / 100.0f;
            float scale = Utils.getScale(matrix);
            String str = documentData.text;
            float dpScale = documentData.lineHeight * Utils.dpScale();
            List<String> textLines = getTextLines(str);
            int size = textLines.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = textLines.get(i2);
                float textLineWidthForGlyphs = getTextLineWidthForGlyphs(str2, font, f3, scale);
                canvas.save();
                applyJustification(documentData.justification, canvas, textLineWidthForGlyphs);
                canvas.translate(0.0f, (i2 * dpScale) - (((size - 1) * dpScale) / 2.0f));
                drawGlyphTextLine(str2, documentData, matrix, font, canvas, scale, f3);
                canvas.restore();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00af A[LOOP:0: B:25:0x00ad->B:26:0x00af, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drawTextWithFont(DocumentData documentData, Font font, Matrix matrix, Canvas canvas) {
        float f2;
        float floatValue;
        int size;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, this, documentData, font, matrix, canvas) == null) {
            Utils.getScale(matrix);
            Typeface typeface = this.lottieDrawable.getTypeface(font.getFamily(), font.getStyle());
            if (typeface == null) {
                return;
            }
            String str = documentData.text;
            TextDelegate textDelegate = this.lottieDrawable.getTextDelegate();
            if (textDelegate != null) {
                str = textDelegate.getTextInternal(str);
            }
            this.fillPaint.setTypeface(typeface);
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.textSizeCallbackAnimation;
            if (baseKeyframeAnimation != null) {
                f2 = baseKeyframeAnimation.getValue().floatValue();
            } else {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.textSizeAnimation;
                if (baseKeyframeAnimation2 != null) {
                    f2 = baseKeyframeAnimation2.getValue().floatValue();
                } else {
                    f2 = documentData.size;
                }
            }
            this.fillPaint.setTextSize(Utils.dpScale() * f2);
            this.strokePaint.setTypeface(this.fillPaint.getTypeface());
            this.strokePaint.setTextSize(this.fillPaint.getTextSize());
            float dpScale = documentData.lineHeight * Utils.dpScale();
            float f3 = documentData.tracking / 10.0f;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.trackingCallbackAnimation;
            if (baseKeyframeAnimation3 != null) {
                floatValue = baseKeyframeAnimation3.getValue().floatValue();
            } else {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.trackingAnimation;
                if (baseKeyframeAnimation4 != null) {
                    floatValue = baseKeyframeAnimation4.getValue().floatValue();
                }
                float dpScale2 = ((f3 * Utils.dpScale()) * f2) / 100.0f;
                List<String> textLines = getTextLines(str);
                size = textLines.size();
                for (i2 = 0; i2 < size; i2++) {
                    String str2 = textLines.get(i2);
                    float measureText = this.strokePaint.measureText(str2) + ((str2.length() - 1) * dpScale2);
                    canvas.save();
                    applyJustification(documentData.justification, canvas, measureText);
                    canvas.translate(0.0f, (i2 * dpScale) - (((size - 1) * dpScale) / 2.0f));
                    drawFontTextLine(str2, documentData, canvas, dpScale2);
                    canvas.restore();
                }
            }
            f3 += floatValue;
            float dpScale22 = ((f3 * Utils.dpScale()) * f2) / 100.0f;
            List<String> textLines2 = getTextLines(str);
            size = textLines2.size();
            while (i2 < size) {
            }
        }
    }

    private List<ContentGroup> getContentsForCharacter(FontCharacter fontCharacter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, fontCharacter)) == null) {
            if (this.contentsForCharacter.containsKey(fontCharacter)) {
                return this.contentsForCharacter.get(fontCharacter);
            }
            List<ShapeGroup> shapes = fontCharacter.getShapes();
            int size = shapes.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new ContentGroup(this.lottieDrawable, this, shapes.get(i2)));
            }
            this.contentsForCharacter.put(fontCharacter, arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private float getTextLineWidthForGlyphs(String str, Font font, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{str, font, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = 0.0f;
            for (int i2 = 0; i2 < str.length(); i2++) {
                FontCharacter fontCharacter = this.composition.getCharacters().get(FontCharacter.hashFor(str.charAt(i2), font.getFamily(), font.getStyle()));
                if (fontCharacter != null) {
                    f4 = (float) (f4 + (fontCharacter.getWidth() * f2 * Utils.dpScale() * f3));
                }
            }
            return f4;
        }
        return invokeCommon.floatValue;
    }

    private List<String> getTextLines(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) ? Arrays.asList(str.replaceAll(Part.CRLF, StringUtils.CR).replaceAll(StringUtils.LF, StringUtils.CR).split(StringUtils.CR)) : (List) invokeL.objValue;
    }

    private boolean isModifier(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65550, this, i2)) == null) ? Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 19 : invokeI.booleanValue;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, t, lottieValueCallback) == null) {
            super.addValueCallback(t, lottieValueCallback);
            if (t == LottieProperty.COLOR) {
                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorCallbackAnimation;
                if (baseKeyframeAnimation != null) {
                    removeAnimation(baseKeyframeAnimation);
                }
                if (lottieValueCallback == null) {
                    this.colorCallbackAnimation = null;
                    return;
                }
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                this.colorCallbackAnimation = valueCallbackKeyframeAnimation;
                valueCallbackKeyframeAnimation.addUpdateListener(this);
                addAnimation(this.colorCallbackAnimation);
            } else if (t == LottieProperty.STROKE_COLOR) {
                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.strokeColorCallbackAnimation;
                if (baseKeyframeAnimation2 != null) {
                    removeAnimation(baseKeyframeAnimation2);
                }
                if (lottieValueCallback == null) {
                    this.strokeColorCallbackAnimation = null;
                    return;
                }
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                this.strokeColorCallbackAnimation = valueCallbackKeyframeAnimation2;
                valueCallbackKeyframeAnimation2.addUpdateListener(this);
                addAnimation(this.strokeColorCallbackAnimation);
            } else if (t == LottieProperty.STROKE_WIDTH) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.strokeWidthCallbackAnimation;
                if (baseKeyframeAnimation3 != null) {
                    removeAnimation(baseKeyframeAnimation3);
                }
                if (lottieValueCallback == null) {
                    this.strokeWidthCallbackAnimation = null;
                    return;
                }
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                this.strokeWidthCallbackAnimation = valueCallbackKeyframeAnimation3;
                valueCallbackKeyframeAnimation3.addUpdateListener(this);
                addAnimation(this.strokeWidthCallbackAnimation);
            } else if (t == LottieProperty.TEXT_TRACKING) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.trackingCallbackAnimation;
                if (baseKeyframeAnimation4 != null) {
                    removeAnimation(baseKeyframeAnimation4);
                }
                if (lottieValueCallback == null) {
                    this.trackingCallbackAnimation = null;
                    return;
                }
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                this.trackingCallbackAnimation = valueCallbackKeyframeAnimation4;
                valueCallbackKeyframeAnimation4.addUpdateListener(this);
                addAnimation(this.trackingCallbackAnimation);
            } else if (t == LottieProperty.TEXT_SIZE) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.textSizeCallbackAnimation;
                if (baseKeyframeAnimation5 != null) {
                    removeAnimation(baseKeyframeAnimation5);
                }
                if (lottieValueCallback == null) {
                    this.textSizeCallbackAnimation = null;
                    return;
                }
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                this.textSizeCallbackAnimation = valueCallbackKeyframeAnimation5;
                valueCallbackKeyframeAnimation5.addUpdateListener(this);
                addAnimation(this.textSizeCallbackAnimation);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) {
            canvas.save();
            if (!this.lottieDrawable.useTextGlyphs()) {
                canvas.concat(matrix);
            }
            DocumentData value = this.textAnimation.getValue();
            Font font = this.composition.getFonts().get(value.fontName);
            if (font == null) {
                canvas.restore();
                return;
            }
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorCallbackAnimation;
            if (baseKeyframeAnimation != null) {
                this.fillPaint.setColor(baseKeyframeAnimation.getValue().intValue());
            } else {
                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.colorAnimation;
                if (baseKeyframeAnimation2 != null) {
                    this.fillPaint.setColor(baseKeyframeAnimation2.getValue().intValue());
                } else {
                    this.fillPaint.setColor(value.color);
                }
            }
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.strokeColorCallbackAnimation;
            if (baseKeyframeAnimation3 != null) {
                this.strokePaint.setColor(baseKeyframeAnimation3.getValue().intValue());
            } else {
                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.strokeColorAnimation;
                if (baseKeyframeAnimation4 != null) {
                    this.strokePaint.setColor(baseKeyframeAnimation4.getValue().intValue());
                } else {
                    this.strokePaint.setColor(value.strokeColor);
                }
            }
            int intValue = ((this.transform.getOpacity() == null ? 100 : this.transform.getOpacity().getValue().intValue()) * 255) / 100;
            this.fillPaint.setAlpha(intValue);
            this.strokePaint.setAlpha(intValue);
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.strokeWidthCallbackAnimation;
            if (baseKeyframeAnimation5 != null) {
                this.strokePaint.setStrokeWidth(baseKeyframeAnimation5.getValue().floatValue());
            } else {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.strokeWidthAnimation;
                if (baseKeyframeAnimation6 != null) {
                    this.strokePaint.setStrokeWidth(baseKeyframeAnimation6.getValue().floatValue());
                } else {
                    this.strokePaint.setStrokeWidth(value.strokeWidth * Utils.dpScale() * Utils.getScale(matrix));
                }
            }
            if (this.lottieDrawable.useTextGlyphs()) {
                drawTextGlyphs(value, matrix, font, canvas);
            } else {
                drawTextWithFont(value, font, matrix, canvas);
            }
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, rectF, matrix, z) == null) {
            super.getBounds(rectF, matrix, z);
            rectF.set(0.0f, 0.0f, this.composition.getBounds().width(), this.composition.getBounds().height());
        }
    }
}
