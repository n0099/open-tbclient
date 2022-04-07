package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class AccessibilityRecordCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AccessibilityRecord mRecord;

    @Deprecated
    public AccessibilityRecordCompat(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRecord = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat accessibilityRecordCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, accessibilityRecordCompat)) == null) ? new AccessibilityRecordCompat(AccessibilityRecord.obtain(accessibilityRecordCompat.mRecord)) : (AccessibilityRecordCompat) invokeL.objValue;
    }

    @Deprecated
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AccessibilityRecordCompat) {
                AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
                AccessibilityRecord accessibilityRecord = this.mRecord;
                if (accessibilityRecord == null) {
                    if (accessibilityRecordCompat.mRecord != null) {
                        return false;
                    }
                } else if (!accessibilityRecord.equals(accessibilityRecordCompat.mRecord)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public int getAddedCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRecord.getAddedCount() : invokeV.intValue;
    }

    @Deprecated
    public CharSequence getBeforeText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRecord.getBeforeText() : (CharSequence) invokeV.objValue;
    }

    @Deprecated
    public CharSequence getClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRecord.getClassName() : (CharSequence) invokeV.objValue;
    }

    @Deprecated
    public CharSequence getContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRecord.getContentDescription() : (CharSequence) invokeV.objValue;
    }

    @Deprecated
    public int getCurrentItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRecord.getCurrentItemIndex() : invokeV.intValue;
    }

    @Deprecated
    public int getFromIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mRecord.getFromIndex() : invokeV.intValue;
    }

    @Deprecated
    public Object getImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mRecord : invokeV.objValue;
    }

    @Deprecated
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mRecord.getItemCount() : invokeV.intValue;
    }

    @Deprecated
    public int getMaxScrollX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getMaxScrollX(this.mRecord) : invokeV.intValue;
    }

    @Deprecated
    public int getMaxScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getMaxScrollY(this.mRecord) : invokeV.intValue;
    }

    @Deprecated
    public Parcelable getParcelableData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mRecord.getParcelableData() : (Parcelable) invokeV.objValue;
    }

    @Deprecated
    public int getRemovedCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mRecord.getRemovedCount() : invokeV.intValue;
    }

    @Deprecated
    public int getScrollX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mRecord.getScrollX() : invokeV.intValue;
    }

    @Deprecated
    public int getScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mRecord.getScrollY() : invokeV.intValue;
    }

    @Deprecated
    public AccessibilityNodeInfoCompat getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mRecord.getSource()) : (AccessibilityNodeInfoCompat) invokeV.objValue;
    }

    @Deprecated
    public List<CharSequence> getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mRecord.getText() : (List) invokeV.objValue;
    }

    @Deprecated
    public int getToIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mRecord.getToIndex() : invokeV.intValue;
    }

    @Deprecated
    public int getWindowId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mRecord.getWindowId() : invokeV.intValue;
    }

    @Deprecated
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            AccessibilityRecord accessibilityRecord = this.mRecord;
            if (accessibilityRecord == null) {
                return 0;
            }
            return accessibilityRecord.hashCode();
        }
        return invokeV.intValue;
    }

    @Deprecated
    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mRecord.isChecked() : invokeV.booleanValue;
    }

    @Deprecated
    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mRecord.isEnabled() : invokeV.booleanValue;
    }

    @Deprecated
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mRecord.isFullScreen() : invokeV.booleanValue;
    }

    @Deprecated
    public boolean isPassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mRecord.isPassword() : invokeV.booleanValue;
    }

    @Deprecated
    public boolean isScrollable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mRecord.isScrollable() : invokeV.booleanValue;
    }

    @Deprecated
    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.mRecord.recycle();
        }
    }

    @Deprecated
    public void setAddedCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.mRecord.setAddedCount(i);
        }
    }

    @Deprecated
    public void setBeforeText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, charSequence) == null) {
            this.mRecord.setBeforeText(charSequence);
        }
    }

    @Deprecated
    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mRecord.setChecked(z);
        }
    }

    @Deprecated
    public void setClassName(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, charSequence) == null) {
            this.mRecord.setClassName(charSequence);
        }
    }

    @Deprecated
    public void setContentDescription(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, charSequence) == null) {
            this.mRecord.setContentDescription(charSequence);
        }
    }

    @Deprecated
    public void setCurrentItemIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.mRecord.setCurrentItemIndex(i);
        }
    }

    @Deprecated
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.mRecord.setEnabled(z);
        }
    }

    @Deprecated
    public void setFromIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.mRecord.setFromIndex(i);
        }
    }

    @Deprecated
    public void setFullScreen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.mRecord.setFullScreen(z);
        }
    }

    @Deprecated
    public void setItemCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.mRecord.setItemCount(i);
        }
    }

    @Deprecated
    public void setMaxScrollX(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            setMaxScrollX(this.mRecord, i);
        }
    }

    @Deprecated
    public void setMaxScrollY(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            setMaxScrollY(this.mRecord, i);
        }
    }

    @Deprecated
    public void setParcelableData(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, parcelable) == null) {
            this.mRecord.setParcelableData(parcelable);
        }
    }

    @Deprecated
    public void setPassword(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.mRecord.setPassword(z);
        }
    }

    @Deprecated
    public void setRemovedCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.mRecord.setRemovedCount(i);
        }
    }

    @Deprecated
    public void setScrollX(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.mRecord.setScrollX(i);
        }
    }

    @Deprecated
    public void setScrollY(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.mRecord.setScrollY(i);
        }
    }

    @Deprecated
    public void setScrollable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.mRecord.setScrollable(z);
        }
    }

    @Deprecated
    public void setSource(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, view2) == null) {
            this.mRecord.setSource(view2);
        }
    }

    @Deprecated
    public void setToIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.mRecord.setToIndex(i);
        }
    }

    public static int getMaxScrollX(AccessibilityRecord accessibilityRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, accessibilityRecord)) == null) {
            if (Build.VERSION.SDK_INT >= 15) {
                return accessibilityRecord.getMaxScrollX();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getMaxScrollY(AccessibilityRecord accessibilityRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, accessibilityRecord)) == null) {
            if (Build.VERSION.SDK_INT >= 15) {
                return accessibilityRecord.getMaxScrollY();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new AccessibilityRecordCompat(AccessibilityRecord.obtain()) : (AccessibilityRecordCompat) invokeV.objValue;
    }

    public static void setMaxScrollX(AccessibilityRecord accessibilityRecord, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, accessibilityRecord, i) == null) || Build.VERSION.SDK_INT < 15) {
            return;
        }
        accessibilityRecord.setMaxScrollX(i);
    }

    public static void setMaxScrollY(AccessibilityRecord accessibilityRecord, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65542, null, accessibilityRecord, i) == null) || Build.VERSION.SDK_INT < 15) {
            return;
        }
        accessibilityRecord.setMaxScrollY(i);
    }

    @Deprecated
    public void setSource(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048621, this, view2, i) == null) {
            setSource(this.mRecord, view2, i);
        }
    }

    public static void setSource(@NonNull AccessibilityRecord accessibilityRecord, View view2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65543, null, accessibilityRecord, view2, i) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        accessibilityRecord.setSource(view2, i);
    }
}
