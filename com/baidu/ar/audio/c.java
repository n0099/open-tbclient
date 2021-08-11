package com.baidu.ar.audio;

import android.media.AudioRecord;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "c";
    public static volatile boolean iP;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioRecord iH;
    public AudioParams iI;
    public byte[] iJ;
    public ArrayList<ByteBuffer> iK;
    public int iL;
    public a iM;
    public VolumeListener iN;
    public boolean iO;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1725836641, "Lcom/baidu/ar/audio/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1725836641, "Lcom/baidu/ar/audio/c;");
        }
    }

    public c() {
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
        this.iJ = null;
        this.iK = null;
        this.iL = 0;
        this.iO = false;
    }

    private void a(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            ByteBuffer byteBuffer = this.iK.get(this.iL);
            if (i2 == -3) {
                com.baidu.ar.h.b.b(TAG, "Audio read error");
            } else if (this.iM != null && byteBuffer != null && byteBuffer.capacity() >= i2) {
                if (this.iI.getAmplifyVolume() != 1.0f) {
                    d.a(this.iJ, this.iI.getAmplifyVolume());
                }
                try {
                    byteBuffer.clear();
                    byteBuffer.position(0);
                    byteBuffer.put(this.iJ, 0, i2);
                    byteBuffer.flip();
                    this.iM.onAudioFrameAvailable(byteBuffer, i2, j2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            int i3 = this.iL + 1;
            this.iL = i3;
            this.iL = i3 % this.iI.getFrameBufferCount();
            if (this.iN != null) {
                this.iN.onRealtimeVolume((int) d.c(this.iJ));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cr() {
        int recordingState;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65539, this) != null) {
            return;
        }
        boolean z = true;
        if (this.iH.getState() == 1) {
            try {
                this.iH.startRecording();
                recordingState = this.iH.getRecordingState();
            } catch (IllegalStateException e2) {
                com.baidu.ar.h.b.b(TAG, "startAudioRecord error!!!");
                e2.printStackTrace();
            }
            if (recordingState == 3) {
                iP = z;
                if (z) {
                    String str = TAG;
                    com.baidu.ar.h.b.b(str, "startAudioRecord error!!! mAudioRecord.getState() = " + this.iH.getState());
                    r(false);
                    return;
                }
                return;
            }
            String str2 = TAG;
            com.baidu.ar.h.b.b(str2, "startAudioRecord state = " + recordingState);
        }
        z = false;
        iP = z;
        if (z) {
        }
    }

    private void cs() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.iI.getFrameSize() <= 0) {
            return;
        }
        if (this.iK == null) {
            this.iK = new ArrayList<>();
            for (int i2 = 0; i2 < this.iI.getFrameBufferCount(); i2++) {
                this.iK.add(ByteBuffer.allocate(this.iI.getFrameSize()));
            }
        }
        this.iL = 0;
        if (this.iJ == null) {
            this.iJ = new byte[this.iI.getFrameSize()];
        }
        int i3 = 0;
        while (iP) {
            long nanoTime = System.nanoTime();
            AudioRecord audioRecord = this.iH;
            byte[] bArr = this.iJ;
            int read = audioRecord.read(bArr, 0, bArr.length);
            if (!this.iO || this.iI == null) {
                h(i3);
                i3++;
            } else {
                a(nanoTime, read);
            }
        }
        this.iK = null;
        this.iJ = null;
        try {
            this.iH.stop();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a aVar = this.iM;
        if (aVar != null) {
            aVar.onAudioStop(true);
        }
    }

    private void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j2) == null) {
            if (j2 >= 20) {
                r(false);
            } else if (d.b(this.iJ) == 0.0d) {
                return;
            } else {
                r(true);
            }
            this.iO = true;
        }
    }

    private void r(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, this, z) == null) || (aVar = this.iM) == null) {
            return;
        }
        aVar.onAudioStart(z);
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.iM = aVar;
        }
    }

    public void b(AudioParams audioParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, audioParams) == null) {
            int minBufferSize = AudioRecord.getMinBufferSize(audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat());
            if (audioParams.getFrameSize() < minBufferSize) {
                audioParams.setAudioBufferSize(((minBufferSize / 1024) + 1) * 1024 * 2);
            }
            this.iH = new AudioRecord(audioParams.getAudioSource(), audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat(), audioParams.getAudioBufferSize());
            this.iI = audioParams;
            this.iO = false;
            a aVar = this.iM;
            if (aVar != null) {
                aVar.onAudioSetup(true);
            }
        }
    }

    public AudioParams cj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.iI : (AudioParams) invokeV.objValue;
    }

    public void co() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            cr();
            cs();
        }
    }

    public void cp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            iP = false;
        }
    }

    public void cq() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || iP) {
            return;
        }
        this.iH.release();
        this.iH = null;
        a aVar = this.iM;
        if (aVar != null) {
            aVar.onAudioRelease();
        }
        this.iM = null;
        this.iN = null;
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, volumeListener) == null) {
            this.iN = volumeListener;
        }
    }
}
