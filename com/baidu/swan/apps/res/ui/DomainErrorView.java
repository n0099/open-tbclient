package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import b.a.p0.a.a2.e;
import b.a.p0.a.g1.f;
import b.a.p0.a.h;
import b.a.p0.a.j2.k;
import b.a.p0.a.j2.p.d;
import b.a.p0.a.m2.b;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.o0;
import b.a.p0.a.v2.q0;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class DomainErrorView extends CommonEmptyView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43970f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f43971g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DomainErrorView f43972h;

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
            this.f43972h = domainErrorView;
            this.f43969e = str;
            this.f43970f = str2;
            this.f43971g = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.p0.a.c1.a.t().b(this.f43971g.x(), this.f43971g.k(), this.f43971g.N(), o0.u(this.f43969e, this.f43970f));
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
            setIcon(b.a.p0.a.e.aiapps_empty_icon_error);
            setTitle(h.aiapps_emptyview_domain_error_title);
            b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
            aVar.j(5L);
            aVar.h(41L);
            aVar.e("domain not in white list--" + stringBuffer2);
            e P = e.P();
            if (P != null) {
                String format = String.format(getContext().getResources().getString(h.aiapps_open_failed_detail_format), q0.D(), b.i(f.T().L(), P.M().F()), String.valueOf(aVar.a()));
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(d2 ? stringBuffer2 : format);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                setSubTitle(sb.toString());
                this.mFeedbackBtn.setVisibility(0);
                this.mFeedbackBtn.setOnClickListener(new a(this, format, stringBuffer2, P));
            }
            this.mTitle.setText(getResources().getText(h.swanapp_domain_error));
            this.mSubTitle.setPadding(n0.g(70.0f), 0, n0.g(70.0f), 0);
            String f2 = q0.n().f();
            String a2 = q0.v().a();
            d dVar = new d();
            dVar.p(aVar);
            dVar.q(k.m(0));
            dVar.m(e.U());
            dVar.l("errorDomain", stringBuffer2);
            dVar.l("path", f2);
            dVar.l("prePath", a2);
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
