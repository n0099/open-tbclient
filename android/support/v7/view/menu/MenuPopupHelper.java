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
    private final int HP;
    private final int HQ;
    private final boolean HR;
    private int HZ;
    private boolean Ie;
    private MenuPresenter.Callback Ig;
    private PopupWindow.OnDismissListener Ii;
    private e JD;
    private final PopupWindow.OnDismissListener JE;
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
        this.HZ = GravityCompat.START;
        this.JE = new PopupWindow.OnDismissListener() { // from class: android.support.v7.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.onDismiss();
            }
        };
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.oa = view;
        this.HR = z;
        this.HP = i;
        this.HQ = i2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.Ii = onDismissListener;
    }

    public void setAnchorView(View view) {
        this.oa = view;
    }

    public void setForceShowIcon(boolean z) {
        this.Ie = z;
        if (this.JD != null) {
            this.JD.setForceShowIcon(z);
        }
    }

    public void setGravity(int i) {
        this.HZ = i;
    }

    public int getGravity() {
        return this.HZ;
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
        if (this.JD == null) {
            this.JD = fc();
        }
        return this.JD;
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.oa == null) {
            return false;
        }
        b(0, 0, false, false);
        return true;
    }

    public boolean tryShow(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.oa == null) {
            return false;
        }
        b(i, i2, true, true);
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
            gVar = new CascadingMenuPopup(this.mContext, this.oa, this.HP, this.HQ, this.HR);
        } else {
            gVar = new g(this.mContext, this.mMenu, this.oa, this.HP, this.HQ, this.HR);
        }
        gVar.c(this.mMenu);
        gVar.setOnDismissListener(this.JE);
        gVar.setAnchorView(this.oa);
        gVar.setCallback(this.Ig);
        gVar.setForceShowIcon(this.Ie);
        gVar.setGravity(this.HZ);
        return gVar;
    }

    private void b(int i, int i2, boolean z, boolean z2) {
        e popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            if ((GravityCompat.getAbsoluteGravity(this.HZ, ViewCompat.getLayoutDirection(this.oa)) & 7) == 5) {
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
            this.JD.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDismiss() {
        this.JD = null;
        if (this.Ii != null) {
            this.Ii.onDismiss();
        }
    }

    public boolean isShowing() {
        return this.JD != null && this.JD.isShowing();
    }

    public void setPresenterCallback(MenuPresenter.Callback callback) {
        this.Ig = callback;
        if (this.JD != null) {
            this.JD.setCallback(callback);
        }
    }
}
