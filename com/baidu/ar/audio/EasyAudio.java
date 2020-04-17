package com.baidu.ar.audio;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class EasyAudio implements IEasyAudio, VolumeListener, a {
    private static final String TAG = EasyAudio.class.getSimpleName();
    private static volatile EasyAudio iI;
    private b iD;
    private ArrayList<EasyAudioCallback> iE;
    private ArrayList<VolumeListener> iF;
    private final Lock iG = new ReentrantLock(true);
    private final Lock iH = new ReentrantLock(true);

    private EasyAudio() {
    }

    private synchronized void bO() {
        if (this.iD != null) {
            this.iD.bC();
            this.iD.bD();
            this.iD = null;
        }
    }

    private synchronized void bP() {
        this.iG.lock();
        if (this.iE != null) {
            this.iE.clear();
            this.iE = null;
        }
        this.iG.unlock();
        if (this.iF != null) {
            this.iF.clear();
            this.iF = null;
        }
        releaseInstance();
    }

    public static EasyAudio getInstance() {
        if (iI == null) {
            synchronized (EasyAudio.class) {
                if (iI == null) {
                    iI = new EasyAudio();
                }
            }
        }
        return iI;
    }

    private static void releaseInstance() {
        iI = null;
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        this.iG.lock();
        try {
            if (this.iE != null) {
                Iterator<EasyAudioCallback> it = this.iE.iterator();
                while (it.hasNext()) {
                    it.next().onAudioFrameAvailable(byteBuffer, i, j);
                }
            }
        } finally {
            this.iG.unlock();
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioRelease() {
        bP();
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioSetup(boolean z) {
        if (z) {
            if (this.iD != null) {
                this.iD.startAudio();
            }
        } else if (this.iE == null || this.iE.get(0) == null) {
        } else {
            this.iE.get(0).onAudioStart(false, null);
            release();
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioStart(boolean z) {
        if (this.iE != null && this.iE.get(0) != null && this.iD != null) {
            this.iE.get(0).onAudioStart(z, this.iD.bE());
        }
        if (z) {
            return;
        }
        release();
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioStop(boolean z) {
        if (this.iE == null || this.iE.get(0) == null) {
            return;
        }
        this.iE.get(0).onAudioStop(z);
    }

    @Override // com.baidu.ar.audio.VolumeListener
    public void onRealtimeVolume(int i) {
        this.iH.lock();
        try {
            if (this.iF != null) {
                Iterator<VolumeListener> it = this.iF.iterator();
                while (it.hasNext()) {
                    it.next().onRealtimeVolume(i);
                }
            }
        } finally {
            this.iH.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void release() {
        bO();
        bP();
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void removeVolumeListener(VolumeListener volumeListener) {
        if (volumeListener == null) {
            com.baidu.ar.f.b.b(TAG, "VolumeListener can not be null!!!");
            return;
        }
        this.iH.lock();
        try {
            if (this.iF != null && this.iF.size() > 0 && this.iF.contains(volumeListener)) {
                this.iF.remove(volumeListener);
            }
        } finally {
            this.iH.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener == null) {
            com.baidu.ar.f.b.b(TAG, "VolumeListener can not be null!!!");
            return;
        }
        if (this.iF == null) {
            this.iF = new ArrayList<>();
        }
        if (this.iF.contains(volumeListener)) {
            com.baidu.ar.f.b.b(TAG, "setVolumeListener volumeListener has been added!!!");
            return;
        }
        if (this.iD == null) {
            this.iD = b.bA();
        }
        this.iH.lock();
        try {
            if (this.iF.size() == 0) {
                this.iD.setVolumeListener(this);
            }
            this.iF.add(volumeListener);
        } finally {
            this.iH.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void startAudio(AudioParams audioParams, EasyAudioCallback easyAudioCallback) {
        if (audioParams == null || easyAudioCallback == null) {
            com.baidu.ar.f.b.b(TAG, "AudioParams && EasyAudioCallback can not be null!!!");
            return;
        }
        if (this.iD == null) {
            this.iD = b.bA();
        }
        if (this.iE == null) {
            this.iE = new ArrayList<>();
        }
        if (this.iE.contains(easyAudioCallback)) {
            com.baidu.ar.f.b.b(TAG, "EasyAudio has been started!!!");
            return;
        }
        if (this.iD.isRunning()) {
            easyAudioCallback.onAudioStart(true, this.iD.bE());
        } else {
            this.iE.clear();
            this.iD.a(audioParams, this);
        }
        this.iG.lock();
        try {
            if (this.iE != null) {
                this.iE.add(easyAudioCallback);
            }
        } finally {
            this.iG.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void stopAudio(EasyAudioCallback easyAudioCallback) {
        if (easyAudioCallback == null) {
            com.baidu.ar.f.b.b(TAG, "EasyAudioCallback can not be null!!!");
        } else if (this.iE == null || !this.iE.contains(easyAudioCallback)) {
            com.baidu.ar.f.b.b(TAG, "Please confirm EasyAudio has been started!!!");
        } else if (this.iE.size() <= 1) {
            bO();
        } else {
            this.iG.lock();
            try {
                boolean remove = this.iE.remove(easyAudioCallback);
                this.iG.unlock();
                easyAudioCallback.onAudioStop(remove);
            } catch (Throwable th) {
                this.iG.unlock();
                throw th;
            }
        }
    }
}
