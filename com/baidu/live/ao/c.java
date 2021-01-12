package com.baidu.live.ao;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.x;
import com.baidu.live.v.f;
/* loaded from: classes10.dex */
public interface c {

    /* loaded from: classes10.dex */
    public interface a {
        void TY();

        void TZ();
    }

    void PK();

    boolean PV();

    void a(a aVar);

    void a(f fVar);

    void b(FrameLayout frameLayout);

    View getEnterView();

    void onDestroy();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onStarted();

    void onStopped();

    void r(x xVar);
}
