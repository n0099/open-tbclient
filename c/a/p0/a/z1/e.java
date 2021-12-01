package c.a.p0.a.z1;

import android.os.Bundle;
import c.a.p0.a.h0.g.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static e f9049c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f9050b;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<c.a.p0.a.d2.e> a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f9051b;

        /* renamed from: c  reason: collision with root package name */
        public String f9052c;

        /* renamed from: d  reason: collision with root package name */
        public MediaModel f9053d;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f9049c == null) {
                synchronized (e.class) {
                    if (f9049c == null) {
                        f9049c = new e();
                    }
                }
            }
            return f9049c;
        }
        return (e) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = null;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.f9050b.get();
            if (dVar != null) {
                dVar.D1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, mediaModel) == null) {
            c.a.p0.a.d2.e L = c.a.p0.a.d2.e.L();
            f H = c.a.p0.a.g1.f.U().H();
            if (L != null && H != null) {
                b bVar = new b(this, null);
                this.a = bVar;
                bVar.a = new WeakReference<>(L);
                this.a.f9051b = new WeakReference<>(H);
                b bVar2 = this.a;
                bVar2.f9052c = str;
                bVar2.f9053d = mediaModel;
                return;
            }
            this.a = null;
        }
    }

    public void e(c.a.p0.a.d2.e eVar, ReplyEditorParams replyEditorParams, c.a.p0.a.z1.a aVar) {
        f H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, eVar, replyEditorParams, aVar) == null) || (H = c.a.p0.a.g1.f.U().H()) == null || eVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", replyEditorParams);
        b bVar = this.a;
        if (bVar != null && eVar == bVar.a.get() && H == this.a.f9051b.get()) {
            bundle.putBoolean(MediaTrackConfig.AE_IMPORT_DRAFT, true);
            bundle.putString("content", this.a.f9052c);
            bundle.putParcelable("image", this.a.f9053d);
        }
        d dVar = new d();
        dVar.k1(bundle);
        dVar.Q1(aVar);
        dVar.u1(H.z(), "ReplyEditor");
        this.f9050b = new WeakReference<>(dVar);
    }
}
