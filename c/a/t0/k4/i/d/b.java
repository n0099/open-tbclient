package c.a.t0.k4.i.d;

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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f18843b;

    /* renamed from: c  reason: collision with root package name */
    public String f18844c;

    /* renamed from: d  reason: collision with root package name */
    public String f18845d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18846e;

    /* renamed from: f  reason: collision with root package name */
    public c f18847f;

    /* renamed from: g  reason: collision with root package name */
    public f f18848g;

    /* renamed from: h  reason: collision with root package name */
    public d f18849h;

    /* renamed from: i  reason: collision with root package name */
    public e f18850i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f18851j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes7.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f18852j;

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
            this.f18852j = bVar;
        }

        @Override // c.a.t0.k4.i.d.f
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18852j.f18851j = true;
                this.f18852j.d();
            }
        }
    }

    /* renamed from: c.a.t0.k4.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1170b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f18853j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1170b(b bVar, Context context, String str, e eVar, c cVar) {
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
            this.f18853j = bVar;
        }

        @Override // c.a.t0.k4.i.d.d
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18853j.k = true;
                this.f18853j.d();
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f18846e = false;
        this.a = context;
        this.f18843b = str;
        this.f18844c = str2;
        this.f18845d = str3;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f18851j && this.k && !this.l) {
            this.f18850i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f fVar = this.f18848g;
            if (fVar != null) {
                fVar.interrupt();
                this.f18848g = null;
            }
            d dVar = this.f18849h;
            if (dVar != null) {
                dVar.interrupt();
                this.f18849h = null;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18846e : invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f18847f != null) {
                File file = new File(this.f18844c);
                if (file.exists() && file.length() > 0) {
                    this.f18847f.onGenFilterVideoSuccess(this.f18844c);
                } else {
                    this.f18847f.onGenFilterVideoFail(223, "Err empty outputFile");
                }
            }
            this.f18846e = false;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f18847f = cVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f18846e) {
            return;
        }
        this.f18846e = true;
        this.f18851j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f18844c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f18847f;
            if (cVar != null) {
                cVar.onGenFilterVideoFail(w0.k, c.a.t0.h2.a.a(e2));
            }
        }
        try {
            this.f18850i = new e(this.f18844c);
            a aVar = new a(this, this.a, this.f18843b, this.f18845d, this.f18850i, this.f18847f);
            this.f18848g = aVar;
            aVar.start();
            C1170b c1170b = new C1170b(this, this.a, this.f18843b, this.f18850i, this.f18847f);
            this.f18849h = c1170b;
            c1170b.start();
        } catch (Exception unused) {
        }
    }
}
