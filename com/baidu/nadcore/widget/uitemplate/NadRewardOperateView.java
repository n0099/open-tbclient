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
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.am0;
import com.baidu.tieba.dl0;
import com.baidu.tieba.e11;
import com.baidu.tieba.hl0;
import com.baidu.tieba.iq0;
import com.baidu.tieba.jl0;
import com.baidu.tieba.k41;
import com.baidu.tieba.k81;
import com.baidu.tieba.l81;
import com.baidu.tieba.ni0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.qk0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class NadRewardOperateView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l81 a;
    public k81 b;
    public AdImageView c;
    public SimpleFeedAdInfoView d;
    public RelativeLayout e;
    public TextView f;
    public TextView g;
    public TextView h;
    public dl0 i;

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
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.b.e(this.a, str);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.i != null) {
                this.a.i.m();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements hl0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ qk0 b;
        public final /* synthetic */ NadRewardOperateView c;

        public c(NadRewardOperateView nadRewardOperateView, AdBaseModel adBaseModel, qk0 qk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardOperateView, adBaseModel, qk0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nadRewardOperateView;
            this.a = adBaseModel;
            this.b = qk0Var;
        }

        @Override // com.baidu.tieba.hl0
        public void a(AdDownloadStatus adDownloadStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, adDownloadStatus) == null) {
                int i = e.a[adDownloadStatus.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                NadRewardOperateView nadRewardOperateView = this.c;
                                if (nadRewardOperateView.b != null && nadRewardOperateView.h(this.a)) {
                                    this.c.b.a(this.a);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        NadRewardOperateView nadRewardOperateView2 = this.c;
                        if (nadRewardOperateView2.b != null && nadRewardOperateView2.h(this.a)) {
                            this.c.b.e(this.a);
                            return;
                        }
                        return;
                    }
                    NadRewardOperateView nadRewardOperateView3 = this.c;
                    if (nadRewardOperateView3.b != null && nadRewardOperateView3.h(this.a)) {
                        this.c.b.d(this.a);
                        return;
                    }
                    return;
                }
                NadRewardOperateView nadRewardOperateView4 = this.c;
                if (nadRewardOperateView4.b != null && nadRewardOperateView4.h(this.a)) {
                    this.c.b.f(this.a, this.b.i);
                }
            }
        }

        @Override // com.baidu.tieba.hl0
        public void b(AdDownloadCode adDownloadCode) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) {
                boolean z2 = true;
                if (adDownloadCode != AdDownloadCode.ERROR_FAST_CLICK) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.c.b == null) {
                    z2 = false;
                }
                if ((z & z2) && this.c.h(this.a)) {
                    this.c.b.b(this.a);
                }
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
                ni0.c(this.a.h.d, this.b.getContext());
                e11.b(new ClogBuilder().y(ClogBuilder.LogType.CLICK).p(this.a.f.d));
                l81 l81Var = this.b.a;
                if (l81Var != null) {
                    l81Var.b(this.a);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-913115250, "Lcom/baidu/nadcore/widget/uitemplate/NadRewardOperateView$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-913115250, "Lcom/baidu/nadcore/widget/uitemplate/NadRewardOperateView$e;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
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

    public final void k(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, adBaseModel) != null) || this.c == null) {
            return;
        }
        iq0 iq0Var = adBaseModel.i;
        if (iq0Var != null && !TextUtils.isEmpty(iq0Var.b)) {
            this.c.g(adBaseModel.i.b);
        } else if (!TextUtils.isEmpty(adBaseModel.f.f)) {
            this.c.g(adBaseModel.f.f);
        }
    }

    public final void l(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) != null) || this.d == null) {
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

    public void d(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, viewGroup) != null) || viewGroup == null) {
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

    public final void f(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) != null) || view2 == null) {
            return;
        }
        k41.a(view2.getContext(), view2, 6.0f);
    }

    public final boolean h(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        pp0 pp0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, adBaseModel)) == null) {
            if (adBaseModel == null || (pp0Var = adBaseModel.l) == null) {
                return false;
            }
            return pp0Var.e;
        }
        return invokeL.booleanValue;
    }

    public void setFeedListener(l81 l81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, l81Var) == null) {
            this.a = l81Var;
        }
    }

    public void setViewDownloadListener(k81 k81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, k81Var) == null) {
            this.b = k81Var;
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

    public final void e(AdBaseModel adBaseModel, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel, str) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.z(ClogBuilder.LogType.FREE_CLICK.type);
            clogBuilder.u(ClogBuilder.Page.REWARD_VIDEO);
            if (!TextUtils.isEmpty(str)) {
                clogBuilder.j(str);
            }
            if (adBaseModel != null && !TextUtils.isEmpty(adBaseModel.f.d)) {
                clogBuilder.p(adBaseModel.f.d);
            }
            e11.b(clogBuilder);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.nad_reward_operate_view, (ViewGroup) this, true);
            this.c = (AdImageView) findViewById(R.id.nad_reward_ad_app_icon);
            this.d = (SimpleFeedAdInfoView) findViewById(R.id.reward_ad_operate_app_info_view);
            this.f = (TextView) findViewById(R.id.reward_ad_operate_command_app_name);
            this.g = (TextView) findViewById(R.id.reward_ad_operate_command_app_title);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.reward_ad_operate_progress_button);
            this.e = relativeLayout;
            f(relativeLayout);
            TextView textView = (TextView) findViewById(R.id.reward_ad_operate_command_button);
            this.h = textView;
            f(textView);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        pp0 pp0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || (pp0Var = adBaseModel.l) == null || !pp0Var.e) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || adBaseModel.h == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void m(AdBaseModel adBaseModel) {
        int i;
        AdOperator.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, adBaseModel) != null) || this.f == null) {
            return;
        }
        if (i() && adBaseModel.i != null) {
            this.f.setVisibility(8);
            return;
        }
        if (adBaseModel.b) {
            i = R.color.NAD_FC4;
        } else {
            i = R.color.NAD_FC1;
        }
        this.f.setTextColor(getContext().getResources().getColor(i));
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
        if ((interceptable == null || interceptable.invokeL(1048586, this, adBaseModel) == null) && this.h != null && adBaseModel.h != null) {
            if (i()) {
                this.h.setVisibility(8);
                return;
            }
            this.h.setTextColor(getContext().getResources().getColor(R.color.NAD_FC13));
            if (this.h.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) this.h.getBackground()).setColor(getContext().getResources().getColor(R.color.NAD_GC52));
                ((GradientDrawable) this.h.getBackground()).setStroke(2, getContext().getResources().getColor(R.color.NAD_GC53));
            } else {
                this.h.setBackground(getContext().getResources().getDrawable(R.drawable.nad_progress_button_bg));
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
    }

    public final void o(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, adBaseModel) != null) || this.e == null) {
            return;
        }
        if (!i()) {
            this.e.setVisibility(8);
            return;
        }
        jl0<?> a2 = am0.a(this.e, IDownloadViewCreator.ViewType.REWARD_DOWNLOAD_VIEW);
        this.e.setVisibility(0);
        qk0 c2 = qk0.c(adBaseModel);
        this.i = new dl0(c2, a2);
        this.e.setOnClickListener(new b(this));
        k81 k81Var = this.b;
        if (k81Var != null) {
            k81Var.c(adBaseModel);
        }
        this.i.o(new c(this, adBaseModel, c2));
    }
}
