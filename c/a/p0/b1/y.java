package c.a.p0.b1;

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
public class y {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static y f12940g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12941a;

    /* renamed from: b  reason: collision with root package name */
    public String f12942b;

    /* renamed from: c  reason: collision with root package name */
    public String f12943c;

    /* renamed from: d  reason: collision with root package name */
    public int f12944d;

    /* renamed from: e  reason: collision with root package name */
    public String f12945e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f12946f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f12947e;

        public a(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12947e = yVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("from", String.valueOf(this.f12947e.f12941a));
                hashMap.put("field_id", this.f12947e.f12942b);
                hashMap.put("type", Integer.valueOf(this.f12947e.f12944d));
                hashMap.put("type_name", this.f12947e.f12945e);
                if (this.f12947e.f12941a == 2) {
                    hashMap.put("fid", this.f12947e.f12943c);
                }
                hashMap.put("animated", Boolean.FALSE);
                hashMap.put(OpenFlutter.EXTRA_TRANSPARANT, Boolean.TRUE);
                hashMap.put("swipeback", Boolean.FALSE);
                if (PluginPackageManager.O().y("com.baidu.tieba.pluginFlutter")) {
                    if (MessageManager.getInstance().findTask(2002015) == null) {
                        c.a.e.e.m.e.a().postDelayed(this.f12947e.f12946f, 0L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new c.a.q0.i3.i0.n(TbadkApplication.getInst().getApplicationContext(), "GodDialog", hashMap)));
                    c.a.p0.s.d0.b.j().w("key_new_god_dialog_showed_time", System.currentTimeMillis());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1705477831, "Lc/a/p0/b1/y;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1705477831, "Lc/a/p0/b1/y;");
        }
    }

    public y() {
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
        this.f12946f = new a(this);
    }

    public static synchronized y g() {
        InterceptResult invokeV;
        y yVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (y.class) {
                if (f12940g == null) {
                    f12940g = new y();
                }
                yVar = f12940g;
            }
            return yVar;
        }
        return (y) invokeV.objValue;
    }

    public final boolean h(int i2, NewGodData newGodData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, newGodData)) == null) {
            if (i2 != 5) {
                return (((((System.currentTimeMillis() - c.a.p0.s.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) > 259200000L ? 1 : (((System.currentTimeMillis() - c.a.p0.s.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) == 259200000L ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.f12946f);
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f12943c = str;
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
            this.f12941a = i2;
            this.f12942b = newGodData.getFieldId();
            this.f12944d = newGodData.getType();
            this.f12945e = newGodData.getTypeName();
            c.a.e.e.m.e.a().postDelayed(this.f12946f, z ? 3000L : 0L);
        }
    }
}
