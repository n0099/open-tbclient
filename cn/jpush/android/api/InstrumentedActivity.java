package cn.jpush.android.api;

import android.app.Activity;
/* loaded from: classes3.dex */
public class InstrumentedActivity extends Activity {
    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
