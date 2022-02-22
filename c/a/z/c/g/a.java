package c.a.z.c.g;

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
/* loaded from: classes9.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-901523095, "Lc/a/z/c/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-901523095, "Lc/a/z/c/g/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 0L;
    }

    @Override // c.a.z.c.g.b
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f27046h == 0) {
                this.f27046h = this.f27043e.presentationTimeUs;
            }
            MediaCodec.BufferInfo bufferInfo = this.f27043e;
            long j2 = bufferInfo.presentationTimeUs - this.f27046h;
            bufferInfo.presentationTimeUs = j2;
            long j3 = this.k;
            if (j2 < j3) {
                long j4 = j3 + 10000;
                this.k = j4;
                bufferInfo.presentationTimeUs = j4;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.f27043e;
            long j5 = bufferInfo2.presentationTimeUs;
            long j6 = b.f27038i;
            if (j5 > j6 + 500000) {
                long j7 = this.k;
                if (j6 > j7) {
                    bufferInfo2.presentationTimeUs = j6 + 5000;
                } else {
                    bufferInfo2.presentationTimeUs = j7 + 5000;
                }
            }
            if (b.f27038i > this.f27043e.presentationTimeUs + 500000) {
                b.f27039j = 1200;
            }
            this.k = this.f27043e.presentationTimeUs;
        }
    }

    public void k(d dVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, eVar) == null) {
            boolean z = false;
            if (dVar != null && eVar != null) {
                this.f27041c = eVar;
                MediaFormat mediaFormat = new MediaFormat();
                mediaFormat.setString("mime", dVar.c());
                mediaFormat.setInteger("aac-profile", 2);
                mediaFormat.setInteger("sample-rate", dVar.e());
                mediaFormat.setInteger("channel-count", dVar.b());
                mediaFormat.setInteger("bitrate", dVar.a());
                mediaFormat.setInteger("max-input-size", dVar.d());
                try {
                    MediaCodec createEncoderByType = MediaCodec.createEncoderByType(dVar.c());
                    this.f27042d = createEncoderByType;
                    createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                    if (!dVar.p()) {
                        this.f27045g = true;
                    } else {
                        this.f27045g = false;
                    }
                    z = true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            c cVar = this.f27044f;
            if (cVar != null) {
                cVar.b(z);
            }
        }
    }
}
