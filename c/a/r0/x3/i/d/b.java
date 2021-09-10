package c.a.r0.x3.i.d;

import android.annotation.TargetApi;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@TargetApi(18)
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f28940a;

    /* renamed from: b  reason: collision with root package name */
    public String f28941b;

    /* renamed from: c  reason: collision with root package name */
    public String f28942c;

    /* renamed from: d  reason: collision with root package name */
    public String f28943d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28944e;

    /* renamed from: f  reason: collision with root package name */
    public c f28945f;

    /* renamed from: g  reason: collision with root package name */
    public f f28946g;

    /* renamed from: h  reason: collision with root package name */
    public d f28947h;

    /* renamed from: i  reason: collision with root package name */
    public e f28948i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f28949j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes4.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f28950j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Context context, String str, String str2, e eVar, c cVar) {
            super(context, str, str2, eVar, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, str, str2, eVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (e) objArr2[3], (c) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28950j = bVar;
        }

        @Override // c.a.r0.x3.i.d.f
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28950j.f28949j = true;
                this.f28950j.d();
            }
        }
    }

    /* renamed from: c.a.r0.x3.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1351b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f28951j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1351b(b bVar, Context context, String str, e eVar, c cVar) {
            super(context, str, eVar, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, str, eVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (e) objArr2[2], (c) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28951j = bVar;
        }

        @Override // c.a.r0.x3.i.d.d
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28951j.k = true;
                this.f28951j.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onGenFilterVideoFail(int i2, String str);

        void onGenFilterVideoRecordError(int i2, String str);

        void onGenFilterVideoSuccess(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28944e = false;
        this.f28940a = context;
        this.f28941b = str;
        this.f28942c = str2;
        this.f28943d = str3;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f28949j && this.k && !this.l) {
            this.f28948i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f fVar = this.f28946g;
            if (fVar != null) {
                fVar.interrupt();
                this.f28946g = null;
            }
            d dVar = this.f28947h;
            if (dVar != null) {
                dVar.interrupt();
                this.f28947h = null;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28944e : invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f28945f != null) {
                File file = new File(this.f28942c);
                if (file.exists() && file.length() > 0) {
                    this.f28945f.onGenFilterVideoSuccess(this.f28942c);
                } else {
                    this.f28945f.onGenFilterVideoFail(223, "Err empty outputFile");
                }
            }
            this.f28944e = false;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f28945f = cVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f28944e) {
            return;
        }
        this.f28944e = true;
        this.f28949j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f28942c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f28945f;
            if (cVar != null) {
                cVar.onGenFilterVideoFail(222, c.a.r0.z1.a.a(e2));
            }
        }
        try {
            this.f28948i = new e(this.f28942c);
            a aVar = new a(this, this.f28940a, this.f28941b, this.f28943d, this.f28948i, this.f28945f);
            this.f28946g = aVar;
            aVar.start();
            C1351b c1351b = new C1351b(this, this.f28940a, this.f28941b, this.f28948i, this.f28945f);
            this.f28947h = c1351b;
            c1351b.start();
        } catch (Exception unused) {
        }
    }
}
