package c.a.c0.g0.s;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public c f1606b;

    /* renamed from: c  reason: collision with root package name */
    public String f1607c;

    /* renamed from: d  reason: collision with root package name */
    public String f1608d;

    /* renamed from: e  reason: collision with root package name */
    public String f1609e;

    /* renamed from: f  reason: collision with root package name */
    public String f1610f;

    /* renamed from: g  reason: collision with root package name */
    public String f1611g;

    /* renamed from: h  reason: collision with root package name */
    public String f1612h;

    /* renamed from: i  reason: collision with root package name */
    public a f1613i;

    /* renamed from: j  reason: collision with root package name */
    public C0048b f1614j;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f1615b;

        /* renamed from: c  reason: collision with root package name */
        public double f1616c;

        public a() {
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

        public static a b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                a aVar = new a();
                JSONObject b2 = c.a.c0.u.b.b(str);
                aVar.a = b2.optString("defer_charge_url");
                aVar.f1615b = b2.optInt("defer_type", 3);
                aVar.f1616c = b2.optDouble("defer_time", 0.0d);
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f1615b;
                return (i2 == 2 || i2 == 3) && this.f1616c > 0.0d && !TextUtils.isEmpty(this.a);
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: c.a.c0.g0.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0048b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f1617b;

        /* renamed from: c  reason: collision with root package name */
        public String f1618c;

        /* renamed from: d  reason: collision with root package name */
        public String f1619d;

        /* renamed from: e  reason: collision with root package name */
        public String f1620e;

        public C0048b() {
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

        public static C0048b a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                C0048b c0048b = new C0048b();
                JSONObject b2 = c.a.c0.u.b.b(str);
                c0048b.f1620e = b2.optString("key");
                b2.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME);
                c0048b.a = b2.optString("download_url");
                b2.optString(BreakpointSQLiteKey.CONTENT_LENGTH);
                c0048b.f1617b = b2.optString("close_virtual_progress");
                c0048b.f1618c = b2.optString("apk_label");
                c0048b.f1619d = b2.optString("apk_icon");
                return c0048b;
            }
            return (C0048b) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

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

        public static c a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                c cVar = new c();
                JSONObject b2 = c.a.c0.u.b.b(str);
                cVar.a = b2.optString("receive_title_script");
                b2.optString("start_load_script");
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

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

    public static b b(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            Bundle extras = intent.getExtras();
            b bVar = null;
            if (extras == null) {
                return null;
            }
            Serializable serializable = extras.getSerializable("map");
            if (serializable instanceof HashMap) {
                HashMap hashMap = (HashMap) serializable;
                if (hashMap != null && !hashMap.isEmpty()) {
                    bVar = new b();
                    bVar.f1607c = (String) c.a.c0.u.c.b(hashMap, LegoListActivityConfig.AD_ID);
                    bVar.a = (String) c.a.c0.u.c.b(hashMap, "url");
                    bVar.f1610f = (String) c.a.c0.u.c.b(hashMap, "ext_info");
                    bVar.f1611g = (String) c.a.c0.u.c.b(hashMap, TiebaStatic.Params.REFER);
                    bVar.f1608d = (String) c.a.c0.u.c.b(hashMap, "charge_url");
                    bVar.f1609e = (String) c.a.c0.u.c.b(hashMap, "ad_invoke_flag");
                    String str = (String) c.a.c0.u.c.b(hashMap, "lp_real_url");
                    String str2 = (String) c.a.c0.u.c.b(hashMap, "log_switch");
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "1";
                    }
                    bVar.f1612h = str2;
                    String str3 = (String) c.a.c0.u.c.b(hashMap, "sdk_script");
                    if (!TextUtils.isEmpty(str3)) {
                        bVar.f1606b = c.a(str3);
                    }
                    String str4 = (String) c.a.c0.u.c.b(hashMap, "defer_charge");
                    if (!TextUtils.isEmpty(str4)) {
                        bVar.f1613i = a.b(str4);
                    }
                    String str5 = (String) c.a.c0.u.c.b(hashMap, "download");
                    if (!TextUtils.isEmpty(str5)) {
                        bVar.f1614j = C0048b.a(str5);
                    }
                    bVar.c();
                }
                return bVar;
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.equals(this.f1609e, "0") : invokeV.booleanValue;
    }

    public final void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TextUtils.isEmpty(this.f1611g)) {
            return;
        }
        if (this.f1611g.contains("__CHARGE_URL__") && !TextUtils.isEmpty(this.f1608d)) {
            this.f1611g = this.f1611g.replace("__CHARGE_URL__", this.f1608d);
        }
        if (!this.f1611g.contains("__DEFER_CHARGE_URL__") || (aVar = this.f1613i) == null || TextUtils.isEmpty(aVar.a)) {
            return;
        }
        this.f1611g = this.f1611g.replace("__DEFER_CHARGE_URL__", this.f1613i.a);
    }
}
