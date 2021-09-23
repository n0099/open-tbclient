package c.a.r0.j3.o0;

import android.text.TextUtils;
import c.a.e.a.g;
import c.a.q0.s.s.a;
import c.a.q0.t.c.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f21003a;

    /* renamed from: b  reason: collision with root package name */
    public static List<Integer> f21004b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f21005e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f21006f;

        public a(c.a.q0.s.s.a aVar, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21005e = aVar;
            this.f21006f = lVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f21005e.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, this.f21006f));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f21007e;

        public b(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21007e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f21007e.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract void a(String str);

        public void b(l.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (cVar != null && cVar.f14694a) {
                    if (cVar instanceof l.a) {
                        a(((l.a) cVar).f14692b);
                        return;
                    } else if (cVar instanceof l.b) {
                        c(((l.b) cVar).f14693b);
                        return;
                    } else {
                        e();
                        return;
                    }
                }
                d();
            }
        }

        public abstract void c(String str);

        public abstract void d();

        public abstract void e();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(802219272, "Lc/a/r0/j3/o0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(802219272, "Lc/a/r0/j3/o0/f;");
                return;
            }
        }
        f21003a = new AtomicBoolean(false);
        f21004b = Arrays.asList(Integer.valueOf((int) NetWorkErr.ERROR_UEG_IDENTITY_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_PHONE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_MODIFY_PWD), Integer.valueOf((int) NetWorkErr.ERROR_UEG_FACE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_DOUBLE_CHECK), Integer.valueOf((int) NetWorkErr.ERROR_UEG_BIND_MOBILE));
    }

    public static boolean a(int i2, AuthTokenData authTokenData, c cVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i2, authTokenData, cVar)) == null) {
            if (f21004b.contains(Integer.valueOf(i2))) {
                if ((i2 == 3250020 || i2 == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken()))) {
                    return false;
                }
                return c(i2, authTokenData.getAuthToken(), cVar);
            }
            return false;
        }
        return invokeILL.booleanValue;
    }

    public static boolean b(int i2, String str, c cVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65538, null, i2, str, cVar)) == null) {
            if (f21004b.contains(Integer.valueOf(i2))) {
                if ((i2 == 3250020 || i2 == 3250021) && TextUtils.isEmpty(str)) {
                    return false;
                }
                return c(i2, str, cVar);
            }
            return false;
        }
        return invokeILL.booleanValue;
    }

    public static boolean c(int i2, String str, c cVar) {
        InterceptResult invokeILL;
        l a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65539, null, i2, str, cVar)) == null) {
            if (f21003a.compareAndSet(false, true)) {
                String.valueOf(System.currentTimeMillis());
                if (i2 == 3250022) {
                    l d2 = l.d();
                    d2.h(cVar);
                    if (cVar != null) {
                        cVar.d();
                    }
                    if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(TbadkCoreApplication.getInst().getCurrentActivity());
                        aVar.setMessageId(R.string.anti_account_modifypwd_tip);
                        aVar.setPositiveButton(R.string.modify_pwd, new a(aVar, d2));
                        aVar.setNegativeButton(R.string.cancel, new b(aVar));
                        if (TbadkCoreApplication.getInst().getCurrentActivity() instanceof g) {
                            aVar.create(((g) TbadkCoreApplication.getInst().getCurrentActivity()).getPageContext());
                            aVar.show();
                        }
                    }
                } else {
                    if (i2 == 3250017) {
                        a2 = l.b();
                    } else if (i2 == 3250023) {
                        a2 = l.c();
                    } else if (i2 == 3250024) {
                        a2 = new l(4, null);
                    } else {
                        a2 = l.a(str);
                    }
                    a2.h(cVar);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921372, a2));
                }
                f21003a.set(false);
                return true;
            }
            return false;
        }
        return invokeILL.booleanValue;
    }
}
