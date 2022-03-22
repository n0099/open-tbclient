package c.a.o0.r.j0;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f10593f;

    /* renamed from: g  reason: collision with root package name */
    public static ContentResolver f10594g;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f10595h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f10596b;

    /* renamed from: c  reason: collision with root package name */
    public String f10597c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f10598d;

    /* renamed from: e  reason: collision with root package name */
    public String f10599e;

    /* loaded from: classes2.dex */
    public class a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.e();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: c.a.o0.r.j0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0826b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f10600b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f10601c;

        public C0826b(b bVar, Uri uri, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, uri, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10601c = bVar;
            this.a = uri;
            this.f10600b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.f10601c.G(this.a, this.f10600b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f10602b;

        public c(b bVar, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10602b = bVar;
            this.a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.f10602b.g(this.a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10599e = null;
        this.f10598d = new ConcurrentHashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        f10595h = hashMap;
        hashMap.put(c.a.o0.r.j0.a.a, "settings");
        f10595h.put(c.a.o0.r.j0.a.f10586b, "remote_settings");
        f10595h.put(c.a.o0.r.j0.a.f10587c, "bdservice_settings");
        f10595h.put(c.a.o0.r.j0.a.f10588d, c.a.o0.r.j0.a.f10591g);
        f10595h.put(c.a.o0.r.j0.a.f10589e, c.a.o0.r.j0.a.f10592h);
        f10595h.put(c.a.o0.r.j0.a.f10590f, c.a.o0.r.j0.a.i);
        f10594g = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b k() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (b.class) {
                if (f10593f == null) {
                    f10593f = new b();
                }
                bVar = f10593f;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return str + "_" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeL.objValue;
    }

    public final void A(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            Uri parse = Uri.parse(i() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(j));
            F(parse, contentValues);
        }
    }

    public final void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            Uri parse = Uri.parse(i() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, str2);
            F(parse, contentValues);
        }
    }

    public final void C(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            Uri parse = Uri.parse(i() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(z));
            F(parse, contentValues);
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (c(str)) {
                E(str);
            } else if (this.f10598d.containsKey(str)) {
                this.f10598d.remove(str);
            } else {
                SharedPreferences p = p();
                this.f10596b = p;
                EditorHelper.remove(p, str);
            }
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            f(Uri.parse(i() + str));
        }
    }

    public void F(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, uri, contentValues) == null) {
            if (n.B()) {
                new C0826b(this, uri, contentValues).execute(new Void[0]);
            } else {
                G(uri, contentValues);
            }
        }
    }

    public final void G(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, uri, contentValues) == null) {
            try {
                f10594g.insert(uri, contentValues);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public void H() {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f10598d.isEmpty()) {
            return;
        }
        SharedPreferences p = p();
        this.f10596b = p;
        if (p == null || (edit = p.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f10598d.entrySet()) {
            if (entry != null) {
                String valueOf = String.valueOf(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(valueOf, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(valueOf, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(valueOf, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(valueOf, ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    edit.putFloat(valueOf, ((Float) value).floatValue());
                }
            }
        }
        edit.commit();
        this.f10598d.clear();
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (str != null && str.length() != 0) {
                int length = c.a.o0.r.j0.a.j.length;
                for (int i = 0; i < length; i++) {
                    if (str.equals(c.a.o0.r.j0.a.j[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SharedPreferences p = p();
            this.f10596b = p;
            SharedPreferences.Editor edit = p.edit();
            if (edit != null) {
                edit.clear();
                edit.commit();
            }
        }
    }

    public void e() {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f10598d.isEmpty()) {
            return;
        }
        SharedPreferences p = p();
        this.f10596b = p;
        if (p == null || (edit = p.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f10598d.entrySet()) {
            if (entry != null) {
                String valueOf = String.valueOf(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(valueOf, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(valueOf, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(valueOf, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(valueOf, ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    edit.putFloat(valueOf, ((Float) value).floatValue());
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
        this.f10598d.clear();
    }

    public void f(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, uri) == null) {
            if (n.B()) {
                new c(this, uri).execute(new Void[0]);
            } else {
                g(uri);
            }
        }
    }

    public final void g(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, uri) == null) {
            try {
                f10594g.delete(uri, null, null);
            } catch (SecurityException e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public boolean h(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, str, z)) == null) {
            if (c(str)) {
                String s = s(str);
                if (s == null) {
                    return z;
                }
                try {
                    return Boolean.parseBoolean(s);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return z;
                }
            }
            Object obj = this.f10598d.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            SharedPreferences p = p();
            this.f10596b = p;
            return p.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f10599e == null) {
                String packageName = AppRuntime.getAppContext().getPackageName();
                if ("com.baidu.tieba".equals(packageName)) {
                    this.f10599e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
                } else {
                    this.f10599e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
                }
            }
            return this.f10599e;
        }
        return (String) invokeV.objValue;
    }

    public ContentResolver j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? f10594g : (ContentResolver) invokeV.objValue;
    }

    public int l(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, str, i)) == null) {
            if (c(str)) {
                String s = s(str);
                if (s == null) {
                    return i;
                }
                try {
                    return Integer.parseInt(s);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return i;
                }
            }
            Object obj = this.f10598d.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            SharedPreferences p = p();
            this.f10596b = p;
            return p.getInt(str, i);
        }
        return invokeLI.intValue;
    }

    public long m(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048593, this, str, j)) == null) {
            if (c(str)) {
                String s = s(str);
                if (s == null) {
                    return j;
                }
                try {
                    return Long.parseLong(s);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return j;
                }
            }
            Object obj = this.f10598d.get(str);
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            SharedPreferences p = p();
            this.f10596b = p;
            try {
                return p.getLong(str, j);
            } catch (ClassCastException e3) {
                BdLog.e(e3);
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            String str = c.a.o0.r.j0.a.a;
            ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.getInst().getSystemService("activity");
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                int myPid = Process.myPid();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                    return str;
                }
                return str;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public synchronized SharedPreferences p() {
        InterceptResult invokeV;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this) {
                if (this.f10597c == null || this.f10597c.length() == 0) {
                    if (this.a == null || this.a.length() == 0) {
                        this.a = n();
                    }
                    if (f10595h.containsKey(this.a)) {
                        this.f10597c = f10595h.get(this.a);
                    } else {
                        this.f10597c = "settings";
                    }
                }
                sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences(this.f10597c, 0);
            }
            return sharedPreferences;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public String q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) {
            if (c(str)) {
                String s = s(str);
                return s != null ? s : str2;
            }
            Object obj = this.f10598d.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            SharedPreferences p = p();
            this.f10596b = p;
            return p.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public String r(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, uri)) == null) {
            try {
                return f10594g.getType(uri);
            } catch (SecurityException e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            return r(Uri.parse(i() + str));
        }
        return (String) invokeL.objValue;
    }

    public boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (c(str)) {
                return false;
            }
            return this.f10598d.containsKey(str) || p().contains(str);
        }
        return invokeL.booleanValue;
    }

    public void u(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048600, this, str, z) == null) {
            if (c(str)) {
                C(str, z);
            } else if (n.B()) {
                v(str, Boolean.valueOf(z));
            } else {
                SharedPreferences p = p();
                this.f10596b = p;
                SharedPreferences.Editor edit = p.edit();
                edit.putBoolean(str, z);
                edit.commit();
            }
        }
    }

    public final void v(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, str, obj) == null) || str == null || obj == null) {
            return;
        }
        this.f10598d.put(str, obj);
        Looper.myQueue().addIdleHandler(new a(this));
    }

    public void w(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i) == null) {
            if (c(str)) {
                z(str, i);
            } else if (n.B()) {
                v(str, Integer.valueOf(i));
            } else {
                SharedPreferences p = p();
                this.f10596b = p;
                SharedPreferences.Editor edit = p.edit();
                edit.putInt(str, i);
                edit.commit();
            }
        }
    }

    public void x(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048603, this, str, j) == null) {
            if (c(str)) {
                A(str, j);
            } else if (n.B()) {
                v(str, Long.valueOf(j));
            } else {
                SharedPreferences p = p();
                this.f10596b = p;
                SharedPreferences.Editor edit = p.edit();
                edit.putLong(str, j);
                edit.commit();
            }
        }
    }

    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, str2) == null) {
            if (c(str)) {
                B(str, str2);
            } else if (StringUtil.NULL_STRING.equals(str2)) {
                D(str);
            } else if (n.B()) {
                v(str, str2);
            } else {
                SharedPreferences p = p();
                this.f10596b = p;
                SharedPreferences.Editor edit = p.edit();
                edit.putString(str, str2);
                edit.commit();
            }
        }
    }

    public final void z(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048605, this, str, i) == null) {
            Uri parse = Uri.parse(i() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(i));
            F(parse, contentValues);
        }
    }
}
