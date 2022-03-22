package c.a.a0.l0.t;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import c.a.a0.s.s;
import c.a.a0.s.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NadExpressNaBaseView a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1501b;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1089888358, "Lc/a/a0/l0/t/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1089888358, "Lc/a/a0/l0/t/d$a;");
                    return;
                }
            }
            int[] iArr = new int[AdOperator.TYPE.values().length];
            a = iArr;
            try {
                iArr[AdOperator.TYPE.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdOperator.TYPE.CHECK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public d(NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nadExpressNaBaseView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nadExpressNaBaseView;
        this.f1501b = nadExpressNaBaseView.getContext();
    }

    public final boolean a(AdBaseModel adBaseModel, int i) {
        InterceptResult invokeLI;
        AdOperator adOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, adBaseModel, i)) == null) {
            if (adBaseModel == null || (adOperator = adBaseModel.f27545h) == null) {
                return false;
            }
            int i2 = a.a[adOperator.a.ordinal()];
            if (i2 != 1) {
                return i2 == 2 && i == 2;
            }
            t tVar = adBaseModel.i;
            return (tVar == null || !tVar.k) ? i == 1 : i == 3;
        }
        return invokeLI.booleanValue;
    }

    public final void b(View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, f2) == null) || view == null) {
            return;
        }
        c.a.a0.h0.t.a(view.getContext(), view, f2);
    }

    public c c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        AdOperator adOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel)) == null) {
            c operateBar = this.a.getOperateBar();
            if (c.d(adBaseModel) && (adOperator = adBaseModel.f27545h) != null) {
                if (operateBar == null || !a(adBaseModel, operateBar.a)) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0914bb);
                    relativeLayout.removeAllViews();
                    AdOperator.TYPE type = adOperator.a;
                    AdOperator.TYPE type2 = AdOperator.TYPE.DOWNLOAD;
                    if (type == type2) {
                        c.a.a0.s.c cVar = adBaseModel.l;
                        if (cVar == null || !cVar.f1535e) {
                            return null;
                        }
                        int i = R.layout.obfuscated_res_0x7f0d05c2;
                        s sVar = adBaseModel.p;
                        if (sVar != null && sVar.b(type2) != 0) {
                            i = adBaseModel.p.b(AdOperator.TYPE.DOWNLOAD);
                        }
                        t tVar = adBaseModel.i;
                        if (tVar != null && tVar.k) {
                            View inflate = LayoutInflater.from(this.f1501b).inflate(i, (ViewGroup) relativeLayout, true);
                            b(inflate.findViewById(R.id.obfuscated_res_0x7f0914ba), 6.0f);
                            return new e(3, inflate);
                        }
                        View inflate2 = LayoutInflater.from(this.f1501b).inflate(R.layout.obfuscated_res_0x7f0d05c4, (ViewGroup) relativeLayout, true);
                        b(inflate2.findViewById(R.id.obfuscated_res_0x7f0914ba), 6.0f);
                        return new g(1, inflate2);
                    }
                    AdOperator.TYPE type3 = AdOperator.TYPE.CHECK;
                    if (type == type3) {
                        int i2 = R.layout.obfuscated_res_0x7f0d05c3;
                        s sVar2 = adBaseModel.p;
                        if (sVar2 != null && sVar2.b(type3) != 0) {
                            i2 = adBaseModel.p.b(AdOperator.TYPE.CHECK);
                        }
                        View inflate3 = LayoutInflater.from(this.f1501b).inflate(i2, (ViewGroup) relativeLayout, true);
                        b(inflate3.findViewById(R.id.obfuscated_res_0x7f0914b9), 6.0f);
                        return new f(2, inflate3);
                    }
                    return null;
                }
                return operateBar;
            }
            return null;
        }
        return (c) invokeL.objValue;
    }
}
