package com.baidu.ar.audio;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes12.dex */
public class EasyAudio implements IEasyAudio, VolumeListener, a {
    private static final String TAG = EasyAudio.class.getSimpleName();
    private static volatile EasyAudio iG;
    private b iB;
    private ArrayList<EasyAudioCallback> iC;
    private ArrayList<VolumeListener> iD;
    private final Lock iE = new ReentrantLock(true);
    private final Lock iF = new ReentrantLock(true);

    private EasyAudio() {
    }

    private synchronized void cu() {
        if (this.iB != null) {
            this.iB.ci();
            this.iB.cj();
            this.iB = null;
        }
    }

    private synchronized void cv() {
        this.iE.lock();
        if (this.iC != null) {
            this.iC.clear();
            this.iC = null;
        }
        this.iE.unlock();
        if (this.iD != null) {
            this.iD.clear();
            this.iD = null;
        }
        releaseInstance();
    }

    public static EasyAudio getInstance() {
        if (iG == null) {
            synchronized (EasyAudio.class) {
                if (iG == null) {
                    iG = new EasyAudio();
                }
            }
        }
        return iG;
    }

    private static void releaseInstance() {
        iG = null;
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        this.iE.lock();
        try {
            if (this.iC != null) {
                Iterator<EasyAudioCallback> it = this.iC.iterator();
                while (it.hasNext()) {
                    it.next().onAudioFrameAvailable(byteBuffer, i, j);
                }
            }
        } finally {
            this.iE.unlock();
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioRelease() {
        cv();
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioSetup(boolean z) {
        if (z) {
            if (this.iB != null) {
                this.iB.startAudio();
            }
        } else if (this.iC == null || this.iC.get(0) == null) {
        } else {
            this.iC.get(0).onAudioStart(false, null);
            release();
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioStart(boolean z) {
        if (this.iC != null && this.iC.get(0) != null && this.iB != null) {
            this.iC.get(0).onAudioStart(z, this.iB.ck());
        }
        if (z) {
            return;
        }
        release();
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioStop(boolean z) {
        if (this.iC == null || this.iC.get(0) == null) {
            return;
        }
        this.iC.get(0).onAudioStop(z);
    }

    @Override // com.baidu.ar.audio.VolumeListener
    public void onRealtimeVolume(int i) {
        this.iF.lock();
        try {
            if (this.iD != null) {
                Iterator<VolumeListener> it = this.iD.iterator();
                while (it.hasNext()) {
                    it.next().onRealtimeVolume(i);
                }
            }
        } finally {
            this.iF.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void release() {
        cu();
        cv();
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void removeVolumeListener(VolumeListener volumeListener) {
        if (volumeListener == null) {
            com.baidu.ar.g.b.b(TAG, "VolumeListener can not be null!!!");
            return;
        }
        this.iF.lock();
        try {
            if (this.iD != null && this.iD.size() > 0 && this.iD.contains(volumeListener)) {
                this.iD.remove(volumeListener);
            }
        } finally {
            this.iF.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener == null) {
            com.baidu.ar.g.b.b(TAG, "VolumeListener can not be null!!!");
            return;
        }
        if (this.iD == null) {
            this.iD = new ArrayList<>();
        }
        if (this.iD.contains(volumeListener)) {
            com.baidu.ar.g.b.b(TAG, "setVolumeListener volumeListener has been added!!!");
            return;
        }
        if (this.iB == null) {
            this.iB = b.cg();
        }
        this.iF.lock();
        try {
            if (this.iD.size() == 0) {
                this.iB.setVolumeListener(this);
            }
            this.iD.add(volumeListener);
        } finally {
            this.iF.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void startAudio(AudioParams audioParams, EasyAudioCallback easyAudioCallback) {
        if (audioParams == null || easyAudioCallback == null) {
            com.baidu.ar.g.b.b(TAG, "AudioParams && EasyAudioCallback can not be null!!!");
            return;
        }
        if (this.iB == null) {
            this.iB = b.cg();
        }
        if (this.iC == null) {
            this.iC = new ArrayList<>();
        }
        if (this.iC.contains(easyAudioCallback)) {
            com.baidu.ar.g.b.b(TAG, "EasyAudio has been started!!!");
            return;
        }
        if (this.iB.isRunning()) {
            easyAudioCallback.onAudioStart(true, this.iB.ck());
        } else {
            this.iC.clear();
            this.iB.a(audioParams, this);
        }
        this.iE.lock();
        try {
            if (this.iC != null) {
                this.iC.add(easyAudioCallback);
            }
        } finally {
            this.iE.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void stopAudio(EasyAudioCallback easyAudioCallback) {
        if (easyAudioCallback == null) {
            com.baidu.ar.g.b.b(TAG, "EasyAudioCallback can not be null!!!");
        } else if (this.iC == null || !this.iC.contains(easyAudioCallback)) {
            com.baidu.ar.g.b.b(TAG, "Please confirm EasyAudio has been started!!!");
        } else if (this.iC.size() <= 1) {
            cu();
        } else {
            this.iE.lock();
            try {
                boolean remove = this.iC.remove(easyAudioCallback);
                this.iE.unlock();
                easyAudioCallback.onAudioStop(remove);
            } catch (Throwable th) {
                this.iE.unlock();
                throw th;
            }
        }
    }
}
