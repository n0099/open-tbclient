package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.b.g0.a.a;
import d.b.g0.a.e0.l.d;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.y0.e.b;
import d.b.g0.m.a.a.m;
/* loaded from: classes3.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static final boolean DEBUG = k.f45050a;
    public static final int INVALID_ANIM = 0;
    public static final String KEY_ERROR_FORBIDDEN_INFO = "swan_error_forbidden_info";
    public static final String KEY_SWAN_ERROR_TYPE = "swan_error_type";
    public static final String TAG = "SwanAppErrorActivity";
    public static final String TYPE_APP_FORBIDDEN = "type_app_forbidden";
    public static final String TYPE_NEED_UPDATE_SDK = "type_need_update_sdk";
    public static final String TYPE_NETWORK_ERROR = "type_network_error";
    public static final String TYPE_NORMAL = "type_normal";
    public static final String TYPE_PATH_FORBIDDEN = "type_path_forbidden";
    public String mErrorType;
    public ForbiddenInfo mForbiddenInfo;
    public b mLaunchInfo;
    public d.b.g0.a.x1.b mSkinDecorator = null;
    public int mEnterAnimWhenFinishing = 0;
    public int mExitAnimWhenFinishing = 0;

    private void loadFragment() {
        d dVar;
        m a2 = getSupportFragmentManager().a();
        if (getIntent() != null) {
            dVar = d.E2(this.mErrorType, this.mForbiddenInfo);
        } else if (this.mLaunchInfo == null) {
            if (DEBUG) {
                Log.e(TAG, "launchInfo is null,error");
                return;
            }
            return;
        } else {
            dVar = new d();
        }
        a2.a(f.ai_apps_error_layout, dVar);
        a2.c();
    }

    private void onErrorForSearchUBC() {
        d.b.g0.a.z1.l.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }

    private void parseIntent(Intent intent) {
        ForbiddenInfo forbiddenInfo;
        if (intent == null) {
            return;
        }
        this.mLaunchInfo = b.V0(intent);
        this.mForbiddenInfo = (ForbiddenInfo) intent.getParcelableExtra(KEY_ERROR_FORBIDDEN_INFO);
        if (TextUtils.isEmpty(this.mLaunchInfo.G()) && (forbiddenInfo = this.mForbiddenInfo) != null) {
            this.mLaunchInfo.q0(forbiddenInfo.appId);
        }
        this.mErrorType = intent.getStringExtra(KEY_SWAN_ERROR_TYPE);
    }

    private void setPendingTransition(int i, int i2) {
        this.mEnterAnimWhenFinishing = i;
        this.mExitAnimWhenFinishing = i2;
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

    public b getLaunchInfo() {
        return this.mLaunchInfo;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, d.b.g0.m.a.a.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        setPendingTransition(a.aiapps_hold, a.aiapps_slide_out_to_bottom);
        int V = k0.V(this);
        super.onCreate(bundle);
        k0.h(this, V);
        setContentView(g.aiapps_error_activity);
        parseIntent(getIntent());
        loadFragment();
        onErrorForSearchUBC();
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
            this.mSkinDecorator = new d.b.g0.a.x1.b();
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
        onNightModeCoverChanged(d.b.g0.a.w0.a.z().a());
    }
}
