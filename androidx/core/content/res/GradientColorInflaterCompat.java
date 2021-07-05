package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class GradientColorInflaterCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TILE_MODE_CLAMP = 0;
    public static final int TILE_MODE_MIRROR = 2;
    public static final int TILE_MODE_REPEAT = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public GradientColorInflaterCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ColorStops checkColors(@Nullable ColorStops colorStops, @ColorInt int i2, @ColorInt int i3, boolean z, @ColorInt int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{colorStops, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)})) == null) {
            if (colorStops != null) {
                return colorStops;
            }
            if (z) {
                return new ColorStops(i2, i4, i3);
            }
            return new ColorStops(i2, i3);
        }
        return (ColorStops) invokeCommon.objValue;
    }

    public static Shader createFromXml(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        InterceptResult invokeLLL;
        int next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, resources, xmlPullParser, theme)) == null) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            do {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        }
        return (Shader) invokeLLL.objValue;
    }

    public static Shader createFromXmlInner(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, resources, xmlPullParser, attributeSet, theme)) == null) {
            String name = xmlPullParser.getName();
            if (name.equals("gradient")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.GradientColor);
                float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "startX", R.styleable.GradientColor_android_startX, 0.0f);
                float namedFloat2 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "startY", R.styleable.GradientColor_android_startY, 0.0f);
                float namedFloat3 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "endX", R.styleable.GradientColor_android_endX, 0.0f);
                float namedFloat4 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "endY", R.styleable.GradientColor_android_endY, 0.0f);
                float namedFloat5 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
                float namedFloat6 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
                int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "type", R.styleable.GradientColor_android_type, 0);
                int namedColor = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "startColor", R.styleable.GradientColor_android_startColor, 0);
                boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "centerColor");
                int namedColor2 = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
                int namedColor3 = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "endColor", R.styleable.GradientColor_android_endColor, 0);
                int namedInt2 = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
                float namedFloat7 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
                obtainAttributes.recycle();
                ColorStops checkColors = checkColors(inflateChildElements(resources, xmlPullParser, attributeSet, theme), namedColor, namedColor3, hasAttribute, namedColor2);
                if (namedInt != 1) {
                    if (namedInt != 2) {
                        return new LinearGradient(namedFloat, namedFloat2, namedFloat3, namedFloat4, checkColors.mColors, checkColors.mOffsets, parseTileMode(namedInt2));
                    }
                    return new SweepGradient(namedFloat5, namedFloat6, checkColors.mColors, checkColors.mOffsets);
                } else if (namedFloat7 > 0.0f) {
                    return new RadialGradient(namedFloat5, namedFloat6, namedFloat7, checkColors.mColors, checkColors.mOffsets, parseTileMode(namedInt2));
                } else {
                    throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                }
            }
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        return (Shader) invokeLLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0088, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ColorStops inflateChildElements(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        InterceptResult invokeLLLL;
        int depth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65540, null, resources, xmlPullParser, attributeSet, theme)) == null) {
            int depth2 = xmlPullParser.getDepth() + 1;
            ArrayList arrayList = new ArrayList(20);
            ArrayList arrayList2 = new ArrayList(20);
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                    break;
                } else if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.GradientColorItem);
                    boolean hasValue = obtainAttributes.hasValue(R.styleable.GradientColorItem_android_color);
                    boolean hasValue2 = obtainAttributes.hasValue(R.styleable.GradientColorItem_android_offset);
                    if (!hasValue || !hasValue2) {
                        break;
                    }
                    int color = obtainAttributes.getColor(R.styleable.GradientColorItem_android_color, 0);
                    float f2 = obtainAttributes.getFloat(R.styleable.GradientColorItem_android_offset, 0.0f);
                    obtainAttributes.recycle();
                    arrayList2.add(Integer.valueOf(color));
                    arrayList.add(Float.valueOf(f2));
                }
            }
            if (arrayList2.size() > 0) {
                return new ColorStops(arrayList2, arrayList);
            }
            return null;
        }
        return (ColorStops) invokeLLLL.objValue;
    }

    public static Shader.TileMode parseTileMode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return Shader.TileMode.CLAMP;
                }
                return Shader.TileMode.MIRROR;
            }
            return Shader.TileMode.REPEAT;
        }
        return (Shader.TileMode) invokeI.objValue;
    }

    /* loaded from: classes.dex */
    public static final class ColorStops {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] mColors;
        public final float[] mOffsets;

        public ColorStops(@NonNull List<Integer> list, @NonNull List<Float> list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, list2};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            int size = list.size();
            this.mColors = new int[size];
            this.mOffsets = new float[size];
            for (int i4 = 0; i4 < size; i4++) {
                this.mColors[i4] = list.get(i4).intValue();
                this.mOffsets[i4] = list2.get(i4).floatValue();
            }
        }

        public ColorStops(@ColorInt int i2, @ColorInt int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mColors = new int[]{i2, i3};
            this.mOffsets = new float[]{0.0f, 1.0f};
        }

        public ColorStops(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mColors = new int[]{i2, i3, i4};
            this.mOffsets = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
