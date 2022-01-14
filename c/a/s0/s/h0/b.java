package c.a.s0.s.h0;

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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f13046f;

    /* renamed from: g  reason: collision with root package name */
    public static ContentResolver f13047g;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f13048h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f13049b;

    /* renamed from: c  reason: collision with root package name */
    public String f13050c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f13051d;

    /* renamed from: e  reason: collision with root package name */
    public String f13052e;

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* renamed from: c.a.s0.s.h0.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0867b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f13053b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f13054c;

        public C0867b(b bVar, Uri uri, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, uri, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13054c = bVar;
            this.a = uri;
            this.f13053b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.f13054c.G(this.a, this.f13053b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f13055b;

        public c(b bVar, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13055b = bVar;
            this.a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.f13055b.g(this.a);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13052e = null;
        this.f13051d = new ConcurrentHashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        f13048h = hashMap;
        hashMap.put(c.a.s0.s.h0.a.a, "settings");
        f13048h.put(c.a.s0.s.h0.a.f13037b, "remote_settings");
        f13048h.put(c.a.s0.s.h0.a.f13038c, "bdservice_settings");
        f13048h.put(c.a.s0.s.h0.a.f13039d, c.a.s0.s.h0.a.f13042g);
        f13048h.put(c.a.s0.s.h0.a.f13040e, c.a.s0.s.h0.a.f13043h);
        f13048h.put(c.a.s0.s.h0.a.f13041f, c.a.s0.s.h0.a.f13044i);
        f13047g = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b k() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (b.class) {
                if (f13046f == null) {
                    f13046f = new b();
                }
                bVar = f13046f;
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

    public final void A(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            Uri parse = Uri.parse(i() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(j2));
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
            } else if (this.f13051d.containsKey(str)) {
                this.f13051d.remove(str);
            } else {
                SharedPreferences p = p();
                this.f13049b = p;
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
                new C0867b(this, uri, contentValues).execute(new Void[0]);
            } else {
                G(uri, contentValues);
            }
        }
    }

    public final void G(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, uri, contentValues) == null) {
            try {
                f13047g.insert(uri, contentValues);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public void H() {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f13051d.isEmpty()) {
            return;
        }
        SharedPreferences p = p();
        this.f13049b = p;
        if (p == null || (edit = p.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f13051d.entrySet()) {
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
        this.f13051d.clear();
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (str != null && str.length() != 0) {
                int length = c.a.s0.s.h0.a.f13045j.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (str.equals(c.a.s0.s.h0.a.f13045j[i2])) {
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
            this.f13049b = p;
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
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f13051d.isEmpty()) {
            return;
        }
        SharedPreferences p = p();
        this.f13049b = p;
        if (p == null || (edit = p.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f13051d.entrySet()) {
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
        this.f13051d.clear();
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
                f13047g.delete(uri, null, null);
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
            Object obj = this.f13051d.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            SharedPreferences p = p();
            this.f13049b = p;
            return p.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f13052e == null) {
                String packageName = AppRuntime.getAppContext().getPackageName();
                if ("com.baidu.tieba".equals(packageName)) {
                    this.f13052e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
                } else {
                    this.f13052e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
                }
            }
            return this.f13052e;
        }
        return (String) invokeV.objValue;
    }

    public ContentResolver j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? f13047g : (ContentResolver) invokeV.objValue;
    }

    public int l(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, str, i2)) == null) {
            if (c(str)) {
                String s = s(str);
                if (s == null) {
                    return i2;
                }
                try {
                    return Integer.parseInt(s);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return i2;
                }
            }
            Object obj = this.f13051d.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            SharedPreferences p = p();
            this.f13049b = p;
            return p.getInt(str, i2);
        }
        return invokeLI.intValue;
    }

    public long m(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048593, this, str, j2)) == null) {
            if (c(str)) {
                String s = s(str);
                if (s == null) {
                    return j2;
                }
                try {
                    return Long.parseLong(s);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return j2;
                }
            }
            Object obj = this.f13051d.get(str);
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            SharedPreferences p = p();
            this.f13049b = p;
            try {
                return p.getLong(str, j2);
            } catch (ClassCastException e3) {
                BdLog.e(e3);
                return j2;
            }
        }
        return invokeLJ.longValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            String str = c.a.s0.s.h0.a.a;
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
                if (this.f13050c == null || this.f13050c.length() == 0) {
                    if (this.a == null || this.a.length() == 0) {
                        this.a = n();
                    }
                    if (f13048h.containsKey(this.a)) {
                        this.f13050c = f13048h.get(this.a);
                    } else {
                        this.f13050c = "settings";
                    }
                }
                sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences(this.f13050c, 0);
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
            Object obj = this.f13051d.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            SharedPreferences p = p();
            this.f13049b = p;
            return p.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public String r(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, uri)) == null) {
            try {
                return f13047g.getType(uri);
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
            return this.f13051d.containsKey(str) || p().contains(str);
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
                this.f13049b = p;
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
        this.f13051d.put(str, obj);
        Looper.myQueue().addIdleHandler(new a(this));
    }

    public void w(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i2) == null) {
            if (c(str)) {
                z(str, i2);
            } else if (n.B()) {
                v(str, Integer.valueOf(i2));
            } else {
                SharedPreferences p = p();
                this.f13049b = p;
                SharedPreferences.Editor edit = p.edit();
                edit.putInt(str, i2);
                edit.commit();
            }
        }
    }

    public void x(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048603, this, str, j2) == null) {
            if (c(str)) {
                A(str, j2);
            } else if (n.B()) {
                v(str, Long.valueOf(j2));
            } else {
                SharedPreferences p = p();
                this.f13049b = p;
                SharedPreferences.Editor edit = p.edit();
                edit.putLong(str, j2);
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
                this.f13049b = p;
                SharedPreferences.Editor edit = p.edit();
                edit.putString(str, str2);
                edit.commit();
            }
        }
    }

    public final void z(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048605, this, str, i2) == null) {
            Uri parse = Uri.parse(i() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(i2));
            F(parse, contentValues);
        }
    }
}
