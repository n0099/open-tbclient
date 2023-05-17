package com.baidu.swan.bdprivate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BaseActivity extends Activity {
    public boolean a = false;

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.a) {
            overridePendingTransition(R.anim.obfuscated_res_0x7f01001d, R.anim.obfuscated_res_0x7f010025);
        } else {
            overridePendingTransition(R.anim.obfuscated_res_0x7f01001d, R.anim.obfuscated_res_0x7f010027);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        if (this.a) {
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001d);
        } else {
            overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.a) {
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001d);
        } else {
            overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
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
}
