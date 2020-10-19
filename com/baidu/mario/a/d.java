package com.baidu.mario.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.recorder.MovieRecorder;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private static volatile int bIU = 0;
    private static volatile boolean bJf = false;
    private static volatile d bJo;
    private e bID;
    private com.baidu.mario.a.b.d bIE;
    private HandlerThread bIX;
    private a bJb;
    private f bJc;
    private com.baidu.mario.a.b.e bJd;
    private com.baidu.mario.a.b.f bJe;
    private com.baidu.mario.a.a.a bJg;
    private com.baidu.mario.a.b.c bJh;
    private com.baidu.mario.a.a.b bJj;
    private com.baidu.mario.a.b.c bJk;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> bJm;
    private int bJn;
    private Context mContext;
    private int bIV = 0;
    private boolean bIW = false;
    private volatile boolean bIY = false;
    private boolean bIZ = false;
    private long bJa = 0;
    private volatile boolean bJi = false;
    private volatile boolean bJl = false;

    public static d UO() {
        if (bJo == null) {
            synchronized (d.class) {
                if (bJo == null) {
                    bJo = new d();
                }
            }
        }
        return bJo;
    }

    private d() {
    }

    public long UP() {
        if (this.bJj != null) {
            return this.bJj.UP();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.bIY);
        if (this.bIY) {
            US();
            return;
        }
        this.bIY = true;
        this.mContext = context;
        this.bIE = dVar;
        this.bID = eVar;
        UQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UQ() {
        UT();
        UU();
        if (UV()) {
            UW();
            UX();
        } else if (!this.bIZ) {
            UY();
        } else {
            US();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.bJj != null && this.bJj.isRunning() && this.bJl && bJf) {
            this.bJj.aH(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.bJi && this.bJg != null && this.bJg.isRunning()) {
            this.bJg.d(byteBuffer, i, j);
        }
    }

    public void UR() {
        if (this.bJj != null) {
            this.bJj.Vk();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.bIY);
        if (this.bIY) {
            if (!Vc() && this.bJb != null) {
                this.bJb.sendMessage(this.bJb.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.bJb != null) {
                this.bJb.sendMessageDelayed(this.bJb.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.bJi = false;
        this.bJl = false;
        this.bJa = 0L;
        if (this.bJg != null && this.bJg.isRunning()) {
            this.bJg.stopRecording();
        }
        if (this.bJj != null && this.bJj.isRunning()) {
            this.bJj.stopRecording();
        }
        cW(false);
    }

    public void onDestroy() {
        if (this.bJm != null) {
            this.bJm.clear();
            this.bJm = null;
        }
        this.bJc = null;
        this.mContext = null;
        this.bIE = null;
        gi(0);
        releaseInstance();
        if (this.bJb != null) {
            this.bJb.removeCallbacksAndMessages(null);
            this.bJb = null;
        }
        if (this.bIX != null) {
            this.bIX.quit();
            this.bIX = null;
        }
    }

    private static void releaseInstance() {
        bJo = null;
    }

    private static void cW(boolean z) {
        bJf = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.bJm == null) {
                this.bJm = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.bJm.size()) {
                    break;
                }
                if (this.bJm.get(i3).UE() == cVar.UE()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.bJm.size()) {
                if (this.bJm.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.bJm.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.bJm.add(cVar.clone());
            } else {
                this.bJm.add(cVar);
            }
            Collections.sort(this.bJm);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.bJj != null) {
            a(cVar, z);
            this.bJj.q(this.bJm);
        }
    }

    private void US() {
        if (this.bJb != null) {
            this.bJb.sendMessageDelayed(this.bJb.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void UT() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bJd = new com.baidu.mario.a.b.e();
        }
        if (this.bIE.isAudioIncluded()) {
            this.bJg = new com.baidu.mario.a.a.a();
        } else {
            bJf = true;
        }
        this.bJj = new com.baidu.mario.a.a.b();
        this.bIV = 0;
        if (!this.bIW && this.bIX == null) {
            this.bIX = new HandlerThread(TAG);
            this.bIX.start();
        }
        if (this.bJb == null) {
            if (this.bIX != null) {
                this.bJb = new a(this.bIX.getLooper());
            } else {
                this.bJb = new a(this.mContext.getMainLooper());
            }
        } else {
            this.bJb.removeCallbacksAndMessages(null);
        }
        this.bJc = new f(this.bIE.getOutputTotalMs());
    }

    private void UU() {
        this.bJk = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void cX(boolean z) {
                if (z) {
                    d.this.bJj.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cY(boolean z) {
                d.this.bJl = z;
                d.this.r(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cZ(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void da(boolean z) {
                d.this.bJj.Vf();
                d.this.bJj = null;
                d.this.bJk = null;
                d.this.u(2, z);
            }
        };
        this.bJh = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void cX(boolean z) {
                if (z) {
                    d.this.bJg.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cY(boolean z) {
                d.this.bJi = z;
                d.this.r(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cZ(boolean z) {
                boolean unused = d.bJf = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void da(boolean z) {
                d.this.bJg.Vf();
                d.this.bJg = null;
                d.this.bJh = null;
                d.this.u(4, z);
            }
        };
        this.bJe = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void db(boolean z) {
                d.this.r(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void dc(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.bJd.Vv();
                    d.this.bJd = null;
                }
                d.this.bJe = null;
                d.this.u(1, z);
            }
        };
    }

    private boolean UV() {
        boolean z = true;
        if (this.bJg != null && this.bJg.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.bJg.stopRecording();
            this.bJg.Vf();
            z = false;
        }
        if (this.bJj != null && this.bJj.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.bJj.stopRecording();
            this.bJj.Vf();
            z = false;
        }
        if (this.bIE != null && !this.bJd.a(this.bIE.getOutputFile(), this.bIE.getOutputFormat(), this.bJe)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void UW() {
        if (this.bJg != null) {
            this.bJg.a(this.bIE, this.bJd, this.bJh);
        }
    }

    private void UX() {
        UZ();
        this.bJj.a(this.bJm, this.bIE, this.bJd, this.bJk);
    }

    private void UY() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.bIZ);
        if (this.bJb != null) {
            this.bIZ = true;
            this.bJb.sendMessageDelayed(this.bJb.obtainMessage(7005), 500L);
        }
    }

    private void UZ() {
        Va();
    }

    private void Va() {
        if (this.bJm != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.bJm.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a UA = it.next().UA();
                if (UA.Um() == MirrorType.NO_MIRROR) {
                    UA.gg(-this.bJn);
                } else {
                    UA.gg(this.bJn);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        t(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + bIU);
        if (Vb()) {
            this.bJb.sendMessage(this.bJb.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(Vc())));
        }
    }

    private static void gi(int i) {
        bIU = i;
    }

    private void t(int i, boolean z) {
        if (z) {
            bIU |= i;
        }
        this.bIV++;
    }

    private boolean Vb() {
        if (this.bIE == null) {
            return false;
        }
        return this.bIE.isAudioIncluded() ? this.bIV == 3 : this.bIV == 2;
    }

    private synchronized boolean Vc() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + bIU);
        i = (bIU ^ 1) ^ 2;
        if (this.bIE != null) {
            if (this.bIE.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        v(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + bIU);
        if (Vd() && this.bJb != null) {
            this.bJb.sendMessage(this.bJb.obtainMessage(7003, Boolean.valueOf(Ve())));
        }
    }

    private void v(int i, boolean z) {
        if (z) {
            bIU ^= i;
        }
        this.bIV--;
    }

    private boolean Vd() {
        return this.bIV == 0;
    }

    private synchronized boolean Ve() {
        return bIU == 0;
    }

    public void aK(long j) {
        this.bJa *= TimeUtils.NANOS_PER_MS;
        if (this.bID != null) {
            this.bID.aJ(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (d.this.bID != null) {
                        d.this.bID.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.bIY = false;
                    break;
                case 7002:
                    if (d.this.bID != null) {
                        d.this.bID.aJ(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.bID != null) {
                        if (d.this.bIE != null) {
                            str = d.this.bIE.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.bID.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.bID != null) {
                        d.this.bID.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.UQ();
                    break;
                case 7006:
                    d.this.bIY = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
