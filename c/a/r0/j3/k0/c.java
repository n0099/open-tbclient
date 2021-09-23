package c.a.r0.j3.k0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, e> f20936a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                c.a(1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(798525095, "Lc/a/r0/j3/k0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(798525095, "Lc/a/r0/j3/k0/c;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2001011));
        f20936a = new HashMap<>();
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            for (String str : f20936a.keySet()) {
                b(f20936a.get(str), i2);
            }
        }
    }

    public static void b(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, eVar, i2) == null) {
            d dVar = eVar.f20944d;
            d dVar2 = eVar.f20945e;
            d dVar3 = eVar.f20946f;
            if (dVar.f20938b + dVar2.f20938b + dVar3.f20938b >= i2) {
                c.a.e.e.n.a aVar = new c.a.e.e.n.a("dbg");
                aVar.b("act", eVar.f20943c);
                aVar.b("httpTimeCost", String.valueOf(dVar.f20937a));
                aVar.b("httpNum", String.valueOf(dVar.f20938b));
                aVar.b("httpFailnum", String.valueOf(dVar.f20939c));
                aVar.b("httpSize", String.valueOf(dVar.f20940d));
                aVar.b("socketTimeCost", String.valueOf(dVar2.f20937a));
                aVar.b("socketNum", String.valueOf(dVar2.f20938b));
                aVar.b("socketFailnum", String.valueOf(dVar2.f20939c));
                aVar.b("socketSize", String.valueOf(dVar2.f20940d));
                aVar.b("abortTimeCost", String.valueOf(dVar3.f20937a));
                aVar.b("abortNum", String.valueOf(dVar3.f20938b));
                aVar.b("netType", eVar.f20942b);
                aVar.b("isJson", eVar.f20941a ? "1" : "0");
                BdStatisticsManager.getInstance().debug("frs", aVar);
                dVar.a();
                dVar2.a();
                dVar3.a();
            }
        }
    }

    public static void c(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, str, str2, z) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (f20936a.containsKey(str3)) {
                return;
            }
            f20936a.put(str3, new e(str, str2, z));
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
        }
    }

    public static e e(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.AD_TEXT_ID, null, str, str2, z)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!f20936a.containsKey(str3)) {
                f20936a.put(str3, new e(str, str2, z));
            }
            return f20936a.get(str3);
        }
        return (e) invokeLLZ.objValue;
    }
}
