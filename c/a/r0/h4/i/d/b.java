package c.a.r0.h4.i.d;

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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f17956b;

    /* renamed from: c  reason: collision with root package name */
    public String f17957c;

    /* renamed from: d  reason: collision with root package name */
    public String f17958d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17959e;

    /* renamed from: f  reason: collision with root package name */
    public c f17960f;

    /* renamed from: g  reason: collision with root package name */
    public f f17961g;

    /* renamed from: h  reason: collision with root package name */
    public d f17962h;

    /* renamed from: i  reason: collision with root package name */
    public e f17963i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f17964j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f17965k;
    public volatile boolean l;

    /* loaded from: classes6.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f17966j;

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
            this.f17966j = bVar;
        }

        @Override // c.a.r0.h4.i.d.f
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17966j.f17964j = true;
                this.f17966j.d();
            }
        }
    }

    /* renamed from: c.a.r0.h4.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1058b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f17967j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1058b(b bVar, Context context, String str, e eVar, c cVar) {
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
            this.f17967j = bVar;
        }

        @Override // c.a.r0.h4.i.d.d
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17967j.f17965k = true;
                this.f17967j.d();
            }
        }
    }

    /* loaded from: classes6.dex */
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
        this.f17959e = false;
        this.a = context;
        this.f17956b = str;
        this.f17957c = str2;
        this.f17958d = str3;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f17964j && this.f17965k && !this.l) {
            this.f17963i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f fVar = this.f17961g;
            if (fVar != null) {
                fVar.interrupt();
                this.f17961g = null;
            }
            d dVar = this.f17962h;
            if (dVar != null) {
                dVar.interrupt();
                this.f17962h = null;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17959e : invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f17960f != null) {
                File file = new File(this.f17957c);
                if (file.exists() && file.length() > 0) {
                    this.f17960f.onGenFilterVideoSuccess(this.f17957c);
                } else {
                    this.f17960f.onGenFilterVideoFail(223, "Err empty outputFile");
                }
            }
            this.f17959e = false;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f17960f = cVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f17959e) {
            return;
        }
        this.f17959e = true;
        this.f17964j = false;
        this.f17965k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f17957c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f17960f;
            if (cVar != null) {
                cVar.onGenFilterVideoFail(w0.f56899k, c.a.r0.g2.a.a(e2));
            }
        }
        try {
            this.f17963i = new e(this.f17957c);
            a aVar = new a(this, this.a, this.f17956b, this.f17958d, this.f17963i, this.f17960f);
            this.f17961g = aVar;
            aVar.start();
            C1058b c1058b = new C1058b(this, this.a, this.f17956b, this.f17963i, this.f17960f);
            this.f17962h = c1058b;
            c1058b.start();
        } catch (Exception unused) {
        }
    }
}
