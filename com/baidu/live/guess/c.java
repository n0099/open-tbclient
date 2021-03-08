package com.baidu.live.guess;

import android.content.DialogInterface;
import android.view.ViewGroup;
/* loaded from: classes10.dex */
public interface c {

    /* loaded from: classes10.dex */
    public interface a {
        void Ji();

        void a(c cVar);

        void b(c cVar);

        void cg(boolean z);

        void onDismiss(DialogInterface dialogInterface);

        void onExit();

        void onTimeout();
    }

    void Jd();

    void Je();

    boolean Jf();

    int Jg();

    ViewGroup Jh();

    void a(DialogInterface.OnKeyListener onKeyListener);

    void ce(boolean z);

    void cf(boolean z);

    void dismiss();

    void dx(int i);

    void gY(String str);

    void gZ(String str);

    void ha(String str);

    void hb(String str);

    boolean isShowing();

    void setDoubleTicketContent(String str);

    void setDoubleTicketNumber(int i);

    void setDoubleTicketTitle(String str);

    void setQuesContent(String str);

    void show();
}
