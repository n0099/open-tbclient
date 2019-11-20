package com.baidu.mario.a;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes2.dex */
class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile boolean awt = false;
    private e awm;
    private a awq;
    private f awr;
    private AudioRecord mAudioRecord;
    private byte[] awn = null;
    private ArrayList<ByteBuffer> awo = null;
    private int awp = 0;
    private boolean aws = false;

    public void a(a aVar) {
        this.awq = aVar;
    }

    public void b(e eVar) {
        int minBufferSize = AudioRecord.getMinBufferSize(eVar.getSampleRate(), eVar.getChannelConfig(), eVar.getAudioFormat());
        if (eVar.getFrameSize() < minBufferSize) {
            eVar.setAudioBufferSize(((minBufferSize / 1024) + 1) * 1024 * 2);
        }
        this.mAudioRecord = new AudioRecord(eVar.getAudioSource(), eVar.getSampleRate(), eVar.getChannelConfig(), eVar.getAudioFormat(), eVar.getAudioBufferSize());
        this.awm = eVar;
        this.aws = false;
        if (this.awq != null) {
            this.awq.onAudioSetup(true);
        }
    }

    public void xo() {
        xr();
        xs();
    }

    public void xp() {
        awt = false;
    }

    public void xq() {
        if (!awt) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
            if (this.awq != null) {
                this.awq.onAudioRelease();
            }
            this.awq = null;
            this.awr = null;
        }
    }

    public e xn() {
        return this.awm;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void xr() {
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
            awt = z;
            if (z) {
                aX(false);
                return;
            }
            return;
        }
        z = false;
        awt = z;
        if (z) {
        }
    }

    private void xs() {
        int i;
        if (this.awm.getFrameSize() > 0) {
            if (this.awo == null) {
                this.awo = new ArrayList<>();
                for (int i2 = 0; i2 < this.awm.getFrameBufferCount(); i2++) {
                    this.awo.add(ByteBuffer.allocate(this.awm.getFrameSize()));
                }
            }
            this.awp = 0;
            if (this.awn == null) {
                this.awn = new byte[this.awm.getFrameSize()];
            }
            int i3 = 0;
            while (awt) {
                long nanoTime = System.nanoTime();
                int read = this.mAudioRecord.read(this.awn, 0, this.awn.length);
                if (this.aws) {
                    ByteBuffer byteBuffer = this.awo.get(this.awp);
                    if (read == -3) {
                        Log.e(TAG, "Audio read error");
                    } else if (this.awq != null && byteBuffer != null && byteBuffer.capacity() >= read) {
                        byteBuffer.clear();
                        byteBuffer.position(0);
                        byteBuffer.put(this.awn, 0, read);
                        byteBuffer.flip();
                        this.awq.onAudioFrameAvailable(byteBuffer, read, nanoTime);
                    }
                    this.awp++;
                    this.awp %= this.awm.getFrameBufferCount();
                    if (this.awr != null) {
                        this.awr.onRealtimeVolume((int) d.p(this.awn));
                    }
                    i = i3;
                } else {
                    K(i3);
                    i = i3 + 1;
                }
                i3 = i;
            }
            this.awo = null;
            this.awn = null;
            try {
                this.mAudioRecord.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.awq != null) {
                this.awq.onAudioStop(true);
            }
        }
    }

    private void K(long j) {
        if (j < 20) {
            if (d.o(this.awn) != 0.0d) {
                aX(true);
                this.aws = true;
                return;
            }
            return;
        }
        aX(false);
        this.aws = true;
    }

    private void aX(boolean z) {
        if (this.awq != null) {
            this.awq.onAudioStart(z);
        }
    }
}
