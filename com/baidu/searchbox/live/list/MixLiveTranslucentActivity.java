package com.baidu.searchbox.live.list;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.searchbox.live.service.MixNotifyBackgroundService;
import java.util.HashMap;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/live/list/MixLiveTranslucentActivity;", "Lcom/baidu/searchbox/live/list/MixLiveActivity;", "", "finish", "()V", "finishByNotifyWithNoAnim", "", "getCaptureBgColor", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "overrideEnterAnim", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixLiveTranslucentActivity extends MixLiveActivity {
    public HashMap _$_findViewCache;

    @Override // com.baidu.searchbox.live.list.MixLiveActivity
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view2 == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view2;
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity, android.app.Activity
    public void finish() {
        super.finish();
        ServiceLocator.Companion.unregisterGlobalService(MixNotifyBackgroundService.class);
    }

    public final void finishByNotifyWithNoAnim() {
        super.finish();
        overridePendingTransition(0, 0);
        ServiceLocator.Companion.unregisterGlobalService(MixNotifyBackgroundService.class);
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity
    public int getCaptureBgColor() {
        if (!getIntent().getBooleanExtra("enterWithAnimation", false)) {
            return 0;
        }
        return -16777216;
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity
    public void overrideEnterAnim() {
        if (getIntent().getBooleanExtra("enterWithAnimation", false)) {
            super.overrideEnterAnim();
        } else {
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity, com.baidu.searchbox.live.shell.LiveBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ServiceLocator.Companion.registerGlobalServices(MixNotifyBackgroundService.class, new MixNotifyBackgroundService() { // from class: com.baidu.searchbox.live.list.MixLiveTranslucentActivity$onCreate$1
            @Override // com.baidu.searchbox.live.service.MixNotifyBackgroundService
            public void hideActivityBackground() {
                View rootView = MixLiveTranslucentActivity.this.getRootView();
                if (rootView != null) {
                    rootView.setBackgroundColor(0);
                }
            }

            @Override // com.baidu.searchbox.live.service.MixNotifyBackgroundService
            public void notifyActivityFinish() {
                MixLiveTranslucentActivity.this.finishByNotifyWithNoAnim();
            }

            @Override // com.baidu.searchbox.live.service.MixNotifyBackgroundService
            public void showActivityBackground() {
                View rootView = MixLiveTranslucentActivity.this.getRootView();
                if (rootView != null) {
                    rootView.setBackgroundColor(-16777216);
                }
            }
        });
    }
}
