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
public class a extends b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "a";
    public transient /* synthetic */ FieldHolder $fh;
    public long uM;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(750732584, "Lcom/baidu/ar/recorder/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(750732584, "Lcom/baidu/ar/recorder/b/a;");
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
        this.uM = 0L;
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void Q(boolean z) {
        super.Q(z);
    }

    public void a(EncoderParams encoderParams, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, encoderParams, dVar) == null) {
            boolean z = false;
            if (encoderParams != null && dVar != null) {
                this.uP = dVar;
                MediaFormat mediaFormat = new MediaFormat();
                mediaFormat.setString("mime", encoderParams.getAudioCodec());
                mediaFormat.setInteger("aac-profile", 2);
                mediaFormat.setInteger("sample-rate", encoderParams.getAudioSampleRate());
                mediaFormat.setInteger("channel-count", encoderParams.getAudioChannel());
                mediaFormat.setInteger("bitrate", encoderParams.getAudioBitrate());
                mediaFormat.setInteger("max-input-size", encoderParams.getAudioFrameSize());
                try {
                    MediaCodec createEncoderByType = MediaCodec.createEncoderByType(encoderParams.getAudioCodec());
                    this.uQ = createEncoderByType;
                    createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                    if (encoderParams.isVideoIncluded()) {
                        this.uT = false;
                    } else {
                        this.uT = true;
                    }
                    z = true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            c cVar = this.uS;
            if (cVar != null) {
                cVar.a(z, null);
            }
        }
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.ar.recorder.b.b
    public /* bridge */ /* synthetic */ void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.a(z, byteBuffer, i, j);
    }

    @Override // com.baidu.ar.recorder.b.b
    public void fQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.uU == 0) {
                this.uU = this.uR.presentationTimeUs;
            }
            MediaCodec.BufferInfo bufferInfo = this.uR;
            long j = bufferInfo.presentationTimeUs - this.uU;
            bufferInfo.presentationTimeUs = j;
            long j2 = this.uM;
            if (j < j2) {
                long j3 = j2 + 10000;
                this.uM = j3;
                bufferInfo.presentationTimeUs = j3;
            }
            this.uM = this.uR.presentationTimeUs;
            String str = TAG;
            com.baidu.ar.h.b.c(str, "syncTimestamp mAudioEncoder = " + this.uR.size + "|" + this.uR.presentationTimeUs);
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
