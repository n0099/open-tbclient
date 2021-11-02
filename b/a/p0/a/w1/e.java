package b.a.p0.a.w1;

import android.os.Bundle;
import b.a.p0.a.h0.g.f;
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
    public static e f8745c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f8746a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f8747b;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<b.a.p0.a.a2.e> f8748a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f8749b;

        /* renamed from: c  reason: collision with root package name */
        public String f8750c;

        /* renamed from: d  reason: collision with root package name */
        public MediaModel f8751d;

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
            if (f8745c == null) {
                synchronized (e.class) {
                    if (f8745c == null) {
                        f8745c = new e();
                    }
                }
            }
            return f8745c;
        }
        return (e) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f8746a = null;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.f8747b.get();
            if (dVar != null) {
                dVar.w1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, mediaModel) == null) {
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            f H = b.a.p0.a.g1.f.T().H();
            if (i2 != null && H != null) {
                b bVar = new b(this, null);
                this.f8746a = bVar;
                bVar.f8748a = new WeakReference<>(i2);
                this.f8746a.f8749b = new WeakReference<>(H);
                b bVar2 = this.f8746a;
                bVar2.f8750c = str;
                bVar2.f8751d = mediaModel;
                return;
            }
            this.f8746a = null;
        }
    }

    public void e(b.a.p0.a.a2.e eVar, ReplyEditorParams replyEditorParams, b.a.p0.a.w1.a aVar) {
        f H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, eVar, replyEditorParams, aVar) == null) || (H = b.a.p0.a.g1.f.T().H()) == null || eVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", replyEditorParams);
        b bVar = this.f8746a;
        if (bVar != null && eVar == bVar.f8748a.get() && H == this.f8746a.f8749b.get()) {
            bundle.putBoolean(MediaTrackConfig.AE_IMPORT_DRAFT, true);
            bundle.putString("content", this.f8746a.f8750c);
            bundle.putParcelable("image", this.f8746a.f8751d);
        }
        d dVar = new d();
        dVar.d1(bundle);
        dVar.J1(aVar);
        dVar.n1(H.s(), "ReplyEditor");
        this.f8747b = new WeakReference<>(dVar);
    }
}
