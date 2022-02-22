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
import c.a.d0.d.e;
import c.a.d0.d.g;
import c.a.d0.h0.t;
import c.a.d0.j.f.i;
import c.a.d0.j.f.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class NadRewardOperateView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdImageView f37630e;

    /* renamed from: f  reason: collision with root package name */
    public SimpleFeedAdInfoView f37631f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f37632g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f37633h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f37634i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f37635j;
    public c.a.d0.j.f.d k;
    public c.a.d0.l0.x.b mFeedListener;
    public c.a.d0.l0.x.a mNadDownloadListener;

    /* loaded from: classes11.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f37636b;

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
            this.f37636b = nadRewardOperateView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f37636b.d(this.a, str);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f37637e;

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
            this.f37637e = nadRewardOperateView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f37637e.k == null) {
                return;
            }
            this.f37637e.k.o();
        }
    }

    /* loaded from: classes11.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f37638b;

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
            this.f37638b = nadRewardOperateView;
            this.a = adBaseModel;
        }

        @Override // c.a.d0.j.f.j
        public void a(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f37638b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f37638b.mNadDownloadListener.e(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void b(c.a.d0.j.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                NadRewardOperateView nadRewardOperateView = this.f37638b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f37638b.mNadDownloadListener.c(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void c(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f37638b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f37638b.mNadDownloadListener.a(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void d(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f37638b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f37638b.mNadDownloadListener.c(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void e(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f37638b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f37638b.mNadDownloadListener.a(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void f(c.a.d0.j.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                NadRewardOperateView nadRewardOperateView = this.f37638b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f37638b.mNadDownloadListener.g(this.a, f2);
            }
        }

        @Override // c.a.d0.j.f.j
        public void g(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f37638b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f37638b.mNadDownloadListener.b(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void h(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                NadRewardOperateView nadRewardOperateView = this.f37638b;
                if (nadRewardOperateView.mNadDownloadListener == null || !nadRewardOperateView.g(aVar, this.a)) {
                    return;
                }
                this.f37638b.mNadDownloadListener.f(this.a);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f37639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NadRewardOperateView f37640f;

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
            this.f37640f = nadRewardOperateView;
            this.f37639e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d0.f.d.c(this.f37639e.f37260h.f37265d, this.f37640f.getContext());
                c.a.d0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CLICK).n(this.f37639e.f37258f.f3093d));
                c.a.d0.l0.x.b bVar = this.f37640f.mFeedListener;
                if (bVar != null) {
                    bVar.b(this.f37639e);
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
            if (adBaseModel != null && !TextUtils.isEmpty(adBaseModel.f37258f.f3093d)) {
                clogBuilder.n(adBaseModel.f37258f.f3093d);
            }
            c.a.d0.a0.a.b(clogBuilder);
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
            LayoutInflater.from(getContext()).inflate(g.nad_reward_operate_view, (ViewGroup) this, true);
            this.f37630e = (AdImageView) findViewById(e.nad_reward_ad_app_icon);
            this.f37631f = (SimpleFeedAdInfoView) findViewById(e.reward_ad_operate_app_info_view);
            this.f37633h = (TextView) findViewById(e.reward_ad_operate_command_app_name);
            this.f37634i = (TextView) findViewById(e.reward_ad_operate_command_app_title);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.reward_ad_operate_progress_button);
            this.f37632g = relativeLayout;
            e(relativeLayout);
            TextView textView = (TextView) findViewById(e.reward_ad_operate_command_button);
            this.f37635j = textView;
            e(textView);
        }
    }

    public final boolean g(c.a.d0.j.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.d0.s.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.l) == null || !TextUtils.equals(aVar.f2802g, cVar.f3076c) || !TextUtils.equals(aVar.d(), cVar.f3077d)) ? false : true : invokeLL.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        c.a.d0.s.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (getTag() instanceof AdBaseModel) && (adBaseModel = (AdBaseModel) getTag()) != null && (cVar = adBaseModel.l) != null && cVar.f3078e : invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || adBaseModel.f37260h == null) ? false : true : invokeV.booleanValue;
    }

    public final void j(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) || this.f37630e == null) {
            return;
        }
        c.a.d0.s.t tVar = adBaseModel.f37261i;
        if (tVar != null && !TextUtils.isEmpty(tVar.f3137b)) {
            this.f37630e.displayImage(adBaseModel.f37261i.f3137b);
        } else if (TextUtils.isEmpty(adBaseModel.f37258f.f3095f)) {
        } else {
            this.f37630e.displayImage(adBaseModel.f37258f.f3095f);
        }
    }

    public final void k(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) || this.f37631f == null) {
            return;
        }
        if (!h()) {
            this.f37631f.setVisibility(8);
            return;
        }
        this.f37631f.setVisibility(0);
        this.f37631f.update(adBaseModel);
        this.f37631f.setAfterListener(new a(this, adBaseModel));
    }

    public final void l(AdBaseModel adBaseModel) {
        AdOperator.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, adBaseModel) == null) || this.f37633h == null) {
            return;
        }
        if (h() && adBaseModel.f37261i != null) {
            this.f37633h.setVisibility(8);
            return;
        }
        this.f37633h.setTextColor(getContext().getResources().getColor(adBaseModel.f37254b ? c.a.d0.d.b.NAD_FC4 : c.a.d0.d.b.NAD_FC1));
        String str = null;
        AdOperator adOperator = adBaseModel.f37260h;
        if (adOperator != null && (aVar = adOperator.f37263b) != null) {
            str = aVar.a;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f37633h.setVisibility(0);
            this.f37633h.setText(str);
        } else {
            this.f37633h.setVisibility(8);
        }
        String str2 = adBaseModel.f37258f.f3096g;
        if (!TextUtils.isEmpty(str2)) {
            this.f37634i.setVisibility(0);
            this.f37634i.setText(str2);
            return;
        }
        this.f37634i.setVisibility(8);
    }

    public final void m(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, adBaseModel) == null) || this.f37635j == null || adBaseModel.f37260h == null) {
            return;
        }
        if (h()) {
            this.f37635j.setVisibility(8);
            return;
        }
        this.f37635j.setTextColor(getContext().getResources().getColor(c.a.d0.d.b.NAD_FC13));
        if (this.f37635j.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.f37635j.getBackground()).setColor(getContext().getResources().getColor(c.a.d0.d.b.NAD_GC52));
            ((GradientDrawable) this.f37635j.getBackground()).setStroke(2, getContext().getResources().getColor(c.a.d0.d.b.NAD_GC53));
        } else {
            this.f37635j.setBackground(getContext().getResources().getDrawable(c.a.d0.d.d.nad_progress_button_bg));
        }
        if (!TextUtils.isEmpty(adBaseModel.f37260h.f37264c)) {
            this.f37635j.setText(adBaseModel.f37260h.f37264c);
        }
        if (!TextUtils.isEmpty(adBaseModel.f37260h.f37265d)) {
            this.f37635j.setVisibility(0);
            this.f37635j.setOnClickListener(new d(this, adBaseModel));
            return;
        }
        this.f37635j.setVisibility(8);
    }

    public final void n(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, adBaseModel) == null) || this.f37632g == null) {
            return;
        }
        if (!h()) {
            this.f37632g.setVisibility(8);
            return;
        }
        i<?> a2 = c.a.d0.j.j.c.a(this.f37632g, IDownloadViewCreator.ViewType.REWARD_DOWNLOAD_VIEW);
        this.f37632g.setVisibility(0);
        this.k = new c.a.d0.j.f.d(c.a.d0.j.d.a.b(adBaseModel), a2);
        this.f37632g.setOnClickListener(new b(this));
        c.a.d0.l0.x.a aVar = this.mNadDownloadListener;
        if (aVar != null) {
            aVar.d(adBaseModel);
        }
        this.k.q(new c(this, adBaseModel));
    }

    public void setFeedListener(c.a.d0.l0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.mFeedListener = bVar;
        }
    }

    public void setViewDownloadListener(c.a.d0.l0.x.a aVar) {
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
