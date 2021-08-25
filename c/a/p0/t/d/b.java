package c.a.p0.t.d;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.p0.t.e.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.DealIntentActivity;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b o;
    public static Date p;
    public static Handler q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f14776a;

    /* renamed from: b  reason: collision with root package name */
    public int f14777b;

    /* renamed from: c  reason: collision with root package name */
    public int f14778c;

    /* renamed from: d  reason: collision with root package name */
    public int f14779d;

    /* renamed from: e  reason: collision with root package name */
    public int f14780e;

    /* renamed from: f  reason: collision with root package name */
    public int f14781f;

    /* renamed from: g  reason: collision with root package name */
    public int f14782g;

    /* renamed from: h  reason: collision with root package name */
    public int f14783h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.t.e.f f14784i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.t.e.f f14785j;
    public boolean k;
    public String l;
    public String m;
    public String n;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
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

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                b.g0().V(b.g0().B());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-815218456, "Lc/a/p0/t/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-815218456, "Lc/a/p0/t/d/b;");
                return;
            }
        }
        q = new a();
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
                return;
            }
        }
        this.f14777b = 0;
        this.f14778c = 0;
        this.f14779d = 0;
        this.f14780e = 0;
        this.f14781f = 0;
        this.f14782g = 0;
        this.f14783h = 0;
        this.f14784i = new c.a.p0.t.e.f();
        this.k = true;
        this.f14776a = TbadkCoreApplication.getInst().getApp();
    }

    public static boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d.d().x()) {
                Calendar calendar = Calendar.getInstance();
                int i2 = (calendar.get(11) * 60) + calendar.get(12);
                String[] split = d.d().g().split(":");
                int parseInt = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
                String[] split2 = d.d().f().split(":");
                int parseInt2 = (Integer.parseInt(split2[0]) * 60) + Integer.parseInt(split2[1]);
                if (parseInt < parseInt2) {
                    if (i2 < parseInt || i2 > parseInt2) {
                        return false;
                    }
                } else if (parseInt <= parseInt2) {
                    return false;
                } else {
                    if ((i2 < parseInt || i2 > 1439) && (i2 < 0 || i2 > parseInt2)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (p == null) {
                p = new Date();
                return true;
            }
            Date date = new Date();
            if (date.getTime() - p.getTime() < 10000) {
                return false;
            }
            p = date;
            return true;
        }
        return invokeV.booleanValue;
    }

    public static b g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (o == null) {
                o = new b();
            }
            return o;
        }
        return (b) invokeV.objValue;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14778c : invokeV.intValue;
    }

    public c.a.p0.t.e.f B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14785j : (c.a.p0.t.e.f) invokeV.objValue;
    }

    public int C(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 == 12 || i2 == 13 || i2 == 28) {
                return 2;
            }
            if (i2 != 29) {
                if (i2 != 2000) {
                    switch (i2) {
                        case 15:
                        case 18:
                        case 19:
                            return 2;
                        case 16:
                        case 17:
                            return 1;
                        default:
                            switch (i2) {
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                    return 3;
                                default:
                                    return 0;
                            }
                    }
                }
                return 2;
            }
            return 3;
        }
        return invokeI.intValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "3222425470" : (String) invokeV.objValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14777b + this.f14778c + this.f14779d + this.f14780e + this.f14782g + this.f14783h : invokeV.intValue;
    }

    public c.a.p0.t.e.f F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14784i : (c.a.p0.t.e.f) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent G(int i2, boolean z) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                Set<String> keySet = this.f14784i.h().keySet();
                if (keySet.iterator().hasNext()) {
                    str = keySet.iterator().next();
                    Intent intent = new Intent();
                    if (!UtilHelper.isFlyMeOs()) {
                        intent.setClass(this.f14776a, DealIntentActivity.class);
                    } else {
                        intent.setClass(this.f14776a, DealIntentService.class);
                    }
                    intent.putExtra(DealIntentService.KEY_CLASS, 5);
                    intent.putExtra("KeyOfNotiId", i2);
                    intent.putExtra("agree_me", this.f14777b);
                    intent.putExtra("at_me", this.f14779d);
                    intent.putExtra("reply_me", this.f14778c);
                    intent.putExtra("fans", this.f14782g);
                    intent.putExtra("chat", x());
                    intent.putExtra("group_msg", this.f14784i.j() - this.f14784i.l());
                    intent.putExtra("group_msg_validate", this.f14784i.q());
                    intent.putExtra("group_msg_updates", this.f14784i.n());
                    intent.putExtra("officialbar_msg", this.f14784i.u());
                    intent.putExtra("privateGid", str);
                    return intent;
                }
            }
            str = "";
            Intent intent2 = new Intent();
            if (!UtilHelper.isFlyMeOs()) {
            }
            intent2.putExtra(DealIntentService.KEY_CLASS, 5);
            intent2.putExtra("KeyOfNotiId", i2);
            intent2.putExtra("agree_me", this.f14777b);
            intent2.putExtra("at_me", this.f14779d);
            intent2.putExtra("reply_me", this.f14778c);
            intent2.putExtra("fans", this.f14782g);
            intent2.putExtra("chat", x());
            intent2.putExtra("group_msg", this.f14784i.j() - this.f14784i.l());
            intent2.putExtra("group_msg_validate", this.f14784i.q());
            intent2.putExtra("group_msg_updates", this.f14784i.n());
            intent2.putExtra("officialbar_msg", this.f14784i.u());
            intent2.putExtra("privateGid", str);
            return intent2;
        }
        return (Intent) invokeCommon.objValue;
    }

    public Intent H(f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.f14776a, DealIntentActivity.class);
            } else {
                intent.setClass(this.f14776a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 36);
            intent.putExtra("tab_id", 1);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public Intent I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.f14776a, DealIntentActivity.class);
            } else {
                intent.setClass(this.f14776a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 24);
            intent.putExtra("KeyOfNotiId", i2);
            intent.putExtra("gift_num", this.f14783h);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
            if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
                intent.putExtra("un", currentAccount);
                intent.putExtra("name", currentAccountName);
            }
            return intent;
        }
        return (Intent) invokeI.objValue;
    }

    public Intent J(f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.f14776a, DealIntentActivity.class);
            } else {
                intent.setClass(this.f14776a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 27);
            intent.putExtra("uid", aVar.f14869a);
            intent.putExtra("uname", aVar.f14873e);
            intent.putExtra("user_type", aVar.f14874f);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public Intent K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.f14776a, DealIntentActivity.class);
            } else {
                intent.setClass(this.f14776a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 35);
            intent.putExtra("KeyOfNotiId", i2);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
            if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
                intent.putExtra("un", currentAccount);
                intent.putExtra("name", currentAccountName);
            }
            return intent;
        }
        return (Intent) invokeI.objValue;
    }

    public Intent L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.f14776a, DealIntentActivity.class);
            } else {
                intent.setClass(this.f14776a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 14);
            intent.putExtra("group_msg_updates", this.f14784i.o());
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public boolean N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? "3222425470".equals(str) : invokeL.booleanValue;
    }

    public final void O(f.a aVar, int i2) {
        PendingIntent service;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, aVar, i2) == null) {
            Intent S = S(aVar);
            if (S != null && S.getDataString() != null && S.getDataString().contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                S.setFlags(276824064);
                NotificationHelper.showNotification(this.f14776a, i2, aVar.f14870b, aVar.f14871c, aVar.f14872d, PendingIntent.getActivity(this.f14776a, i2, S, 134217728), false);
                return;
            }
            if (S == null) {
                S = J(aVar);
            }
            if (S == null) {
                S = H(aVar);
            }
            if (S == null) {
                return;
            }
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.f14776a, i2, S, 134217728);
            } else {
                service = PendingIntent.getService(this.f14776a, i2, S, 134217728);
            }
            j(C(i2), i2);
            NotificationHelper.showNotification(this.f14776a, i2, aVar.f14870b, aVar.f14871c, aVar.f14872d, service, false);
        }
    }

    public final void P(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            Q(i2, str, str2, str3, false);
        }
    }

    public final void Q(int i2, String str, String str2, String str3, boolean z) {
        Intent G;
        PendingIntent service;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), str, str2, str3, Boolean.valueOf(z)}) == null) && this.k) {
            if (i2 == 23 && this.f14783h > 0) {
                G = I(i2);
            } else if (i2 == 26 && this.f14782g > 0) {
                G = K(i2);
            } else if (i2 == 18) {
                G = L();
            } else if (i2 == 24) {
                G = G(i2, z);
                G.putExtra("tab_id", 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i2 != 16 && i2 != 17 && i2 != 18) {
                G = G(i2, z);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                G = G(i2, z);
                G.putExtra("tab_id", 2);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            G.setFlags(268435456);
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.f14776a, i2, G, 134217728);
            } else {
                service = PendingIntent.getService(this.f14776a, i2, G, 134217728);
            }
            j(C(i2), i2);
            NotificationHelper.showNotification(this.f14776a, i2, str, str2, str3, service, false);
        }
    }

    public Intent S(f.a aVar) {
        InterceptResult invokeL;
        ImMessageCenterPojo i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, aVar)) == null) {
            if (aVar != null && (i2 = c.a.q0.j1.k.b.o().i(aVar.f14869a, aVar.f14874f)) != null && i2.getLast_content() != null) {
                try {
                    String lastTaskId = i2.getLastTaskId();
                    String lastServiceId = i2.getLastServiceId();
                    JSONArray jSONArray = new JSONArray(i2.getLastContentRawData());
                    if (jSONArray.length() != 1) {
                        return null;
                    }
                    String optString = ((JSONObject) jSONArray.get(0)).optString("url");
                    if (StringUtils.isNull(optString)) {
                        return null;
                    }
                    Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(optString);
                    if (matcher.find()) {
                        String group = matcher.group(1);
                        if (!StringUtils.isNull(group)) {
                            Intent intent = new Intent();
                            if (UtilHelper.isFlyMeOs()) {
                                intent.setClass(this.f14776a, DealIntentActivity.class);
                            } else {
                                intent.setClass(this.f14776a, DealIntentService.class);
                            }
                            intent.putExtra(DealIntentService.KEY_CLASS, 1);
                            intent.putExtra("id", group);
                            intent.putExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, true);
                            intent.putExtra("key_start_from", 7);
                            intent.putExtra("gid", aVar.f14869a);
                            intent.putExtra("task_id", lastTaskId);
                            intent.putExtra("service_id", lastServiceId);
                            return intent;
                        }
                    } else {
                        if (!optString.contains("mo/q/hotMessage") && !optString.contains("mo/q/newtopic")) {
                            if (optString.contains("open_wb_view=1")) {
                                Intent intent2 = new Intent();
                                if (UtilHelper.isFlyMeOs()) {
                                    intent2.setClass(this.f14776a, DealIntentActivity.class);
                                } else {
                                    intent2.setClass(this.f14776a, DealIntentService.class);
                                }
                                intent2.putExtra(DealIntentService.KEY_CLASS, 0);
                                intent2.putExtra("url", optString.trim());
                                intent2.putExtra("task_id", lastTaskId);
                                intent2.putExtra("service_id", lastServiceId);
                                return intent2;
                            } else if (optString.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                                return Intent.parseUri(optString, 1);
                            } else {
                                if (optString.contains(UrlSchemaHelper.SCHEMA_TYPE_SUB_PB)) {
                                    Intent intent3 = new Intent();
                                    if (UtilHelper.isFlyMeOs()) {
                                        intent3.setClass(this.f14776a, DealIntentActivity.class);
                                    } else {
                                        intent3.setClass(this.f14776a, DealIntentService.class);
                                    }
                                    intent3.putExtra(DealIntentService.KEY_CLASS, 39);
                                    String paramStr = UrlManager.getParamStr(optString);
                                    if (!TextUtils.isEmpty(paramStr)) {
                                        Map<String, String> paramPair = UrlManager.getParamPair(paramStr);
                                        if (!paramPair.isEmpty()) {
                                            String str = paramPair.get("tid");
                                            String str2 = paramPair.get("pid");
                                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                                intent3.putExtra("thread_id", str);
                                                intent3.putExtra("post_id", str2);
                                                return intent3;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        Intent intent4 = new Intent();
                        if (UtilHelper.isFlyMeOs()) {
                            intent4.setClass(this.f14776a, DealIntentActivity.class);
                        } else {
                            intent4.setClass(this.f14776a, DealIntentService.class);
                        }
                        intent4.putExtra(DealIntentService.KEY_CLASS, 30);
                        intent4.putExtra("jump_url", optString);
                        intent4.putExtra("task_id", lastTaskId);
                        intent4.putExtra("service_id", lastServiceId);
                        return intent4;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
        return (Intent) invokeL.objValue;
    }

    public final void T(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, newsNotifyMessage) == null) {
        }
    }

    public void U(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
            if (i2 == this.f14777b && i3 == this.f14778c && i4 == this.f14779d && i5 == this.f14780e && i6 == this.f14782g && i7 == this.f14781f && i8 == this.f14783h) {
                return;
            }
            int i14 = this.f14777b;
            int i15 = 2;
            int i16 = (i2 > i14 || i3 > (i12 = this.f14778c) || i4 > (i13 = this.f14779d) || i5 > this.f14780e || i6 > this.f14782g || i7 > this.f14781f || i8 > this.f14783h) ? 1 : (i2 < i14 || i3 < i12 || i4 < i13) ? 2 : 0;
            if (i2 <= this.f14777b || !d.d().w()) {
                i9 = i2 < this.f14777b ? 2 : 0;
            } else {
                i9 = 1;
            }
            if (i3 <= this.f14778c || !d.d().t()) {
                i10 = i3 < this.f14778c ? 2 : 0;
            } else {
                i10 = 1;
            }
            if (i4 <= this.f14779d || !d.d().o()) {
                i11 = i4 < this.f14779d ? 2 : 0;
            } else {
                i11 = 1;
            }
            int i17 = i5 > this.f14780e ? 1 : 0;
            int i18 = i6 > this.f14782g ? 1 : 0;
            int i19 = i8 > this.f14783h ? 1 : 0;
            this.f14777b = i2;
            this.f14778c = i3;
            this.f14779d = i4;
            this.f14780e = i5;
            this.f14782g = i6;
            this.f14781f = i7;
            this.f14783h = i8;
            if (E() <= 0) {
                i16 = 2;
                i18 = 2;
                i9 = 2;
                i10 = 2;
                i11 = 2;
                i17 = 2;
            } else {
                i15 = i19;
            }
            if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                return;
            }
            a();
            h0(i15, 23);
            h0(i17, 16);
            h0(i16, 17);
            h0(i10, 24);
            h0(i11, 25);
            h0(i18, 26);
            h0(i9, 29);
        }
    }

    public void V(c.a.p0.t.e.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f14784i = fVar;
        this.f14780e = (fVar.j() - fVar.l()) + fVar.w() + fVar.t() + fVar.s();
        b(fVar);
        int i2 = 0;
        if (fVar.z()) {
            this.f14785j = null;
            q.removeMessages(0);
        }
        if (fVar.z()) {
            if (d.d().n() && d.d().e() > 0) {
                i2 = fVar.j() - fVar.l();
            }
            long w = (!d.d().p() || d.d().e() <= 0) ? 0L : fVar.w();
            if ((i2 > 0 || w > 0) && ((i2 > fVar.m() - fVar.l() && i2 > 0) || w > fVar.x())) {
                i0(1, 16, fVar);
            }
            int u = fVar.u();
            if (u > 0 && u > fVar.v()) {
                i0(1, 19, fVar);
            }
            if (fVar.n() > fVar.p() || fVar.q() > fVar.r()) {
                if (fVar.n() > fVar.p() && fVar.q() == fVar.r() && k0()) {
                    return;
                }
                if (fVar.n() == fVar.p() && fVar.q() > fVar.r() && l0()) {
                    return;
                }
                i0(1, 17, fVar);
            }
        }
    }

    public void W(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            if (i2 == this.f14777b && i3 == this.f14778c && i4 == this.f14779d && i5 == this.f14780e && i6 == this.f14782g && this.f14783h == i7) {
                return;
            }
            this.f14777b = i2;
            this.f14778c = i3;
            this.f14779d = i4;
            this.f14780e = i5;
            this.f14782g = i6;
            this.f14783h = i7;
            a();
            if (E() <= 0) {
                h0(2, 16);
                h0(2, 17);
            }
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (z) {
                U(0, 0, 0, 0, 0, 0, 0);
                return;
            }
            this.f14777b = 0;
            this.f14778c = 0;
            this.f14779d = 0;
            this.f14780e = 0;
            this.f14782g = 0;
            this.f14781f = 0;
        }
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || i2 < 0) {
            return;
        }
        U(i2, this.f14778c, this.f14779d, this.f14780e, this.f14782g, this.f14781f, this.f14783h);
    }

    public void Z(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || i2 < 0) {
            return;
        }
        U(this.f14777b, this.f14778c, i2, this.f14780e, this.f14782g, this.f14781f, this.f14783h);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(u());
            newsNotifyMessage.setMsgAtme(v());
            newsNotifyMessage.setMsgBookmark(w());
            newsNotifyMessage.setMsgChat(t());
            newsNotifyMessage.setMsgFans(y());
            newsNotifyMessage.setMsgReplyme(A());
            newsNotifyMessage.setMsgGiftNum(z());
            newsNotifyMessage.setMsgPrivateChat(this.f14784i.w());
            newsNotifyMessage.setMsgStrangerChat(this.f14784i.y());
            newsNotifyMessage.setMsgOfficialMerge(this.f14784i.t());
            T(newsNotifyMessage);
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || i2 < 0) {
            return;
        }
        U(this.f14777b, this.f14778c, this.f14779d, this.f14780e, this.f14782g, i2, this.f14783h);
    }

    public void b(c.a.p0.t.e.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, fVar) == null) || fVar == null) {
            return;
        }
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(u());
        newsNotifyMessage.setMsgAtme(v());
        newsNotifyMessage.setMsgBookmark(w());
        newsNotifyMessage.setMsgChat(((((fVar.w() + fVar.j()) + fVar.y()) + fVar.t()) + fVar.s()) - fVar.l());
        newsNotifyMessage.setMsgFans(y());
        newsNotifyMessage.setMsgReplyme(A());
        newsNotifyMessage.setMsgGiftNum(z());
        newsNotifyMessage.setMsgPrivateChat(fVar.w());
        newsNotifyMessage.setMsgStrangerChat(fVar.y());
        newsNotifyMessage.setMsgOfficialMerge(fVar.t());
        T(newsNotifyMessage);
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void b0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || i2 < 0) {
            return;
        }
        U(this.f14777b, this.f14778c, this.f14779d, i2, this.f14782g, this.f14781f, this.f14783h);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            NotificationHelper.cancelNotification(this.f14776a, 16);
        }
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048605, this, i2) == null) || i2 < 0) {
            return;
        }
        U(this.f14777b, this.f14778c, this.f14779d, this.f14780e, i2, this.f14781f, this.f14783h);
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                c();
                return;
            }
            c.a.p0.t.e.f F = F();
            if (F == null) {
                c();
                return;
            }
            HashMap<String, String> a2 = F.a();
            if (a2 != null && !a2.isEmpty()) {
                if (a2.containsKey(str)) {
                    c();
                    return;
                }
                return;
            }
            c();
        }
    }

    public void d0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || i2 < 0) {
            return;
        }
        this.f14783h = i2;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            NotificationHelper.cancelNotification(this.f14776a, 17);
        }
    }

    public void e0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i2) == null) || i2 < 0) {
            return;
        }
        U(this.f14777b, i2, this.f14779d, this.f14780e, this.f14782g, this.f14781f, this.f14783h);
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            c.a.p0.t.e.f F = F();
            if (F == null) {
                e();
            } else if (1 == i2) {
                if (F.n() <= 0) {
                    e();
                }
            } else if (2 != i2 || F.q() > 0) {
            } else {
                e();
            }
        }
    }

    public void f0(c.a.p0.t.e.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, fVar) == null) {
            this.f14784i = fVar;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            NotificationHelper.cancelNotification(this.f14776a, 18);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            NotificationHelper.cancelNotification(this.f14776a, 23);
            NotificationHelper.cancelNotification(this.f14776a, 24);
            NotificationHelper.cancelNotification(this.f14776a, 25);
            NotificationHelper.cancelNotification(this.f14776a, 29);
            NotificationHelper.cancelNotification(this.f14776a, 26);
            NotificationHelper.cancelNotification(this.f14776a, 17);
            NotificationHelper.cancelNotification(this.f14776a, 15);
            NotificationHelper.cancelNotification(this.f14776a, 13);
            NotificationHelper.cancelNotification(this.f14776a, 12);
        }
    }

    public final void h0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048614, this, i2, i3) == null) {
            try {
                if (i2 != 1) {
                    if (i2 == 2) {
                        NotificationHelper.cancelNotification(this.f14776a, 16);
                        NotificationHelper.cancelNotification(this.f14776a, 17);
                    }
                } else if (i3 == 23) {
                    if (this.f14783h > 0) {
                        String format = String.format(this.f14776a.getString(R.string.notify_gift), String.valueOf(this.f14783h));
                        P(23, null, format, format);
                    }
                } else if (i3 == 29) {
                    if (this.f14777b > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.f14776a.getString(R.string.notify_agree), Integer.valueOf(this.f14777b)));
                        P(29, null, sb.toString(), sb.toString());
                    }
                } else if (i3 == 24) {
                    if (this.f14778c > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.f14778c > 1) {
                            sb2.append(PreferencesUtil.LEFT_MOUNT);
                            sb2.append(String.valueOf(this.f14778c));
                            sb2.append(this.f14776a.getString(R.string.notify_unit));
                            sb2.append(PreferencesUtil.RIGHT_MOUNT);
                        }
                        if (this.m != null) {
                            sb2.append(this.m);
                        } else {
                            sb2.append(this.f14776a.getString(R.string.notify_reply));
                        }
                        P(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i3 != 25) {
                    if (i3 == 26) {
                        if (this.f14782g > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(String.format(this.f14776a.getString(R.string.notify_fans), Integer.valueOf(this.f14782g)));
                            P(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i3 != 16 && d.d().n()) {
                        d.d().e();
                    }
                } else if (this.f14779d > 0) {
                    StringBuilder sb4 = new StringBuilder();
                    if (this.f14779d > 1) {
                        sb4.append(PreferencesUtil.LEFT_MOUNT);
                        sb4.append(String.valueOf(this.f14779d));
                        sb4.append(this.f14776a.getString(R.string.notify_unit));
                        sb4.append(PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (this.n != null) {
                        sb4.append(this.n);
                    } else {
                        sb4.append(this.f14776a.getString(R.string.notify_at));
                    }
                    P(25, null, sb4.toString(), sb4.toString());
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            NotificationHelper.cancelNotification(this.f14776a, 29);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x02ec A[Catch: Exception -> 0x034e, TryCatch #0 {Exception -> 0x034e, blocks: (B:8:0x000e, B:10:0x0019, B:12:0x001d, B:16:0x0040, B:18:0x0044, B:20:0x004d, B:21:0x0067, B:23:0x006b, B:25:0x007c, B:24:0x0071, B:28:0x008d, B:30:0x0091, B:32:0x009a, B:33:0x00b4, B:35:0x00b8, B:37:0x00c9, B:36:0x00be, B:40:0x00da, B:42:0x00de, B:44:0x00e7, B:45:0x0101, B:47:0x0105, B:49:0x0116, B:48:0x010b, B:52:0x0127, B:54:0x012b, B:56:0x0134, B:57:0x014d, B:60:0x0169, B:62:0x0173, B:64:0x017d, B:66:0x0188, B:68:0x0192, B:70:0x019c, B:76:0x01aa, B:78:0x01b2, B:80:0x01dc, B:82:0x01e6, B:85:0x0210, B:87:0x0216, B:89:0x0234, B:93:0x023d, B:84:0x0206, B:97:0x024a, B:99:0x0250, B:102:0x0257, B:103:0x025b, B:105:0x0261, B:107:0x0269, B:109:0x0271, B:112:0x027a, B:114:0x0280, B:116:0x0284, B:118:0x0289, B:120:0x0293, B:122:0x029d, B:124:0x02a8, B:126:0x02ae, B:128:0x02b4, B:130:0x02c2, B:136:0x02e6, B:138:0x02ec, B:141:0x02f4, B:145:0x032f, B:147:0x033c, B:142:0x0310, B:131:0x02db, B:152:0x0353), top: B:159:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x032f A[Catch: Exception -> 0x034e, TryCatch #0 {Exception -> 0x034e, blocks: (B:8:0x000e, B:10:0x0019, B:12:0x001d, B:16:0x0040, B:18:0x0044, B:20:0x004d, B:21:0x0067, B:23:0x006b, B:25:0x007c, B:24:0x0071, B:28:0x008d, B:30:0x0091, B:32:0x009a, B:33:0x00b4, B:35:0x00b8, B:37:0x00c9, B:36:0x00be, B:40:0x00da, B:42:0x00de, B:44:0x00e7, B:45:0x0101, B:47:0x0105, B:49:0x0116, B:48:0x010b, B:52:0x0127, B:54:0x012b, B:56:0x0134, B:57:0x014d, B:60:0x0169, B:62:0x0173, B:64:0x017d, B:66:0x0188, B:68:0x0192, B:70:0x019c, B:76:0x01aa, B:78:0x01b2, B:80:0x01dc, B:82:0x01e6, B:85:0x0210, B:87:0x0216, B:89:0x0234, B:93:0x023d, B:84:0x0206, B:97:0x024a, B:99:0x0250, B:102:0x0257, B:103:0x025b, B:105:0x0261, B:107:0x0269, B:109:0x0271, B:112:0x027a, B:114:0x0280, B:116:0x0284, B:118:0x0289, B:120:0x0293, B:122:0x029d, B:124:0x02a8, B:126:0x02ae, B:128:0x02b4, B:130:0x02c2, B:136:0x02e6, B:138:0x02ec, B:141:0x02f4, B:145:0x032f, B:147:0x033c, B:142:0x0310, B:131:0x02db, B:152:0x0353), top: B:159:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x033c A[Catch: Exception -> 0x034e, TryCatch #0 {Exception -> 0x034e, blocks: (B:8:0x000e, B:10:0x0019, B:12:0x001d, B:16:0x0040, B:18:0x0044, B:20:0x004d, B:21:0x0067, B:23:0x006b, B:25:0x007c, B:24:0x0071, B:28:0x008d, B:30:0x0091, B:32:0x009a, B:33:0x00b4, B:35:0x00b8, B:37:0x00c9, B:36:0x00be, B:40:0x00da, B:42:0x00de, B:44:0x00e7, B:45:0x0101, B:47:0x0105, B:49:0x0116, B:48:0x010b, B:52:0x0127, B:54:0x012b, B:56:0x0134, B:57:0x014d, B:60:0x0169, B:62:0x0173, B:64:0x017d, B:66:0x0188, B:68:0x0192, B:70:0x019c, B:76:0x01aa, B:78:0x01b2, B:80:0x01dc, B:82:0x01e6, B:85:0x0210, B:87:0x0216, B:89:0x0234, B:93:0x023d, B:84:0x0206, B:97:0x024a, B:99:0x0250, B:102:0x0257, B:103:0x025b, B:105:0x0261, B:107:0x0269, B:109:0x0271, B:112:0x027a, B:114:0x0280, B:116:0x0284, B:118:0x0289, B:120:0x0293, B:122:0x029d, B:124:0x02a8, B:126:0x02ae, B:128:0x02b4, B:130:0x02c2, B:136:0x02e6, B:138:0x02ec, B:141:0x02f4, B:145:0x032f, B:147:0x033c, B:142:0x0310, B:131:0x02db, B:152:0x0353), top: B:159:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:190:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i0(int i2, int i3, c.a.p0.t.e.f fVar) {
        boolean z;
        boolean z2;
        String e2;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048616, this, i2, i3, fVar) == null) || fVar == null) {
            return;
        }
        boolean z3 = true;
        try {
            if (i2 != 1) {
                if (i2 == 2) {
                    NotificationHelper.cancelNotification(this.f14776a, 16);
                    NotificationHelper.cancelNotification(this.f14776a, 17);
                    return;
                }
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (i3 == 23) {
                if (this.f14783h > 0) {
                    String format = String.format(this.f14776a.getString(R.string.notify_gift), String.valueOf(this.f14783h));
                    P(23, null, format, format);
                }
            } else if (i3 == 29) {
                if (this.f14777b > 0) {
                    StringBuilder sb = new StringBuilder();
                    if (this.f14777b > 1) {
                        sb.append(PreferencesUtil.LEFT_MOUNT);
                        sb.append(String.valueOf(this.f14777b));
                        sb.append(this.f14776a.getString(R.string.notify_unit));
                        sb.append(PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (this.l != null) {
                        sb.append(this.l);
                    } else {
                        sb.append(this.f14776a.getString(R.string.notify_agree));
                    }
                    P(29, null, sb.toString(), sb.toString());
                }
            } else if (i3 == 24) {
                if (this.f14778c > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    if (this.f14778c > 1) {
                        sb2.append(PreferencesUtil.LEFT_MOUNT);
                        sb2.append(String.valueOf(this.f14778c));
                        sb2.append(this.f14776a.getString(R.string.notify_unit));
                        sb2.append(PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (this.m != null) {
                        sb2.append(this.m);
                    } else {
                        sb2.append(this.f14776a.getString(R.string.notify_reply));
                    }
                    P(24, null, sb2.toString(), sb2.toString());
                }
            } else if (i3 == 25) {
                if (this.f14779d > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    if (this.f14779d > 1) {
                        sb3.append(PreferencesUtil.LEFT_MOUNT);
                        sb3.append(String.valueOf(this.f14779d));
                        sb3.append(this.f14776a.getString(R.string.notify_unit));
                        sb3.append(PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (this.n != null) {
                        sb3.append(this.n);
                    } else {
                        sb3.append(this.f14776a.getString(R.string.notify_at));
                    }
                    P(25, null, sb3.toString(), sb3.toString());
                }
            } else if (i3 == 26) {
                if (this.f14782g > 0) {
                    StringBuilder sb4 = new StringBuilder();
                    if (this.f14782g > 1) {
                        sb4.append(String.format(this.f14776a.getString(R.string.notify_fans_unit), Integer.valueOf(this.f14782g)));
                    }
                    sb4.append(this.f14776a.getString(R.string.notify_fans));
                    P(26, null, sb4.toString(), sb4.toString());
                }
            } else if (i3 == 16) {
                int j2 = (!d.d().n() || d.d().e() <= 0) ? 0 : fVar.j() - fVar.l();
                long w = (!d.d().p() || d.d().e() <= 0) ? 0L : fVar.w();
                boolean z4 = w > 0;
                long j3 = j2 + w;
                int i4 = (j3 > 1L ? 1 : (j3 == 1L ? 0 : -1));
                if (i4 > 0) {
                    stringBuffer.append(String.format(this.f14776a.getString(R.string.notify_chat), Long.valueOf(j3)));
                    Q(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                } else if (i4 == 0) {
                    fVar.i();
                    fVar.f();
                    if (w == 1) {
                        String i5 = fVar.i();
                        e2 = fVar.f();
                        str2 = i5 + "：" + e2;
                        str = i5;
                    } else if (j2 != 1) {
                        return;
                    } else {
                        String b2 = fVar.b();
                        e2 = fVar.e();
                        str = b2;
                        str2 = e2;
                    }
                    if (TextUtils.isEmpty(e2)) {
                        stringBuffer.append(String.format(this.f14776a.getString(R.string.notify_chat), Long.valueOf(j3)));
                        str3 = stringBuffer.toString();
                    } else {
                        str3 = e2;
                    }
                    Q(16, str, str3, TextUtils.isEmpty(str2) ? str3 : str2, z4);
                }
            } else if (i3 == 19) {
                List<f.a> g2 = fVar.g();
                if (g2 != null && g2.size() != 0) {
                    for (f.a aVar : g2) {
                        if (aVar != null && !StringUtils.isNull(aVar.f14871c) && !k.isEmpty(aVar.f14869a) && aVar.f14875g > aVar.f14876h && aVar.f14877i == null) {
                            O(aVar, 19);
                        }
                    }
                }
            } else if (d.d().n() && d.d().e() > 0 && fVar.n() + fVar.q() > 0) {
                if (fVar.n() > 0 && !k0()) {
                    long n = fVar.n() - fVar.o();
                    if (n <= 0) {
                        if (fVar.o() > 0) {
                            z = false;
                            z2 = true;
                            if (fVar.q() > 0) {
                            }
                            z3 = z;
                            if (z3) {
                            }
                            if (z2) {
                            }
                        }
                    } else {
                        stringBuffer.append(String.format(this.f14776a.getString(R.string.notify_updates), Long.valueOf(n)));
                        z = true;
                        z2 = false;
                        if (fVar.q() > 0 || l0()) {
                            z3 = z;
                        } else if (!z) {
                            stringBuffer.append(String.format(this.f14776a.getString(R.string.notify_validate), Integer.valueOf(fVar.q())));
                        } else {
                            stringBuffer.append(String.format(this.f14776a.getString(R.string.notify_validate_1), Integer.valueOf(fVar.q())));
                        }
                        if (z3) {
                            P(17, null, stringBuffer.toString(), stringBuffer.toString());
                        }
                        if (z2) {
                            P(18, fVar.d(), fVar.c(), fVar.c());
                            return;
                        }
                        return;
                    }
                }
                z = false;
                z2 = false;
                if (fVar.q() > 0) {
                }
                z3 = z;
                if (z3) {
                }
                if (z2) {
                }
            }
        } catch (Exception e3) {
            BdLog.e(e3.getMessage());
        }
    }

    public void j(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            if (1 == j2) {
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 16, i2);
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 17, i2);
            } else if (2 == j2) {
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 12, i2);
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 13, i2);
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 15, i2);
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 18, i2);
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 19, i2);
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 28, i2);
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 2000, i2);
            } else if (3 == j2) {
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 29, i2);
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 23, i2);
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 24, i2);
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 25, i2);
                NotificationHelper.cancelNotificationExceptSpecific(this.f14776a, 26, i2);
            }
        }
    }

    public void j0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("replyme");
        int optInt2 = jSONObject.optInt("agree");
        JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("replyme");
            String optString2 = optJSONObject.optString("atme");
            String optString3 = optJSONObject.optString("agree");
            if (!StringUtils.isNull(optString) && optInt > 0) {
                this.m = optString;
            }
            if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                this.l = optString3;
            }
            if (StringUtils.isNull(optString2)) {
                return;
            }
            this.n = optString2;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            NotificationHelper.cancelNotification(this.f14776a, 25);
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? ChatStatusManager.getInst().getIsOpen(6) : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            NotificationHelper.cancelNotification(this.f14776a, 17);
            NotificationHelper.cancelNotification(this.f14776a, 19);
            NotificationHelper.cancelNotification(this.f14776a, 16);
            NotificationHelper.cancelNotification(this.f14776a, 18);
            NotificationHelper.cancelNotification(this.f14776a, 30);
        }
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? ChatStatusManager.getInst().getIsOpen(7) : invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            NotificationHelper.cancelNotification(this.f14776a, 26);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            NotificationHelper.cancelNotification(this.f14776a, 23);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            NotificationHelper.cancelNotification(this.f14776a, 26);
            NotificationHelper.cancelNotification(this.f14776a, 25);
            NotificationHelper.cancelNotification(this.f14776a, 24);
            NotificationHelper.cancelNotification(this.f14776a, 23);
            NotificationHelper.cancelNotification(this.f14776a, 16);
            NotificationHelper.cancelNotification(this.f14776a, 17);
            NotificationHelper.cancelNotification(this.f14776a, 29);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            NotificationHelper.cancelNotification(this.f14776a, 24);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            NotificationHelper.cancelNotification(this.f14776a, 19);
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            NotificationHelper.cancelNotification(this.f14776a, i2);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                c();
                return;
            }
            c.a.p0.t.e.f F = F();
            if (F == null) {
                c();
                return;
            }
            HashMap<String, String> h2 = F.h();
            if (h2 != null && !h2.isEmpty()) {
                if (h2.containsKey(str)) {
                    c();
                    return;
                }
                return;
            }
            c();
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? ((((this.f14784i.w() + this.f14784i.j()) + this.f14784i.y()) + this.f14784i.t()) + this.f14784i.s()) - this.f14784i.l() : invokeV.intValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f14777b : invokeV.intValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.f14779d : invokeV.intValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f14781f : invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.f14780e : invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.f14782g : invokeV.intValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.f14783h : invokeV.intValue;
    }
}
