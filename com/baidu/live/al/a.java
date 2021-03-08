package com.baidu.live.al;

import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.data.ab;
/* loaded from: classes10.dex */
public interface a {
    void J(Object obj);

    boolean Rq();

    void VA();

    boolean VB();

    void VC();

    void VD();

    void VE();

    void VF();

    void a(FrameLayout frameLayout);

    void a(b bVar);

    void onDestroy();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onKeyboardVisibilityChanged(boolean z);

    void setMute(boolean z);

    void t(ab abVar);

    void v(ViewGroup viewGroup);

    void w(ViewGroup viewGroup);
}
