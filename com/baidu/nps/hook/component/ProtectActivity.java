package com.baidu.nps.hook.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.util.HashMap;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/nps/hook/component/ProtectActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "", MissionEvent.MESSAGE_CREATE, "(Landroid/os/Bundle;)V", "<init>", "()V", "sdk_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ProtectActivity extends Activity {
    public HashMap _$_findViewCache;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.clear();
            } catch (Exception unused) {
            }
        }
        super.onCreate(bundle);
        try {
            setIntent(new Intent());
            finish();
        } catch (Exception unused2) {
        }
    }
}
