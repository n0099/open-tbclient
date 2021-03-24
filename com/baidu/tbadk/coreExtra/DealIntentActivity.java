package com.baidu.tbadk.coreExtra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import d.b.b.a.a;
/* loaded from: classes3.dex */
public class DealIntentActivity extends Activity {
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        finish();
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        a.b(this);
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
        if (a.d(this) && a.a(i)) {
            return;
        }
        super.setRequestedOrientation(i);
    }
}
