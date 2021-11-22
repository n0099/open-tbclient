package b.a.r0.i2.d;

import b.a.e.f.p.j;
import b.a.q0.s.l.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends b.a.q0.s.l.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f19421c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final a.InterfaceC0720a f19422b;

    /* renamed from: b.a.r0.i2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0981a implements a.InterfaceC0720a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0981a(a aVar) {
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
                }
            }
        }

        @Override // b.a.q0.s.l.a.InterfaceC0720a
        public void onBeforeLogin(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // b.a.q0.s.l.a.InterfaceC0720a
        public void onFailure(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) && i2 == 1) {
                ReloginManager.g().f(null);
            }
        }

        @Override // b.a.q0.s.l.a.InterfaceC0720a
        public void onSuccess(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921613));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-523570655, "Lb/a/r0/i2/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-523570655, "Lb/a/r0/i2/d/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19422b = new C0981a(this);
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f19421c == null) {
                f19421c = new a();
            }
            return f19421c;
        }
        return (a) invokeV.objValue;
    }

    @Override // b.a.q0.s.l.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0720a interfaceC0720a) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, str, str2, str3, str4, interfaceC0720a)) == null) ? b.a.r0.z1.b.a(str, str2, str3, str4, interfaceC0720a) : (BdAsyncTask) invokeLLLLL.objValue;
    }

    @Override // b.a.q0.s.l.a
    public a.b d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
            return (a.b) invokeL.objValue;
        }
        a.b bVar = null;
        if (str == null) {
            return null;
        }
        try {
            String[] split = str.split("[|]");
            if (split == null || split.length < 1) {
                return null;
            }
            a.b bVar2 = new a.b();
            try {
                bVar2.f13917a = split[0];
                if (split.length >= 2) {
                    bVar2.f13918b = split[1];
                }
                return bVar2;
            } catch (Exception e2) {
                e = e2;
                bVar = bVar2;
                BdLog.e(e.getMessage());
                return bVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @Override // b.a.q0.s.l.a
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && j.z()) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                a.b d2 = d(currentAccountObj.getBDUSS());
                if (d2 != null) {
                    b.a.r0.z1.b.a(currentAccountObj.getAccount(), d2.f13917a, d2.f13918b, currentAccountObj.getStoken(), this.f19422b);
                    return;
                }
                return;
            }
            b.a.q0.s.a0.a.a("account", -1L, 0, "main_tab_has_no_cache_account", 0, "", new Object[0]);
        }
    }
}
