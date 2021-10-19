package com.baidu.mapsdkplatform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f42212b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comjni.map.favorite.a f42213a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42214c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42215d;

    /* renamed from: e  reason: collision with root package name */
    public Vector<String> f42216e;

    /* renamed from: f  reason: collision with root package name */
    public Vector<String> f42217f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42218g;

    /* renamed from: h  reason: collision with root package name */
    public c f42219h;

    /* renamed from: i  reason: collision with root package name */
    public b f42220i;

    /* renamed from: com.baidu.mapsdkplatform.comapi.favrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1674a implements Comparator<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42221a;

        public C1674a(a aVar) {
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
            this.f42221a = aVar;
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

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42222a;

        /* renamed from: b  reason: collision with root package name */
        public long f42223b;

        /* renamed from: c  reason: collision with root package name */
        public long f42224c;

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
            this.f42222a = aVar;
        }

        public /* synthetic */ b(a aVar, com.baidu.mapsdkplatform.comapi.favrite.b bVar) {
            this(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.f42223b = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                this.f42224c = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.f42224c - this.f42223b > 1000 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42225a;

        /* renamed from: b  reason: collision with root package name */
        public String f42226b;

        /* renamed from: c  reason: collision with root package name */
        public long f42227c;

        /* renamed from: d  reason: collision with root package name */
        public long f42228d;

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
            this.f42225a = aVar;
            this.f42227c = 5000L;
            this.f42228d = 0L;
        }

        public /* synthetic */ c(a aVar, com.baidu.mapsdkplatform.comapi.favrite.b bVar) {
            this(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f42226b : (String) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
                this.f42226b = str;
                this.f42228d = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? TextUtils.isEmpty(this.f42226b) : invokeV.booleanValue;
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
        this.f42213a = null;
        this.f42214c = false;
        this.f42215d = false;
        this.f42216e = null;
        this.f42217f = null;
        this.f42218g = false;
        this.f42219h = new c(this, null);
        this.f42220i = new b(this, null);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f42212b == null) {
                synchronized (a.class) {
                    if (f42212b == null) {
                        a aVar = new a();
                        f42212b = aVar;
                        aVar.h();
                    }
                }
            }
            return f42212b;
        }
        return (a) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        com.baidu.mapsdkplatform.comjni.map.favorite.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            a aVar2 = f42212b;
            return (aVar2 == null || (aVar = aVar2.f42213a) == null || !aVar.d()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.f42213a == null) {
                com.baidu.mapsdkplatform.comjni.map.favorite.a aVar = new com.baidu.mapsdkplatform.comjni.map.favorite.a();
                this.f42213a = aVar;
                if (aVar.a() == 0) {
                    this.f42213a = null;
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
            if (this.f42213a == null) {
                return false;
            }
            String str = SysOSUtil.getModuleFileName() + "/";
            this.f42213a.a(1);
            return this.f42213a.a(str, "fav_poi", "fifo", 10, 501, -1);
        }
        return invokeV.booleanValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f42214c = false;
            this.f42215d = false;
        }
    }

    public synchronized int a(String str, FavSyncPoi favSyncPoi) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, favSyncPoi)) == null) {
            synchronized (this) {
                if (this.f42213a == null) {
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
                            if (b2 != null && str.equals(b2.f42203b)) {
                                return -1;
                            }
                        }
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        favSyncPoi.f42203b = str;
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        String str2 = valueOf + "_" + favSyncPoi.hashCode();
                        favSyncPoi.f42209h = valueOf;
                        favSyncPoi.f42202a = str2;
                        jSONObject.put("bdetail", favSyncPoi.f42210i);
                        jSONObject.put("uspoiname", favSyncPoi.f42203b);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("x", favSyncPoi.f42204c.getmPtx());
                        jSONObject2.put("y", favSyncPoi.f42204c.getmPty());
                        jSONObject.put("pt", jSONObject2);
                        jSONObject.put("ncityid", favSyncPoi.f42206e);
                        jSONObject.put("npoitype", favSyncPoi.f42208g);
                        jSONObject.put("uspoiuid", favSyncPoi.f42207f);
                        jSONObject.put(DuPaBInfoMsg.B_ADDR, favSyncPoi.f42205d);
                        jSONObject.put("addtimesec", favSyncPoi.f42209h);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("Fav_Sync", jSONObject);
                        jSONObject3.put("Fav_Content", favSyncPoi.f42211j);
                        if (!this.f42213a.a(str2, jSONObject3.toString())) {
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
                if (this.f42213a == null) {
                    return false;
                }
                if (str != null && !str.equals("")) {
                    if (c(str)) {
                        j();
                        return this.f42213a.a(str);
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
            if (this.f42213a != null && str != null && !str.equals("")) {
                try {
                    if (c(str)) {
                        FavSyncPoi favSyncPoi = new FavSyncPoi();
                        String b2 = this.f42213a.b(str);
                        if (b2 != null && !b2.equals("")) {
                            JSONObject jSONObject = new JSONObject(b2);
                            JSONObject optJSONObject = jSONObject.optJSONObject("Fav_Sync");
                            String optString = jSONObject.optString("Fav_Content");
                            favSyncPoi.f42203b = optJSONObject.optString("uspoiname");
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("pt");
                            favSyncPoi.f42204c = new Point(optJSONObject2.optInt("x"), optJSONObject2.optInt("y"));
                            favSyncPoi.f42206e = optJSONObject.optString("ncityid");
                            favSyncPoi.f42207f = optJSONObject.optString("uspoiuid");
                            favSyncPoi.f42208g = optJSONObject.optInt("npoitype");
                            favSyncPoi.f42205d = optJSONObject.optString(DuPaBInfoMsg.B_ADDR);
                            favSyncPoi.f42209h = optJSONObject.optString("addtimesec");
                            favSyncPoi.f42210i = optJSONObject.optBoolean("bdetail");
                            favSyncPoi.f42211j = optString;
                            favSyncPoi.f42202a = str;
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = f42212b) == null) {
            return;
        }
        com.baidu.mapsdkplatform.comjni.map.favorite.a aVar2 = aVar.f42213a;
        if (aVar2 != null) {
            aVar2.b();
            f42212b.f42213a = null;
        }
        f42212b = null;
    }

    public synchronized boolean b(String str, FavSyncPoi favSyncPoi) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, favSyncPoi)) == null) {
            synchronized (this) {
                boolean z = false;
                if (this.f42213a != null && str != null && !str.equals("") && favSyncPoi != null) {
                    if (c(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("uspoiname", favSyncPoi.f42203b);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("x", favSyncPoi.f42204c.getmPtx());
                            jSONObject2.put("y", favSyncPoi.f42204c.getmPty());
                            jSONObject.put("pt", jSONObject2);
                            jSONObject.put("ncityid", favSyncPoi.f42206e);
                            jSONObject.put("npoitype", favSyncPoi.f42208g);
                            jSONObject.put("uspoiuid", favSyncPoi.f42207f);
                            jSONObject.put(DuPaBInfoMsg.B_ADDR, favSyncPoi.f42205d);
                            String valueOf = String.valueOf(System.currentTimeMillis());
                            favSyncPoi.f42209h = valueOf;
                            jSONObject.put("addtimesec", valueOf);
                            jSONObject.put("bdetail", false);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("Fav_Sync", jSONObject);
                            jSONObject3.put("Fav_Content", favSyncPoi.f42211j);
                            j();
                            if (this.f42213a != null) {
                                if (this.f42213a.b(str, jSONObject3.toString())) {
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
                if (this.f42213a == null) {
                    return false;
                }
                j();
                boolean c2 = this.f42213a.c();
                g();
                return c2;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? (this.f42213a == null || str == null || str.equals("") || !this.f42213a.c(str)) ? false : true : invokeL.booleanValue;
    }

    public ArrayList<String> d() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f42213a == null) {
                return null;
            }
            if (!this.f42215d || this.f42217f == null) {
                try {
                    Bundle bundle = new Bundle();
                    this.f42213a.a(bundle);
                    String[] stringArray = bundle.getStringArray("rstString");
                    if (stringArray != null) {
                        if (this.f42217f == null) {
                            this.f42217f = new Vector<>();
                        } else {
                            this.f42217f.clear();
                        }
                        for (int i2 = 0; i2 < stringArray.length; i2++) {
                            if (!stringArray[i2].equals("data_version") && (b2 = this.f42213a.b(stringArray[i2])) != null && !b2.equals("")) {
                                this.f42217f.add(stringArray[i2]);
                            }
                        }
                        if (this.f42217f.size() > 0) {
                            try {
                                Collections.sort(this.f42217f, new C1674a(this));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            this.f42215d = true;
                        }
                    } else if (this.f42217f != null) {
                        this.f42217f.clear();
                        this.f42217f = null;
                    }
                    if (this.f42217f != null && !this.f42217f.isEmpty()) {
                        return new ArrayList<>(this.f42217f);
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return new ArrayList<>(this.f42217f);
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f42213a == null) {
                return null;
            }
            if (!this.f42214c || this.f42216e == null) {
                try {
                    Bundle bundle = new Bundle();
                    this.f42213a.a(bundle);
                    String[] stringArray = bundle.getStringArray("rstString");
                    if (stringArray != null) {
                        if (this.f42216e == null) {
                            this.f42216e = new Vector<>();
                        } else {
                            this.f42216e.clear();
                        }
                        for (String str : stringArray) {
                            if (!str.equals("data_version")) {
                                this.f42216e.add(str);
                            }
                        }
                        if (this.f42216e.size() > 0) {
                            try {
                                Collections.sort(this.f42216e, new C1674a(this));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            this.f42214c = true;
                        }
                    } else if (this.f42216e != null) {
                        this.f42216e.clear();
                        this.f42216e = null;
                    }
                    Vector<String> vector = this.f42216e;
                    if (vector == null || vector.size() == 0) {
                        return null;
                    }
                    return new ArrayList<>(this.f42216e);
                } catch (Exception unused) {
                    return null;
                }
            }
            return new ArrayList<>(this.f42216e);
        }
        return (ArrayList) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.f42220i.c() || this.f42219h.c() || this.f42219h.b()) {
                this.f42220i.a();
                if (this.f42213a == null) {
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
                            if (next != null && !next.equals("data_version") && (b2 = this.f42213a.b(next)) != null && !b2.equals("")) {
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
                this.f42220i.b();
                this.f42219h.a(jSONObject.toString());
                return this.f42219h.a();
            }
            return this.f42219h.a();
        }
        return (String) invokeV.objValue;
    }
}
