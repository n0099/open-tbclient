package com.baidu.mario.a;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes2.dex */
class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile boolean adn = false;
    private e adg;
    private a adk;
    private f adl;
    private AudioRecord mAudioRecord;
    private byte[] adh = null;
    private ArrayList<ByteBuffer> adi = null;
    private int adj = 0;
    private boolean adm = false;

    public void a(a aVar) {
        this.adk = aVar;
    }

    public void b(e eVar) {
        int minBufferSize = AudioRecord.getMinBufferSize(eVar.getSampleRate(), eVar.getChannelConfig(), eVar.getAudioFormat());
        if (eVar.getFrameSize() < minBufferSize) {
            eVar.setAudioBufferSize(((minBufferSize / 1024) + 1) * 1024 * 2);
        }
        this.mAudioRecord = new AudioRecord(eVar.getAudioSource(), eVar.getSampleRate(), eVar.getChannelConfig(), eVar.getAudioFormat(), eVar.getAudioBufferSize());
        this.adg = eVar;
        this.adm = false;
        if (this.adk != null) {
            this.adk.onAudioSetup(true);
        }
    }

    public void ss() {
        sv();
        sw();
    }

    public void st() {
        adn = false;
    }

    public void su() {
        if (!adn) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
            if (this.adk != null) {
                this.adk.onAudioRelease();
            }
            this.adk = null;
            this.adl = null;
        }
    }

    public e sr() {
        return this.adg;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void sv() {
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
            adn = z;
            if (z) {
                aF(false);
                return;
            }
            return;
        }
        z = false;
        adn = z;
        if (z) {
        }
    }

    private void sw() {
        int i;
        if (this.adg.getFrameSize() > 0) {
            if (this.adi == null) {
                this.adi = new ArrayList<>();
                for (int i2 = 0; i2 < this.adg.getFrameBufferCount(); i2++) {
                    this.adi.add(ByteBuffer.allocate(this.adg.getFrameSize()));
                }
            }
            this.adj = 0;
            if (this.adh == null) {
                this.adh = new byte[this.adg.getFrameSize()];
            }
            int i3 = 0;
            while (adn) {
                long nanoTime = System.nanoTime();
                int read = this.mAudioRecord.read(this.adh, 0, this.adh.length);
                if (this.adm) {
                    ByteBuffer byteBuffer = this.adi.get(this.adj);
                    if (read == -3) {
                        Log.e(TAG, "Audio read error");
                    } else if (this.adk != null && byteBuffer != null && byteBuffer.capacity() >= read) {
                        byteBuffer.clear();
                        byteBuffer.position(0);
                        byteBuffer.put(this.adh, 0, read);
                        byteBuffer.flip();
                        this.adk.onAudioFrameAvailable(byteBuffer, read, nanoTime);
                    }
                    this.adj++;
                    this.adj %= this.adg.getFrameBufferCount();
                    if (this.adl != null) {
                        this.adl.onRealtimeVolume((int) d.x(this.adh));
                    }
                    i = i3;
                } else {
                    s(i3);
                    i = i3 + 1;
                }
                i3 = i;
            }
            this.adi = null;
            this.adh = null;
            try {
                this.mAudioRecord.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.adk != null) {
                this.adk.onAudioStop(true);
            }
        }
    }

    private void s(long j) {
        if (j < 20) {
            if (d.w(this.adh) != 0.0d) {
                aF(true);
                this.adm = true;
                return;
            }
            return;
        }
        aF(false);
        this.adm = true;
    }

    private void aF(boolean z) {
        if (this.adk != null) {
            this.adk.onAudioStart(z);
        }
    }
}
