package b.a.q0.s.e0;

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
import b.a.e.f.p.l;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f13708f;

    /* renamed from: g  reason: collision with root package name */
    public static ContentResolver f13709g;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f13710h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13711a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f13712b;

    /* renamed from: c  reason: collision with root package name */
    public String f13713c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f13714d;

    /* renamed from: e  reason: collision with root package name */
    public String f13715e;

    /* loaded from: classes4.dex */
    public class a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f13716a;

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
            this.f13716a = bVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f13716a.d();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: b.a.q0.s.e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0710b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f13717a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f13718b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f13719c;

        public C0710b(b bVar, Uri uri, ContentValues contentValues) {
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
            this.f13719c = bVar;
            this.f13717a = uri;
            this.f13718b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.f13719c.F(this.f13717a, this.f13718b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f13720a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f13721b;

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
            this.f13721b = bVar;
            this.f13720a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.f13721b.f(this.f13720a);
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
        this.f13715e = null;
        this.f13714d = new ConcurrentHashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        f13710h = hashMap;
        hashMap.put(b.a.q0.s.e0.a.f13699a, "settings");
        f13710h.put(b.a.q0.s.e0.a.f13700b, "remote_settings");
        f13710h.put(b.a.q0.s.e0.a.f13701c, "bdservice_settings");
        f13710h.put(b.a.q0.s.e0.a.f13702d, b.a.q0.s.e0.a.f13705g);
        f13710h.put(b.a.q0.s.e0.a.f13703e, b.a.q0.s.e0.a.f13706h);
        f13710h.put(b.a.q0.s.e0.a.f13704f, b.a.q0.s.e0.a.f13707i);
        f13709g = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b j() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (b.class) {
                if (f13708f == null) {
                    f13708f = new b();
                }
                bVar = f13708f;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return str + "_" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeL.objValue;
    }

    public final void A(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            Uri parse = Uri.parse(h() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, str2);
            E(parse, contentValues);
        }
    }

    public final void B(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            Uri parse = Uri.parse(h() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(z));
            E(parse, contentValues);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (c(str)) {
                D(str);
            } else if (this.f13714d.containsKey(str)) {
                this.f13714d.remove(str);
            } else {
                SharedPreferences o = o();
                this.f13712b = o;
                EditorHelper.remove(o, str);
            }
        }
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            e(Uri.parse(h() + str));
        }
    }

    public void E(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, uri, contentValues) == null) {
            if (l.C()) {
                new C0710b(this, uri, contentValues).execute(new Void[0]);
            } else {
                F(uri, contentValues);
            }
        }
    }

    public final void F(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, uri, contentValues) == null) {
            try {
                f13709g.insert(uri, contentValues);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str != null && str.length() != 0) {
                int length = b.a.q0.s.e0.a.j.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (str.equals(b.a.q0.s.e0.a.j[i2])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f13714d.isEmpty()) {
            return;
        }
        SharedPreferences o = o();
        this.f13712b = o;
        if (o == null || (edit = o.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f13714d.entrySet()) {
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
        this.f13714d.clear();
    }

    public void e(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri) == null) {
            if (l.C()) {
                new c(this, uri).execute(new Void[0]);
            } else {
                f(uri);
            }
        }
    }

    public final void f(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, uri) == null) {
            try {
                f13709g.delete(uri, null, null);
            } catch (SecurityException e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public boolean g(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            if (c(str)) {
                String r = r(str);
                if (r == null) {
                    return z;
                }
                try {
                    return Boolean.parseBoolean(r);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return z;
                }
            }
            Object obj = this.f13714d.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            SharedPreferences o = o();
            this.f13712b = o;
            return o.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f13715e == null) {
                String packageName = AppRuntime.getAppContext().getPackageName();
                if ("com.baidu.tieba".equals(packageName)) {
                    this.f13715e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
                } else {
                    this.f13715e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
                }
            }
            return this.f13715e;
        }
        return (String) invokeV.objValue;
    }

    public ContentResolver i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? f13709g : (ContentResolver) invokeV.objValue;
    }

    public int k(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i2)) == null) {
            if (c(str)) {
                String r = r(str);
                if (r == null) {
                    return i2;
                }
                try {
                    return Integer.parseInt(r);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return i2;
                }
            }
            Object obj = this.f13714d.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            SharedPreferences o = o();
            this.f13712b = o;
            return o.getInt(str, i2);
        }
        return invokeLI.intValue;
    }

    public long l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048590, this, str, j)) == null) {
            if (c(str)) {
                String r = r(str);
                if (r == null) {
                    return j;
                }
                try {
                    return Long.parseLong(r);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return j;
                }
            }
            Object obj = this.f13714d.get(str);
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            SharedPreferences o = o();
            this.f13712b = o;
            try {
                return o.getLong(str, j);
            } catch (ClassCastException e3) {
                BdLog.e(e3);
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            String str = b.a.q0.s.e0.a.f13699a;
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

    public synchronized SharedPreferences o() {
        InterceptResult invokeV;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this) {
                if (this.f13713c == null || this.f13713c.length() == 0) {
                    if (this.f13711a == null || this.f13711a.length() == 0) {
                        this.f13711a = m();
                    }
                    if (f13710h.containsKey(this.f13711a)) {
                        this.f13713c = f13710h.get(this.f13711a);
                    } else {
                        this.f13713c = "settings";
                    }
                }
                sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences(this.f13713c, 0);
            }
            return sharedPreferences;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public String p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c(str)) {
                String r = r(str);
                return r != null ? r : str2;
            }
            Object obj = this.f13714d.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            SharedPreferences o = o();
            this.f13712b = o;
            return o.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public String q(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, uri)) == null) {
            try {
                return f13709g.getType(uri);
            } catch (SecurityException e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            return q(Uri.parse(h() + str));
        }
        return (String) invokeL.objValue;
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (c(str)) {
                return false;
            }
            return this.f13714d.containsKey(str) || o().contains(str);
        }
        return invokeL.booleanValue;
    }

    public void t(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, str, z) == null) {
            if (c(str)) {
                B(str, z);
            } else if (l.C()) {
                u(str, Boolean.valueOf(z));
            } else {
                SharedPreferences o = o();
                this.f13712b = o;
                SharedPreferences.Editor edit = o.edit();
                edit.putBoolean(str, z);
                edit.commit();
            }
        }
    }

    public final void u(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, str, obj) == null) || str == null || obj == null) {
            return;
        }
        this.f13714d.put(str, obj);
        Looper.myQueue().addIdleHandler(new a(this));
    }

    public void v(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, str, i2) == null) {
            if (c(str)) {
                y(str, i2);
            } else if (l.C()) {
                u(str, Integer.valueOf(i2));
            } else {
                SharedPreferences o = o();
                this.f13712b = o;
                SharedPreferences.Editor edit = o.edit();
                edit.putInt(str, i2);
                edit.commit();
            }
        }
    }

    public void w(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, str, j) == null) {
            if (c(str)) {
                z(str, j);
            } else if (l.C()) {
                u(str, Long.valueOf(j));
            } else {
                SharedPreferences o = o();
                this.f13712b = o;
                SharedPreferences.Editor edit = o.edit();
                edit.putLong(str, j);
                edit.commit();
            }
        }
    }

    public void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            if (c(str)) {
                A(str, str2);
            } else if (StringUtil.NULL_STRING.equals(str2)) {
                C(str);
            } else if (l.C()) {
                u(str, str2);
            } else {
                SharedPreferences o = o();
                this.f13712b = o;
                SharedPreferences.Editor edit = o.edit();
                edit.putString(str, str2);
                edit.commit();
            }
        }
    }

    public final void y(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i2) == null) {
            Uri parse = Uri.parse(h() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(i2));
            E(parse, contentValues);
        }
    }

    public final void z(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048603, this, str, j) == null) {
            Uri parse = Uri.parse(h() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(j));
            E(parse, contentValues);
        }
    }
}
