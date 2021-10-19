package com.baidu.mobstat.dxmpay;

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
/* loaded from: classes5.dex */
public class Session {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile long f43734a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f43735b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f43736c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f43737d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f43738e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f43739f;

    /* renamed from: g  reason: collision with root package name */
    public List<a> f43740g;

    /* renamed from: h  reason: collision with root package name */
    public volatile JSONObject f43741h;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f43742a;

        /* renamed from: b  reason: collision with root package name */
        public String f43743b;

        /* renamed from: c  reason: collision with root package name */
        public String f43744c;

        /* renamed from: d  reason: collision with root package name */
        public long f43745d;

        /* renamed from: e  reason: collision with root package name */
        public long f43746e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f43747f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f43748g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f43749h;

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
            this.f43743b = str;
            this.f43744c = str2;
            this.f43742a = str3;
            this.f43745d = j2;
            this.f43746e = j3;
            this.f43747f = z;
            this.f43748g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.f43749h = z2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43743b : (String) invokeV.objValue;
        }

        public JSONObject e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43748g : (JSONObject) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f43747f : invokeV.booleanValue;
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f43742a = aVar.f43742a;
                this.f43743b = aVar.f43743b;
                this.f43744c = aVar.f43744c;
                this.f43745d = aVar.f43745d;
                this.f43746e = aVar.f43746e;
                this.f43747f = aVar.f43747f;
                this.f43748g = aVar.f43748g;
                this.f43749h = aVar.f43749h;
            }
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43744c : (String) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f43745d : invokeV.longValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43746e : invokeV.longValue;
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
        this.f43734a = 0L;
        this.f43735b = 0L;
        this.f43736c = 0L;
        this.f43737d = 0L;
        this.f43738e = 0L;
        this.f43739f = 0;
        this.f43740g = new ArrayList();
        this.f43741h = null;
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
        if (!TextUtils.isEmpty(aVar2.f43742a) && !TextUtils.isEmpty(aVar.f43742a)) {
            if (aVar2.f43742a.equals(aVar.f43742a) && aVar2.f43747f != aVar.f43747f) {
                if (aVar2.f43747f) {
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
                if (!aVar.f43749h) {
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
            a(this.f43740g, new a(str, str2, str3, j2, j3, z, extraInfo, z2));
        }
    }

    public JSONObject constructJSONObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("s", this.f43734a);
                jSONObject.put("e", this.f43735b);
                jSONObject.put("i", this.f43738e);
                jSONObject.put("c", 1);
                jSONObject.put("s2", this.f43736c == 0 ? this.f43734a : this.f43736c);
                jSONObject.put("e2", this.f43737d == 0 ? this.f43735b : this.f43737d);
                jSONObject.put("pc", this.f43739f);
                if (this.f43741h != null && this.f43741h.length() != 0) {
                    jSONObject.put("launch", this.f43741h);
                }
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.f43740g.size(); i2++) {
                    jSONArray.put(getPVJson(this.f43740g.get(i2), this.f43734a));
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
                jSONObject.put("s", this.f43734a);
                jSONObject.put("e", this.f43735b);
                jSONObject.put("i", this.f43738e);
                jSONObject.put("c", 1);
                jSONObject.put("s2", this.f43736c == 0 ? this.f43734a : this.f43736c);
                jSONObject.put("e2", this.f43737d == 0 ? this.f43735b : this.f43737d);
                jSONObject.put("pc", this.f43739f);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43734a : invokeV.longValue;
    }

    public boolean hasEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43735b > 0 : invokeV.booleanValue;
    }

    public boolean hasStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f43734a > 0 : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f43734a = 0L;
            this.f43735b = 0L;
            this.f43736c = 0L;
            this.f43737d = 0L;
            this.f43739f = 0;
            this.f43740g.clear();
        }
    }

    public void setEndTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.f43735b = j2;
        }
    }

    public void setInvokeType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f43739f = i2;
        }
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) {
            this.f43741h = jSONObject;
        }
    }

    public void setStartTime(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) || this.f43734a > 0) {
            return;
        }
        this.f43734a = j2;
        this.f43738e = j2;
    }

    public void setTrackEndTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.f43737d = j2;
        }
    }

    public void setTrackStartTime(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) || this.f43736c > 0) {
            return;
        }
        this.f43736c = j2;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? constructJSONObject().toString() : (String) invokeV.objValue;
    }

    public void addPageView(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            a(this.f43740g, aVar);
        }
    }
}
