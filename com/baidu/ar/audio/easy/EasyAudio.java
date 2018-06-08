package com.baidu.ar.audio.easy;

import android.util.Log;
import com.baidu.ar.audio.AudioCallback;
import com.baidu.ar.audio.AudioController;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.audio.VolumeListener;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class EasyAudio implements AudioCallback, VolumeListener, IEasyAudio {
    private static final String TAG = EasyAudio.class.getSimpleName();
    private static volatile EasyAudio sInstance;
    private AudioController mAudioController;
    private ArrayList<EasyAudioCallback> mCallbackList;
    private ArrayList<VolumeListener> mVolumeListenerList;
    private final Lock mAudioCallbackLock = new ReentrantLock(true);
    private final Lock mVolumeListenerLock = new ReentrantLock(true);

    private EasyAudio() {
    }

    public static EasyAudio getInstance() {
        if (sInstance == null) {
            synchronized (EasyAudio.class) {
                if (sInstance == null) {
                    sInstance = new EasyAudio();
                }
            }
        }
        return sInstance;
    }

    private void releaseEasyAudio() {
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

    private static void releaseInstance() {
        sInstance = null;
    }

    private void stopAndReleaseAudioController() {
        if (this.mAudioController != null) {
            this.mAudioController.stopAudio();
            this.mAudioController.releaseAudio();
            this.mAudioController = null;
        }
    }

    @Override // com.baidu.ar.audio.AudioCallback
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        this.mAudioCallbackLock.lock();
        try {
            if (this.mCallbackList != null) {
                Iterator<EasyAudioCallback> it = this.mCallbackList.iterator();
                while (it.hasNext()) {
                    it.next().onAudioFrameAvailable(byteBuffer, i, j);
                }
            }
        } finally {
            this.mAudioCallbackLock.unlock();
        }
    }

    @Override // com.baidu.ar.audio.AudioCallback
    public void onAudioRelease() {
        releaseEasyAudio();
    }

    @Override // com.baidu.ar.audio.AudioCallback
    public void onAudioSetup(boolean z) {
        if (z) {
            if (this.mAudioController != null) {
                this.mAudioController.startAudio();
            }
        } else if (this.mCallbackList == null || this.mCallbackList.get(0) == null) {
        } else {
            this.mCallbackList.get(0).onAudioStart(false, null);
            release();
        }
    }

    @Override // com.baidu.ar.audio.AudioCallback
    public void onAudioStart(boolean z) {
        if (this.mCallbackList != null && this.mCallbackList.get(0) != null && this.mAudioController != null) {
            this.mCallbackList.get(0).onAudioStart(z, this.mAudioController.getAudioParams());
        }
        if (z) {
            return;
        }
        release();
    }

    @Override // com.baidu.ar.audio.AudioCallback
    public void onAudioStop(boolean z) {
        if (this.mCallbackList == null || this.mCallbackList.get(0) == null) {
            return;
        }
        this.mCallbackList.get(0).onAudioStop(z);
    }

    @Override // com.baidu.ar.audio.VolumeListener
    public void onRealtimeVolume(int i) {
        this.mVolumeListenerLock.lock();
        try {
            if (this.mVolumeListenerList != null) {
                Iterator<VolumeListener> it = this.mVolumeListenerList.iterator();
                while (it.hasNext()) {
                    it.next().onRealtimeVolume(i);
                }
            }
        } finally {
            this.mVolumeListenerLock.unlock();
        }
    }

    @Override // com.baidu.ar.audio.easy.IEasyAudio
    public void release() {
        stopAndReleaseAudioController();
        releaseEasyAudio();
    }

    @Override // com.baidu.ar.audio.easy.IEasyAudio
    public void removeVolumeListener(VolumeListener volumeListener) {
        if (volumeListener == null) {
            Log.e(TAG, "VolumeListener can not be null!!!");
            return;
        }
        this.mVolumeListenerLock.lock();
        try {
            if (this.mVolumeListenerList != null && this.mVolumeListenerList.size() > 0 && this.mVolumeListenerList.contains(volumeListener)) {
                this.mVolumeListenerList.remove(volumeListener);
            }
        } finally {
            this.mVolumeListenerLock.unlock();
        }
    }

    @Override // com.baidu.ar.audio.easy.IEasyAudio
    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener == null) {
            Log.e(TAG, "VolumeListener can not be null!!!");
            return;
        }
        if (this.mVolumeListenerList == null) {
            this.mVolumeListenerList = new ArrayList<>();
        }
        if (this.mVolumeListenerList.contains(volumeListener)) {
            Log.e(TAG, "setVolumeListener volumeListener has been added!!!");
            return;
        }
        if (this.mAudioController == null) {
            this.mAudioController = AudioController.getInstance();
        }
        this.mVolumeListenerLock.lock();
        try {
            if (this.mVolumeListenerList.size() == 0) {
                this.mAudioController.setVolumeListener(this);
            }
            this.mVolumeListenerList.add(volumeListener);
        } finally {
            this.mVolumeListenerLock.unlock();
        }
    }

    @Override // com.baidu.ar.audio.easy.IEasyAudio
    public void startAudio(AudioParams audioParams, EasyAudioCallback easyAudioCallback) {
        if (audioParams == null || easyAudioCallback == null) {
            Log.e(TAG, "AudioParams && EasyAudioCallback can not be null!!!");
            return;
        }
        if (this.mAudioController == null) {
            this.mAudioController = AudioController.getInstance();
        }
        if (this.mCallbackList == null) {
            this.mCallbackList = new ArrayList<>();
        }
        if (this.mCallbackList.contains(easyAudioCallback)) {
            Log.e(TAG, "EasyAudio has been started!!!");
            return;
        }
        if (this.mAudioController.isRunning()) {
            easyAudioCallback.onAudioStart(true, this.mAudioController.getAudioParams());
        } else {
            this.mCallbackList.clear();
            this.mAudioController.setupAudio(audioParams, this);
        }
        this.mAudioCallbackLock.lock();
        try {
            this.mCallbackList.add(easyAudioCallback);
        } finally {
            this.mAudioCallbackLock.unlock();
        }
    }

    @Override // com.baidu.ar.audio.easy.IEasyAudio
    public void stopAudio(EasyAudioCallback easyAudioCallback) {
        if (easyAudioCallback == null) {
            Log.e(TAG, "EasyAudioCallback can not be null!!!");
        } else if (this.mCallbackList == null || !this.mCallbackList.contains(easyAudioCallback)) {
            Log.e(TAG, "Please confirm EasyAudio has been started!!!");
        } else if (this.mCallbackList.size() <= 1) {
            stopAndReleaseAudioController();
        } else {
            this.mAudioCallbackLock.lock();
            try {
                boolean remove = this.mCallbackList.remove(easyAudioCallback);
                this.mAudioCallbackLock.unlock();
                easyAudioCallback.onAudioStop(remove);
            } catch (Throwable th) {
                this.mAudioCallbackLock.unlock();
                throw th;
            }
        }
    }
}
