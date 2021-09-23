package c.a.p0.a.w1;

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
    public static e f9502c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f9503a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f9504b;

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
        public WeakReference<c.a.p0.a.a2.e> f9505a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f9506b;

        /* renamed from: c  reason: collision with root package name */
        public String f9507c;

        /* renamed from: d  reason: collision with root package name */
        public MediaModel f9508d;

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
            if (f9502c == null) {
                synchronized (e.class) {
                    if (f9502c == null) {
                        f9502c = new e();
                    }
                }
            }
            return f9502c;
        }
        return (e) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f9503a = null;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.f9504b.get();
            if (dVar != null) {
                dVar.A1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, mediaModel) == null) {
            c.a.p0.a.a2.e i2 = c.a.p0.a.a2.e.i();
            f J = c.a.p0.a.g1.f.V().J();
            if (i2 != null && J != null) {
                b bVar = new b(this, null);
                this.f9503a = bVar;
                bVar.f9505a = new WeakReference<>(i2);
                this.f9503a.f9506b = new WeakReference<>(J);
                b bVar2 = this.f9503a;
                bVar2.f9507c = str;
                bVar2.f9508d = mediaModel;
                return;
            }
            this.f9503a = null;
        }
    }

    public void e(c.a.p0.a.a2.e eVar, ReplyEditorParams replyEditorParams, c.a.p0.a.w1.a aVar) {
        f J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, eVar, replyEditorParams, aVar) == null) || (J = c.a.p0.a.g1.f.V().J()) == null || eVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", replyEditorParams);
        b bVar = this.f9503a;
        if (bVar != null && eVar == bVar.f9505a.get() && J == this.f9503a.f9506b.get()) {
            bundle.putBoolean(MediaTrackConfig.AE_IMPORT_DRAFT, true);
            bundle.putString("content", this.f9503a.f9507c);
            bundle.putParcelable("image", this.f9503a.f9508d);
        }
        d dVar = new d();
        dVar.h1(bundle);
        dVar.N1(aVar);
        dVar.r1(J.u(), "ReplyEditor");
        this.f9504b = new WeakReference<>(dVar);
    }
}
