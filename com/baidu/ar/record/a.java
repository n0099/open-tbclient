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
/* loaded from: classes3.dex */
public class a implements OnRenderFinishedListener, IRecord {
    private static final String TAG = a.class.getSimpleName();
    private DuMixOutput ab;
    private AudioParams iv;
    private Context mContext;
    private j oF;
    private RecordCallback sc;
    private b sd;
    private EncoderParams se;
    private MovieRecorderCallback sf;
    private IEasyAudio sg;
    private EasyAudioCallback sh;
    private long sk;
    private boolean si = false;
    private boolean sj = false;
    private long sl = 0;

    /* renamed from: com.baidu.ar.record.a$3  reason: invalid class name */
    /* loaded from: classes3.dex */
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
        this.oF = jVar;
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
        long nanoTime = System.nanoTime() - this.sl;
        if (this.sd != null && byteBuffer != null && i > 0 && !this.sj) {
            this.sd.onAudioFrameAvailable(byteBuffer, i, nanoTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, AudioParams audioParams) {
        this.se.setAudioIncluded(z);
        if (this.sd != null) {
            a(this.se, audioParams);
            this.sd.startRecorder(this.mContext, this.se, this.sf);
        }
    }

    private void dR() {
        if (this.iv == null) {
            this.iv = new AudioParams();
        }
        if (this.sh == null) {
            this.sh = new EasyAudioCallback() { // from class: com.baidu.ar.record.a.1
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
        if (this.sg == null) {
            this.sg = com.baidu.ar.a.c();
        }
    }

    private void dS() {
        if (this.se == null) {
            this.se = new EncoderParams();
        }
        if (this.sf == null) {
            this.sf = new MovieRecorderCallback() { // from class: com.baidu.ar.record.a.2
                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderComplete(boolean z, String str) {
                    com.baidu.ar.f.b.c(a.TAG, "onRecorderComplete result = " + z);
                    a.this.si = false;
                    if (a.this.sc != null) {
                        a.this.sc.onRecorderComplete(z, str);
                        a.this.sc = null;
                    }
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderError(int i) {
                    com.baidu.ar.f.b.b(a.TAG, "onRecorderError error = " + i);
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderInit(Surface surface) {
                    if (a.this.se == null) {
                        return;
                    }
                    com.baidu.ar.f.b.c(a.TAG, "onRecorderInit inputSurface = " + surface.hashCode());
                    a.this.ab = new DuMixOutput(surface, a.this.se.getVideoWidth(), a.this.se.getVideoHeight());
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
                    a.this.ab.setRotationType(bVar);
                    if (a.this.oF == null || a.this.se == null) {
                        return;
                    }
                    a.this.oF.addOutputSurface(a.this.ab);
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderProcess(int i) {
                    com.baidu.ar.f.b.c(a.TAG, "onRecorderProcess process = " + i);
                    if (i > 100) {
                        a.this.stopRecord();
                    } else if (a.this.sc != null) {
                        a.this.sc.onRecorderProcess(i);
                    }
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderStart(boolean z) {
                    com.baidu.ar.f.b.c(a.TAG, "onRecorderStart result = " + z);
                    a.this.si = z;
                    if (a.this.sc != null) {
                        a.this.sc.onRecorderStart(z);
                    }
                }
            };
        }
        if (this.sd == null) {
            this.sd = com.baidu.ar.a.b();
        }
    }

    @Override // com.baidu.ar.arplay.core.filter.OnRenderFinishedListener
    public void onRenderFinished() {
        if (this.sd == null || this.sj) {
            return;
        }
        this.sd.onVideoFrameAvailable(System.nanoTime() - this.sl);
    }

    @Override // com.baidu.ar.record.IRecord
    public void pauseRecord() {
        if (!this.si || this.sj) {
            return;
        }
        this.sj = true;
        this.sk = System.nanoTime();
    }

    @Override // com.baidu.ar.record.IRecord
    public void resumeRecord() {
        if (this.si && this.sj) {
            this.sj = false;
            this.sl += System.nanoTime() - this.sk;
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void startRecord(String str, long j, RecordCallback recordCallback) {
        dR();
        dS();
        this.sc = recordCallback;
        if (this.se != null) {
            this.se.setOutputFile(str);
            this.se.setOutputTotalMs(j);
        }
        if (this.sg != null) {
            this.sg.startAudio(this.iv, this.sh);
        }
        if (this.oF != null) {
            this.oF.setRenderFinishedListener(this);
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public synchronized void stopRecord() {
        if (this.sg != null) {
            this.sg.stopAudio(this.sh);
            this.sg = null;
        }
        this.iv = null;
        this.sh = null;
        if (this.sd != null) {
            this.sd.stopRecorder();
            this.sd = null;
        }
        this.se = null;
        this.sf = null;
        if (this.oF != null) {
            this.oF.removeOutputSurface(this.ab);
            this.oF.setRenderFinishedListener(null);
        }
        this.ab = null;
    }
}
