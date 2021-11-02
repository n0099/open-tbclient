package b.a.x.c.g;

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
/* loaded from: classes6.dex */
public class g extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-221259002, "Lb/a/x/c/g/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-221259002, "Lb/a/x/c/g/g;");
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // b.a.x.c.g.b
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f29470h == 0) {
                this.f29470h = this.f29467e.presentationTimeUs;
                b.f29462i = 0L;
            }
            MediaCodec.BufferInfo bufferInfo = this.f29467e;
            long j = bufferInfo.presentationTimeUs - this.f29470h;
            bufferInfo.presentationTimeUs = j;
            b.f29462i = j;
            b.a.x.c.d.x().V(b.f29462i / 1000);
        }
    }

    public Surface k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (Surface) invokeV.objValue;
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
            this.f29465c = eVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(dVar.j(), dVar.n(), dVar.l());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", dVar.i());
            createVideoFormat.setInteger("frame-rate", dVar.k());
            createVideoFormat.setInteger("i-frame-interval", dVar.m());
            try {
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType(dVar.j());
                this.f29466d = createEncoderByType;
                createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.k = this.f29466d.createInputSurface();
                this.f29469g = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            cVar = this.f29468f;
            if (cVar == null) {
                cVar.b(z);
                return;
            }
            return;
        }
        z = false;
        cVar = this.f29468f;
        if (cVar == null) {
        }
    }
}
