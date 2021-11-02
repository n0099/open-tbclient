package b.a.p0.a.n0.l;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.j2.k;
import b.a.p0.a.j2.p.e;
import b.a.p0.a.n0.l.b;
import b.a.p0.a.v2.k0;
import b.a.p0.t.d;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final b.C0310b f6882e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f6883e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6883e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6883e.f();
            }
        }
    }

    public c(b.C0310b c0310b) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0310b};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6882e = c0310b == null ? new b.C0310b() : c0310b;
    }

    public static boolean d(b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) ? aVar != null && aVar.isValid() : invokeL.booleanValue;
    }

    public static c l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? m(null) : (c) invokeV.objValue;
    }

    public static c m(b.C0310b c0310b) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c0310b)) == null) ? new c(c0310b) : (c) invokeL.objValue;
    }

    public c b(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (e() && !TextUtils.isEmpty(str) && !d(this.f6882e.f6878a.get(str))) {
                b.a.p0.a.n0.l.a query = b.a.p0.a.n0.l.a.query(str);
                if (d(query)) {
                    this.f6882e.f6878a.put(query.a(), query);
                }
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.C0310b c0310b = this.f6882e;
            int i2 = c0310b.f6881d;
            return i2 == 0 ? c0310b.f6880c : i2;
        }
        return invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.f6882e) {
                z = this.f6882e.f6879b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        String str;
        b.a value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.f6882e) {
                if (e()) {
                    this.f6882e.f6879b = false;
                    e eVar = new e();
                    eVar.f6383a = "swan";
                    eVar.f6385c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                    int c2 = c();
                    eVar.f6384b = String.valueOf(c2);
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, b.a> entry : this.f6882e.f6878a.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                            jSONArray.put(value.b());
                        }
                    }
                    eVar.a("purged_list", jSONArray);
                    if (7 == c2) {
                        eVar.a("history_list", h());
                        eVar.a("disk_size", g());
                    }
                    if (b.e0) {
                        JSONObject f2 = eVar.f();
                        if (f2 == null) {
                            str = StringUtil.NULL_STRING;
                        } else {
                            try {
                                str = f2.toString(4);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                                str = "" + eVar;
                            }
                        }
                        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
                        while (true) {
                            try {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    String str2 = "report event => " + readLine;
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            } finally {
                                d.d(bufferedReader);
                            }
                        }
                    }
                    k.u("1377", eVar);
                }
            }
        }
    }

    @NonNull
    public final JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            int a2 = k0.a();
            int i2 = b.a.p0.a.k2.b.i();
            int b2 = b.a.p0.a.k2.b.b();
            int k = b.a.p0.a.k2.b.k();
            try {
                jSONObject.put("device", a2);
                jSONObject.put("swan_pkg", i2);
                jSONObject.put("app_pkg", b2);
                jSONObject.put("app_third", k);
            } catch (JSONException e2) {
                if (b.e0) {
                    e2.printStackTrace();
                    String str = "queryDiskSize: e=" + e2;
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public final JSONArray h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                Cursor l = b.a.p0.a.j0.c.b.l();
                int count = l.getCount();
                while (l.moveToNext()) {
                    String string = l.getString(l.getColumnIndex("app_id"));
                    long j = l.getLong(l.getColumnIndex("visit_time"));
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(IntentConfig.PKG_ID, string);
                        jSONObject.put("last_launch_time", j);
                        jSONArray.put(jSONObject);
                    }
                }
                if (b.e0) {
                    String str = "queryHisList: cursor=" + count + " items=" + jSONArray.length();
                }
                if (l != null) {
                    l.close();
                }
            } catch (JSONException e2) {
                if (b.e0) {
                    e2.printStackTrace();
                    String str2 = "queryHisList: e=" + e2;
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public c i(int i2) {
        InterceptResult invokeI;
        b.C0310b c0310b;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (e() && i2 != (i3 = (c0310b = this.f6882e).f6881d) && (i3 == 0 || i3 == c0310b.f6880c)) {
                this.f6882e.f6881d = i2;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (b.e0) {
                String str = "performReport: " + this.f6882e;
            }
            if (e()) {
                ExecutorUtilsExt.postOnElastic(new a(this), "PurgerStatistic", 3);
            }
        }
    }

    public b.C0310b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f6882e : (b.C0310b) invokeV.objValue;
    }

    public c n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (e()) {
                this.f6882e.f6880c = i2;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }
}
