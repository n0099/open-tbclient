package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
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
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
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
    public Paint S0;
    public boolean T0;
    public int y0;
    public int z0;

    public void setBjhAuthIconRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadImageView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void U(Canvas canvas) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) && this.T0 && (i = this.O0) == (i2 = this.P0)) {
            float f = i * 0.77f;
            float f2 = (i - f) / 2.0f;
            float f3 = f + f2;
            float f4 = (i2 * 0.77f) + f2;
            this.S0.setColor(SkinManager.getColor(R.color.CAM_X0201));
            canvas.drawCircle(f3, f4, f2, this.S0);
            this.S0.setColor(SkinManager.getColor(R.color.CAM_X0309));
            canvas.drawCircle(f3, f4, f2 - 4.0f, this.S0);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        x();
    }

    private void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.z0 = wi.g(getContext(), R.dimen.tbds36);
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

    public void V(Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) && this.A0 && this.z0 > 0) {
            int i = this.M0;
            if (i != 0) {
                Drawable drawable2 = SkinManager.getDrawable(i);
                if (drawable2 == null) {
                    return;
                }
                int i2 = this.O0;
                int i3 = this.z0;
                int i4 = this.y0;
                int i5 = this.P0;
                drawable2.setBounds((i2 - i3) - i4, (i5 - i3) - i4, i2 - i4, i5 - i4);
                drawable2.draw(canvas);
                return;
            }
            int i6 = this.N0;
            if (i6 != 0) {
                Drawable drawable3 = SkinManager.getDrawable(i6);
                if (drawable3 == null) {
                    return;
                }
                int i7 = this.O0;
                int i8 = this.z0;
                int i9 = this.y0;
                int i10 = this.P0;
                drawable3.setBounds((i7 - i8) - i9, (i10 - i8) - i9, i7 - i9, i10 - i9);
                drawable3.draw(canvas);
                return;
            }
            Drawable bjhBigVIconDrawable = UtilHelper.getBjhBigVIconDrawable(this.K0);
            if (bjhBigVIconDrawable != null) {
                int i11 = this.O0;
                int i12 = this.z0;
                int i13 = this.y0;
                int i14 = this.P0;
                bjhBigVIconDrawable.setBounds((i11 - i12) - i13, (i14 - i12) - i13, i11 - i13, i14 - i13);
                bjhBigVIconDrawable.draw(canvas);
                return;
            }
            int i15 = this.L0;
            if (i15 == 0 || (drawable = SkinManager.getDrawable(i15)) == null) {
                return;
            }
            int i16 = this.O0;
            int i17 = this.z0;
            int i18 = this.y0;
            int i19 = this.P0;
            drawable.setBounds((i16 - i17) - i18, (i19 - i17) - i18, i16 - i18, i19 - i18);
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (canvas == null) {
                return;
            }
            V(canvas);
            U(canvas);
        }
    }

    public void setAlaInfo(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, alaInfoData) == null) {
            this.Q0 = alaInfoData;
        }
    }

    public void setBazhuIconRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.L0 = i;
        }
    }

    public void setFName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.G0 = str;
        }
    }

    public void setFid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.D0 = str;
        }
    }

    public void setFloor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.H0 = i;
        }
    }

    public void setGodIconMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            setIsRound(true);
            if (i > 0) {
                this.y0 = wi.g(getContext(), i);
            }
            invalidate();
        }
    }

    public void setGodIconResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.K0 = i;
        }
    }

    public void setGodIconWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            if (i > 0) {
                this.z0 = wi.g(getContext(), i);
            }
            invalidate();
        }
    }

    public void setIsBigV(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.A0 = z;
        }
    }

    public void setIsGod(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
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

    public void setLiveStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.R0 = i;
        }
    }

    public void setOfficialIconResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.M0 = i;
        }
    }

    public void setOriginatorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.N0 = i;
        }
    }

    public void setShowActiveStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.T0 = z;
            if (z) {
                Paint paint = new Paint(1);
                this.S0 = paint;
                paint.setStyle(Paint.Style.FILL);
                invalidate();
            }
        }
    }

    public void setShowV(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.A0 = z;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.E0 = str;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.F0 = str;
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.B0 = str;
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            setUserName(str, str + getResources().getString(R.string.somebodys_portrait));
        }
    }

    public AlaInfoData getAlaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.Q0;
        }
        return (AlaInfoData) invokeV.objValue;
    }

    public String getFName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.G0;
        }
        return (String) invokeV.objValue;
    }

    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.D0;
        }
        return (String) invokeV.objValue;
    }

    public int getFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.H0;
        }
        return invokeV.intValue;
    }

    public int getLiveStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.R0;
        }
        return invokeV.intValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.E0;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.F0;
        }
        return (String) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.B0;
        }
        return (String) invokeV.objValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.C0;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.O0 = getWidth();
            this.P0 = getHeight();
        }
    }

    public void setUserName(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, str2) == null) {
            this.C0 = str;
            setContentDescription(str2);
        }
    }
}
