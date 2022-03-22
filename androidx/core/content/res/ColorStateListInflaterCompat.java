package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.R$attr;
import androidx.core.R$styleable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ColorStateListInflaterCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ColorStateListInflaterCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static ColorStateList createFromXml(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        InterceptResult invokeLLL;
        int next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, resources, xmlPullParser, theme)) == null) {
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
        return (ColorStateList) invokeLLL.objValue;
    }

    @NonNull
    public static ColorStateList createFromXmlInner(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, resources, xmlPullParser, attributeSet, theme)) == null) {
            String name = xmlPullParser.getName();
            if (name.equals("selector")) {
                return inflate(resources, xmlPullParser, attributeSet, theme);
            }
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
        }
        return (ColorStateList) invokeLLLL.objValue;
    }

    @Nullable
    public static ColorStateList inflate(@NonNull Resources resources, @XmlRes int i, @Nullable Resources.Theme theme) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, resources, i, theme)) == null) {
            try {
                return createFromXml(resources, resources.getXml(i), theme);
            } catch (Exception e2) {
                Log.e("CSLCompat", "Failed to inflate ColorStateList.", e2);
                return null;
            }
        }
        return (ColorStateList) invokeLIL.objValue;
    }

    @ColorInt
    public static int modulateColorAlpha(@ColorInt int i, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), Float.valueOf(f2)})) == null) ? (i & 16777215) | (Math.round(Color.alpha(i) * f2) << 24) : invokeCommon.intValue;
    }

    public static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, resources, theme, attributeSet, iArr)) == null) {
            if (theme == null) {
                return resources.obtainAttributes(attributeSet, iArr);
            }
            return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        }
        return (TypedArray) invokeLLLL.objValue;
    }

    public static ColorStateList inflate(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        InterceptResult invokeLLLL;
        int depth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, resources, xmlPullParser, attributeSet, theme)) == null) {
            int i = 1;
            int depth2 = xmlPullParser.getDepth() + 1;
            int[][] iArr = new int[20];
            int[] iArr2 = new int[20];
            int i2 = 0;
            while (true) {
                int next = xmlPullParser.next();
                if (next == i || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                    break;
                }
                if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                    TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R$styleable.ColorStateListItem);
                    int color = obtainAttributes.getColor(R$styleable.ColorStateListItem_android_color, -65281);
                    float f2 = 1.0f;
                    if (obtainAttributes.hasValue(R$styleable.ColorStateListItem_android_alpha)) {
                        f2 = obtainAttributes.getFloat(R$styleable.ColorStateListItem_android_alpha, 1.0f);
                    } else if (obtainAttributes.hasValue(R$styleable.ColorStateListItem_alpha)) {
                        f2 = obtainAttributes.getFloat(R$styleable.ColorStateListItem_alpha, 1.0f);
                    }
                    obtainAttributes.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr3 = new int[attributeCount];
                    int i3 = 0;
                    for (int i4 = 0; i4 < attributeCount; i4++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                        if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R$attr.alpha) {
                            int i5 = i3 + 1;
                            if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr3[i3] = attributeNameResource;
                            i3 = i5;
                        }
                    }
                    int[] trimStateSet = StateSet.trimStateSet(iArr3, i3);
                    iArr2 = GrowingArrayUtils.append(iArr2, i2, modulateColorAlpha(color, f2));
                    iArr = (int[][]) GrowingArrayUtils.append(iArr, i2, trimStateSet);
                    i2++;
                }
                i = 1;
            }
            int[] iArr4 = new int[i2];
            int[][] iArr5 = new int[i2];
            System.arraycopy(iArr2, 0, iArr4, 0, i2);
            System.arraycopy(iArr, 0, iArr5, 0, i2);
            return new ColorStateList(iArr5, iArr4);
        }
        return (ColorStateList) invokeLLLL.objValue;
    }
}
