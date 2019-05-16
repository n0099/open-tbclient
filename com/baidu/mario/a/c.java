package com.baidu.mario.a;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes2.dex */
class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile boolean acP = false;
    private e acI;
    private a acM;
    private f acN;
    private AudioRecord mAudioRecord;
    private byte[] acJ = null;
    private ArrayList<ByteBuffer> acK = null;
    private int acL = 0;
    private boolean acO = false;

    public void a(a aVar) {
        this.acM = aVar;
    }

    public void b(e eVar) {
        int minBufferSize = AudioRecord.getMinBufferSize(eVar.getSampleRate(), eVar.getChannelConfig(), eVar.getAudioFormat());
        if (eVar.getFrameSize() < minBufferSize) {
            eVar.setAudioBufferSize(((minBufferSize / 1024) + 1) * 1024 * 2);
        }
        this.mAudioRecord = new AudioRecord(eVar.getAudioSource(), eVar.getSampleRate(), eVar.getChannelConfig(), eVar.getAudioFormat(), eVar.getAudioBufferSize());
        this.acI = eVar;
        this.acO = false;
        if (this.acM != null) {
            this.acM.onAudioSetup(true);
        }
    }

    public void rU() {
        rX();
        rY();
    }

    public void rV() {
        acP = false;
    }

    public void rW() {
        if (!acP) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
            if (this.acM != null) {
                this.acM.onAudioRelease();
            }
            this.acM = null;
            this.acN = null;
        }
    }

    public e rT() {
        return this.acI;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void rX() {
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
            acP = z;
            if (z) {
                aC(false);
                return;
            }
            return;
        }
        z = false;
        acP = z;
        if (z) {
        }
    }

    private void rY() {
        int i;
        if (this.acI.getFrameSize() > 0) {
            if (this.acK == null) {
                this.acK = new ArrayList<>();
                for (int i2 = 0; i2 < this.acI.getFrameBufferCount(); i2++) {
                    this.acK.add(ByteBuffer.allocate(this.acI.getFrameSize()));
                }
            }
            this.acL = 0;
            if (this.acJ == null) {
                this.acJ = new byte[this.acI.getFrameSize()];
            }
            int i3 = 0;
            while (acP) {
                long nanoTime = System.nanoTime();
                int read = this.mAudioRecord.read(this.acJ, 0, this.acJ.length);
                if (this.acO) {
                    ByteBuffer byteBuffer = this.acK.get(this.acL);
                    if (read == -3) {
                        Log.e(TAG, "Audio read error");
                    } else if (this.acM != null && byteBuffer != null && byteBuffer.capacity() >= read) {
                        byteBuffer.clear();
                        byteBuffer.position(0);
                        byteBuffer.put(this.acJ, 0, read);
                        byteBuffer.flip();
                        this.acM.onAudioFrameAvailable(byteBuffer, read, nanoTime);
                    }
                    this.acL++;
                    this.acL %= this.acI.getFrameBufferCount();
                    if (this.acN != null) {
                        this.acN.onRealtimeVolume((int) d.w(this.acJ));
                    }
                    i = i3;
                } else {
                    s(i3);
                    i = i3 + 1;
                }
                i3 = i;
            }
            this.acK = null;
            this.acJ = null;
            try {
                this.mAudioRecord.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.acM != null) {
                this.acM.onAudioStop(true);
            }
        }
    }

    private void s(long j) {
        if (j < 20) {
            if (d.v(this.acJ) != 0.0d) {
                aC(true);
                this.acO = true;
                return;
            }
            return;
        }
        aC(false);
        this.acO = true;
    }

    private void aC(boolean z) {
        if (this.acM != null) {
            this.acM.onAudioStart(z);
        }
    }
}
