package com.baidu.swan.bdprivate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class BaseActivity extends Activity {
    public boolean a = false;

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.a) {
            overridePendingTransition(R.anim.obfuscated_res_0x7f01001c, R.anim.obfuscated_res_0x7f010024);
        } else {
            overridePendingTransition(R.anim.obfuscated_res_0x7f01001c, R.anim.obfuscated_res_0x7f010026);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        if (this.a) {
            overridePendingTransition(R.anim.obfuscated_res_0x7f010021, R.anim.obfuscated_res_0x7f01001c);
        } else {
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.a) {
            overridePendingTransition(R.anim.obfuscated_res_0x7f010021, R.anim.obfuscated_res_0x7f01001c);
        } else {
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
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
