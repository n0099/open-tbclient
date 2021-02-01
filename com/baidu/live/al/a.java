package com.baidu.live.al;

import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.data.ab;
/* loaded from: classes11.dex */
public interface a {
    void H(Object obj);

    boolean Rn();

    void VA();

    void VB();

    void VC();

    void Vx();

    boolean Vy();

    void Vz();

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
