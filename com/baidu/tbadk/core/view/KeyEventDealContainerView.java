package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes3.dex */
public class KeyEventDealContainerView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f12292e;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.f12292e = null;
        setFocusableInTouchMode(true);
        this.f12292e = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        a aVar;
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            a aVar2 = this.f12292e;
            if (aVar2 != null) {
                aVar2.a();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && (aVar = this.f12292e) != null) {
            aVar.b();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
