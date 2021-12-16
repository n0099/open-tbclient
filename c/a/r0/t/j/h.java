package c.a.r0.t.j;

import android.os.Build;
import android.text.TextUtils;
import c.a.d.c.f.j;
import c.a.d.f.p.m;
import c.a.d.f.r.k;
import c.a.r0.s.l;
import c.a.r0.s.m.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.switchs.NetDeleteSwitch;
import com.baidu.tbadk.switchs.NetTypeFixedSwitch;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.Map;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static h f13960f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.c.e.c.k.a f13961b;

    /* renamed from: c  reason: collision with root package name */
    public UpdateClientInfoMessage f13962c;

    /* renamed from: d  reason: collision with root package name */
    public int f13963d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.d.c.e.c.k.a f13964e;

    /* loaded from: classes6.dex */
    public class a implements c.a.d.c.e.c.k.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // c.a.d.c.e.c.k.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.f13961b == null) {
                return;
            }
            this.a.f13961b.a(str);
        }

        @Override // c.a.d.c.e.c.k.a
        public boolean b(int i2, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
                c.a.r0.f0.a.b(0, 2, 0, 0, 0);
                if (this.a.f13961b != null) {
                    this.a.f13961b.b(i2, str);
                }
                return false;
            }
            return invokeIL.booleanValue;
        }

        @Override // c.a.d.c.e.c.k.a
        public void c(c.a.d.f.r.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || this.a.f13961b == null) {
                return;
            }
            this.a.f13961b.c(cVar);
        }

        @Override // c.a.d.c.e.c.k.a
        public void d(k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) || this.a.f13961b == null) {
                return;
            }
            this.a.f13961b.d(kVar);
        }

        @Override // c.a.d.c.e.c.k.a
        public void g(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
                c.a.r0.f0.a.b(0, 1, 0, 0, 0);
                if (this.a.f13961b != null) {
                    this.a.f13961b.g(map);
                }
                c.a.d.c.e.c.i.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
                if (c.a.r0.r0.k.d().g() && h.b(this.a) < 10) {
                    c.a.d.c.e.c.i.e();
                }
                c.a.r0.f0.a.b(1001, 0, 0, 3, 0);
                h hVar = this.a;
                hVar.f13962c = hVar.i();
                MessageManager.getInstance().sendMessage(this.a.f13962c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.c.f.g
        /* renamed from: c */
        public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
            InterceptResult invokeL;
            long j2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage)) == null) {
                if (!(socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    this.a.o(socketResponsedMessage.getCmd(), -1, null);
                    return null;
                }
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (responseOnlineMessage.getOrginalMessage() == null || !(responseOnlineMessage.getOrginalMessage() instanceof SocketMessage)) {
                    j2 = 0;
                    i2 = 0;
                } else {
                    i2 = ((SocketMessage) responseOnlineMessage.getOrginalMessage()).getSquencedId();
                    j2 = ((SocketMessage) responseOnlineMessage.getOrginalMessage()).getClientLogID();
                }
                if (responseOnlineMessage.getError() != 0) {
                    this.a.o(socketResponsedMessage.getCmd(), responseOnlineMessage.getError(), responseOnlineMessage.getErrorString());
                    c.a.d.c.e.c.i.b("TbOnline", socketResponsedMessage.getCmd(), j2, i2, "online_failed", responseOnlineMessage.getError(), responseOnlineMessage.getErrorString() + "online failed. count-" + this.a.a);
                    return null;
                }
                this.a.m();
                c.a.d.c.e.c.i.b("TbOnline", socketResponsedMessage.getCmd(), j2, i2, "online_succ", 0, "online succ. retry count-" + this.a.a);
                return socketResponsedMessage;
            }
            return (SocketResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-134981154, "Lc/a/r0/t/j/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-134981154, "Lc/a/r0/t/j/h;");
        }
    }

    public h() {
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
        this.f13961b = null;
        this.f13962c = null;
        this.f13963d = 0;
        this.f13964e = new a(this);
        MessageManager.getInstance().addResponsedMessageRule(new b(this, 1001));
    }

    public static /* synthetic */ int b(h hVar) {
        int i2 = hVar.f13963d + 1;
        hVar.f13963d = i2;
        return i2;
    }

    public static synchronized h j() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (h.class) {
                if (f13960f == null) {
                    synchronized (h.class) {
                        if (f13960f == null) {
                            f13960f = new h();
                        }
                    }
                }
                hVar = f13960f;
            }
            return hVar;
        }
        return (h) invokeV.objValue;
    }

    public final UpdateClientInfoMessage i() {
        InterceptResult invokeV;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            UpdateClientInfoMessage updateClientInfoMessage = new UpdateClientInfoMessage();
            updateClientInfoMessage.addUserInfo(HttpRequest.CLIENT_TYPE, "2");
            updateClientInfoMessage.addUserInfo("_client_version", TbConfig.getVersion());
            if (TbadkCoreApplication.getInst().getImei() != null) {
                updateClientInfoMessage.addUserInfo(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
            }
            String clientId = TbadkCoreApplication.getClientId();
            if (clientId != null) {
                updateClientInfoMessage.addUserInfo(HttpRequest.CLIENT_ID, clientId);
            }
            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                updateClientInfoMessage.addUserInfo(HttpRequest.SUBAPP_TYPE, TbConfig.getSubappType());
            }
            String from = TbadkCoreApplication.getFrom();
            if (from != null && from.length() > 0) {
                updateClientInfoMessage.addUserInfo("from", from);
            }
            if (NetTypeFixedSwitch.isOn()) {
                updateClientInfoMessage.addUserInfo("net_type", String.valueOf(c.a.d.f.p.k.I()));
            } else {
                String str = new NetWork().getNetContext().getRequest().getNetWorkParam().mNetType;
                if (str != null) {
                    updateClientInfoMessage.addUserInfo("net_type", str);
                }
            }
            if (!NetDeleteSwitch.isOn() && (valueOf = String.valueOf(c.a.d.f.p.k.I())) != null) {
                updateClientInfoMessage.addUserInfo("net", valueOf);
            }
            updateClientInfoMessage.addUserInfo("cuid", TbadkCoreApplication.getInst().getCuid());
            updateClientInfoMessage.addUserInfo("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            updateClientInfoMessage.addUserInfo("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            updateClientInfoMessage.addUserInfo(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
            updateClientInfoMessage.addUserInfo("model", Build.MODEL);
            updateClientInfoMessage.addUserInfo(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
            updateClientInfoMessage.addUserInfo("z_id", TbadkCoreApplication.getInst().getZid());
            updateClientInfoMessage.addUserInfo(BaseStatisContent.MAC, PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()));
            updateClientInfoMessage.addUserInfo("brand", Build.BRAND);
            updateClientInfoMessage.addUserInfo(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
            updateClientInfoMessage.addUserInfo("baiduid", TbSingleton.getInstance().getBaiduIdForAnti());
            updateClientInfoMessage.addUserInfo("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
            updateClientInfoMessage.addUserInfo("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
            updateClientInfoMessage.addUserInfo("swan_game_ver", TbadkCoreApplication.getInst().getSwan_game_ver());
            updateClientInfoMessage.addUserInfo(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(m.k(TbadkCoreApplication.getInst().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(m.i(TbadkCoreApplication.getInst().getApp())));
            updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
            if (c.a.r0.t.d.d.d().e() > 0) {
                updateClientInfoMessage.addUserInfo("_msg_status", "0");
            } else {
                updateClientInfoMessage.addUserInfo("_msg_status", "1");
            }
            updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(l.c().e()));
            String yunpushChannelId = TbadkCoreApplication.getInst().getYunpushChannelId();
            String str2 = "channel_id " + yunpushChannelId;
            if (!TextUtils.isEmpty(yunpushChannelId)) {
                updateClientInfoMessage.addUserInfo("channel_id", yunpushChannelId);
            }
            try {
                if (TbadkCoreApplication.isLogin()) {
                    a.b d2 = c.a.r0.s.m.a.b().d(TbadkCoreApplication.getCurrentBduss());
                    String a2 = c.a.r0.s.m.e.a(TbadkCoreApplication.getCurrentAccountInfo());
                    if (d2 != null) {
                        updateClientInfoMessage.setBduss(d2.a, a2);
                    } else {
                        updateClientInfoMessage.setBduss(TbadkCoreApplication.getCurrentBduss(), a2);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            int d3 = m.d(TbadkCoreApplication.getInst().getContext(), 70.0f);
            updateClientInfoMessage.setHeight(m.d(TbadkCoreApplication.getInst().getContext(), 70.0f));
            updateClientInfoMessage.setWidth(d3);
            if (c.a.r0.t.b.a.b().d()) {
                updateClientInfoMessage.setPub_env(Integer.valueOf(c.a.r0.t.b.a.b().c()));
            }
            if (TbSingleton.getInstance().isVisitPreviewServer()) {
                updateClientInfoMessage.setPub_env(Integer.valueOf(c.a.d.f.m.b.e(TbSingleton.getInstance().getPubEnvValue(), 0)));
            }
            updateClientInfoMessage.setSecretKey(c.a.d.c.e.c.j.d.a().c());
            updateClientInfoMessage.addUserInfo("pversion", "1.0.3");
            if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
                updateClientInfoMessage = TbadkCoreApplication.getInst().getCustomizedFilter().c(updateClientInfoMessage);
            }
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            updateClientInfoMessage.addUserInfo("q_type", String.valueOf(l.c().e()));
            updateClientInfoMessage.addUserInfo("scr_h", String.valueOf(m.i(inst)));
            updateClientInfoMessage.addUserInfo("scr_w", String.valueOf(m.k(inst)));
            updateClientInfoMessage.addUserInfo("scr_dip", String.valueOf(Double.valueOf(m.h(inst))));
            updateClientInfoMessage.addUserInfo("active_timestamp", TbSingleton.getInstance().getActiveTimeStamp() + "");
            updateClientInfoMessage.addUserInfo("first_install_time", TbSingleton.getInstance().getAppFirstInstallTime() + "");
            updateClientInfoMessage.addUserInfo(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, TbSingleton.getInstance().getAppLastUpdateTime() + "");
            updateClientInfoMessage.addUserInfo("event_day", TbSingleton.getInstance().getData());
            updateClientInfoMessage.addUserInfo("android_id", TbadkCoreApplication.getInst().getAndroidId());
            updateClientInfoMessage.addUserInfo(CommonUrlParamManager.PARAM_CMODE, PermissionUtil.isAgreePrivacyPolicy() ? "1" : "2");
            updateClientInfoMessage.addUserInfo("extra", c.a.r0.s.g0.b.j().p("key_sync_extra_field", ""));
            return updateClientInfoMessage;
        }
        return (UpdateClientInfoMessage) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().getSocketClient().G(this.f13964e);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a >= 5 : invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a = 0;
            MessageManager.getInstance().getSocketClient().I();
            NoNetworkView.updateUI();
            BdSocketLinkService.stopReConnStrategy("online succ");
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a++;
            if (l()) {
                BdSocketLinkService.setAvailable(false);
                NoNetworkView.updateUI();
            }
        }
    }

    public final void o(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) {
            n();
            BdSocketLinkService.close(8, "online error = " + i3);
        }
    }

    public void p(c.a.d.c.e.c.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f13961b = aVar;
        }
    }
}
