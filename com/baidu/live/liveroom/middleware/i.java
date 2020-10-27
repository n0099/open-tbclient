package com.baidu.live.liveroom.middleware;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
/* loaded from: classes4.dex */
public interface i {
    void cg(boolean z);

    void onActivityResult(int i, int i2, Intent intent);

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onPause();

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onResume();

    void onStop();

    void s(Activity activity);
}
