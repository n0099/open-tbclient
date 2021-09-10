package c.a.q0.d1;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static z f13016g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13017a;

    /* renamed from: b  reason: collision with root package name */
    public String f13018b;

    /* renamed from: c  reason: collision with root package name */
    public String f13019c;

    /* renamed from: d  reason: collision with root package name */
    public int f13020d;

    /* renamed from: e  reason: collision with root package name */
    public String f13021e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f13022f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f13023e;

        public a(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13023e = zVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("from", String.valueOf(this.f13023e.f13017a));
                hashMap.put("field_id", this.f13023e.f13018b);
                hashMap.put("type", Integer.valueOf(this.f13023e.f13020d));
                hashMap.put("type_name", this.f13023e.f13021e);
                if (this.f13023e.f13017a == 2) {
                    hashMap.put("fid", this.f13023e.f13019c);
                }
                hashMap.put("animated", Boolean.FALSE);
                hashMap.put(OpenFlutter.EXTRA_TRANSPARANT, Boolean.TRUE);
                hashMap.put("swipeback", Boolean.FALSE);
                if (PluginPackageManager.O().y("com.baidu.tieba.pluginFlutter")) {
                    if (MessageManager.getInstance().findTask(2002015) == null) {
                        c.a.e.e.m.e.a().postDelayed(this.f13023e.f13022f, 0L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new c.a.r0.j3.i0.n(TbadkApplication.getInst().getApplicationContext(), "GodDialog", hashMap)));
                    c.a.q0.s.d0.b.j().w("key_new_god_dialog_showed_time", System.currentTimeMillis());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(39179577, "Lc/a/q0/d1/z;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(39179577, "Lc/a/q0/d1/z;");
        }
    }

    public z() {
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
        this.f13022f = new a(this);
    }

    public static synchronized z g() {
        InterceptResult invokeV;
        z zVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (z.class) {
                if (f13016g == null) {
                    f13016g = new z();
                }
                zVar = f13016g;
            }
            return zVar;
        }
        return (z) invokeV.objValue;
    }

    public final boolean h(int i2, NewGodData newGodData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, newGodData)) == null) {
            if (i2 != 5) {
                return (((((System.currentTimeMillis() - c.a.q0.s.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) > 259200000L ? 1 : (((System.currentTimeMillis() - c.a.q0.s.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) == 259200000L ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.f13022f);
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f13019c = str;
        }
    }

    public void k(int i2, NewGodData newGodData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, newGodData) == null) {
            l(i2, newGodData, true);
        }
    }

    public void l(int i2, NewGodData newGodData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), newGodData, Boolean.valueOf(z)}) == null) && h(i2, newGodData)) {
            i();
            this.f13017a = i2;
            this.f13018b = newGodData.getFieldId();
            this.f13020d = newGodData.getType();
            this.f13021e = newGodData.getTypeName();
            c.a.e.e.m.e.a().postDelayed(this.f13022f, z ? 3000L : 0L);
        }
    }
}
