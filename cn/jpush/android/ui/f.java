package cn.jpush.android.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f implements Runnable {
    final /* synthetic */ PushActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PushActivity pushActivity) {
        this.a = pushActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FullScreenView fullScreenView;
        FullScreenView fullScreenView2;
        fullScreenView = this.a.d;
        if (fullScreenView != null) {
            fullScreenView2 = this.a.d;
            fullScreenView2.showTitleBar();
        }
    }
}
