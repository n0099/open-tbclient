package com.baidu.live.guess;

import android.content.DialogInterface;
import android.view.ViewGroup;
/* loaded from: classes11.dex */
public interface c {

    /* loaded from: classes11.dex */
    public interface a {
        void Jf();

        void a(c cVar);

        void b(c cVar);

        void cg(boolean z);

        void onDismiss(DialogInterface dialogInterface);

        void onExit();

        void onTimeout();
    }

    void Ja();

    void Jb();

    boolean Jc();

    int Jd();

    ViewGroup Je();

    void a(DialogInterface.OnKeyListener onKeyListener);

    void ce(boolean z);

    void cf(boolean z);

    void dismiss();

    void dw(int i);

    void gS(String str);

    void gT(String str);

    void gU(String str);

    void gV(String str);

    boolean isShowing();

    void setDoubleTicketContent(String str);

    void setDoubleTicketNumber(int i);

    void setDoubleTicketTitle(String str);

    void setQuesContent(String str);

    void show();
}
