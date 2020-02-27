package com.baidu.swan.games.x.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class a {
    @V8JavascriptField
    public int progress;
    @V8JavascriptField
    public long totalBytesExpectedToWrite;
    @V8JavascriptField
    public long totalBytesWritten;

    public String toString() {
        return "SubPackageProgressData{progress=" + this.progress + ", totalBytesWritten=" + this.totalBytesWritten + ", totalBytesExpectedToWrite=" + this.totalBytesExpectedToWrite + '}';
    }
}
