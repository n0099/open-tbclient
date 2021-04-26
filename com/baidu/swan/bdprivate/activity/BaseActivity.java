package com.baidu.swan.bdprivate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import d.a.h0.b.b;
/* loaded from: classes3.dex */
public class BaseActivity extends Activity {
    public static final int ACTION_BAR_TEXT_SIZE = 14;
    public boolean mIsSlideInFromBottom = false;

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.mIsSlideInFromBottom) {
            overridePendingTransition(b.aiapps_hold, b.aiapps_slide_out_to_bottom_zadjustment_top);
        } else {
            overridePendingTransition(b.aiapps_hold, b.aiapps_slide_out_to_right_zadjustment_top);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        if (this.mIsSlideInFromBottom) {
            overridePendingTransition(b.aiapps_slide_in_from_bottom, b.aiapps_hold);
        } else {
            overridePendingTransition(b.aiapps_slide_in_from_right, b.aiapps_hold);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.mIsSlideInFromBottom) {
            overridePendingTransition(b.aiapps_slide_in_from_bottom, b.aiapps_hold);
        } else {
            overridePendingTransition(b.aiapps_slide_in_from_right, b.aiapps_hold);
        }
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void setIsSlideInFromBottom(boolean z) {
        this.mIsSlideInFromBottom = z;
    }
}
