package com.baidu.live.guess;

import android.content.DialogInterface;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public interface a {
        void Mj();

        void Mk();

        void a(b bVar);

        void b(b bVar);

        void onDismiss(DialogInterface dialogInterface);

        void onExit();
    }

    void Mh();

    void Mi();

    void a(DialogInterface.OnKeyListener onKeyListener);

    void dismiss();

    void eZ(int i);

    void hV(String str);

    void hW(String str);

    void hX(String str);

    boolean isShowing();

    void setQuesContent(String str);

    void show();
}
