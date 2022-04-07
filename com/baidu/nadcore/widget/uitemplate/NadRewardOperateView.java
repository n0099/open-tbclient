package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a51;
import com.repackage.b51;
import com.repackage.ck0;
import com.repackage.ez0;
import com.repackage.hk0;
import com.repackage.ik0;
import com.repackage.mo0;
import com.repackage.qh0;
import com.repackage.r11;
import com.repackage.rj0;
import com.repackage.tn0;
import com.repackage.uk0;
/* loaded from: classes2.dex */
public class NadRewardOperateView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b51 a;
    public a51 b;
    public AdImageView c;
    public SimpleFeedAdInfoView d;
    public RelativeLayout e;
    public TextView f;
    public TextView g;
    public TextView h;
    public ck0 i;

    /* loaded from: classes2.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ NadRewardOperateView b;

        public a(NadRewardOperateView nadRewardOperateView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardOperateView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nadRewardOperateView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.e(this.a, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardOperateView a;

        public b(NadRewardOperateView nadRewardOperateView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardOperateView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardOperateView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i == null) {
                return;
            }
            this.a.i.p();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ik0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ NadRewardOperateView b;

        public c(NadRewardOperateView nadRewardOperateView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardOperateView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nadRewardOperateView;
            this.a = adBaseModel;
        }

        @Override // com.repackage.ik0
        public void a(rj0 rj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rj0Var) == null) {
                NadRewardOperateView nadRewardOperateView = this.b;
                if (nadRewardOperateView.b == null || !nadRewardOperateView.h(rj0Var, this.a)) {
                    return;
                }
                this.b.b.e(this.a);
            }
        }

        @Override // com.repackage.ik0
        public void b(rj0 rj0Var, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rj0Var, adDownloadCode) == null) {
                NadRewardOperateView nadRewardOperateView = this.b;
                if (nadRewardOperateView.b == null || !nadRewardOperateView.h(rj0Var, this.a)) {
                    return;
                }
                this.b.b.c(this.a);
            }
        }

        @Override // com.repackage.ik0
        public void c(rj0 rj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rj0Var) == null) {
                NadRewardOperateView nadRewardOperateView = this.b;
                if (nadRewardOperateView.b == null || !nadRewardOperateView.h(rj0Var, this.a)) {
                    return;
                }
                this.b.b.a(this.a);
            }
        }

        @Override // com.repackage.ik0
        public void d(rj0 rj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, rj0Var) == null) {
                NadRewardOperateView nadRewardOperateView = this.b;
                if (nadRewardOperateView.b == null || !nadRewardOperateView.h(rj0Var, this.a)) {
                    return;
                }
                this.b.b.c(this.a);
            }
        }

        @Override // com.repackage.ik0
        public void e(rj0 rj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, rj0Var) == null) {
                NadRewardOperateView nadRewardOperateView = this.b;
                if (nadRewardOperateView.b == null || !nadRewardOperateView.h(rj0Var, this.a)) {
                    return;
                }
                this.b.b.a(this.a);
            }
        }

        @Override // com.repackage.ik0
        public void f(rj0 rj0Var, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, rj0Var, f) == null) {
                NadRewardOperateView nadRewardOperateView = this.b;
                if (nadRewardOperateView.b == null || !nadRewardOperateView.h(rj0Var, this.a)) {
                    return;
                }
                this.b.b.g(this.a, f);
            }
        }

        @Override // com.repackage.ik0
        public void g(rj0 rj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, rj0Var) == null) {
                NadRewardOperateView nadRewardOperateView = this.b;
                if (nadRewardOperateView.b == null || !nadRewardOperateView.h(rj0Var, this.a)) {
                    return;
                }
                this.b.b.b(this.a);
            }
        }

        @Override // com.repackage.ik0
        public void h(rj0 rj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, rj0Var) == null) {
                NadRewardOperateView nadRewardOperateView = this.b;
                if (nadRewardOperateView.b == null || !nadRewardOperateView.h(rj0Var, this.a)) {
                    return;
                }
                this.b.b.f(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ NadRewardOperateView b;

        public d(NadRewardOperateView nadRewardOperateView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardOperateView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nadRewardOperateView;
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qh0.c(this.a.h.d, this.b.getContext());
                ez0.b(new ClogBuilder().s(ClogBuilder.LogType.CLICK).n(this.a.f.d));
                b51 b51Var = this.b.a;
                if (b51Var != null) {
                    b51Var.b(this.a);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardOperateView(@NonNull Context context) {
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

    public void d(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this);
        }
        if (!j()) {
            viewGroup.setVisibility(8);
            return;
        }
        viewGroup.addView(this);
        viewGroup.setVisibility(0);
    }

    public final void e(AdBaseModel adBaseModel, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel, str) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.t(ClogBuilder.LogType.FREE_CLICK.type);
            clogBuilder.q(ClogBuilder.Page.REWARD_VIDEO);
            if (!TextUtils.isEmpty(str)) {
                clogBuilder.h(str);
            }
            if (adBaseModel != null && !TextUtils.isEmpty(adBaseModel.f.d)) {
                clogBuilder.n(adBaseModel.f.d);
            }
            ez0.b(clogBuilder);
        }
    }

    public final void f(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || view2 == null) {
            return;
        }
        r11.a(view2.getContext(), view2, 6.0f);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05cc, (ViewGroup) this, true);
            this.c = (AdImageView) findViewById(R.id.obfuscated_res_0x7f0914d2);
            this.d = (SimpleFeedAdInfoView) findViewById(R.id.obfuscated_res_0x7f091a6a);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091a6b);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091a6c);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091a6e);
            this.e = relativeLayout;
            f(relativeLayout);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091a6d);
            this.h = textView;
            f(textView);
        }
    }

    public final boolean h(rj0 rj0Var, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        tn0 tn0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, rj0Var, adBaseModel)) == null) ? (rj0Var == null || adBaseModel == null || (tn0Var = adBaseModel.l) == null || !TextUtils.equals(rj0Var.g, tn0Var.c) || !TextUtils.equals(rj0Var.d(), tn0Var.d)) ? false : true : invokeLL.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        tn0 tn0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (getTag() instanceof AdBaseModel) && (adBaseModel = (AdBaseModel) getTag()) != null && (tn0Var = adBaseModel.l) != null && tn0Var.e : invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || adBaseModel.h == null) ? false : true : invokeV.booleanValue;
    }

    public final void k(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) || this.c == null) {
            return;
        }
        mo0 mo0Var = adBaseModel.i;
        if (mo0Var != null && !TextUtils.isEmpty(mo0Var.b)) {
            this.c.g(adBaseModel.i.b);
        } else if (TextUtils.isEmpty(adBaseModel.f.f)) {
        } else {
            this.c.g(adBaseModel.f.f);
        }
    }

    public final void l(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) || this.d == null) {
            return;
        }
        if (!i()) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        this.d.update(adBaseModel);
        this.d.setAfterListener(new a(this, adBaseModel));
    }

    public final void m(AdBaseModel adBaseModel) {
        AdOperator.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, adBaseModel) == null) || this.f == null) {
            return;
        }
        if (i() && adBaseModel.i != null) {
            this.f.setVisibility(8);
            return;
        }
        this.f.setTextColor(getContext().getResources().getColor(adBaseModel.b ? R.color.obfuscated_res_0x7f06027e : R.color.obfuscated_res_0x7f06024e));
        String str = null;
        AdOperator adOperator = adBaseModel.h;
        if (adOperator != null && (aVar = adOperator.b) != null) {
            str = aVar.a;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f.setVisibility(0);
            this.f.setText(str);
        } else {
            this.f.setVisibility(8);
        }
        String str2 = adBaseModel.f.g;
        if (!TextUtils.isEmpty(str2)) {
            this.g.setVisibility(0);
            this.g.setText(str2);
            return;
        }
        this.g.setVisibility(8);
    }

    public final void n(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, adBaseModel) == null) || this.h == null || adBaseModel.h == null) {
            return;
        }
        if (i()) {
            this.h.setVisibility(8);
            return;
        }
        this.h.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f06025c));
        if (this.h.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.h.getBackground()).setColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0602d8));
            ((GradientDrawable) this.h.getBackground()).setStroke(2, getContext().getResources().getColor(R.color.obfuscated_res_0x7f0602d9));
        } else {
            this.h.setBackground(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080dd4));
        }
        if (!TextUtils.isEmpty(adBaseModel.h.c)) {
            this.h.setText(adBaseModel.h.c);
        }
        if (!TextUtils.isEmpty(adBaseModel.h.d)) {
            this.h.setVisibility(0);
            this.h.setOnClickListener(new d(this, adBaseModel));
            return;
        }
        this.h.setVisibility(8);
    }

    public final void o(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, adBaseModel) == null) || this.e == null) {
            return;
        }
        if (!i()) {
            this.e.setVisibility(8);
            return;
        }
        hk0<?> a2 = uk0.a(this.e, IDownloadViewCreator.ViewType.REWARD_DOWNLOAD_VIEW);
        this.e.setVisibility(0);
        this.i = new ck0(rj0.b(adBaseModel), a2);
        this.e.setOnClickListener(new b(this));
        a51 a51Var = this.b;
        if (a51Var != null) {
            a51Var.d(adBaseModel);
        }
        this.i.s(new c(this, adBaseModel));
    }

    public void setFeedListener(b51 b51Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, b51Var) == null) {
            this.a = b51Var;
        }
    }

    public void setViewDownloadListener(a51 a51Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, a51Var) == null) {
            this.b = a51Var;
        }
    }

    public void update(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, adBaseModel) == null) {
            setTag(adBaseModel);
            if (!j()) {
                setVisibility(8);
                return;
            }
            k(adBaseModel);
            l(adBaseModel);
            m(adBaseModel);
            o(adBaseModel);
            n(adBaseModel);
            setVisibility(0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardOperateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardOperateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        g();
    }
}
