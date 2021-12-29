package c.a.r0.a.o2.g;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
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
    public static final boolean f8246e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences$EditorC0478b f8247b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f8248c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8249d;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-975116396, "Lc/a/r0/a/o2/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-975116396, "Lc/a/r0/a/o2/g/b;");
                return;
            }
        }
        f8246e = k.a;
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
        this.f8247b = new SharedPreferences$EditorC0478b(this, null);
        this.f8249d = str;
        this.f8248c = ProcessUtils.isMainProcess() || b();
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f8248c) {
                super.clear();
            } else {
                c.a.r0.a.y1.b.e.c(f.class, c.a(h(), 100, "", ""));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    public boolean d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) ? super.getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public float e(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, str, f2)) == null) ? super.getFloat(str, f2) : invokeLF.floatValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f8248c ? super.edit() : this.f8247b : (SharedPreferences.Editor) invokeV.objValue;
    }

    public int f(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) ? super.getInt(str, i2) : invokeLI.intValue;
    }

    public long g(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, str, j2)) == null) ? super.getLong(str, j2) : invokeLJ.longValue;
    }

    @Override // c.a.r0.a.o2.g.g, c.a.r0.w.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? j() ? super.getAll() : new HashMap(super.getAll()) : (Map) invokeV.objValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            try {
                if (this.f8248c) {
                    return d(str, z);
                }
                c.a.r0.a.y1.b.g c2 = c.a.r0.a.y1.b.e.c(e.class, c.a(h(), 3, str, String.valueOf(z)));
                if (f8246e) {
                    String str2 = "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + c2.a.getBoolean("result_value");
                }
                return c2.a.getBoolean("result_value");
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, f2)) == null) {
            if (this.f8248c) {
                return e(str, f2);
            }
            c.a.r0.a.y1.b.g c2 = c.a.r0.a.y1.b.e.c(e.class, c.a(h(), 5, str, String.valueOf(f2)));
            if (f8246e) {
                String str2 = "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + c2.a.getFloat("result_value");
            }
            return c2.a.getFloat("result_value");
        }
        return invokeLF.floatValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i2)) == null) {
            if (this.f8248c) {
                return f(str, i2);
            }
            c.a.r0.a.y1.b.g c2 = c.a.r0.a.y1.b.e.c(e.class, c.a(h(), 1, str, String.valueOf(i2)));
            if (f8246e) {
                String str2 = "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + c2.a.getInt("result_value");
            }
            return c2.a.getInt("result_value");
        }
        return invokeLI.intValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j2)) == null) {
            if (this.f8248c) {
                return g(str, j2);
            }
            c.a.r0.a.y1.b.g c2 = c.a.r0.a.y1.b.e.c(e.class, c.a(h(), 2, str, String.valueOf(j2)));
            if (f8246e) {
                String str2 = "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + c2.a.getLong("result_value");
            }
            return c2.a.getLong("result_value");
        }
        return invokeLJ.longValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            if (this.f8248c) {
                return i(str, str2);
            }
            c.a.r0.a.y1.b.g c2 = c.a.r0.a.y1.b.e.c(e.class, c.a(h(), 4, str, str2));
            if (f8246e) {
                String str3 = "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + c2.a.getString("result_value");
            }
            return c2.a.getString("result_value");
        }
        return (String) invokeLL.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f8249d : (String) invokeV.objValue;
    }

    public String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) ? super.getString(str, str2) : (String) invokeLL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f8248c : invokeV.booleanValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            if (this.f8248c) {
                super.putBoolean(str, z);
            } else {
                c.a.r0.a.y1.b.e.c(f.class, c.a(h(), 3, str, String.valueOf(z)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLZ.objValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048592, this, str, f2)) == null) {
            if (this.f8248c) {
                super.putFloat(str, f2);
            } else {
                c.a.r0.a.y1.b.e.c(f.class, c.a(h(), 5, str, String.valueOf(f2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLF.objValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i2)) == null) {
            if (this.f8248c) {
                super.putInt(str, i2);
            } else {
                c.a.r0.a.y1.b.e.c(f.class, c.a(h(), 1, str, String.valueOf(i2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLI.objValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048594, this, str, j2)) == null) {
            if (this.f8248c) {
                super.edit().putLong(str, j2).commit();
            } else {
                c.a.r0.a.y1.b.e.c(f.class, c.a(h(), 2, str, String.valueOf(j2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLJ.objValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, str2)) == null) {
            if (this.f8248c) {
                super.putString(str, str2);
            } else {
                c.a.r0.a.y1.b.e.c(f.class, c.a(h(), 4, str, str2));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (this.f8248c) {
                super.remove(str);
            } else {
                c.a.r0.a.y1.b.e.c(f.class, c.a(h(), 101, str, ""));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeL.objValue;
    }

    /* renamed from: c.a.r0.a.o2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class SharedPreferences$EditorC0478b implements SharedPreferences.Editor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Deque<Runnable> a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f8250b;

        /* renamed from: c.a.r0.a.o2.g.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f8251e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f8252f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0478b f8253g;

            public a(SharedPreferences$EditorC0478b sharedPreferences$EditorC0478b, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0478b, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8253g = sharedPreferences$EditorC0478b;
                this.f8251e = str;
                this.f8252f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8253g.f8250b.putString(this.f8251e, this.f8252f);
                }
            }
        }

        /* renamed from: c.a.r0.a.o2.g.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0479b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f8254e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Set f8255f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0478b f8256g;

            public RunnableC0479b(SharedPreferences$EditorC0478b sharedPreferences$EditorC0478b, String str, Set set) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0478b, str, set};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8256g = sharedPreferences$EditorC0478b;
                this.f8254e = str;
                this.f8255f = set;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8256g.f8250b.putStringSet(this.f8254e, this.f8255f);
                }
            }
        }

        /* renamed from: c.a.r0.a.o2.g.b$b$c */
        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f8257e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f8258f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0478b f8259g;

            public c(SharedPreferences$EditorC0478b sharedPreferences$EditorC0478b, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0478b, str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8259g = sharedPreferences$EditorC0478b;
                this.f8257e = str;
                this.f8258f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8259g.f8250b.putInt(this.f8257e, this.f8258f);
                }
            }
        }

        /* renamed from: c.a.r0.a.o2.g.b$b$d */
        /* loaded from: classes.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f8260e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f8261f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0478b f8262g;

            public d(SharedPreferences$EditorC0478b sharedPreferences$EditorC0478b, String str, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0478b, str, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8262g = sharedPreferences$EditorC0478b;
                this.f8260e = str;
                this.f8261f = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8262g.f8250b.putLong(this.f8260e, this.f8261f);
                }
            }
        }

        /* renamed from: c.a.r0.a.o2.g.b$b$e */
        /* loaded from: classes.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f8263e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f8264f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0478b f8265g;

            public e(SharedPreferences$EditorC0478b sharedPreferences$EditorC0478b, String str, float f2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0478b, str, Float.valueOf(f2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8265g = sharedPreferences$EditorC0478b;
                this.f8263e = str;
                this.f8264f = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8265g.f8250b.putFloat(this.f8263e, this.f8264f);
                }
            }
        }

        /* renamed from: c.a.r0.a.o2.g.b$b$f */
        /* loaded from: classes.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f8266e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f8267f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0478b f8268g;

            public f(SharedPreferences$EditorC0478b sharedPreferences$EditorC0478b, String str, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0478b, str, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8268g = sharedPreferences$EditorC0478b;
                this.f8266e = str;
                this.f8267f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8268g.f8250b.putBoolean(this.f8266e, this.f8267f);
                }
            }
        }

        /* renamed from: c.a.r0.a.o2.g.b$b$g */
        /* loaded from: classes.dex */
        public class g implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f8269e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0478b f8270f;

            public g(SharedPreferences$EditorC0478b sharedPreferences$EditorC0478b, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0478b, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8270f = sharedPreferences$EditorC0478b;
                this.f8269e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8270f.f8250b.remove(this.f8269e);
                }
            }
        }

        /* renamed from: c.a.r0.a.o2.g.b$b$h */
        /* loaded from: classes.dex */
        public class h implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0478b f8271e;

            public h(SharedPreferences$EditorC0478b sharedPreferences$EditorC0478b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0478b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8271e = sharedPreferences$EditorC0478b;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8271e.f8250b.clear();
                }
            }
        }

        public SharedPreferences$EditorC0478b(b bVar) {
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
            this.f8250b = bVar;
            this.a = new ArrayDeque();
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
                d(new h(this));
                return this;
            }
            return (SharedPreferences.Editor) invokeV.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.a) {
                    while (!this.a.isEmpty()) {
                        Runnable poll = this.a.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final SharedPreferences$EditorC0478b d(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, runnable)) == null) {
                synchronized (this.a) {
                    this.a.offer(runnable);
                }
                return this;
            }
            return (SharedPreferences$EditorC0478b) invokeL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
                d(new f(this, str, z));
                return this;
            }
            return (SharedPreferences.Editor) invokeLZ.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(1048581, this, str, f2)) == null) {
                d(new e(this, str, f2));
                return this;
            }
            return (SharedPreferences.Editor) invokeLF.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) {
                d(new c(this, str, i2));
                return this;
            }
            return (SharedPreferences.Editor) invokeLI.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j2) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j2)) == null) {
                d(new d(this, str, j2));
                return this;
            }
            return (SharedPreferences.Editor) invokeLJ.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
                d(new a(this, str, str2));
                return this;
            }
            return (SharedPreferences.Editor) invokeLL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, set)) == null) {
                d(new RunnableC0479b(this, str, set));
                return this;
            }
            return (SharedPreferences.Editor) invokeLL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                d(new g(this, str));
                return this;
            }
            return (SharedPreferences.Editor) invokeL.objValue;
        }

        public /* synthetic */ SharedPreferences$EditorC0478b(b bVar, a aVar) {
            this(bVar);
        }
    }
}
