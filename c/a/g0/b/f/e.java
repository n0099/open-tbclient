package c.a.g0.b.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import c.a.b0.u.n;
import c.a.b0.u.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static d a;

    /* renamed from: b  reason: collision with root package name */
    public static List<g> f3479b;

    /* renamed from: c  reason: collision with root package name */
    public static g f3480c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ File f3481e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3482f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f3483g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f3484h;

        /* renamed from: c.a.g0.b.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0149a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0149a(a aVar) {
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

            @Override // c.a.b0.u.t.a.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (f.k() && !TextUtils.isEmpty(this.a.f3483g) && !TextUtils.equals(c.a.b0.h0.i.a(this.a.f3481e), this.a.f3483g)) {
                        this.a.f3481e.delete();
                        return;
                    }
                    a aVar = this.a;
                    e.w(aVar.f3481e, aVar.f3484h);
                }
            }
        }

        public a(File file, String str, String str2, File file2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, str2, file2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3481e = file;
            this.f3482f = str;
            this.f3483g = str2;
            this.f3484h = file2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.b0.u.t.a.a(this.f3481e, this.f3482f, new C0149a(this));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f3485e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3485e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.y(this.f3485e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f3486e;

        public c(List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3486e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.f3486e) == null || list.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(3);
            Iterator it = this.f3486e.iterator();
            while (it.hasNext() && (gVar = (g) it.next()) != null) {
                if (e.s(gVar.v)) {
                    e.h(gVar);
                } else {
                    arrayList.add(gVar);
                }
            }
            if (arrayList.size() > 0) {
                if (e.a == null) {
                    d unused = e.a = new d(arrayList, null);
                    c.a.b0.h.a.b().registerReceiver(e.a, e.a.getIntentFilter());
                    return;
                }
                e.a.setNeedDownloadList(arrayList);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<g> mNeedDownloadList;

        public /* synthetic */ d(List list, a aVar) {
            this(list);
        }

        public IntentFilter getIntentFilter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE") : (IntentFilter) invokeV.objValue;
        }

        public List<g> getNeedDownloadList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mNeedDownloadList : (List) invokeV.objValue;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) && TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                ArrayList arrayList = new ArrayList();
                for (g gVar : this.mNeedDownloadList) {
                    if (e.s(gVar.v)) {
                        String str = "onReceive: " + gVar;
                        e.h(gVar);
                    } else {
                        arrayList.add(gVar);
                    }
                }
                this.mNeedDownloadList = arrayList;
            }
        }

        public void setNeedDownloadList(List<g> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.mNeedDownloadList = list;
            }
        }

        public d(List<g> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mNeedDownloadList = list;
        }
    }

    public static void A(List<g> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, list) == null) || list == null || list.size() == 0) {
            return;
        }
        f3479b = Collections.synchronizedList(list);
        v(list, n());
    }

    public static int e(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, gVar)) == null) ? f(gVar, false) : invokeL.intValue;
    }

    public static int f(g gVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, gVar, z)) == null) {
            if (gVar.f()) {
                r1 = f.a(c.a.g0.b.e.a()) ? 0 : 1024;
                if (i.a() >= f.d()) {
                    r1 |= 2048;
                }
                if (!f.c(true)) {
                    r1 |= 4096;
                }
                if (r1 != 0) {
                    return r1;
                }
            }
            if (gVar.x) {
                return r1;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long c2 = i.c();
            if (currentTimeMillis < gVar.r || currentTimeMillis > gVar.s) {
                r1 |= 2;
            }
            if (z) {
                int i2 = gVar.w;
                int i3 = gVar.u;
                if (i2 >= i3 || i3 == 0) {
                    r1 |= 8;
                }
            }
            if (currentTimeMillis - c2 < gVar.t * 60000) {
                r1 |= 16;
            }
            File o = o(gVar.f3494g);
            return (o == null || !o.exists()) ? r1 | 4 : r1;
        }
        return invokeLZ.intValue;
    }

    public static void g(@Nullable List<g> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, list) == null) {
            if (list != null && !list.isEmpty()) {
                File[] listFiles = m().listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (g gVar : list) {
                    if (gVar != null) {
                        arrayList.add(k(gVar.f3494g));
                        arrayList.add(k(gVar.y));
                        arrayList.add(k(gVar.G));
                    }
                }
                g gVar2 = f3480c;
                if (gVar2 != null) {
                    arrayList.add(k(gVar2.f3494g));
                    arrayList.add(k(f3480c.y));
                    arrayList.add(k(f3480c.G));
                }
                for (File file : listFiles) {
                    if (!arrayList.contains(file.getName())) {
                        file.delete();
                    }
                }
                return;
            }
            c.a.b0.h0.h.c(m());
        }
    }

    public static void h(g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, gVar) == null) && URLUtil.isNetworkUrl(gVar.f3494g)) {
            i(gVar.f3494g, gVar.f3497j);
            if (!TextUtils.isEmpty(gVar.y)) {
                i(gVar.y, "");
            }
            if (TextUtils.isEmpty(gVar.G)) {
                return;
            }
            i(gVar.G, "");
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            File o = o(str);
            if (o == null || !o.exists()) {
                File r = r(c.a.b0.h0.i.c(str, false));
                if (r.exists()) {
                    r.delete();
                }
                c.a.b0.d0.b.d(new a(r, str, str2, o), "download splash resource");
            }
        }
    }

    public static String j(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, file)) == null) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (Exception unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (Exception unused3) {
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(c.a.b0.h0.i.c(str, false));
            int lastIndexOf = str.lastIndexOf(".");
            int lastIndexOf2 = str.lastIndexOf("/");
            if (lastIndexOf < lastIndexOf2 || lastIndexOf == -1 || lastIndexOf2 == -1) {
                return null;
            }
            sb.append(str.substring(lastIndexOf));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            List<g> u = u(true);
            if (u == null || u.size() <= 0) {
                return null;
            }
            for (int i2 = 0; i2 < u.size(); i2++) {
                g gVar = u.get(i2);
                if (gVar != null && gVar.h()) {
                    return gVar;
                }
            }
            return null;
        }
        return (g) invokeV.objValue;
    }

    public static File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            File file = new File(c.a.b0.h.a.b().getFilesDir(), SpeedStatsUtils.UBC_VALUE_SPLASH);
            file.mkdirs();
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static File n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? new File(m(), "splash.dat") : (File) invokeV.objValue;
    }

    public static File o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            String k = k(str);
            if (TextUtils.isEmpty(k)) {
                return null;
            }
            return new File(m(), k);
        }
        return (File) invokeL.objValue;
    }

    public static List<g> p() {
        InterceptResult invokeV;
        String j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            List<g> list = f3479b;
            if (list != null) {
                return list;
            }
            f3479b = new CopyOnWriteArrayList();
            File n = n();
            if (n.exists() && (j2 = j(n)) != null) {
                try {
                    JSONArray jSONArray = new JSONArray(j2);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        f3479b.add(g.b(jSONArray.optJSONObject(i2)));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return f3479b;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public static HashMap<String, g> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            HashMap<String, g> hashMap = new HashMap<>();
            File n = n();
            if (n.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(j(n));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        g b2 = g.b((JSONObject) jSONArray.get(i2));
                        hashMap.put(b2.f3489b, b2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return hashMap;
            }
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    public static File r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".tmp");
            return new File(m(), stringBuffer.toString());
        }
        return (File) invokeL.objValue;
    }

    public static boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i2)) == null) ? new n(c.a.b0.h.a.b()).a() || i2 == 0 : invokeI.booleanValue;
    }

    public static List<g> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? u(false) : (List) invokeV.objValue;
    }

    public static List<g> u(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65557, null, z)) == null) {
            List<g> p = p();
            if (p != null && p.size() != 0) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                int i2 = 0;
                for (int i3 = 0; i3 < p.size(); i3++) {
                    g gVar = p.get(i3);
                    int f2 = f(gVar, z);
                    if (f2 == 0) {
                        arrayList.add(gVar);
                    } else {
                        i2 |= f2;
                        try {
                            jSONObject.put(gVar.f3490c, f2);
                        } catch (JSONException unused) {
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    BaseVM.i(i2, jSONObject.toString());
                    return null;
                }
                return arrayList;
            }
            BaseVM.h(1);
            return null;
        }
        return (List) invokeZ.objValue;
    }

    public static boolean v(List<g> list, File file) {
        InterceptResult invokeLL;
        StringBuffer stringBuffer;
        int i2;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, list, file)) == null) {
            int i3 = 0;
            if (list.size() <= 0) {
                return false;
            }
            FileWriter fileWriter2 = null;
            try {
                g[] gVarArr = (g[]) list.toArray(new g[list.size() - 1]);
                stringBuffer = new StringBuffer();
                stringBuffer.append(PreferencesUtil.LEFT_MOUNT);
                int length = gVarArr.length;
                while (true) {
                    i2 = length - 1;
                    if (i3 >= i2) {
                        break;
                    }
                    stringBuffer.append(gVarArr[i3].k());
                    stringBuffer.append(",");
                    i3++;
                }
                stringBuffer.append(gVarArr[i2].k());
                stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
                fileWriter = new FileWriter(file);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write(stringBuffer.toString());
                try {
                    fileWriter.close();
                } catch (Exception unused2) {
                }
                return true;
            } catch (IOException unused3) {
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Exception unused4) {
                    }
                }
                return true;
            } catch (Throwable th2) {
                fileWriter2 = fileWriter;
                th = th2;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean w(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, file, file2)) == null) {
            if (file == null || file2 == null) {
                return false;
            }
            return file.renameTo(file2);
        }
        return invokeLL.booleanValue;
    }

    public static void x(List<g> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, list) == null) {
            c.a.b0.d0.b.d(new c(list), "ScheduleDownloadSplashSourceThread");
        }
    }

    public static void y(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, gVar) == null) {
            ArrayList arrayList = new ArrayList();
            File n = n();
            List<g> p = p();
            if (p == null || p.size() == 0) {
                return;
            }
            for (int i2 = 0; i2 < p.size(); i2++) {
                g gVar2 = p.get(i2);
                if (TextUtils.equals(gVar.f3489b, gVar2.f3489b)) {
                    g.l(gVar2, gVar);
                    arrayList.add(gVar2);
                } else {
                    arrayList.add(gVar2);
                }
            }
            v(arrayList, n);
        }
    }

    public static void z(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, null, gVar) == null) || gVar.u < 1) {
            return;
        }
        int i2 = gVar.w;
        if (i2 < Integer.MAX_VALUE) {
            gVar.w = i2 + 1;
        }
        c.a.b0.d0.b.d(new b(gVar), "updateSplashDataItemRate");
    }
}
