package com.baidu.searchbox.v8engine;
@NotProguard
/* loaded from: classes2.dex */
public class JsSerializeValue extends JsReleaser {
    public static final boolean DEBUG = false;
    public static final String TAG = "JsSerializeValue";
    public boolean mAutoRelease;

    public JsSerializeValue(long j, long j2, long j3) {
        super(j, j2, j3);
        this.mAutoRelease = true;
    }

    @Override // com.baidu.searchbox.v8engine.JsReleaser
    public void finalize() {
        super.finalize();
    }

    public boolean isAutoRelease() {
        return this.mAutoRelease;
    }

    public void setAutoRelease(boolean z) {
        this.mAutoRelease = z;
    }
}
