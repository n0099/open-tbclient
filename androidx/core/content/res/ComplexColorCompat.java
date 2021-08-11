package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ComplexColorCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "ComplexColorCompat";
    public transient /* synthetic */ FieldHolder $fh;
    public int mColor;
    public final ColorStateList mColorStateList;
    public final Shader mShader;

    public ComplexColorCompat(Shader shader, ColorStateList colorStateList, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shader, colorStateList, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mShader = shader;
        this.mColorStateList = colorStateList;
        this.mColor = i2;
    }

    @NonNull
    public static ComplexColorCompat createFromXml(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        InterceptResult invokeLIL;
        int next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, resources, i2, theme)) == null) {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                String name = xml.getName();
                char c2 = 65535;
                int hashCode = name.hashCode();
                if (hashCode != 89650992) {
                    if (hashCode == 1191572447 && name.equals("selector")) {
                        c2 = 0;
                    }
                } else if (name.equals("gradient")) {
                    c2 = 1;
                }
                if (c2 != 0) {
                    if (c2 == 1) {
                        return from(GradientColorInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
                    }
                    throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
                }
                return from(ColorStateListInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
            }
            throw new XmlPullParserException("No start tag found");
        }
        return (ComplexColorCompat) invokeLIL.objValue;
    }

    public static ComplexColorCompat from(@NonNull Shader shader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, shader)) == null) ? new ComplexColorCompat(shader, null, 0) : (ComplexColorCompat) invokeL.objValue;
    }

    @Nullable
    public static ComplexColorCompat inflate(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, null, resources, i2, theme)) == null) {
            try {
                return createFromXml(resources, i2, theme);
            } catch (Exception unused) {
                return null;
            }
        }
        return (ComplexColorCompat) invokeLIL.objValue;
    }

    @ColorInt
    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mColor : invokeV.intValue;
    }

    @Nullable
    public Shader getShader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mShader : (Shader) invokeV.objValue;
    }

    public boolean isGradient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mShader != null : invokeV.booleanValue;
    }

    public boolean isStateful() {
        InterceptResult invokeV;
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mShader == null && (colorStateList = this.mColorStateList) != null && colorStateList.isStateful() : invokeV.booleanValue;
    }

    public boolean onStateChanged(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iArr)) == null) {
            if (isStateful()) {
                ColorStateList colorStateList = this.mColorStateList;
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (colorForState != this.mColor) {
                    this.mColor = colorForState;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mColor = i2;
        }
    }

    public boolean willDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? isGradient() || this.mColor != 0 : invokeV.booleanValue;
    }

    public static ComplexColorCompat from(@NonNull ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, colorStateList)) == null) ? new ComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor()) : (ComplexColorCompat) invokeL.objValue;
    }

    public static ComplexColorCompat from(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? new ComplexColorCompat(null, null, i2) : (ComplexColorCompat) invokeI.objValue;
    }
}
