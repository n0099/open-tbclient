package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
@RestrictTo
/* loaded from: classes2.dex */
public class MenuPopupHelper {
    private final int HQ;
    private final int HR;
    private final boolean HS;
    private int Ia;
    private boolean If;
    private MenuPresenter.Callback Ih;
    private PopupWindow.OnDismissListener Ij;
    private e JE;
    private final PopupWindow.OnDismissListener JF;
    private final Context mContext;
    private final MenuBuilder mMenu;
    private View oa;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder) {
        this(context, menuBuilder, null, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view) {
        this(context, menuBuilder, view, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.Ia = GravityCompat.START;
        this.JF = new PopupWindow.OnDismissListener() { // from class: android.support.v7.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.onDismiss();
            }
        };
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.oa = view;
        this.HS = z;
        this.HQ = i;
        this.HR = i2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.Ij = onDismissListener;
    }

    public void setAnchorView(View view) {
        this.oa = view;
    }

    public void setForceShowIcon(boolean z) {
        this.If = z;
        if (this.JE != null) {
            this.JE.setForceShowIcon(z);
        }
    }

    public void setGravity(int i) {
        this.Ia = i;
    }

    public int getGravity() {
        return this.Ia;
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void show(int i, int i2) {
        if (!tryShow(i, i2)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public e getPopup() {
        if (this.JE == null) {
            this.JE = fc();
        }
        return this.JE;
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.oa == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public boolean tryShow(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.oa == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    private e fc() {
        e gVar;
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (Build.VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        } else {
            point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        if (Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
            gVar = new CascadingMenuPopup(this.mContext, this.oa, this.HQ, this.HR, this.HS);
        } else {
            gVar = new g(this.mContext, this.mMenu, this.oa, this.HQ, this.HR, this.HS);
        }
        gVar.c(this.mMenu);
        gVar.setOnDismissListener(this.JF);
        gVar.setAnchorView(this.oa);
        gVar.setCallback(this.Ih);
        gVar.setForceShowIcon(this.If);
        gVar.setGravity(this.Ia);
        return gVar;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        e popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            if ((GravityCompat.getAbsoluteGravity(this.Ia, ViewCompat.getLayoutDirection(this.oa)) & 7) == 5) {
                i -= this.oa.getWidth();
            }
            popup.setHorizontalOffset(i);
            popup.setVerticalOffset(i2);
            int i3 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.setEpicenterBounds(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        popup.show();
    }

    public void dismiss() {
        if (isShowing()) {
            this.JE.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDismiss() {
        this.JE = null;
        if (this.Ij != null) {
            this.Ij.onDismiss();
        }
    }

    public boolean isShowing() {
        return this.JE != null && this.JE.isShowing();
    }

    public void setPresenterCallback(MenuPresenter.Callback callback) {
        this.Ih = callback;
        if (this.JE != null) {
            this.JE.setCallback(callback);
        }
    }
}
