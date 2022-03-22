package com.baidu.tbadk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HeadPendantView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f29988b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f29989c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f29990d;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f29991e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29992f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29993g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29994h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HeadPendantView f29995b;

        public a(HeadPendantView headPendantView, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headPendantView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29995b = headPendantView;
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setAlpha(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
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
        this.f29992f = false;
        this.f29993g = false;
        this.f29994h = false;
        this.i = n.f(TbadkApplication.getInst(), R.dimen.tbds36);
        this.k = true;
        this.l = false;
        this.a = context;
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(this.a);
            this.f29990d = imageView;
            imageView.setImageDrawable(null);
            int i = this.i;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(11, -1);
            this.f29990d.setLayoutParams(layoutParams);
            this.f29990d.setVisibility(8);
            addView(this.f29990d);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HeadImageView headImageView = new HeadImageView(this.a);
            this.f29991e = headImageView;
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f29991e.setPlaceHolder(1);
            this.f29991e.setDefaultResource(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f29991e.setLayoutParams(layoutParams);
            addView(this.f29991e);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbImageView tbImageView = new TbImageView(this.a);
            this.f29989c = tbImageView;
            tbImageView.setPageId(this.f29988b);
            this.f29989c.setDefaultBgResource(0);
            this.f29989c.setDefaultResource(0);
            this.f29989c.setImageDrawable(null);
            this.f29989c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f29989c.setVisibility(8);
            addView(this.f29989c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.i = n.f(getContext(), R.dimen.tbds42);
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

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            view.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new a(this, view));
            ofInt.start();
        }
    }

    public final void f() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.i <= 0 || (imageView = this.f29990d) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        int i = this.i;
        layoutParams.width = i;
        layoutParams.height = i;
        this.f29990d.setLayoutParams(layoutParams);
    }

    public final void g(MetaData metaData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, metaData) == null) || metaData == null) {
            return;
        }
        if (this.j) {
            this.f29990d.setVisibility(8);
            return;
        }
        this.f29991e.setShowV(false);
        if (UtilHelper.isFllowByPriorty(metaData)) {
            if (metaData.getAuthType() == 1) {
                z = UtilHelper.showOfficialIcon(this.f29990d, metaData);
            } else if (metaData.getAuthType() == 1) {
                z = UtilHelper.showOriginalIcon(this.f29990d, metaData);
            } else if (metaData.getAuthType() == 3) {
                z = UtilHelper.showNewGodIcon(this.f29990d, metaData);
            } else if (metaData.getAuthType() == 4 && !this.f29994h) {
                z = UtilHelper.showHeadBazhuIcon(this.f29990d, metaData, this.k);
            }
            if (!z || UtilHelper.showOfficialIcon(this.f29990d, metaData) || UtilHelper.showOriginalIcon(this.f29990d, metaData) || UtilHelper.showNewGodIcon(this.f29990d, metaData)) {
                return;
            }
            h(false);
            if (this.f29994h || UtilHelper.showHeadBazhuIcon(this.f29990d, metaData, this.k)) {
            }
        }
        z = false;
        if (!z) {
            return;
        }
        h(false);
        if (this.f29994h) {
        }
    }

    public ImageView getBigVIconView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29990d : (ImageView) invokeV.objValue;
    }

    public HeadImageView getHeadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29991e : (HeadImageView) invokeV.objValue;
    }

    public TbImageView getPendantView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f29989c : (TbImageView) invokeV.objValue;
    }

    public void h(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (imageView = this.f29990d) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void i(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, metaData) == null) || metaData == null) {
            return;
        }
        if (metaData.getPendantData() != null) {
            m(metaData.getPendantData().getImgUrl());
        } else {
            m(null);
        }
        g(metaData);
    }

    public void j(MetaData metaData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048589, this, metaData, i) == null) || metaData == null) {
            return;
        }
        i(metaData);
    }

    public void k(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.f29991e.G(str, i, 0, 0, z);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(str);
        this.f29991e.setImageBitmap(null);
        this.f29991e.setUrl(headPortraitFilter);
        if (headPortraitFilter.startsWith("http")) {
            k(headPortraitFilter, 10, false);
        } else {
            k(headPortraitFilter, 25, false);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || this.f29989c == null) {
            return;
        }
        if (this.f29992f && !StringUtils.isNull(str)) {
            this.f29989c.setVisibility(0);
            this.f29989c.setImageDrawable(null);
            this.f29989c.J(str, 10, false);
            if (this.l) {
                e(this.f29989c);
                return;
            }
            return;
        }
        this.f29989c.setVisibility(8);
    }

    public void n(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, metaData) == null) || metaData == null || TextUtils.isEmpty(metaData.getPortrait())) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(metaData.getAvater());
        setUrl(headPortraitFilter);
        if (headPortraitFilter.startsWith("http")) {
            k(headPortraitFilter, 10, false);
        } else {
            k(headPortraitFilter, 25, false);
        }
        i(metaData);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) {
            if (this.f29992f) {
                int size = View.MeasureSpec.getSize(i);
                int i3 = (int) (size * 0.13f);
                int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
                ((RelativeLayout.LayoutParams) this.f29991e.getLayoutParams()).setMargins(i3, size2, i3, size2);
                ImageView imageView = this.f29990d;
                if (imageView != null) {
                    ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(i3, size2, i3, size2);
                }
            }
            if (this.f29993g) {
                ((RelativeLayout.LayoutParams) this.f29991e.getLayoutParams()).setMargins(0, 0, 0, 0);
                ImageView imageView2 = this.f29990d;
                if (imageView2 != null) {
                    ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
            }
            super.onMeasure(i, i2);
        }
    }

    public void setAuthIconType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f29989c.setAutoChangeStyle(z);
            this.f29991e.setAutoChangeStyle(z);
        }
    }

    public void setBigVDimenSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            if (i > 0) {
                this.i = n.f(getContext(), i);
            }
            f();
        }
    }

    public void setBigVIconResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
        }
    }

    public void setBjhPbFirstFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f29993g = z;
        }
    }

    public void setDefalutResid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.f29991e.setDefaultResource(i);
        }
    }

    public void setHasPendantStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f29992f = true;
        }
    }

    public void setIsHomePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.f29994h = z;
        }
    }

    public void setIsNeedAlpAnima(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.l = z;
        }
    }

    public void setIsclearmode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.j = z;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bdUniqueId) == null) {
            this.f29988b = bdUniqueId;
            HeadImageView headImageView = this.f29991e;
            if (headImageView != null) {
                headImageView.setPageId(bdUniqueId);
            }
            TbImageView tbImageView = this.f29989c;
            if (tbImageView != null) {
                tbImageView.setPageId(bdUniqueId);
            }
        }
    }

    public void setShowSimpleIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.k = z;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.f29991e.setUrl(str);
        }
    }

    public void setHasPendantStyle(boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            if (this.f29992f && !z && (headImageView2 = this.f29991e) != null) {
                ((RelativeLayout.LayoutParams) headImageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
                ImageView imageView = this.f29990d;
                if (imageView != null) {
                    ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                TbImageView tbImageView = this.f29989c;
                if (tbImageView != null) {
                    tbImageView.setVisibility(8);
                }
                invalidate();
            } else if (!this.f29992f && z && (headImageView = this.f29991e) != null) {
                int width = (int) (this.f29991e.getWidth() * 0.13f);
                int height = (int) (this.f29991e.getHeight() * 0.13f);
                ((RelativeLayout.LayoutParams) headImageView.getLayoutParams()).setMargins(width, height, width, height);
                ImageView imageView2 = this.f29990d;
                if (imageView2 != null) {
                    ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(width, height, width, height);
                }
                invalidate();
            }
            this.f29992f = z;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29992f = false;
        this.f29993g = false;
        this.f29994h = false;
        this.i = n.f(TbadkApplication.getInst(), R.dimen.tbds36);
        this.k = true;
        this.l = false;
        this.a = context;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29992f = false;
        this.f29993g = false;
        this.f29994h = false;
        this.i = n.f(TbadkApplication.getInst(), R.dimen.tbds36);
        this.k = true;
        this.l = false;
        this.a = context;
        d();
    }
}
