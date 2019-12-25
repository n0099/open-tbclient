package com.baidu.swan.games.network.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes9.dex */
public class a {
    @V8JavascriptField
    public int progress;
    @V8JavascriptField
    public long totalBytesExpectedToWrite;
    @V8JavascriptField
    public long totalBytesWritten;

    public a(int i, long j, long j2) {
        this.progress = i;
        this.totalBytesExpectedToWrite = j;
        this.totalBytesWritten = j2;
    }

    public String toString() {
        return "TaskProgressData{progress=" + this.progress + ", totalBytesExpectedToWrite=" + this.totalBytesExpectedToWrite + ", totalBytesWritten=" + this.totalBytesWritten + '}';
    }
}
