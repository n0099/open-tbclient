package com.baidu.live.aj;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.data.w;
import com.baidu.live.s.f;
/* loaded from: classes4.dex */
public interface c {

    /* loaded from: classes4.dex */
    public interface a {
        void Ui();

        void Uj();
    }

    void Qd();

    boolean Qn();

    void a(a aVar);

    void a(f fVar);

    void b(FrameLayout frameLayout);

    View getEnterView();

    void onDestroy();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onStarted();

    void onStopped();

    void q(w wVar);
}
