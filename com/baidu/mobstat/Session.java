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
/* loaded from: classes5.dex */
public class Session {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile long f43103a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f43104b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f43105c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f43106d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f43107e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f43108f;

    /* renamed from: g  reason: collision with root package name */
    public List<a> f43109g;

    /* renamed from: h  reason: collision with root package name */
    public volatile JSONObject f43110h;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f43111a;

        /* renamed from: b  reason: collision with root package name */
        public String f43112b;

        /* renamed from: c  reason: collision with root package name */
        public String f43113c;

        /* renamed from: d  reason: collision with root package name */
        public long f43114d;

        /* renamed from: e  reason: collision with root package name */
        public long f43115e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f43116f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f43117g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f43118h;

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
            this.f43112b = str;
            this.f43113c = str2;
            this.f43111a = str3;
            this.f43114d = j2;
            this.f43115e = j3;
            this.f43116f = z;
            this.f43117g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.f43118h = z2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43112b : (String) invokeV.objValue;
        }

        public JSONObject e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43117g : (JSONObject) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f43116f : invokeV.booleanValue;
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f43111a = aVar.f43111a;
                this.f43112b = aVar.f43112b;
                this.f43113c = aVar.f43113c;
                this.f43114d = aVar.f43114d;
                this.f43115e = aVar.f43115e;
                this.f43116f = aVar.f43116f;
                this.f43117g = aVar.f43117g;
                this.f43118h = aVar.f43118h;
            }
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43113c : (String) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f43114d : invokeV.longValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43115e : invokeV.longValue;
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
        this.f43103a = 0L;
        this.f43104b = 0L;
        this.f43105c = 0L;
        this.f43106d = 0L;
        this.f43107e = 0L;
        this.f43108f = 0;
        this.f43109g = new ArrayList();
        this.f43110h = null;
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
        if (!TextUtils.isEmpty(aVar2.f43111a) && !TextUtils.isEmpty(aVar.f43111a)) {
            if (aVar2.f43111a.equals(aVar.f43111a) && aVar2.f43116f != aVar.f43116f) {
                if (aVar2.f43116f) {
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
                if (!aVar.f43118h) {
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
            a(this.f43109g, new a(str, str2, str3, j2, j3, z, extraInfo, z2));
        }
    }

    public JSONObject constructJSONObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("s", this.f43103a);
                jSONObject.put("e", this.f43104b);
                jSONObject.put("i", this.f43107e);
                jSONObject.put("c", 1);
                jSONObject.put("s2", this.f43105c == 0 ? this.f43103a : this.f43105c);
                jSONObject.put("e2", this.f43106d == 0 ? this.f43104b : this.f43106d);
                jSONObject.put("pc", this.f43108f);
                if (this.f43110h != null && this.f43110h.length() != 0) {
                    jSONObject.put("launch", this.f43110h);
                }
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.f43109g.size(); i2++) {
                    jSONArray.put(getPVJson(this.f43109g.get(i2), this.f43103a));
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
                jSONObject.put("s", this.f43103a);
                jSONObject.put("e", this.f43104b);
                jSONObject.put("i", this.f43107e);
                jSONObject.put("c", 1);
                jSONObject.put("s2", this.f43105c == 0 ? this.f43103a : this.f43105c);
                jSONObject.put("e2", this.f43106d == 0 ? this.f43104b : this.f43106d);
                jSONObject.put("pc", this.f43108f);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43103a : invokeV.longValue;
    }

    public boolean hasEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43104b > 0 : invokeV.booleanValue;
    }

    public boolean hasStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f43103a > 0 : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f43103a = 0L;
            this.f43104b = 0L;
            this.f43105c = 0L;
            this.f43106d = 0L;
            this.f43108f = 0;
            this.f43109g.clear();
        }
    }

    public void setEndTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.f43104b = j2;
        }
    }

    public void setInvokeType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f43108f = i2;
        }
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) {
            this.f43110h = jSONObject;
        }
    }

    public void setStartTime(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) || this.f43103a > 0) {
            return;
        }
        this.f43103a = j2;
        this.f43107e = j2;
    }

    public void setTrackEndTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.f43106d = j2;
        }
    }

    public void setTrackStartTime(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) || this.f43105c > 0) {
            return;
        }
        this.f43105c = j2;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? constructJSONObject().toString() : (String) invokeV.objValue;
    }

    public void addPageView(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            a(this.f43109g, aVar);
        }
    }
}
