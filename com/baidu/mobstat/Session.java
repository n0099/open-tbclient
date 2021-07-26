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

    /* renamed from: a  reason: collision with root package name */
    public volatile long f8608a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f8609b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f8610c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f8611d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f8612e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f8613f;

    /* renamed from: g  reason: collision with root package name */
    public List<a> f8614g;

    /* renamed from: h  reason: collision with root package name */
    public volatile JSONObject f8615h;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f8616a;

        /* renamed from: b  reason: collision with root package name */
        public String f8617b;

        /* renamed from: c  reason: collision with root package name */
        public String f8618c;

        /* renamed from: d  reason: collision with root package name */
        public long f8619d;

        /* renamed from: e  reason: collision with root package name */
        public long f8620e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8621f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f8622g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8623h;

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
            this.f8617b = str;
            this.f8618c = str2;
            this.f8616a = str3;
            this.f8619d = j;
            this.f8620e = j2;
            this.f8621f = z;
            this.f8622g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.f8623h = z2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8617b : (String) invokeV.objValue;
        }

        public JSONObject e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f8622g : (JSONObject) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f8621f : invokeV.booleanValue;
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f8616a = aVar.f8616a;
                this.f8617b = aVar.f8617b;
                this.f8618c = aVar.f8618c;
                this.f8619d = aVar.f8619d;
                this.f8620e = aVar.f8620e;
                this.f8621f = aVar.f8621f;
                this.f8622g = aVar.f8622g;
                this.f8623h = aVar.f8623h;
            }
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8618c : (String) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f8619d : invokeV.longValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f8620e : invokeV.longValue;
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
        this.f8608a = 0L;
        this.f8609b = 0L;
        this.f8610c = 0L;
        this.f8611d = 0L;
        this.f8612e = 0L;
        this.f8613f = 0;
        this.f8614g = new ArrayList();
        this.f8615h = null;
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
        if (!TextUtils.isEmpty(aVar2.f8616a) && !TextUtils.isEmpty(aVar.f8616a)) {
            if (aVar2.f8616a.equals(aVar.f8616a) && aVar2.f8621f != aVar.f8621f) {
                if (aVar2.f8621f) {
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
                if (!aVar.f8623h) {
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
            a(this.f8614g, new a(str, str2, str3, j, j2, z, extraInfo, z2));
        }
    }

    public JSONObject constructJSONObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("s", this.f8608a);
                jSONObject.put("e", this.f8609b);
                jSONObject.put("i", this.f8612e);
                jSONObject.put("c", 1);
                jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8610c == 0 ? this.f8608a : this.f8610c);
                jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8611d == 0 ? this.f8609b : this.f8611d);
                jSONObject.put("pc", this.f8613f);
                if (this.f8615h != null && this.f8615h.length() != 0) {
                    jSONObject.put("launch", this.f8615h);
                }
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.f8614g.size(); i2++) {
                    jSONArray.put(getPVJson(this.f8614g.get(i2), this.f8608a));
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
                jSONObject.put("s", this.f8608a);
                jSONObject.put("e", this.f8609b);
                jSONObject.put("i", this.f8612e);
                jSONObject.put("c", 1);
                jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8610c == 0 ? this.f8608a : this.f8610c);
                jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8611d == 0 ? this.f8609b : this.f8611d);
                jSONObject.put("pc", this.f8613f);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f8608a : invokeV.longValue;
    }

    public boolean hasEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f8609b > 0 : invokeV.booleanValue;
    }

    public boolean hasStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f8608a > 0 : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f8608a = 0L;
            this.f8609b = 0L;
            this.f8610c = 0L;
            this.f8611d = 0L;
            this.f8613f = 0;
            this.f8614g.clear();
        }
    }

    public void setEndTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.f8609b = j;
        }
    }

    public void setInvokeType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f8613f = i2;
        }
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) {
            this.f8615h = jSONObject;
        }
    }

    public void setStartTime(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048587, this, j) == null) || this.f8608a > 0) {
            return;
        }
        this.f8608a = j;
        this.f8612e = j;
    }

    public void setTrackEndTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.f8611d = j;
        }
    }

    public void setTrackStartTime(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048589, this, j) == null) || this.f8610c > 0) {
            return;
        }
        this.f8610c = j;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? constructJSONObject().toString() : (String) invokeV.objValue;
    }

    public void addPageView(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            a(this.f8614g, aVar);
        }
    }
}
