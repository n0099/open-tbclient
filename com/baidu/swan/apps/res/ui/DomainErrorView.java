package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import c.a.r0.a.d2.e;
import c.a.r0.a.g1.f;
import c.a.r0.a.h;
import c.a.r0.a.n2.n;
import c.a.r0.a.n2.s.d;
import c.a.r0.a.q2.b;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.o0;
import c.a.r0.a.z2.q0;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class DomainErrorView extends CommonEmptyView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f39075e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f39076f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f39077g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DomainErrorView f39078h;

        public a(DomainErrorView domainErrorView, String str, String str2, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {domainErrorView, str, str2, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39078h = domainErrorView;
            this.f39075e = str;
            this.f39076f = str2;
            this.f39077g = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.a.c1.a.u().b(this.f39077g.x(), this.f39077g.N(), this.f39077g.Y(), o0.u(this.f39075e, this.f39076f));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DomainErrorView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void showError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            boolean d2 = o0.d(str, stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            setIcon(c.a.r0.a.e.swanapp_error_page_general_tips);
            setTitle(h.aiapps_emptyview_domain_error_title);
            c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
            aVar.k(5L);
            aVar.i(41L);
            aVar.f("domain not in white list--" + stringBuffer2);
            e a0 = e.a0();
            if (a0 != null) {
                String format = String.format(getContext().getResources().getString(h.aiapps_open_failed_detail_format), q0.D(), b.i(f.U().M(), a0.X().G()), String.valueOf(aVar.a()));
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(d2 ? stringBuffer2 : format);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                setSubTitle(sb.toString());
                this.mFeedbackBtn.setVisibility(0);
                this.mFeedbackBtn.setOnClickListener(new a(this, format, stringBuffer2, a0));
            }
            this.mTitle.setText(getResources().getText(h.swanapp_domain_error));
            this.mSubTitle.setPadding(n0.g(70.0f), 0, n0.g(70.0f), 0);
            String f2 = q0.n().f();
            String a2 = q0.v().a();
            d dVar = new d();
            dVar.p(aVar);
            dVar.q(n.n(0));
            dVar.m(e.f0());
            dVar.l("errorDomain", stringBuffer2);
            dVar.l("path", f2);
            dVar.l("prePath", a2);
            dVar.l("curPath", q0.n().a());
            n.R(dVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DomainErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DomainErrorView(Context context, AttributeSet attributeSet, int i2) {
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
    }
}
