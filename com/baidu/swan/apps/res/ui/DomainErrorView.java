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
import com.repackage.ae3;
import com.repackage.be3;
import com.repackage.c73;
import com.repackage.cc3;
import com.repackage.de3;
import com.repackage.j03;
import com.repackage.k73;
import com.repackage.o93;
import com.repackage.qj2;
import com.repackage.wl2;
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
        public final /* synthetic */ j03 c;
        public final /* synthetic */ DomainErrorView d;

        public a(DomainErrorView domainErrorView, String str, String str2, j03 j03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {domainErrorView, str, str2, j03Var};
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
            this.c = j03Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qj2.u().b(this.c.x(), this.c.N(), this.c.Y(), be3.u(this.a, this.b));
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
            boolean d = be3.d(str, stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            setIcon(R.drawable.obfuscated_res_0x7f08116d);
            setTitle(R.string.obfuscated_res_0x7f0f014f);
            cc3 cc3Var = new cc3();
            cc3Var.k(5L);
            cc3Var.i(41L);
            cc3Var.f("domain not in white list--" + stringBuffer2);
            j03 a0 = j03.a0();
            if (a0 != null) {
                String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f019b), de3.D(), o93.i(wl2.U().M(), a0.X().G()), String.valueOf(cc3Var.a()));
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(d ? stringBuffer2 : format);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                setSubTitle(sb.toString());
                this.g.setVisibility(0);
                this.g.setOnClickListener(new a(this, format, stringBuffer2, a0));
            }
            this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1282));
            this.c.setPadding(ae3.g(70.0f), 0, ae3.g(70.0f), 0);
            String e = de3.n().e();
            String a2 = de3.v().a();
            k73 k73Var = new k73();
            k73Var.p(cc3Var);
            k73Var.q(c73.n(0));
            k73Var.m(j03.f0());
            k73Var.l("errorDomain", stringBuffer2);
            k73Var.l("path", e);
            k73Var.l("prePath", a2);
            k73Var.l("curPath", de3.n().a());
            c73.R(k73Var);
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
