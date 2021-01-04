package com.baidu.ar.audio;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class EasyAudio implements IEasyAudio, VolumeListener, a {
    private static final String TAG = EasyAudio.class.getSimpleName();
    private static volatile EasyAudio iV;
    private b iQ;
    private ArrayList<EasyAudioCallback> iR;
    private ArrayList<VolumeListener> iS;
    private final Lock iT = new ReentrantLock(true);
    private final Lock iU = new ReentrantLock(true);

    private EasyAudio() {
    }

    private synchronized void ct() {
        if (this.iQ != null) {
            this.iQ.ch();
            this.iQ.ci();
            this.iQ = null;
        }
    }

    private synchronized void cu() {
        this.iT.lock();
        if (this.iR != null) {
            this.iR.clear();
            this.iR = null;
        }
        this.iT.unlock();
        if (this.iS != null) {
            this.iS.clear();
            this.iS = null;
        }
        releaseInstance();
    }

    public static EasyAudio getInstance() {
        if (iV == null) {
            synchronized (EasyAudio.class) {
                if (iV == null) {
                    iV = new EasyAudio();
                }
            }
        }
        return iV;
    }

    private static void releaseInstance() {
        iV = null;
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        this.iT.lock();
        try {
            if (this.iR != null) {
                Iterator<EasyAudioCallback> it = this.iR.iterator();
                while (it.hasNext()) {
                    it.next().onAudioFrameAvailable(byteBuffer, i, j);
                }
            }
        } finally {
            this.iT.unlock();
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioRelease() {
        cu();
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioSetup(boolean z) {
        if (z) {
            if (this.iQ != null) {
                this.iQ.startAudio();
            }
        } else if (this.iR == null || this.iR.get(0) == null) {
        } else {
            this.iR.get(0).onAudioStart(false, null);
            release();
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioStart(boolean z) {
        if (this.iR != null && this.iR.get(0) != null && this.iQ != null) {
            this.iR.get(0).onAudioStart(z, this.iQ.cj());
        }
        if (z) {
            return;
        }
        release();
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioStop(boolean z) {
        if (this.iR == null || this.iR.get(0) == null) {
            return;
        }
        this.iR.get(0).onAudioStop(z);
    }

    @Override // com.baidu.ar.audio.VolumeListener
    public void onRealtimeVolume(int i) {
        this.iU.lock();
        try {
            if (this.iS != null) {
                Iterator<VolumeListener> it = this.iS.iterator();
                while (it.hasNext()) {
                    it.next().onRealtimeVolume(i);
                }
            }
        } finally {
            this.iU.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void release() {
        ct();
        cu();
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void removeVolumeListener(VolumeListener volumeListener) {
        if (volumeListener == null) {
            com.baidu.ar.h.b.b(TAG, "VolumeListener can not be null!!!");
            return;
        }
        this.iU.lock();
        try {
            if (this.iS != null && this.iS.size() > 0 && this.iS.contains(volumeListener)) {
                this.iS.remove(volumeListener);
            }
        } finally {
            this.iU.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener == null) {
            com.baidu.ar.h.b.b(TAG, "VolumeListener can not be null!!!");
            return;
        }
        if (this.iS == null) {
            this.iS = new ArrayList<>();
        }
        if (this.iS.contains(volumeListener)) {
            com.baidu.ar.h.b.b(TAG, "setVolumeListener volumeListener has been added!!!");
            return;
        }
        if (this.iQ == null) {
            this.iQ = b.cf();
        }
        this.iU.lock();
        try {
            if (this.iS.size() == 0) {
                this.iQ.setVolumeListener(this);
            }
            this.iS.add(volumeListener);
        } finally {
            this.iU.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void startAudio(AudioParams audioParams, EasyAudioCallback easyAudioCallback) {
        if (audioParams == null || easyAudioCallback == null) {
            com.baidu.ar.h.b.b(TAG, "AudioParams && EasyAudioCallback can not be null!!!");
            return;
        }
        if (this.iQ == null) {
            this.iQ = b.cf();
        }
        if (this.iR == null) {
            this.iR = new ArrayList<>();
        }
        if (this.iR.contains(easyAudioCallback)) {
            com.baidu.ar.h.b.b(TAG, "EasyAudio has been started!!!");
            return;
        }
        if (this.iQ.isRunning()) {
            easyAudioCallback.onAudioStart(true, this.iQ.cj());
        } else {
            this.iR.clear();
            this.iQ.a(audioParams, this);
        }
        this.iT.lock();
        try {
            if (this.iR != null) {
                this.iR.add(easyAudioCallback);
            }
        } finally {
            this.iT.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void stopAudio(EasyAudioCallback easyAudioCallback) {
        if (easyAudioCallback == null) {
            com.baidu.ar.h.b.b(TAG, "EasyAudioCallback can not be null!!!");
        } else if (this.iR == null || !this.iR.contains(easyAudioCallback)) {
            com.baidu.ar.h.b.b(TAG, "Please confirm EasyAudio has been started!!!");
        } else if (this.iR.size() <= 1) {
            ct();
        } else {
            this.iT.lock();
            try {
                boolean remove = this.iR.remove(easyAudioCallback);
                this.iT.unlock();
                easyAudioCallback.onAudioStop(remove);
            } catch (Throwable th) {
                this.iT.unlock();
                throw th;
            }
        }
    }
}
