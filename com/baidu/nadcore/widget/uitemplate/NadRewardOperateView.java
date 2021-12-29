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
import c.a.c0.b.e;
import c.a.c0.b.g;
import c.a.c0.d0.q;
import c.a.c0.g.f.i;
import c.a.c0.g.f.j;
import c.a.c0.p.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uitemplate.SimpleAdInfoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class NadRewardOperateView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdImageView f38596e;

    /* renamed from: f  reason: collision with root package name */
    public SimpleFeedAdInfoView f38597f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f38598g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f38599h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f38600i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f38601j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.c0.g.f.d f38602k;
    public c.a.c0.h0.c0.b mFeedListener;
    public c.a.c0.h0.c0.a mNadDownloadListener;

    /* loaded from: classes10.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f38603b;

        public a(NadRewardOperateView nadRewardOperateView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardOperateView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38603b = nadRewardOperateView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uitemplate.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f38603b.d(this.a, str);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f38604e;

        public b(NadRewardOperateView nadRewardOperateView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardOperateView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38604e = nadRewardOperateView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38604e.f38602k == null) {
                return;
            }
            this.f38604e.f38602k.o();
        }
    }

    /* loaded from: classes10.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f38605b;

        public c(NadRewardOperateView nadRewardOperateView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardOperateView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38605b = nadRewardOperateView;
            this.a = adBaseModel;
        }

        @Override // c.a.c0.g.f.j
        public void a(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f38605b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f38605b.mNadDownloadListener.e(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void b(c.a.c0.g.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                NadRewardOperateView nadRewardOperateView = this.f38605b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f38605b.mNadDownloadListener.c(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void c(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f38605b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f38605b.mNadDownloadListener.a(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void d(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f38605b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f38605b.mNadDownloadListener.c(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void e(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f38605b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f38605b.mNadDownloadListener.a(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void f(c.a.c0.g.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                NadRewardOperateView nadRewardOperateView = this.f38605b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f38605b.mNadDownloadListener.g(this.a, f2);
            }
        }

        @Override // c.a.c0.g.f.j
        public void g(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f38605b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f38605b.mNadDownloadListener.b(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void h(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f38605b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f38605b.mNadDownloadListener.f(this.a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f38606e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f38607f;

        public d(NadRewardOperateView nadRewardOperateView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardOperateView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38607f = nadRewardOperateView;
            this.f38606e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.c0.d.c.c(this.f38606e.f38221f.f38229d, this.f38607f.getContext());
                c.a.c0.x.a.b(new ClogBuilder().r(ClogBuilder.LogType.CLICK).m(this.f38606e.f38219d.f2227b));
                c.a.c0.h0.c0.b bVar = this.f38607f.mFeedListener;
                if (bVar != null) {
                    bVar.b(this.f38606e);
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

    public void bindContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this);
        }
        if (!i()) {
            viewGroup.setVisibility(8);
            return;
        }
        viewGroup.addView(this);
        viewGroup.setVisibility(0);
    }

    public final void d(AdBaseModel adBaseModel, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel, str) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.s(ClogBuilder.LogType.FREE_CLICK.type);
            clogBuilder.p(ClogBuilder.Page.REWARD_VIDEO);
            if (!TextUtils.isEmpty(str)) {
                clogBuilder.g(str);
            }
            if (adBaseModel != null && !TextUtils.isEmpty(adBaseModel.f38219d.f2227b)) {
                clogBuilder.m(adBaseModel.f38219d.f2227b);
            }
            c.a.c0.x.a.b(clogBuilder);
        }
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || view == null) {
            return;
        }
        q.a(view.getContext(), view, 6.0f);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(g.nad_reward_operate_view, (ViewGroup) this, true);
            this.f38596e = (AdImageView) findViewById(e.nad_reward_ad_app_icon);
            this.f38597f = (SimpleFeedAdInfoView) findViewById(e.reward_ad_operate_app_info_view);
            this.f38599h = (TextView) findViewById(e.reward_ad_operate_command_app_name);
            this.f38600i = (TextView) findViewById(e.reward_ad_operate_command_app_title);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.reward_ad_operate_progress_button);
            this.f38598g = relativeLayout;
            e(relativeLayout);
            TextView textView = (TextView) findViewById(e.reward_ad_operate_command_button);
            this.f38601j = textView;
            e(textView);
        }
    }

    public final boolean g(c.a.c0.g.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.c0.p.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.f38224i) == null || !TextUtils.equals(aVar.f1944g, cVar.f2213b) || !TextUtils.equals(aVar.d(), cVar.f2214c)) ? false : true : invokeLL.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        c.a.c0.p.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (getTag() instanceof AdBaseModel) && (adBaseModel = (AdBaseModel) getTag()) != null && (cVar = adBaseModel.f38224i) != null && cVar.f2215d : invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || adBaseModel.f38221f == null) ? false : true : invokeV.booleanValue;
    }

    public final void j(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) || this.f38596e == null) {
            return;
        }
        p pVar = adBaseModel.f38222g;
        if (pVar != null && !TextUtils.isEmpty(pVar.f2256b)) {
            this.f38596e.displayImage(adBaseModel.f38222g.f2256b);
        } else if (TextUtils.isEmpty(adBaseModel.f38219d.f2229d)) {
        } else {
            this.f38596e.displayImage(adBaseModel.f38219d.f2229d);
        }
    }

    public final void k(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) || this.f38597f == null) {
            return;
        }
        if (!h()) {
            this.f38597f.setVisibility(8);
            return;
        }
        this.f38597f.setVisibility(0);
        this.f38597f.update(adBaseModel);
        this.f38597f.setAfterListener(new a(this, adBaseModel));
    }

    public final void l(AdBaseModel adBaseModel) {
        AdOperator.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, adBaseModel) == null) || this.f38599h == null) {
            return;
        }
        if (h() && adBaseModel.f38222g != null) {
            this.f38599h.setVisibility(8);
            return;
        }
        this.f38599h.setTextColor(getContext().getResources().getColor(adBaseModel.f38217b ? c.a.c0.b.b.NAD_FC4 : c.a.c0.b.b.NAD_FC1));
        String str = null;
        AdOperator adOperator = adBaseModel.f38221f;
        if (adOperator != null && (aVar = adOperator.f38227b) != null) {
            str = aVar.a;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f38599h.setVisibility(0);
            this.f38599h.setText(str);
        } else {
            this.f38599h.setVisibility(8);
        }
        String str2 = adBaseModel.f38219d.f2230e;
        if (!TextUtils.isEmpty(str2)) {
            this.f38600i.setVisibility(0);
            this.f38600i.setText(str2);
            return;
        }
        this.f38600i.setVisibility(8);
    }

    public final void m(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, adBaseModel) == null) || this.f38601j == null || adBaseModel.f38221f == null) {
            return;
        }
        if (h()) {
            this.f38601j.setVisibility(8);
            return;
        }
        this.f38601j.setTextColor(getContext().getResources().getColor(c.a.c0.b.b.NAD_FC13));
        if (this.f38601j.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.f38601j.getBackground()).setColor(getContext().getResources().getColor(c.a.c0.b.b.NAD_GC52));
            ((GradientDrawable) this.f38601j.getBackground()).setStroke(2, getContext().getResources().getColor(c.a.c0.b.b.NAD_GC53));
        } else {
            this.f38601j.setBackground(getContext().getResources().getDrawable(c.a.c0.b.d.nad_progress_button_bg));
        }
        if (!TextUtils.isEmpty(adBaseModel.f38221f.f38228c)) {
            this.f38601j.setText(adBaseModel.f38221f.f38228c);
        }
        if (!TextUtils.isEmpty(adBaseModel.f38221f.f38229d)) {
            this.f38601j.setVisibility(0);
            this.f38601j.setOnClickListener(new d(this, adBaseModel));
            return;
        }
        this.f38601j.setVisibility(8);
    }

    public final void n(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, adBaseModel) == null) || this.f38598g == null) {
            return;
        }
        if (!h()) {
            this.f38598g.setVisibility(8);
            return;
        }
        i<?> a2 = c.a.c0.g.j.c.a(this.f38598g, IDownloadViewCreator.ViewType.REWARD_DOWNLOAD_VIEW);
        this.f38598g.setVisibility(0);
        this.f38602k = new c.a.c0.g.f.d(c.a.c0.g.d.a.b(adBaseModel), a2);
        this.f38598g.setOnClickListener(new b(this));
        c.a.c0.h0.c0.a aVar = this.mNadDownloadListener;
        if (aVar != null) {
            aVar.d(adBaseModel);
        }
        this.f38602k.q(new c(this, adBaseModel));
    }

    public void setFeedListener(c.a.c0.h0.c0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.mFeedListener = bVar;
        }
    }

    public void setViewDownloadListener(c.a.c0.h0.c0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.mNadDownloadListener = aVar;
        }
    }

    public void update(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, adBaseModel) == null) {
            setTag(adBaseModel);
            if (!i()) {
                setVisibility(8);
                return;
            }
            j(adBaseModel);
            k(adBaseModel);
            l(adBaseModel);
            n(adBaseModel);
            m(adBaseModel);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardOperateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        f();
    }
}
