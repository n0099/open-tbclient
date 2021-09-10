package c.a.q0.s.d0;

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
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f13785f;

    /* renamed from: g  reason: collision with root package name */
    public static ContentResolver f13786g;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f13787h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13788a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f13789b;

    /* renamed from: c  reason: collision with root package name */
    public String f13790c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f13791d;

    /* renamed from: e  reason: collision with root package name */
    public String f13792e;

    /* loaded from: classes3.dex */
    public class a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f13793a;

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
            this.f13793a = bVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f13793a.d();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: c.a.q0.s.d0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0679b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f13794a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f13795b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f13796c;

        public C0679b(b bVar, Uri uri, ContentValues contentValues) {
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
            this.f13796c = bVar;
            this.f13794a = uri;
            this.f13795b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.f13796c.F(this.f13794a, this.f13795b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f13797a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f13798b;

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
            this.f13798b = bVar;
            this.f13797a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.f13798b.f(this.f13797a);
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
        this.f13792e = null;
        this.f13791d = new ConcurrentHashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        f13787h = hashMap;
        hashMap.put(c.a.q0.s.d0.a.f13775a, "settings");
        f13787h.put(c.a.q0.s.d0.a.f13776b, "remote_settings");
        f13787h.put(c.a.q0.s.d0.a.f13777c, "bdservice_settings");
        f13787h.put(c.a.q0.s.d0.a.f13778d, c.a.q0.s.d0.a.f13781g);
        f13787h.put(c.a.q0.s.d0.a.f13779e, c.a.q0.s.d0.a.f13782h);
        f13787h.put(c.a.q0.s.d0.a.f13780f, c.a.q0.s.d0.a.f13783i);
        f13786g = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b j() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (b.class) {
                if (f13785f == null) {
                    f13785f = new b();
                }
                bVar = f13785f;
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
            } else if (this.f13791d.containsKey(str)) {
                this.f13791d.remove(str);
            } else {
                SharedPreferences o = o();
                this.f13789b = o;
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
                new C0679b(this, uri, contentValues).execute(new Void[0]);
            } else {
                F(uri, contentValues);
            }
        }
    }

    public final void F(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, uri, contentValues) == null) {
            try {
                f13786g.insert(uri, contentValues);
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
                int length = c.a.q0.s.d0.a.f13784j.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (str.equals(c.a.q0.s.d0.a.f13784j[i2])) {
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f13791d.isEmpty()) {
            return;
        }
        SharedPreferences o = o();
        this.f13789b = o;
        if (o == null || (edit = o.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f13791d.entrySet()) {
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
        this.f13791d.clear();
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
                f13786g.delete(uri, null, null);
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
            Object obj = this.f13791d.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            SharedPreferences o = o();
            this.f13789b = o;
            return o.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f13792e == null) {
                String packageName = AppRuntime.getAppContext().getPackageName();
                if ("com.baidu.tieba".equals(packageName)) {
                    this.f13792e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
                } else {
                    this.f13792e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
                }
            }
            return this.f13792e;
        }
        return (String) invokeV.objValue;
    }

    public ContentResolver i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? f13786g : (ContentResolver) invokeV.objValue;
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
            Object obj = this.f13791d.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            SharedPreferences o = o();
            this.f13789b = o;
            return o.getInt(str, i2);
        }
        return invokeLI.intValue;
    }

    public long l(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048590, this, str, j2)) == null) {
            if (c(str)) {
                String r = r(str);
                if (r == null) {
                    return j2;
                }
                try {
                    return Long.parseLong(r);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return j2;
                }
            }
            Object obj = this.f13791d.get(str);
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            SharedPreferences o = o();
            this.f13789b = o;
            try {
                return o.getLong(str, j2);
            } catch (ClassCastException e3) {
                BdLog.e(e3);
                return j2;
            }
        }
        return invokeLJ.longValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            String str = c.a.q0.s.d0.a.f13775a;
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
                if (this.f13790c == null || this.f13790c.length() == 0) {
                    if (this.f13788a == null || this.f13788a.length() == 0) {
                        this.f13788a = m();
                    }
                    if (f13787h.containsKey(this.f13788a)) {
                        this.f13790c = f13787h.get(this.f13788a);
                    } else {
                        this.f13790c = "settings";
                    }
                }
                sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences(this.f13790c, 4);
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
            Object obj = this.f13791d.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            SharedPreferences o = o();
            this.f13789b = o;
            return o.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public String q(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, uri)) == null) {
            try {
                return f13786g.getType(uri);
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
            return this.f13791d.containsKey(str) || o().contains(str);
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
                this.f13789b = o;
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
        this.f13791d.put(str, obj);
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
                this.f13789b = o;
                SharedPreferences.Editor edit = o.edit();
                edit.putInt(str, i2);
                edit.commit();
            }
        }
    }

    public void w(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, str, j2) == null) {
            if (c(str)) {
                z(str, j2);
            } else if (l.C()) {
                u(str, Long.valueOf(j2));
            } else {
                SharedPreferences o = o();
                this.f13789b = o;
                SharedPreferences.Editor edit = o.edit();
                edit.putLong(str, j2);
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
                this.f13789b = o;
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

    public final void z(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048603, this, str, j2) == null) {
            Uri parse = Uri.parse(h() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(j2));
            E(parse, contentValues);
        }
    }
}
