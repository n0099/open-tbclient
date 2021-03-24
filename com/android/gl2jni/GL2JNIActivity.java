package com.android.gl2jni;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.baidu.android.glview.GL2RenderJNIView;
/* loaded from: classes.dex */
public class GL2JNIActivity extends Activity {
    public GL2RenderJNIView mView;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        System.loadLibrary("glrender");
        GL2RenderJNIView gL2RenderJNIView = new GL2RenderJNIView(getApplication());
        this.mView = gL2RenderJNIView;
        setContentView(gL2RenderJNIView);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mView.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mView.onResume();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return this.mView.onTouchEvent(motionEvent);
    }
}
