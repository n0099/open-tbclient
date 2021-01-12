package com.baidu.ala.recorder.audio;
/* loaded from: classes14.dex */
public class AudioSamplesInfo {
    public int audioFormat;
    public int channelCount;
    public byte[] data;
    public long dts;
    public int length;
    public long pts;
    public int sampleRate;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("audioFormat=").append(this.audioFormat).append(" , ").append("channelCount=").append(this.channelCount).append(" , ").append("sampleRate=").append(this.sampleRate).append(" , ").append("length=").append(this.length).append(" , ").append("dts=").append(this.dts).append(" , ").append("pts=").append(this.pts).append(" , ");
        return sb.toString();
    }
}
