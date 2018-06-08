package com.baidu.ar.audio;
/* loaded from: classes3.dex */
public interface IAudio {
    void releaseAudio();

    void setVolumeListener(VolumeListener volumeListener);

    boolean setupAudio(AudioParams audioParams, AudioCallback audioCallback);

    void startAudio();

    void stopAudio();
}
