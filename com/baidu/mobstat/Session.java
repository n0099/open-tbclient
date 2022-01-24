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
/* loaded from: classes10.dex */
public class Session {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile long a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f36364b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f36365c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f36366d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f36367e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f36368f;

    /* renamed from: g  reason: collision with root package name */
    public List<a> f36369g;

    /* renamed from: h  reason: collision with root package name */
    public volatile JSONObject f36370h;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f36371b;

        /* renamed from: c  reason: collision with root package name */
        public String f36372c;

        /* renamed from: d  reason: collision with root package name */
        public long f36373d;

        /* renamed from: e  reason: collision with root package name */
        public long f36374e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f36375f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f36376g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f36377h;

        public a(String str, String str2, String str3, long j2, long j3, boolean z, ExtraInfo extraInfo, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), extraInfo, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36371b = str;
            this.f36372c = str2;
            this.a = str3;
            this.f36373d = j2;
            this.f36374e = j3;
            this.f36375f = z;
            this.f36376g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.f36377h = z2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36371b : (String) invokeV.objValue;
        }

        public JSONObject e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36376g : (JSONObject) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f36375f : invokeV.booleanValue;
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a = aVar.a;
                this.f36371b = aVar.f36371b;
                this.f36372c = aVar.f36372c;
                this.f36373d = aVar.f36373d;
                this.f36374e = aVar.f36374e;
                this.f36375f = aVar.f36375f;
                this.f36376g = aVar.f36376g;
                this.f36377h = aVar.f36377h;
            }
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36372c : (String) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f36373d : invokeV.longValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36374e : invokeV.longValue;
        }
    }

    public Session() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f36364b = 0L;
        this.f36365c = 0L;
        this.f36366d = 0L;
        this.f36367e = 0L;
        this.f36368f = 0;
        this.f36369g = new ArrayList();
        this.f36370h = null;
    }

    private void a(List<a> list, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, list, aVar) == null) || list == null || aVar == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(aVar);
            return;
        }
        a aVar2 = list.get(size - 1);
        if (!TextUtils.isEmpty(aVar2.a) && !TextUtils.isEmpty(aVar.a)) {
            if (aVar2.a.equals(aVar.a) && aVar2.f36375f != aVar.f36375f) {
                if (aVar2.f36375f) {
                    aVar2.a(aVar);
                    return;
                }
                return;
            }
            list.add(aVar);
            return;
        }
        list.add(aVar);
    }

    public static JSONObject getPVJson(a aVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, aVar, j2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", aVar.a());
                jSONObject.put("d", aVar.c());
                long d2 = aVar.d() - j2;
                if (d2 < 0) {
                    d2 = 0;
                }
                jSONObject.put("ps", d2);
                jSONObject.put("t", aVar.b());
                int i2 = 1;
                jSONObject.put("at", aVar.f() ? 1 : 0);
                JSONObject e2 = aVar.e();
                if (e2 != null && e2.length() != 0) {
                    jSONObject.put("ext", e2);
                }
                if (!aVar.f36377h) {
                    i2 = 0;
                }
                jSONObject.put("h5", i2);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLJ.objValue;
    }

    public void addPageView(String str, String str2, String str3, long j2, long j3, boolean z, ExtraInfo extraInfo, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), extraInfo, Boolean.valueOf(z2)}) == null) {
            a(this.f36369g, new a(str, str2, str3, j2, j3, z, extraInfo, z2));
        }
    }

    public JSONObject constructJSONObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("s", this.a);
                jSONObject.put("e", this.f36364b);
                jSONObject.put("i", this.f36367e);
                jSONObject.put("c", 1);
                jSONObject.put("s2", this.f36365c == 0 ? this.a : this.f36365c);
                jSONObject.put("e2", this.f36366d == 0 ? this.f36364b : this.f36366d);
                jSONObject.put("pc", this.f36368f);
                if (this.f36370h != null && this.f36370h.length() != 0) {
                    jSONObject.put("launch", this.f36370h);
                }
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.f36369g.size(); i2++) {
                    jSONArray.put(getPVJson(this.f36369g.get(i2), this.a));
                }
                jSONObject.put("p", jSONArray);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("s", this.a);
                jSONObject.put("e", this.f36364b);
                jSONObject.put("i", this.f36367e);
                jSONObject.put("c", 1);
                jSONObject.put("s2", this.f36365c == 0 ? this.a : this.f36365c);
                jSONObject.put("e2", this.f36366d == 0 ? this.f36364b : this.f36366d);
                jSONObject.put("pc", this.f36368f);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.longValue;
    }

    public boolean hasEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36364b > 0 : invokeV.booleanValue;
    }

    public boolean hasStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a > 0 : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = 0L;
            this.f36364b = 0L;
            this.f36365c = 0L;
            this.f36366d = 0L;
            this.f36368f = 0;
            this.f36369g.clear();
        }
    }

    public void setEndTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.f36364b = j2;
        }
    }

    public void setInvokeType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f36368f = i2;
        }
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) {
            this.f36370h = jSONObject;
        }
    }

    public void setStartTime(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) || this.a > 0) {
            return;
        }
        this.a = j2;
        this.f36367e = j2;
    }

    public void setTrackEndTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.f36366d = j2;
        }
    }

    public void setTrackStartTime(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) || this.f36365c > 0) {
            return;
        }
        this.f36365c = j2;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? constructJSONObject().toString() : (String) invokeV.objValue;
    }

    public void addPageView(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            a(this.f36369g, aVar);
        }
    }
}
