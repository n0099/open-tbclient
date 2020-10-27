package com.baidu.live.guess;

import android.content.DialogInterface;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public interface a {
        void Kq();

        void Kr();

        void a(b bVar);

        void b(b bVar);

        void onDismiss(DialogInterface dialogInterface);

        void onExit();
    }

    void Ko();

    void Kp();

    void a(DialogInterface.OnKeyListener onKeyListener);

    void dismiss();

    void eH(int i);

    void hu(String str);

    void hv(String str);

    void hw(String str);

    boolean isShowing();

    void setQuesContent(String str);

    void show();
}
