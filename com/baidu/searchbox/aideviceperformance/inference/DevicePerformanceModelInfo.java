package com.baidu.searchbox.aideviceperformance.inference;
/* loaded from: classes3.dex */
public class DevicePerformanceModelInfo {
    public String modelPath;
    public long versionCode;

    public DevicePerformanceModelInfo() {
        this.versionCode = -1L;
    }

    public String getModelPath() {
        return this.modelPath;
    }

    public DevicePerformanceModelInfo(String str, long j) {
        this.versionCode = -1L;
        this.modelPath = str;
        this.versionCode = j;
    }
}
