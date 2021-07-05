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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, attributeSet, iArr)) == null) ? new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr)) : (TintTypedArray) invokeLLL.objValue;
    }

    public boolean getBoolean(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? this.mWrapped.getBoolean(i2, z) : invokeCommon.booleanValue;
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mWrapped.getChangingConfigurations() : invokeV.intValue;
    }

    public int getColor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) ? this.mWrapped.getColor(i2, i3) : invokeII.intValue;
    }

    public ColorStateList getColorStateList(int i2) {
        InterceptResult invokeI;
        int resourceId;
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? (!this.mWrapped.hasValue(i2) || (resourceId = this.mWrapped.getResourceId(i2, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) == null) ? this.mWrapped.getColorStateList(i2) : colorStateList : (ColorStateList) invokeI.objValue;
    }

    public float getDimension(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? this.mWrapped.getDimension(i2, f2) : invokeCommon.floatValue;
    }

    public int getDimensionPixelOffset(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) ? this.mWrapped.getDimensionPixelOffset(i2, i3) : invokeII.intValue;
    }

    public int getDimensionPixelSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) ? this.mWrapped.getDimensionPixelSize(i2, i3) : invokeII.intValue;
    }

    public Drawable getDrawable(int i2) {
        InterceptResult invokeI;
        int resourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (this.mWrapped.hasValue(i2) && (resourceId = this.mWrapped.getResourceId(i2, 0)) != 0) {
                return AppCompatResources.getDrawable(this.mContext, resourceId);
            }
            return this.mWrapped.getDrawable(i2);
        }
        return (Drawable) invokeI.objValue;
    }

    public Drawable getDrawableIfKnown(int i2) {
        InterceptResult invokeI;
        int resourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (!this.mWrapped.hasValue(i2) || (resourceId = this.mWrapped.getResourceId(i2, 0)) == 0) {
                return null;
            }
            return AppCompatDrawableManager.get().getDrawable(this.mContext, resourceId, true);
        }
        return (Drawable) invokeI.objValue;
    }

    public float getFloat(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? this.mWrapped.getFloat(i2, f2) : invokeCommon.floatValue;
    }

    @Nullable
    public Typeface getFont(@StyleableRes int i2, int i3, @Nullable ResourcesCompat.FontCallback fontCallback) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, fontCallback)) == null) {
            int resourceId = this.mWrapped.getResourceId(i2, 0);
            if (resourceId == 0) {
                return null;
            }
            if (this.mTypedValue == null) {
                this.mTypedValue = new TypedValue();
            }
            return ResourcesCompat.getFont(this.mContext, resourceId, this.mTypedValue, i3, fontCallback);
        }
        return (Typeface) invokeIIL.objValue;
    }

    public float getFraction(int i2, int i3, int i4, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)})) == null) ? this.mWrapped.getFraction(i2, i3, i4, f2) : invokeCommon.floatValue;
    }

    public int getIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? this.mWrapped.getIndex(i2) : invokeI.intValue;
    }

    public int getIndexCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mWrapped.getIndexCount() : invokeV.intValue;
    }

    public int getInt(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i2, i3)) == null) ? this.mWrapped.getInt(i2, i3) : invokeII.intValue;
    }

    public int getInteger(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i2, i3)) == null) ? this.mWrapped.getInteger(i2, i3) : invokeII.intValue;
    }

    public int getLayoutDimension(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i2, str)) == null) ? this.mWrapped.getLayoutDimension(i2, str) : invokeIL.intValue;
    }

    public String getNonResourceString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) ? this.mWrapped.getNonResourceString(i2) : (String) invokeI.objValue;
    }

    public String getPositionDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mWrapped.getPositionDescription() : (String) invokeV.objValue;
    }

    public int getResourceId(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) ? this.mWrapped.getResourceId(i2, i3) : invokeII.intValue;
    }

    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mWrapped.getResources() : (Resources) invokeV.objValue;
    }

    public String getString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? this.mWrapped.getString(i2) : (String) invokeI.objValue;
    }

    public CharSequence getText(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? this.mWrapped.getText(i2) : (CharSequence) invokeI.objValue;
    }

    public CharSequence[] getTextArray(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) ? this.mWrapped.getTextArray(i2) : (CharSequence[]) invokeI.objValue;
    }

    public int getType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.mWrapped.getType(i2);
            }
            if (this.mTypedValue == null) {
                this.mTypedValue = new TypedValue();
            }
            this.mWrapped.getValue(i2, this.mTypedValue);
            return this.mTypedValue.type;
        }
        return invokeI.intValue;
    }

    public boolean getValue(int i2, TypedValue typedValue) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i2, typedValue)) == null) ? this.mWrapped.getValue(i2, typedValue) : invokeIL.booleanValue;
    }

    public TypedArray getWrappedTypeArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mWrapped : (TypedArray) invokeV.objValue;
    }

    public boolean hasValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? this.mWrapped.hasValue(i2) : invokeI.booleanValue;
    }

    public int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mWrapped.length() : invokeV.intValue;
    }

    public TypedValue peekValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) ? this.mWrapped.peekValue(i2) : (TypedValue) invokeI.objValue;
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.mWrapped.recycle();
        }
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, attributeSet, iArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3)) : (TintTypedArray) invokeCommon.objValue;
    }

    public int getLayoutDimension(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i2, i3)) == null) ? this.mWrapped.getLayoutDimension(i2, i3) : invokeII.intValue;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i2, int[] iArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, context, i2, iArr)) == null) ? new TintTypedArray(context, context.obtainStyledAttributes(i2, iArr)) : (TintTypedArray) invokeLIL.objValue;
    }
}
