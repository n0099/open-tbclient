package c.a.q0.s.l;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.h;
import c.a.e.e.p.j;
import c.a.q0.q0.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.service.ChangeSkinReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static b f14020j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AccountData f14021a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14022b;

    /* renamed from: c  reason: collision with root package name */
    public C0690b f14023c;

    /* renamed from: d  reason: collision with root package name */
    public int f14024d;

    /* renamed from: e  reason: collision with root package name */
    public int f14025e;

    /* renamed from: f  reason: collision with root package name */
    public int f14026f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14027g;

    /* renamed from: h  reason: collision with root package name */
    public int f14028h;

    /* renamed from: i  reason: collision with root package name */
    public ChangeSkinReceiver f14029i;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.k3.o0.a.a("", 7);
            }
        }
    }

    /* renamed from: c.a.q0.s.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0690b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b this$0;

        public C0690b(b bVar) {
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
            this.this$0 = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && this.this$0.E() && intent != null && "com.baidu.tieba.action.accountChange".equals(intent.getAction())) {
                Serializable serializableExtra = intent.getSerializableExtra("intent_data_accountData");
                if (serializableExtra instanceof AccountData) {
                    this.this$0.f14021a = (AccountData) serializableExtra;
                } else {
                    this.this$0.f14021a = null;
                }
                c.a.q0.j0.f.o(this.this$0.C());
                if (this.this$0.f14021a != null) {
                    c.a.q0.j0.f.n(this.this$0.f14021a.getBDUSS());
                    c.a.q0.j0.f.q(this.this$0.f14021a.getTbs());
                    c.a.q0.j0.f.p(this.this$0.f14021a.getStoken());
                }
            }
        }

        public /* synthetic */ C0690b(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14021a = null;
        this.f14022b = false;
        this.f14024d = 0;
        this.f14025e = 0;
        this.f14026f = 0;
        this.f14027g = true;
    }

    public static void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            h.a().b(new a());
            c.a.q0.s.d0.b.j().w("app_inverval", System.currentTimeMillis());
        }
    }

    public static void I(AccountData accountData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, accountData) == null) {
            String str2 = null;
            if (accountData != null) {
                str2 = accountData.getID();
                str = accountData.getAccount();
            } else {
                str = null;
            }
            String currentBduss = TbadkCoreApplication.getCurrentBduss();
            Intent intent = new Intent();
            intent.setAction("adp.bdstatisticsmanager.account_changed");
            intent.putExtra("intent_data_userid", str2);
            intent.putExtra("intent_data_username", str);
            intent.putExtra("intent_data_bduss", currentBduss);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            try {
                TbadkCoreApplication.getInst().sendStickyBroadcast(intent);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
            Intent intent2 = new Intent();
            intent2.setAction("com.baidu.tieba.action.accountChange");
            intent2.putExtra("intent_data_accountData", accountData);
            intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
            TbadkCoreApplication.getInst().sendBroadcast(intent2);
            c.a.q0.j0.f.o(!TextUtils.isEmpty(str2));
            if (accountData != null) {
                c.a.q0.j0.f.n(accountData.getBDUSS());
                c.a.q0.j0.f.q(accountData.getTbs());
                c.a.q0.j0.f.p(accountData.getStoken());
            }
        }
    }

    public static b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f14020j == null) {
                synchronized (b.class) {
                    if (f14020j == null) {
                        f14020j = new b();
                    }
                }
            }
            return f14020j;
        }
        return (b) invokeV.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !D(false) && E() && this.f14023c == null) {
            this.f14023c = new C0690b(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.action.accountChange");
            TbadkCoreApplication.getInst().registerReceiver(this.f14023c, intentFilter);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && E()) {
            this.f14029i = new ChangeSkinReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionChangeSkin());
            TbadkCoreApplication.getInst().registerReceiver(this.f14029i, intentFilter);
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String g2 = g();
            return g2 != null && g2.length() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean D(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) ? TbadkCoreApplication.getInst().isMainProcess(z) : invokeZ.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TbadkCoreApplication.getInst().isRemoteProcess() : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14027g : invokeV.booleanValue;
    }

    public void G(AccountData accountData, Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, accountData, application) == null) {
            BdLog.e("账号切换");
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            String p = j2.p("current_used_theme_" + g(), null);
            if (StringUtils.isNull(p)) {
                this.f14025e = 0;
            } else {
                String[] split = p.split("/");
                if (split != null && split.length >= 2) {
                    this.f14025e = c.a.e.e.m.b.e(split[0], 0);
                    c.a.e.e.m.b.e(split[1], 0);
                } else {
                    this.f14025e = 0;
                }
            }
            e();
            MessageManager.getInstance().sendMessageFromBackground(new CustomMessage(2005006, accountData));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005016, accountData));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2005019, accountData);
            MessageManager.getInstance().registerStickyMode(2005019);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TbSingleton.getInstance().onAccountChange();
        }
    }

    public void J(AccountData accountData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, accountData, str, str2) == null) {
            if (accountData == null && this.f14021a != null) {
                this.f14022b = true;
            } else if (this.f14021a == null && accountData != null) {
                this.f14022b = true;
            } else {
                AccountData accountData2 = this.f14021a;
                if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                    this.f14022b = true;
                }
            }
            if (this.f14021a == null && accountData != null) {
                this.f14021a = accountData;
            }
            if (this.f14021a == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f14021a.setBDUSS(str);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f14021a.setTbs(str2);
        }
    }

    public void K(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, accountData, context) == null) {
            String str = "set_application_account:";
            if (accountData == null) {
                str = "set_application_account:" + StringUtil.NULL_STRING;
            } else if (!StringUtils.isNull(accountData.getID()) && !StringUtils.isNull(accountData.getBDUSS())) {
                str = "set_application_account:valid_logined";
            } else if (!StringUtils.isNull(accountData.getBDUSS())) {
                str = "set_application_account:valid";
            } else if (!StringUtils.isNull(accountData.getID())) {
                str = "set_application_account:logined";
            }
            c.a.q0.s.z.a.a("account", -1L, 0, str, 0, "", new Object[0]);
            M(accountData, context);
        }
    }

    public void L(AccountData accountData, Context context) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, accountData, context) == null) {
            this.f14021a = accountData;
            String str3 = null;
            if (accountData != null) {
                str3 = accountData.getID();
                str2 = accountData.getAccount();
                str = accountData.getBDUSS();
            } else {
                str = null;
                str2 = null;
            }
            BdStatisticsManager.getInstance().setUser(str3, str2, str);
        }
    }

    public void M(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, accountData, context) == null) {
            if (!this.f14022b) {
                if (accountData == null && this.f14021a != null) {
                    this.f14022b = true;
                } else if (this.f14021a == null && accountData != null) {
                    this.f14022b = true;
                } else {
                    AccountData accountData2 = this.f14021a;
                    if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                        this.f14022b = true;
                    }
                }
            }
            this.f14021a = accountData;
            c.a.r0.k3.o0.a.n();
            if (context != null) {
                if (TbadkCoreApplication.getInst().isPushServiceOpen()) {
                    UtilHelper.startPushService(context);
                } else {
                    UtilHelper.stopPushService(context);
                }
            }
            I(accountData);
            if (this.f14022b) {
                G(accountData, TbadkCoreApplication.getInst());
                BdSocketLinkService.setHasAbsoluteClose(false);
                BdSocketLinkService.setAvailable(true);
                c.a.q0.f0.a.b(0, 0, 0, 1, 2);
                BdSocketLinkService.startService(true, "account changed");
            }
            MessageManager.getInstance().runTask(2004603, (Class) null);
            if (j.H() && accountData != null) {
                MessageManager.getInstance().runTask(2004611, (Class) null);
            }
            TbadkCoreApplication.getInst().setActivityPrizeData(null);
        }
    }

    public void N(int i2) {
        AccountData accountData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (accountData = this.f14021a) == null) {
            return;
        }
        accountData.setMemberType(i2);
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f14028h = v();
            H();
            P(i2);
            TbadkSettings.getInst().saveInt("skin_", i2);
            a(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001304, Integer.valueOf(i2)));
        }
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f14024d = i2;
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        synchronized (this) {
            if (this.f14021a != null) {
                this.f14021a.setTbs(str);
            }
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f14027g = z;
        }
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f14026f = i2;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            Intent intent = new Intent();
            intent.setAction(TbConfig.getBroadcastActionChangeSkin());
            intent.putExtra("skin_type", i2);
            TbadkCoreApplication.getInst().getContext().sendBroadcast(intent);
        }
    }

    public boolean d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, str, i2)) == null) {
            c.a.e.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.e("delete from cash_data where type=?", new String[]{String.valueOf(i2)});
            return mainDBDatabaseManager.e("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i2), "", str});
        }
        return invokeLI.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            TbSingleton.getInstance().clearVideoRecord();
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || str == null) {
            return;
        }
        c.a.e.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from cash_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from mark_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from draft_box where account=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from account_data where id=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from setting where account=?", new Object[]{str});
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            AccountData accountData = this.f14021a;
            if (accountData != null) {
                return accountData.getID();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String g2 = g();
            if (TextUtils.isEmpty(g2)) {
                AccountData e2 = c.e();
                return e2 != null ? e2.getID() : "";
            }
            return g2;
        }
        return (String) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            AccountData accountData = this.f14021a;
            if (accountData != null) {
                return c.a.e.e.m.b.g(accountData.getID(), 0L);
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public AccountData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f14021a : (AccountData) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            AccountData accountData = this.f14021a;
            if (accountData != null) {
                return accountData.getAccount();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            AccountData accountData = this.f14021a;
            if (accountData != null) {
                return accountData.getAccountNameShow();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public AccountData m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f14021a : (AccountData) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            AccountData m = m();
            if (m == null) {
                return null;
            }
            if (!TextUtils.isEmpty(m.getAvatar())) {
                return m.getAvatar();
            }
            return m.getPortrait();
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            AccountData accountData = this.f14021a;
            if (accountData != null) {
                return accountData.getBDUSS();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            AccountData accountData = this.f14021a;
            if (accountData != null) {
                return accountData.getMemberType();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            AccountData m = m();
            if (m == null) {
                return null;
            }
            return m.getPortrait();
        }
        return (String) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            AccountData accountData = this.f14021a;
            if (accountData == null || accountData.getVipInfo() == null) {
                return 0;
            }
            return this.f14021a.getVipInfo().getVipLevel();
        }
        return invokeV.intValue;
    }

    public String t(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048609, this, i2)) != null) {
            return (String) invokeI.objValue;
        }
        c.a.e.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor2 = null;
        try {
            cursor = mainDBDatabaseManager.j("select * from cash_data where type=? ", new String[]{String.valueOf(i2)});
            try {
                try {
                    String string = cursor.moveToFirst() ? cursor.getString(2) : null;
                    c.a.e.e.m.a.a(cursor);
                    return string;
                } catch (Exception e2) {
                    e = e2;
                    mainDBDatabaseManager.i(e, "getNoAccountData");
                    c.a.e.e.m.a.a(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                c.a.e.e.m.a.a(cursor2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            c.a.e.e.m.a.a(cursor2);
            throw th;
        }
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f14028h : invokeV.intValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f14024d : invokeV.intValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            AccountData accountData = this.f14021a;
            if (accountData != null) {
                return accountData.getTbs();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f14026f : invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f14025e : invokeV.intValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (D(true)) {
                try {
                    if (TbadkCoreApplication.getInst().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                        AccountData e2 = c.e();
                        if (e2 != null) {
                            c.a.q0.s.z.a.a("account", -1L, 0, "application_init_account", 0, "", new Object[0]);
                            K(e2, TbadkCoreApplication.getInst());
                        } else {
                            c.a.q0.s.z.a.a("account", -1L, 0, "application_init_no_account", 0, "", new Object[0]);
                        }
                    } else {
                        c.a.q0.s.z.a.a("account", -1L, 0, "application_bd_no_account", 0, "", new Object[0]);
                    }
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
                l.b().i(System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }
}
