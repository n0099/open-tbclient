package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes3.dex */
public class HeadImageView extends TbClipImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A0;
    public String B0;
    public String C0;
    public String D0;
    public String E0;
    public String F0;
    public String G0;
    public int H0;
    public int I0;
    public int J0;
    public int K0;
    public int L0;
    public int M0;
    public int N0;
    public int O0;
    public int P0;
    public AlaInfoData Q0;
    public int R0;
    public int y0;
    public int z0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadImageView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.z0 = l.g(getContext(), R.dimen.tbds36);
            setDrawerType(1);
            setGifIconSupport(false);
            setDrawBorder(true);
            setDefaultBgResource(this.J0);
            setDefaultResource(this.I0);
            setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            setBorderColor(SkinManager.getColor(R.color.black_alpha8));
            setBorderSurroundContent(true);
            setConrers(15);
        }
    }

    public void T(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) && this.A0 && this.z0 > 0) {
            int i2 = this.N0;
            if (i2 != 0) {
                Drawable drawable = SkinManager.getDrawable(i2);
                if (drawable == null) {
                    return;
                }
                int i3 = this.O0;
                int i4 = this.z0;
                int i5 = this.y0;
                int i6 = this.P0;
                drawable.setBounds((i3 - i4) - i5, (i6 - i4) - i5, i3 - i5, i6 - i5);
                drawable.draw(canvas);
                return;
            }
            int i7 = this.M0;
            if (i7 != 0) {
                Drawable bjhBigVIconDrawable = UtilHelper.getBjhBigVIconDrawable(i7);
                if (bjhBigVIconDrawable == null) {
                    return;
                }
                int i8 = this.O0;
                int i9 = this.z0;
                int i10 = this.y0;
                int i11 = this.P0;
                bjhBigVIconDrawable.setBounds((i8 - i9) - i10, (i11 - i9) - i10, i8 - i10, i11 - i10);
                bjhBigVIconDrawable.draw(canvas);
                return;
            }
            int i12 = this.L0;
            if (i12 != 0) {
                Drawable drawable2 = SkinManager.getDrawable(i12);
                if (drawable2 == null) {
                    return;
                }
                int i13 = this.O0;
                int i14 = this.z0;
                int i15 = this.y0;
                int i16 = this.P0;
                drawable2.setBounds((i13 - i14) - i15, (i16 - i14) - i15, i13 - i15, i16 - i15);
                drawable2.draw(canvas);
                return;
            }
            Drawable bjhBigVIconDrawable2 = UtilHelper.getBjhBigVIconDrawable(this.K0);
            if (bjhBigVIconDrawable2 == null) {
                return;
            }
            int i17 = this.O0;
            int i18 = this.z0;
            int i19 = this.y0;
            int i20 = this.P0;
            bjhBigVIconDrawable2.setBounds((i17 - i18) - i19, (i20 - i18) - i19, i17 - i19, i20 - i19);
            bjhBigVIconDrawable2.draw(canvas);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (canvas == null) {
                return;
            }
            T(canvas);
        }
    }

    public AlaInfoData getAlaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.Q0 : (AlaInfoData) invokeV.objValue;
    }

    public String getFName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.G0 : (String) invokeV.objValue;
    }

    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.D0 : (String) invokeV.objValue;
    }

    public int getFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.H0 : invokeV.intValue;
    }

    public int getLiveStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.R0 : invokeV.intValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.E0 : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.F0 : (String) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.B0 : (String) invokeV.objValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.C0 : (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048587, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.O0 = getWidth();
            this.P0 = getHeight();
        }
    }

    public void setAlaInfo(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, alaInfoData) == null) {
            this.Q0 = alaInfoData;
        }
    }

    public void setBazhuIconRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.L0 = i2;
        }
    }

    public void setBjhAuthIconRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.M0 = i2;
        }
    }

    public void setFName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.G0 = str;
        }
    }

    public void setFid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.D0 = str;
        }
    }

    public void setFloor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.H0 = i2;
        }
    }

    public void setGodIconMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            setIsRound(true);
            if (i2 > 0) {
                this.y0 = l.g(getContext(), i2);
            }
            invalidate();
        }
    }

    public void setGodIconResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.K0 = i2;
        }
    }

    public void setGodIconWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 > 0) {
                this.z0 = l.g(getContext(), i2);
            }
            invalidate();
        }
    }

    public void setIsBigV(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.A0 = z;
        }
    }

    public void setIsGod(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.A0 = z;
            if (z) {
                setGodIconMargin(0);
                return;
            }
            setIsRound(true);
            this.y0 = 0;
            invalidate();
        }
    }

    public void setLiveStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.R0 = i2;
        }
    }

    public void setOfficialIconResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.N0 = i2;
        }
    }

    public void setShowV(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.A0 = z;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.E0 = str;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.F0 = str;
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.B0 = str;
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            setUserName(str, str + getResources().getString(R.string.somebodys_portrait));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setUserName(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, str2) == null) {
            this.C0 = str;
            setContentDescription(str2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.y0 = 0;
        this.z0 = 0;
        this.A0 = false;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.I0 = R.drawable.transparent_bg;
        this.J0 = R.color.CAM_X0209;
        this.K0 = R.drawable.ic_icon_mask_shen20_n;
        this.L0 = 0;
        this.R0 = -1;
        v();
    }
}
