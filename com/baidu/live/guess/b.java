package com.baidu.live.guess;

import android.content.DialogInterface;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public interface a {
        void JW();

        void JX();

        void a(b bVar);

        void b(b bVar);

        void onDismiss(DialogInterface dialogInterface);

        void onExit();
    }

    void JU();

    void JV();

    void a(DialogInterface.OnKeyListener onKeyListener);

    void dismiss();

    void eG(int i);

    void hm(String str);

    void hn(String str);

    void ho(String str);

    boolean isShowing();

    void setQuesContent(String str);

    void show();
}
