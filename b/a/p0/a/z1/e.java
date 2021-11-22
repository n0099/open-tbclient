package b.a.p0.a.z1;

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
    public static e f9649c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f9650a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f9651b;

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
        public WeakReference<b.a.p0.a.d2.e> f9652a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f9653b;

        /* renamed from: c  reason: collision with root package name */
        public String f9654c;

        /* renamed from: d  reason: collision with root package name */
        public MediaModel f9655d;

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
            if (f9649c == null) {
                synchronized (e.class) {
                    if (f9649c == null) {
                        f9649c = new e();
                    }
                }
            }
            return f9649c;
        }
        return (e) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f9650a = null;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.f9651b.get();
            if (dVar != null) {
                dVar.z1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, mediaModel) == null) {
            b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
            f H = b.a.p0.a.g1.f.U().H();
            if (L != null && H != null) {
                b bVar = new b(this, null);
                this.f9650a = bVar;
                bVar.f9652a = new WeakReference<>(L);
                this.f9650a.f9653b = new WeakReference<>(H);
                b bVar2 = this.f9650a;
                bVar2.f9654c = str;
                bVar2.f9655d = mediaModel;
                return;
            }
            this.f9650a = null;
        }
    }

    public void e(b.a.p0.a.d2.e eVar, ReplyEditorParams replyEditorParams, b.a.p0.a.z1.a aVar) {
        f H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, eVar, replyEditorParams, aVar) == null) || (H = b.a.p0.a.g1.f.U().H()) == null || eVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", replyEditorParams);
        b bVar = this.f9650a;
        if (bVar != null && eVar == bVar.f9652a.get() && H == this.f9650a.f9653b.get()) {
            bundle.putBoolean(MediaTrackConfig.AE_IMPORT_DRAFT, true);
            bundle.putString("content", this.f9650a.f9654c);
            bundle.putParcelable("image", this.f9650a.f9655d);
        }
        d dVar = new d();
        dVar.g1(bundle);
        dVar.M1(aVar);
        dVar.q1(H.t(), "ReplyEditor");
        this.f9651b = new WeakReference<>(dVar);
    }
}
