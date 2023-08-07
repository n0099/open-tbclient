package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes4.dex */
public class HeadImageView extends TbClipImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float ACTIVE_STATUS_DISTANCE_PROPORTION_OF_IMG = 0.77f;
    public static final float ACTIVE_STATUS_STROKE_WIDTH = 4.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint activeStatusPaint;
    public AlaInfoData alaInfo;
    public String fName;
    public String fid;
    public int floor;
    public int height;
    public int iconMargin;
    public boolean isShowV;
    public int liveStatus;
    public int mBazhuIconResId;
    public int mBjhAuthIconResId;
    public int mDefaultBgId;
    public int mDefaultId;
    public int mGodIconResId;
    public int mIconWidth;
    public int mOriginatorResId;
    public String mUrl;
    public int officialIconResId;
    public boolean showActiveStatus;
    public String tid;
    public String user_id;
    public String user_name;
    public int width;

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

    private void drawActiveStatus(Canvas canvas) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, canvas) == null) && this.showActiveStatus && (i = this.width) == (i2 = this.height)) {
            float f = i * 0.77f;
            float f2 = (i - f) / 2.0f;
            float f3 = f + f2;
            float f4 = (i2 * 0.77f) + f2;
            this.activeStatusPaint.setColor(SkinManager.getColor(R.color.CAM_X0201));
            canvas.drawCircle(f3, f4, f2, this.activeStatusPaint);
            this.activeStatusPaint.setColor(SkinManager.getColor(R.color.CAM_X0309));
            canvas.drawCircle(f3, f4, f2 - 4.0f, this.activeStatusPaint);
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
        this.iconMargin = 0;
        this.mIconWidth = 0;
        this.isShowV = false;
        this.user_id = null;
        this.user_name = null;
        this.fid = null;
        this.tid = null;
        this.mUrl = null;
        this.fName = null;
        this.mDefaultId = R.drawable.transparent_bg;
        this.mDefaultBgId = R.color.CAM_X0209;
        this.mGodIconResId = R.drawable.ic_icon_mask_shen20_n;
        this.mBazhuIconResId = 0;
        this.liveStatus = -1;
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mIconWidth = BdUtilHelper.getDimens(getContext(), R.dimen.tbds36);
            setDrawerType(1);
            setGifIconSupport(false);
            setDrawBorder(true);
            setDefaultBgResource(this.mDefaultBgId);
            setDefaultResource(this.mDefaultId);
            setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            setBorderColor(SkinManager.getColor(R.color.black_alpha8));
            setBorderSurroundContent(true);
            setConrers(15);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (canvas == null) {
                return;
            }
            updateVIcon(canvas);
            drawActiveStatus(canvas);
        }
    }

    public void setAlaInfo(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, alaInfoData) == null) {
            this.alaInfo = alaInfoData;
        }
    }

    public void setBazhuIconRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mBazhuIconResId = i;
        }
    }

    public void setBjhAuthIconRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.mBjhAuthIconResId = i;
        }
    }

    public void setFName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.fName = str;
        }
    }

    public void setFid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.fid = str;
        }
    }

    public void setFloor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.floor = i;
        }
    }

    public void setGodIconMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            setIsRound(true);
            if (i > 0) {
                this.iconMargin = BdUtilHelper.getDimens(getContext(), i);
            }
            invalidate();
        }
    }

    public void setGodIconResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.mGodIconResId = i;
        }
    }

    public void setGodIconWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            if (i > 0) {
                this.mIconWidth = BdUtilHelper.getDimens(getContext(), i);
            }
            invalidate();
        }
    }

    public void setIsBigV(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.isShowV = z;
        }
    }

    public void setIsGod(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.isShowV = z;
            if (z) {
                setGodIconMargin(0);
                return;
            }
            setIsRound(true);
            this.iconMargin = 0;
            invalidate();
        }
    }

    public void setLiveStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.liveStatus = i;
        }
    }

    public void setOfficialIconResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.officialIconResId = i;
        }
    }

    public void setOriginatorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.mOriginatorResId = i;
        }
    }

    public void setShowActiveStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.showActiveStatus = z;
            if (z) {
                Paint paint = new Paint(1);
                this.activeStatusPaint = paint;
                paint.setStyle(Paint.Style.FILL);
                invalidate();
            }
        }
    }

    public void setShowV(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.isShowV = z;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.tid = str;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.mUrl = str;
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.user_id = str;
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            setUserName(str, str + getResources().getString(R.string.somebodys_portrait));
        }
    }

    public AlaInfoData getAlaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.alaInfo;
        }
        return (AlaInfoData) invokeV.objValue;
    }

    public String getFName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.fName;
        }
        return (String) invokeV.objValue;
    }

    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.fid;
        }
        return (String) invokeV.objValue;
    }

    public int getFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.floor;
        }
        return invokeV.intValue;
    }

    public int getLiveStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.liveStatus;
        }
        return invokeV.intValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.tid;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.user_id;
        }
        return (String) invokeV.objValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.user_name;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.width = getWidth();
            this.height = getHeight();
        }
    }

    public void setUserName(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, str, str2) == null) {
            this.user_name = str;
            setContentDescription(str2);
        }
    }

    public void updateVIcon(Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, canvas) == null) && this.isShowV && this.mIconWidth > 0) {
            int i = this.officialIconResId;
            if (i != 0) {
                Drawable drawable2 = SkinManager.getDrawable(i);
                if (drawable2 == null) {
                    return;
                }
                int i2 = this.width;
                int i3 = this.mIconWidth;
                int i4 = this.iconMargin;
                int i5 = this.height;
                drawable2.setBounds((i2 - i3) - i4, (i5 - i3) - i4, i2 - i4, i5 - i4);
                drawable2.draw(canvas);
                return;
            }
            int i6 = this.mOriginatorResId;
            if (i6 != 0) {
                Drawable drawable3 = SkinManager.getDrawable(i6);
                if (drawable3 == null) {
                    return;
                }
                int i7 = this.width;
                int i8 = this.mIconWidth;
                int i9 = this.iconMargin;
                int i10 = this.height;
                drawable3.setBounds((i7 - i8) - i9, (i10 - i8) - i9, i7 - i9, i10 - i9);
                drawable3.draw(canvas);
                return;
            }
            Drawable bjhBigVIconDrawable = UtilHelper.getBjhBigVIconDrawable(this.mGodIconResId);
            if (bjhBigVIconDrawable != null) {
                int i11 = this.width;
                int i12 = this.mIconWidth;
                int i13 = this.iconMargin;
                int i14 = this.height;
                bjhBigVIconDrawable.setBounds((i11 - i12) - i13, (i14 - i12) - i13, i11 - i13, i14 - i13);
                bjhBigVIconDrawable.draw(canvas);
                return;
            }
            int i15 = this.mBazhuIconResId;
            if (i15 == 0 || (drawable = SkinManager.getDrawable(i15)) == null) {
                return;
            }
            int i16 = this.width;
            int i17 = this.mIconWidth;
            int i18 = this.iconMargin;
            int i19 = this.height;
            drawable.setBounds((i16 - i17) - i18, (i19 - i17) - i18, i16 - i18, i19 - i18);
            drawable.draw(canvas);
        }
    }
}
