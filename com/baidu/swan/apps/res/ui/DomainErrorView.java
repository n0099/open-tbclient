package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import c.a.n0.a.a2.e;
import c.a.n0.a.g1.f;
import c.a.n0.a.h;
import c.a.n0.a.j2.k;
import c.a.n0.a.j2.p.d;
import c.a.n0.a.m2.b;
import c.a.n0.a.v2.n0;
import c.a.n0.a.v2.o0;
import c.a.n0.a.v2.q0;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class DomainErrorView extends CommonEmptyView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46047e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46048f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f46049g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DomainErrorView f46050h;

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
            this.f46050h = domainErrorView;
            this.f46047e = str;
            this.f46048f = str2;
            this.f46049g = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.n0.a.c1.a.t().b(this.f46049g.x(), this.f46049g.D(), this.f46049g.O(), o0.u(this.f46047e, this.f46048f));
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
            setIcon(c.a.n0.a.e.aiapps_empty_icon_error);
            setTitle(h.aiapps_emptyview_domain_error_title);
            c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
            aVar.j(5L);
            aVar.h(41L);
            aVar.e("domain not in white list--" + stringBuffer2);
            e Q = e.Q();
            if (Q != null) {
                String format = String.format(getContext().getResources().getString(h.aiapps_open_failed_detail_format), q0.D(), b.i(f.V().N(), Q.N().G()), String.valueOf(aVar.a()));
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(d2 ? stringBuffer2 : format);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                setSubTitle(sb.toString());
                this.mFeedbackBtn.setVisibility(0);
                this.mFeedbackBtn.setOnClickListener(new a(this, format, stringBuffer2, Q));
            }
            this.mTitle.setText(getResources().getText(h.swanapp_domain_error));
            this.mSubTitle.setPadding(n0.g(70.0f), 0, n0.g(70.0f), 0);
            String h2 = q0.n().h();
            String d3 = q0.v().d();
            d dVar = new d();
            dVar.p(aVar);
            dVar.q(k.m(0));
            dVar.m(e.V());
            dVar.l("errorDomain", stringBuffer2);
            dVar.l("path", h2);
            dVar.l("prePath", d3);
            k.L(dVar);
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
