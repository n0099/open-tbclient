package com.baidu.live.guess;

import android.content.DialogInterface;
/* loaded from: classes10.dex */
public interface b {

    /* loaded from: classes10.dex */
    public interface a {
        void HM();

        void a(b bVar);

        void b(b bVar);

        void onDismiss(DialogInterface dialogInterface);

        void onExit();

        void onTimeout();
    }

    void HK();

    void HL();

    void a(DialogInterface.OnKeyListener onKeyListener);

    void dismiss();

    void dr(int i);

    void gv(String str);

    void gw(String str);

    void gx(String str);

    boolean isShowing();

    void setQuesContent(String str);

    void show();
}
