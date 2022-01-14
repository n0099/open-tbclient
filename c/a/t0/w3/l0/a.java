package c.a.t0.w3.l0;

import android.os.Build;
import c.a.d.f.p.m;
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
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.t0.w3.l0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1504a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final String f24893b;

        /* renamed from: c  reason: collision with root package name */
        public final String f24894c;

        /* renamed from: d  reason: collision with root package name */
        public final String f24895d;

        /* renamed from: e  reason: collision with root package name */
        public final String f24896e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f24897f;

        /* renamed from: g  reason: collision with root package name */
        public final StatisticItem f24898g;

        public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, C1504a c1504a) {
            this(str, str2, str3, str4, str5);
        }

        public final StatisticItem b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StatisticItem statisticItem = new StatisticItem(this.a);
                if (!StringUtils.isNull(this.f24893b)) {
                    statisticItem = statisticItem.param("line", this.f24893b);
                }
                if (!StringUtils.isNull(this.f24894c)) {
                    statisticItem = statisticItem.param("page", this.f24894c);
                }
                if (!StringUtils.isNull(this.f24895d)) {
                    statisticItem = statisticItem.param("locate", this.f24895d);
                }
                return !StringUtils.isNull(this.f24896e) ? statisticItem.param("task", this.f24896e) : statisticItem;
            }
            return (StatisticItem) invokeV.objValue;
        }

        public final StatisticItem c(String str, String str2, String str3, String str4, String str5) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4, str5)) == null) {
                if (!StringUtils.isNull(str)) {
                    this.f24898g.param(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
                }
                if (!StringUtils.isNull(str2)) {
                    this.f24898g.param("obj_id", str2);
                }
                if (!StringUtils.isNull(str3)) {
                    this.f24898g.param("fid", str3);
                }
                if (!StringUtils.isNull(str4)) {
                    this.f24898g.param("fname", str4);
                }
                if (!StringUtils.isNull(str5)) {
                    this.f24898g.param("tid", str5);
                }
                this.f24898g.param("obj_cpid", 0).param("obj_good_id", 0).param("obj_throw_type", "BY_POST").param("client_type", "MOBILE_APP").param("user_timestamp", String.valueOf(System.currentTimeMillis())).param(UrlOcrConfig.IdCardKey.OS, "android").param(HttpConstants.OS_VERSION, Build.VERSION.RELEASE).param("log_ver", "1.1");
                return this.f24898g;
            }
            return (StatisticItem) invokeLLLLL.objValue;
        }

        public b d(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
                if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                    this.f24898g.param(str, str2);
                }
                return this;
            }
            return (b) invokeLL.objValue;
        }

        public void delete(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f24898g.delete(str);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                TiebaStatic.log(this.f24898g);
                if (this.f24897f) {
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
            this.a = str;
            this.f24893b = str2;
            this.f24894c = str3;
            this.f24895d = str4;
            this.f24896e = str5;
            this.f24897f = !(StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5));
            this.f24898g = b();
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f24899b;

        /* renamed from: c  reason: collision with root package name */
        public int f24900c;

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
            if (!m.isEmpty(str6)) {
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
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || m.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (str2 != null) {
            statisticItem = statisticItem.param("obj_type", str2);
        }
        TiebaStatic.log(statisticItem);
    }
}
