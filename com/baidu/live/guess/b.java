package com.baidu.live.guess;

import android.content.DialogInterface;
/* loaded from: classes11.dex */
public interface b {

    /* loaded from: classes11.dex */
    public interface a {
        void LH();

        void a(b bVar);

        void b(b bVar);

        void onDismiss(DialogInterface dialogInterface);

        void onExit();

        void onTimeout();
    }

    void LF();

    void LG();

    void a(DialogInterface.OnKeyListener onKeyListener);

    void dismiss();

    void eX(int i);

    void hG(String str);

    void hH(String str);

    void hI(String str);

    boolean isShowing();

    void setQuesContent(String str);

    void show();
}
