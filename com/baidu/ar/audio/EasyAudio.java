package com.baidu.ar.audio;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes11.dex */
public class EasyAudio implements IEasyAudio, VolumeListener, a {
    private static final String TAG = EasyAudio.class.getSimpleName();
    private static volatile EasyAudio iX;
    private b iS;
    private ArrayList<EasyAudioCallback> iT;
    private ArrayList<VolumeListener> iU;
    private final Lock iV = new ReentrantLock(true);
    private final Lock iW = new ReentrantLock(true);

    private EasyAudio() {
    }

    private synchronized void cc() {
        if (this.iS != null) {
            this.iS.bQ();
            this.iS.bR();
            this.iS = null;
        }
    }

    private synchronized void cd() {
        this.iV.lock();
        if (this.iT != null) {
            this.iT.clear();
            this.iT = null;
        }
        this.iV.unlock();
        if (this.iU != null) {
            this.iU.clear();
            this.iU = null;
        }
        releaseInstance();
    }

    public static EasyAudio getInstance() {
        if (iX == null) {
            synchronized (EasyAudio.class) {
                if (iX == null) {
                    iX = new EasyAudio();
                }
            }
        }
        return iX;
    }

    private static void releaseInstance() {
        iX = null;
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        this.iV.lock();
        try {
            if (this.iT != null) {
                Iterator<EasyAudioCallback> it = this.iT.iterator();
                while (it.hasNext()) {
                    it.next().onAudioFrameAvailable(byteBuffer, i, j);
                }
            }
        } finally {
            this.iV.unlock();
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioRelease() {
        cd();
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioSetup(boolean z) {
        if (z) {
            if (this.iS != null) {
                this.iS.startAudio();
            }
        } else if (this.iT == null || this.iT.get(0) == null) {
        } else {
            this.iT.get(0).onAudioStart(false, null);
            release();
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioStart(boolean z) {
        if (this.iT != null && this.iT.get(0) != null && this.iS != null) {
            this.iT.get(0).onAudioStart(z, this.iS.bS());
        }
        if (z) {
            return;
        }
        release();
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioStop(boolean z) {
        if (this.iT == null || this.iT.get(0) == null) {
            return;
        }
        this.iT.get(0).onAudioStop(z);
    }

    @Override // com.baidu.ar.audio.VolumeListener
    public void onRealtimeVolume(int i) {
        this.iW.lock();
        try {
            if (this.iU != null) {
                Iterator<VolumeListener> it = this.iU.iterator();
                while (it.hasNext()) {
                    it.next().onRealtimeVolume(i);
                }
            }
        } finally {
            this.iW.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void release() {
        cc();
        cd();
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void removeVolumeListener(VolumeListener volumeListener) {
        if (volumeListener == null) {
            com.baidu.ar.f.b.b(TAG, "VolumeListener can not be null!!!");
            return;
        }
        this.iW.lock();
        try {
            if (this.iU != null && this.iU.size() > 0 && this.iU.contains(volumeListener)) {
                this.iU.remove(volumeListener);
            }
        } finally {
            this.iW.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener == null) {
            com.baidu.ar.f.b.b(TAG, "VolumeListener can not be null!!!");
            return;
        }
        if (this.iU == null) {
            this.iU = new ArrayList<>();
        }
        if (this.iU.contains(volumeListener)) {
            com.baidu.ar.f.b.b(TAG, "setVolumeListener volumeListener has been added!!!");
            return;
        }
        if (this.iS == null) {
            this.iS = b.bO();
        }
        this.iW.lock();
        try {
            if (this.iU.size() == 0) {
                this.iS.setVolumeListener(this);
            }
            this.iU.add(volumeListener);
        } finally {
            this.iW.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void startAudio(AudioParams audioParams, EasyAudioCallback easyAudioCallback) {
        if (audioParams == null || easyAudioCallback == null) {
            com.baidu.ar.f.b.b(TAG, "AudioParams && EasyAudioCallback can not be null!!!");
            return;
        }
        if (this.iS == null) {
            this.iS = b.bO();
        }
        if (this.iT == null) {
            this.iT = new ArrayList<>();
        }
        if (this.iT.contains(easyAudioCallback)) {
            com.baidu.ar.f.b.b(TAG, "EasyAudio has been started!!!");
            return;
        }
        if (this.iS.isRunning()) {
            easyAudioCallback.onAudioStart(true, this.iS.bS());
        } else {
            this.iT.clear();
            this.iS.a(audioParams, this);
        }
        this.iV.lock();
        try {
            if (this.iT != null) {
                this.iT.add(easyAudioCallback);
            }
        } finally {
            this.iV.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void stopAudio(EasyAudioCallback easyAudioCallback) {
        if (easyAudioCallback == null) {
            com.baidu.ar.f.b.b(TAG, "EasyAudioCallback can not be null!!!");
        } else if (this.iT == null || !this.iT.contains(easyAudioCallback)) {
            com.baidu.ar.f.b.b(TAG, "Please confirm EasyAudio has been started!!!");
        } else if (this.iT.size() <= 1) {
            cc();
        } else {
            this.iV.lock();
            try {
                boolean remove = this.iT.remove(easyAudioCallback);
                this.iV.unlock();
                easyAudioCallback.onAudioStop(remove);
            } catch (Throwable th) {
                this.iV.unlock();
                throw th;
            }
        }
    }
}
