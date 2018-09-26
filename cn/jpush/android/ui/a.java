package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
/* loaded from: classes3.dex */
final class a implements View.OnClickListener {
    final /* synthetic */ FullScreenView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FullScreenView fullScreenView) {
        this.a = fullScreenView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        context = this.a.mContext;
        if (context != null) {
            context2 = this.a.mContext;
            ((Activity) context2).onBackPressed();
        }
    }
}
