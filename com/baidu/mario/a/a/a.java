package com.baidu.mario.a.a;

import android.util.Log;
import com.baidu.mario.a.e;
import com.baidu.mario.a.f;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class a implements com.baidu.mario.a.a, f {
    private static final String TAG = a.class.getSimpleName();
    private static volatile a adp;
    private com.baidu.mario.a.b ado;
    private ArrayList<b> mCallbackList;
    private ArrayList<f> mVolumeListenerList;
    private final Lock mAudioCallbackLock = new ReentrantLock(true);
    private final Lock mVolumeListenerLock = new ReentrantLock(true);

    public static a sx() {
        if (adp == null) {
            synchronized (a.class) {
                if (adp == null) {
                    adp = new a();
                }
            }
        }
        return adp;
    }

    private static void releaseInstance() {
        adp = null;
    }

    private a() {
    }

    public void a(e eVar, b bVar) {
        if (eVar == null || bVar == null) {
            Log.e(TAG, "AudioParams && EasyAudioCallback can not be null!!!");
            return;
        }
        if (this.ado == null) {
            this.ado = com.baidu.mario.a.b.sq();
        }
        if (this.mCallbackList == null) {
            this.mCallbackList = new ArrayList<>();
        }
        if (this.mCallbackList.contains(bVar)) {
            Log.e(TAG, "EasyAudio has been started!!!");
            return;
        }
        if (this.ado.isRunning()) {
            bVar.a(true, this.ado.sr());
        } else {
            this.mCallbackList.clear();
            this.ado.a(eVar, this);
        }
        this.mAudioCallbackLock.lock();
        try {
            this.mCallbackList.add(bVar);
        } finally {
            this.mAudioCallbackLock.unlock();
        }
    }

    public void a(b bVar) {
        if (bVar == null) {
            Log.e(TAG, "EasyAudioCallback can not be null!!!");
        } else if (this.mCallbackList != null && this.mCallbackList.contains(bVar)) {
            if (this.mCallbackList.size() > 1) {
                this.mAudioCallbackLock.lock();
                try {
                    boolean remove = this.mCallbackList.remove(bVar);
                    this.mAudioCallbackLock.unlock();
                    bVar.onAudioStop(remove);
                    return;
                } catch (Throwable th) {
                    this.mAudioCallbackLock.unlock();
                    throw th;
                }
            }
            stopAndReleaseAudioController();
        } else {
            Log.e(TAG, "Please confirm EasyAudio has been started!!!");
        }
    }

    public void release() {
        stopAndReleaseAudioController();
        releaseEasyAudio();
    }

    private synchronized void stopAndReleaseAudioController() {
        if (this.ado != null) {
            this.ado.stopAudio();
            this.ado.releaseAudio();
            this.ado = null;
        }
    }

    @Override // com.baidu.mario.a.a
    public void onAudioSetup(boolean z) {
        if (z) {
            if (this.ado != null) {
                this.ado.startAudio();
            }
        } else if (this.mCallbackList != null && this.mCallbackList.get(0) != null) {
            this.mCallbackList.get(0).a(false, null);
            release();
        }
    }

    @Override // com.baidu.mario.a.a
    public void onAudioStart(boolean z) {
        if (this.mCallbackList != null && this.mCallbackList.get(0) != null && this.ado != null) {
            this.mCallbackList.get(0).a(z, this.ado.sr());
        }
        if (!z) {
            release();
        }
    }

    @Override // com.baidu.mario.a.a
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        this.mAudioCallbackLock.lock();
        try {
            if (this.mCallbackList != null) {
                Iterator<b> it = this.mCallbackList.iterator();
                while (it.hasNext()) {
                    it.next().onAudioFrameAvailable(byteBuffer, i, j);
                }
            }
        } finally {
            this.mAudioCallbackLock.unlock();
        }
    }

    @Override // com.baidu.mario.a.a
    public void onAudioStop(boolean z) {
        if (this.mCallbackList != null && this.mCallbackList.get(0) != null) {
            this.mCallbackList.get(0).onAudioStop(z);
        }
    }

    @Override // com.baidu.mario.a.a
    public void onAudioRelease() {
        releaseEasyAudio();
    }

    private synchronized void releaseEasyAudio() {
        if (this.mCallbackList != null) {
            this.mCallbackList.clear();
        }
        this.mCallbackList = null;
        if (this.mVolumeListenerList != null) {
            this.mVolumeListenerList.clear();
        }
        this.mVolumeListenerList = null;
        releaseInstance();
    }

    @Override // com.baidu.mario.a.f
    public void onRealtimeVolume(int i) {
        this.mVolumeListenerLock.lock();
        try {
            if (this.mVolumeListenerList != null) {
                Iterator<f> it = this.mVolumeListenerList.iterator();
                while (it.hasNext()) {
                    it.next().onRealtimeVolume(i);
                }
            }
        } finally {
            this.mVolumeListenerLock.unlock();
        }
    }
}
