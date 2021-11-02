package b.a.r0.l3.l0;

import android.os.Build;
import b.a.e.e.p.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.r0.l3.l0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C1023a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f20672a;

        /* renamed from: b  reason: collision with root package name */
        public final String f20673b;

        /* renamed from: c  reason: collision with root package name */
        public final String f20674c;

        /* renamed from: d  reason: collision with root package name */
        public final String f20675d;

        /* renamed from: e  reason: collision with root package name */
        public final String f20676e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f20677f;

        /* renamed from: g  reason: collision with root package name */
        public final StatisticItem f20678g;

        public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, C1023a c1023a) {
            this(str, str2, str3, str4, str5);
        }

        public final StatisticItem b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StatisticItem statisticItem = new StatisticItem(this.f20672a);
                if (!StringUtils.isNull(this.f20673b)) {
                    statisticItem = statisticItem.param("line", this.f20673b);
                }
                if (!StringUtils.isNull(this.f20674c)) {
                    statisticItem = statisticItem.param("page", this.f20674c);
                }
                if (!StringUtils.isNull(this.f20675d)) {
                    statisticItem = statisticItem.param("locate", this.f20675d);
                }
                return !StringUtils.isNull(this.f20676e) ? statisticItem.param("task", this.f20676e) : statisticItem;
            }
            return (StatisticItem) invokeV.objValue;
        }

        public final StatisticItem c(String str, String str2, String str3, String str4, String str5) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4, str5)) == null) {
                if (!StringUtils.isNull(str)) {
                    this.f20678g.param(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
                }
                if (!StringUtils.isNull(str2)) {
                    this.f20678g.param("obj_id", str2);
                }
                if (!StringUtils.isNull(str3)) {
                    this.f20678g.param("fid", str3);
                }
                if (!StringUtils.isNull(str4)) {
                    this.f20678g.param("fname", str4);
                }
                if (!StringUtils.isNull(str5)) {
                    this.f20678g.param("tid", str5);
                }
                this.f20678g.param("obj_cpid", 0).param("obj_good_id", 0).param("obj_throw_type", "BY_POST").param("client_type", "MOBILE_APP").param("user_timestamp", String.valueOf(System.currentTimeMillis())).param("os", "android").param(HttpConstants.OS_VERSION, Build.VERSION.RELEASE).param("log_ver", "1.1");
                return this.f20678g;
            }
            return (StatisticItem) invokeLLLLL.objValue;
        }

        public b d(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
                if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                    this.f20678g.param(str, str2);
                }
                return this;
            }
            return (b) invokeLL.objValue;
        }

        public void delete(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f20678g.delete(str);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                TiebaStatic.log(this.f20678g);
                if (this.f20677f) {
                    return;
                }
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    BdLog.e("Invalid parameter.");
                    return;
                }
                throw new IllegalArgumentException();
            }
        }

        public b(String str, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20672a = str;
            this.f20673b = str2;
            this.f20674c = str3;
            this.f20675d = str4;
            this.f20676e = str5;
            this.f20677f = !(StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5));
            this.f20678g = b();
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f20679a;

        /* renamed from: b  reason: collision with root package name */
        public String f20680b;

        /* renamed from: c  reason: collision with root package name */
        public int f20681c;

        public c() {
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
    }

    public static b a(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            b bVar = new b("ad_tpoint", "PT", str, str2, "tpoint", null);
            bVar.c(null, null, str3, str4, str5);
            if (!k.isEmpty(str6)) {
                bVar.d("obj_ref", str6);
            }
            return bVar;
        }
        return (b) invokeCommon.objValue;
    }

    public static b b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10})) == null) {
            b bVar = new b(str, str2, str3, str4, str5, null);
            bVar.c(str6, str7, str8, str9, str10);
            return bVar;
        }
        return (b) invokeCommon.objValue;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, str4, str5, str6, str7}) == null) {
            b bVar = new b("ad_tpoint", "PT", str, "c0122", "ad_plat", null);
            bVar.c(str2, str7, str3, str4, str5);
            bVar.d(TiebaStatic.Params.OBJ_URL, str6);
            bVar.e();
        }
    }

    @Deprecated
    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || k.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (str2 != null) {
            statisticItem = statisticItem.param("obj_type", str2);
        }
        TiebaStatic.log(statisticItem);
    }
}
