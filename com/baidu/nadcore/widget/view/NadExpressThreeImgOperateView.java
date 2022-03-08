package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import c.a.b0.h0.f;
import c.a.b0.s.d;
import c.a.b0.s.n;
import c.a.b0.s.s;
import c.a.b0.x.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class NadExpressThreeImgOperateView extends NadExpressNaBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f36065h;

    /* renamed from: i  reason: collision with root package name */
    public int f36066i;

    /* renamed from: j  reason: collision with root package name */
    public int f36067j;
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
    public void initInflate(LayoutInflater layoutInflater, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, layoutInflater, sVar) == null) {
            int i2 = R.layout.nad_tpl_triple_image;
            if (sVar != null) {
                if (sVar.a(AdBaseModel.STYLE.THREE_IMAGE) != 0) {
                    i2 = sVar.a(AdBaseModel.STYLE.THREE_IMAGE);
                }
                s.a aVar = sVar.f1956j;
                if (aVar != null) {
                    this.f36065h = aVar.a;
                    this.f36066i = aVar.f1957b;
                    this.f36067j = aVar.f1958c;
                    this.k = aVar.f1959d;
                }
            }
            layoutInflater.inflate(i2, this);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void initLayout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.l = (AdImageView) findViewById(R.id.nad_feed_template_tripe_image_one_id);
            this.m = (AdImageView) findViewById(R.id.nad_feed_template_tripe_image_two_id);
            this.n = (AdImageView) findViewById(R.id.nad_feed_template_tripe_image_three_id);
            Resources resources = context.getResources();
            this.o = (((((f.c.e(context) - f.c.a(getContext(), this.f36065h)) - f.c.a(getContext(), this.f36066i)) - f.c.a(getContext(), this.f36067j)) - f.c.a(getContext(), this.k)) - (resources.getDimensionPixelSize(R.dimen.NAD_F_M_W_X024) * 2)) / 3;
            this.p = Math.round((this.o / ((int) resources.getDimension(R.dimen.nad_template_p1_w))) * ((int) resources.getDimension(R.dimen.nad_template_p1_h)));
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
        if ((interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) && (adBaseModel instanceof n)) {
            List<d> list = ((n) adBaseModel).f35661f.k;
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet, int i2, s sVar) {
        super(context, attributeSet, i2, sVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), sVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f36065h = 15;
        this.f36066i = 15;
        this.f36067j = 0;
        this.k = 0;
    }
}
