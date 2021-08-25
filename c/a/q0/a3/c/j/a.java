package c.a.q0.a3.c.j;

import android.content.Context;
import android.text.TextUtils;
import c.a.q0.a3.c.j.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.common.TitanConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f15567a;

    /* renamed from: b  reason: collision with root package name */
    public String f15568b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15569c;

    /* renamed from: d  reason: collision with root package name */
    public Context f15570d;

    /* renamed from: e  reason: collision with root package name */
    public b.a f15571e;

    /* renamed from: c.a.q0.a3.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0731a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f15572a;

        public C0731a(a aVar) {
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
            this.f15572a = aVar;
        }

        @Override // c.a.q0.a3.c.j.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f15572a.f15569c) {
                this.f15572a.f15569c = false;
            }
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15568b = null;
        this.f15569c = false;
        this.f15571e = new C0731a(this);
        this.f15570d = context;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.f15568b)) {
                return this.f15568b;
            }
            String b2 = c.b();
            this.f15568b = b2;
            if (TextUtils.isEmpty(b2)) {
                this.f15568b = c.c();
            } else if (!this.f15568b.endsWith(File.separator)) {
                this.f15568b += File.separator;
            }
            return this.f15568b;
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15569c : invokeV.booleanValue;
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            File file = new File(str);
            if (!file.exists()) {
                if (file.mkdirs()) {
                    BdLog.d("folder mkdir success: " + str);
                } else if (!file.exists()) {
                    BdLog.d("folder mkdir failed");
                }
            }
            if (file.isDirectory()) {
                return;
            }
            throw new IllegalArgumentException("The logcat folder path is not a directory: " + str);
        }
    }

    public final boolean f(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, str, str2, z)) == null) {
            if (this.f15567a == null) {
                e(str);
                b bVar = new b(str, str2, z);
                this.f15567a = bVar;
                bVar.b(this.f15571e);
                try {
                    this.f15567a.start();
                    return true;
                } catch (IllegalThreadStateException unused) {
                    return true;
                } catch (Exception e2) {
                    this.f15567a = null;
                    BdLog.e(e2);
                    return false;
                }
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String c2 = c();
            if (TextUtils.isEmpty(c2)) {
                return;
            }
            h();
            if (c.e(c2) && f(c2, TitanConstant.KEY_INSTANT_INIT_CLASS, true)) {
                this.f15569c = true;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: c.a.q0.a3.c.j.b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [c.a.q0.a3.c.j.b$a, c.a.q0.a3.c.j.b] */
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b bVar = this.f15567a;
            if (bVar != null) {
                try {
                    try {
                        bVar.c();
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                } finally {
                    this.f15567a.b(null);
                    this.f15567a = null;
                }
            }
            this.f15569c = false;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            h();
        }
    }
}
