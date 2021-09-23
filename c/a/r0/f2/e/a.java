package c.a.r0.f2.e;

import c.a.q0.b.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    public static final C0863a f17663a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.f2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0863a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0863a() {
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
        public final void a(int i2, int i3, int i4, String str, String str2) {
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2}) == null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_CLICK);
                statisticItem.param("obj_name", i2);
                if (d.n()) {
                    i5 = 1;
                } else {
                    i5 = d.o() ? 2 : 3;
                }
                statisticItem.param("obj_type", i5);
                statisticItem.param("obj_locate", i3);
                statisticItem.param("obj_source", i4);
                statisticItem.param("obj_param1", str);
                statisticItem.param("fid", str2);
                TiebaStatic.log(statisticItem);
            }
        }

        @JvmStatic
        public final void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_SEE_MORE_CLICK);
                statisticItem.param("obj_name", str);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }

        @JvmStatic
        public final void c(int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_SHOW);
                statisticItem.param("obj_name", i2);
                if (d.n()) {
                    i4 = 1;
                } else {
                    i4 = d.o() ? 2 : 3;
                }
                statisticItem.param("obj_type", i4);
                statisticItem.param("obj_source", i3);
                TiebaStatic.log(statisticItem);
            }
        }

        public /* synthetic */ C0863a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(603356764, "Lc/a/r0/f2/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(603356764, "Lc/a/r0/f2/e/a;");
                return;
            }
        }
        f17663a = new C0863a(null);
    }

    @JvmStatic
    public static final void a(int i2, int i3, int i4, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2}) == null) {
            f17663a.a(i2, i3, i4, str, str2);
        }
    }

    @JvmStatic
    public static final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            f17663a.b(str);
        }
    }

    @JvmStatic
    public static final void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, null, i2, i3) == null) {
            f17663a.c(i2, i3);
        }
    }
}
