package c.a.o0.a.k2.g;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
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
    public static final boolean f7093e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences$EditorC0278b f7094b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f7095c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7096d;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-617411981, "Lc/a/o0/a/k2/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-617411981, "Lc/a/o0/a/k2/g/b;");
                return;
            }
        }
        f7093e = k.f7049a;
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
        this.f7094b = new SharedPreferences$EditorC0278b(this, null);
        this.f7096d = str;
        this.f7095c = ProcessUtils.isMainProcess() || b();
    }

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f7095c) {
                super.clear();
            } else {
                c.a.o0.a.v1.b.d.b(f.class, c.a(i(), 100, "", ""));
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

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7095c ? super.edit() : this.f7094b : (SharedPreferences.Editor) invokeV.objValue;
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

    @Override // c.a.o0.a.k2.g.g, c.a.o0.t.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k() ? super.getAll() : new HashMap(super.getAll()) : (Map) invokeV.objValue;
    }

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            try {
                if (this.f7095c) {
                    return e(str, z);
                }
                c.a.o0.a.v1.b.f b2 = c.a.o0.a.v1.b.d.b(e.class, c.a(i(), 3, str, String.valueOf(z)));
                if (f7093e) {
                    String str2 = "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f9201a.getBoolean("result_value");
                }
                return b2.f9201a.getBoolean("result_value");
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048583, this, str, f2)) == null) {
            if (this.f7095c) {
                return f(str, f2);
            }
            c.a.o0.a.v1.b.f b2 = c.a.o0.a.v1.b.d.b(e.class, c.a(i(), 5, str, String.valueOf(f2)));
            if (f7093e) {
                String str2 = "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f9201a.getFloat("result_value");
            }
            return b2.f9201a.getFloat("result_value");
        }
        return invokeLF.floatValue;
    }

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2)) == null) {
            if (this.f7095c) {
                return g(str, i2);
            }
            c.a.o0.a.v1.b.f b2 = c.a.o0.a.v1.b.d.b(e.class, c.a(i(), 1, str, String.valueOf(i2)));
            if (f7093e) {
                String str2 = "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f9201a.getInt("result_value");
            }
            return b2.f9201a.getInt("result_value");
        }
        return invokeLI.intValue;
    }

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j2)) == null) {
            if (this.f7095c) {
                return h(str, j2);
            }
            c.a.o0.a.v1.b.f b2 = c.a.o0.a.v1.b.d.b(e.class, c.a(i(), 2, str, String.valueOf(j2)));
            if (f7093e) {
                String str2 = "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f9201a.getLong("result_value");
            }
            return b2.f9201a.getLong("result_value");
        }
        return invokeLJ.longValue;
    }

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            if (this.f7095c) {
                return j(str, str2);
            }
            c.a.o0.a.v1.b.f b2 = c.a.o0.a.v1.b.d.b(e.class, c.a(i(), 4, str, str2));
            if (f7093e) {
                String str3 = "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f9201a.getString("result_value");
            }
            return b2.f9201a.getString("result_value");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f7096d : (String) invokeV.objValue;
    }

    public String j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) ? super.getString(str, str2) : (String) invokeLL.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f7095c : invokeV.booleanValue;
    }

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            if (this.f7095c) {
                super.putBoolean(str, z);
            } else {
                c.a.o0.a.v1.b.d.b(f.class, c.a(i(), 3, str, String.valueOf(z)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLZ.objValue;
    }

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048592, this, str, f2)) == null) {
            if (this.f7095c) {
                super.putFloat(str, f2);
            } else {
                c.a.o0.a.v1.b.d.b(f.class, c.a(i(), 5, str, String.valueOf(f2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLF.objValue;
    }

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i2)) == null) {
            if (this.f7095c) {
                super.putInt(str, i2);
            } else {
                c.a.o0.a.v1.b.d.b(f.class, c.a(i(), 1, str, String.valueOf(i2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLI.objValue;
    }

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048594, this, str, j2)) == null) {
            if (this.f7095c) {
                super.edit().putLong(str, j2).commit();
            } else {
                c.a.o0.a.v1.b.d.b(f.class, c.a(i(), 2, str, String.valueOf(j2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLJ.objValue;
    }

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, str2)) == null) {
            if (this.f7095c) {
                super.putString(str, str2);
            } else {
                c.a.o0.a.v1.b.d.b(f.class, c.a(i(), 4, str, str2));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // c.a.o0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (this.f7095c) {
                super.remove(str);
            } else {
                c.a.o0.a.v1.b.d.b(f.class, c.a(i(), 101, str, ""));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeL.objValue;
    }

    /* renamed from: c.a.o0.a.k2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class SharedPreferences$EditorC0278b implements SharedPreferences.Editor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Deque<Runnable> f7097a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f7098b;

        /* renamed from: c.a.o0.a.k2.g.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7099e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f7100f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0278b f7101g;

            public a(SharedPreferences$EditorC0278b sharedPreferences$EditorC0278b, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0278b, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7101g = sharedPreferences$EditorC0278b;
                this.f7099e = str;
                this.f7100f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7101g.f7098b.putString(this.f7099e, this.f7100f);
                }
            }
        }

        /* renamed from: c.a.o0.a.k2.g.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0279b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7102e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Set f7103f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0278b f7104g;

            public RunnableC0279b(SharedPreferences$EditorC0278b sharedPreferences$EditorC0278b, String str, Set set) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0278b, str, set};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7104g = sharedPreferences$EditorC0278b;
                this.f7102e = str;
                this.f7103f = set;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7104g.f7098b.putStringSet(this.f7102e, this.f7103f);
                }
            }
        }

        /* renamed from: c.a.o0.a.k2.g.b$b$c */
        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7105e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f7106f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0278b f7107g;

            public c(SharedPreferences$EditorC0278b sharedPreferences$EditorC0278b, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0278b, str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7107g = sharedPreferences$EditorC0278b;
                this.f7105e = str;
                this.f7106f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7107g.f7098b.putInt(this.f7105e, this.f7106f);
                }
            }
        }

        /* renamed from: c.a.o0.a.k2.g.b$b$d */
        /* loaded from: classes.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7108e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f7109f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0278b f7110g;

            public d(SharedPreferences$EditorC0278b sharedPreferences$EditorC0278b, String str, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0278b, str, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7110g = sharedPreferences$EditorC0278b;
                this.f7108e = str;
                this.f7109f = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7110g.f7098b.putLong(this.f7108e, this.f7109f);
                }
            }
        }

        /* renamed from: c.a.o0.a.k2.g.b$b$e */
        /* loaded from: classes.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7111e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f7112f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0278b f7113g;

            public e(SharedPreferences$EditorC0278b sharedPreferences$EditorC0278b, String str, float f2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0278b, str, Float.valueOf(f2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7113g = sharedPreferences$EditorC0278b;
                this.f7111e = str;
                this.f7112f = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7113g.f7098b.putFloat(this.f7111e, this.f7112f);
                }
            }
        }

        /* renamed from: c.a.o0.a.k2.g.b$b$f */
        /* loaded from: classes.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7114e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f7115f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0278b f7116g;

            public f(SharedPreferences$EditorC0278b sharedPreferences$EditorC0278b, String str, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0278b, str, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7116g = sharedPreferences$EditorC0278b;
                this.f7114e = str;
                this.f7115f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7116g.f7098b.putBoolean(this.f7114e, this.f7115f);
                }
            }
        }

        /* renamed from: c.a.o0.a.k2.g.b$b$g */
        /* loaded from: classes.dex */
        public class g implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7117e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0278b f7118f;

            public g(SharedPreferences$EditorC0278b sharedPreferences$EditorC0278b, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0278b, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7118f = sharedPreferences$EditorC0278b;
                this.f7117e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7118f.f7098b.remove(this.f7117e);
                }
            }
        }

        /* renamed from: c.a.o0.a.k2.g.b$b$h */
        /* loaded from: classes.dex */
        public class h implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0278b f7119e;

            public h(SharedPreferences$EditorC0278b sharedPreferences$EditorC0278b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0278b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7119e = sharedPreferences$EditorC0278b;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7119e.f7098b.clear();
                }
            }
        }

        public SharedPreferences$EditorC0278b(b bVar) {
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
            this.f7098b = bVar;
            this.f7097a = new ArrayDeque();
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
                synchronized (this.f7097a) {
                    while (!this.f7097a.isEmpty()) {
                        Runnable poll = this.f7097a.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final SharedPreferences$EditorC0278b e(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, runnable)) == null) {
                synchronized (this.f7097a) {
                    this.f7097a.offer(runnable);
                }
                return this;
            }
            return (SharedPreferences$EditorC0278b) invokeL.objValue;
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
                e(new RunnableC0279b(this, str, set));
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

        public /* synthetic */ SharedPreferences$EditorC0278b(b bVar, a aVar) {
            this(bVar);
        }
    }
}
