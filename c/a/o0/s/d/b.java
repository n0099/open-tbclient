package c.a.o0.s.d;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.o0.s.e.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b o;
    public static Date p;
    public static Handler q;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f11287b;

    /* renamed from: c  reason: collision with root package name */
    public int f11288c;

    /* renamed from: d  reason: collision with root package name */
    public int f11289d;

    /* renamed from: e  reason: collision with root package name */
    public int f11290e;

    /* renamed from: f  reason: collision with root package name */
    public int f11291f;

    /* renamed from: g  reason: collision with root package name */
    public int f11292g;

    /* renamed from: h  reason: collision with root package name */
    public int f11293h;
    public c.a.o0.s.e.f i;
    public c.a.o0.s.e.f j;
    public boolean k;
    public String l;
    public String m;
    public String n;

    /* loaded from: classes2.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(963606856, "Lc/a/o0/s/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(963606856, "Lc/a/o0/s/d/b;");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11287b = 0;
        this.f11288c = 0;
        this.f11289d = 0;
        this.f11290e = 0;
        this.f11291f = 0;
        this.f11292g = 0;
        this.f11293h = 0;
        this.i = new c.a.o0.s.e.f();
        this.k = true;
        this.a = TbadkCoreApplication.getInst().getApp();
    }

    public static boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d.d().z()) {
                Calendar calendar = Calendar.getInstance();
                int i = (calendar.get(11) * 60) + calendar.get(12);
                String[] split = d.d().g().split(":");
                int parseInt = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
                String[] split2 = d.d().f().split(":");
                int parseInt2 = (Integer.parseInt(split2[0]) * 60) + Integer.parseInt(split2[1]);
                if (parseInt < parseInt2) {
                    if (i < parseInt || i > parseInt2) {
                        return false;
                    }
                } else if (parseInt <= parseInt2) {
                    return false;
                } else {
                    if ((i < parseInt || i > 1439) && (i < 0 || i > parseInt2)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11288c : invokeV.intValue;
    }

    public c.a.o0.s.e.f B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (c.a.o0.s.e.f) invokeV.objValue;
    }

    public int C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == 12 || i == 13 || i == 28) {
                return 2;
            }
            if (i != 29) {
                if (i != 2000) {
                    switch (i) {
                        case 15:
                        case 18:
                        case 19:
                            return 2;
                        case 16:
                        case 17:
                            return 1;
                        default:
                            switch (i) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11287b + this.f11288c + this.f11289d + this.f11290e + this.f11292g + this.f11293h : invokeV.intValue;
    }

    public c.a.o0.s.e.f F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (c.a.o0.s.e.f) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent G(int i, boolean z) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (z) {
                Set<String> keySet = this.i.h().keySet();
                if (keySet.iterator().hasNext()) {
                    str = keySet.iterator().next();
                    Intent intent = new Intent();
                    if (!UtilHelper.isFlyMeOs()) {
                        intent.setClass(this.a, DealIntentActivity.class);
                    } else {
                        intent.setClass(this.a, DealIntentService.class);
                    }
                    intent.putExtra(DealIntentService.KEY_CLASS, 5);
                    intent.putExtra("KeyOfNotiId", i);
                    intent.putExtra("agree_me", this.f11287b);
                    intent.putExtra("at_me", this.f11289d);
                    intent.putExtra("reply_me", this.f11288c);
                    intent.putExtra("fans", this.f11292g);
                    intent.putExtra("chat", x());
                    intent.putExtra("group_msg", this.i.j() - this.i.l());
                    intent.putExtra("group_msg_validate", this.i.q());
                    intent.putExtra("group_msg_updates", this.i.n());
                    intent.putExtra("officialbar_msg", this.i.u());
                    intent.putExtra("privateGid", str);
                    return intent;
                }
            }
            str = "";
            Intent intent2 = new Intent();
            if (!UtilHelper.isFlyMeOs()) {
            }
            intent2.putExtra(DealIntentService.KEY_CLASS, 5);
            intent2.putExtra("KeyOfNotiId", i);
            intent2.putExtra("agree_me", this.f11287b);
            intent2.putExtra("at_me", this.f11289d);
            intent2.putExtra("reply_me", this.f11288c);
            intent2.putExtra("fans", this.f11292g);
            intent2.putExtra("chat", x());
            intent2.putExtra("group_msg", this.i.j() - this.i.l());
            intent2.putExtra("group_msg_validate", this.i.q());
            intent2.putExtra("group_msg_updates", this.i.n());
            intent2.putExtra("officialbar_msg", this.i.u());
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
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 36);
            intent.putExtra("tab_id", 1);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public Intent I(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 24);
            intent.putExtra("KeyOfNotiId", i);
            intent.putExtra("gift_num", this.f11293h);
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
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 27);
            intent.putExtra("uid", aVar.a);
            intent.putExtra("uname", aVar.f11353e);
            intent.putExtra("user_type", aVar.f11354f);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public Intent K(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 35);
            intent.putExtra("KeyOfNotiId", i);
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
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 14);
            intent.putExtra("group_msg_updates", this.i.o());
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public boolean N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? "3222425470".equals(str) : invokeL.booleanValue;
    }

    public final void O(f.a aVar, int i) {
        PendingIntent service;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, aVar, i) == null) {
            Intent S = S(aVar);
            if (S != null && S.getDataString() != null && S.getDataString().contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                S.setFlags(276824064);
                NotificationHelper.showNotification(this.a, i, aVar.f11350b, aVar.f11351c, aVar.f11352d, PendingIntent.getActivity(this.a, i, S, 134217728), false);
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
                service = PendingIntent.getActivity(this.a, i, S, 134217728);
            } else {
                service = PendingIntent.getService(this.a, i, S, 134217728);
            }
            j(C(i), i);
            NotificationHelper.showNotification(this.a, i, aVar.f11350b, aVar.f11351c, aVar.f11352d, service, false);
        }
    }

    public final void P(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            Q(i, str, str2, str3, false);
        }
    }

    public final void Q(int i, String str, String str2, String str3, boolean z) {
        Intent G;
        PendingIntent service;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, str2, str3, Boolean.valueOf(z)}) == null) && this.k) {
            if (i == 23 && this.f11293h > 0) {
                G = I(i);
            } else if (i == 26 && this.f11292g > 0) {
                G = K(i);
            } else if (i == 18) {
                G = L();
            } else if (i == 24) {
                G = G(i, z);
                G.putExtra("tab_id", 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i != 16 && i != 17 && i != 18) {
                G = G(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                G = G(i, z);
                G.putExtra("tab_id", 2);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            G.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.a, i, G, 134217728);
            } else {
                service = PendingIntent.getService(this.a, i, G, 134217728);
            }
            j(C(i), i);
            NotificationHelper.showNotification(this.a, i, str, str2, str3, service, false);
        }
    }

    public Intent S(f.a aVar) {
        InterceptResult invokeL;
        ImMessageCenterPojo i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, aVar)) == null) {
            if (aVar != null && (i = c.a.p0.u1.k.b.o().i(aVar.a, aVar.f11354f)) != null && i.getLast_content() != null) {
                try {
                    String lastTaskId = i.getLastTaskId();
                    String lastServiceId = i.getLastServiceId();
                    JSONArray jSONArray = new JSONArray(i.getLastContentRawData());
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
                                intent.setClass(this.a, DealIntentActivity.class);
                            } else {
                                intent.setClass(this.a, DealIntentService.class);
                            }
                            intent.putExtra(DealIntentService.KEY_CLASS, 1);
                            intent.putExtra("id", group);
                            intent.putExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, true);
                            intent.putExtra("key_start_from", 7);
                            intent.putExtra("gid", aVar.a);
                            intent.putExtra("task_id", lastTaskId);
                            intent.putExtra("service_id", lastServiceId);
                            return intent;
                        }
                    } else {
                        if (!optString.contains("mo/q/hotMessage") && !optString.contains("mo/q/newtopic")) {
                            if (optString.contains("open_wb_view=1")) {
                                Intent intent2 = new Intent();
                                if (UtilHelper.isFlyMeOs()) {
                                    intent2.setClass(this.a, DealIntentActivity.class);
                                } else {
                                    intent2.setClass(this.a, DealIntentService.class);
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
                                        intent3.setClass(this.a, DealIntentActivity.class);
                                    } else {
                                        intent3.setClass(this.a, DealIntentService.class);
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
                            intent4.setClass(this.a, DealIntentActivity.class);
                        } else {
                            intent4.setClass(this.a, DealIntentService.class);
                        }
                        intent4.putExtra(DealIntentService.KEY_CLASS, 30);
                        intent4.putExtra(BigdayActivityConfig.JUMP_URL, optString);
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

    public void U(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            if (i == this.f11287b && i2 == this.f11288c && i3 == this.f11289d && i4 == this.f11290e && i5 == this.f11292g && i6 == this.f11291f && i7 == this.f11293h) {
                return;
            }
            int i13 = this.f11287b;
            int i14 = 2;
            int i15 = (i > i13 || i2 > (i11 = this.f11288c) || i3 > (i12 = this.f11289d) || i4 > this.f11290e || i5 > this.f11292g || i6 > this.f11291f || i7 > this.f11293h) ? 1 : (i < i13 || i2 < i11 || i3 < i12) ? 2 : 0;
            if (i <= this.f11287b || !d.d().y()) {
                i8 = i < this.f11287b ? 2 : 0;
            } else {
                i8 = 1;
            }
            if (i2 <= this.f11288c || !d.d().v()) {
                i9 = i2 < this.f11288c ? 2 : 0;
            } else {
                i9 = 1;
            }
            if (i3 <= this.f11289d || !d.d().q()) {
                i10 = i3 < this.f11289d ? 2 : 0;
            } else {
                i10 = 1;
            }
            int i16 = i4 > this.f11290e ? 1 : 0;
            int i17 = i5 > this.f11292g ? 1 : 0;
            int i18 = i7 > this.f11293h ? 1 : 0;
            this.f11287b = i;
            this.f11288c = i2;
            this.f11289d = i3;
            this.f11290e = i4;
            this.f11292g = i5;
            this.f11291f = i6;
            this.f11293h = i7;
            if (E() <= 0) {
                i15 = 2;
                i17 = 2;
                i8 = 2;
                i9 = 2;
                i10 = 2;
                i16 = 2;
            } else {
                i14 = i18;
            }
            if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                return;
            }
            a();
            h0(i14, 23);
            h0(i16, 16);
            h0(i15, 17);
            h0(i9, 24);
            h0(i10, 25);
            h0(i17, 26);
            h0(i8, 29);
        }
    }

    public void V(c.a.o0.s.e.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) || fVar == null) {
            return;
        }
        this.i = fVar;
        this.f11290e = (fVar.j() - fVar.l()) + fVar.w() + fVar.t() + fVar.s();
        b(fVar);
        int i = 0;
        if (fVar.z()) {
            this.j = null;
            q.removeMessages(0);
        }
        if (fVar.z()) {
            if (d.d().p() && d.d().e() > 0) {
                i = fVar.j() - fVar.l();
            }
            long w = (!d.d().r() || d.d().e() <= 0) ? 0L : fVar.w();
            if ((i > 0 || w > 0) && ((i > fVar.m() - fVar.l() && i > 0) || w > fVar.x())) {
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

    public void W(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            if (i == this.f11287b && i2 == this.f11288c && i3 == this.f11289d && i4 == this.f11290e && i5 == this.f11292g && this.f11293h == i6) {
                return;
            }
            this.f11287b = i;
            this.f11288c = i2;
            this.f11289d = i3;
            this.f11290e = i4;
            this.f11292g = i5;
            this.f11293h = i6;
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
            this.f11287b = 0;
            this.f11288c = 0;
            this.f11289d = 0;
            this.f11290e = 0;
            this.f11292g = 0;
            this.f11291f = 0;
        }
    }

    public void Y(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || i < 0) {
            return;
        }
        U(i, this.f11288c, this.f11289d, this.f11290e, this.f11292g, this.f11291f, this.f11293h);
    }

    public void Z(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i) == null) || i < 0) {
            return;
        }
        U(this.f11287b, this.f11288c, i, this.f11290e, this.f11292g, this.f11291f, this.f11293h);
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
            newsNotifyMessage.setMsgPrivateChat(this.i.w());
            newsNotifyMessage.setMsgStrangerChat(this.i.y());
            newsNotifyMessage.setMsgOfficialMerge(this.i.t());
            T(newsNotifyMessage);
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i) == null) || i < 0) {
            return;
        }
        U(this.f11287b, this.f11288c, this.f11289d, this.f11290e, this.f11292g, i, this.f11293h);
    }

    public void b(c.a.o0.s.e.f fVar) {
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

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i) == null) || i < 0) {
            return;
        }
        U(this.f11287b, this.f11288c, this.f11289d, i, this.f11292g, this.f11291f, this.f11293h);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            NotificationHelper.cancelNotification(this.a, 16);
        }
    }

    public void c0(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048605, this, i) == null) || i < 0) {
            return;
        }
        U(this.f11287b, this.f11288c, this.f11289d, this.f11290e, i, this.f11291f, this.f11293h);
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                c();
                return;
            }
            c.a.o0.s.e.f F = F();
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

    public void d0(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i) == null) || i < 0) {
            return;
        }
        this.f11293h = i;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            NotificationHelper.cancelNotification(this.a, 17);
        }
    }

    public void e0(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i) == null) || i < 0) {
            return;
        }
        U(this.f11287b, i, this.f11289d, this.f11290e, this.f11292g, this.f11291f, this.f11293h);
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            c.a.o0.s.e.f F = F();
            if (F == null) {
                e();
            } else if (1 == i) {
                if (F.n() <= 0) {
                    e();
                }
            } else if (2 != i || F.q() > 0) {
            } else {
                e();
            }
        }
    }

    public void f0(c.a.o0.s.e.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, fVar) == null) {
            this.i = fVar;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            NotificationHelper.cancelNotification(this.a, 18);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            NotificationHelper.cancelNotification(this.a, 23);
            NotificationHelper.cancelNotification(this.a, 24);
            NotificationHelper.cancelNotification(this.a, 25);
            NotificationHelper.cancelNotification(this.a, 29);
            NotificationHelper.cancelNotification(this.a, 26);
            NotificationHelper.cancelNotification(this.a, 17);
            NotificationHelper.cancelNotification(this.a, 15);
            NotificationHelper.cancelNotification(this.a, 13);
            NotificationHelper.cancelNotification(this.a, 12);
        }
    }

    public final void h0(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048614, this, i, i2) == null) {
            try {
                if (i != 1) {
                    if (i == 2) {
                        NotificationHelper.cancelNotification(this.a, 16);
                        NotificationHelper.cancelNotification(this.a, 17);
                    }
                } else if (i2 == 23) {
                    if (this.f11293h > 0) {
                        String format = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0c85), String.valueOf(this.f11293h));
                        P(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.f11287b > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0c7f), Integer.valueOf(this.f11287b)));
                        P(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.f11288c > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.f11288c > 1) {
                            sb2.append(PreferencesUtil.LEFT_MOUNT);
                            sb2.append(String.valueOf(this.f11288c));
                            sb2.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c88));
                            sb2.append(PreferencesUtil.RIGHT_MOUNT);
                        }
                        if (this.m != null) {
                            sb2.append(this.m);
                        } else {
                            sb2.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c86));
                        }
                        P(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 != 25) {
                    if (i2 == 26) {
                        if (this.f11292g > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0c83), Integer.valueOf(this.f11292g)));
                            P(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 != 16 && d.d().p()) {
                        d.d().e();
                    }
                } else if (this.f11289d > 0) {
                    StringBuilder sb4 = new StringBuilder();
                    if (this.f11289d > 1) {
                        sb4.append(PreferencesUtil.LEFT_MOUNT);
                        sb4.append(String.valueOf(this.f11289d));
                        sb4.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c88));
                        sb4.append(PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (this.n != null) {
                        sb4.append(this.n);
                    } else {
                        sb4.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c80));
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
            NotificationHelper.cancelNotification(this.a, 29);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x02ef A[Catch: Exception -> 0x0353, TryCatch #0 {Exception -> 0x0353, blocks: (B:8:0x000e, B:10:0x0019, B:12:0x001d, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0069, B:23:0x006d, B:25:0x007f, B:24:0x0073, B:28:0x0090, B:30:0x0094, B:32:0x009d, B:33:0x00b5, B:35:0x00b9, B:37:0x00cb, B:36:0x00bf, B:40:0x00dc, B:42:0x00e0, B:44:0x00e9, B:45:0x0101, B:47:0x0105, B:49:0x0117, B:48:0x010b, B:52:0x0128, B:54:0x012c, B:56:0x0135, B:57:0x014f, B:60:0x016c, B:62:0x0176, B:64:0x0180, B:66:0x018b, B:68:0x0195, B:70:0x019f, B:76:0x01ad, B:78:0x01b8, B:80:0x01e0, B:82:0x01ea, B:85:0x0214, B:87:0x021a, B:89:0x0236, B:93:0x023f, B:84:0x020a, B:97:0x024c, B:99:0x0252, B:102:0x0259, B:103:0x025d, B:105:0x0263, B:107:0x026b, B:109:0x0273, B:112:0x027c, B:114:0x0282, B:116:0x0286, B:118:0x028b, B:120:0x0295, B:122:0x029f, B:124:0x02aa, B:126:0x02b0, B:128:0x02b6, B:130:0x02c4, B:136:0x02e9, B:138:0x02ef, B:141:0x02f7, B:145:0x0334, B:147:0x0341, B:142:0x0314, B:131:0x02de, B:152:0x0358), top: B:159:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0334 A[Catch: Exception -> 0x0353, TryCatch #0 {Exception -> 0x0353, blocks: (B:8:0x000e, B:10:0x0019, B:12:0x001d, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0069, B:23:0x006d, B:25:0x007f, B:24:0x0073, B:28:0x0090, B:30:0x0094, B:32:0x009d, B:33:0x00b5, B:35:0x00b9, B:37:0x00cb, B:36:0x00bf, B:40:0x00dc, B:42:0x00e0, B:44:0x00e9, B:45:0x0101, B:47:0x0105, B:49:0x0117, B:48:0x010b, B:52:0x0128, B:54:0x012c, B:56:0x0135, B:57:0x014f, B:60:0x016c, B:62:0x0176, B:64:0x0180, B:66:0x018b, B:68:0x0195, B:70:0x019f, B:76:0x01ad, B:78:0x01b8, B:80:0x01e0, B:82:0x01ea, B:85:0x0214, B:87:0x021a, B:89:0x0236, B:93:0x023f, B:84:0x020a, B:97:0x024c, B:99:0x0252, B:102:0x0259, B:103:0x025d, B:105:0x0263, B:107:0x026b, B:109:0x0273, B:112:0x027c, B:114:0x0282, B:116:0x0286, B:118:0x028b, B:120:0x0295, B:122:0x029f, B:124:0x02aa, B:126:0x02b0, B:128:0x02b6, B:130:0x02c4, B:136:0x02e9, B:138:0x02ef, B:141:0x02f7, B:145:0x0334, B:147:0x0341, B:142:0x0314, B:131:0x02de, B:152:0x0358), top: B:159:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0341 A[Catch: Exception -> 0x0353, TryCatch #0 {Exception -> 0x0353, blocks: (B:8:0x000e, B:10:0x0019, B:12:0x001d, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0069, B:23:0x006d, B:25:0x007f, B:24:0x0073, B:28:0x0090, B:30:0x0094, B:32:0x009d, B:33:0x00b5, B:35:0x00b9, B:37:0x00cb, B:36:0x00bf, B:40:0x00dc, B:42:0x00e0, B:44:0x00e9, B:45:0x0101, B:47:0x0105, B:49:0x0117, B:48:0x010b, B:52:0x0128, B:54:0x012c, B:56:0x0135, B:57:0x014f, B:60:0x016c, B:62:0x0176, B:64:0x0180, B:66:0x018b, B:68:0x0195, B:70:0x019f, B:76:0x01ad, B:78:0x01b8, B:80:0x01e0, B:82:0x01ea, B:85:0x0214, B:87:0x021a, B:89:0x0236, B:93:0x023f, B:84:0x020a, B:97:0x024c, B:99:0x0252, B:102:0x0259, B:103:0x025d, B:105:0x0263, B:107:0x026b, B:109:0x0273, B:112:0x027c, B:114:0x0282, B:116:0x0286, B:118:0x028b, B:120:0x0295, B:122:0x029f, B:124:0x02aa, B:126:0x02b0, B:128:0x02b6, B:130:0x02c4, B:136:0x02e9, B:138:0x02ef, B:141:0x02f7, B:145:0x0334, B:147:0x0341, B:142:0x0314, B:131:0x02de, B:152:0x0358), top: B:159:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:190:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i0(int i, int i2, c.a.o0.s.e.f fVar) {
        boolean z;
        boolean z2;
        String e2;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048616, this, i, i2, fVar) == null) || fVar == null) {
            return;
        }
        boolean z3 = true;
        try {
            if (i != 1) {
                if (i == 2) {
                    NotificationHelper.cancelNotification(this.a, 16);
                    NotificationHelper.cancelNotification(this.a, 17);
                    return;
                }
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (i2 == 23) {
                if (this.f11293h > 0) {
                    String format = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0c85), String.valueOf(this.f11293h));
                    P(23, null, format, format);
                }
            } else if (i2 == 29) {
                if (this.f11287b > 0) {
                    StringBuilder sb = new StringBuilder();
                    if (this.f11287b > 1) {
                        sb.append(PreferencesUtil.LEFT_MOUNT);
                        sb.append(String.valueOf(this.f11287b));
                        sb.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c88));
                        sb.append(PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (this.l != null) {
                        sb.append(this.l);
                    } else {
                        sb.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c7f));
                    }
                    P(29, null, sb.toString(), sb.toString());
                }
            } else if (i2 == 24) {
                if (this.f11288c > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    if (this.f11288c > 1) {
                        sb2.append(PreferencesUtil.LEFT_MOUNT);
                        sb2.append(String.valueOf(this.f11288c));
                        sb2.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c88));
                        sb2.append(PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (this.m != null) {
                        sb2.append(this.m);
                    } else {
                        sb2.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c86));
                    }
                    P(24, null, sb2.toString(), sb2.toString());
                }
            } else if (i2 == 25) {
                if (this.f11289d > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    if (this.f11289d > 1) {
                        sb3.append(PreferencesUtil.LEFT_MOUNT);
                        sb3.append(String.valueOf(this.f11289d));
                        sb3.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c88));
                        sb3.append(PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (this.n != null) {
                        sb3.append(this.n);
                    } else {
                        sb3.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c80));
                    }
                    P(25, null, sb3.toString(), sb3.toString());
                }
            } else if (i2 == 26) {
                if (this.f11292g > 0) {
                    StringBuilder sb4 = new StringBuilder();
                    if (this.f11292g > 1) {
                        sb4.append(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0c84), Integer.valueOf(this.f11292g)));
                    }
                    sb4.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c83));
                    P(26, null, sb4.toString(), sb4.toString());
                }
            } else if (i2 == 16) {
                int j = (!d.d().p() || d.d().e() <= 0) ? 0 : fVar.j() - fVar.l();
                long w = (!d.d().r() || d.d().e() <= 0) ? 0L : fVar.w();
                boolean z4 = w > 0;
                long j2 = j + w;
                int i3 = (j2 > 1L ? 1 : (j2 == 1L ? 0 : -1));
                if (i3 > 0) {
                    stringBuffer.append(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0c82), Long.valueOf(j2)));
                    Q(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                } else if (i3 == 0) {
                    fVar.i();
                    fVar.f();
                    if (w == 1) {
                        String i4 = fVar.i();
                        e2 = fVar.f();
                        str2 = i4 + "：" + e2;
                        str = i4;
                    } else if (j != 1) {
                        return;
                    } else {
                        String b2 = fVar.b();
                        e2 = fVar.e();
                        str = b2;
                        str2 = e2;
                    }
                    if (TextUtils.isEmpty(e2)) {
                        stringBuffer.append(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0c82), Long.valueOf(j2)));
                        str3 = stringBuffer.toString();
                    } else {
                        str3 = e2;
                    }
                    Q(16, str, str3, TextUtils.isEmpty(str2) ? str3 : str2, z4);
                }
            } else if (i2 == 19) {
                List<f.a> g2 = fVar.g();
                if (g2 != null && g2.size() != 0) {
                    for (f.a aVar : g2) {
                        if (aVar != null && !StringUtils.isNull(aVar.f11351c) && !m.isEmpty(aVar.a) && aVar.f11355g > aVar.f11356h && aVar.i == null) {
                            O(aVar, 19);
                        }
                    }
                }
            } else if (d.d().p() && d.d().e() > 0 && fVar.n() + fVar.q() > 0) {
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
                        stringBuffer.append(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0c89), Long.valueOf(n)));
                        z = true;
                        z2 = false;
                        if (fVar.q() > 0 || l0()) {
                            z3 = z;
                        } else if (!z) {
                            stringBuffer.append(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0c8a), Integer.valueOf(fVar.q())));
                        } else {
                            stringBuffer.append(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0c8b), Integer.valueOf(fVar.q())));
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

    public void j(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            if (1 == j) {
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 16, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 17, i);
            } else if (2 == j) {
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 12, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 13, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 15, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 18, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 19, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 28, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 2000, i);
            } else if (3 == j) {
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 29, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 23, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 24, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 25, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 26, i);
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
            NotificationHelper.cancelNotification(this.a, 25);
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
            NotificationHelper.cancelNotification(this.a, 17);
            NotificationHelper.cancelNotification(this.a, 19);
            NotificationHelper.cancelNotification(this.a, 16);
            NotificationHelper.cancelNotification(this.a, 18);
            NotificationHelper.cancelNotification(this.a, 30);
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
            NotificationHelper.cancelNotification(this.a, 26);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            NotificationHelper.cancelNotification(this.a, 23);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            NotificationHelper.cancelNotification(this.a, 26);
            NotificationHelper.cancelNotification(this.a, 25);
            NotificationHelper.cancelNotification(this.a, 24);
            NotificationHelper.cancelNotification(this.a, 23);
            NotificationHelper.cancelNotification(this.a, 16);
            NotificationHelper.cancelNotification(this.a, 17);
            NotificationHelper.cancelNotification(this.a, 29);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            NotificationHelper.cancelNotification(this.a, 24);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            NotificationHelper.cancelNotification(this.a, 19);
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            NotificationHelper.cancelNotification(this.a, i);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                c();
                return;
            }
            c.a.o0.s.e.f F = F();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? ((((this.i.w() + this.i.j()) + this.i.y()) + this.i.t()) + this.i.s()) - this.i.l() : invokeV.intValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f11287b : invokeV.intValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.f11289d : invokeV.intValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f11291f : invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.f11290e : invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.f11292g : invokeV.intValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.f11293h : invokeV.intValue;
    }
}
