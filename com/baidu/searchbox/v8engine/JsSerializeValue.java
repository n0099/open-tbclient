package com.baidu.searchbox.v8engine;
@NotProguard
/* loaded from: classes20.dex */
public class JsSerializeValue extends JsReleaser {
    public static final boolean DEBUG = false;
    public static final String TAG = "JsSerializeValue";
    private boolean mAutoRelease;

    public JsSerializeValue(long j, long j2, long j3) {
        super(j, j2, j3);
        this.mAutoRelease = true;
    }

    public void setAutoRelease(boolean z) {
        this.mAutoRelease = z;
    }

    public boolean isAutoRelease() {
        return this.mAutoRelease;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.v8engine.JsReleaser
    public void finalize() throws Throwable {
        super.finalize();
    }
}
