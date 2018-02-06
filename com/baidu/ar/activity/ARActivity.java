package com.baidu.ar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.baidu.ar.ARFragment;
import com.baidu.ar.R;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ARActivity extends FragmentActivity {
    private ARFragment a;

    private void a(Intent intent) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        String stringExtra = intent.getStringExtra("ar_id");
        String stringExtra2 = intent.getStringExtra(Constants.AR_KEY);
        String stringExtra3 = intent.getStringExtra(Constants.AR_CODED_KEY);
        int intExtra = intent.getIntExtra("ar_type", 0);
        String stringExtra4 = intent.getStringExtra(Constants.EXTRA_INFO);
        int intExtra2 = intent.getIntExtra(Constants.AR_LAUNCH_MODE, 0);
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(stringExtra2) && TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra3)) {
            try {
                jSONObject.put(Constants.AR_KEY, "8c1b5cd3075415fee5fca088b214e420");
                jSONObject.put("ar_type", intExtra);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            try {
                jSONObject.put(Constants.AR_KEY, stringExtra2);
                jSONObject.put("ar_id", stringExtra);
                jSONObject.put("ar_type", intExtra);
                jSONObject.put(Constants.AR_CODED_KEY, stringExtra3);
                jSONObject.put(Constants.AR_LAUNCH_MODE, intExtra2);
                jSONObject.put(Constants.EXTRA_INFO, stringExtra4);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        bundle.putString(Constants.AR_VALUE, jSONObject.toString());
        if (this.a != null) {
            this.a.release();
            this.a = null;
        }
        this.a = new ARFragment();
        this.a.setArguments(bundle);
        this.a.setARCallback(null);
        beginTransaction.replace(R.id.plugin_bdar_id_fragment_container, this.a);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        boolean z = false;
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null && fragments.size() > 0) {
            int i = 0;
            while (true) {
                if (i < fragments.size()) {
                    Fragment fragment = fragments.get(i);
                    if (fragment != null && (fragment instanceof ARFragment)) {
                        z = ((ARFragment) fragment).onFragmentBackPressed();
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        if (z) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b.a("onCreate");
        setContentView(R.layout.bdar_demo_track_ar_layout);
        setRequestedOrientation(1);
        if (findViewById(R.id.plugin_bdar_id_fragment_container) != null) {
            a(getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b.a("onDestroy");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        b.a("onNewIntent");
        a(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        b.a("onPause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b.a("onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        b.a("onStart");
    }
}
