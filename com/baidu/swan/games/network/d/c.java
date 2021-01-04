package com.baidu.swan.games.network.d;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes9.dex */
public class c {
    @V8JavascriptField
    public int progress;
    @V8JavascriptField
    public long totalBytesExpectedToSend;
    @V8JavascriptField
    public long totalBytesSent;

    public c(int i, long j, long j2) {
        this.progress = i;
        this.totalBytesExpectedToSend = j;
        this.totalBytesSent = j2;
    }

    public String toString() {
        return "TaskProgressData{progress=" + this.progress + ", fileTotalBytes=" + this.totalBytesExpectedToSend + ", totalBytesExpectedToSend=" + this.totalBytesSent + '}';
    }
}
