package c.a.p0.n4.i.d;

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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f16632b;

    /* renamed from: c  reason: collision with root package name */
    public String f16633c;

    /* renamed from: d  reason: collision with root package name */
    public String f16634d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16635e;

    /* renamed from: f  reason: collision with root package name */
    public c f16636f;

    /* renamed from: g  reason: collision with root package name */
    public f f16637g;

    /* renamed from: h  reason: collision with root package name */
    public d f16638h;
    public e i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes2.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f16639f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Context context, String str, String str2, e eVar, c cVar) {
            super(context, str, str2, eVar, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, str, str2, eVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (e) objArr2[3], (c) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16639f = bVar;
        }

        @Override // c.a.p0.n4.i.d.f
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16639f.j = true;
                this.f16639f.d();
            }
        }
    }

    /* renamed from: c.a.p0.n4.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1243b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f16640f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1243b(b bVar, Context context, String str, e eVar, c cVar) {
            super(context, str, eVar, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, str, eVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (e) objArr2[2], (c) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16640f = bVar;
        }

        @Override // c.a.p0.n4.i.d.d
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16640f.k = true;
                this.f16640f.d();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onGenFilterVideoFail(int i, String str);

        void onGenFilterVideoRecordError(int i, String str);

        void onGenFilterVideoSuccess(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16635e = false;
        this.a = context;
        this.f16632b = str;
        this.f16633c = str2;
        this.f16634d = str3;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.j && this.k && !this.l) {
            this.i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f fVar = this.f16637g;
            if (fVar != null) {
                fVar.interrupt();
                this.f16637g = null;
            }
            d dVar = this.f16638h;
            if (dVar != null) {
                dVar.interrupt();
                this.f16638h = null;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16635e : invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f16636f != null) {
                File file = new File(this.f16633c);
                if (file.exists() && file.length() > 0) {
                    this.f16636f.onGenFilterVideoSuccess(this.f16633c);
                } else {
                    this.f16636f.onGenFilterVideoFail(223, "Err empty outputFile");
                }
            }
            this.f16635e = false;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f16636f = cVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f16635e) {
            return;
        }
        this.f16635e = true;
        this.j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f16633c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f16636f;
            if (cVar != null) {
                cVar.onGenFilterVideoFail(w0.k, c.a.p0.l2.a.a(e2));
            }
        }
        try {
            this.i = new e(this.f16633c);
            a aVar = new a(this, this.a, this.f16632b, this.f16634d, this.i, this.f16636f);
            this.f16637g = aVar;
            aVar.start();
            C1243b c1243b = new C1243b(this, this.a, this.f16632b, this.i, this.f16636f);
            this.f16638h = c1243b;
            c1243b.start();
        } catch (Exception unused) {
        }
    }
}
