package com.baidu.live.guess;

import android.content.DialogInterface;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public interface a {
        void Kh();

        void Ki();

        void a(b bVar);

        void b(b bVar);

        void onDismiss(DialogInterface dialogInterface);

        void onExit();
    }

    void Kf();

    void Kg();

    void a(DialogInterface.OnKeyListener onKeyListener);

    void dismiss();

    void eD(int i);

    void hv(String str);

    void hw(String str);

    void hx(String str);

    boolean isShowing();

    void setQuesContent(String str);

    void show();
}
