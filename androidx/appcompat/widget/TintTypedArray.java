package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TintTypedArray {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;
    public TypedValue mTypedValue;
    public final TypedArray mWrapped;

    public TintTypedArray(Context context, TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, typedArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i, int[] iArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, context, i, iArr)) == null) {
            return new TintTypedArray(context, context.obtainStyledAttributes(i, iArr));
        }
        return (TintTypedArray) invokeLIL.objValue;
    }

    @Nullable
    public Typeface getFont(@StyleableRes int i, int i2, @Nullable ResourcesCompat.FontCallback fontCallback) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, fontCallback)) == null) {
            int resourceId = this.mWrapped.getResourceId(i, 0);
            if (resourceId == 0) {
                return null;
            }
            if (this.mTypedValue == null) {
                this.mTypedValue = new TypedValue();
            }
            return ResourcesCompat.getFont(this.mContext, resourceId, this.mTypedValue, i2, fontCallback);
        }
        return (Typeface) invokeIIL.objValue;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, attributeSet, iArr)) == null) {
            return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
        }
        return (TintTypedArray) invokeLLL.objValue;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, attributeSet, iArr, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
        }
        return (TintTypedArray) invokeCommon.objValue;
    }

    public boolean getBoolean(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return this.mWrapped.getBoolean(i, z);
        }
        return invokeCommon.booleanValue;
    }

    public int getColor(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            return this.mWrapped.getColor(i, i2);
        }
        return invokeII.intValue;
    }

    public float getDimension(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            return this.mWrapped.getDimension(i, f);
        }
        return invokeCommon.floatValue;
    }

    public int getDimensionPixelOffset(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i, i2)) == null) {
            return this.mWrapped.getDimensionPixelOffset(i, i2);
        }
        return invokeII.intValue;
    }

    public int getDimensionPixelSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            return this.mWrapped.getDimensionPixelSize(i, i2);
        }
        return invokeII.intValue;
    }

    public float getFloat(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            return this.mWrapped.getFloat(i, f);
        }
        return invokeCommon.floatValue;
    }

    public int getInt(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i, i2)) == null) {
            return this.mWrapped.getInt(i, i2);
        }
        return invokeII.intValue;
    }

    public int getInteger(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i, i2)) == null) {
            return this.mWrapped.getInteger(i, i2);
        }
        return invokeII.intValue;
    }

    public int getLayoutDimension(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i, i2)) == null) {
            return this.mWrapped.getLayoutDimension(i, i2);
        }
        return invokeII.intValue;
    }

    public int getResourceId(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i, i2)) == null) {
            return this.mWrapped.getResourceId(i, i2);
        }
        return invokeII.intValue;
    }

    public boolean getValue(int i, TypedValue typedValue) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, typedValue)) == null) {
            return this.mWrapped.getValue(i, typedValue);
        }
        return invokeIL.booleanValue;
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mWrapped.getChangingConfigurations();
        }
        return invokeV.intValue;
    }

    public int getIndexCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mWrapped.getIndexCount();
        }
        return invokeV.intValue;
    }

    public String getPositionDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mWrapped.getPositionDescription();
        }
        return (String) invokeV.objValue;
    }

    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mWrapped.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public TypedArray getWrappedTypeArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mWrapped;
        }
        return (TypedArray) invokeV.objValue;
    }

    public int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mWrapped.length();
        }
        return invokeV.intValue;
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.mWrapped.recycle();
        }
    }

    public ColorStateList getColorStateList(int i) {
        InterceptResult invokeI;
        int resourceId;
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (this.mWrapped.hasValue(i) && (resourceId = this.mWrapped.getResourceId(i, 0)) != 0 && (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) != null) {
                return colorStateList;
            }
            return this.mWrapped.getColorStateList(i);
        }
        return (ColorStateList) invokeI.objValue;
    }

    public int getType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.mWrapped.getType(i);
            }
            if (this.mTypedValue == null) {
                this.mTypedValue = new TypedValue();
            }
            this.mWrapped.getValue(i, this.mTypedValue);
            return this.mTypedValue.type;
        }
        return invokeI.intValue;
    }

    public Drawable getDrawable(int i) {
        InterceptResult invokeI;
        int resourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (this.mWrapped.hasValue(i) && (resourceId = this.mWrapped.getResourceId(i, 0)) != 0) {
                return AppCompatResources.getDrawable(this.mContext, resourceId);
            }
            return this.mWrapped.getDrawable(i);
        }
        return (Drawable) invokeI.objValue;
    }

    public Drawable getDrawableIfKnown(int i) {
        InterceptResult invokeI;
        int resourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (this.mWrapped.hasValue(i) && (resourceId = this.mWrapped.getResourceId(i, 0)) != 0) {
                return AppCompatDrawableManager.get().getDrawable(this.mContext, resourceId, true);
            }
            return null;
        }
        return (Drawable) invokeI.objValue;
    }

    public int getIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            return this.mWrapped.getIndex(i);
        }
        return invokeI.intValue;
    }

    public String getNonResourceString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            return this.mWrapped.getNonResourceString(i);
        }
        return (String) invokeI.objValue;
    }

    public String getString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            return this.mWrapped.getString(i);
        }
        return (String) invokeI.objValue;
    }

    public CharSequence getText(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            return this.mWrapped.getText(i);
        }
        return (CharSequence) invokeI.objValue;
    }

    public CharSequence[] getTextArray(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            return this.mWrapped.getTextArray(i);
        }
        return (CharSequence[]) invokeI.objValue;
    }

    public boolean hasValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            return this.mWrapped.hasValue(i);
        }
        return invokeI.booleanValue;
    }

    public TypedValue peekValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            return this.mWrapped.peekValue(i);
        }
        return (TypedValue) invokeI.objValue;
    }

    public float getFraction(int i, int i2, int i3, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f)})) == null) {
            return this.mWrapped.getFraction(i, i2, i3, f);
        }
        return invokeCommon.floatValue;
    }

    public int getLayoutDimension(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, str)) == null) {
            return this.mWrapped.getLayoutDimension(i, str);
        }
        return invokeIL.intValue;
    }
}
