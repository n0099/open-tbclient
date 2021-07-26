package com.baidu.mapsdkplatform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f7659b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comjni.map.favorite.a f7660a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7661c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7662d;

    /* renamed from: e  reason: collision with root package name */
    public Vector<String> f7663e;

    /* renamed from: f  reason: collision with root package name */
    public Vector<String> f7664f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7665g;

    /* renamed from: h  reason: collision with root package name */
    public c f7666h;

    /* renamed from: i  reason: collision with root package name */
    public b f7667i;

    /* renamed from: com.baidu.mapsdkplatform.comapi.favrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0118a implements Comparator<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7668a;

        public C0118a(a aVar) {
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
            this.f7668a = aVar;
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

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7669a;

        /* renamed from: b  reason: collision with root package name */
        public long f7670b;

        /* renamed from: c  reason: collision with root package name */
        public long f7671c;

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
            this.f7669a = aVar;
        }

        public /* synthetic */ b(a aVar, com.baidu.mapsdkplatform.comapi.favrite.b bVar) {
            this(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.f7670b = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                this.f7671c = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.f7671c - this.f7670b > 1000 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7672a;

        /* renamed from: b  reason: collision with root package name */
        public String f7673b;

        /* renamed from: c  reason: collision with root package name */
        public long f7674c;

        /* renamed from: d  reason: collision with root package name */
        public long f7675d;

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
            this.f7672a = aVar;
            this.f7674c = 5000L;
            this.f7675d = 0L;
        }

        public /* synthetic */ c(a aVar, com.baidu.mapsdkplatform.comapi.favrite.b bVar) {
            this(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f7673b : (String) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
                this.f7673b = str;
                this.f7675d = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? TextUtils.isEmpty(this.f7673b) : invokeV.booleanValue;
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
        this.f7660a = null;
        this.f7661c = false;
        this.f7662d = false;
        this.f7663e = null;
        this.f7664f = null;
        this.f7665g = false;
        this.f7666h = new c(this, null);
        this.f7667i = new b(this, null);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f7659b == null) {
                synchronized (a.class) {
                    if (f7659b == null) {
                        a aVar = new a();
                        f7659b = aVar;
                        aVar.h();
                    }
                }
            }
            return f7659b;
        }
        return (a) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        com.baidu.mapsdkplatform.comjni.map.favorite.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            a aVar2 = f7659b;
            return (aVar2 == null || (aVar = aVar2.f7660a) == null || !aVar.d()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.f7660a == null) {
                com.baidu.mapsdkplatform.comjni.map.favorite.a aVar = new com.baidu.mapsdkplatform.comjni.map.favorite.a();
                this.f7660a = aVar;
                if (aVar.a() == 0) {
                    this.f7660a = null;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (this.f7660a == null) {
                return false;
            }
            String str = SysOSUtil.getModuleFileName() + "/";
            this.f7660a.a(1);
            return this.f7660a.a(str, "fav_poi", "fifo", 10, 501, -1);
        }
        return invokeV.booleanValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f7661c = false;
            this.f7662d = false;
        }
    }

    public synchronized int a(String str, FavSyncPoi favSyncPoi) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, favSyncPoi)) == null) {
            synchronized (this) {
                if (this.f7660a == null) {
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
                            if (b2 != null && str.equals(b2.f7651b)) {
                                return -1;
                            }
                        }
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        favSyncPoi.f7651b = str;
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        String str2 = valueOf + "_" + favSyncPoi.hashCode();
                        favSyncPoi.f7657h = valueOf;
                        favSyncPoi.f7650a = str2;
                        jSONObject.put("bdetail", favSyncPoi.f7658i);
                        jSONObject.put("uspoiname", favSyncPoi.f7651b);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("x", favSyncPoi.f7652c.getmPtx());
                        jSONObject2.put("y", favSyncPoi.f7652c.getmPty());
                        jSONObject.put(Config.PLATFORM_TYPE, jSONObject2);
                        jSONObject.put("ncityid", favSyncPoi.f7654e);
                        jSONObject.put("npoitype", favSyncPoi.f7656g);
                        jSONObject.put("uspoiuid", favSyncPoi.f7655f);
                        jSONObject.put(DuPaBInfoMsg.B_ADDR, favSyncPoi.f7653d);
                        jSONObject.put("addtimesec", favSyncPoi.f7657h);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("Fav_Sync", jSONObject);
                        jSONObject3.put("Fav_Content", favSyncPoi.j);
                        if (!this.f7660a.a(str2, jSONObject3.toString())) {
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
                if (this.f7660a == null) {
                    return false;
                }
                if (str != null && !str.equals("")) {
                    if (c(str)) {
                        j();
                        return this.f7660a.a(str);
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
            if (this.f7660a != null && str != null && !str.equals("")) {
                try {
                    if (c(str)) {
                        FavSyncPoi favSyncPoi = new FavSyncPoi();
                        String b2 = this.f7660a.b(str);
                        if (b2 != null && !b2.equals("")) {
                            JSONObject jSONObject = new JSONObject(b2);
                            JSONObject optJSONObject = jSONObject.optJSONObject("Fav_Sync");
                            String optString = jSONObject.optString("Fav_Content");
                            favSyncPoi.f7651b = optJSONObject.optString("uspoiname");
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(Config.PLATFORM_TYPE);
                            favSyncPoi.f7652c = new Point(optJSONObject2.optInt("x"), optJSONObject2.optInt("y"));
                            favSyncPoi.f7654e = optJSONObject.optString("ncityid");
                            favSyncPoi.f7655f = optJSONObject.optString("uspoiuid");
                            favSyncPoi.f7656g = optJSONObject.optInt("npoitype");
                            favSyncPoi.f7653d = optJSONObject.optString(DuPaBInfoMsg.B_ADDR);
                            favSyncPoi.f7657h = optJSONObject.optString("addtimesec");
                            favSyncPoi.f7658i = optJSONObject.optBoolean("bdetail");
                            favSyncPoi.j = optString;
                            favSyncPoi.f7650a = str;
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = f7659b) == null) {
            return;
        }
        com.baidu.mapsdkplatform.comjni.map.favorite.a aVar2 = aVar.f7660a;
        if (aVar2 != null) {
            aVar2.b();
            f7659b.f7660a = null;
        }
        f7659b = null;
    }

    public synchronized boolean b(String str, FavSyncPoi favSyncPoi) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, favSyncPoi)) == null) {
            synchronized (this) {
                boolean z = false;
                if (this.f7660a != null && str != null && !str.equals("") && favSyncPoi != null) {
                    if (c(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("uspoiname", favSyncPoi.f7651b);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("x", favSyncPoi.f7652c.getmPtx());
                            jSONObject2.put("y", favSyncPoi.f7652c.getmPty());
                            jSONObject.put(Config.PLATFORM_TYPE, jSONObject2);
                            jSONObject.put("ncityid", favSyncPoi.f7654e);
                            jSONObject.put("npoitype", favSyncPoi.f7656g);
                            jSONObject.put("uspoiuid", favSyncPoi.f7655f);
                            jSONObject.put(DuPaBInfoMsg.B_ADDR, favSyncPoi.f7653d);
                            String valueOf = String.valueOf(System.currentTimeMillis());
                            favSyncPoi.f7657h = valueOf;
                            jSONObject.put("addtimesec", valueOf);
                            jSONObject.put("bdetail", false);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("Fav_Sync", jSONObject);
                            jSONObject3.put("Fav_Content", favSyncPoi.j);
                            j();
                            if (this.f7660a != null) {
                                if (this.f7660a.b(str, jSONObject3.toString())) {
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
                if (this.f7660a == null) {
                    return false;
                }
                j();
                boolean c2 = this.f7660a.c();
                g();
                return c2;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? (this.f7660a == null || str == null || str.equals("") || !this.f7660a.c(str)) ? false : true : invokeL.booleanValue;
    }

    public ArrayList<String> d() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f7660a == null) {
                return null;
            }
            if (!this.f7662d || this.f7664f == null) {
                try {
                    Bundle bundle = new Bundle();
                    this.f7660a.a(bundle);
                    String[] stringArray = bundle.getStringArray("rstString");
                    if (stringArray != null) {
                        if (this.f7664f == null) {
                            this.f7664f = new Vector<>();
                        } else {
                            this.f7664f.clear();
                        }
                        for (int i2 = 0; i2 < stringArray.length; i2++) {
                            if (!stringArray[i2].equals("data_version") && (b2 = this.f7660a.b(stringArray[i2])) != null && !b2.equals("")) {
                                this.f7664f.add(stringArray[i2]);
                            }
                        }
                        if (this.f7664f.size() > 0) {
                            try {
                                Collections.sort(this.f7664f, new C0118a(this));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            this.f7662d = true;
                        }
                    } else if (this.f7664f != null) {
                        this.f7664f.clear();
                        this.f7664f = null;
                    }
                    if (this.f7664f != null && !this.f7664f.isEmpty()) {
                        return new ArrayList<>(this.f7664f);
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return new ArrayList<>(this.f7664f);
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f7660a == null) {
                return null;
            }
            if (!this.f7661c || this.f7663e == null) {
                try {
                    Bundle bundle = new Bundle();
                    this.f7660a.a(bundle);
                    String[] stringArray = bundle.getStringArray("rstString");
                    if (stringArray != null) {
                        if (this.f7663e == null) {
                            this.f7663e = new Vector<>();
                        } else {
                            this.f7663e.clear();
                        }
                        for (String str : stringArray) {
                            if (!str.equals("data_version")) {
                                this.f7663e.add(str);
                            }
                        }
                        if (this.f7663e.size() > 0) {
                            try {
                                Collections.sort(this.f7663e, new C0118a(this));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            this.f7661c = true;
                        }
                    } else if (this.f7663e != null) {
                        this.f7663e.clear();
                        this.f7663e = null;
                    }
                    Vector<String> vector = this.f7663e;
                    if (vector == null || vector.size() == 0) {
                        return null;
                    }
                    return new ArrayList<>(this.f7663e);
                } catch (Exception unused) {
                    return null;
                }
            }
            return new ArrayList<>(this.f7663e);
        }
        return (ArrayList) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.f7667i.c() || this.f7666h.c() || this.f7666h.b()) {
                this.f7667i.a();
                if (this.f7660a == null) {
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
                            if (next != null && !next.equals("data_version") && (b2 = this.f7660a.b(next)) != null && !b2.equals("")) {
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
                this.f7667i.b();
                this.f7666h.a(jSONObject.toString());
                return this.f7666h.a();
            }
            return this.f7666h.a();
        }
        return (String) invokeV.objValue;
    }
}
