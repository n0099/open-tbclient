package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareCallPacking;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ShareResultProxyActivity extends Activity implements NoProguard {
    public static final String KEY_EXTRA_PARAMS = "key_extra_params";
    public static final String KEY_PKG = "key_pkg";
    public static final String KEY_SESSION_ID = "key_session_id";
    public static final String KEY_TRACE_ID = "key_trace_id";
    public static final String KEY_URL = "key_url";
    public static final String KEY_VERSION = "key_version";

    /* renamed from: h  reason: collision with root package name */
    public static final String f10763h = "ShareResultProxyActivity";

    /* renamed from: i  reason: collision with root package name */
    public static final String f10764i = "key_launch_share_activity_status";

    /* renamed from: a  reason: collision with root package name */
    public String f10765a;

    /* renamed from: b  reason: collision with root package name */
    public String f10766b;

    /* renamed from: c  reason: collision with root package name */
    public String f10767c;

    /* renamed from: d  reason: collision with root package name */
    public String f10768d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<PassNameValuePair> f10769e;

    /* renamed from: f  reason: collision with root package name */
    public String f10770f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10771g;

    private void a() {
        this.f10771g = true;
        Intent intent = getIntent();
        this.f10765a = intent.getStringExtra(KEY_PKG);
        this.f10766b = intent.getStringExtra("key_url");
        this.f10767c = intent.getStringExtra(KEY_TRACE_ID);
        this.f10768d = intent.getStringExtra("key_session_id");
        this.f10769e = (ArrayList) intent.getSerializableExtra(KEY_EXTRA_PARAMS);
        this.f10770f = intent.getStringExtra("key_version");
        new ShareCallPacking().startLoginShareActivityForResult(this, this.f10765a, this.f10766b, this.f10767c, this.f10768d, this.f10769e, this.f10770f, "product");
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 20001) {
            CoreViewRouter.getInstance().onShareLoginActivityResult(i2, i3, intent, "");
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = 1;
        attributes.height = 1;
        attributes.type = 2002;
        attributes.flags = 32;
        window.setAttributes(attributes);
        if (bundle != null) {
            this.f10771g = bundle.getBoolean(f10764i, false);
        }
        if (this.f10771g) {
            return;
        }
        a();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(f10764i, this.f10771g);
        super.onSaveInstanceState(bundle);
    }
}
