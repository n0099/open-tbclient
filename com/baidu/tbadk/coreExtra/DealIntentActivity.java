package com.baidu.tbadk.coreExtra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.baidu.adp.base.a;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class DealIntentActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        a.j(this);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            intent.setClass(this, DealIntentService.class);
            startService(intent);
        }
        finish();
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (!a.k(this) || !a.Z(i)) {
            super.setRequestedOrientation(i);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        finish();
        return super.dispatchTouchEvent(motionEvent);
    }
}
