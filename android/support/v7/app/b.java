package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class b extends AppCompatDelegate {
    private static boolean Cp;
    private static final boolean Cq;
    private static final int[] Cr;
    final Window BG;
    boolean CA;
    private boolean CB;
    final Window.Callback Cs;
    final Window.Callback Ct;
    final AppCompatCallback Cu;
    ActionBar Cv;
    boolean Cw;
    boolean Cx;
    boolean Cy;
    boolean Cz;
    MenuInflater lh;
    final Context mContext;
    private boolean mIsStarted;
    private CharSequence mTitle;

    abstract ActionMode a(ActionMode.Callback callback);

    abstract void dU();

    abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    abstract void f(CharSequence charSequence);

    abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    abstract boolean onMenuOpened(int i, Menu menu);

    abstract void onPanelClosed(int i, Menu menu);

    static {
        Cq = Build.VERSION.SDK_INT < 21;
        if (Cq && !Cp) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: android.support.v7.app.b.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    if (f(th)) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }

                private boolean f(Throwable th) {
                    String message;
                    if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                        return false;
                    }
                    return message.contains("drawable") || message.contains("Drawable");
                }
            });
            Cp = true;
        }
        Cr = new int[]{16842836};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, Window window, AppCompatCallback appCompatCallback) {
        this.mContext = context;
        this.BG = window;
        this.Cu = appCompatCallback;
        this.Cs = this.BG.getCallback();
        if (this.Cs instanceof C0009b) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.Ct = a(this.Cs);
        this.BG.setCallback(this.Ct);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, Cr);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            this.BG.setBackgroundDrawable(drawableIfKnown);
        }
        obtainStyledAttributes.recycle();
    }

    Window.Callback a(Window.Callback callback) {
        return new C0009b(callback);
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public ActionBar getSupportActionBar() {
        dU();
        return this.Cv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ActionBar dV() {
        return this.Cv;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public MenuInflater getMenuInflater() {
        if (this.lh == null) {
            dU();
            this.lh = new SupportMenuInflater(this.Cv != null ? this.Cv.getThemedContext() : this.mContext);
        }
        return this.lh;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setLocalNightMode(int i) {
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context getActionBarThemedContext() {
        Context context = null;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            context = supportActionBar.getThemedContext();
        }
        if (context == null) {
            return this.mContext;
        }
        return context;
    }

    /* loaded from: classes2.dex */
    private class a implements ActionBarDrawerToggle.Delegate {
        a() {
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return b.this.getActionBarThemedContext();
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            ActionBar supportActionBar = b.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar supportActionBar = b.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            ActionBar supportActionBar = b.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onStart() {
        this.mIsStarted = true;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onStop() {
        this.mIsStarted = false;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onDestroy() {
        this.CB = true;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z) {
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return false;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean applyDayNight() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isDestroyed() {
        return this.CB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Window.Callback dW() {
        return this.BG.getCallback();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        f(charSequence);
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CharSequence getTitle() {
        return this.Cs instanceof Activity ? ((Activity) this.Cs).getTitle() : this.mTitle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.app.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0009b extends WindowCallbackWrapper {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C0009b(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return b.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || b.this.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
                return onPreparePanel;
            }
            return onPreparePanel;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            b.this.onMenuOpened(i, menu);
            return true;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            b.this.onPanelClosed(i, menu);
        }
    }
}
