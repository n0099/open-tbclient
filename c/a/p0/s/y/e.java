package c.a.p0.s.y;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final c f14562a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f14563b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f14564c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.a.p0.s.y.e.c
        public void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || str2 == null) {
                return;
            }
            String str4 = "code:" + str2 + " message:" + str3;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(String str, String str2, String str3);
    }

    /* loaded from: classes3.dex */
    public static final class d implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        @Override // c.a.p0.s.y.e.c
        public void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                StatisticItem statisticItem = new StatisticItem("c10729");
                statisticItem.param("obj_param1", str);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str3);
                if (BdBaseApplication.getInst() != null) {
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-843221903, "Lc/a/p0/s/y/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-843221903, "Lc/a/p0/s/y/e;");
                return;
            }
        }
        f14562a = new b(null);
        f14563b = new d(null);
        f14564c = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, str) == null) && f14564c) {
            f14562a.a(null, null, str);
        }
    }

    public static void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            a(str3);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, str3) == null) {
            if (f14564c) {
                f14562a.a(str, str2, str3);
            }
            f14563b.a(str, str2, str3);
        }
    }
}
