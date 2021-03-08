package com.baidu.live.am;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.ab;
import com.baidu.live.u.f;
/* loaded from: classes10.dex */
public interface c {

    /* loaded from: classes10.dex */
    public interface a {
        void VK();

        void VL();
    }

    boolean RI();

    void Rx();

    void a(a aVar);

    void a(f fVar);

    void b(FrameLayout frameLayout);

    View getEnterView();

    void onDestroy();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onStarted();

    void onStopped();

    void r(ab abVar);
}
