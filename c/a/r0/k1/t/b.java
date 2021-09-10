package c.a.r0.k1.t;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.d.l;
import c.a.q0.d1.i0;
import c.a.q0.d1.l0;
import c.a.q0.d1.o;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
/* loaded from: classes3.dex */
public class b extends c.a.r0.k1.t.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static b f21619b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a extends i0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21620a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21621b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f21622c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f21623d;

        public a(b bVar, String str, String str2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21623d = bVar;
            this.f21620a = str;
            this.f21621b = str2;
            this.f21622c = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.q0.d1.i0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                GroupSettingItemData a2 = this.f21623d.a(this.f21620a, this.f21621b);
                if (a2 != null && a2.isAlreadyApply()) {
                    if (System.currentTimeMillis() - a2.getLastApplyTimeStamp() <= this.f21622c) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* renamed from: c.a.r0.k1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1014b extends i0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupSettingItemData f21624a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21625b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f21626c;

        public C1014b(b bVar, GroupSettingItemData groupSettingItemData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, groupSettingItemData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21626c = bVar;
            this.f21624a = groupSettingItemData;
            this.f21625b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f21626c.b().g(this.f21625b, OrmObject.jsonStrWithObject(this.f21624a));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends i0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21627a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f21628b;

        public c(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21628b = bVar;
            this.f21627a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f21628b.b().remove(this.f21627a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(717725618, "Lc/a/r0/k1/t/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(717725618, "Lc/a/r0/k1/t/b;");
                return;
            }
        }
        f21619b = new b();
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

    public static b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f21619b : (b) invokeV.objValue;
    }

    @Override // c.a.r0.k1.t.a
    public l<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.q0.s.r.a.f();
            return c.a.q0.s.r.a.g("tb.im_group_setting");
        }
        return (l) invokeV.objValue;
    }

    @Override // c.a.r0.k1.t.a
    public void h(ChatSetting chatSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatSetting) == null) && chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
                l<String> b2 = b();
                String str = uid + TNCManager.TNC_PROBE_HEADER_SECEPTOR + gid;
                String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
                synchronized (this.f21615a) {
                    this.f21615a.put(str, groupSettingItemData);
                }
                b2.g(str, jsonStrWithObject);
            } else if (TbConfig.getDebugSwitch()) {
                throw new RuntimeException("key param is null");
            }
        }
    }

    @Override // c.a.r0.k1.t.a
    public void i(ChatSetting chatSetting, o<Void> oVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, chatSetting, oVar) == null) && chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
                String str = uid + TNCManager.TNC_PROBE_HEADER_SECEPTOR + gid;
                synchronized (this.f21615a) {
                    this.f21615a.put(str, groupSettingItemData);
                }
                l0.c(new C1014b(this, groupSettingItemData, str), oVar);
            } else if (TbConfig.getDebugSwitch()) {
                throw new RuntimeException("key param is null");
            }
        }
    }

    public void j(String str, String str2, o<Void> oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, oVar) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = str + TNCManager.TNC_PROBE_HEADER_SECEPTOR + str2;
        synchronized (this.f21615a) {
            this.f21615a.remove(str3);
        }
        l0.c(new c(this, str3), oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.k1.t.a
    /* renamed from: l */
    public GroupSettingItemData a(String str, String str2) {
        InterceptResult invokeLL;
        GroupSettingItemData groupSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = str + TNCManager.TNC_PROBE_HEADER_SECEPTOR + str2;
            synchronized (this.f21615a) {
                ChatSetting chatSetting = this.f21615a.get(str3);
                groupSettingItemData = chatSetting instanceof GroupSettingItemData ? (GroupSettingItemData) chatSetting : null;
            }
            if (groupSettingItemData == null) {
                GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
                groupSettingItemData2.setUid(str);
                groupSettingItemData2.setGid(str2);
                groupSettingItemData2.setAcceptNotify(true);
                groupSettingItemData2.setInGroup(true);
                return groupSettingItemData2;
            }
            return groupSettingItemData;
        }
        return (GroupSettingItemData) invokeLL.objValue;
    }

    public void m(String str, String str2, long j2, o<Boolean> oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Long.valueOf(j2), oVar}) == null) {
            l0.c(new a(this, str, str2, j2), oVar);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.e(GroupSettingItemData.class);
        }
    }

    public void o(String str, String str2, boolean z, o<Void> oVar) {
        GroupSettingItemData a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Boolean.valueOf(z), oVar}) == null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setAlreadyApply(z);
        a2.setLastApplyTimeStamp(System.currentTimeMillis());
        i(a2, oVar);
    }

    public void p(String str, String str2, boolean z, o<Void> oVar) {
        GroupSettingItemData a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Boolean.valueOf(z), oVar}) == null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setInGroup(z);
        i(a2, oVar);
    }
}
