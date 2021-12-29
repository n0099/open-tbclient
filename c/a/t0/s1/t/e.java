package c.a.t0.s1.t;

import android.text.TextUtils;
import c.a.d.f.d.l;
import c.a.s0.e1.k0;
import c.a.s0.e1.n0;
import c.a.s0.e1.s;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e extends c.a.t0.s1.t.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static e f22886b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends k0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalSettingItemData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f22887b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f22888c;

        public a(e eVar, PersonalSettingItemData personalSettingItemData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, personalSettingItemData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22888c = eVar;
            this.a = personalSettingItemData;
            this.f22887b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.e1.k0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f22888c.b().g(this.f22887b, OrmObject.jsonStrWithObject(this.a));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1165206443, "Lc/a/t0/s1/t/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1165206443, "Lc/a/t0/s1/t/e;");
                return;
            }
        }
        f22886b = new e();
    }

    public e() {
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

    public static e j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f22886b : (e) invokeV.objValue;
    }

    @Override // c.a.t0.s1.t.a
    public l<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.s0.s.r.a.f();
            return c.a.s0.s.r.a.g("tb.im_personal_chat_setting");
        }
        return (l) invokeV.objValue;
    }

    @Override // c.a.t0.s1.t.a
    public void h(ChatSetting chatSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatSetting) == null) && chatSetting != null && (chatSetting instanceof PersonalSettingItemData)) {
            PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) chatSetting;
            String myUid = personalSettingItemData.getMyUid();
            String toUid = personalSettingItemData.getToUid();
            if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
                l<String> b2 = b();
                String str = myUid + "@" + toUid;
                String jsonStrWithObject = OrmObject.jsonStrWithObject(personalSettingItemData);
                synchronized (this.a) {
                    this.a.put(str, personalSettingItemData);
                }
                b2.g(str, jsonStrWithObject);
            } else if (TbConfig.getDebugSwitch()) {
                throw new RuntimeException("key param is null");
            }
        }
    }

    @Override // c.a.t0.s1.t.a
    public void i(ChatSetting chatSetting, s<Void> sVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, chatSetting, sVar) == null) && chatSetting != null && (chatSetting instanceof PersonalSettingItemData)) {
            PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) chatSetting;
            String myUid = personalSettingItemData.getMyUid();
            String toUid = personalSettingItemData.getToUid();
            if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
                String str = myUid + "@" + toUid;
                synchronized (this.a) {
                    this.a.put(str, personalSettingItemData);
                }
                n0.c(new a(this, personalSettingItemData, str), sVar);
            } else if (TbConfig.getDebugSwitch()) {
                throw new RuntimeException("key param is null");
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.s1.t.a
    /* renamed from: k */
    public PersonalSettingItemData a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            PersonalSettingItemData personalSettingItemData = null;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = str + "@" + str2;
            synchronized (this.a) {
                ChatSetting chatSetting = this.a.get(str3);
                if (chatSetting != null && (chatSetting instanceof PersonalSettingItemData)) {
                    personalSettingItemData = (PersonalSettingItemData) chatSetting;
                }
            }
            if (personalSettingItemData == null) {
                PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
                personalSettingItemData2.setMyUid(str);
                personalSettingItemData2.setToUid(str2);
                personalSettingItemData2.setAcceptNotify(true);
                return personalSettingItemData2;
            }
            return personalSettingItemData;
        }
        return (PersonalSettingItemData) invokeLL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.e(PersonalSettingItemData.class);
        }
    }

    public void m(String str, String str2, UserData userData) {
        PersonalSettingItemData a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, userData) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || userData == null || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setToPortrait(userData.getPortrait());
        a2.setToName(userData.getUserName());
        h(a2);
    }
}
