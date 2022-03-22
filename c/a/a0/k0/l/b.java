package c.a.a0.k0.l;

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
    public c f1333b;

    /* renamed from: c  reason: collision with root package name */
    public String f1334c;

    /* renamed from: d  reason: collision with root package name */
    public String f1335d;

    /* renamed from: e  reason: collision with root package name */
    public String f1336e;

    /* renamed from: f  reason: collision with root package name */
    public String f1337f;

    /* renamed from: g  reason: collision with root package name */
    public String f1338g;

    /* renamed from: h  reason: collision with root package name */
    public String f1339h;
    public a i;
    public C0046b j;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f1340b;

        /* renamed from: c  reason: collision with root package name */
        public double f1341c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                JSONObject b2 = c.a.a0.x.b.b(str);
                aVar.a = b2.optString("defer_charge_url");
                aVar.f1340b = b2.optInt("defer_type", 3);
                aVar.f1341c = b2.optDouble("defer_time", 0.0d);
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.f1340b;
                return (i == 2 || i == 3) && this.f1341c > 0.0d && !TextUtils.isEmpty(this.a);
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: c.a.a0.k0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0046b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f1342b;

        /* renamed from: c  reason: collision with root package name */
        public String f1343c;

        /* renamed from: d  reason: collision with root package name */
        public String f1344d;

        /* renamed from: e  reason: collision with root package name */
        public String f1345e;

        public C0046b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static C0046b a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                C0046b c0046b = new C0046b();
                JSONObject b2 = c.a.a0.x.b.b(str);
                c0046b.f1345e = b2.optString("key");
                b2.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME);
                c0046b.a = b2.optString("download_url");
                b2.optString(BreakpointSQLiteKey.CONTENT_LENGTH);
                c0046b.f1342b = b2.optString("close_virtual_progress");
                c0046b.f1343c = b2.optString("apk_label");
                c0046b.f1344d = b2.optString("apk_icon");
                return c0046b;
            }
            return (C0046b) invokeL.objValue;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                JSONObject b2 = c.a.a0.x.b.b(str);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    bVar.f1334c = (String) c.a.a0.x.c.b(hashMap, LegoListActivityConfig.AD_ID);
                    bVar.a = (String) c.a.a0.x.c.b(hashMap, "url");
                    bVar.f1337f = (String) c.a.a0.x.c.b(hashMap, "ext_info");
                    bVar.f1338g = (String) c.a.a0.x.c.b(hashMap, TiebaStatic.Params.REFER);
                    bVar.f1335d = (String) c.a.a0.x.c.b(hashMap, "charge_url");
                    bVar.f1336e = (String) c.a.a0.x.c.b(hashMap, "ad_invoke_flag");
                    String str = (String) c.a.a0.x.c.b(hashMap, "lp_real_url");
                    String str2 = (String) c.a.a0.x.c.b(hashMap, "log_switch");
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "1";
                    }
                    bVar.f1339h = str2;
                    String str3 = (String) c.a.a0.x.c.b(hashMap, "sdk_script");
                    if (!TextUtils.isEmpty(str3)) {
                        bVar.f1333b = c.a(str3);
                    }
                    String str4 = (String) c.a.a0.x.c.b(hashMap, "defer_charge");
                    if (!TextUtils.isEmpty(str4)) {
                        bVar.i = a.b(str4);
                    }
                    String str5 = (String) c.a.a0.x.c.b(hashMap, "download");
                    if (!TextUtils.isEmpty(str5)) {
                        bVar.j = C0046b.a(str5);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.equals(this.f1336e, "0") : invokeV.booleanValue;
    }

    public final void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TextUtils.isEmpty(this.f1338g)) {
            return;
        }
        if (this.f1338g.contains("__CHARGE_URL__") && !TextUtils.isEmpty(this.f1335d)) {
            this.f1338g = this.f1338g.replace("__CHARGE_URL__", this.f1335d);
        }
        if (!this.f1338g.contains("__DEFER_CHARGE_URL__") || (aVar = this.i) == null || TextUtils.isEmpty(aVar.a)) {
            return;
        }
        this.f1338g = this.f1338g.replace("__DEFER_CHARGE_URL__", this.i.a);
    }
}
