package c.a.q0.z;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.h;
import c.a.d.f.p.n;
import c.a.q0.r.m.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.getUserInfo.GetUserInfoHttpResponseMessage;
import com.baidu.tbadk.getUserInfo.GetUserInfoRequstData;
import com.baidu.tbadk.getUserInfo.GetUserInfoSocketResponseMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static b f14109c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f14110d = true;
    public transient /* synthetic */ FieldHolder $fh;
    public UserData a;

    /* renamed from: b  reason: collision with root package name */
    public TbHttpMessageTask f14111b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14112e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14112e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GetUserInfoRequstData c2 = this.f14112e.c();
                c2.setNetType(NetMessage.NetType.HTTP);
                if (this.f14112e.f14111b != null) {
                    new HttpClient.a(c2.getHttpMessage(), this.f14112e.f14111b).execute(new HttpMessage[0]);
                }
            }
        }
    }

    /* renamed from: c.a.q0.z.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0905b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f14113e;

        public RunnableC0905b(b bVar, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14113e = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.g(this.f14113e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1522101800, "Lc/a/q0/z/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1522101800, "Lc/a/q0/z/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f14109c == null) {
                synchronized (b.class) {
                    if (f14109c == null) {
                        f14109c = new b();
                    }
                }
            }
            return f14109c;
        }
        return (b) invokeV.objValue;
    }

    public final GetUserInfoRequstData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetUserInfoRequstData getUserInfoRequstData = new GetUserInfoRequstData(CmdConfigHttp.CMD_GET_USER_INFO, 303024);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                getUserInfoRequstData.setUid(c.a.d.f.m.b.g(currentAccountObj.getID(), 0L));
            }
            getUserInfoRequstData.setScreenWidth(n.k(TbadkCoreApplication.getInst().getApp()));
            return getUserInfoRequstData;
        }
        return (GetUserInfoRequstData) invokeV.objValue;
    }

    public UserData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (UserData) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.y3.g0.a.h(303024, GetUserInfoSocketResponseMessage.class, false, false);
            TbHttpMessageTask c2 = c.a.r0.y3.g0.a.c(303024, CmdConfigHttp.CMD_GET_USER_INFO, TbConfig.GET_USER_INFO, GetUserInfoHttpResponseMessage.class, false, false, false, false);
            this.f14111b = c2;
            c2.setTimeOut(c.a.d.c.j.b.d().b());
            this.f14111b.setRetry(c.a.d.c.j.b.d().a());
            this.f14111b.setConnectTimeOut(c.a.d.c.j.b.d().c());
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            new Thread(new a(this)).start();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f14110d) {
                g();
                f14110d = false;
                return;
            }
            MessageManager.getInstance().sendMessage(c());
        }
    }

    public void i(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, userData) == null) {
            this.a = userData;
            if (userData == null) {
                return;
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = new AccountData();
            }
            if (!StringUtils.isNull(userData.getUserName())) {
                currentAccountObj.setAccount(userData.getUserName());
            }
            if (!StringUtils.isNull(userData.getPortrait())) {
                currentAccountObj.setPortrait(userData.getPortrait());
            }
            currentAccountObj.setSex(userData.getSex());
            currentAccountObj.setMemberType(userData.getIsMem());
            currentAccountObj.setVipInfo(userData.getUserVipInfo());
            currentAccountObj.setPersonalBgUrl(userData.getBg_pic());
            if (userData.getGodUserData() != null) {
                currentAccountObj.setGodType(userData.getGodUserData().getType());
            }
            if (userData.getNewGodData() != null) {
                currentAccountObj.setNewGodStatus(userData.getNewGodData().getStatus());
            }
            if (!TextUtils.isEmpty(userData.getUk())) {
                currentAccountObj.setUk(userData.getUk());
            }
            currentAccountObj.setIsBigV(userData.isBigV());
            currentAccountObj.setNameShow(userData.getName_show());
            TbadkCoreApplication.getInst().setDefaultBubble(userData.getBimg_url());
            PayMemberInfoData payMemberInfoData = userData.getPayMemberInfoData();
            if (currentAccountObj.getVipInfo() != null) {
                currentAccountObj.setMemberIconUrl(currentAccountObj.getVipInfo().getVipIconUrl());
            } else {
                currentAccountObj.setMemberIconUrl(null);
            }
            CloseAdData closeAdData = userData.getCloseAdData();
            if (closeAdData != null) {
                currentAccountObj.setMemberCloseAdIsOpen(closeAdData.w());
                currentAccountObj.setMemberCloseAdVipClose(closeAdData.x());
            }
            currentAccountObj.setUserIcons(userData.getIconInfo());
            currentAccountObj.setIsSelectTail(userData.getIsSelectTail());
            h.a().c(new RunnableC0905b(this, currentAccountObj));
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247, payMemberInfoData));
        }
    }
}
