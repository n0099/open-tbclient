package com.baidu.mario.a;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes2.dex */
class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile boolean awL = false;
    private e awE;
    private a awI;
    private f awJ;
    private AudioRecord mAudioRecord;
    private byte[] awF = null;
    private ArrayList<ByteBuffer> awG = null;
    private int awH = 0;
    private boolean awK = false;

    public void a(a aVar) {
        this.awI = aVar;
    }

    public void b(e eVar) {
        int minBufferSize = AudioRecord.getMinBufferSize(eVar.getSampleRate(), eVar.getChannelConfig(), eVar.getAudioFormat());
        if (eVar.getFrameSize() < minBufferSize) {
            eVar.setAudioBufferSize(((minBufferSize / 1024) + 1) * 1024 * 2);
        }
        this.mAudioRecord = new AudioRecord(eVar.getAudioSource(), eVar.getSampleRate(), eVar.getChannelConfig(), eVar.getAudioFormat(), eVar.getAudioBufferSize());
        this.awE = eVar;
        this.awK = false;
        if (this.awI != null) {
            this.awI.onAudioSetup(true);
        }
    }

    public void xn() {
        xq();
        xr();
    }

    public void xo() {
        awL = false;
    }

    public void xp() {
        if (!awL) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
            if (this.awI != null) {
                this.awI.onAudioRelease();
            }
            this.awI = null;
            this.awJ = null;
        }
    }

    public e xm() {
        return this.awE;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void xq() {
        boolean z = true;
        if (this.mAudioRecord.getState() == 1) {
            try {
                this.mAudioRecord.startRecording();
                int recordingState = this.mAudioRecord.getRecordingState();
                if (recordingState != 3) {
                    Log.e(TAG, "startAudioRecord state = " + recordingState);
                }
            } catch (IllegalStateException e) {
                Log.e(TAG, "startAudioRecord error!!!");
                e.printStackTrace();
            }
            awL = z;
            if (z) {
                aX(false);
                return;
            }
            return;
        }
        z = false;
        awL = z;
        if (z) {
        }
    }

    private void xr() {
        int i;
        if (this.awE.getFrameSize() > 0) {
            if (this.awG == null) {
                this.awG = new ArrayList<>();
                for (int i2 = 0; i2 < this.awE.getFrameBufferCount(); i2++) {
                    this.awG.add(ByteBuffer.allocate(this.awE.getFrameSize()));
                }
            }
            this.awH = 0;
            if (this.awF == null) {
                this.awF = new byte[this.awE.getFrameSize()];
            }
            int i3 = 0;
            while (awL) {
                long nanoTime = System.nanoTime();
                int read = this.mAudioRecord.read(this.awF, 0, this.awF.length);
                if (this.awK) {
                    ByteBuffer byteBuffer = this.awG.get(this.awH);
                    if (read == -3) {
                        Log.e(TAG, "Audio read error");
                    } else if (this.awI != null && byteBuffer != null && byteBuffer.capacity() >= read) {
                        byteBuffer.clear();
                        byteBuffer.position(0);
                        byteBuffer.put(this.awF, 0, read);
                        byteBuffer.flip();
                        this.awI.onAudioFrameAvailable(byteBuffer, read, nanoTime);
                    }
                    this.awH++;
                    this.awH %= this.awE.getFrameBufferCount();
                    if (this.awJ != null) {
                        this.awJ.onRealtimeVolume((int) d.p(this.awF));
                    }
                    i = i3;
                } else {
                    L(i3);
                    i = i3 + 1;
                }
                i3 = i;
            }
            this.awG = null;
            this.awF = null;
            try {
                this.mAudioRecord.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.awI != null) {
                this.awI.onAudioStop(true);
            }
        }
    }

    private void L(long j) {
        if (j < 20) {
            if (d.o(this.awF) != 0.0d) {
                aX(true);
                this.awK = true;
                return;
            }
            return;
        }
        aX(false);
        this.awK = true;
    }

    private void aX(boolean z) {
        if (this.awI != null) {
            this.awI.onAudioStart(z);
        }
    }
}
