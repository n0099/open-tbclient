package com.baidu.mapsdkplatform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.favorite.NAFavorite;
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
    public static a b;
    public transient /* synthetic */ FieldHolder $fh;
    public NAFavorite a;
    public boolean c;
    public boolean d;
    public Vector<String> e;
    public Vector<String> f;
    public boolean g;
    public c h;
    public b i;

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

    /* renamed from: com.baidu.mapsdkplatform.comapi.favrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0113a implements Comparator<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0113a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                return str2.compareTo(str);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;
        public long b;
        public long c;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.b = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                this.c = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
                if (this.c - this.b > 1000) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;
        public String b;
        public long c;
        public long d;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.c = 5000L;
            this.d = 0L;
        }

        public /* synthetic */ c(a aVar, com.baidu.mapsdkplatform.comapi.favrite.b bVar) {
            this(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
                return TextUtils.isEmpty(this.b);
            }
            return invokeV.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
                this.b = str;
                this.d = System.currentTimeMillis();
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = false;
        this.d = false;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = new c(this, null);
        this.i = new b(this, null);
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.a == null) {
                NAFavorite nAFavorite = new NAFavorite();
                this.a = nAFavorite;
                if (nAFavorite.a() == 0) {
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

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (a.class) {
                    if (b == null) {
                        a aVar = new a();
                        b = aVar;
                        aVar.h();
                    }
                }
            }
            return b;
        }
        return (a) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        NAFavorite nAFavorite;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            a aVar = b;
            if (aVar != null && (nAFavorite = aVar.a) != null && nAFavorite.d()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.c = false;
            this.d = false;
        }
    }

    public void b() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (aVar = b) != null) {
            NAFavorite nAFavorite = aVar.a;
            if (nAFavorite != null) {
                nAFavorite.b();
                b.a = null;
            }
            b = null;
        }
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

    public synchronized int a(String str, FavSyncPoi favSyncPoi) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, favSyncPoi)) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return 0;
                }
                if (str != null && !str.equals("") && favSyncPoi != null) {
                    j();
                    ArrayList<String> e = e();
                    if (e != null) {
                        i = e.size();
                    } else {
                        i = 0;
                    }
                    if (i + 1 > 500) {
                        return -2;
                    }
                    if (e != null && e.size() > 0) {
                        Iterator<String> it = e.iterator();
                        while (it.hasNext()) {
                            FavSyncPoi b2 = b(it.next());
                            if (b2 != null && str.equals(b2.b)) {
                                return -1;
                            }
                        }
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        favSyncPoi.b = str;
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        String str2 = valueOf + "_" + favSyncPoi.hashCode();
                        favSyncPoi.h = valueOf;
                        favSyncPoi.a = str2;
                        jSONObject.put("bdetail", favSyncPoi.i);
                        jSONObject.put("uspoiname", favSyncPoi.b);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("x", favSyncPoi.c.getDoubleX());
                        jSONObject2.put("y", favSyncPoi.c.getDoubleY());
                        jSONObject.put(Config.PLATFORM_TYPE, jSONObject2);
                        jSONObject.put("ncityid", favSyncPoi.e);
                        jSONObject.put("npoitype", favSyncPoi.g);
                        jSONObject.put("uspoiuid", favSyncPoi.f);
                        jSONObject.put(DuPaBInfoMsg.B_ADDR, favSyncPoi.d);
                        jSONObject.put("addtimesec", favSyncPoi.h);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("Fav_Sync", jSONObject);
                        jSONObject3.put("Fav_Content", favSyncPoi.j);
                        if (this.a.a(str2, jSONObject3.toString())) {
                            j();
                            g();
                            return 1;
                        }
                        g();
                        return 0;
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
                    if (!c(str)) {
                        return false;
                    }
                    j();
                    return this.a.a(str);
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
                    if (!c(str)) {
                        return null;
                    }
                    FavSyncPoi favSyncPoi = new FavSyncPoi();
                    String b2 = this.a.b(str);
                    if (b2 != null && !b2.equals("")) {
                        JSONObject jSONObject = new JSONObject(b2);
                        JSONObject optJSONObject = jSONObject.optJSONObject("Fav_Sync");
                        String optString = jSONObject.optString("Fav_Content");
                        favSyncPoi.b = optJSONObject.optString("uspoiname");
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(Config.PLATFORM_TYPE);
                        favSyncPoi.c = new Point(optJSONObject2.optInt("x"), optJSONObject2.optInt("y"));
                        favSyncPoi.e = optJSONObject.optString("ncityid");
                        favSyncPoi.f = optJSONObject.optString("uspoiuid");
                        favSyncPoi.g = optJSONObject.optInt("npoitype");
                        favSyncPoi.d = optJSONObject.optString(DuPaBInfoMsg.B_ADDR);
                        favSyncPoi.h = optJSONObject.optString("addtimesec");
                        favSyncPoi.i = optJSONObject.optBoolean("bdetail");
                        favSyncPoi.j = optString;
                        favSyncPoi.a = str;
                        return favSyncPoi;
                    }
                    return null;
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (FavSyncPoi) invokeL.objValue;
    }

    public synchronized boolean b(String str, FavSyncPoi favSyncPoi) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, favSyncPoi)) == null) {
            synchronized (this) {
                boolean z = false;
                if (this.a != null && str != null && !str.equals("") && favSyncPoi != null) {
                    if (!c(str)) {
                        return false;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("uspoiname", favSyncPoi.b);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("x", favSyncPoi.c.getDoubleX());
                        jSONObject2.put("y", favSyncPoi.c.getDoubleY());
                        jSONObject.put(Config.PLATFORM_TYPE, jSONObject2);
                        jSONObject.put("ncityid", favSyncPoi.e);
                        jSONObject.put("npoitype", favSyncPoi.g);
                        jSONObject.put("uspoiuid", favSyncPoi.f);
                        jSONObject.put(DuPaBInfoMsg.B_ADDR, favSyncPoi.d);
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        favSyncPoi.h = valueOf;
                        jSONObject.put("addtimesec", valueOf);
                        jSONObject.put("bdetail", false);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("Fav_Sync", jSONObject);
                        jSONObject3.put("Fav_Content", favSyncPoi.j);
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
        }
        return invokeLL.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (this.a != null && str != null && !str.equals("") && this.a.c(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ArrayList<String> d() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null) {
                return null;
            }
            if (this.d && this.f != null) {
                return new ArrayList<>(this.f);
            }
            try {
                Bundle bundle = new Bundle();
                this.a.a(bundle);
                String[] stringArray = bundle.getStringArray("rstString");
                if (stringArray != null) {
                    if (this.f == null) {
                        this.f = new Vector<>();
                    } else {
                        this.f.clear();
                    }
                    for (int i = 0; i < stringArray.length; i++) {
                        if (!stringArray[i].equals("data_version") && (b2 = this.a.b(stringArray[i])) != null && !b2.equals("")) {
                            this.f.add(stringArray[i]);
                        }
                    }
                    if (this.f.size() > 0) {
                        try {
                            Collections.sort(this.f, new C0113a(this));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.d = true;
                    }
                } else if (this.f != null) {
                    this.f.clear();
                    this.f = null;
                }
                if (this.f != null && !this.f.isEmpty()) {
                    return new ArrayList<>(this.f);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
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
            if (this.c && this.e != null) {
                return new ArrayList<>(this.e);
            }
            try {
                Bundle bundle = new Bundle();
                this.a.a(bundle);
                String[] stringArray = bundle.getStringArray("rstString");
                if (stringArray != null) {
                    if (this.e == null) {
                        this.e = new Vector<>();
                    } else {
                        this.e.clear();
                    }
                    for (String str : stringArray) {
                        if (!str.equals("data_version")) {
                            this.e.add(str);
                        }
                    }
                    if (this.e.size() > 0) {
                        try {
                            Collections.sort(this.e, new C0113a(this));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.c = true;
                    }
                } else if (this.e != null) {
                    this.e.clear();
                    this.e = null;
                }
                Vector<String> vector = this.e;
                if (vector == null || vector.size() == 0) {
                    return null;
                }
                return new ArrayList<>(this.e);
            } catch (Exception unused) {
                return null;
            }
        }
        return (ArrayList) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.i.c() || this.h.c() || this.h.b()) {
                this.i.a();
                if (this.a == null) {
                    return null;
                }
                ArrayList<String> d = d();
                JSONObject jSONObject = new JSONObject();
                if (d != null) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        int i = 0;
                        Iterator<String> it = d.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (next != null && !next.equals("data_version") && (b2 = this.a.b(next)) != null && !b2.equals("")) {
                                JSONObject optJSONObject = new JSONObject(b2).optJSONObject("Fav_Sync");
                                optJSONObject.put("key", next);
                                jSONArray.put(i, optJSONObject);
                                i++;
                            }
                        }
                        if (i > 0) {
                            jSONObject.put("favcontents", jSONArray);
                            jSONObject.put("favpoinum", i);
                        }
                    } catch (JSONException unused) {
                        return null;
                    }
                }
                this.i.b();
                this.h.a(jSONObject.toString());
                return this.h.a();
            }
            return this.h.a();
        }
        return (String) invokeV.objValue;
    }
}
