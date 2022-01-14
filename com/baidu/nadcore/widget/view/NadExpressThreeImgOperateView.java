package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import c.a.c0.d.c;
import c.a.c0.d.e;
import c.a.c0.d.g;
import c.a.c0.g0.f;
import c.a.c0.s.d;
import c.a.c0.s.j;
import c.a.c0.s.o;
import c.a.c0.x.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public class NadExpressThreeImgOperateView extends NadExpressNaBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f37402h;

    /* renamed from: i  reason: collision with root package name */
    public int f37403i;

    /* renamed from: j  reason: collision with root package name */
    public int f37404j;
    public int k;
    @Nullable
    public AdImageView l;
    @Nullable
    public AdImageView m;
    @Nullable
    public AdImageView n;
    public int o;
    public int p;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressThreeImgOperateView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void initInflate(LayoutInflater layoutInflater, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, layoutInflater, oVar) == null) {
            int i2 = g.nad_tpl_triple_image;
            if (oVar != null) {
                if (oVar.a(AdBaseModel.STYLE.THREE_IMAGE) != 0) {
                    i2 = oVar.a(AdBaseModel.STYLE.THREE_IMAGE);
                }
                o.a aVar = oVar.f2259h;
                if (aVar != null) {
                    this.f37402h = aVar.a;
                    this.f37403i = aVar.f2261b;
                    this.f37404j = aVar.f2262c;
                    this.k = aVar.f2263d;
                }
            }
            layoutInflater.inflate(i2, this);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void initLayout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.l = (AdImageView) findViewById(e.nad_feed_template_tripe_image_one_id);
            this.m = (AdImageView) findViewById(e.nad_feed_template_tripe_image_two_id);
            this.n = (AdImageView) findViewById(e.nad_feed_template_tripe_image_three_id);
            Resources resources = context.getResources();
            this.o = (((((f.c.e(context) - f.c.a(getContext(), this.f37402h)) - f.c.a(getContext(), this.f37403i)) - f.c.a(getContext(), this.f37404j)) - f.c.a(getContext(), this.k)) - (resources.getDimensionPixelSize(c.NAD_F_M_W_X024) * 2)) / 3;
            this.p = Math.round((this.o / ((int) resources.getDimension(c.nad_template_p1_w))) * ((int) resources.getDimension(c.nad_template_p1_h)));
            AdImageView adImageView = this.l;
            if (adImageView != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) adImageView.getLayoutParams();
                layoutParams.width = this.o;
                layoutParams.height = this.p;
                this.l.setLayoutParams(layoutParams);
            }
            AdImageView adImageView2 = this.m;
            if (adImageView2 != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) adImageView2.getLayoutParams();
                layoutParams2.width = this.o;
                layoutParams2.height = this.p;
                this.m.setLayoutParams(layoutParams2);
            }
            AdImageView adImageView3 = this.n;
            if (adImageView3 != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) adImageView3.getLayoutParams();
                layoutParams3.width = this.o;
                layoutParams3.height = this.p;
                this.n.setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void updateSubViewData(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) {
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void updateSubViewUi(AdBaseModel adBaseModel) {
        AdImageView adImageView;
        AdImageView adImageView2;
        AdImageView adImageView3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) && (adBaseModel instanceof j)) {
            List<d> list = ((j) adBaseModel).f37016d.f2239h;
            if (a.g(list) || a.k(list) < 3) {
                return;
            }
            d dVar = (d) a.d(list, 0);
            d dVar2 = (d) a.d(list, 1);
            d dVar3 = (d) a.d(list, 2);
            if (dVar != null && (adImageView3 = this.l) != null) {
                adImageView3.displayImage(dVar.a);
            }
            if (dVar2 != null && (adImageView2 = this.m) != null) {
                adImageView2.displayImage(dVar2.a);
            }
            if (dVar3 == null || (adImageView = this.n) == null) {
                return;
            }
            adImageView.displayImage(dVar3.a);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (o) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet, int i2, o oVar) {
        super(context, attributeSet, i2, oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), oVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (o) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f37402h = 15;
        this.f37403i = 15;
        this.f37404j = 0;
        this.k = 0;
    }
}
