package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.DimenRes;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class HeadPendantView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float HEAD_PADDING_RATE = 0.13f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47416e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f47417f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f47418g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f47419h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f47420i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f47421j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadPendantView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f47421j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = l.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.o = 0;
        this.q = true;
        this.f47416e = context;
        init();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(this.f47416e);
            this.f47419h = imageView;
            imageView.setImageDrawable(null);
            int i2 = this.n;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(11, -1);
            this.f47419h.setLayoutParams(layoutParams);
            this.f47419h.setVisibility(8);
            addView(this.f47419h);
        }
    }

    public void adjustBjhPbFirstFloorHeadView(@DimenRes int i2, @DimenRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) && (getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = l.g(getContext(), i2);
            ((FrameLayout.LayoutParams) getLayoutParams()).width = l.g(getContext(), i3);
            ((FrameLayout.LayoutParams) getLayoutParams()).height = l.g(getContext(), i3);
            if (this.l) {
                ((FrameLayout.LayoutParams) getLayoutParams()).gravity = 51;
            } else {
                ((FrameLayout.LayoutParams) getLayoutParams()).gravity = 16;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadImageView headImageView = new HeadImageView(this.f47416e);
            this.f47420i = headImageView;
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f47420i.setPlaceHolder(1);
            this.f47420i.setDefaultResource(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f47420i.setLayoutParams(layoutParams);
            addView(this.f47420i);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbImageView tbImageView = new TbImageView(this.f47416e);
            this.f47418g = tbImageView;
            tbImageView.setPageId(this.f47417f);
            this.f47418g.setDefaultBgResource(0);
            this.f47418g.setDefaultResource(0);
            this.f47418g.setImageDrawable(null);
            this.f47418g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f47418g.setVisibility(8);
            addView(this.f47418g);
        }
    }

    public final void d() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.n <= 0 || (imageView = this.f47419h) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        int i2 = this.n;
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f47419h.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.dispatchDraw(canvas);
        }
    }

    public final void e(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, metaData) == null) || metaData == null) {
            return;
        }
        if (this.p) {
            this.f47419h.setVisibility(8);
            return;
        }
        this.f47420i.setShowV(false);
        if (UtilHelper.showOfficialIcon(this.f47419h, metaData)) {
            return;
        }
        if (metaData.isNewGod()) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f47419h, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
            showBigVIcon(true);
            return;
        }
        showBigVIcon(false);
        if (this.m || !UtilHelper.showHeadBazhuIcon(this.f47419h, metaData, this.q)) {
            UtilHelper.showHeadBjhBigVIcon(this.f47419h, metaData, this.o);
        }
    }

    public ImageView getBigVIconView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f47419h : (ImageView) invokeV.objValue;
    }

    public HeadImageView getHeadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f47420i : (HeadImageView) invokeV.objValue;
    }

    public TbImageView getPendantView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f47418g : (TbImageView) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.n = l.g(getContext(), R.dimen.tbds42);
            b();
            c();
            a();
        }
    }

    public boolean isPendantShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : invokeV.booleanValue;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            if (this.f47421j) {
                int size = View.MeasureSpec.getSize(i2);
                int i4 = (int) (size * 0.13f);
                int size2 = (int) (View.MeasureSpec.getSize(i3) * 0.13f);
                ((RelativeLayout.LayoutParams) this.f47420i.getLayoutParams()).setMargins(i4, size2, i4, size2);
                ImageView imageView = this.f47419h;
                if (imageView != null) {
                    ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(i4, size2, i4, size2);
                }
            }
            if (this.l) {
                ((RelativeLayout.LayoutParams) this.f47420i.getLayoutParams()).setMargins(0, 0, 0, 0);
                ImageView imageView2 = this.f47419h;
                if (imageView2 != null) {
                    ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
            }
            super.onMeasure(i2, i3);
        }
    }

    public void setAuthIconType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f47418g.setAutoChangeStyle(z);
            this.f47420i.setAutoChangeStyle(z);
        }
    }

    public void setBigVDimenSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (i2 > 0) {
                this.n = l.g(getContext(), i2);
            }
            d();
        }
    }

    public void setBigVIconResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
        }
    }

    public void setBjhPbFirstFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.l = z;
        }
    }

    public void setDefalutResid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f47420i.setDefaultResource(i2);
        }
    }

    public void setHasPendantStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f47421j = true;
        }
    }

    public void setIsHomePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.m = z;
        }
    }

    public void setIsclearmode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.p = z;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bdUniqueId) == null) {
            this.f47417f = bdUniqueId;
            HeadImageView headImageView = this.f47420i;
            if (headImageView != null) {
                headImageView.setPageId(bdUniqueId);
            }
            TbImageView tbImageView = this.f47418g;
            if (tbImageView != null) {
                tbImageView.setPageId(bdUniqueId);
            }
        }
    }

    public void setShowSimpleIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.q = z;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.f47420i.setUrl(str);
        }
    }

    public void showBigVIcon(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (imageView = this.f47419h) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void showHeadPendantAndBigV(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, metaData) == null) || metaData == null) {
            return;
        }
        if (metaData.getPendantData() != null) {
            startLoadPendantUrl(metaData.getPendantData().getImgUrl());
        } else {
            startLoadPendantUrl(null);
        }
        e(metaData);
    }

    public void startLoad(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f47420i.startLoad(str, i2, 0, 0, z);
        }
    }

    public void startLoadAndAutoAdjustPendantStyle(MetaData metaData, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048606, this, metaData, i2, i3) == null) {
            if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().getImgUrl())) {
                setHasPendantStyle(true);
                setBigVDimenSize(i3);
            } else {
                setHasPendantStyle(false);
                setBigVDimenSize(i2);
            }
            startLoadWithPendantAndBigV(metaData);
        }
    }

    public void startLoadOnlyHeadUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(str);
        this.f47420i.setImageBitmap(null);
        this.f47420i.setUrl(headPortraitFilter);
        if (headPortraitFilter.startsWith("http")) {
            startLoad(headPortraitFilter, 10, false);
        } else {
            startLoad(headPortraitFilter, 25, false);
        }
    }

    public void startLoadPendantUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || this.f47418g == null) {
            return;
        }
        if (this.f47421j && !StringUtils.isNull(str)) {
            this.k = true;
            this.f47418g.setVisibility(0);
            this.f47418g.setImageDrawable(null);
            this.f47418g.startLoad(str, 10, false);
            return;
        }
        this.f47418g.setVisibility(8);
        this.k = false;
    }

    public void startLoadWithPendantAndBigV(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, metaData) == null) || metaData == null || TextUtils.isEmpty(metaData.getPortrait())) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(metaData.getAvater());
        setUrl(headPortraitFilter);
        if (headPortraitFilter.startsWith("http")) {
            startLoad(headPortraitFilter, 10, false);
        } else {
            startLoad(headPortraitFilter, 25, false);
        }
        showHeadPendantAndBigV(metaData);
    }

    public void setHasPendantStyle(boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (this.f47421j && !z && (headImageView2 = this.f47420i) != null) {
                ((RelativeLayout.LayoutParams) headImageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
                ImageView imageView = this.f47419h;
                if (imageView != null) {
                    ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                TbImageView tbImageView = this.f47418g;
                if (tbImageView != null) {
                    tbImageView.setVisibility(8);
                }
                this.k = false;
                invalidate();
            } else if (!this.f47421j && z && (headImageView = this.f47420i) != null) {
                int width = (int) (this.f47420i.getWidth() * 0.13f);
                int height = (int) (this.f47420i.getHeight() * 0.13f);
                ((RelativeLayout.LayoutParams) headImageView.getLayoutParams()).setMargins(width, height, width, height);
                ImageView imageView2 = this.f47419h;
                if (imageView2 != null) {
                    ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(width, height, width, height);
                }
                invalidate();
            }
            this.f47421j = z;
        }
    }

    public void showHeadPendantAndBigV(MetaData metaData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048604, this, metaData, i2) == null) || metaData == null) {
            return;
        }
        this.o = i2;
        showHeadPendantAndBigV(metaData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47421j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = l.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.o = 0;
        this.q = true;
        this.f47416e = context;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadPendantView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47421j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = l.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.o = 0;
        this.q = true;
        this.f47416e = context;
        init();
    }
}
