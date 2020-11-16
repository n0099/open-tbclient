package com.android.gl2jni;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.baidu.android.glview.GL2RenderJNIView;
/* loaded from: classes16.dex */
public class GL2JNIActivity extends Activity {
    GL2RenderJNIView mView;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        System.loadLibrary("glrender");
        this.mView = new GL2RenderJNIView(getApplication());
        setContentView(this.mView);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mView.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mView.onResume();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return this.mView.onTouchEvent(motionEvent);
    }
}
