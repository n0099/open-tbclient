package c.a.f0.b.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import c.a.f0.a.c.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3404a;

    /* renamed from: b  reason: collision with root package name */
    public static d f3405b;

    /* renamed from: c  reason: collision with root package name */
    public static List<h> f3406c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ File f3407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3408f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f3409g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f3410h;

        /* renamed from: c.a.f0.b.g.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0072a implements e.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f3411a;

            public C0072a(a aVar) {
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
                this.f3411a = aVar;
            }

            @Override // c.a.f0.a.c.e.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (g.e() && !TextUtils.isEmpty(this.f3411a.f3409g) && !TextUtils.equals(c.a.f0.a.c.f.b(this.f3411a.f3407e), this.f3411a.f3409g)) {
                        if (f.f3404a) {
                            String str = "md5 check fail  url:" + this.f3411a.f3408f;
                        }
                        this.f3411a.f3407e.delete();
                        return;
                    }
                    a aVar = this.f3411a;
                    f.v(aVar.f3407e, aVar.f3410h);
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
            this.f3407e = file;
            this.f3408f = str;
            this.f3409g = str2;
            this.f3410h = file2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.f0.a.c.e.b(this.f3407e, this.f3408f, new C0072a(this));
                } catch (Exception e2) {
                    if (c.a.f0.a.b.a.f3338a.get().t()) {
                        e2.toString();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f3412e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3412e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f.x(this.f3412e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f3413e;

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
            this.f3413e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = f.f3404a;
                List list = this.f3413e;
                if (list == null || list.size() == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(3);
                Iterator it = this.f3413e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    h hVar = (h) it.next();
                    if (hVar == null) {
                        boolean unused2 = f.f3404a;
                        break;
                    } else if (c.a.f0.a.c.h.a(hVar.v)) {
                        f.h(hVar);
                    } else {
                        arrayList.add(hVar);
                    }
                }
                if (arrayList.size() > 0) {
                    if (f.f3405b == null) {
                        d unused3 = f.f3405b = new d(arrayList, null);
                        c.a.f0.a.b.a.f3338a.get().p().registerReceiver(f.f3405b, f.f3405b.getIntentFilter());
                        return;
                    }
                    f.f3405b.setNeedDownloadList(arrayList);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<h> mNeedDownloadList;

        public /* synthetic */ d(List list, a aVar) {
            this(list);
        }

        public IntentFilter getIntentFilter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE") : (IntentFilter) invokeV.objValue;
        }

        public List<h> getNeedDownloadList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mNeedDownloadList : (List) invokeV.objValue;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) && TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                ArrayList arrayList = new ArrayList();
                for (h hVar : this.mNeedDownloadList) {
                    if (c.a.f0.a.c.h.a(hVar.v)) {
                        String str = "onReceive: " + hVar;
                        f.h(hVar);
                    } else {
                        arrayList.add(hVar);
                    }
                }
                this.mNeedDownloadList = arrayList;
            }
        }

        public void setNeedDownloadList(List<h> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.mNeedDownloadList = list;
            }
        }

        public d(List<h> list) {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-435778231, "Lc/a/f0/b/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-435778231, "Lc/a/f0/b/g/f;");
                return;
            }
        }
        f3404a = c.a.f0.a.a.a.f3336a;
    }

    public static int e(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, hVar)) == null) ? f(hVar, false) : invokeL.intValue;
    }

    public static int f(h hVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, hVar, z)) == null) {
            int i2 = 0;
            if (hVar.x) {
                return 0;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long a2 = j.a();
            i2 = (currentTimeMillis < hVar.r || currentTimeMillis > hVar.s) ? 2 : 2;
            if (z) {
                int i3 = hVar.w;
                int i4 = hVar.u;
                if (i3 >= i4 || i4 == 0) {
                    i2 |= 8;
                }
            }
            if (currentTimeMillis - a2 < hVar.t * 60000) {
                i2 |= 16;
            }
            File o = o(hVar.f3420g);
            if (o == null || !o.exists()) {
                i2 |= 4;
            }
            if (f3404a) {
                String str = "物料不满足展示条件 reason ：" + i2;
            }
            return i2;
        }
        return invokeLZ.intValue;
    }

    public static void g(@Nullable List<h> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, list) == null) {
            if (list != null && !list.isEmpty()) {
                File[] listFiles = m().listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (h hVar : list) {
                    if (hVar != null) {
                        arrayList.add(k(hVar.f3420g));
                        arrayList.add(k(hVar.y));
                        arrayList.add(k(hVar.G));
                    }
                }
                for (File file : listFiles) {
                    if (!arrayList.contains(file.getName())) {
                        file.delete();
                    }
                }
                return;
            }
            c.a.f0.a.c.e.a(m());
        }
    }

    public static void h(h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, hVar) == null) && URLUtil.isNetworkUrl(hVar.f3420g)) {
            i(hVar.f3420g, hVar.f3423j);
            if (!TextUtils.isEmpty(hVar.y)) {
                i(hVar.y, "");
            }
            if (TextUtils.isEmpty(hVar.G)) {
                return;
            }
            i(hVar.G, "");
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            File o = o(str);
            if (o == null || !o.exists()) {
                File r = r(c.a.f0.a.c.f.c(str));
                if (r.exists()) {
                    r.delete();
                }
                c.a.f0.d.a.a.b(new a(r, str, str2, o), "download splash resource");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (c.a.f0.b.g.f.f3404a == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0044, code lost:
        if (c.a.f0.b.g.f.f3404a == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
                            if (readLine != null) {
                                sb.append(readLine);
                            } else {
                                try {
                                    break;
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bufferedReader = bufferedReader2;
                            if (f3404a) {
                                e.printStackTrace();
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e4) {
                                    e = e4;
                                }
                            }
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e5) {
                                    if (f3404a) {
                                        e5.printStackTrace();
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e6) {
                e = e6;
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
            sb.append(c.a.f0.a.c.f.c(str));
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
    public static h l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            List<h> t = t(true);
            if (t == null || t.size() <= 0) {
                return null;
            }
            return t.get(0);
        }
        return (h) invokeV.objValue;
    }

    public static File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            File file = new File(c.a.f0.a.b.b.a().getFilesDir(), "splash");
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

    public static List<h> p() {
        InterceptResult invokeV;
        String j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (f3406c != null) {
                if (f3404a) {
                    String str = "from cache splashDataItemList:" + f3406c.size();
                }
                return f3406c;
            }
            f3406c = Collections.synchronizedList(new ArrayList());
            File n = n();
            if (n.exists() && (j2 = j(n)) != null) {
                if (f3404a) {
                    String str2 = "from local content:" + j2;
                }
                try {
                    JSONArray jSONArray = new JSONArray(j2);
                    if (f3404a) {
                        String str3 = "JSONArray" + jSONArray.length();
                    }
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        f3406c.add(h.b(jSONArray.optJSONObject(i2)));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (f3404a) {
                    String str4 = "from local splashDataItemList:" + f3406c.size();
                }
                return f3406c;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public static HashMap<String, h> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            HashMap<String, h> hashMap = new HashMap<>();
            File n = n();
            if (n.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(j(n));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        h b2 = h.b((JSONObject) jSONArray.get(i2));
                        hashMap.put(b2.f3415b, b2);
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

    public static List<h> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? t(false) : (List) invokeV.objValue;
    }

    public static List<h> t(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65556, null, z)) == null) {
            List<h> p = p();
            if (p != null && p.size() != 0) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                int i2 = 0;
                for (int i3 = 0; i3 < p.size(); i3++) {
                    h hVar = p.get(i3);
                    int f2 = f(hVar, z);
                    if (f2 == 0) {
                        arrayList.add(hVar);
                    } else {
                        i2 |= f2;
                        try {
                            jSONObject.put(hVar.f3416c, f2);
                        } catch (JSONException e2) {
                            if (f3404a) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    c.a.f0.b.g.b.g(i2, jSONObject.toString());
                    return null;
                }
                return arrayList;
            }
            c.a.f0.b.g.b.f(1);
            return null;
        }
        return (List) invokeZ.objValue;
    }

    public static boolean u(List<h> list, File file) {
        InterceptResult invokeLL;
        StringBuffer stringBuffer;
        int i2;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, list, file)) == null) {
            if (f3404a) {
                String str = "persistListToFile size:" + list.size();
            }
            int i3 = 0;
            if (list.size() <= 0) {
                return false;
            }
            FileWriter fileWriter2 = null;
            try {
                try {
                    h[] hVarArr = (h[]) list.toArray(new h[list.size() - 1]);
                    stringBuffer = new StringBuffer();
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT);
                    int length = hVarArr.length;
                    while (true) {
                        i2 = length - 1;
                        if (i3 >= i2) {
                            break;
                        }
                        stringBuffer.append(hVarArr[i3].k());
                        stringBuffer.append(",");
                        i3++;
                    }
                    stringBuffer.append(hVarArr[i2].k());
                    stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
                    if (f3404a) {
                        String str2 = "persistListToFile:" + stringBuffer.toString();
                    }
                    fileWriter = new FileWriter(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                fileWriter.write(stringBuffer.toString());
                try {
                    fileWriter.close();
                } catch (Exception e3) {
                    if (f3404a) {
                        e3.printStackTrace();
                    }
                }
                return true;
            } catch (IOException e4) {
                fileWriter2 = fileWriter;
                e = e4;
                if (f3404a) {
                    e.printStackTrace();
                }
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Exception e5) {
                        if (f3404a) {
                            e5.printStackTrace();
                        }
                    }
                }
                return true;
            } catch (Throwable th2) {
                fileWriter2 = fileWriter;
                th = th2;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Exception e6) {
                        if (f3404a) {
                            e6.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean v(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, file, file2)) == null) {
            if (file == null || file2 == null) {
                return false;
            }
            return file.renameTo(file2);
        }
        return invokeLL.booleanValue;
    }

    public static void w(List<h> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, list) == null) {
            c.a.f0.d.a.a.b(new c(list), "ScheduleDownloadSplashSourceThread");
        }
    }

    public static void x(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, hVar) == null) {
            ArrayList arrayList = new ArrayList();
            File n = n();
            List<h> p = p();
            if (p == null || p.size() == 0) {
                return;
            }
            if (f3404a) {
                String str = "updateSplashDataItem--->getSplashDataItemList:" + p.size();
            }
            for (int i2 = 0; i2 < p.size(); i2++) {
                h hVar2 = p.get(i2);
                if (TextUtils.equals(hVar.f3415b, hVar2.f3415b)) {
                    h.l(hVar2, hVar);
                    arrayList.add(hVar2);
                } else {
                    arrayList.add(hVar2);
                }
            }
            u(arrayList, n);
        }
    }

    public static void y(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, null, hVar) == null) || hVar.u < 1) {
            return;
        }
        int i2 = hVar.w;
        if (i2 < Integer.MAX_VALUE) {
            hVar.w = i2 + 1;
        }
        c.a.f0.d.a.a.b(new b(hVar), "updateSplashDataItemRate");
    }

    public static void z(List<h> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, null, list) == null) || list == null || list.size() == 0) {
            return;
        }
        f3406c = Collections.synchronizedList(list);
        u(list, n());
    }
}
