package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a63;
import com.repackage.ab3;
import com.repackage.bd3;
import com.repackage.hz2;
import com.repackage.i63;
import com.repackage.m83;
import com.repackage.oi2;
import com.repackage.uk2;
import com.repackage.yc3;
import com.repackage.zc3;
/* loaded from: classes2.dex */
public class DomainErrorView extends CommonEmptyView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hz2 c;
        public final /* synthetic */ DomainErrorView d;

        public a(DomainErrorView domainErrorView, String str, String str2, hz2 hz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {domainErrorView, str, str2, hz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = domainErrorView;
            this.a = str;
            this.b = str2;
            this.c = hz2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                oi2.u().b(this.c.x(), this.c.N(), this.c.Y(), zc3.u(this.a, this.b));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            boolean d = zc3.d(str, stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            setIcon(R.drawable.obfuscated_res_0x7f081195);
            setTitle(R.string.obfuscated_res_0x7f0f0152);
            ab3 ab3Var = new ab3();
            ab3Var.k(5L);
            ab3Var.i(41L);
            ab3Var.f("domain not in white list--" + stringBuffer2);
            hz2 a0 = hz2.a0();
            if (a0 != null) {
                String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f019e), bd3.D(), m83.i(uk2.U().M(), a0.X().G()), String.valueOf(ab3Var.a()));
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(d ? stringBuffer2 : format);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                setSubTitle(sb.toString());
                this.g.setVisibility(0);
                this.g.setOnClickListener(new a(this, format, stringBuffer2, a0));
            }
            this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f12b5));
            this.c.setPadding(yc3.g(70.0f), 0, yc3.g(70.0f), 0);
            String e = bd3.n().e();
            String a2 = bd3.v().a();
            i63 i63Var = new i63();
            i63Var.p(ab3Var);
            i63Var.q(a63.n(0));
            i63Var.m(hz2.f0());
            i63Var.l("errorDomain", stringBuffer2);
            i63Var.l("path", e);
            i63Var.l("prePath", a2);
            i63Var.l("curPath", bd3.n().a());
            a63.R(i63Var);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DomainErrorView(Context context, AttributeSet attributeSet, int i) {
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
    }
}
