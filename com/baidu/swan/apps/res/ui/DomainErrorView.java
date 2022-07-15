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
import com.repackage.a73;
import com.repackage.ac3;
import com.repackage.be3;
import com.repackage.h03;
import com.repackage.i73;
import com.repackage.m93;
import com.repackage.oj2;
import com.repackage.ul2;
import com.repackage.yd3;
import com.repackage.zd3;
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
        public final /* synthetic */ h03 c;
        public final /* synthetic */ DomainErrorView d;

        public a(DomainErrorView domainErrorView, String str, String str2, h03 h03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {domainErrorView, str, str2, h03Var};
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
            this.c = h03Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                oj2.u().b(this.c.w(), this.c.O(), this.c.Z(), zd3.u(this.a, this.b));
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
            boolean d = zd3.d(str, stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            setIcon(R.drawable.obfuscated_res_0x7f081106);
            setTitle(R.string.obfuscated_res_0x7f0f0154);
            ac3 ac3Var = new ac3();
            ac3Var.k(5L);
            ac3Var.i(41L);
            ac3Var.f("domain not in white list--" + stringBuffer2);
            h03 b0 = h03.b0();
            if (b0 != null) {
                String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01a0), be3.D(), m93.i(ul2.U().M(), b0.Y().G()), String.valueOf(ac3Var.a()));
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(d ? stringBuffer2 : format);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                setSubTitle(sb.toString());
                this.g.setVisibility(0);
                this.g.setOnClickListener(new a(this, format, stringBuffer2, b0));
            }
            this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f12bb));
            this.c.setPadding(yd3.g(70.0f), 0, yd3.g(70.0f), 0);
            String e = be3.n().e();
            String a2 = be3.v().a();
            i73 i73Var = new i73();
            i73Var.p(ac3Var);
            i73Var.q(a73.n(0));
            i73Var.m(h03.g0());
            i73Var.l("errorDomain", stringBuffer2);
            i73Var.l("path", e);
            i73Var.l("prePath", a2);
            i73Var.l("curPath", be3.n().a());
            a73.R(i73Var);
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
