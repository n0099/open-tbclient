package com.baidu.ar.record;

import android.content.Context;
import android.view.Surface;
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
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a implements FrameRenderListener, IRecord {
    public static final String TAG = "a";
    public DuMixOutput W;
    public Watermark bu;
    public AudioParams iI;
    public Context mContext;
    public l qh;
    public RecordCallback tU;
    public b tV;
    public EncoderParams tW;
    public MovieRecorderCallback tX;
    public IEasyAudio tY;
    public EasyAudioCallback tZ;
    public long uc;
    public int mWindowWidth = 0;
    public int mWindowHeight = 0;
    public boolean ua = false;
    public boolean ub = false;
    public long ud = 0;

    /* renamed from: com.baidu.ar.record.a$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation;

        static {
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

    public a(Context context, l lVar) {
        this.mContext = context;
        this.qh = lVar;
    }

    private void a(EncoderParams encoderParams, AudioParams audioParams) {
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
            int i = videoHeight;
            videoHeight = videoWidth;
            videoWidth = i;
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

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(ByteBuffer byteBuffer, int i) {
        long nanoTime = System.nanoTime() - this.ud;
        if (this.tV != null && byteBuffer != null && i > 0 && !this.ub) {
            this.tV.onAudioFrameAvailable(byteBuffer, i, nanoTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, AudioParams audioParams) {
        this.tW.setAudioIncluded(z);
        if (this.tV != null) {
            a(this.tW, audioParams);
            fs();
            this.tV.startRecorder(this.mContext, this.tW, this.tX);
        }
    }

    private void fs() {
        Watermark watermark;
        RotationType rotationType;
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

    private void ft() {
        if (this.iI == null) {
            this.iI = new AudioParams();
        }
        if (this.tZ == null) {
            this.tZ = new EasyAudioCallback() { // from class: com.baidu.ar.record.a.1
                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
                    a.this.a(byteBuffer, i);
                }

                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioStart(boolean z, AudioParams audioParams) {
                    String str = a.TAG;
                    com.baidu.ar.h.b.c(str, "onAudioStart result = " + z);
                    a.this.a(z, audioParams);
                }

                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioStop(boolean z) {
                    String str = a.TAG;
                    com.baidu.ar.h.b.c(str, "onAudioStop result = " + z);
                }
            };
        }
        if (this.tY == null) {
            this.tY = com.baidu.ar.a.c();
        }
    }

    private void fu() {
        if (this.tW == null) {
            this.tW = new EncoderParams();
        }
        if (this.tX == null) {
            this.tX = new MovieRecorderCallback() { // from class: com.baidu.ar.record.a.2
                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderComplete(boolean z, String str) {
                    String str2 = a.TAG;
                    com.baidu.ar.h.b.c(str2, "onRecorderComplete result = " + z);
                    a.this.ua = false;
                    if (a.this.tU != null) {
                        a.this.tU.onRecorderComplete(z, str);
                        a.this.tU = null;
                    }
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderError(int i) {
                    String str = a.TAG;
                    com.baidu.ar.h.b.b(str, "onRecorderError error = " + i);
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderInit(Surface surface) {
                    if (a.this.tW == null) {
                        return;
                    }
                    String str = a.TAG;
                    com.baidu.ar.h.b.c(str, "onRecorderInit inputSurface = " + surface.hashCode());
                    a aVar = a.this;
                    aVar.W = new DuMixOutput(surface, aVar.tW.getVideoWidth(), a.this.tW.getVideoHeight());
                    a.this.W.setRotationType(a.this.fv());
                    a.this.W.setWatermark(a.this.bu);
                    if (a.this.qh == null || a.this.tW == null) {
                        return;
                    }
                    a.this.qh.addOutputSurface(a.this.W);
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderProcess(int i) {
                    String str = a.TAG;
                    com.baidu.ar.h.b.c(str, "onRecorderProcess process = " + i);
                    if (i > 100) {
                        a.this.stopRecord();
                    } else if (a.this.tU != null) {
                        a.this.tU.onRecorderProcess(i);
                    }
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderStart(boolean z) {
                    String str = a.TAG;
                    com.baidu.ar.h.b.c(str, "onRecorderStart result = " + z);
                    a.this.ua = z;
                    if (a.this.tU != null) {
                        a.this.tU.onRecorderStart(z);
                    }
                }
            };
        }
        if (this.tV == null) {
            this.tV = com.baidu.ar.a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RotationType fv() {
        RotationType rotationType = RotationType.ROTATE_0;
        int i = AnonymousClass3.$SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[OrientationManager.getGlobalOrientation().ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? rotationType : RotationType.ROTATE_180 : RotationType.ROTATE_270 : RotationType.ROTATE_90;
    }

    public void j(int i, int i2) {
        this.mWindowWidth = i;
        this.mWindowHeight = i2;
    }

    @Override // com.baidu.ar.arrender.FrameRenderListener
    public void onRenderFinished(long j) {
        if (this.tV == null || this.ub) {
            return;
        }
        this.tV.onVideoFrameAvailable(System.nanoTime() - this.ud);
    }

    @Override // com.baidu.ar.arrender.FrameRenderListener
    public void onRenderStarted(long j) {
    }

    @Override // com.baidu.ar.record.IRecord
    public void pauseRecord() {
        if (!this.ua || this.ub) {
            return;
        }
        this.ub = true;
        this.uc = System.nanoTime();
    }

    @Override // com.baidu.ar.record.IRecord
    public void resumeRecord() {
        if (this.ua && this.ub) {
            this.ub = false;
            this.ud += System.nanoTime() - this.uc;
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void setRecordWatermark(Watermark watermark) {
        this.bu = watermark;
    }

    @Override // com.baidu.ar.record.IRecord
    public void startRecord(String str, long j, RecordCallback recordCallback) {
        ft();
        fu();
        this.tU = recordCallback;
        EncoderParams encoderParams = this.tW;
        if (encoderParams != null) {
            encoderParams.setOutputFile(str);
            this.tW.setOutputTotalMs(j);
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

    @Override // com.baidu.ar.record.IRecord
    public synchronized void stopRecord() {
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
