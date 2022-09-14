package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.dc3;
import com.baidu.tieba.fm2;
import com.baidu.tieba.lo2;
import com.baidu.tieba.pg3;
import com.baidu.tieba.qg3;
import com.baidu.tieba.r93;
import com.baidu.tieba.re3;
import com.baidu.tieba.sg3;
import com.baidu.tieba.y23;
import com.baidu.tieba.z93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
        public final /* synthetic */ y23 c;
        public final /* synthetic */ DomainErrorView d;

        public a(DomainErrorView domainErrorView, String str, String str2, y23 y23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {domainErrorView, str, str2, y23Var};
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
            this.c = y23Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                fm2.u().b(this.c.w(), this.c.O(), this.c.Z(), qg3.u(this.a, this.b));
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
            boolean d = qg3.d(str, stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            setIcon(R.drawable.obfuscated_res_0x7f08119c);
            setTitle(R.string.obfuscated_res_0x7f0f0159);
            re3 re3Var = new re3();
            re3Var.k(5L);
            re3Var.i(41L);
            re3Var.f("domain not in white list--" + stringBuffer2);
            y23 b0 = y23.b0();
            if (b0 != null) {
                String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01a5), sg3.D(), dc3.i(lo2.U().M(), b0.Y().G()), String.valueOf(re3Var.a()));
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(d ? stringBuffer2 : format);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                setSubTitle(sb.toString());
                this.g.setVisibility(0);
                this.g.setOnClickListener(new a(this, format, stringBuffer2, b0));
            }
            this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f12c9));
            this.c.setPadding(pg3.g(70.0f), 0, pg3.g(70.0f), 0);
            String e = sg3.n().e();
            String a2 = sg3.v().a();
            z93 z93Var = new z93();
            z93Var.p(re3Var);
            z93Var.q(r93.n(0));
            z93Var.m(y23.g0());
            z93Var.l("errorDomain", stringBuffer2);
            z93Var.l("path", e);
            z93Var.l("prePath", a2);
            z93Var.l("curPath", sg3.n().a());
            r93.R(z93Var);
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
