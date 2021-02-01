package com.baidu.ala.recorder.audio;
/* loaded from: classes6.dex */
public class AlaAudioConfig {
    public int channels;
    public boolean enableAPM;
    public int format;
    public int mode;
    public int sampleRate;

    public AlaAudioConfig(int i, int i2, int i3) {
        this.sampleRate = 44100;
        this.channels = 1;
        this.format = 16;
        this.mode = 1;
        this.enableAPM = true;
        this.sampleRate = i;
        this.format = i2;
        this.channels = isStereo(i2) ? 2 : 1;
        this.mode = i3;
    }

    public AlaAudioConfig(AlaAudioConfig alaAudioConfig) {
        this.sampleRate = 44100;
        this.channels = 1;
        this.format = 16;
        this.mode = 1;
        this.enableAPM = true;
        this.sampleRate = alaAudioConfig.sampleRate;
        this.channels = alaAudioConfig.channels;
        this.format = alaAudioConfig.format;
        this.mode = alaAudioConfig.mode;
    }

    public AlaAudioConfig() {
        this.sampleRate = 44100;
        this.channels = 1;
        this.format = 16;
        this.mode = 1;
        this.enableAPM = true;
    }

    public static boolean isStereo(int i) {
        return i == 12 || i == 12;
    }

    public boolean isEqual(AlaAudioConfig alaAudioConfig) {
        return alaAudioConfig != null && alaAudioConfig.channels == this.channels && alaAudioConfig.sampleRate == this.sampleRate && alaAudioConfig.mode == this.mode && alaAudioConfig.format == this.format;
    }
}
