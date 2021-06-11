package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.l0.a.a;
import d.a.l0.a.f;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.g;
import d.a.l0.a.h0.g.e;
import d.a.l0.a.k;
import d.a.l0.a.v1.c.f.c;
import d.a.l0.a.v2.q0;
import d.a.l0.o.a.a.n;
/* loaded from: classes2.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static final boolean DEBUG = k.f46875a;
    public static final int INVALID_ANIM = 0;
    public static final String KEY_ERROR_FORBIDDEN_INFO = "swan_error_forbidden_info";
    public static final String KEY_ERROR_MENU_NOTICE_COUNT = "swan_error_menu_notice_count";
    public static final String KEY_ERROR_MENU_PRIVACY_COUNT = "swan_error_menu_privacy_count";
    public static final String KEY_SWAN_ERROR_TYPE = "swan_error_type";
    public static final int SHOW_MENU_NOTICE_DEFAULT = 0;
    public static final String TAG = "SwanAppErrorActivity";
    public static final String TYPE_APP_FORBIDDEN = "type_app_forbidden";
    public static final String TYPE_LOAD_V8_FAILED = "type_load_v8_failed";
    public static final String TYPE_NEED_UPDATE_SDK = "type_need_update_sdk";
    public static final String TYPE_NETWORK_ERROR = "type_network_error";
    public static final String TYPE_NORMAL = "type_normal";
    public static final String TYPE_PATH_FORBIDDEN = "type_path_forbidden";
    public String mErrorType;
    public ForbiddenInfo mForbiddenInfo;
    public b mLaunchInfo;
    public int mMenuNoticeCount;
    public int mMenuPrivateCount;
    public d.a.l0.a.g2.b mSkinDecorator = null;
    public int mEnterAnimWhenFinishing = 0;
    public int mExitAnimWhenFinishing = 0;

    private void loadFragment() {
        e eVar;
        n a2 = getSupportFragmentManager().a();
        if (getIntent() != null) {
            eVar = e.R2(this.mErrorType, this.mForbiddenInfo, this.mMenuNoticeCount, this.mMenuPrivateCount);
        } else if (this.mLaunchInfo == null) {
            if (DEBUG) {
                Log.e(TAG, "launchInfo is null,error");
                return;
            }
            return;
        } else {
            eVar = new e();
        }
        a2.a(f.ai_apps_error_layout, eVar);
        a2.d();
    }

    private void parseIntent(Intent intent) {
        ForbiddenInfo forbiddenInfo;
        if (intent == null) {
            return;
        }
        this.mLaunchInfo = b.b1(intent);
        this.mForbiddenInfo = (ForbiddenInfo) intent.getParcelableExtra(KEY_ERROR_FORBIDDEN_INFO);
        this.mMenuNoticeCount = intent.getIntExtra(KEY_ERROR_MENU_NOTICE_COUNT, 0);
        this.mMenuPrivateCount = intent.getIntExtra(KEY_ERROR_MENU_PRIVACY_COUNT, 0);
        if (TextUtils.isEmpty(this.mLaunchInfo.H()) && (forbiddenInfo = this.mForbiddenInfo) != null) {
            this.mLaunchInfo.u0(forbiddenInfo.appId);
        }
        this.mErrorType = intent.getStringExtra(KEY_SWAN_ERROR_TYPE);
    }

    private void setPendingTransition(int i2, int i3) {
        this.mEnterAnimWhenFinishing = i2;
        this.mExitAnimWhenFinishing = i3;
    }

    private void startExitActivityAnim() {
        if (this.mEnterAnimWhenFinishing == 0 && this.mExitAnimWhenFinishing == 0) {
            return;
        }
        overridePendingTransition(this.mEnterAnimWhenFinishing, this.mExitAnimWhenFinishing);
        this.mEnterAnimWhenFinishing = 0;
        this.mExitAnimWhenFinishing = 0;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        startExitActivityAnim();
    }

    public ForbiddenInfo getForbiddenInfo() {
        return this.mForbiddenInfo;
    }

    public b getLaunchInfo() {
        return this.mLaunchInfo;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, d.a.l0.o.a.a.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        setPendingTransition(a.aiapps_hold, a.aiapps_slide_out_to_bottom);
        int Z = q0.Z(this);
        super.onCreate(bundle);
        q0.g(this, Z);
        setContentView(g.aiapps_error_activity);
        parseIntent(getIntent());
        loadFragment();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        parseIntent(intent);
        loadFragment();
    }

    public void onNightModeCoverChanged(boolean z) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e(TAG, "activity or window is null");
                return;
            }
            return;
        }
        if (this.mSkinDecorator == null) {
            this.mSkinDecorator = new d.a.l0.a.g2.b();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.mSkinDecorator.a(viewGroup);
        } else {
            this.mSkinDecorator.b(viewGroup);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        updateCurrentNightMode();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        c i2;
        super.onStart();
        if (TextUtils.equals(this.mErrorType, TYPE_APP_FORBIDDEN) && (i2 = d.a.l0.a.v1.c.f.e.k().i(this.mForbiddenInfo.appId)) != null && i2.C()) {
            d.a.l0.a.c2.f.g0.a.g(this.mForbiddenInfo.appId);
        }
    }

    public void updateCurrentNightMode() {
        onNightModeCoverChanged(d.a.l0.a.c1.a.H().a());
    }
}
