package c.a.p0.e2.d;

import c.a.o0.b.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final C0813a f16697a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.e2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0813a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0813a() {
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

        @JvmStatic
        public final void a(int i2, int i3, int i4) {
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_CLICK);
                statisticItem.param("obj_name", i2);
                if (d.w()) {
                    i5 = 1;
                } else {
                    i5 = d.x() ? 2 : 3;
                }
                statisticItem.param("obj_type", i5);
                statisticItem.param("obj_locate", i3);
                statisticItem.param("obj_source", i4);
                TiebaStatic.log(statisticItem);
            }
        }

        @JvmStatic
        public final void b(int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_SHOW);
                statisticItem.param("obj_name", i2);
                if (d.w()) {
                    i4 = 1;
                } else {
                    i4 = d.x() ? 2 : 3;
                }
                statisticItem.param("obj_type", i4);
                statisticItem.param("obj_source", i3);
                TiebaStatic.log(statisticItem);
            }
        }

        public /* synthetic */ C0813a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(108850302, "Lc/a/p0/e2/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(108850302, "Lc/a/p0/e2/d/a;");
                return;
            }
        }
        f16697a = new C0813a(null);
    }

    @JvmStatic
    public static final void a(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65537, null, i2, i3, i4) == null) {
            f16697a.a(i2, i3, i4);
        }
    }

    @JvmStatic
    public static final void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, null, i2, i3) == null) {
            f16697a.b(i2, i3);
        }
    }
}
