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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.s9;
import com.baidu.tieba.y9;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes3.dex */
public class HeadPendantView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbImageView b;
    public SimpleDraweeView c;
    public ImageView d;
    public HeadImageView e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public final int j;
    public boolean k;
    public boolean l;
    public boolean m;

    public void setAuthIconType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
        }
    }

    public void setBigVIconResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ HeadPendantView b;

        public a(HeadPendantView headPendantView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headPendantView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = headPendantView;
            this.a = view2;
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
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = zi.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.j = zi.g(TbadkApplication.getInst(), R.dimen.tbds5);
        this.l = true;
        this.m = false;
        this.a = context;
        d();
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            TbImageView tbImageView = this.b;
            if (tbImageView != null) {
                tbImageView.setVisibility(8);
            }
            if (this.c != null) {
                if (!StringUtils.isNull(str)) {
                    this.c.setVisibility(0);
                    this.c.setController(Fresco.newDraweeControllerBuilder().setUri(str).setAutoPlayAnimations(true).build());
                    return;
                }
                this.c.setVisibility(8);
            }
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            SimpleDraweeView simpleDraweeView = this.c;
            if (simpleDraweeView != null) {
                simpleDraweeView.setVisibility(8);
            }
            if (this.b == null) {
                return;
            }
            if (this.f && !StringUtils.isNull(str)) {
                this.b.setVisibility(0);
                this.b.setImageDrawable(null);
                Glide.with(this.a).load(str).into(this.b);
                if (this.m) {
                    e(this.b);
                    return;
                }
                return;
            }
            this.b.setVisibility(8);
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
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = zi.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.j = zi.g(TbadkApplication.getInst(), R.dimen.tbds5);
        this.l = true;
        this.m = false;
        this.a = context;
        d();
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
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = zi.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.j = zi.g(TbadkApplication.getInst(), R.dimen.tbds5);
        this.l = true;
        this.m = false;
        this.a = context;
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(this.a);
            this.d = imageView;
            imageView.setImageDrawable(null);
            int i = this.i;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(11, -1);
            this.d.setLayoutParams(layoutParams);
            this.d.setVisibility(8);
            addView(this.d);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HeadImageView headImageView = new HeadImageView(this.a);
            this.e = headImageView;
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.e.setPlaceHolder(1);
            this.e.setDefaultResource(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.e.setLayoutParams(layoutParams);
            addView(this.e);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = new TbImageView(this.a);
            s9<?> a2 = y9.a(this.a);
            if (a2 != null) {
                this.b.setPageId(a2.getUniqueId());
            }
            this.b.setDefaultBgResource(0);
            this.b.setDefaultResource(0);
            this.b.setImageDrawable(null);
            this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.b.setVisibility(8);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this.a);
            this.c = simpleDraweeView;
            simpleDraweeView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            SimpleDraweeView simpleDraweeView2 = this.c;
            int i = this.j;
            simpleDraweeView2.setPadding(i, i, i, i);
            this.c.setVisibility(8);
            addView(this.b);
            addView(this.c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.i = zi.g(getContext(), R.dimen.tbds42);
            b();
            c();
            a();
        }
    }

    public final void f() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.i > 0 && (imageView = this.d) != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            int i = this.i;
            layoutParams.width = i;
            layoutParams.height = i;
            this.d.setLayoutParams(layoutParams);
        }
    }

    public ImageView getBigVIconView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (ImageView) invokeV.objValue;
    }

    public HeadImageView getHeadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return (HeadImageView) invokeV.objValue;
    }

    public TbImageView getPendantView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (TbImageView) invokeV.objValue;
    }

    public void setHasPendantStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.dispatchDraw(canvas);
        }
    }

    public void h(boolean z) {
        ImageView imageView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z) != null) || (imageView = this.d) == null) {
            return;
        }
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.b.setAutoChangeStyle(z);
            this.e.setAutoChangeStyle(z);
        }
    }

    public void setBigVDimenSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            if (i > 0) {
                this.i = zi.g(getContext(), i);
            }
            f();
        }
    }

    public void setBjhPbFirstFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.g = z;
        }
    }

    public void setDefalutResid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.e.setDefaultResource(i);
        }
    }

    public void setIsHomePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.h = z;
        }
    }

    public void setIsNeedAlpAnima(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.m = z;
        }
    }

    public void setIsclearmode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.k = z;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bdUniqueId) == null) {
            HeadImageView headImageView = this.e;
            if (headImageView != null) {
                headImageView.setPageId(bdUniqueId);
            }
            TbImageView tbImageView = this.b;
            if (tbImageView != null) {
                tbImageView.setPageId(bdUniqueId);
            }
        }
    }

    public void setShowSimpleIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.l = z;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.e.setUrl(str);
        }
    }

    public final void e(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            view2.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new a(this, view2));
            ofInt.start();
        }
    }

    public void i(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, metaData) != null) || metaData == null) {
            return;
        }
        UserPendantData pendantData = metaData.getPendantData();
        if (pendantData != null) {
            if (!StringUtils.isNull(pendantData.getDynamicImgUrl())) {
                l(pendantData.getDynamicImgUrl());
            } else {
                n(pendantData.getImgUrl());
            }
        } else {
            n(null);
        }
        g(metaData);
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.e.setImageBitmap(null);
        this.e.setUrl(str);
        if (str.startsWith("http")) {
            k(str, 10, false);
        } else {
            k(str, 25, false);
        }
    }

    public void o(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, metaData) == null) && metaData != null && !TextUtils.isEmpty(metaData.getPortrait())) {
            String avater = metaData.getAvater();
            setUrl(avater);
            if (avater.startsWith("http")) {
                k(avater, 10, false);
            } else {
                k(avater, 25, false);
            }
            i(metaData);
        }
    }

    public final void g(MetaData metaData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, metaData) != null) || metaData == null) {
            return;
        }
        if (this.k) {
            this.d.setVisibility(8);
            return;
        }
        this.e.setShowV(false);
        if (UtilHelper.isFllowByPriorty(metaData)) {
            if (metaData.getAuthType() == 1) {
                z = UtilHelper.showOfficialIcon(this.d, metaData);
            } else if (metaData.getAuthType() == 1) {
                z = UtilHelper.showOriginalIcon(this.d, metaData);
            } else if (metaData.getAuthType() == 3) {
                z = UtilHelper.showNewGodIcon(this.d, metaData);
            } else if (metaData.getAuthType() == 4 && !this.h) {
                z = UtilHelper.showHeadBazhuIcon(this.d, metaData, this.l);
            }
            if (!z || UtilHelper.showOfficialIcon(this.d, metaData) || UtilHelper.showOriginalIcon(this.d, metaData) || UtilHelper.showNewGodIcon(this.d, metaData)) {
                return;
            }
            h(false);
            if (!this.h || UtilHelper.showHeadBazhuIcon(this.d, metaData, this.l)) {
            }
        }
        z = false;
        if (!z) {
            return;
        }
        h(false);
        if (!this.h) {
        }
    }

    public void j(MetaData metaData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048589, this, metaData, i) != null) || metaData == null) {
            return;
        }
        i(metaData);
    }

    public void k(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.e.G(str, i, 0, 0, z);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) {
            if (this.f) {
                int size = View.MeasureSpec.getSize(i);
                int i3 = (int) (size * 0.13f);
                int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
                ((RelativeLayout.LayoutParams) this.e.getLayoutParams()).setMargins(i3, size2, i3, size2);
                ImageView imageView = this.d;
                if (imageView != null) {
                    ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(i3, size2, i3, size2);
                }
            }
            if (this.g) {
                ((RelativeLayout.LayoutParams) this.e.getLayoutParams()).setMargins(0, 0, 0, 0);
                ImageView imageView2 = this.d;
                if (imageView2 != null) {
                    ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
            }
            super.onMeasure(i, i2);
        }
    }

    public void setHasPendantStyle(boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            if (this.f && !z && (headImageView2 = this.e) != null) {
                ((RelativeLayout.LayoutParams) headImageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
                ImageView imageView = this.d;
                if (imageView != null) {
                    ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                TbImageView tbImageView = this.b;
                if (tbImageView != null) {
                    tbImageView.setVisibility(8);
                }
                invalidate();
            } else if (!this.f && z && (headImageView = this.e) != null) {
                int width = (int) (this.e.getWidth() * 0.13f);
                int height = (int) (this.e.getHeight() * 0.13f);
                ((RelativeLayout.LayoutParams) headImageView.getLayoutParams()).setMargins(width, height, width, height);
                ImageView imageView2 = this.d;
                if (imageView2 != null) {
                    ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(width, height, width, height);
                }
                invalidate();
            }
            this.f = z;
        }
    }
}
