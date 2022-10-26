package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.dh3;
import com.baidu.tieba.eh3;
import com.baidu.tieba.fa3;
import com.baidu.tieba.ff3;
import com.baidu.tieba.gh3;
import com.baidu.tieba.m33;
import com.baidu.tieba.na3;
import com.baidu.tieba.rc3;
import com.baidu.tieba.tm2;
import com.baidu.tieba.zo2;
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
        public final /* synthetic */ m33 c;
        public final /* synthetic */ DomainErrorView d;

        public a(DomainErrorView domainErrorView, String str, String str2, m33 m33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {domainErrorView, str, str2, m33Var};
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
            this.c = m33Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                tm2.u().b(this.c.w(), this.c.O(), this.c.Z(), eh3.u(this.a, this.b));
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

    public void b(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            boolean d = eh3.d(str, stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            setIcon(R.drawable.obfuscated_res_0x7f0811b2);
            setTitle(R.string.obfuscated_res_0x7f0f0159);
            ff3 ff3Var = new ff3();
            ff3Var.k(5L);
            ff3Var.i(41L);
            ff3Var.f("domain not in white list--" + stringBuffer2);
            m33 b0 = m33.b0();
            if (b0 != null) {
                String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01a5), gh3.D(), rc3.i(zo2.U().M(), b0.Y().G()), String.valueOf(ff3Var.a()));
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                if (d) {
                    str2 = stringBuffer2;
                } else {
                    str2 = format;
                }
                sb.append(str2);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                setSubTitle(sb.toString());
                this.g.setVisibility(0);
                this.g.setOnClickListener(new a(this, format, stringBuffer2, b0));
            }
            this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f12de));
            this.c.setPadding(dh3.g(70.0f), 0, dh3.g(70.0f), 0);
            String e = gh3.n().e();
            String a2 = gh3.v().a();
            na3 na3Var = new na3();
            na3Var.p(ff3Var);
            na3Var.q(fa3.n(0));
            na3Var.m(m33.g0());
            na3Var.l("errorDomain", stringBuffer2);
            na3Var.l("path", e);
            na3Var.l("prePath", a2);
            na3Var.l("curPath", gh3.n().a());
            fa3.R(na3Var);
        }
    }
}
