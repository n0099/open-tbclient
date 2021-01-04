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
/* loaded from: classes6.dex */
public class a implements FrameRenderListener, IRecord {
    private static final String TAG = a.class.getSimpleName();
    private DuMixOutput W;
    private Watermark bu;
    private AudioParams iI;
    private Context mContext;
    private l qh;
    private RecordCallback tU;
    private b tV;
    private EncoderParams tW;
    private MovieRecorderCallback tX;
    private IEasyAudio tY;
    private EasyAudioCallback tZ;
    private long uc;
    private int mWindowWidth = 0;
    private int mWindowHeight = 0;
    private boolean ua = false;
    private boolean ub = false;
    private long ud = 0;

    public a(Context context, l lVar) {
        this.mContext = context;
        this.qh = lVar;
    }

    private void a(EncoderParams encoderParams, AudioParams audioParams) {
        int i;
        int i2;
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
            i = videoWidth;
            i2 = videoHeight;
        } else {
            i = videoHeight;
            i2 = videoWidth;
        }
        if (i2 % 2 == 1) {
            i2++;
        }
        if (i % 2 == 1) {
            i++;
        }
        encoderParams.setVideoWidth(i2);
        encoderParams.setVideoHeight(i);
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
        Orientation globalOrientation = OrientationManager.getGlobalOrientation();
        if (this.bu != null) {
            if (globalOrientation == Orientation.LANDSCAPE) {
                this.bu.setCoordinateType(Watermark.CoordinateType.RIGHT_BOTTOM);
                this.bu.setRotationType(RotationType.ROTATE_270);
            } else if (globalOrientation == Orientation.LANDSCAPE_REVERSE) {
                this.bu.setCoordinateType(Watermark.CoordinateType.LEFT_TOP);
                this.bu.setRotationType(RotationType.ROTATE_90);
            } else if (globalOrientation == Orientation.PORTRAIT_REVERSE) {
                this.bu.setCoordinateType(Watermark.CoordinateType.RIGHT_TOP);
                this.bu.setRotationType(RotationType.ROTATE_180);
            } else {
                this.bu.setCoordinateType(Watermark.CoordinateType.LEFT_BOTTOM);
                this.bu.setRotationType(RotationType.ROTATE_0);
            }
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
                    com.baidu.ar.h.b.c(a.TAG, "onAudioStart result = " + z);
                    a.this.a(z, audioParams);
                }

                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioStop(boolean z) {
                    com.baidu.ar.h.b.c(a.TAG, "onAudioStop result = " + z);
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
                    com.baidu.ar.h.b.c(a.TAG, "onRecorderComplete result = " + z);
                    a.this.ua = false;
                    if (a.this.tU != null) {
                        a.this.tU.onRecorderComplete(z, str);
                        a.this.tU = null;
                    }
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderError(int i) {
                    com.baidu.ar.h.b.b(a.TAG, "onRecorderError error = " + i);
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderInit(Surface surface) {
                    if (a.this.tW == null) {
                        return;
                    }
                    com.baidu.ar.h.b.c(a.TAG, "onRecorderInit inputSurface = " + surface.hashCode());
                    a.this.W = new DuMixOutput(surface, a.this.tW.getVideoWidth(), a.this.tW.getVideoHeight());
                    a.this.W.setRotationType(a.this.fv());
                    a.this.W.setWatermark(a.this.bu);
                    if (a.this.qh == null || a.this.tW == null) {
                        return;
                    }
                    a.this.qh.addOutputSurface(a.this.W);
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderProcess(int i) {
                    com.baidu.ar.h.b.c(a.TAG, "onRecorderProcess process = " + i);
                    if (i > 100) {
                        a.this.stopRecord();
                    } else if (a.this.tU != null) {
                        a.this.tU.onRecorderProcess(i);
                    }
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderStart(boolean z) {
                    com.baidu.ar.h.b.c(a.TAG, "onRecorderStart result = " + z);
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
        switch (OrientationManager.getGlobalOrientation()) {
            case LANDSCAPE:
                return RotationType.ROTATE_90;
            case LANDSCAPE_REVERSE:
                return RotationType.ROTATE_270;
            case PORTRAIT_REVERSE:
                return RotationType.ROTATE_180;
            default:
                return rotationType;
        }
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
        if (this.tW != null) {
            this.tW.setOutputFile(str);
            this.tW.setOutputTotalMs(j);
        }
        if (this.tY != null) {
            this.tY.startAudio(this.iI, this.tZ);
        }
        if (this.qh != null) {
            this.qh.addFrameRenderListener(this);
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
