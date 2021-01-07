package com.baidu.live.an;

import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.data.x;
/* loaded from: classes11.dex */
public interface a {
    void H(Object obj);

    boolean Ty();

    void XI();

    boolean XJ();

    void XK();

    void XL();

    void XM();

    void a(FrameLayout frameLayout);

    void a(b bVar);

    void onDestroy();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onKeyboardVisibilityChanged(boolean z);

    void setMute(boolean z);

    void t(x xVar);

    void x(ViewGroup viewGroup);

    void y(ViewGroup viewGroup);
}
