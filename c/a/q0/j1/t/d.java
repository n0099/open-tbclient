package c.a.q0.j1.t;

import android.text.TextUtils;
import c.a.e.e.d.l;
import c.a.p0.b1.h0;
import c.a.p0.b1.k0;
import c.a.p0.b1.n;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
/* loaded from: classes3.dex */
public class d extends c.a.q0.j1.t.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static d f21061b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a extends h0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialSettingItemData f21062a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21063b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f21064c;

        public a(d dVar, OfficialSettingItemData officialSettingItemData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, officialSettingItemData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21064c = dVar;
            this.f21062a = officialSettingItemData;
            this.f21063b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.h0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f21064c.b().g(this.f21063b, OrmObject.jsonStrWithObject(this.f21062a));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(26735504, "Lc/a/q0/j1/t/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(26735504, "Lc/a/q0/j1/t/d;");
                return;
            }
        }
        f21061b = new d();
    }

    public d() {
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

    public static d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f21061b : (d) invokeV.objValue;
    }

    @Override // c.a.q0.j1.t.a
    public l<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.s.r.a.f();
            return c.a.p0.s.r.a.g("tb.im_official_chat_setting");
        }
        return (l) invokeV.objValue;
    }

    @Override // c.a.q0.j1.t.a
    public void h(ChatSetting chatSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatSetting) == null) && chatSetting != null && (chatSetting instanceof OfficialSettingItemData)) {
            OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) chatSetting;
            String myUid = officialSettingItemData.getMyUid();
            String toUid = officialSettingItemData.getToUid();
            if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
                l<String> b2 = b();
                String str = myUid + TNCManager.TNC_PROBE_HEADER_SECEPTOR + toUid;
                String jsonStrWithObject = OrmObject.jsonStrWithObject(officialSettingItemData);
                synchronized (this.f21045a) {
                    this.f21045a.put(str, officialSettingItemData);
                }
                b2.g(str, jsonStrWithObject);
            } else if (TbConfig.getDebugSwitch()) {
                throw new RuntimeException("key param is null");
            }
        }
    }

    @Override // c.a.q0.j1.t.a
    public void i(ChatSetting chatSetting, n<Void> nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, chatSetting, nVar) == null) && chatSetting != null && (chatSetting instanceof OfficialSettingItemData)) {
            OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) chatSetting;
            String myUid = officialSettingItemData.getMyUid();
            String toUid = officialSettingItemData.getToUid();
            if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
                String str = myUid + TNCManager.TNC_PROBE_HEADER_SECEPTOR + toUid;
                synchronized (this.f21045a) {
                    this.f21045a.put(str, officialSettingItemData);
                }
                k0.c(new a(this, officialSettingItemData, str), nVar);
            } else if (TbConfig.getDebugSwitch()) {
                throw new RuntimeException("key param is null");
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.j1.t.a
    /* renamed from: k */
    public OfficialSettingItemData a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            OfficialSettingItemData officialSettingItemData = null;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = str + TNCManager.TNC_PROBE_HEADER_SECEPTOR + str2;
            synchronized (this.f21045a) {
                ChatSetting chatSetting = this.f21045a.get(str3);
                if (chatSetting != null && (chatSetting instanceof OfficialSettingItemData)) {
                    officialSettingItemData = (OfficialSettingItemData) chatSetting;
                }
            }
            if (officialSettingItemData == null) {
                OfficialSettingItemData officialSettingItemData2 = new OfficialSettingItemData();
                officialSettingItemData2.setMyUid(str);
                officialSettingItemData2.setToUid(str2);
                officialSettingItemData2.setAcceptNotify(true);
                return officialSettingItemData2;
            }
            return officialSettingItemData;
        }
        return (OfficialSettingItemData) invokeLL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.e(OfficialSettingItemData.class);
        }
    }

    public void m(String str, String str2, UserData userData) {
        OfficialSettingItemData a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, userData) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || userData == null || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setToPortrait(userData.getPortrait());
        a2.setToName(userData.getUserName());
        h(a2);
    }
}
