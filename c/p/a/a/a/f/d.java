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
    public String f34494a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34495b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34496c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f34497d;

    /* renamed from: e  reason: collision with root package name */
    public final long f34498e;

    /* renamed from: f  reason: collision with root package name */
    public final String f34499f;

    /* renamed from: g  reason: collision with root package name */
    public final long f34500g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f34501h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f34502i;

    /* renamed from: j  reason: collision with root package name */
    public final List<String> f34503j;
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
        public String f34504a;

        /* renamed from: b  reason: collision with root package name */
        public String f34505b;

        /* renamed from: c  reason: collision with root package name */
        public String f34506c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34507d;

        /* renamed from: e  reason: collision with root package name */
        public long f34508e;

        /* renamed from: f  reason: collision with root package name */
        public String f34509f;

        /* renamed from: g  reason: collision with root package name */
        public long f34510g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f34511h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f34512i;

        /* renamed from: j  reason: collision with root package name */
        public Map<String, Object> f34513j;
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
            this.f34507d = false;
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
                this.f34508e = j2;
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
                this.f34505b = str;
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
                this.f34511h = jSONObject;
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
                if (TextUtils.isEmpty(this.f34504a)) {
                    this.f34504a = AppLog.UMENG_CATEGORY;
                }
                JSONObject jSONObject = new JSONObject();
                if (this.f34511h == null) {
                    this.f34511h = new JSONObject();
                }
                try {
                    if (this.f34513j != null && !this.f34513j.isEmpty()) {
                        for (Map.Entry<String, Object> entry : this.f34513j.entrySet()) {
                            if (!this.f34511h.has(entry.getKey())) {
                                this.f34511h.putOpt(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    if (this.o) {
                        this.p = this.f34506c;
                        JSONObject jSONObject2 = new JSONObject();
                        this.q = jSONObject2;
                        if (this.f34507d) {
                            jSONObject2.put("ad_extra_data", this.f34511h.toString());
                        } else {
                            Iterator<String> keys = this.f34511h.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                this.q.put(next, this.f34511h.get(next));
                            }
                        }
                        this.q.put("category", this.f34504a);
                        this.q.put("tag", this.f34505b);
                        this.q.put("value", this.f34508e);
                        this.q.put("ext_value", this.f34510g);
                        if (!TextUtils.isEmpty(this.n)) {
                            this.q.put(TiebaStatic.Params.REFER, this.n);
                        }
                        if (this.f34512i != null) {
                            this.q = c.p.a.a.a.g.b.e(this.f34512i, this.q);
                        }
                        if (this.f34507d) {
                            if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f34509f)) {
                                this.q.put("log_extra", this.f34509f);
                            }
                            this.q.put("is_ad_event", "1");
                        }
                    }
                    if (this.f34507d) {
                        jSONObject.put("ad_extra_data", this.f34511h.toString());
                        if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f34509f)) {
                            jSONObject.put("log_extra", this.f34509f);
                        }
                        jSONObject.put("is_ad_event", "1");
                    } else {
                        jSONObject.put("extra", this.f34511h);
                    }
                    if (!TextUtils.isEmpty(this.n)) {
                        jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f34512i != null) {
                        jSONObject = c.p.a.a.a.g.b.e(this.f34512i, jSONObject);
                    }
                    this.f34511h = jSONObject;
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
                this.f34510g = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f34506c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a l(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSONObject)) == null) {
                this.f34512i = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a m(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.f34507d = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a o(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f34509f = str;
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
        this.f34494a = aVar.f34504a;
        this.f34495b = aVar.f34505b;
        this.f34496c = aVar.f34506c;
        this.f34497d = aVar.f34507d;
        this.f34498e = aVar.f34508e;
        this.f34499f = aVar.f34509f;
        this.f34500g = aVar.f34510g;
        this.f34501h = aVar.f34511h;
        this.f34502i = aVar.f34512i;
        this.f34503j = aVar.k;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34495b : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34496c : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34497d : invokeV.booleanValue;
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34501h : (JSONObject) invokeV.objValue;
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
            sb.append(this.f34494a);
            sb.append("\ttag: ");
            sb.append(this.f34495b);
            sb.append("\tlabel: ");
            sb.append(this.f34496c);
            sb.append("\nisAd: ");
            sb.append(this.f34497d);
            sb.append("\tadId: ");
            sb.append(this.f34498e);
            sb.append("\tlogExtra: ");
            sb.append(this.f34499f);
            sb.append("\textValue: ");
            sb.append(this.f34500g);
            sb.append("\nextJson: ");
            sb.append(this.f34501h);
            sb.append("\nparamsJson: ");
            sb.append(this.f34502i);
            sb.append("\nclickTrackUrl: ");
            List<String> list = this.f34503j;
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
