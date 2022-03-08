package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.record.EncoderParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class f extends b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "f";
    public transient /* synthetic */ FieldHolder $fh;
    public Surface uX;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(750732739, "Lcom/baidu/ar/recorder/b/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(750732739, "Lcom/baidu/ar/recorder/b/f;");
        }
    }

    public f() {
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

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void Q(boolean z) {
        super.Q(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(EncoderParams encoderParams, d dVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, encoderParams, dVar) != null) {
            return;
        }
        boolean z = true;
        if (encoderParams != null && dVar != null) {
            this.uP = dVar;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(encoderParams.getVideoCodec(), encoderParams.getVideoWidth(), encoderParams.getVideoHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", encoderParams.getVideoBitrate());
            createVideoFormat.setInteger("frame-rate", encoderParams.getVideoFrameRate());
            createVideoFormat.setInteger("i-frame-interval", encoderParams.getVideoIFrameInterval());
            try {
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType(encoderParams.getVideoCodec());
                this.uQ = createEncoderByType;
                createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.uX = this.uQ.createInputSurface();
                this.uT = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            cVar = this.uS;
            if (cVar == null) {
                cVar.a(z, this.uX);
                return;
            }
            return;
        }
        z = false;
        cVar = this.uS;
        if (cVar == null) {
        }
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void a(boolean z, ByteBuffer byteBuffer, int i2, long j2) {
        super.a(z, byteBuffer, i2, j2);
    }

    @Override // com.baidu.ar.recorder.b.b
    public void fQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.uU == 0) {
                this.uU = this.uR.presentationTimeUs;
            }
            this.uR.presentationTimeUs -= this.uU;
            com.baidu.ar.h.b.c(TAG, "syncTimestamp mVideoEncoder = " + this.uR.size + "|" + this.uR.presentationTimeUs);
        }
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void fR() {
        super.fR();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void fS() {
        super.fS();
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void fT() {
        super.fT();
    }
}
