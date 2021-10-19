package c.a.r0.y3.i.d;

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
    public Context f29136a;

    /* renamed from: b  reason: collision with root package name */
    public String f29137b;

    /* renamed from: c  reason: collision with root package name */
    public String f29138c;

    /* renamed from: d  reason: collision with root package name */
    public String f29139d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29140e;

    /* renamed from: f  reason: collision with root package name */
    public c f29141f;

    /* renamed from: g  reason: collision with root package name */
    public f f29142g;

    /* renamed from: h  reason: collision with root package name */
    public d f29143h;

    /* renamed from: i  reason: collision with root package name */
    public e f29144i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f29145j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes4.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f29146j;

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
            this.f29146j = bVar;
        }

        @Override // c.a.r0.y3.i.d.f
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29146j.f29145j = true;
                this.f29146j.d();
            }
        }
    }

    /* renamed from: c.a.r0.y3.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1358b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f29147j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1358b(b bVar, Context context, String str, e eVar, c cVar) {
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
            this.f29147j = bVar;
        }

        @Override // c.a.r0.y3.i.d.d
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29147j.k = true;
                this.f29147j.d();
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
        this.f29140e = false;
        this.f29136a = context;
        this.f29137b = str;
        this.f29138c = str2;
        this.f29139d = str3;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f29145j && this.k && !this.l) {
            this.f29144i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f fVar = this.f29142g;
            if (fVar != null) {
                fVar.interrupt();
                this.f29142g = null;
            }
            d dVar = this.f29143h;
            if (dVar != null) {
                dVar.interrupt();
                this.f29143h = null;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29140e : invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f29141f != null) {
                File file = new File(this.f29138c);
                if (file.exists() && file.length() > 0) {
                    this.f29141f.onGenFilterVideoSuccess(this.f29138c);
                } else {
                    this.f29141f.onGenFilterVideoFail(223, "Err empty outputFile");
                }
            }
            this.f29140e = false;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f29141f = cVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f29140e) {
            return;
        }
        this.f29140e = true;
        this.f29145j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f29138c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f29141f;
            if (cVar != null) {
                cVar.onGenFilterVideoFail(222, c.a.r0.a2.a.a(e2));
            }
        }
        try {
            this.f29144i = new e(this.f29138c);
            a aVar = new a(this, this.f29136a, this.f29137b, this.f29139d, this.f29144i, this.f29141f);
            this.f29142g = aVar;
            aVar.start();
            C1358b c1358b = new C1358b(this, this.f29136a, this.f29137b, this.f29144i, this.f29141f);
            this.f29143h = c1358b;
            c1358b.start();
        } catch (Exception unused) {
        }
    }
}
