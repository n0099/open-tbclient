package com.baidu.ar.record;

import android.content.Context;
import android.view.Surface;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.filter.OnRenderFinishedListener;
import com.baidu.ar.arrender.k;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.audio.EasyAudioCallback;
import com.baidu.ar.audio.IEasyAudio;
import com.baidu.ar.bean.RotationType;
import java.nio.ByteBuffer;
/* loaded from: classes12.dex */
public class a implements OnRenderFinishedListener, IRecord {
    private static final String TAG = a.class.getSimpleName();
    private DuMixOutput aa;
    private AudioParams it;
    private Context mContext;
    private k pR;
    private RecordCallback th;
    private b ti;
    private EncoderParams tj;
    private MovieRecorderCallback tk;
    private IEasyAudio tl;
    private EasyAudioCallback tm;
    private long tp;
    private boolean tn = false;
    private boolean to = false;
    private long tq = 0;

    /* renamed from: com.baidu.ar.record.a$3  reason: invalid class name */
    /* loaded from: classes12.dex */
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

    public a(Context context, k kVar) {
        this.mContext = context;
        this.pR = kVar;
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
        long nanoTime = System.nanoTime() - this.tq;
        if (this.ti != null && byteBuffer != null && i > 0 && !this.to) {
            this.ti.onAudioFrameAvailable(byteBuffer, i, nanoTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, AudioParams audioParams) {
        this.tj.setAudioIncluded(z);
        if (this.ti != null) {
            a(this.tj, audioParams);
            this.ti.startRecorder(this.mContext, this.tj, this.tk);
        }
    }

    private void ft() {
        if (this.it == null) {
            this.it = new AudioParams();
        }
        if (this.tm == null) {
            this.tm = new EasyAudioCallback() { // from class: com.baidu.ar.record.a.1
                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
                    a.this.a(byteBuffer, i);
                }

                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioStart(boolean z, AudioParams audioParams) {
                    com.baidu.ar.g.b.c(a.TAG, "onAudioStart result = " + z);
                    a.this.a(z, audioParams);
                }

                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioStop(boolean z) {
                    com.baidu.ar.g.b.c(a.TAG, "onAudioStop result = " + z);
                }
            };
        }
        if (this.tl == null) {
            this.tl = com.baidu.ar.a.c();
        }
    }

    private void fu() {
        if (this.tj == null) {
            this.tj = new EncoderParams();
        }
        if (this.tk == null) {
            this.tk = new MovieRecorderCallback() { // from class: com.baidu.ar.record.a.2
                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderComplete(boolean z, String str) {
                    com.baidu.ar.g.b.c(a.TAG, "onRecorderComplete result = " + z);
                    a.this.tn = false;
                    if (a.this.th != null) {
                        a.this.th.onRecorderComplete(z, str);
                        a.this.th = null;
                    }
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderError(int i) {
                    com.baidu.ar.g.b.b(a.TAG, "onRecorderError error = " + i);
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderInit(Surface surface) {
                    if (a.this.tj == null) {
                        return;
                    }
                    com.baidu.ar.g.b.c(a.TAG, "onRecorderInit inputSurface = " + surface.hashCode());
                    a.this.aa = new DuMixOutput(surface, a.this.tj.getVideoWidth(), a.this.tj.getVideoHeight());
                    RotationType rotationType = RotationType.ROTATE_0;
                    switch (AnonymousClass3.$SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[OrientationManager.getGlobalOrientation().ordinal()]) {
                        case 1:
                            rotationType = RotationType.ROTATE_90;
                            break;
                        case 2:
                            rotationType = RotationType.ROTATE_270;
                            break;
                        case 3:
                            rotationType = RotationType.ROTATE_180;
                            break;
                    }
                    a.this.aa.setRotationType(rotationType);
                    if (a.this.pR == null || a.this.tj == null) {
                        return;
                    }
                    a.this.pR.addOutputSurface(a.this.aa);
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderProcess(int i) {
                    com.baidu.ar.g.b.c(a.TAG, "onRecorderProcess process = " + i);
                    if (i > 100) {
                        a.this.stopRecord();
                    } else if (a.this.th != null) {
                        a.this.th.onRecorderProcess(i);
                    }
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderStart(boolean z) {
                    com.baidu.ar.g.b.c(a.TAG, "onRecorderStart result = " + z);
                    a.this.tn = z;
                    if (a.this.th != null) {
                        a.this.th.onRecorderStart(z);
                    }
                }
            };
        }
        if (this.ti == null) {
            this.ti = com.baidu.ar.a.b();
        }
    }

    @Override // com.baidu.ar.arplay.core.filter.OnRenderFinishedListener
    public void onRenderFinished(long j) {
        if (this.ti == null || this.to) {
            return;
        }
        this.ti.onVideoFrameAvailable(System.nanoTime() - this.tq);
    }

    @Override // com.baidu.ar.record.IRecord
    public void pauseRecord() {
        if (!this.tn || this.to) {
            return;
        }
        this.to = true;
        this.tp = System.nanoTime();
    }

    @Override // com.baidu.ar.record.IRecord
    public void resumeRecord() {
        if (this.tn && this.to) {
            this.to = false;
            this.tq += System.nanoTime() - this.tp;
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void startRecord(String str, long j, RecordCallback recordCallback) {
        ft();
        fu();
        this.th = recordCallback;
        if (this.tj != null) {
            this.tj.setOutputFile(str);
            this.tj.setOutputTotalMs(j);
        }
        if (this.tl != null) {
            this.tl.startAudio(this.it, this.tm);
        }
        if (this.pR != null) {
            this.pR.setRenderFinishedListener(this);
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public synchronized void stopRecord() {
        if (this.tl != null) {
            this.tl.stopAudio(this.tm);
            this.tl = null;
        }
        this.it = null;
        this.tm = null;
        if (this.ti != null) {
            this.ti.stopRecorder();
            this.ti = null;
        }
        this.tj = null;
        this.tk = null;
        if (this.pR != null) {
            this.pR.removeOutputSurface(this.aa);
            this.pR.setRenderFinishedListener(null);
        }
        this.aa = null;
    }
}
