package com.baidu.android.ext.widget.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BdMenuItem {
    public static /* synthetic */ Interceptable $ic;
    public static final int NO_ICON = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mChecked;
    public Context mContext;
    public long mDismissDelayTime;
    public boolean mEnabled;
    public Drawable mIconDrawable;
    public int mIconResId;
    public final int mId;
    public boolean mIsAutoDismiss;
    public BdMenu mMenu;
    public OnItemClickListener mOnClickListener;
    public boolean mShowTip;
    public CharSequence mTitle;

    /* loaded from: classes6.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEnabled = true;
        this.mChecked = false;
        this.mShowTip = false;
        this.mIsAutoDismiss = true;
        this.mDismissDelayTime = 0L;
        this.mIconResId = 0;
        this.mContext = context;
        this.mId = i2;
        this.mTitle = charSequence;
    }

    public long getDismissDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDismissDelayTime : invokeV.longValue;
    }

    public Drawable getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Drawable drawable = this.mIconDrawable;
            if (drawable != null) {
                return drawable;
            }
            if (this.mIconResId != 0) {
                Drawable drawable2 = this.mContext.getResources().getDrawable(this.mIconResId);
                this.mIconResId = 0;
                this.mIconDrawable = drawable2;
                return drawable2;
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public int getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mId : invokeV.intValue;
    }

    public BdMenu getMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMenu : (BdMenu) invokeV.objValue;
    }

    public OnItemClickListener getOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mOnClickListener : (OnItemClickListener) invokeV.objValue;
    }

    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTitle : (CharSequence) invokeV.objValue;
    }

    public boolean isAutoDismiss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIsAutoDismiss : invokeV.booleanValue;
    }

    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mChecked : invokeV.booleanValue;
    }

    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mEnabled : invokeV.booleanValue;
    }

    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mChecked = z;
        }
    }

    public void setDismissDelayTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.mDismissDelayTime = j;
        }
    }

    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mEnabled = z;
        }
    }

    public BdMenuItem setIcon(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, drawable)) == null) {
            this.mIconResId = 0;
            this.mIconDrawable = drawable;
            return this;
        }
        return (BdMenuItem) invokeL.objValue;
    }

    public void setIsAutoDismiss(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mIsAutoDismiss = z;
        }
    }

    public void setMenu(BdMenu bdMenu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdMenu) == null) {
            this.mMenu = bdMenu;
        }
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onItemClickListener) == null) {
            this.mOnClickListener = onItemClickListener;
        }
    }

    public void setShowTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mShowTip = z;
        }
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, charSequence)) == null) {
            this.mTitle = charSequence;
            return this;
        }
        return (BdMenuItem) invokeL.objValue;
    }

    public boolean showTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mShowTip : invokeV.booleanValue;
    }

    public BdMenuItem setTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.mTitle = this.mContext.getResources().getText(i2, this.mTitle);
            return this;
        }
        return (BdMenuItem) invokeI.objValue;
    }

    public BdMenuItem setIcon(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.mIconDrawable = null;
            this.mIconResId = i2;
            return this;
        }
        return (BdMenuItem) invokeI.objValue;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEnabled = true;
        this.mChecked = false;
        this.mShowTip = false;
        this.mIsAutoDismiss = true;
        this.mDismissDelayTime = 0L;
        this.mIconResId = 0;
        this.mContext = context;
        this.mId = i2;
        this.mTitle = charSequence;
        this.mIconResId = i3;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence, drawable};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mEnabled = true;
        this.mChecked = false;
        this.mShowTip = false;
        this.mIsAutoDismiss = true;
        this.mDismissDelayTime = 0L;
        this.mIconResId = 0;
        this.mContext = context;
        this.mId = i2;
        this.mTitle = charSequence;
        this.mIconDrawable = drawable;
    }
}
