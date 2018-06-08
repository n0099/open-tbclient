package com.baidu.ar.audio.easy;

import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.audio.VolumeListener;
/* loaded from: classes3.dex */
public interface IEasyAudio {
    void release();

    void removeVolumeListener(VolumeListener volumeListener);

    void setVolumeListener(VolumeListener volumeListener);

    void startAudio(AudioParams audioParams, EasyAudioCallback easyAudioCallback);

    void stopAudio(EasyAudioCallback easyAudioCallback);
}
