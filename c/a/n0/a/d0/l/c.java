package c.a.n0.a.d0.l;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d0.l.b;
import c.a.n0.a.d2.n;
import c.a.n0.a.d2.s.e;
import c.a.n0.a.p2.k0;
import c.a.n0.w.d;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
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
    public final b.C0236b a;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    public c(b.C0236b c0236b) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0236b};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c0236b == null ? new b.C0236b() : c0236b;
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

    public static c m(b.C0236b c0236b) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c0236b)) == null) ? new c(c0236b) : (c) invokeL.objValue;
    }

    public c b(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (e() && !TextUtils.isEmpty(str) && !d(this.a.a.get(str))) {
                c.a.n0.a.d0.l.a query = c.a.n0.a.d0.l.a.query(str);
                if (d(query)) {
                    this.a.a.put(query.a(), query);
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
            b.C0236b c0236b = this.a;
            int i = c0236b.f4079d;
            return i == 0 ? c0236b.f4078c : i;
        }
        return invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.a) {
                z = this.a.f4077b;
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
            synchronized (this.a) {
                if (e()) {
                    this.a.f4077b = false;
                    e eVar = new e();
                    eVar.a = "swan";
                    eVar.f4189c = "NA";
                    int c2 = c();
                    eVar.f4188b = String.valueOf(c2);
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, b.a> entry : this.a.a.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                            jSONArray.put(value.b());
                        }
                    }
                    eVar.a("purged_list", jSONArray);
                    if (7 == c2) {
                        eVar.a("history_list", h());
                        eVar.a("disk_size", g());
                    }
                    if (b.c0) {
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
                                    Log.i("PurgerStatistic", "report event => " + readLine);
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            } finally {
                                d.d(bufferedReader);
                            }
                        }
                    }
                    n.x("1377", eVar);
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
            int i = c.a.n0.a.e2.b.i();
            int b2 = c.a.n0.a.e2.b.b();
            int k = c.a.n0.a.e2.b.k();
            try {
                jSONObject.put(Config.DEVICE_PART, a2);
                jSONObject.put("swan_pkg", i);
                jSONObject.put("app_pkg", b2);
                jSONObject.put("app_third", k);
            } catch (JSONException e2) {
                if (b.c0) {
                    e2.printStackTrace();
                    Log.i("PurgerStatistic", "queryDiskSize: e=" + e2);
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
                Cursor m = c.a.n0.a.z.c.b.m();
                int count = m.getCount();
                while (m.moveToNext()) {
                    String string = m.getString(m.getColumnIndex("app_id"));
                    long j = m.getLong(m.getColumnIndex("visit_time"));
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(IntentConfig.PKG_ID, string);
                        jSONObject.put("last_launch_time", j);
                        jSONArray.put(jSONObject);
                    }
                }
                if (b.c0) {
                    Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
                }
                if (m != null) {
                    m.close();
                }
            } catch (JSONException e2) {
                if (b.c0) {
                    e2.printStackTrace();
                    Log.i("PurgerStatistic", "queryHisList: e=" + e2);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public c i(int i) {
        InterceptResult invokeI;
        b.C0236b c0236b;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (e() && i != (i2 = (c0236b = this.a).f4079d) && (i2 == 0 || i2 == c0236b.f4078c)) {
                this.a.f4079d = i;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (b.c0) {
                Log.i("PurgerStatistic", "performReport: " + this.a);
            }
            if (e()) {
                ExecutorUtilsExt.postOnElastic(new a(this), "PurgerStatistic", 3);
            }
        }
    }

    public b.C0236b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : (b.C0236b) invokeV.objValue;
    }

    public c n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (e()) {
                this.a.f4078c = i;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }
}
