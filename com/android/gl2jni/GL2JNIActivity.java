package com.android.gl2jni;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.android.glview.GL2RenderJNIView;
/* loaded from: classes.dex */
public class GL2JNIActivity extends Activity {
    GL2RenderJNIView mView;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mView = new GL2RenderJNIView(getApplication());
        setContentView(this.mView);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mView.onPause();
        this.mView.close();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mView.onResume();
    }
}
