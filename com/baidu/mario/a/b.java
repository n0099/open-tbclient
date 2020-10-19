package com.baidu.mario.a;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.mario.audio.AudioParams;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes5.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private long bIA;
    private com.baidu.mario.a.b.d bIE;
    private boolean bIF;
    private int bIG;
    private c bIH;
    private AudioParams bIJ;
    private com.baidu.mario.audio.a.a bIK;
    private com.baidu.mario.gldraw2d.params.c bIe;
    private long bIy;
    private long bIz;
    private Context mAppContext;
    private int bIw = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean bIx = false;
    private boolean bIB = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] bIL = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer bIM = ByteBuffer.allocate(3840).put(this.bIL);
    private Timer bIN = null;
    private TimerTask bIO = null;
    private boolean bIP = false;
    private boolean bIQ = false;
    private long bIR = 0;
    private d bIC = d.UO();
    private com.baidu.mario.a.a bII = null;
    private e bID = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.bIH != null) {
                b.this.bIH.onStart();
                b.this.bIP = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void aJ(long j) {
            b.this.bIA = j;
            if (j > b.this.bIw && b.this.bIF) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.bIA);
            if (b.this.bIH != null) {
                b.this.bIH.S((int) b.this.bIA, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.bIH != null) {
                b.this.bIH.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.bID);
    }

    public void setGameRecordCallback(c cVar) {
        this.bIH = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.bII = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.bIe == null) {
                this.bIe = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.bIe.a(eGLContext);
            }
            this.bIe.Uy().setWidth(i);
            this.bIe.Uy().setHeight(i2);
            if (z) {
                this.bIe.UA().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.bIE.setVideoWidth(i);
            this.bIE.setVideoHeight(i2);
        }
    }

    public void gh(int i) {
        if (this.bIe != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.bIe.c(dVar);
                if (this.bIC != null) {
                    this.bIC.b(this.bIe);
                }
                this.mTextureId = i;
            }
            f(this.mTextureId, System.nanoTime());
        }
    }

    private void f(int i, long j) {
        if (this.bIF && this.bIE != null) {
            switch (this.bIG) {
                case 0:
                    UM();
                    if (this.bIC != null) {
                        this.bIC.a(this.mAppContext, this.bIE, this.bID);
                    }
                    this.bIG = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.bIe.Ux().setId(i);
                    if (this.bIC != null) {
                        this.bIC.c(this.bIe);
                    }
                    this.bIG = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.bIG);
            }
        }
        if (this.bIC != null && !this.bIx) {
            this.bIC.onVideoFrameAvailable(j - this.bIy);
        }
    }

    public long UH() {
        return this.bIA;
    }

    public void UI() {
        if (!this.bIx) {
            this.bIB = true;
            pauseRecord();
            return;
        }
        this.bIB = false;
    }

    public void UJ() {
        if (this.bIx && this.bIB) {
            resumeRecord();
        }
        this.bIB = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.bIF) {
            Log.i(TAG, "startRecored");
            this.bIR = System.nanoTime();
            this.mIsLandscape = z2;
            this.bIE.setOutputFile(str);
            this.bIE.setAudioIncluded(z);
            this.bIE.setOutputTotalMs(i * 1000);
            this.bIE.setVideoWidth(this.mCanvasWidth);
            this.bIE.setVideoHeight(this.mCanvasHeight);
            this.bIy = 0L;
            this.bIA = 0L;
            if (i > 0 && i < 120) {
                this.bIw = i * 1000;
            } else {
                this.bIw = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void UK() {
        if (this.bIN != null) {
            this.bIN.cancel();
            this.bIN = null;
            this.bIO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.bIE.setAudioSampleRate(audioParams.getSampleRate());
            this.bIE.setAudioFrameSize(audioParams.getFrameSize());
            this.bIE.setAudioChannel(audioParams.getChannelConfig());
        }
        this.bIP = false;
        this.bIF = true;
        UK();
        this.bIN = new Timer();
        this.bIO = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.bIP || b.this.bIQ) {
                    b.this.c(b.this.bIM, 3840, System.nanoTime() - b.this.bIR);
                    b.this.bIQ = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.UK();
                b.this.bIQ = false;
            }
        };
        this.bIN.schedule(this.bIO, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.bIK == null) {
            UN();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.bIJ = new AudioParams();
        } else {
            this.bIJ = audioParams;
        }
        if (this.bII != null) {
            Log.i(TAG, "set audio engie:" + this.bII);
            this.bII.a(this.bIK);
        }
    }

    public void pauseRecord() {
        if (this.bIx) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.bIF) {
            this.bIx = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.bIz = System.nanoTime();
            this.bIy = 0L;
            if (this.bIC != null) {
                this.bIC.UR();
                this.bIy = (this.bIz - (this.bIA * TimeUtils.NANOS_PER_MS)) - this.bIC.UP();
                if (this.bIy < 0) {
                    this.bIy = 0L;
                }
            }
            if (this.bIH != null) {
                this.bIH.onPause();
            }
            UK();
        }
    }

    public void resumeRecord() {
        if (this.bIx) {
            this.bIy += System.nanoTime() - this.bIz;
            this.bIx = false;
            a((AudioParams) null);
            if (this.bIH != null) {
                this.bIH.onResume();
            }
        }
    }

    private void UL() {
        if (this.bIx) {
            this.bIy += System.nanoTime() - this.bIz;
            this.bIx = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        UL();
        this.bIF = false;
        this.bIP = false;
        this.bIQ = false;
        switch (this.bIG) {
            case 0:
                return;
            case 1:
            case 2:
                this.bIG = 0;
                if (this.bIC != null) {
                    this.bIC.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.bIG);
        }
    }

    private void UM() {
        if (this.bIE != null && this.bIe != null) {
            int videoHeight = this.bIE.getVideoHeight();
            int videoWidth = this.bIE.getVideoWidth();
            if (videoHeight >= 1920 || videoWidth >= 1920) {
                videoHeight = (int) ((videoHeight * 2) / 3.0f);
                videoWidth = (int) ((videoWidth * 2) / 3.0f);
            }
            if (videoHeight % 2 == 1) {
                videoHeight++;
            }
            if (videoWidth % 2 == 1) {
                videoWidth++;
            }
            Log.i(TAG, "Record video width:" + videoWidth + " ;video height:" + videoHeight);
            this.bIE.setVideoWidth(videoWidth);
            this.bIE.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.bIE = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.bID = eVar;
    }

    private void UN() {
        if (this.bIK == null) {
            this.bIK = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.bIC != null && this.bIF && byteBuffer != null && i > 0 && !this.bIx) {
            this.bIC.onAudioFrameAvailable(byteBuffer, i, j - this.bIy);
        }
    }

    public void release() {
        if (this.bIC != null) {
            this.bIC.onDestroy();
            this.bIC = null;
        }
        if (this.bID != null) {
            this.bID = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> bIT;

        public a(b bVar) {
            this.bIT = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.bIT.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.bIT.get() != null) {
                this.bIT.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.bIT.get() != null) {
                this.bIT.get().bIQ = false;
                this.bIT.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.bIT.get() != null) {
                this.bIT.get().UK();
            }
        }
    }
}
