package com.baidu.mapsdkplatform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f35823b;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.mapsdkplatform.comjni.map.favorite.a a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35824c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35825d;

    /* renamed from: e  reason: collision with root package name */
    public Vector<String> f35826e;

    /* renamed from: f  reason: collision with root package name */
    public Vector<String> f35827f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35828g;

    /* renamed from: h  reason: collision with root package name */
    public c f35829h;

    /* renamed from: i  reason: collision with root package name */
    public b f35830i;

    /* renamed from: com.baidu.mapsdkplatform.comapi.favrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C1827a implements Comparator<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1827a(a aVar) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? str2.compareTo(str) : invokeLL.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: b  reason: collision with root package name */
        public long f35831b;

        /* renamed from: c  reason: collision with root package name */
        public long f35832c;

        public b(a aVar) {
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
            this.a = aVar;
        }

        public /* synthetic */ b(a aVar, com.baidu.mapsdkplatform.comapi.favrite.b bVar) {
            this(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.f35831b = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                this.f35832c = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.f35832c - this.f35831b > 1000 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: b  reason: collision with root package name */
        public String f35833b;

        /* renamed from: c  reason: collision with root package name */
        public long f35834c;

        /* renamed from: d  reason: collision with root package name */
        public long f35835d;

        public c(a aVar) {
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
            this.a = aVar;
            this.f35834c = 5000L;
            this.f35835d = 0L;
        }

        public /* synthetic */ c(a aVar, com.baidu.mapsdkplatform.comapi.favrite.b bVar) {
            this(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f35833b : (String) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
                this.f35833b = str;
                this.f35835d = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? TextUtils.isEmpty(this.f35833b) : invokeV.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(787437612, "Lcom/baidu/mapsdkplatform/comapi/favrite/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(787437612, "Lcom/baidu/mapsdkplatform/comapi/favrite/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f35824c = false;
        this.f35825d = false;
        this.f35826e = null;
        this.f35827f = null;
        this.f35828g = false;
        this.f35829h = new c(this, null);
        this.f35830i = new b(this, null);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f35823b == null) {
                synchronized (a.class) {
                    if (f35823b == null) {
                        a aVar = new a();
                        f35823b = aVar;
                        aVar.h();
                    }
                }
            }
            return f35823b;
        }
        return (a) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        com.baidu.mapsdkplatform.comjni.map.favorite.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            a aVar2 = f35823b;
            return (aVar2 == null || (aVar = aVar2.a) == null || !aVar.d()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.a == null) {
                com.baidu.mapsdkplatform.comjni.map.favorite.a aVar = new com.baidu.mapsdkplatform.comjni.map.favorite.a();
                this.a = aVar;
                if (aVar.a() == 0) {
                    this.a = null;
                    return false;
                }
                j();
                i();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.a == null) {
                return false;
            }
            String str = SysOSUtil.getModuleFileName() + "/";
            this.a.a(1);
            return this.a.a(str, "fav_poi", "fifo", 10, 501, -1);
        }
        return invokeV.booleanValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.f35824c = false;
            this.f35825d = false;
        }
    }

    public synchronized int a(String str, FavSyncPoi favSyncPoi) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, favSyncPoi)) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return 0;
                }
                if (str != null && !str.equals("") && favSyncPoi != null) {
                    j();
                    ArrayList<String> e2 = e();
                    if ((e2 != null ? e2.size() : 0) + 1 > 500) {
                        return -2;
                    }
                    if (e2 != null && e2.size() > 0) {
                        Iterator<String> it = e2.iterator();
                        while (it.hasNext()) {
                            FavSyncPoi b2 = b(it.next());
                            if (b2 != null && str.equals(b2.f35814b)) {
                                return -1;
                            }
                        }
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        favSyncPoi.f35814b = str;
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        String str2 = valueOf + "_" + favSyncPoi.hashCode();
                        favSyncPoi.f35820h = valueOf;
                        favSyncPoi.a = str2;
                        jSONObject.put("bdetail", favSyncPoi.f35821i);
                        jSONObject.put("uspoiname", favSyncPoi.f35814b);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("x", favSyncPoi.f35815c.getmPtx());
                        jSONObject2.put("y", favSyncPoi.f35815c.getmPty());
                        jSONObject.put("pt", jSONObject2);
                        jSONObject.put("ncityid", favSyncPoi.f35817e);
                        jSONObject.put("npoitype", favSyncPoi.f35819g);
                        jSONObject.put("uspoiuid", favSyncPoi.f35818f);
                        jSONObject.put(DuPaBInfoMsg.B_ADDR, favSyncPoi.f35816d);
                        jSONObject.put("addtimesec", favSyncPoi.f35820h);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("Fav_Sync", jSONObject);
                        jSONObject3.put("Fav_Content", favSyncPoi.f35822j);
                        if (!this.a.a(str2, jSONObject3.toString())) {
                            g();
                            return 0;
                        }
                        j();
                        g();
                        return 1;
                    } catch (JSONException unused) {
                        g();
                        return 0;
                    }
                }
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public synchronized boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return false;
                }
                if (str != null && !str.equals("")) {
                    if (c(str)) {
                        j();
                        return this.a.a(str);
                    }
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public FavSyncPoi b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.a != null && str != null && !str.equals("")) {
                try {
                    if (c(str)) {
                        FavSyncPoi favSyncPoi = new FavSyncPoi();
                        String b2 = this.a.b(str);
                        if (b2 != null && !b2.equals("")) {
                            JSONObject jSONObject = new JSONObject(b2);
                            JSONObject optJSONObject = jSONObject.optJSONObject("Fav_Sync");
                            String optString = jSONObject.optString("Fav_Content");
                            favSyncPoi.f35814b = optJSONObject.optString("uspoiname");
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("pt");
                            favSyncPoi.f35815c = new Point(optJSONObject2.optInt("x"), optJSONObject2.optInt("y"));
                            favSyncPoi.f35817e = optJSONObject.optString("ncityid");
                            favSyncPoi.f35818f = optJSONObject.optString("uspoiuid");
                            favSyncPoi.f35819g = optJSONObject.optInt("npoitype");
                            favSyncPoi.f35816d = optJSONObject.optString(DuPaBInfoMsg.B_ADDR);
                            favSyncPoi.f35820h = optJSONObject.optString("addtimesec");
                            favSyncPoi.f35821i = optJSONObject.optBoolean("bdetail");
                            favSyncPoi.f35822j = optString;
                            favSyncPoi.a = str;
                            return favSyncPoi;
                        }
                        return null;
                    }
                    return null;
                } catch (NullPointerException e2) {
                    e2.printStackTrace();
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (FavSyncPoi) invokeL.objValue;
    }

    public void b() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = f35823b) == null) {
            return;
        }
        com.baidu.mapsdkplatform.comjni.map.favorite.a aVar2 = aVar.a;
        if (aVar2 != null) {
            aVar2.b();
            f35823b.a = null;
        }
        f35823b = null;
    }

    public synchronized boolean b(String str, FavSyncPoi favSyncPoi) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, favSyncPoi)) == null) {
            synchronized (this) {
                boolean z = false;
                if (this.a != null && str != null && !str.equals("") && favSyncPoi != null) {
                    if (c(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("uspoiname", favSyncPoi.f35814b);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("x", favSyncPoi.f35815c.getmPtx());
                            jSONObject2.put("y", favSyncPoi.f35815c.getmPty());
                            jSONObject.put("pt", jSONObject2);
                            jSONObject.put("ncityid", favSyncPoi.f35817e);
                            jSONObject.put("npoitype", favSyncPoi.f35819g);
                            jSONObject.put("uspoiuid", favSyncPoi.f35818f);
                            jSONObject.put(DuPaBInfoMsg.B_ADDR, favSyncPoi.f35816d);
                            String valueOf = String.valueOf(System.currentTimeMillis());
                            favSyncPoi.f35820h = valueOf;
                            jSONObject.put("addtimesec", valueOf);
                            jSONObject.put("bdetail", false);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("Fav_Sync", jSONObject);
                            jSONObject3.put("Fav_Content", favSyncPoi.f35822j);
                            j();
                            if (this.a != null) {
                                if (this.a.b(str, jSONObject3.toString())) {
                                    z = true;
                                }
                            }
                            return z;
                        } catch (JSONException unused) {
                            return false;
                        }
                    }
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public synchronized boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return false;
                }
                j();
                boolean c2 = this.a.c();
                g();
                return c2;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? (this.a == null || str == null || str.equals("") || !this.a.c(str)) ? false : true : invokeL.booleanValue;
    }

    public ArrayList<String> d() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null) {
                return null;
            }
            if (!this.f35825d || this.f35827f == null) {
                try {
                    Bundle bundle = new Bundle();
                    this.a.a(bundle);
                    String[] stringArray = bundle.getStringArray("rstString");
                    if (stringArray != null) {
                        if (this.f35827f == null) {
                            this.f35827f = new Vector<>();
                        } else {
                            this.f35827f.clear();
                        }
                        for (int i2 = 0; i2 < stringArray.length; i2++) {
                            if (!stringArray[i2].equals("data_version") && (b2 = this.a.b(stringArray[i2])) != null && !b2.equals("")) {
                                this.f35827f.add(stringArray[i2]);
                            }
                        }
                        if (this.f35827f.size() > 0) {
                            try {
                                Collections.sort(this.f35827f, new C1827a(this));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            this.f35825d = true;
                        }
                    } else if (this.f35827f != null) {
                        this.f35827f.clear();
                        this.f35827f = null;
                    }
                    if (this.f35827f != null && !this.f35827f.isEmpty()) {
                        return new ArrayList<>(this.f35827f);
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return new ArrayList<>(this.f35827f);
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == null) {
                return null;
            }
            if (!this.f35824c || this.f35826e == null) {
                try {
                    Bundle bundle = new Bundle();
                    this.a.a(bundle);
                    String[] stringArray = bundle.getStringArray("rstString");
                    if (stringArray != null) {
                        if (this.f35826e == null) {
                            this.f35826e = new Vector<>();
                        } else {
                            this.f35826e.clear();
                        }
                        for (String str : stringArray) {
                            if (!str.equals("data_version")) {
                                this.f35826e.add(str);
                            }
                        }
                        if (this.f35826e.size() > 0) {
                            try {
                                Collections.sort(this.f35826e, new C1827a(this));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            this.f35824c = true;
                        }
                    } else if (this.f35826e != null) {
                        this.f35826e.clear();
                        this.f35826e = null;
                    }
                    Vector<String> vector = this.f35826e;
                    if (vector == null || vector.size() == 0) {
                        return null;
                    }
                    return new ArrayList<>(this.f35826e);
                } catch (Exception unused) {
                    return null;
                }
            }
            return new ArrayList<>(this.f35826e);
        }
        return (ArrayList) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.f35830i.c() || this.f35829h.c() || this.f35829h.b()) {
                this.f35830i.a();
                if (this.a == null) {
                    return null;
                }
                ArrayList<String> d2 = d();
                JSONObject jSONObject = new JSONObject();
                if (d2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        int i2 = 0;
                        Iterator<String> it = d2.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (next != null && !next.equals("data_version") && (b2 = this.a.b(next)) != null && !b2.equals("")) {
                                JSONObject optJSONObject = new JSONObject(b2).optJSONObject("Fav_Sync");
                                optJSONObject.put("key", next);
                                jSONArray.put(i2, optJSONObject);
                                i2++;
                            }
                        }
                        if (i2 > 0) {
                            jSONObject.put("favcontents", jSONArray);
                            jSONObject.put("favpoinum", i2);
                        }
                    } catch (JSONException unused) {
                        return null;
                    }
                }
                this.f35830i.b();
                this.f35829h.a(jSONObject.toString());
                return this.f35829h.a();
            }
            return this.f35829h.a();
        }
        return (String) invokeV.objValue;
    }
}
