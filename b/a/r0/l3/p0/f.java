package b.a.r0.l3.p0;

import android.text.TextUtils;
import b.a.e.a.g;
import b.a.q0.s.s.a;
import b.a.q0.t.c.m;
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
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f20750a;

    /* renamed from: b  reason: collision with root package name */
    public static List<Integer> f20751b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f20752e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f20753f;

        public a(b.a.q0.s.s.a aVar, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20752e = aVar;
            this.f20753f = mVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20752e.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, this.f20753f));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f20754e;

        public b(b.a.q0.s.s.a aVar) {
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
            this.f20754e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20754e.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        public void b(m.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (cVar != null && cVar.f13815a) {
                    if (cVar instanceof m.a) {
                        a(((m.a) cVar).f13813b);
                        return;
                    } else if (cVar instanceof m.b) {
                        c(((m.b) cVar).f13814b);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1513755642, "Lb/a/r0/l3/p0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1513755642, "Lb/a/r0/l3/p0/f;");
                return;
            }
        }
        f20750a = new AtomicBoolean(false);
        f20751b = Arrays.asList(Integer.valueOf((int) NetWorkErr.ERROR_UEG_IDENTITY_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_PHONE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_MODIFY_PWD), Integer.valueOf((int) NetWorkErr.ERROR_UEG_FACE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_DOUBLE_CHECK), Integer.valueOf((int) NetWorkErr.ERROR_UEG_BIND_MOBILE));
    }

    public static boolean a(int i2, AuthTokenData authTokenData, c cVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i2, authTokenData, cVar)) == null) {
            if (f20751b.contains(Integer.valueOf(i2))) {
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
            if (f20751b.contains(Integer.valueOf(i2))) {
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
        m a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65539, null, i2, str, cVar)) == null) {
            if (f20750a.compareAndSet(false, true)) {
                String.valueOf(System.currentTimeMillis());
                if (i2 == 3250022) {
                    m d2 = m.d();
                    d2.g(cVar);
                    if (cVar != null) {
                        cVar.d();
                    }
                    if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(TbadkCoreApplication.getInst().getCurrentActivity());
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
                        a2 = m.b();
                    } else if (i2 == 3250023) {
                        a2 = m.c();
                    } else if (i2 == 3250024) {
                        a2 = new m(4, null);
                    } else {
                        a2 = m.a(str);
                    }
                    a2.g(cVar);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921372, a2));
                }
                f20750a.set(false);
                return true;
            }
            return false;
        }
        return invokeILL.booleanValue;
    }
}
