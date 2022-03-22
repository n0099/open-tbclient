package c.a.f0.b.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import c.a.a0.u.n;
import c.a.a0.u.t.a;
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
    public static List<g> f2923b;

    /* renamed from: c  reason: collision with root package name */
    public static g f2924c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f2925b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f2926c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ File f2927d;

        /* renamed from: c.a.f0.b.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0140a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0140a(a aVar) {
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

            @Override // c.a.a0.u.t.a.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (f.k() && !TextUtils.isEmpty(this.a.f2926c) && !TextUtils.equals(c.a.a0.h0.i.a(this.a.a), this.a.f2926c)) {
                        this.a.a.delete();
                        return;
                    }
                    a aVar = this.a;
                    e.y(aVar.a, aVar.f2927d);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.f2925b = str;
            this.f2926c = str2;
            this.f2927d = file2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.a0.u.t.a.a(this.a, this.f2925b, new C0140a(this));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.A(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public c(List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null || list.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(3);
            Iterator it = this.a.iterator();
            while (it.hasNext() && (gVar = (g) it.next()) != null) {
                if (e.u(gVar.v)) {
                    e.i(gVar);
                } else {
                    arrayList.add(gVar);
                }
            }
            if (arrayList.size() > 0) {
                if (e.a == null) {
                    d unused = e.a = new d(arrayList, null);
                    c.a.a0.h.a.b().registerReceiver(e.a, e.a.getIntentFilter());
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
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) {
                Log.d("SourceManager", "onReceive: receiver");
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                    ArrayList arrayList = new ArrayList();
                    for (g gVar : this.mNeedDownloadList) {
                        if (e.u(gVar.v)) {
                            Log.d("SourceManager", "onReceive: " + gVar);
                            e.i(gVar);
                        } else {
                            arrayList.add(gVar);
                        }
                    }
                    this.mNeedDownloadList = arrayList;
                }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mNeedDownloadList = list;
        }
    }

    public static void A(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, gVar) == null) {
            ArrayList arrayList = new ArrayList();
            File p = p();
            List<g> r = r();
            if (r == null || r.size() == 0) {
                return;
            }
            for (int i = 0; i < r.size(); i++) {
                g gVar2 = r.get(i);
                if (TextUtils.equals(gVar.f2930b, gVar2.f2930b)) {
                    g.l(gVar2, gVar);
                    arrayList.add(gVar2);
                } else {
                    arrayList.add(gVar2);
                }
            }
            x(arrayList, p);
        }
    }

    public static void B(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, gVar) == null) || gVar.u < 1) {
            return;
        }
        int i = gVar.w;
        if (i < Integer.MAX_VALUE) {
            gVar.w = i + 1;
        }
        c.a.a0.d0.b.d(new b(gVar), "updateSplashDataItemRate");
    }

    public static void C(List<g> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || list == null || list.size() == 0) {
            return;
        }
        f2923b = Collections.synchronizedList(list);
        x(list, p());
    }

    public static int e(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, gVar)) == null) ? g(gVar, false, 0) : invokeL.intValue;
    }

    public static int f(g gVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, gVar, i)) == null) ? g(gVar, false, i) : invokeLI.intValue;
    }

    public static int g(g gVar, boolean z, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{gVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (gVar.f()) {
                i2 = !f.a(c.a.f0.b.e.a()) ? 1024 : 0;
                if (i.a() >= f.d()) {
                    i2 |= 2048;
                }
                if (!f.c(true)) {
                    i2 |= 4096;
                }
                if (i2 != 0) {
                    return i2;
                }
            } else {
                i2 = 0;
            }
            if (gVar.x) {
                return i2;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long c2 = i.c();
            if (currentTimeMillis < gVar.r || currentTimeMillis > gVar.s) {
                i2 |= 2;
            }
            if (z) {
                int i3 = gVar.w;
                int i4 = gVar.u;
                if (i3 >= i4 || i4 == 0) {
                    i2 |= 8;
                }
            }
            if (currentTimeMillis - c2 < gVar.t * 60000) {
                i2 |= 16;
            }
            File q = q(gVar.f2935g);
            if (q == null || !q.exists()) {
                i2 |= 4;
            }
            return (i == 1 && c.a.f0.a.b.d.a().d() != null && c.a.f0.a.b.d.a().d().optInt("hot_launch_splash_policy", 0) == 2 && TextUtils.equals(gVar.f2933e, "splash_video")) ? i2 | 256 : i2;
        }
        return invokeCommon.intValue;
    }

    public static void h(@Nullable List<g> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            if (list != null && !list.isEmpty()) {
                File[] listFiles = o().listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (g gVar : list) {
                    if (gVar != null) {
                        arrayList.add(l(gVar.f2935g));
                        arrayList.add(l(gVar.y));
                        arrayList.add(l(gVar.G));
                    }
                }
                g gVar2 = f2924c;
                if (gVar2 != null) {
                    arrayList.add(l(gVar2.f2935g));
                    arrayList.add(l(f2924c.y));
                    arrayList.add(l(f2924c.G));
                }
                for (File file : listFiles) {
                    if (!arrayList.contains(file.getName())) {
                        file.delete();
                    }
                }
                return;
            }
            c.a.a0.h0.h.c(o());
        }
    }

    public static void i(g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, gVar) == null) && URLUtil.isNetworkUrl(gVar.f2935g)) {
            j(gVar.f2935g, gVar.j);
            if (!TextUtils.isEmpty(gVar.y)) {
                j(gVar.y, "");
            }
            if (TextUtils.isEmpty(gVar.G)) {
                return;
            }
            j(gVar.G, "");
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            File q = q(str);
            if (q == null || !q.exists()) {
                File t = t(c.a.a0.h0.i.c(str, false));
                if (t.exists()) {
                    t.delete();
                }
                c.a.a0.d0.b.d(new a(t, str, str2, q), "download splash resource");
            }
        }
    }

    public static String k(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, file)) == null) {
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

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(c.a.a0.h0.i.c(str, false));
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
    public static g m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? n(0) : (g) invokeV.objValue;
    }

    @Nullable
    public static g n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            List<g> w = w(true, i);
            if (w == null || w.size() <= 0) {
                return null;
            }
            for (int i2 = 0; i2 < w.size(); i2++) {
                g gVar = w.get(i2);
                if (gVar != null && gVar.h()) {
                    return gVar;
                }
            }
            return null;
        }
        return (g) invokeI.objValue;
    }

    public static File o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            File file = new File(c.a.a0.h.a.b().getFilesDir(), SpeedStatsUtils.UBC_VALUE_SPLASH);
            file.mkdirs();
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static File p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? new File(o(), "splash.dat") : (File) invokeV.objValue;
    }

    public static File q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            String l = l(str);
            if (TextUtils.isEmpty(l)) {
                return null;
            }
            return new File(o(), l);
        }
        return (File) invokeL.objValue;
    }

    public static List<g> r() {
        InterceptResult invokeV;
        String k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            List<g> list = f2923b;
            if (list != null) {
                return list;
            }
            f2923b = new CopyOnWriteArrayList();
            File p = p();
            if (p.exists() && (k = k(p)) != null) {
                try {
                    JSONArray jSONArray = new JSONArray(k);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        f2923b.add(g.b(jSONArray.optJSONObject(i)));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return f2923b;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public static HashMap<String, g> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            HashMap<String, g> hashMap = new HashMap<>();
            File p = p();
            if (p.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(k(p));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        g b2 = g.b((JSONObject) jSONArray.get(i));
                        hashMap.put(b2.f2930b, b2);
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

    public static File t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".tmp");
            return new File(o(), stringBuffer.toString());
        }
        return (File) invokeL.objValue;
    }

    public static boolean u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i)) == null) ? new n(c.a.a0.h.a.b()).a() || i == 0 : invokeI.booleanValue;
    }

    public static List<g> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? w(false, 0) : (List) invokeV.objValue;
    }

    public static List<g> w(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            List<g> r = r();
            if (r != null && r.size() != 0) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                int i2 = 0;
                for (int i3 = 0; i3 < r.size(); i3++) {
                    g gVar = r.get(i3);
                    int g2 = g(gVar, z, i);
                    if (g2 == 0) {
                        arrayList.add(gVar);
                    } else {
                        i2 |= g2;
                        try {
                            jSONObject.put(gVar.f2931c, g2);
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
        return (List) invokeCommon.objValue;
    }

    public static boolean x(List<g> list, File file) {
        InterceptResult invokeLL;
        StringBuffer stringBuffer;
        int i;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, list, file)) == null) {
            int i2 = 0;
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
                    i = length - 1;
                    if (i2 >= i) {
                        break;
                    }
                    stringBuffer.append(gVarArr[i2].k());
                    stringBuffer.append(",");
                    i2++;
                }
                stringBuffer.append(gVarArr[i].k());
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

    public static boolean y(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, file, file2)) == null) {
            if (file == null || file2 == null) {
                return false;
            }
            return file.renameTo(file2);
        }
        return invokeLL.booleanValue;
    }

    public static void z(List<g> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, list) == null) {
            c.a.a0.d0.b.d(new c(list), "ScheduleDownloadSplashSourceThread");
        }
    }
}
