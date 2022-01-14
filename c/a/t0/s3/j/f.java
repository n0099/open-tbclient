package c.a.t0.s3.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.b2;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<b2> a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f23560b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f23561c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23562d;

    /* renamed from: e  reason: collision with root package name */
    public long f23563e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d> f23564f;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f23565b;

        /* renamed from: c  reason: collision with root package name */
        public String f23566c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f23567d;

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
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f23568b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f23569c;

        /* renamed from: d  reason: collision with root package name */
        public int f23570d;

        /* renamed from: e  reason: collision with root package name */
        public String f23571e;

        /* renamed from: f  reason: collision with root package name */
        public String f23572f;

        /* renamed from: g  reason: collision with root package name */
        public String f23573g;

        /* renamed from: h  reason: collision with root package name */
        public String f23574h;

        /* renamed from: i  reason: collision with root package name */
        public String f23575i;

        /* renamed from: j  reason: collision with root package name */
        public long f23576j;
        public long k;
        public String l;
        public int m;
        public int n;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f23577b;

        /* renamed from: c  reason: collision with root package name */
        public String f23578c;

        /* renamed from: d  reason: collision with root package name */
        public long f23579d;

        /* renamed from: e  reason: collision with root package name */
        public long f23580e;

        /* renamed from: f  reason: collision with root package name */
        public String f23581f;

        /* renamed from: g  reason: collision with root package name */
        public String f23582g;

        /* renamed from: h  reason: collision with root package name */
        public String f23583h;

        /* renamed from: i  reason: collision with root package name */
        public String f23584i;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f23585b;

        /* renamed from: c  reason: collision with root package name */
        public String f23586c;

        /* renamed from: d  reason: collision with root package name */
        public String f23587d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<c> f23588e;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public f() {
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
        this.a = new ArrayList<>();
        this.f23560b = new ArrayList<>();
        this.f23561c = new ArrayList<>();
        this.f23564f = new ArrayList<>();
        this.f23562d = true;
    }

    public ArrayList<a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23560b : (ArrayList) invokeV.objValue;
    }

    public ArrayList<b> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23561c : (ArrayList) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            try {
                if (this.a != null && this.a.size() != 0) {
                    Iterator<b2> it = this.a.iterator();
                    while (it.hasNext()) {
                        b2 next = it.next();
                        if (next != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("pic_url_bigger", next.a());
                            jSONObject2.put("link", next.b());
                            jSONArray2.put(jSONObject2);
                        }
                    }
                    jSONObject.put(SpeedStatsUtils.UBC_VALUE_BANNER, jSONArray2);
                }
                jSONObject.put("prevtime", this.f23563e);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
            if (this.f23564f != null && this.f23564f.size() != 0) {
                Iterator<d> it2 = this.f23564f.iterator();
                while (it2.hasNext()) {
                    d next2 = it2.next();
                    if (next2 != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("title", next2.a);
                        jSONObject3.put("type", next2.f23585b);
                        jSONObject3.put("pic", next2.f23586c);
                        jSONObject3.put("link", next2.f23587d);
                        ArrayList<c> arrayList = next2.f23588e;
                        if (arrayList != null && arrayList.size() != 0) {
                            JSONArray jSONArray3 = new JSONArray();
                            Iterator<c> it3 = arrayList.iterator();
                            while (it3.hasNext()) {
                                c next3 = it3.next();
                                if (next3 != null) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("forum_id", next3.a);
                                    jSONObject4.put("forum_name", next3.f23577b);
                                    jSONObject4.put("avatar", next3.f23578c);
                                    jSONObject4.put("explain", next3.f23581f);
                                    jSONObject4.put("desc", next3.f23582g);
                                    jSONObject4.put("tag", next3.f23583h);
                                    jSONObject4.put("thread_num", next3.f23580e);
                                    jSONObject4.put("member_count", next3.f23579d);
                                    jSONObject4.put("link", next3.f23584i);
                                    jSONArray3.put(jSONObject4);
                                }
                            }
                            jSONObject3.put("forum_list", jSONArray3);
                            jSONArray.put(jSONObject3);
                        }
                        jSONArray.put(jSONObject3);
                    }
                }
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("new_list", jSONArray);
                jSONObject.put("new_recommend_topic", jSONObject5);
                return jSONObject.toString();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<b2> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23563e : invokeV.longValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        ArrayList<a> arrayList;
        ArrayList<b> arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f23562d) {
                ArrayList<b2> arrayList3 = this.a;
                return (arrayList3 == null || arrayList3.size() == 0) && ((arrayList = this.f23560b) == null || arrayList.size() == 0) && ((arrayList2 = this.f23561c) == null || arrayList2.size() == 0);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void h(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jSONArray) == null) || jSONArray == null) {
            return;
        }
        try {
            if (jSONArray.length() == 0) {
                return;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("pic_url_bigger", "");
                    String optString2 = jSONObject.optString("link", "");
                    String optString3 = jSONObject.optString("template_id", "");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        b2 b2Var = new b2();
                        b2Var.d(optString);
                        b2Var.e(optString2);
                        b2Var.f(optString3);
                        this.a.add(b2Var);
                    }
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final void i(JSONArray jSONArray) {
        int optInt;
        JSONArray optJSONArray;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONArray) == null) || jSONArray == null) {
            return;
        }
        try {
            if (jSONArray.length() == 0) {
                return;
            }
            boolean z = false;
            int i3 = 0;
            int i4 = 0;
            while (i3 < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null && (optInt = jSONObject.optInt("type", -1)) != -1) {
                    boolean z2 = true;
                    String str2 = "";
                    if (optInt == 1) {
                        i4++;
                        a aVar = new a();
                        aVar.a = jSONObject.optString("title", "");
                        aVar.f23565b = jSONObject.optString("link", "");
                        aVar.f23566c = jSONObject.optString("pic", "");
                        aVar.f23567d = z;
                        this.f23560b.add(aVar);
                    } else if (optInt == 3) {
                        i4++;
                        a aVar2 = new a();
                        aVar2.a = jSONObject.optString("title", "");
                        aVar2.f23565b = jSONObject.optString("link", "");
                        aVar2.f23566c = jSONObject.optString("pic", "");
                        aVar2.f23567d = true;
                        this.f23560b.add(aVar2);
                    } else if ((optInt == 2 || optInt == 0) && (optJSONArray = jSONObject.optJSONArray("forum_list")) != null && optJSONArray.length() != 0) {
                        b bVar = new b();
                        bVar.a = true;
                        int i5 = i3 - i4;
                        bVar.m = i5;
                        if (optInt == 2) {
                            bVar.f23569c = true;
                        } else {
                            bVar.f23569c = z;
                        }
                        bVar.l = jSONObject.optString("link", "");
                        bVar.f23568b = jSONObject.optString("title", "");
                        this.f23561c.add(bVar);
                        int i6 = 0;
                        ?? r2 = z;
                        while (i6 < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i6);
                            if (jSONObject2 == null) {
                                i2 = i3;
                                str = str2;
                            } else {
                                b bVar2 = new b();
                                if (optInt == 2) {
                                    bVar2.f23569c = z2;
                                } else {
                                    bVar2.f23569c = r2;
                                }
                                bVar2.a = r2;
                                bVar2.m = i5;
                                bVar2.n = i6;
                                bVar2.f23570d = jSONObject2.optInt("forum_id", r2);
                                bVar2.f23571e = jSONObject2.optString("forum_name", str2);
                                bVar2.f23572f = jSONObject2.optString("avatar", str2);
                                bVar2.f23574h = jSONObject2.optString("explain", str2);
                                bVar2.f23575i = jSONObject2.optString("desc", str2);
                                bVar2.f23573g = jSONObject2.optString("tag", str2);
                                i2 = i3;
                                bVar2.f23576j = jSONObject2.optLong("member_count", 0L);
                                bVar2.k = jSONObject2.optLong("thread_num", 0L);
                                str = str2;
                                bVar2.l = jSONObject2.optString("link", str);
                                this.f23561c.add(bVar2);
                            }
                            i6++;
                            str2 = str;
                            i3 = i2;
                            r2 = 0;
                            z2 = true;
                        }
                    }
                }
                i3++;
                z = false;
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (str != null && str.length() >= 1) {
                try {
                    k(new JSONObject(str));
                    l(str);
                    return;
                } catch (Exception e2) {
                    this.f23562d = false;
                    BdLog.e(e2.toString());
                    return;
                }
            }
            this.f23562d = false;
        }
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            h(jSONObject.optJSONArray(SpeedStatsUtils.UBC_VALUE_BANNER));
            this.f23563e = jSONObject.optLong("prevtime");
            JSONObject optJSONObject = jSONObject.optJSONObject("new_recommend_topic");
            if (optJSONObject == null) {
                return;
            }
            i(optJSONObject.optJSONArray("new_list"));
        } catch (Exception e2) {
            this.f23562d = false;
            BdLog.e(e2.toString());
        }
    }

    public final void l(String str) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || str == null) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("new_recommend_topic");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("new_list")) != null && optJSONArray.length() != 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        d dVar = new d();
                        this.f23564f.add(dVar);
                        dVar.f23588e = new ArrayList<>();
                        dVar.a = jSONObject.optString("title", "");
                        dVar.f23585b = jSONObject.optInt("type", -1);
                        dVar.f23586c = jSONObject.optString("pic", "");
                        dVar.f23587d = jSONObject.optString("link", "");
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("forum_list");
                        if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i3);
                                if (jSONObject2 != null) {
                                    c cVar = new c();
                                    cVar.a = jSONObject2.optInt("forum_id", 0);
                                    cVar.f23577b = jSONObject2.optString("forum_name", "");
                                    cVar.f23578c = jSONObject2.optString("avatar", "");
                                    cVar.f23581f = jSONObject2.optString("explain", "");
                                    cVar.f23582g = jSONObject2.optString("desc", "");
                                    cVar.f23583h = jSONObject2.optString("tag", "");
                                    cVar.f23579d = jSONObject2.optLong("member_count", 0L);
                                    cVar.f23580e = jSONObject2.optLong("thread_num", 0L);
                                    cVar.f23584i = jSONObject2.optString("link", "");
                                    dVar.f23588e.add(cVar);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void m(ArrayList<b2> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) {
            this.a = arrayList;
        }
    }

    public void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.f23563e = j2;
        }
    }
}
