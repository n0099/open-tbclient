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
import c.a.a0.h0.t;
import c.a.a0.j.f.i;
import c.a.a0.j.f.j;
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
/* loaded from: classes4.dex */
public class NadRewardOperateView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.a0.l0.r.b a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.a0.l0.r.a f27826b;

    /* renamed from: c  reason: collision with root package name */
    public AdImageView f27827c;

    /* renamed from: d  reason: collision with root package name */
    public SimpleFeedAdInfoView f27828d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f27829e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27830f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f27831g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27832h;
    public c.a.a0.j.f.d i;

    /* loaded from: classes4.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f27833b;

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
            this.f27833b = nadRewardOperateView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f27833b.e(this.a, str);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.i == null) {
                return;
            }
            this.a.i.p();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f27834b;

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
            this.f27834b = nadRewardOperateView;
            this.a = adBaseModel;
        }

        @Override // c.a.a0.j.f.j
        public void a(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f27834b;
                if (nadRewardOperateView.f27826b == null || !nadRewardOperateView.h(aVar, this.a)) {
                    return;
                }
                this.f27834b.f27826b.e(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void b(c.a.a0.j.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                NadRewardOperateView nadRewardOperateView = this.f27834b;
                if (nadRewardOperateView.f27826b == null || !nadRewardOperateView.h(aVar, this.a)) {
                    return;
                }
                this.f27834b.f27826b.c(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void c(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f27834b;
                if (nadRewardOperateView.f27826b == null || !nadRewardOperateView.h(aVar, this.a)) {
                    return;
                }
                this.f27834b.f27826b.a(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void d(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f27834b;
                if (nadRewardOperateView.f27826b == null || !nadRewardOperateView.h(aVar, this.a)) {
                    return;
                }
                this.f27834b.f27826b.c(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void e(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f27834b;
                if (nadRewardOperateView.f27826b == null || !nadRewardOperateView.h(aVar, this.a)) {
                    return;
                }
                this.f27834b.f27826b.a(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void f(c.a.a0.j.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                NadRewardOperateView nadRewardOperateView = this.f27834b;
                if (nadRewardOperateView.f27826b == null || !nadRewardOperateView.h(aVar, this.a)) {
                    return;
                }
                this.f27834b.f27826b.g(this.a, f2);
            }
        }

        @Override // c.a.a0.j.f.j
        public void g(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f27834b;
                if (nadRewardOperateView.f27826b == null || !nadRewardOperateView.h(aVar, this.a)) {
                    return;
                }
                this.f27834b.f27826b.b(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void h(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f27834b;
                if (nadRewardOperateView.f27826b == null || !nadRewardOperateView.h(aVar, this.a)) {
                    return;
                }
                this.f27834b.f27826b.f(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f27835b;

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
            this.f27835b = nadRewardOperateView;
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.a0.g.c.c(this.a.f27545h.f27548d, this.f27835b.getContext());
                c.a.a0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CLICK).n(this.a.f27543f.f1549d));
                c.a.a0.l0.r.b bVar = this.f27835b.a;
                if (bVar != null) {
                    bVar.b(this.a);
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
            if (adBaseModel != null && !TextUtils.isEmpty(adBaseModel.f27543f.f1549d)) {
                clogBuilder.n(adBaseModel.f27543f.f1549d);
            }
            c.a.a0.a0.a.b(clogBuilder);
        }
    }

    public final void f(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || view == null) {
            return;
        }
        t.a(view.getContext(), view, 6.0f);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05ca, (ViewGroup) this, true);
            this.f27827c = (AdImageView) findViewById(R.id.obfuscated_res_0x7f0914d7);
            this.f27828d = (SimpleFeedAdInfoView) findViewById(R.id.obfuscated_res_0x7f091a7b);
            this.f27830f = (TextView) findViewById(R.id.obfuscated_res_0x7f091a7c);
            this.f27831g = (TextView) findViewById(R.id.obfuscated_res_0x7f091a7d);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091a7f);
            this.f27829e = relativeLayout;
            f(relativeLayout);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091a7e);
            this.f27832h = textView;
            f(textView);
        }
    }

    public final boolean h(c.a.a0.j.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.a0.s.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.l) == null || !TextUtils.equals(aVar.f1250g, cVar.f1533c) || !TextUtils.equals(aVar.d(), cVar.f1534d)) ? false : true : invokeLL.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        c.a.a0.s.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (getTag() instanceof AdBaseModel) && (adBaseModel = (AdBaseModel) getTag()) != null && (cVar = adBaseModel.l) != null && cVar.f1535e : invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || adBaseModel.f27545h == null) ? false : true : invokeV.booleanValue;
    }

    public final void k(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) || this.f27827c == null) {
            return;
        }
        c.a.a0.s.t tVar = adBaseModel.i;
        if (tVar != null && !TextUtils.isEmpty(tVar.f1586b)) {
            this.f27827c.g(adBaseModel.i.f1586b);
        } else if (TextUtils.isEmpty(adBaseModel.f27543f.f1551f)) {
        } else {
            this.f27827c.g(adBaseModel.f27543f.f1551f);
        }
    }

    public final void l(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) || this.f27828d == null) {
            return;
        }
        if (!i()) {
            this.f27828d.setVisibility(8);
            return;
        }
        this.f27828d.setVisibility(0);
        this.f27828d.update(adBaseModel);
        this.f27828d.setAfterListener(new a(this, adBaseModel));
    }

    public final void m(AdBaseModel adBaseModel) {
        AdOperator.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, adBaseModel) == null) || this.f27830f == null) {
            return;
        }
        if (i() && adBaseModel.i != null) {
            this.f27830f.setVisibility(8);
            return;
        }
        this.f27830f.setTextColor(getContext().getResources().getColor(adBaseModel.f27539b ? R.color.obfuscated_res_0x7f06027e : R.color.obfuscated_res_0x7f06024e));
        String str = null;
        AdOperator adOperator = adBaseModel.f27545h;
        if (adOperator != null && (aVar = adOperator.f27546b) != null) {
            str = aVar.a;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f27830f.setVisibility(0);
            this.f27830f.setText(str);
        } else {
            this.f27830f.setVisibility(8);
        }
        String str2 = adBaseModel.f27543f.f1552g;
        if (!TextUtils.isEmpty(str2)) {
            this.f27831g.setVisibility(0);
            this.f27831g.setText(str2);
            return;
        }
        this.f27831g.setVisibility(8);
    }

    public final void n(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, adBaseModel) == null) || this.f27832h == null || adBaseModel.f27545h == null) {
            return;
        }
        if (i()) {
            this.f27832h.setVisibility(8);
            return;
        }
        this.f27832h.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f06025c));
        if (this.f27832h.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.f27832h.getBackground()).setColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0602d8));
            ((GradientDrawable) this.f27832h.getBackground()).setStroke(2, getContext().getResources().getColor(R.color.obfuscated_res_0x7f0602d9));
        } else {
            this.f27832h.setBackground(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080dcb));
        }
        if (!TextUtils.isEmpty(adBaseModel.f27545h.f27547c)) {
            this.f27832h.setText(adBaseModel.f27545h.f27547c);
        }
        if (!TextUtils.isEmpty(adBaseModel.f27545h.f27548d)) {
            this.f27832h.setVisibility(0);
            this.f27832h.setOnClickListener(new d(this, adBaseModel));
            return;
        }
        this.f27832h.setVisibility(8);
    }

    public final void o(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, adBaseModel) == null) || this.f27829e == null) {
            return;
        }
        if (!i()) {
            this.f27829e.setVisibility(8);
            return;
        }
        i<?> a2 = c.a.a0.j.j.c.a(this.f27829e, IDownloadViewCreator.ViewType.REWARD_DOWNLOAD_VIEW);
        this.f27829e.setVisibility(0);
        this.i = new c.a.a0.j.f.d(c.a.a0.j.d.a.b(adBaseModel), a2);
        this.f27829e.setOnClickListener(new b(this));
        c.a.a0.l0.r.a aVar = this.f27826b;
        if (aVar != null) {
            aVar.d(adBaseModel);
        }
        this.i.r(new c(this, adBaseModel));
    }

    public void setFeedListener(c.a.a0.l0.r.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void setViewDownloadListener(c.a.a0.l0.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f27826b = aVar;
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
