package com.baidu.swan.bdprivate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes11.dex */
public class BaseActivity extends Activity {
    private boolean cNJ = false;

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        if (this.cNJ) {
            overridePendingTransition(b.a.aiapps_slide_in_from_bottom, b.a.aiapps_hold);
        } else {
            overridePendingTransition(b.a.aiapps_slide_in_from_right, b.a.aiapps_hold);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (this.cNJ) {
            overridePendingTransition(b.a.aiapps_slide_in_from_bottom, b.a.aiapps_hold);
        } else {
            overridePendingTransition(b.a.aiapps_slide_in_from_right, b.a.aiapps_hold);
        }
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.cNJ) {
            overridePendingTransition(b.a.aiapps_hold, b.a.aiapps_slide_out_to_bottom_zadjustment_top);
        } else {
            overridePendingTransition(b.a.aiapps_hold, b.a.aiapps_slide_out_to_right_zadjustment_top);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
