package com.baidu.ar.record;

import android.content.Context;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arrender.FrameRenderListener;
import com.baidu.ar.arrender.l;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.audio.EasyAudioCallback;
import com.baidu.ar.audio.IEasyAudio;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.Watermark;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class a implements FrameRenderListener, IRecord {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "a";
    public transient /* synthetic */ FieldHolder $fh;
    public DuMixOutput W;
    public Watermark bu;
    public AudioParams iI;
    public Context mContext;
    public int mWindowHeight;
    public int mWindowWidth;
    public l qh;
    public RecordCallback tU;
    public b tV;
    public EncoderParams tW;
    public MovieRecorderCallback tX;
    public IEasyAudio tY;
    public EasyAudioCallback tZ;
    public boolean ua;
    public boolean ub;
    public long uc;
    public long ud;

    /* renamed from: com.baidu.ar.record.a$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1224134201, "Lcom/baidu/ar/record/a$3;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1224134201, "Lcom/baidu/ar/record/a$3;");
                    return;
                }
            }
            int[] iArr = new int[Orientation.values().length];
            $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation = iArr;
            try {
                iArr[Orientation.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.LANDSCAPE_REVERSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.PORTRAIT_REVERSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1527216088, "Lcom/baidu/ar/record/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1527216088, "Lcom/baidu/ar/record/a;");
        }
    }

    public a(Context context, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, lVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mWindowWidth = 0;
        this.mWindowHeight = 0;
        this.ua = false;
        this.ub = false;
        this.ud = 0L;
        this.mContext = context;
        this.qh = lVar;
    }

    private void a(EncoderParams encoderParams, AudioParams audioParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, encoderParams, audioParams) == null) {
            int videoWidth = encoderParams.getVideoWidth();
            int videoHeight = encoderParams.getVideoHeight();
            if (this.mWindowWidth > 0 && this.mWindowHeight > 0) {
                if (videoHeight > videoWidth) {
                    videoHeight = (this.tW.getVideoWidth() * this.mWindowHeight) / this.mWindowWidth;
                } else {
                    videoWidth = (this.tW.getVideoHeight() * this.mWindowHeight) / this.mWindowWidth;
                }
            }
            Orientation globalOrientation = OrientationManager.getGlobalOrientation();
            if (globalOrientation == Orientation.LANDSCAPE || globalOrientation == Orientation.LANDSCAPE_REVERSE) {
                int i2 = videoHeight;
                videoHeight = videoWidth;
                videoWidth = i2;
            }
            if (videoWidth % 2 == 1) {
                videoWidth++;
            }
            if (videoHeight % 2 == 1) {
                videoHeight++;
            }
            encoderParams.setVideoWidth(videoWidth);
            encoderParams.setVideoHeight(videoHeight);
            encoderParams.setAudioSampleRate(audioParams.getSampleRate());
            encoderParams.setAudioFrameSize(audioParams.getFrameSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, this, byteBuffer, i2) == null) {
            synchronized (this) {
                long nanoTime = System.nanoTime() - this.ud;
                if (this.tV != null && byteBuffer != null && i2 > 0 && !this.ub) {
                    this.tV.onAudioFrameAvailable(byteBuffer, i2, nanoTime);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, AudioParams audioParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65545, this, z, audioParams) == null) {
            synchronized (this) {
                this.tW.setAudioIncluded(z);
                if (this.tV != null) {
                    a(this.tW, audioParams);
                    fs();
                    this.tV.startRecorder(this.mContext, this.tW, this.tX);
                }
            }
        }
    }

    private void fs() {
        Watermark watermark;
        RotationType rotationType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            Orientation globalOrientation = OrientationManager.getGlobalOrientation();
            Watermark watermark2 = this.bu;
            if (watermark2 != null) {
                if (globalOrientation == Orientation.LANDSCAPE) {
                    watermark2.setCoordinateType(Watermark.CoordinateType.RIGHT_BOTTOM);
                    watermark = this.bu;
                    rotationType = RotationType.ROTATE_270;
                } else if (globalOrientation == Orientation.LANDSCAPE_REVERSE) {
                    watermark2.setCoordinateType(Watermark.CoordinateType.LEFT_TOP);
                    watermark = this.bu;
                    rotationType = RotationType.ROTATE_90;
                } else if (globalOrientation == Orientation.PORTRAIT_REVERSE) {
                    watermark2.setCoordinateType(Watermark.CoordinateType.RIGHT_TOP);
                    watermark = this.bu;
                    rotationType = RotationType.ROTATE_180;
                } else {
                    watermark2.setCoordinateType(Watermark.CoordinateType.LEFT_BOTTOM);
                    watermark = this.bu;
                    rotationType = RotationType.ROTATE_0;
                }
                watermark.setRotationType(rotationType);
            }
        }
    }

    private void ft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if (this.iI == null) {
                this.iI = new AudioParams();
            }
            if (this.tZ == null) {
                this.tZ = new EasyAudioCallback(this) { // from class: com.baidu.ar.record.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a ue;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.ue = this;
                    }

                    @Override // com.baidu.ar.audio.EasyAudioCallback
                    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                            this.ue.a(byteBuffer, i2);
                        }
                    }

                    @Override // com.baidu.ar.audio.EasyAudioCallback
                    public void onAudioStart(boolean z, AudioParams audioParams) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, audioParams) == null) {
                            String str = a.TAG;
                            com.baidu.ar.h.b.c(str, "onAudioStart result = " + z);
                            this.ue.a(z, audioParams);
                        }
                    }

                    @Override // com.baidu.ar.audio.EasyAudioCallback
                    public void onAudioStop(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                            String str = a.TAG;
                            com.baidu.ar.h.b.c(str, "onAudioStop result = " + z);
                        }
                    }
                };
            }
            if (this.tY == null) {
                this.tY = com.baidu.ar.a.c();
            }
        }
    }

    private void fu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            if (this.tW == null) {
                this.tW = new EncoderParams();
            }
            if (this.tX == null) {
                this.tX = new MovieRecorderCallback(this) { // from class: com.baidu.ar.record.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a ue;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.ue = this;
                    }

                    @Override // com.baidu.ar.record.MovieRecorderCallback
                    public void onRecorderComplete(boolean z, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, str) == null) {
                            String str2 = a.TAG;
                            com.baidu.ar.h.b.c(str2, "onRecorderComplete result = " + z);
                            this.ue.ua = false;
                            if (this.ue.tU != null) {
                                this.ue.tU.onRecorderComplete(z, str);
                                this.ue.tU = null;
                            }
                        }
                    }

                    @Override // com.baidu.ar.record.MovieRecorderCallback
                    public void onRecorderError(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                            String str = a.TAG;
                            com.baidu.ar.h.b.b(str, "onRecorderError error = " + i2);
                        }
                    }

                    @Override // com.baidu.ar.record.MovieRecorderCallback
                    public void onRecorderInit(Surface surface) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, surface) == null) || this.ue.tW == null) {
                            return;
                        }
                        String str = a.TAG;
                        com.baidu.ar.h.b.c(str, "onRecorderInit inputSurface = " + surface.hashCode());
                        a aVar = this.ue;
                        aVar.W = new DuMixOutput(surface, aVar.tW.getVideoWidth(), this.ue.tW.getVideoHeight());
                        this.ue.W.setRotationType(this.ue.fv());
                        this.ue.W.setWatermark(this.ue.bu);
                        if (this.ue.qh == null || this.ue.tW == null) {
                            return;
                        }
                        this.ue.qh.addOutputSurface(this.ue.W);
                    }

                    @Override // com.baidu.ar.record.MovieRecorderCallback
                    public void onRecorderProcess(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048579, this, i2) == null) {
                            String str = a.TAG;
                            com.baidu.ar.h.b.c(str, "onRecorderProcess process = " + i2);
                            if (i2 > 100) {
                                this.ue.stopRecord();
                            } else if (this.ue.tU != null) {
                                this.ue.tU.onRecorderProcess(i2);
                            }
                        }
                    }

                    @Override // com.baidu.ar.record.MovieRecorderCallback
                    public void onRecorderStart(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048580, this, z) == null) {
                            String str = a.TAG;
                            com.baidu.ar.h.b.c(str, "onRecorderStart result = " + z);
                            this.ue.ua = z;
                            if (this.ue.tU != null) {
                                this.ue.tU.onRecorderStart(z);
                            }
                        }
                    }
                };
            }
            if (this.tV == null) {
                this.tV = com.baidu.ar.a.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RotationType fv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            RotationType rotationType = RotationType.ROTATE_0;
            int i2 = AnonymousClass3.$SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[OrientationManager.getGlobalOrientation().ordinal()];
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? rotationType : RotationType.ROTATE_180 : RotationType.ROTATE_270 : RotationType.ROTATE_90;
        }
        return (RotationType) invokeV.objValue;
    }

    public void j(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            this.mWindowWidth = i2;
            this.mWindowHeight = i3;
        }
    }

    @Override // com.baidu.ar.arrender.FrameRenderListener
    public void onRenderFinished(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || this.tV == null || this.ub) {
            return;
        }
        this.tV.onVideoFrameAvailable(System.nanoTime() - this.ud);
    }

    @Override // com.baidu.ar.arrender.FrameRenderListener
    public void onRenderStarted(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void pauseRecord() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.ua && !this.ub) {
            this.ub = true;
            this.uc = System.nanoTime();
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void resumeRecord() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.ua && this.ub) {
            this.ub = false;
            this.ud += System.nanoTime() - this.uc;
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void setRecordWatermark(Watermark watermark) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, watermark) == null) {
            this.bu = watermark;
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void startRecord(String str, long j2, RecordCallback recordCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j2), recordCallback}) == null) {
            ft();
            fu();
            this.tU = recordCallback;
            EncoderParams encoderParams = this.tW;
            if (encoderParams != null) {
                encoderParams.setOutputFile(str);
                this.tW.setOutputTotalMs(j2);
            }
            IEasyAudio iEasyAudio = this.tY;
            if (iEasyAudio != null) {
                iEasyAudio.startAudio(this.iI, this.tZ);
            }
            l lVar = this.qh;
            if (lVar != null) {
                lVar.addFrameRenderListener(this);
            }
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public synchronized void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.tY != null) {
                    this.tY.stopAudio(this.tZ);
                    this.tY = null;
                }
                this.iI = null;
                this.tZ = null;
                if (this.tV != null) {
                    this.tV.stopRecorder();
                    this.tV = null;
                }
                this.tW = null;
                this.tX = null;
                if (this.qh != null) {
                    this.qh.removeOutputSurface(this.W);
                    this.qh.removeFrameRenderListener(this);
                }
                this.W = null;
            }
        }
    }
}
