package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ip0;
import com.baidu.tieba.np0;
import com.baidu.tieba.u21;
import com.baidu.tieba.wo0;
import com.baidu.tieba.xz0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class NadExpressThreeImgOperateView extends NadExpressNaBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public int n;
    public int o;
    public int p;
    public AdImageView q;
    public AdImageView r;
    public AdImageView s;
    public int t;
    public int u;

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void m(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressThreeImgOperateView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (np0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadExpressThreeImgOperateView(Context context, AttributeSet attributeSet, int i, np0 np0Var) {
        super(context, attributeSet, i, np0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), np0Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (np0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.m = 15;
        this.n = 15;
        this.o = 0;
        this.p = 0;
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void j(LayoutInflater layoutInflater, np0 np0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, layoutInflater, np0Var) == null) {
            int i = R.layout.obfuscated_res_0x7f0d0617;
            if (np0Var != null) {
                if (np0Var.a(AdBaseModel.STYLE.THREE_IMAGE) != 0) {
                    i = np0Var.a(AdBaseModel.STYLE.THREE_IMAGE);
                }
                np0.a aVar = np0Var.j;
                if (aVar != null) {
                    this.m = aVar.a;
                    this.n = aVar.b;
                    this.o = aVar.c;
                    this.p = aVar.d;
                }
            }
            layoutInflater.inflate(i, this);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.q = (AdImageView) findViewById(R.id.obfuscated_res_0x7f0915ea);
            this.r = (AdImageView) findViewById(R.id.obfuscated_res_0x7f0915ec);
            this.s = (AdImageView) findViewById(R.id.obfuscated_res_0x7f0915eb);
            Resources resources = context.getResources();
            this.t = (((((u21.c.e(context) - u21.c.a(getContext(), this.m)) - u21.c.a(getContext(), this.n)) - u21.c.a(getContext(), this.o)) - u21.c.a(getContext(), this.p)) - (resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070051) * 2)) / 3;
            this.u = Math.round((this.t / ((int) resources.getDimension(R.dimen.obfuscated_res_0x7f070586))) * ((int) resources.getDimension(R.dimen.obfuscated_res_0x7f070585)));
            AdImageView adImageView = this.q;
            if (adImageView != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) adImageView.getLayoutParams();
                layoutParams.width = this.t;
                layoutParams.height = this.u;
                this.q.setLayoutParams(layoutParams);
            }
            AdImageView adImageView2 = this.r;
            if (adImageView2 != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) adImageView2.getLayoutParams();
                layoutParams2.width = this.t;
                layoutParams2.height = this.u;
                this.r.setLayoutParams(layoutParams2);
            }
            AdImageView adImageView3 = this.s;
            if (adImageView3 != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) adImageView3.getLayoutParams();
                layoutParams3.width = this.t;
                layoutParams3.height = this.u;
                this.s.setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void n(AdBaseModel adBaseModel) {
        AdImageView adImageView;
        AdImageView adImageView2;
        AdImageView adImageView3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, adBaseModel) != null) || !(adBaseModel instanceof ip0)) {
            return;
        }
        List list = ((ip0) adBaseModel).f.k;
        if (!xz0.g(list) && xz0.l(list) >= 3) {
            wo0 wo0Var = (wo0) xz0.d(list, 0);
            wo0 wo0Var2 = (wo0) xz0.d(list, 1);
            wo0 wo0Var3 = (wo0) xz0.d(list, 2);
            if (wo0Var != null && (adImageView3 = this.q) != null) {
                adImageView3.g(wo0Var.a);
            }
            if (wo0Var2 != null && (adImageView2 = this.r) != null) {
                adImageView2.g(wo0Var2.a);
            }
            if (wo0Var3 != null && (adImageView = this.s) != null) {
                adImageView.g(wo0Var3.a);
            }
        }
    }
}
