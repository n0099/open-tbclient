package com.baidu.cloudsdk.social.oauth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.au;
import com.av;
import com.aw;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
/* loaded from: classes.dex */
public class SocialOAuthActivity extends Activity {
    private static IBaiduListener a;
    private String b;
    private String c;
    private av e;
    private boolean d = false;
    private IBaiduListener f = new au(this);

    public static synchronized void setListener(IBaiduListener iBaiduListener) {
        synchronized (SocialOAuthActivity.class) {
            a = iBaiduListener;
        }
    }

    public void a() {
        this.d = true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.e != null) {
            this.e.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        if (bundle == null && (intent = getIntent()) != null) {
            bundle = intent.getExtras();
        }
        if (bundle == null) {
            finish();
        } else if (!Utils.isNetWorkAvaliable(this)) {
            Toast.makeText(this, SocialShareConfig.getInstance(this).getString("network_not_avaliable"), 0).show();
            if (a != null) {
                a.onError(new BaiduException("Network not Avaliable"));
            }
            finish();
        } else {
            this.b = bundle.getString(SocialConstants.PARAM_MEDIA_TYPE);
            this.c = bundle.getString("client_id");
            this.d = bundle.getBoolean(SocialConstants.PARAM_ACTIVITY_STATE_FLAG);
            this.e = new aw(this, this.c, this.f).ob(this.b);
            if (this.d) {
                return;
            }
            this.e.startAuthorize();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.e != null) {
            this.e.onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, this.b);
        bundle.putString("client_id", this.c);
        bundle.putBoolean(SocialConstants.PARAM_ACTIVITY_STATE_FLAG, this.d);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, this.b);
        bundle.putString("client_id", this.c);
        bundle.putBoolean(SocialConstants.PARAM_ACTIVITY_STATE_FLAG, this.d);
    }
}
