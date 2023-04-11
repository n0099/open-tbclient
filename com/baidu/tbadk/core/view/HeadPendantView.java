package com.baidu.tbadk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.g9;
import com.baidu.tieba.ii;
import com.baidu.tieba.view.TbLayerImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
/* loaded from: classes3.dex */
public class HeadPendantView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public TbImageView b;
    public SimpleDraweeView c;
    public TbLayerImageView d;
    public ImageView e;
    public HeadImageView f;
    public boolean g;
    public boolean h;
    public int i;
    public final int j;
    public boolean k;
    public boolean l;
    public boolean m;

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
        this.g = false;
        this.h = false;
        this.i = ii.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.j = ii.g(TbadkApplication.getInst(), R.dimen.tbds5);
        this.l = true;
        this.m = false;
        this.a = context;
        e();
    }

    public final void l(String str) {
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
            if (this.g && !StringUtils.isNull(str)) {
                this.b.setVisibility(0);
                this.b.setImageDrawable(null);
                Glide.with(this.a).load(str).into(this.b);
                if (this.m) {
                    f(this.b);
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
        this.g = false;
        this.h = false;
        this.i = ii.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.j = ii.g(TbadkApplication.getInst(), R.dimen.tbds5);
        this.l = true;
        this.m = false;
        this.a = context;
        e();
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
        this.g = false;
        this.h = false;
        this.i = ii.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.j = ii.g(TbadkApplication.getInst(), R.dimen.tbds5);
        this.l = true;
        this.m = false;
        this.a = context;
        e();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(this.a);
            this.e = imageView;
            imageView.setImageDrawable(null);
            int i = this.i;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(11, -1);
            this.e.setLayoutParams(layoutParams);
            this.e.setVisibility(8);
            addView(this.e);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HeadImageView headImageView = new HeadImageView(this.a);
            this.f = headImageView;
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f.setPlaceHolder(1);
            this.f.setDefaultResource(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f.setLayoutParams(layoutParams);
            addView(this.f);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbLayerImageView tbLayerImageView = new TbLayerImageView(this.a);
            this.d = tbLayerImageView;
            tbLayerImageView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            this.d.setVisibility(8);
            addView(this.d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i = ii.g(getContext(), R.dimen.tbds42);
            b();
            d();
            c();
            a();
        }
    }

    public ImageView getBigVIconView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (ImageView) invokeV.objValue;
    }

    public HeadImageView getHeadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (HeadImageView) invokeV.objValue;
    }

    public TbLayerImageView getLayerImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (TbLayerImageView) invokeV.objValue;
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.g = true;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = new TbImageView(this.a);
            a9<?> a2 = g9.a(this.a);
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

    public final void f(View view2) {
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
        j(metaData.getPendants());
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.f.setImageBitmap(null);
        this.f.setUrl(str);
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
            this.f.setUrl(avater);
            if (avater.startsWith("http")) {
                k(avater, 10, false);
            } else {
                k(avater, 25, false);
            }
            i(metaData);
        }
    }

    public void setBigVDimenSize(int i) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            if (i > 0) {
                this.i = ii.g(getContext(), i);
            }
            if (this.i > 0 && (imageView = this.e) != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                int i2 = this.i;
                layoutParams.width = i2;
                layoutParams.height = i2;
                this.e.setLayoutParams(layoutParams);
            }
        }
    }

    public final void g(MetaData metaData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, metaData) != null) || metaData == null) {
            return;
        }
        if (this.k) {
            this.e.setVisibility(8);
            return;
        }
        this.f.setShowV(false);
        if (UtilHelper.isFllowByPriorty(metaData)) {
            if (metaData.getAuthType() == 1) {
                z = UtilHelper.showOfficialIcon(this.e, metaData);
            } else if (metaData.getAuthType() == 1) {
                z = UtilHelper.showOriginalIcon(this.e, metaData);
            } else if (metaData.getAuthType() == 3) {
                z = UtilHelper.showNewGodIcon(this.e, metaData);
            } else if (metaData.getAuthType() == 4 && !this.h) {
                z = UtilHelper.showHeadBazhuIcon(this.e, metaData, this.l);
            }
            if (!z || UtilHelper.showOfficialIcon(this.e, metaData) || UtilHelper.showOriginalIcon(this.e, metaData) || UtilHelper.showNewGodIcon(this.e, metaData)) {
                return;
            }
            h(false);
            if (!this.h || UtilHelper.showHeadBazhuIcon(this.e, metaData, this.l)) {
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

    public void h(boolean z) {
        ImageView imageView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z) != null) || (imageView = this.e) == null) {
            return;
        }
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                this.d.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            this.d.a(list);
        }
    }

    public void setDefalutResid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.f.setDefaultResource(i);
        }
    }

    public void setIsHomePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.h = z;
        }
    }

    public void setIsNeedAlpAnima(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.m = z;
        }
    }

    public void setIsclearmode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.k = z;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bdUniqueId) == null) {
            HeadImageView headImageView = this.f;
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
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.l = z;
        }
    }

    public void k(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.f.J(str, i, 0, 0, z);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) {
            if (this.g) {
                int size = View.MeasureSpec.getSize(i);
                int i3 = (int) (size * 0.13f);
                int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
                ((RelativeLayout.LayoutParams) this.f.getLayoutParams()).setMargins(i3, size2, i3, size2);
                ImageView imageView = this.e;
                if (imageView != null) {
                    ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(i3, size2, i3, size2);
                }
            }
            super.onMeasure(i, i2);
        }
    }
}
