package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class ArcMotion extends PathMotion {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    public static final float DEFAULT_MAX_TANGENT;
    public static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public float mMaximumAngle;
    public float mMaximumTangent;
    public float mMinimumHorizontalAngle;
    public float mMinimumHorizontalTangent;
    public float mMinimumVerticalAngle;
    public float mMinimumVerticalTangent;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(264832851, "Landroidx/transition/ArcMotion;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(264832851, "Landroidx/transition/ArcMotion;");
                return;
            }
        }
        DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    }

    public ArcMotion() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = 70.0f;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }

    public static float toTangent(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f2)) == null) {
            if (f2 >= 0.0f && f2 <= 90.0f) {
                return (float) Math.tan(Math.toRadians(f2 / 2.0f));
            }
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return invokeF.floatValue;
    }

    public float getMaximumAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mMaximumAngle : invokeV.floatValue;
    }

    public float getMinimumHorizontalAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMinimumHorizontalAngle : invokeV.floatValue;
    }

    public float getMinimumVerticalAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMinimumVerticalAngle : invokeV.floatValue;
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        float f6;
        float f7;
        float f8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            Path path = new Path();
            path.moveTo(f2, f3);
            float f9 = f4 - f2;
            float f10 = f5 - f3;
            float f11 = (f9 * f9) + (f10 * f10);
            float f12 = (f2 + f4) / 2.0f;
            float f13 = (f3 + f5) / 2.0f;
            float f14 = 0.25f * f11;
            boolean z = f3 > f5;
            if (Math.abs(f9) < Math.abs(f10)) {
                float abs = Math.abs(f11 / (f10 * 2.0f));
                if (z) {
                    f7 = abs + f5;
                    f6 = f4;
                } else {
                    f7 = abs + f3;
                    f6 = f2;
                }
                f8 = this.mMinimumVerticalTangent;
            } else {
                float f15 = f11 / (f9 * 2.0f);
                if (z) {
                    f7 = f3;
                    f6 = f15 + f2;
                } else {
                    f6 = f4 - f15;
                    f7 = f5;
                }
                f8 = this.mMinimumHorizontalTangent;
            }
            float f16 = f14 * f8 * f8;
            float f17 = f12 - f6;
            float f18 = f13 - f7;
            float f19 = (f17 * f17) + (f18 * f18);
            float f20 = this.mMaximumTangent;
            float f21 = f14 * f20 * f20;
            if (f19 >= f16) {
                f16 = f19 > f21 ? f21 : 0.0f;
            }
            if (f16 != 0.0f) {
                float sqrt = (float) Math.sqrt(f16 / f19);
                f6 = ((f6 - f12) * sqrt) + f12;
                f7 = f13 + (sqrt * (f7 - f13));
            }
            path.cubicTo((f2 + f6) / 2.0f, (f3 + f7) / 2.0f, (f6 + f4) / 2.0f, (f7 + f5) / 2.0f, f4, f5);
            return path;
        }
        return (Path) invokeCommon.objValue;
    }

    public void setMaximumAngle(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.mMaximumAngle = f2;
            this.mMaximumTangent = toTangent(f2);
        }
    }

    public void setMinimumHorizontalAngle(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.mMinimumHorizontalAngle = f2;
            this.mMinimumHorizontalTangent = toTangent(f2);
        }
    }

    public void setMinimumVerticalAngle(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.mMinimumVerticalAngle = f2;
            this.mMinimumVerticalTangent = toTangent(f2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = 70.0f;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        obtainStyledAttributes.recycle();
    }
}
