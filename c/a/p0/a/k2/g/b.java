package c.a.p0.a.k2.g;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f7129e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences$EditorC0280b f7130b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f7131c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7132d;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-488329262, "Lc/a/p0/a/k2/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-488329262, "Lc/a/p0/a/k2/g/b;");
                return;
            }
        }
        f7129e = k.f7085a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7130b = new SharedPreferences$EditorC0280b(this, null);
        this.f7132d = str;
        this.f7131c = ProcessUtils.isMainProcess() || b();
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f7131c) {
                super.clear();
            } else {
                c.a.p0.a.v1.b.d.b(f.class, c.a(i(), 100, "", ""));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    public boolean e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) ? super.getBoolean(str, z) : invokeLZ.booleanValue;
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7131c ? super.edit() : this.f7130b : (SharedPreferences.Editor) invokeV.objValue;
    }

    public float f(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048579, this, str, f2)) == null) ? super.getFloat(str, f2) : invokeLF.floatValue;
    }

    public int g(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) ? super.getInt(str, i2) : invokeLI.intValue;
    }

    @Override // c.a.p0.a.k2.g.g, c.a.p0.t.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k() ? super.getAll() : new HashMap(super.getAll()) : (Map) invokeV.objValue;
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            try {
                if (this.f7131c) {
                    return e(str, z);
                }
                c.a.p0.a.v1.b.f b2 = c.a.p0.a.v1.b.d.b(e.class, c.a(i(), 3, str, String.valueOf(z)));
                if (f7129e) {
                    String str2 = "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f9237a.getBoolean("result_value");
                }
                return b2.f9237a.getBoolean("result_value");
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048583, this, str, f2)) == null) {
            if (this.f7131c) {
                return f(str, f2);
            }
            c.a.p0.a.v1.b.f b2 = c.a.p0.a.v1.b.d.b(e.class, c.a(i(), 5, str, String.valueOf(f2)));
            if (f7129e) {
                String str2 = "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f9237a.getFloat("result_value");
            }
            return b2.f9237a.getFloat("result_value");
        }
        return invokeLF.floatValue;
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2)) == null) {
            if (this.f7131c) {
                return g(str, i2);
            }
            c.a.p0.a.v1.b.f b2 = c.a.p0.a.v1.b.d.b(e.class, c.a(i(), 1, str, String.valueOf(i2)));
            if (f7129e) {
                String str2 = "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f9237a.getInt("result_value");
            }
            return b2.f9237a.getInt("result_value");
        }
        return invokeLI.intValue;
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j2)) == null) {
            if (this.f7131c) {
                return h(str, j2);
            }
            c.a.p0.a.v1.b.f b2 = c.a.p0.a.v1.b.d.b(e.class, c.a(i(), 2, str, String.valueOf(j2)));
            if (f7129e) {
                String str2 = "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f9237a.getLong("result_value");
            }
            return b2.f9237a.getLong("result_value");
        }
        return invokeLJ.longValue;
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            if (this.f7131c) {
                return j(str, str2);
            }
            c.a.p0.a.v1.b.f b2 = c.a.p0.a.v1.b.d.b(e.class, c.a(i(), 4, str, str2));
            if (f7129e) {
                String str3 = "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f9237a.getString("result_value");
            }
            return b2.f9237a.getString("result_value");
        }
        return (String) invokeLL.objValue;
    }

    public long h(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048587, this, str, j2)) == null) ? super.getLong(str, j2) : invokeLJ.longValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f7132d : (String) invokeV.objValue;
    }

    public String j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) ? super.getString(str, str2) : (String) invokeLL.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f7131c : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            if (this.f7131c) {
                super.putBoolean(str, z);
            } else {
                c.a.p0.a.v1.b.d.b(f.class, c.a(i(), 3, str, String.valueOf(z)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLZ.objValue;
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048592, this, str, f2)) == null) {
            if (this.f7131c) {
                super.putFloat(str, f2);
            } else {
                c.a.p0.a.v1.b.d.b(f.class, c.a(i(), 5, str, String.valueOf(f2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLF.objValue;
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i2)) == null) {
            if (this.f7131c) {
                super.putInt(str, i2);
            } else {
                c.a.p0.a.v1.b.d.b(f.class, c.a(i(), 1, str, String.valueOf(i2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLI.objValue;
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048594, this, str, j2)) == null) {
            if (this.f7131c) {
                super.edit().putLong(str, j2).commit();
            } else {
                c.a.p0.a.v1.b.d.b(f.class, c.a(i(), 2, str, String.valueOf(j2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLJ.objValue;
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, str2)) == null) {
            if (this.f7131c) {
                super.putString(str, str2);
            } else {
                c.a.p0.a.v1.b.d.b(f.class, c.a(i(), 4, str, str2));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // c.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (this.f7131c) {
                super.remove(str);
            } else {
                c.a.p0.a.v1.b.d.b(f.class, c.a(i(), 101, str, ""));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeL.objValue;
    }

    /* renamed from: c.a.p0.a.k2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class SharedPreferences$EditorC0280b implements SharedPreferences.Editor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Deque<Runnable> f7133a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f7134b;

        /* renamed from: c.a.p0.a.k2.g.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7135e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f7136f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0280b f7137g;

            public a(SharedPreferences$EditorC0280b sharedPreferences$EditorC0280b, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0280b, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7137g = sharedPreferences$EditorC0280b;
                this.f7135e = str;
                this.f7136f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7137g.f7134b.putString(this.f7135e, this.f7136f);
                }
            }
        }

        /* renamed from: c.a.p0.a.k2.g.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0281b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7138e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Set f7139f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0280b f7140g;

            public RunnableC0281b(SharedPreferences$EditorC0280b sharedPreferences$EditorC0280b, String str, Set set) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0280b, str, set};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7140g = sharedPreferences$EditorC0280b;
                this.f7138e = str;
                this.f7139f = set;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7140g.f7134b.putStringSet(this.f7138e, this.f7139f);
                }
            }
        }

        /* renamed from: c.a.p0.a.k2.g.b$b$c */
        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7141e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f7142f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0280b f7143g;

            public c(SharedPreferences$EditorC0280b sharedPreferences$EditorC0280b, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0280b, str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7143g = sharedPreferences$EditorC0280b;
                this.f7141e = str;
                this.f7142f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7143g.f7134b.putInt(this.f7141e, this.f7142f);
                }
            }
        }

        /* renamed from: c.a.p0.a.k2.g.b$b$d */
        /* loaded from: classes.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7144e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f7145f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0280b f7146g;

            public d(SharedPreferences$EditorC0280b sharedPreferences$EditorC0280b, String str, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0280b, str, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7146g = sharedPreferences$EditorC0280b;
                this.f7144e = str;
                this.f7145f = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7146g.f7134b.putLong(this.f7144e, this.f7145f);
                }
            }
        }

        /* renamed from: c.a.p0.a.k2.g.b$b$e */
        /* loaded from: classes.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7147e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f7148f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0280b f7149g;

            public e(SharedPreferences$EditorC0280b sharedPreferences$EditorC0280b, String str, float f2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0280b, str, Float.valueOf(f2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7149g = sharedPreferences$EditorC0280b;
                this.f7147e = str;
                this.f7148f = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7149g.f7134b.putFloat(this.f7147e, this.f7148f);
                }
            }
        }

        /* renamed from: c.a.p0.a.k2.g.b$b$f */
        /* loaded from: classes.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7150e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f7151f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0280b f7152g;

            public f(SharedPreferences$EditorC0280b sharedPreferences$EditorC0280b, String str, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0280b, str, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7152g = sharedPreferences$EditorC0280b;
                this.f7150e = str;
                this.f7151f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7152g.f7134b.putBoolean(this.f7150e, this.f7151f);
                }
            }
        }

        /* renamed from: c.a.p0.a.k2.g.b$b$g */
        /* loaded from: classes.dex */
        public class g implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7153e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0280b f7154f;

            public g(SharedPreferences$EditorC0280b sharedPreferences$EditorC0280b, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0280b, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7154f = sharedPreferences$EditorC0280b;
                this.f7153e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7154f.f7134b.remove(this.f7153e);
                }
            }
        }

        /* renamed from: c.a.p0.a.k2.g.b$b$h */
        /* loaded from: classes.dex */
        public class h implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0280b f7155e;

            public h(SharedPreferences$EditorC0280b sharedPreferences$EditorC0280b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0280b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7155e = sharedPreferences$EditorC0280b;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7155e.f7134b.clear();
                }
            }
        }

        public SharedPreferences$EditorC0280b(b bVar) {
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
            this.f7134b = bVar;
            this.f7133a = new ArrayDeque();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                commit();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e(new h(this));
                return this;
            }
            return (SharedPreferences.Editor) invokeV.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.f7133a) {
                    while (!this.f7133a.isEmpty()) {
                        Runnable poll = this.f7133a.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final SharedPreferences$EditorC0280b e(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, runnable)) == null) {
                synchronized (this.f7133a) {
                    this.f7133a.offer(runnable);
                }
                return this;
            }
            return (SharedPreferences$EditorC0280b) invokeL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
                e(new f(this, str, z));
                return this;
            }
            return (SharedPreferences.Editor) invokeLZ.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(1048581, this, str, f2)) == null) {
                e(new e(this, str, f2));
                return this;
            }
            return (SharedPreferences.Editor) invokeLF.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) {
                e(new c(this, str, i2));
                return this;
            }
            return (SharedPreferences.Editor) invokeLI.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j2) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j2)) == null) {
                e(new d(this, str, j2));
                return this;
            }
            return (SharedPreferences.Editor) invokeLJ.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
                e(new a(this, str, str2));
                return this;
            }
            return (SharedPreferences.Editor) invokeLL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, set)) == null) {
                e(new RunnableC0281b(this, str, set));
                return this;
            }
            return (SharedPreferences.Editor) invokeLL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                e(new g(this, str));
                return this;
            }
            return (SharedPreferences.Editor) invokeL.objValue;
        }

        public /* synthetic */ SharedPreferences$EditorC0280b(b bVar, a aVar) {
            this(bVar);
        }
    }
}
