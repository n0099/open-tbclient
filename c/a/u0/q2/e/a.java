package c.a.u0.q2.e;

import c.a.t0.b.d;
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
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final C1316a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.u0.q2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1316a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1316a() {
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

        public /* synthetic */ C1316a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(int i2, int i3, int i4, String objParam1, String fid) {
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), objParam1, fid}) == null) {
                Intrinsics.checkNotNullParameter(objParam1, "objParam1");
                Intrinsics.checkNotNullParameter(fid, "fid");
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
                statisticItem.param("obj_param1", objParam1);
                statisticItem.param("fid", fid);
                TiebaStatic.log(statisticItem);
            }
        }

        @JvmStatic
        public final void b(String objName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objName) == null) {
                Intrinsics.checkNotNullParameter(objName, "objName");
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_SEE_MORE_CLICK);
                statisticItem.param("obj_name", objName);
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1186422148, "Lc/a/u0/q2/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1186422148, "Lc/a/u0/q2/e/a;");
                return;
            }
        }
        a = new C1316a(null);
    }

    @JvmStatic
    public static final void a(int i2, int i3, int i4, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2}) == null) {
            a.a(i2, i3, i4, str, str2);
        }
    }

    @JvmStatic
    public static final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            a.b(str);
        }
    }

    @JvmStatic
    public static final void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, null, i2, i3) == null) {
            a.c(i2, i3);
        }
    }
}
