package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
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
import d.a.d.e.p.l;
/* loaded from: classes3.dex */
public class HeadPendantView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f12454e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f12455f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f12456g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f12457h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f12458i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;

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
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.n = 0;
        this.p = true;
        this.f12454e = context;
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(this.f12454e);
            this.f12457h = imageView;
            imageView.setImageDrawable(null);
            int i2 = this.m;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(11, -1);
            this.f12457h.setLayoutParams(layoutParams);
            this.f12457h.setVisibility(8);
            addView(this.f12457h);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HeadImageView headImageView = new HeadImageView(this.f12454e);
            this.f12458i = headImageView;
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f12458i.setPlaceHolder(1);
            this.f12458i.setDefaultResource(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f12458i.setLayoutParams(layoutParams);
            addView(this.f12458i);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbImageView tbImageView = new TbImageView(this.f12454e);
            this.f12456g = tbImageView;
            tbImageView.setPageId(this.f12455f);
            this.f12456g.setDefaultBgResource(0);
            this.f12456g.setDefaultResource(0);
            this.f12456g.setImageDrawable(null);
            this.f12456g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f12456g.setVisibility(8);
            addView(this.f12456g);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.m = l.g(getContext(), R.dimen.tbds42);
            b();
            c();
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.dispatchDraw(canvas);
        }
    }

    public final void e() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.m <= 0 || (imageView = this.f12457h) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        int i2 = this.m;
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f12457h.setLayoutParams(layoutParams);
    }

    public final void f(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, metaData) == null) || metaData == null) {
            return;
        }
        if (this.o) {
            this.f12457h.setVisibility(8);
            return;
        }
        this.f12458i.setShowV(false);
        if (UtilHelper.showOfficialIcon(this.f12457h, metaData)) {
            return;
        }
        if (metaData.isNewGod()) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f12457h, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
            g(true);
            return;
        }
        g(false);
        if (this.l || !UtilHelper.showHeadBazhuIcon(this.f12457h, metaData, this.p)) {
            UtilHelper.showHeadBjhBigVIcon(this.f12457h, metaData, this.n);
        }
    }

    public void g(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (imageView = this.f12457h) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public ImageView getBigVIconView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f12457h : (ImageView) invokeV.objValue;
    }

    public HeadImageView getHeadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f12458i : (HeadImageView) invokeV.objValue;
    }

    public TbImageView getPendantView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f12456g : (TbImageView) invokeV.objValue;
    }

    public void h(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, metaData) == null) || metaData == null) {
            return;
        }
        if (metaData.getPendantData() != null) {
            l(metaData.getPendantData().getImgUrl());
        } else {
            l(null);
        }
        f(metaData);
    }

    public void i(MetaData metaData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048588, this, metaData, i2) == null) || metaData == null) {
            return;
        }
        this.n = i2;
        h(metaData);
    }

    public void j(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f12458i.J(str, i2, 0, 0, z);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(str);
        this.f12458i.setImageBitmap(null);
        this.f12458i.setUrl(headPortraitFilter);
        if (headPortraitFilter.startsWith("http")) {
            j(headPortraitFilter, 10, false);
        } else {
            j(headPortraitFilter, 25, false);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || this.f12456g == null) {
            return;
        }
        if (this.j && !StringUtils.isNull(str)) {
            this.f12456g.setVisibility(0);
            this.f12456g.setImageDrawable(null);
            this.f12456g.M(str, 10, false);
            return;
        }
        this.f12456g.setVisibility(8);
    }

    public void m(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, metaData) == null) || metaData == null || TextUtils.isEmpty(metaData.getPortrait())) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(metaData.getAvater());
        setUrl(headPortraitFilter);
        if (headPortraitFilter.startsWith("http")) {
            j(headPortraitFilter, 10, false);
        } else {
            j(headPortraitFilter, 25, false);
        }
        h(metaData);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            if (this.j) {
                int size = View.MeasureSpec.getSize(i2);
                int i4 = (int) (size * 0.13f);
                int size2 = (int) (View.MeasureSpec.getSize(i3) * 0.13f);
                ((RelativeLayout.LayoutParams) this.f12458i.getLayoutParams()).setMargins(i4, size2, i4, size2);
                ImageView imageView = this.f12457h;
                if (imageView != null) {
                    ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(i4, size2, i4, size2);
                }
            }
            if (this.k) {
                ((RelativeLayout.LayoutParams) this.f12458i.getLayoutParams()).setMargins(0, 0, 0, 0);
                ImageView imageView2 = this.f12457h;
                if (imageView2 != null) {
                    ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
            }
            super.onMeasure(i2, i3);
        }
    }

    public void setAuthIconType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f12456g.setAutoChangeStyle(z);
            this.f12458i.setAutoChangeStyle(z);
        }
    }

    public void setBigVDimenSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 > 0) {
                this.m = l.g(getContext(), i2);
            }
            e();
        }
    }

    public void setBigVIconResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
        }
    }

    public void setBjhPbFirstFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.k = z;
        }
    }

    public void setDefalutResid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f12458i.setDefaultResource(i2);
        }
    }

    public void setHasPendantStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.j = true;
        }
    }

    public void setIsHomePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.l = z;
        }
    }

    public void setIsclearmode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.o = z;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bdUniqueId) == null) {
            this.f12455f = bdUniqueId;
            HeadImageView headImageView = this.f12458i;
            if (headImageView != null) {
                headImageView.setPageId(bdUniqueId);
            }
            TbImageView tbImageView = this.f12456g;
            if (tbImageView != null) {
                tbImageView.setPageId(bdUniqueId);
            }
        }
    }

    public void setShowSimpleIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.p = z;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.f12458i.setUrl(str);
        }
    }

    public void setHasPendantStyle(boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (this.j && !z && (headImageView2 = this.f12458i) != null) {
                ((RelativeLayout.LayoutParams) headImageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
                ImageView imageView = this.f12457h;
                if (imageView != null) {
                    ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                TbImageView tbImageView = this.f12456g;
                if (tbImageView != null) {
                    tbImageView.setVisibility(8);
                }
                invalidate();
            } else if (!this.j && z && (headImageView = this.f12458i) != null) {
                int width = (int) (this.f12458i.getWidth() * 0.13f);
                int height = (int) (this.f12458i.getHeight() * 0.13f);
                ((RelativeLayout.LayoutParams) headImageView.getLayoutParams()).setMargins(width, height, width, height);
                ImageView imageView2 = this.f12457h;
                if (imageView2 != null) {
                    ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(width, height, width, height);
                }
                invalidate();
            }
            this.j = z;
        }
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
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.n = 0;
        this.p = true;
        this.f12454e = context;
        d();
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
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.n = 0;
        this.p = true;
        this.f12454e = context;
        d();
    }
}
