package b.a.p0.a.k2.g;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
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
    public static final boolean f6441e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences$EditorC0275b f6442b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6443c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6444d;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(22204915, "Lb/a/p0/a/k2/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(22204915, "Lb/a/p0/a/k2/g/b;");
                return;
            }
        }
        f6441e = k.f6397a;
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
        this.f6442b = new SharedPreferences$EditorC0275b(this, null);
        this.f6444d = str;
        this.f6443c = ProcessUtils.isMainProcess() || b();
    }

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f6443c) {
                super.clear();
            } else {
                b.a.p0.a.v1.b.d.b(f.class, c.a(i(), 100, "", ""));
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

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6443c ? super.edit() : this.f6442b : (SharedPreferences.Editor) invokeV.objValue;
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

    @Override // b.a.p0.a.k2.g.g, b.a.p0.t.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k() ? super.getAll() : new HashMap(super.getAll()) : (Map) invokeV.objValue;
    }

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            try {
                if (this.f6443c) {
                    return e(str, z);
                }
                b.a.p0.a.v1.b.f b2 = b.a.p0.a.v1.b.d.b(e.class, c.a(i(), 3, str, String.valueOf(z)));
                if (f6441e) {
                    String str2 = "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f8485a.getBoolean("result_value");
                }
                return b2.f8485a.getBoolean("result_value");
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048583, this, str, f2)) == null) {
            if (this.f6443c) {
                return f(str, f2);
            }
            b.a.p0.a.v1.b.f b2 = b.a.p0.a.v1.b.d.b(e.class, c.a(i(), 5, str, String.valueOf(f2)));
            if (f6441e) {
                String str2 = "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f8485a.getFloat("result_value");
            }
            return b2.f8485a.getFloat("result_value");
        }
        return invokeLF.floatValue;
    }

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2)) == null) {
            if (this.f6443c) {
                return g(str, i2);
            }
            b.a.p0.a.v1.b.f b2 = b.a.p0.a.v1.b.d.b(e.class, c.a(i(), 1, str, String.valueOf(i2)));
            if (f6441e) {
                String str2 = "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f8485a.getInt("result_value");
            }
            return b2.f8485a.getInt("result_value");
        }
        return invokeLI.intValue;
    }

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j)) == null) {
            if (this.f6443c) {
                return h(str, j);
            }
            b.a.p0.a.v1.b.f b2 = b.a.p0.a.v1.b.d.b(e.class, c.a(i(), 2, str, String.valueOf(j)));
            if (f6441e) {
                String str2 = "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f8485a.getLong("result_value");
            }
            return b2.f8485a.getLong("result_value");
        }
        return invokeLJ.longValue;
    }

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            if (this.f6443c) {
                return j(str, str2);
            }
            b.a.p0.a.v1.b.f b2 = b.a.p0.a.v1.b.d.b(e.class, c.a(i(), 4, str, str2));
            if (f6441e) {
                String str3 = "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f8485a.getString("result_value");
            }
            return b2.f8485a.getString("result_value");
        }
        return (String) invokeLL.objValue;
    }

    public long h(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048587, this, str, j)) == null) ? super.getLong(str, j) : invokeLJ.longValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f6444d : (String) invokeV.objValue;
    }

    public String j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) ? super.getString(str, str2) : (String) invokeLL.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f6443c : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            if (this.f6443c) {
                super.putBoolean(str, z);
            } else {
                b.a.p0.a.v1.b.d.b(f.class, c.a(i(), 3, str, String.valueOf(z)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLZ.objValue;
    }

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048592, this, str, f2)) == null) {
            if (this.f6443c) {
                super.putFloat(str, f2);
            } else {
                b.a.p0.a.v1.b.d.b(f.class, c.a(i(), 5, str, String.valueOf(f2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLF.objValue;
    }

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i2)) == null) {
            if (this.f6443c) {
                super.putInt(str, i2);
            } else {
                b.a.p0.a.v1.b.d.b(f.class, c.a(i(), 1, str, String.valueOf(i2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLI.objValue;
    }

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048594, this, str, j)) == null) {
            if (this.f6443c) {
                super.edit().putLong(str, j).commit();
            } else {
                b.a.p0.a.v1.b.d.b(f.class, c.a(i(), 2, str, String.valueOf(j)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLJ.objValue;
    }

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, str2)) == null) {
            if (this.f6443c) {
                super.putString(str, str2);
            } else {
                b.a.p0.a.v1.b.d.b(f.class, c.a(i(), 4, str, str2));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // b.a.p0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (this.f6443c) {
                super.remove(str);
            } else {
                b.a.p0.a.v1.b.d.b(f.class, c.a(i(), 101, str, ""));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeL.objValue;
    }

    /* renamed from: b.a.p0.a.k2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class SharedPreferences$EditorC0275b implements SharedPreferences.Editor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Deque<Runnable> f6445a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f6446b;

        /* renamed from: b.a.p0.a.k2.g.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f6447e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f6448f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0275b f6449g;

            public a(SharedPreferences$EditorC0275b sharedPreferences$EditorC0275b, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0275b, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6449g = sharedPreferences$EditorC0275b;
                this.f6447e = str;
                this.f6448f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6449g.f6446b.putString(this.f6447e, this.f6448f);
                }
            }
        }

        /* renamed from: b.a.p0.a.k2.g.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0276b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f6450e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Set f6451f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0275b f6452g;

            public RunnableC0276b(SharedPreferences$EditorC0275b sharedPreferences$EditorC0275b, String str, Set set) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0275b, str, set};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6452g = sharedPreferences$EditorC0275b;
                this.f6450e = str;
                this.f6451f = set;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6452g.f6446b.putStringSet(this.f6450e, this.f6451f);
                }
            }
        }

        /* renamed from: b.a.p0.a.k2.g.b$b$c */
        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f6453e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f6454f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0275b f6455g;

            public c(SharedPreferences$EditorC0275b sharedPreferences$EditorC0275b, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0275b, str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6455g = sharedPreferences$EditorC0275b;
                this.f6453e = str;
                this.f6454f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6455g.f6446b.putInt(this.f6453e, this.f6454f);
                }
            }
        }

        /* renamed from: b.a.p0.a.k2.g.b$b$d */
        /* loaded from: classes.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f6456e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f6457f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0275b f6458g;

            public d(SharedPreferences$EditorC0275b sharedPreferences$EditorC0275b, String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0275b, str, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6458g = sharedPreferences$EditorC0275b;
                this.f6456e = str;
                this.f6457f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6458g.f6446b.putLong(this.f6456e, this.f6457f);
                }
            }
        }

        /* renamed from: b.a.p0.a.k2.g.b$b$e */
        /* loaded from: classes.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f6459e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f6460f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0275b f6461g;

            public e(SharedPreferences$EditorC0275b sharedPreferences$EditorC0275b, String str, float f2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0275b, str, Float.valueOf(f2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6461g = sharedPreferences$EditorC0275b;
                this.f6459e = str;
                this.f6460f = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6461g.f6446b.putFloat(this.f6459e, this.f6460f);
                }
            }
        }

        /* renamed from: b.a.p0.a.k2.g.b$b$f */
        /* loaded from: classes.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f6462e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f6463f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0275b f6464g;

            public f(SharedPreferences$EditorC0275b sharedPreferences$EditorC0275b, String str, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0275b, str, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6464g = sharedPreferences$EditorC0275b;
                this.f6462e = str;
                this.f6463f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6464g.f6446b.putBoolean(this.f6462e, this.f6463f);
                }
            }
        }

        /* renamed from: b.a.p0.a.k2.g.b$b$g */
        /* loaded from: classes.dex */
        public class g implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f6465e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0275b f6466f;

            public g(SharedPreferences$EditorC0275b sharedPreferences$EditorC0275b, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0275b, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6466f = sharedPreferences$EditorC0275b;
                this.f6465e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6466f.f6446b.remove(this.f6465e);
                }
            }
        }

        /* renamed from: b.a.p0.a.k2.g.b$b$h */
        /* loaded from: classes.dex */
        public class h implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0275b f6467e;

            public h(SharedPreferences$EditorC0275b sharedPreferences$EditorC0275b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0275b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6467e = sharedPreferences$EditorC0275b;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6467e.f6446b.clear();
                }
            }
        }

        public SharedPreferences$EditorC0275b(b bVar) {
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
            this.f6446b = bVar;
            this.f6445a = new ArrayDeque();
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
                synchronized (this.f6445a) {
                    while (!this.f6445a.isEmpty()) {
                        Runnable poll = this.f6445a.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final SharedPreferences$EditorC0275b e(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, runnable)) == null) {
                synchronized (this.f6445a) {
                    this.f6445a.offer(runnable);
                }
                return this;
            }
            return (SharedPreferences$EditorC0275b) invokeL.objValue;
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
        public SharedPreferences.Editor putLong(String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j)) == null) {
                e(new d(this, str, j));
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
                e(new RunnableC0276b(this, str, set));
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

        public /* synthetic */ SharedPreferences$EditorC0275b(b bVar, a aVar) {
            this(bVar);
        }
    }
}
