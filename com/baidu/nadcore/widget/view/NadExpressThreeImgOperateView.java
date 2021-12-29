package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import c.a.c0.b.c;
import c.a.c0.b.e;
import c.a.c0.b.g;
import c.a.c0.d0.f;
import c.a.c0.p.d;
import c.a.c0.p.k;
import c.a.c0.p.o;
import c.a.c0.u.a;
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
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public AdImageView f38650h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public AdImageView f38651i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public AdImageView f38652j;

    /* renamed from: k  reason: collision with root package name */
    public int f38653k;
    public int l;

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
            if (oVar != null && oVar.a(AdBaseModel.STYLE.THREE_IMAGE) != 0) {
                i2 = oVar.a(AdBaseModel.STYLE.THREE_IMAGE);
            }
            layoutInflater.inflate(i2, this);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void initLayout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f38650h = (AdImageView) findViewById(e.nad_feed_template_tripe_image_one_id);
            this.f38651i = (AdImageView) findViewById(e.nad_feed_template_tripe_image_two_id);
            this.f38652j = (AdImageView) findViewById(e.nad_feed_template_tripe_image_three_id);
            Resources resources = context.getResources();
            this.f38653k = ((f.c.e(context) - (resources.getDimensionPixelSize(c.NAD_F_M_W_X001) * 2)) - (resources.getDimensionPixelSize(c.NAD_F_M_W_X024) * 2)) / 3;
            this.l = Math.round((this.f38653k / ((int) resources.getDimension(c.nad_template_p1_w))) * ((int) resources.getDimension(c.nad_template_p1_h)));
            AdImageView adImageView = this.f38650h;
            if (adImageView != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) adImageView.getLayoutParams();
                layoutParams.width = this.f38653k;
                layoutParams.height = this.l;
                this.f38650h.setLayoutParams(layoutParams);
            }
            AdImageView adImageView2 = this.f38651i;
            if (adImageView2 != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) adImageView2.getLayoutParams();
                layoutParams2.width = this.f38653k;
                layoutParams2.height = this.l;
                this.f38651i.setLayoutParams(layoutParams2);
            }
            AdImageView adImageView3 = this.f38652j;
            if (adImageView3 != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) adImageView3.getLayoutParams();
                layoutParams3.width = this.f38653k;
                layoutParams3.height = this.l;
                this.f38652j.setLayoutParams(layoutParams3);
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
        if ((interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) && (adBaseModel instanceof k)) {
            List<d> list = ((k) adBaseModel).f38219d.f2233h;
            if (a.g(list) || a.k(list) < 3) {
                return;
            }
            d dVar = (d) a.d(list, 0);
            d dVar2 = (d) a.d(list, 1);
            d dVar3 = (d) a.d(list, 2);
            if (dVar != null && (adImageView3 = this.f38650h) != null) {
                adImageView3.displayImage(dVar.a);
            }
            if (dVar2 != null && (adImageView2 = this.f38651i) != null) {
                adImageView2.displayImage(dVar2.a);
            }
            if (dVar3 == null || (adImageView = this.f38652j) == null) {
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
    }
}
