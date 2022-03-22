package c.a.w.c.g;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1834986618, "Lc/a/w/c/g/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1834986618, "Lc/a/w/c/g/g;");
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.w.c.g.b
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f21930h == 0) {
                this.f21930h = this.f21927e.presentationTimeUs;
                b.j = 0L;
            }
            MediaCodec.BufferInfo bufferInfo = this.f21927e;
            long j = bufferInfo.presentationTimeUs - this.f21930h;
            bufferInfo.presentationTimeUs = j;
            b.j = j;
            c.a.w.c.d.x().V(b.j / 1000);
        }
    }

    public Surface k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (Surface) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(d dVar, e eVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, eVar) != null) {
            return;
        }
        boolean z = true;
        if (dVar != null && eVar != null) {
            this.f21925c = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.j(), dVar.n(), dVar.l());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", dVar.i());
            createVideoFormat.setInteger("frame-rate", dVar.k());
            createVideoFormat.setInteger("i-frame-interval", dVar.m());
            try {
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType(dVar.j());
                this.f21926d = createEncoderByType;
                createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.l = this.f21926d.createInputSurface();
                this.f21929g = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            cVar = this.f21928f;
            if (cVar == null) {
                cVar.b(z);
                return;
            }
            return;
        }
        z = false;
        cVar = this.f21928f;
        if (cVar == null) {
        }
    }
}
