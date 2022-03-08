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
import c.a.b0.h0.t;
import c.a.b0.j.f.i;
import c.a.b0.j.f.j;
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

    /* renamed from: e  reason: collision with root package name */
    public AdImageView f36033e;

    /* renamed from: f  reason: collision with root package name */
    public SimpleFeedAdInfoView f36034f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f36035g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f36036h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f36037i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f36038j;
    public c.a.b0.j.f.d k;
    public c.a.b0.l0.p.b mFeedListener;
    public c.a.b0.l0.p.a mNadDownloadListener;

    /* loaded from: classes4.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f36039b;

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
            this.f36039b = nadRewardOperateView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f36039b.d(this.a, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f36040e;

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
            this.f36040e = nadRewardOperateView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f36040e.k == null) {
                return;
            }
            this.f36040e.k.o();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f36041b;

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
            this.f36041b = nadRewardOperateView;
            this.a = adBaseModel;
        }

        @Override // c.a.b0.j.f.j
        public void a(c.a.b0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f36041b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f36041b.mNadDownloadListener.e(this.a);
            }
        }

        @Override // c.a.b0.j.f.j
        public void b(c.a.b0.j.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                NadRewardOperateView nadRewardOperateView = this.f36041b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f36041b.mNadDownloadListener.c(this.a);
            }
        }

        @Override // c.a.b0.j.f.j
        public void c(c.a.b0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f36041b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f36041b.mNadDownloadListener.a(this.a);
            }
        }

        @Override // c.a.b0.j.f.j
        public void d(c.a.b0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f36041b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f36041b.mNadDownloadListener.c(this.a);
            }
        }

        @Override // c.a.b0.j.f.j
        public void e(c.a.b0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f36041b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f36041b.mNadDownloadListener.a(this.a);
            }
        }

        @Override // c.a.b0.j.f.j
        public void f(c.a.b0.j.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                NadRewardOperateView nadRewardOperateView = this.f36041b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f36041b.mNadDownloadListener.g(this.a, f2);
            }
        }

        @Override // c.a.b0.j.f.j
        public void g(c.a.b0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f36041b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f36041b.mNadDownloadListener.b(this.a);
            }
        }

        @Override // c.a.b0.j.f.j
        public void h(c.a.b0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f36041b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f36041b.mNadDownloadListener.f(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f36042e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f36043f;

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
            this.f36043f = nadRewardOperateView;
            this.f36042e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.b0.f.c.c(this.f36042e.f35663h.f35668d, this.f36043f.getContext());
                c.a.b0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CLICK).n(this.f36042e.f35661f.f1923d));
                c.a.b0.l0.p.b bVar = this.f36043f.mFeedListener;
                if (bVar != null) {
                    bVar.b(this.f36042e);
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
            clogBuilder.t(ClogBuilder.LogType.FREE_CLICK.type);
            clogBuilder.q(ClogBuilder.Page.REWARD_VIDEO);
            if (!TextUtils.isEmpty(str)) {
                clogBuilder.h(str);
            }
            if (adBaseModel != null && !TextUtils.isEmpty(adBaseModel.f35661f.f1923d)) {
                clogBuilder.n(adBaseModel.f35661f.f1923d);
            }
            c.a.b0.a0.a.b(clogBuilder);
        }
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || view == null) {
            return;
        }
        t.a(view.getContext(), view, 6.0f);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.nad_reward_operate_view, (ViewGroup) this, true);
            this.f36033e = (AdImageView) findViewById(R.id.nad_reward_ad_app_icon);
            this.f36034f = (SimpleFeedAdInfoView) findViewById(R.id.reward_ad_operate_app_info_view);
            this.f36036h = (TextView) findViewById(R.id.reward_ad_operate_command_app_name);
            this.f36037i = (TextView) findViewById(R.id.reward_ad_operate_command_app_title);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.reward_ad_operate_progress_button);
            this.f36035g = relativeLayout;
            e(relativeLayout);
            TextView textView = (TextView) findViewById(R.id.reward_ad_operate_command_button);
            this.f36038j = textView;
            e(textView);
        }
    }

    public final boolean g(c.a.b0.j.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.b0.s.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.l) == null || !TextUtils.equals(aVar.f1617g, cVar.f1906c) || !TextUtils.equals(aVar.d(), cVar.f1907d)) ? false : true : invokeLL.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        c.a.b0.s.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (getTag() instanceof AdBaseModel) && (adBaseModel = (AdBaseModel) getTag()) != null && (cVar = adBaseModel.l) != null && cVar.f1908e : invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || adBaseModel.f35663h == null) ? false : true : invokeV.booleanValue;
    }

    public final void j(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) || this.f36033e == null) {
            return;
        }
        c.a.b0.s.t tVar = adBaseModel.f35664i;
        if (tVar != null && !TextUtils.isEmpty(tVar.f1967b)) {
            this.f36033e.displayImage(adBaseModel.f35664i.f1967b);
        } else if (TextUtils.isEmpty(adBaseModel.f35661f.f1925f)) {
        } else {
            this.f36033e.displayImage(adBaseModel.f35661f.f1925f);
        }
    }

    public final void k(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) || this.f36034f == null) {
            return;
        }
        if (!h()) {
            this.f36034f.setVisibility(8);
            return;
        }
        this.f36034f.setVisibility(0);
        this.f36034f.update(adBaseModel);
        this.f36034f.setAfterListener(new a(this, adBaseModel));
    }

    public final void l(AdBaseModel adBaseModel) {
        AdOperator.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, adBaseModel) == null) || this.f36036h == null) {
            return;
        }
        if (h() && adBaseModel.f35664i != null) {
            this.f36036h.setVisibility(8);
            return;
        }
        this.f36036h.setTextColor(getContext().getResources().getColor(adBaseModel.f35657b ? R.color.NAD_FC4 : R.color.NAD_FC1));
        String str = null;
        AdOperator adOperator = adBaseModel.f35663h;
        if (adOperator != null && (aVar = adOperator.f35666b) != null) {
            str = aVar.a;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f36036h.setVisibility(0);
            this.f36036h.setText(str);
        } else {
            this.f36036h.setVisibility(8);
        }
        String str2 = adBaseModel.f35661f.f1926g;
        if (!TextUtils.isEmpty(str2)) {
            this.f36037i.setVisibility(0);
            this.f36037i.setText(str2);
            return;
        }
        this.f36037i.setVisibility(8);
    }

    public final void m(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, adBaseModel) == null) || this.f36038j == null || adBaseModel.f35663h == null) {
            return;
        }
        if (h()) {
            this.f36038j.setVisibility(8);
            return;
        }
        this.f36038j.setTextColor(getContext().getResources().getColor(R.color.NAD_FC13));
        if (this.f36038j.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.f36038j.getBackground()).setColor(getContext().getResources().getColor(R.color.NAD_GC52));
            ((GradientDrawable) this.f36038j.getBackground()).setStroke(2, getContext().getResources().getColor(R.color.NAD_GC53));
        } else {
            this.f36038j.setBackground(getContext().getResources().getDrawable(R.drawable.nad_progress_button_bg));
        }
        if (!TextUtils.isEmpty(adBaseModel.f35663h.f35667c)) {
            this.f36038j.setText(adBaseModel.f35663h.f35667c);
        }
        if (!TextUtils.isEmpty(adBaseModel.f35663h.f35668d)) {
            this.f36038j.setVisibility(0);
            this.f36038j.setOnClickListener(new d(this, adBaseModel));
            return;
        }
        this.f36038j.setVisibility(8);
    }

    public final void n(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, adBaseModel) == null) || this.f36035g == null) {
            return;
        }
        if (!h()) {
            this.f36035g.setVisibility(8);
            return;
        }
        i<?> a2 = c.a.b0.j.j.c.a(this.f36035g, IDownloadViewCreator.ViewType.REWARD_DOWNLOAD_VIEW);
        this.f36035g.setVisibility(0);
        this.k = new c.a.b0.j.f.d(c.a.b0.j.d.a.b(adBaseModel), a2);
        this.f36035g.setOnClickListener(new b(this));
        c.a.b0.l0.p.a aVar = this.mNadDownloadListener;
        if (aVar != null) {
            aVar.d(adBaseModel);
        }
        this.k.q(new c(this, adBaseModel));
    }

    public void setFeedListener(c.a.b0.l0.p.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.mFeedListener = bVar;
        }
    }

    public void setViewDownloadListener(c.a.b0.l0.p.a aVar) {
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
