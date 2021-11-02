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
/* loaded from: classes7.dex */
public class Session {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile long f41514a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f41515b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f41516c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f41517d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f41518e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f41519f;

    /* renamed from: g  reason: collision with root package name */
    public List<a> f41520g;

    /* renamed from: h  reason: collision with root package name */
    public volatile JSONObject f41521h;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f41522a;

        /* renamed from: b  reason: collision with root package name */
        public String f41523b;

        /* renamed from: c  reason: collision with root package name */
        public String f41524c;

        /* renamed from: d  reason: collision with root package name */
        public long f41525d;

        /* renamed from: e  reason: collision with root package name */
        public long f41526e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f41527f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f41528g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f41529h;

        public a(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), extraInfo, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41523b = str;
            this.f41524c = str2;
            this.f41522a = str3;
            this.f41525d = j;
            this.f41526e = j2;
            this.f41527f = z;
            this.f41528g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.f41529h = z2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41523b : (String) invokeV.objValue;
        }

        public JSONObject e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41528g : (JSONObject) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41527f : invokeV.booleanValue;
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f41522a = aVar.f41522a;
                this.f41523b = aVar.f41523b;
                this.f41524c = aVar.f41524c;
                this.f41525d = aVar.f41525d;
                this.f41526e = aVar.f41526e;
                this.f41527f = aVar.f41527f;
                this.f41528g = aVar.f41528g;
                this.f41529h = aVar.f41529h;
            }
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41524c : (String) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41525d : invokeV.longValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41526e : invokeV.longValue;
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
        this.f41514a = 0L;
        this.f41515b = 0L;
        this.f41516c = 0L;
        this.f41517d = 0L;
        this.f41518e = 0L;
        this.f41519f = 0;
        this.f41520g = new ArrayList();
        this.f41521h = null;
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
        if (!TextUtils.isEmpty(aVar2.f41522a) && !TextUtils.isEmpty(aVar.f41522a)) {
            if (aVar2.f41522a.equals(aVar.f41522a) && aVar2.f41527f != aVar.f41527f) {
                if (aVar2.f41527f) {
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

    public static JSONObject getPVJson(a aVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, aVar, j)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", aVar.a());
                jSONObject.put("d", aVar.c());
                long d2 = aVar.d() - j;
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
                if (!aVar.f41529h) {
                    i2 = 0;
                }
                jSONObject.put("h5", i2);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLJ.objValue;
    }

    public void addPageView(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), extraInfo, Boolean.valueOf(z2)}) == null) {
            a(this.f41520g, new a(str, str2, str3, j, j2, z, extraInfo, z2));
        }
    }

    public JSONObject constructJSONObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("s", this.f41514a);
                jSONObject.put("e", this.f41515b);
                jSONObject.put("i", this.f41518e);
                jSONObject.put("c", 1);
                jSONObject.put("s2", this.f41516c == 0 ? this.f41514a : this.f41516c);
                jSONObject.put("e2", this.f41517d == 0 ? this.f41515b : this.f41517d);
                jSONObject.put("pc", this.f41519f);
                if (this.f41521h != null && this.f41521h.length() != 0) {
                    jSONObject.put("launch", this.f41521h);
                }
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.f41520g.size(); i2++) {
                    jSONArray.put(getPVJson(this.f41520g.get(i2), this.f41514a));
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
                jSONObject.put("s", this.f41514a);
                jSONObject.put("e", this.f41515b);
                jSONObject.put("i", this.f41518e);
                jSONObject.put("c", 1);
                jSONObject.put("s2", this.f41516c == 0 ? this.f41514a : this.f41516c);
                jSONObject.put("e2", this.f41517d == 0 ? this.f41515b : this.f41517d);
                jSONObject.put("pc", this.f41519f);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41514a : invokeV.longValue;
    }

    public boolean hasEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41515b > 0 : invokeV.booleanValue;
    }

    public boolean hasStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41514a > 0 : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f41514a = 0L;
            this.f41515b = 0L;
            this.f41516c = 0L;
            this.f41517d = 0L;
            this.f41519f = 0;
            this.f41520g.clear();
        }
    }

    public void setEndTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.f41515b = j;
        }
    }

    public void setInvokeType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f41519f = i2;
        }
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) {
            this.f41521h = jSONObject;
        }
    }

    public void setStartTime(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048587, this, j) == null) || this.f41514a > 0) {
            return;
        }
        this.f41514a = j;
        this.f41518e = j;
    }

    public void setTrackEndTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.f41517d = j;
        }
    }

    public void setTrackStartTime(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048589, this, j) == null) || this.f41516c > 0) {
            return;
        }
        this.f41516c = j;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? constructJSONObject().toString() : (String) invokeV.objValue;
    }

    public void addPageView(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            a(this.f41520g, aVar);
        }
    }
}
