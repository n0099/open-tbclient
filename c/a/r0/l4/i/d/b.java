package c.a.r0.l4.i.d;

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
    public String f19030b;

    /* renamed from: c  reason: collision with root package name */
    public String f19031c;

    /* renamed from: d  reason: collision with root package name */
    public String f19032d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19033e;

    /* renamed from: f  reason: collision with root package name */
    public c f19034f;

    /* renamed from: g  reason: collision with root package name */
    public f f19035g;

    /* renamed from: h  reason: collision with root package name */
    public d f19036h;

    /* renamed from: i  reason: collision with root package name */
    public e f19037i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f19038j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes2.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f19039j;

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
            this.f19039j = bVar;
        }

        @Override // c.a.r0.l4.i.d.f
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19039j.f19038j = true;
                this.f19039j.d();
            }
        }
    }

    /* renamed from: c.a.r0.l4.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1189b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f19040j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1189b(b bVar, Context context, String str, e eVar, c cVar) {
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
            this.f19040j = bVar;
        }

        @Override // c.a.r0.l4.i.d.d
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19040j.k = true;
                this.f19040j.d();
            }
        }
    }

    /* loaded from: classes2.dex */
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
        this.f19033e = false;
        this.a = context;
        this.f19030b = str;
        this.f19031c = str2;
        this.f19032d = str3;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19038j && this.k && !this.l) {
            this.f19037i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f fVar = this.f19035g;
            if (fVar != null) {
                fVar.interrupt();
                this.f19035g = null;
            }
            d dVar = this.f19036h;
            if (dVar != null) {
                dVar.interrupt();
                this.f19036h = null;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19033e : invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f19034f != null) {
                File file = new File(this.f19031c);
                if (file.exists() && file.length() > 0) {
                    this.f19034f.onGenFilterVideoSuccess(this.f19031c);
                } else {
                    this.f19034f.onGenFilterVideoFail(223, "Err empty outputFile");
                }
            }
            this.f19033e = false;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f19034f = cVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f19033e) {
            return;
        }
        this.f19033e = true;
        this.f19038j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f19031c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f19034f;
            if (cVar != null) {
                cVar.onGenFilterVideoFail(w0.k, c.a.r0.j2.a.a(e2));
            }
        }
        try {
            this.f19037i = new e(this.f19031c);
            a aVar = new a(this, this.a, this.f19030b, this.f19032d, this.f19037i, this.f19034f);
            this.f19035g = aVar;
            aVar.start();
            C1189b c1189b = new C1189b(this, this.a, this.f19030b, this.f19037i, this.f19034f);
            this.f19036h = c1189b;
            c1189b.start();
        } catch (Exception unused) {
        }
    }
}
