package com.baidu.tbadk.coreExtra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes2.dex */
public class DealIntentActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            intent.setClass(this, DealIntentService.class);
            startService(intent);
        }
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        finish();
        return super.dispatchTouchEvent(motionEvent);
    }
}
