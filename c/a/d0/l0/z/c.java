package c.a.d0.l0.z;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import c.a.d0.d.g;
import c.a.d0.s.s;
import c.a.d0.s.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NadExpressNaBaseView a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f3051b;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1648881630, "Lc/a/d0/l0/z/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1648881630, "Lc/a/d0/l0/z/c$a;");
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

    public c(NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nadExpressNaBaseView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nadExpressNaBaseView;
        this.f3051b = nadExpressNaBaseView.getContext();
    }

    public final boolean a(AdBaseModel adBaseModel, int i2) {
        InterceptResult invokeLI;
        AdOperator adOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, adBaseModel, i2)) == null) {
            if (adBaseModel == null || (adOperator = adBaseModel.f37260h) == null) {
                return false;
            }
            int i3 = a.a[adOperator.a.ordinal()];
            if (i3 != 1) {
                return i3 == 2 && i2 == 2;
            }
            t tVar = adBaseModel.f37261i;
            return (tVar == null || !tVar.k) ? i2 == 1 : i2 == 3;
        }
        return invokeLI.booleanValue;
    }

    public final void b(View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, f2) == null) || view == null) {
            return;
        }
        c.a.d0.h0.t.a(view.getContext(), view, f2);
    }

    public b c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        AdOperator adOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel)) == null) {
            b operateBar = this.a.getOperateBar();
            if (b.d(adBaseModel) && (adOperator = adBaseModel.f37260h) != null) {
                if (operateBar == null || !a(adBaseModel, operateBar.a)) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(c.a.d0.d.e.nad_feed_ad_operate_view);
                    relativeLayout.removeAllViews();
                    AdOperator.TYPE type = adOperator.a;
                    if (type == AdOperator.TYPE.DOWNLOAD) {
                        c.a.d0.s.c cVar = adBaseModel.l;
                        if (cVar == null || !cVar.f3078e) {
                            return null;
                        }
                        int i2 = g.nad_operate_app_info_view;
                        s sVar = adBaseModel.q;
                        if (sVar != null && sVar.b(AdOperator.TYPE.DOWNLOAD) != 0) {
                            i2 = adBaseModel.q.b(AdOperator.TYPE.DOWNLOAD);
                        }
                        t tVar = adBaseModel.f37261i;
                        if (tVar != null && tVar.k) {
                            View inflate = LayoutInflater.from(this.f3051b).inflate(i2, (ViewGroup) relativeLayout, true);
                            b(inflate.findViewById(c.a.d0.d.e.nad_feed_ad_operate_progress_button), 6.0f);
                            return new d(3, inflate);
                        }
                        View inflate2 = LayoutInflater.from(this.f3051b).inflate(g.nad_operate_download, (ViewGroup) relativeLayout, true);
                        b(inflate2.findViewById(c.a.d0.d.e.nad_feed_ad_operate_progress_button), 6.0f);
                        return new f(1, inflate2);
                    } else if (type == AdOperator.TYPE.CHECK) {
                        int i3 = g.nad_operate_command;
                        s sVar2 = adBaseModel.q;
                        if (sVar2 != null && sVar2.b(AdOperator.TYPE.CHECK) != 0) {
                            i3 = adBaseModel.q.b(AdOperator.TYPE.CHECK);
                        }
                        View inflate3 = LayoutInflater.from(this.f3051b).inflate(i3, (ViewGroup) relativeLayout, true);
                        b(inflate3.findViewById(c.a.d0.d.e.nad_feed_ad_operate_command_button), 6.0f);
                        return new e(2, inflate3);
                    } else {
                        return null;
                    }
                }
                return operateBar;
            }
            return null;
        }
        return (b) invokeL.objValue;
    }
}
