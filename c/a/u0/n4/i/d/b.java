package c.a.u0.n4.i.d;

import android.annotation.TargetApi;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.io.File;
@TargetApi(18)
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f19828b;

    /* renamed from: c  reason: collision with root package name */
    public String f19829c;

    /* renamed from: d  reason: collision with root package name */
    public String f19830d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19831e;

    /* renamed from: f  reason: collision with root package name */
    public c f19832f;

    /* renamed from: g  reason: collision with root package name */
    public f f19833g;

    /* renamed from: h  reason: collision with root package name */
    public d f19834h;

    /* renamed from: i  reason: collision with root package name */
    public e f19835i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f19836j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes8.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f19837j;

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
            this.f19837j = bVar;
        }

        @Override // c.a.u0.n4.i.d.f
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19837j.f19836j = true;
                this.f19837j.d();
            }
        }
    }

    /* renamed from: c.a.u0.n4.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1221b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f19838j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1221b(b bVar, Context context, String str, e eVar, c cVar) {
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
            this.f19838j = bVar;
        }

        @Override // c.a.u0.n4.i.d.d
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19838j.k = true;
                this.f19838j.d();
            }
        }
    }

    /* loaded from: classes8.dex */
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
        this.f19831e = false;
        this.a = context;
        this.f19828b = str;
        this.f19829c = str2;
        this.f19830d = str3;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19836j && this.k && !this.l) {
            this.f19835i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f fVar = this.f19833g;
            if (fVar != null) {
                fVar.interrupt();
                this.f19833g = null;
            }
            d dVar = this.f19834h;
            if (dVar != null) {
                dVar.interrupt();
                this.f19834h = null;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19831e : invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f19832f != null) {
                File file = new File(this.f19829c);
                if (file.exists() && file.length() > 0) {
                    this.f19832f.onGenFilterVideoSuccess(this.f19829c);
                } else {
                    this.f19832f.onGenFilterVideoFail(223, "Err empty outputFile");
                }
            }
            this.f19831e = false;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f19832f = cVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f19831e) {
            return;
        }
        this.f19831e = true;
        this.f19836j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f19829c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f19832f;
            if (cVar != null) {
                cVar.onGenFilterVideoFail(w0.k, c.a.u0.j2.a.a(e2));
            }
        }
        try {
            this.f19835i = new e(this.f19829c);
            a aVar = new a(this, this.a, this.f19828b, this.f19830d, this.f19835i, this.f19832f);
            this.f19833g = aVar;
            aVar.start();
            C1221b c1221b = new C1221b(this, this.a, this.f19828b, this.f19835i, this.f19832f);
            this.f19834h = c1221b;
            c1221b.start();
        } catch (Exception unused) {
        }
    }
}
