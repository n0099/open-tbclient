package com.baidu.ar.record;

import android.content.Context;
import android.view.Surface;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.filter.OnRenderFinishedListener;
import com.baidu.ar.arrender.j;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.audio.EasyAudioCallback;
import com.baidu.ar.audio.IEasyAudio;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class a implements OnRenderFinishedListener, IRecord {
    private static final String TAG = a.class.getSimpleName();
    private DuMixOutput aa;
    private AudioParams iK;
    private Context mContext;
    private j pf;
    private RecordCallback sC;
    private b sD;
    private EncoderParams sE;
    private MovieRecorderCallback sF;
    private IEasyAudio sG;
    private EasyAudioCallback sH;
    private long sK;
    private boolean sI = false;
    private boolean sJ = false;
    private long sL = 0;

    /* renamed from: com.baidu.ar.record.a$3  reason: invalid class name */
    /* loaded from: classes11.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation = new int[Orientation.values().length];

        static {
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.LANDSCAPE_REVERSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.PORTRAIT_REVERSE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public a(Context context, j jVar) {
        this.mContext = context;
        this.pf = jVar;
    }

    private void a(EncoderParams encoderParams, AudioParams audioParams) {
        int videoWidth = encoderParams.getVideoWidth();
        int videoHeight = encoderParams.getVideoHeight();
        Orientation globalOrientation = OrientationManager.getGlobalOrientation();
        if (globalOrientation == Orientation.LANDSCAPE || globalOrientation == Orientation.LANDSCAPE_REVERSE) {
            videoWidth = encoderParams.getVideoHeight();
            videoHeight = encoderParams.getVideoWidth();
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
        long nanoTime = System.nanoTime() - this.sL;
        if (this.sD != null && byteBuffer != null && i > 0 && !this.sJ) {
            this.sD.onAudioFrameAvailable(byteBuffer, i, nanoTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, AudioParams audioParams) {
        this.sE.setAudioIncluded(z);
        if (this.sD != null) {
            a(this.sE, audioParams);
            this.sD.startRecorder(this.mContext, this.sE, this.sF);
        }
    }

    private void eh() {
        if (this.iK == null) {
            this.iK = new AudioParams();
        }
        if (this.sH == null) {
            this.sH = new EasyAudioCallback() { // from class: com.baidu.ar.record.a.1
                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
                    a.this.a(byteBuffer, i);
                }

                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioStart(boolean z, AudioParams audioParams) {
                    com.baidu.ar.f.b.c(a.TAG, "onAudioStart result = " + z);
                    a.this.a(z, audioParams);
                }

                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioStop(boolean z) {
                    com.baidu.ar.f.b.c(a.TAG, "onAudioStop result = " + z);
                }
            };
        }
        if (this.sG == null) {
            this.sG = com.baidu.ar.a.c();
        }
    }

    private void ei() {
        if (this.sE == null) {
            this.sE = new EncoderParams();
        }
        if (this.sF == null) {
            this.sF = new MovieRecorderCallback() { // from class: com.baidu.ar.record.a.2
                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderComplete(boolean z, String str) {
                    com.baidu.ar.f.b.c(a.TAG, "onRecorderComplete result = " + z);
                    a.this.sI = false;
                    if (a.this.sC != null) {
                        a.this.sC.onRecorderComplete(z, str);
                        a.this.sC = null;
                    }
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderError(int i) {
                    com.baidu.ar.f.b.b(a.TAG, "onRecorderError error = " + i);
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderInit(Surface surface) {
                    if (a.this.sE == null) {
                        return;
                    }
                    com.baidu.ar.f.b.c(a.TAG, "onRecorderInit inputSurface = " + surface.hashCode());
                    a.this.aa = new DuMixOutput(surface, a.this.sE.getVideoWidth(), a.this.sE.getVideoHeight());
                    DuMixOutput.b bVar = DuMixOutput.b.ROTATE_0;
                    switch (AnonymousClass3.$SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[OrientationManager.getGlobalOrientation().ordinal()]) {
                        case 1:
                            bVar = DuMixOutput.b.ROTATE_90;
                            break;
                        case 2:
                            bVar = DuMixOutput.b.ROTATE_270;
                            break;
                        case 3:
                            bVar = DuMixOutput.b.ROTATE_180;
                            break;
                    }
                    a.this.aa.setRotationType(bVar);
                    if (a.this.pf == null || a.this.sE == null) {
                        return;
                    }
                    a.this.pf.addOutputSurface(a.this.aa);
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderProcess(int i) {
                    com.baidu.ar.f.b.c(a.TAG, "onRecorderProcess process = " + i);
                    if (i > 100) {
                        a.this.stopRecord();
                    } else if (a.this.sC != null) {
                        a.this.sC.onRecorderProcess(i);
                    }
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderStart(boolean z) {
                    com.baidu.ar.f.b.c(a.TAG, "onRecorderStart result = " + z);
                    a.this.sI = z;
                    if (a.this.sC != null) {
                        a.this.sC.onRecorderStart(z);
                    }
                }
            };
        }
        if (this.sD == null) {
            this.sD = com.baidu.ar.a.b();
        }
    }

    @Override // com.baidu.ar.arplay.core.filter.OnRenderFinishedListener
    public void onRenderFinished() {
        if (this.sD == null || this.sJ) {
            return;
        }
        this.sD.onVideoFrameAvailable(System.nanoTime() - this.sL);
    }

    @Override // com.baidu.ar.record.IRecord
    public void pauseRecord() {
        if (!this.sI || this.sJ) {
            return;
        }
        this.sJ = true;
        this.sK = System.nanoTime();
    }

    @Override // com.baidu.ar.record.IRecord
    public void resumeRecord() {
        if (this.sI && this.sJ) {
            this.sJ = false;
            this.sL += System.nanoTime() - this.sK;
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void startRecord(String str, long j, RecordCallback recordCallback) {
        eh();
        ei();
        this.sC = recordCallback;
        if (this.sE != null) {
            this.sE.setOutputFile(str);
            this.sE.setOutputTotalMs(j);
        }
        if (this.sG != null) {
            this.sG.startAudio(this.iK, this.sH);
        }
        if (this.pf != null) {
            this.pf.setRenderFinishedListener(this);
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public synchronized void stopRecord() {
        if (this.sG != null) {
            this.sG.stopAudio(this.sH);
            this.sG = null;
        }
        this.iK = null;
        this.sH = null;
        if (this.sD != null) {
            this.sD.stopRecorder();
            this.sD = null;
        }
        this.sE = null;
        this.sF = null;
        if (this.pf != null) {
            this.pf.removeOutputSurface(this.aa);
            this.pf.setRenderFinishedListener(null);
        }
        this.aa = null;
    }
}
