package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import c.a.c0.d.e;
import c.a.c0.d.g;
import c.a.c0.g0.f;
import c.a.c0.s.a;
import c.a.c0.s.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class NadExpressSingleImgOperateView extends NadExpressNaBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f37427h;

    /* renamed from: i  reason: collision with root package name */
    public int f37428i;

    /* renamed from: j  reason: collision with root package name */
    public int f37429j;
    public int k;
    @Nullable
    public AdImageView l;
    public a m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressSingleImgOperateView(Context context) {
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
            int i2 = g.nad_single_image;
            if (oVar != null) {
                int a = oVar.a(AdBaseModel.STYLE.SMALL_IMAGE);
                if (a != 0) {
                    i2 = a;
                } else if (oVar.f2253b) {
                    i2 = g.nad_single_image_for_img_right;
                }
                o.a aVar = oVar.f2259h;
                if (aVar != null) {
                    this.f37427h = aVar.a;
                    this.f37428i = aVar.f2261b;
                    this.f37429j = aVar.f2262c;
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
            AdImageView adImageView = (AdImageView) findViewById(e.nad_feed_template_single_image_id);
            this.l = adImageView;
            if (adImageView == null) {
                return;
            }
            int e2 = (((((f.c.e(context) - f.c.a(getContext(), this.f37427h)) - f.c.a(getContext(), this.f37428i)) - f.c.a(getContext(), this.f37429j)) - f.c.a(getContext(), this.k)) - (f.c.a(getContext(), 6.0f) * 2)) / 3;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.width = e2;
            layoutParams.height = Math.round((e2 / getResources().getInteger(c.a.c0.d.f.nad_list_small_image_width)) * getResources().getInteger(c.a.c0.d.f.nad_list_small_image_height));
            this.l.setLayoutParams(layoutParams);
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) && (adBaseModel instanceof a)) {
            a aVar = (a) adBaseModel;
            this.m = aVar;
            AdImageView adImageView = this.l;
            if (adImageView != null) {
                adImageView.displayImage(aVar.m.a);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressSingleImgOperateView(Context context, AttributeSet attributeSet) {
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
    public NadExpressSingleImgOperateView(Context context, AttributeSet attributeSet, int i2) {
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
    public NadExpressSingleImgOperateView(Context context, AttributeSet attributeSet, int i2, o oVar) {
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
        this.f37427h = 15;
        this.f37428i = 15;
        this.f37429j = 0;
        this.k = 0;
    }
}
