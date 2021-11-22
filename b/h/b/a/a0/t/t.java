package b.h.b.a.a0.t;

import b.h.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.List;
/* loaded from: classes6.dex */
public final class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<Format> f32660a;

    /* renamed from: b  reason: collision with root package name */
    public final b.h.b.a.a0.m[] f32661b;

    public t(List<Format> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32660a = list;
        this.f32661b = new b.h.b.a.a0.m[list.size()];
    }

    public void a(long j, b.h.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, lVar) == null) {
            b.h.b.a.e0.l.g.a(j, lVar, this.f32661b);
        }
    }

    public void b(b.h.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
            for (int i2 = 0; i2 < this.f32661b.length; i2++) {
                dVar.a();
                b.h.b.a.a0.m a2 = gVar.a(dVar.c(), 3);
                Format format = this.f32660a.get(i2);
                String str = format.sampleMimeType;
                boolean z = "application/cea-608".equals(str) || "application/cea-708".equals(str);
                b.h.b.a.i0.a.b(z, "Invalid closed caption mime type provided: " + str);
                String str2 = format.id;
                if (str2 == null) {
                    str2 = dVar.b();
                }
                a2.b(Format.createTextSampleFormat(str2, str, (String) null, -1, format.selectionFlags, format.language, format.accessibilityChannel, (DrmInitData) null));
                this.f32661b[i2] = a2;
            }
        }
    }
}
