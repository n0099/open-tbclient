package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.app.e;
import android.view.ActionMode;
import android.view.Window;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class f extends e {
    private final UiModeManager CP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.CP = (UiModeManager) context.getSystemService("uimode");
    }

    @Override // android.support.v7.app.e, android.support.v7.app.b
    Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.e
    public int ax(int i) {
        if (i == 0 && this.CP.getNightMode() == 0) {
            return -1;
        }
        return super.ax(i);
    }

    /* loaded from: classes2.dex */
    class a extends e.a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (f.this.isHandleNativeActionModesEnabled()) {
                switch (i) {
                    case 0:
                        return a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        @Override // android.support.v7.app.e.a, android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }
}
