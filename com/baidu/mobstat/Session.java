package com.baidu.mobstat;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Session {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile long a;
    public volatile long b;
    public volatile long c;
    public volatile long d;
    public volatile long e;
    public volatile int f;
    public List<a> g;
    public volatile JSONObject h;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public long d;
        public long e;
        public boolean f;
        public JSONObject g;
        public boolean h;
        public String i;

        public a(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, str3, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), extraInfo, Boolean.valueOf(z2), str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = str;
            this.c = str2;
            this.a = str3;
            this.d = j;
            this.e = j2;
            this.f = z;
            this.i = str4;
            this.g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.h = z2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.d;
            }
            return invokeV.longValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.e;
            }
            return invokeV.longValue;
        }

        public JSONObject e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.g;
            }
            return (JSONObject) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.f;
            }
            return invokeV.booleanValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.i;
            }
            return (String) invokeV.objValue;
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a = aVar.a;
                this.b = aVar.b;
                this.c = aVar.c;
                this.d = aVar.d;
                this.e = aVar.e;
                this.f = aVar.f;
                this.g = aVar.g;
                this.h = aVar.h;
                this.i = aVar.i;
            }
        }
    }

    public Session() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0;
        this.g = new ArrayList();
        this.h = null;
    }

    private void a(List<a> list, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, list, aVar) == null) {
            try {
                if (!bu.a().e() || list == null || aVar == null) {
                    return;
                }
                int size = list.size();
                if (size == 0) {
                    list.add(aVar);
                    return;
                }
                a aVar2 = list.get(size - 1);
                if (!TextUtils.isEmpty(aVar2.a) && !TextUtils.isEmpty(aVar.a)) {
                    if (aVar2.a.equals(aVar.a) && aVar2.f != aVar.f) {
                        if (aVar2.f) {
                            aVar2.a(aVar);
                            return;
                        }
                        return;
                    }
                    list.add(aVar);
                    return;
                }
                list.add(aVar);
            } catch (Exception unused) {
            }
        }
    }

    public static JSONObject getPVJson(a aVar, long j) {
        InterceptResult invokeLJ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, aVar, j)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", aVar.a());
                jSONObject.put("d", aVar.c());
                long d = aVar.d() - j;
                if (d < 0) {
                    d = 0;
                }
                jSONObject.put("ps", d);
                jSONObject.put("t", aVar.b());
                int i2 = 1;
                if (aVar.f()) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("at", i);
                JSONObject e = aVar.e();
                if (e != null && e.length() != 0) {
                    jSONObject.put("ext", e);
                }
                if (!aVar.h) {
                    i2 = 0;
                }
                jSONObject.put("h5", i2);
                jSONObject.put(Config.PY, aVar.g());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLJ.objValue;
    }

    public void addPageView(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            a(this.g, aVar);
        }
    }

    public void setEndTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.b = j;
        }
    }

    public void setInvokeType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f = i;
        }
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            this.h = jSONObject;
        }
    }

    public void setStartTime(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048589, this, j) != null) || this.a > 0) {
            return;
        }
        this.a = j;
        this.e = j;
    }

    public void setTrackEndTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.d = j;
        }
    }

    public void setTrackStartTime(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048591, this, j) != null) || this.c > 0) {
            return;
        }
        this.c = j;
    }

    public void addPageView(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), extraInfo, Boolean.valueOf(z2), str4}) == null) {
            a(this.g, new a(str, str2, str3, j, j2, z, extraInfo, z2, str4));
        }
    }

    public JSONObject constructJSONObject() {
        InterceptResult invokeV;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("s", this.a);
                jSONObject.put("e", this.b);
                jSONObject.put("i", this.e);
                jSONObject.put("c", 1);
                if (this.c == 0) {
                    j = this.a;
                } else {
                    j = this.c;
                }
                jSONObject.put(Config.SESSTION_TRACK_START_TIME, j);
                if (this.d == 0) {
                    j2 = this.b;
                } else {
                    j2 = this.d;
                }
                jSONObject.put(Config.SESSTION_TRACK_END_TIME, j2);
                jSONObject.put("pc", this.f);
                if (this.h != null && this.h.length() != 0) {
                    jSONObject.put("launch", this.h);
                }
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.g.size(); i++) {
                    jSONArray.put(getPVJson(this.g.get(i), this.a));
                }
                if (bu.a().e()) {
                    jSONObject.put("p", jSONArray);
                }
                jSONObject.put(Config.PY, DataCore.instance().getSessionPy());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("s", this.a);
                jSONObject.put("e", this.b);
                jSONObject.put("i", this.e);
                jSONObject.put("c", 1);
                if (this.c == 0) {
                    j = this.a;
                } else {
                    j = this.c;
                }
                jSONObject.put(Config.SESSTION_TRACK_START_TIME, j);
                if (this.d == 0) {
                    j2 = this.b;
                } else {
                    j2 = this.d;
                }
                jSONObject.put(Config.SESSTION_TRACK_END_TIME, j2);
                jSONObject.put("pc", this.f);
                jSONObject.put(Config.PY, DataCore.instance().getSessionPy());
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    public long getTrackEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public long getTrackStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public boolean hasEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.b > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a = 0L;
            this.b = 0L;
            this.c = 0L;
            this.d = 0L;
            this.f = 0;
            this.g.clear();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return constructJSONObject().toString();
        }
        return (String) invokeV.objValue;
    }
}
