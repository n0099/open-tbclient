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
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1834986804, "Lc/a/w/c/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1834986804, "Lc/a/w/c/g/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 0L;
    }

    @Override // c.a.w.c.g.b
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f21930h == 0) {
                this.f21930h = this.f21927e.presentationTimeUs;
            }
            MediaCodec.BufferInfo bufferInfo = this.f21927e;
            long j = bufferInfo.presentationTimeUs - this.f21930h;
            bufferInfo.presentationTimeUs = j;
            long j2 = this.l;
            if (j < j2) {
                long j3 = j2 + 10000;
                this.l = j3;
                bufferInfo.presentationTimeUs = j3;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.f21927e;
            long j4 = bufferInfo2.presentationTimeUs;
            long j5 = b.j;
            if (j4 > j5 + 500000) {
                long j6 = this.l;
                if (j5 > j6) {
                    bufferInfo2.presentationTimeUs = j5 + 5000;
                } else {
                    bufferInfo2.presentationTimeUs = j6 + 5000;
                }
            }
            if (b.j > this.f21927e.presentationTimeUs + 500000) {
                b.k = 1200;
            }
            this.l = this.f21927e.presentationTimeUs;
        }
    }

    public void k(d dVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, eVar) == null) {
            boolean z = false;
            if (dVar != null && eVar != null) {
                this.f21925c = eVar;
                MediaFormat mediaFormat = new MediaFormat();
                mediaFormat.setString("mime", dVar.c());
                mediaFormat.setInteger("aac-profile", 2);
                mediaFormat.setInteger("sample-rate", dVar.e());
                mediaFormat.setInteger("channel-count", dVar.b());
                mediaFormat.setInteger("bitrate", dVar.a());
                mediaFormat.setInteger("max-input-size", dVar.d());
                try {
                    MediaCodec createEncoderByType = MediaCodec.createEncoderByType(dVar.c());
                    this.f21926d = createEncoderByType;
                    createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                    if (!dVar.p()) {
                        this.f21929g = true;
                    } else {
                        this.f21929g = false;
                    }
                    z = true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            c cVar = this.f21928f;
            if (cVar != null) {
                cVar.b(z);
            }
        }
    }
}
