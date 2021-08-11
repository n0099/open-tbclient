package c.a.p0.w3.i.d;

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
    public Context f27914a;

    /* renamed from: b  reason: collision with root package name */
    public String f27915b;

    /* renamed from: c  reason: collision with root package name */
    public String f27916c;

    /* renamed from: d  reason: collision with root package name */
    public String f27917d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27918e;

    /* renamed from: f  reason: collision with root package name */
    public c f27919f;

    /* renamed from: g  reason: collision with root package name */
    public f f27920g;

    /* renamed from: h  reason: collision with root package name */
    public d f27921h;

    /* renamed from: i  reason: collision with root package name */
    public e f27922i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f27923j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes4.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f27924j;

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
            this.f27924j = bVar;
        }

        @Override // c.a.p0.w3.i.d.f
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27924j.f27923j = true;
                this.f27924j.d();
            }
        }
    }

    /* renamed from: c.a.p0.w3.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1304b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f27925j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1304b(b bVar, Context context, String str, e eVar, c cVar) {
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
            this.f27925j = bVar;
        }

        @Override // c.a.p0.w3.i.d.d
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27925j.k = true;
                this.f27925j.d();
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
        this.f27918e = false;
        this.f27914a = context;
        this.f27915b = str;
        this.f27916c = str2;
        this.f27917d = str3;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f27923j && this.k && !this.l) {
            this.f27922i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f fVar = this.f27920g;
            if (fVar != null) {
                fVar.interrupt();
                this.f27920g = null;
            }
            d dVar = this.f27921h;
            if (dVar != null) {
                dVar.interrupt();
                this.f27921h = null;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27918e : invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f27919f != null) {
                File file = new File(this.f27916c);
                if (file.exists() && file.length() > 0) {
                    this.f27919f.onGenFilterVideoSuccess(this.f27916c);
                } else {
                    this.f27919f.onGenFilterVideoFail(223, "Err empty outputFile");
                }
            }
            this.f27918e = false;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f27919f = cVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f27918e) {
            return;
        }
        this.f27918e = true;
        this.f27923j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f27916c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f27919f;
            if (cVar != null) {
                cVar.onGenFilterVideoFail(222, c.a.p0.y1.a.a(e2));
            }
        }
        try {
            this.f27922i = new e(this.f27916c);
            a aVar = new a(this, this.f27914a, this.f27915b, this.f27917d, this.f27922i, this.f27919f);
            this.f27920g = aVar;
            aVar.start();
            C1304b c1304b = new C1304b(this, this.f27914a, this.f27915b, this.f27922i, this.f27919f);
            this.f27921h = c1304b;
            c1304b.start();
        } catch (Exception unused) {
        }
    }
}
