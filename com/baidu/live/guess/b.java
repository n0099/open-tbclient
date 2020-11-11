package com.baidu.live.guess;

import android.content.DialogInterface;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public interface a {
        void KQ();

        void KR();

        void a(b bVar);

        void b(b bVar);

        void onDismiss(DialogInterface dialogInterface);

        void onExit();
    }

    void KO();

    void KP();

    void a(DialogInterface.OnKeyListener onKeyListener);

    void dismiss();

    void eH(int i);

    void hB(String str);

    void hC(String str);

    void hD(String str);

    boolean isShowing();

    void setQuesContent(String str);

    void show();
}
