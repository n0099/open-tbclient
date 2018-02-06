package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.AppCompatDelegateImplV9;
import android.support.v7.app.f;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c extends f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    @Override // android.support.v7.app.f, android.support.v7.app.e, android.support.v7.app.b
    Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    /* loaded from: classes2.dex */
    class a extends f.a {
        a(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            AppCompatDelegateImplV9.PanelFeatureState j = c.this.j(0, true);
            if (j != null && j.Dw != null) {
                super.onProvideKeyboardShortcuts(list, j.Dw, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }
    }
}
