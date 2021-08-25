package c.p.a.a.a.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.p.a.d.b.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f34358a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34359b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34360c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f34361d;

    /* renamed from: e  reason: collision with root package name */
    public final long f34362e;

    /* renamed from: f  reason: collision with root package name */
    public final String f34363f;

    /* renamed from: g  reason: collision with root package name */
    public final long f34364g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f34365h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f34366i;

    /* renamed from: j  reason: collision with root package name */
    public final List<String> f34367j;
    public final int k;
    public final Object l;
    public final boolean m;
    public final String n;
    public final JSONObject o;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f34368a;

        /* renamed from: b  reason: collision with root package name */
        public String f34369b;

        /* renamed from: c  reason: collision with root package name */
        public String f34370c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34371d;

        /* renamed from: e  reason: collision with root package name */
        public long f34372e;

        /* renamed from: f  reason: collision with root package name */
        public String f34373f;

        /* renamed from: g  reason: collision with root package name */
        public long f34374g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f34375h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f34376i;

        /* renamed from: j  reason: collision with root package name */
        public Map<String, Object> f34377j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public boolean o;
        public String p;
        public JSONObject q;

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
                    return;
                }
            }
            this.f34371d = false;
            this.o = false;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.l = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.f34372e = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a c(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                this.m = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f34369b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
                this.k = list;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
                this.f34375h = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.o = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public d h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (TextUtils.isEmpty(this.f34368a)) {
                    this.f34368a = AppLog.UMENG_CATEGORY;
                }
                JSONObject jSONObject = new JSONObject();
                if (this.f34375h == null) {
                    this.f34375h = new JSONObject();
                }
                try {
                    if (this.f34377j != null && !this.f34377j.isEmpty()) {
                        for (Map.Entry<String, Object> entry : this.f34377j.entrySet()) {
                            if (!this.f34375h.has(entry.getKey())) {
                                this.f34375h.putOpt(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    if (this.o) {
                        this.p = this.f34370c;
                        JSONObject jSONObject2 = new JSONObject();
                        this.q = jSONObject2;
                        if (this.f34371d) {
                            jSONObject2.put("ad_extra_data", this.f34375h.toString());
                        } else {
                            Iterator<String> keys = this.f34375h.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                this.q.put(next, this.f34375h.get(next));
                            }
                        }
                        this.q.put("category", this.f34368a);
                        this.q.put("tag", this.f34369b);
                        this.q.put("value", this.f34372e);
                        this.q.put("ext_value", this.f34374g);
                        if (!TextUtils.isEmpty(this.n)) {
                            this.q.put(TiebaStatic.Params.REFER, this.n);
                        }
                        if (this.f34376i != null) {
                            this.q = c.p.a.a.a.g.b.e(this.f34376i, this.q);
                        }
                        if (this.f34371d) {
                            if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f34373f)) {
                                this.q.put("log_extra", this.f34373f);
                            }
                            this.q.put("is_ad_event", "1");
                        }
                    }
                    if (this.f34371d) {
                        jSONObject.put("ad_extra_data", this.f34375h.toString());
                        if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f34373f)) {
                            jSONObject.put("log_extra", this.f34373f);
                        }
                        jSONObject.put("is_ad_event", "1");
                    } else {
                        jSONObject.put("extra", this.f34375h);
                    }
                    if (!TextUtils.isEmpty(this.n)) {
                        jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f34376i != null) {
                        jSONObject = c.p.a.a.a.g.b.e(this.f34376i, jSONObject);
                    }
                    this.f34375h = jSONObject;
                } catch (Exception e2) {
                    l.F().a(e2, "DownloadEventModel build");
                }
                return new d(this);
            }
            return (d) invokeV.objValue;
        }

        public a j(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                this.f34374g = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f34370c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a l(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSONObject)) == null) {
                this.f34376i = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a m(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.f34371d = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a o(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f34373f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.n = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34358a = aVar.f34368a;
        this.f34359b = aVar.f34369b;
        this.f34360c = aVar.f34370c;
        this.f34361d = aVar.f34371d;
        this.f34362e = aVar.f34372e;
        this.f34363f = aVar.f34373f;
        this.f34364g = aVar.f34374g;
        this.f34365h = aVar.f34375h;
        this.f34366i = aVar.f34376i;
        this.f34367j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.m = aVar.o;
        this.n = aVar.p;
        this.o = aVar.q;
        String unused = aVar.n;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34359b : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34360c : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34361d : invokeV.booleanValue;
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34365h : (JSONObject) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("category: ");
            sb.append(this.f34358a);
            sb.append("\ttag: ");
            sb.append(this.f34359b);
            sb.append("\tlabel: ");
            sb.append(this.f34360c);
            sb.append("\nisAd: ");
            sb.append(this.f34361d);
            sb.append("\tadId: ");
            sb.append(this.f34362e);
            sb.append("\tlogExtra: ");
            sb.append(this.f34363f);
            sb.append("\textValue: ");
            sb.append(this.f34364g);
            sb.append("\nextJson: ");
            sb.append(this.f34365h);
            sb.append("\nparamsJson: ");
            sb.append(this.f34366i);
            sb.append("\nclickTrackUrl: ");
            List<String> list = this.f34367j;
            sb.append(list != null ? list.toString() : "");
            sb.append("\teventSource: ");
            sb.append(this.k);
            sb.append("\textraObject: ");
            Object obj = this.l;
            sb.append(obj != null ? obj.toString() : "");
            sb.append("\nisV3: ");
            sb.append(this.m);
            sb.append("\tV3EventName: ");
            sb.append(this.n);
            sb.append("\tV3EventParams: ");
            JSONObject jSONObject = this.o;
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
