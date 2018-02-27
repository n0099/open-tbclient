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
    private final int HK;
    private final int HL;
    private final boolean HM;
    private int HU;
    private boolean HZ;
    private MenuPresenter.Callback Ib;
    private PopupWindow.OnDismissListener Id;
    private e Jy;
    private final PopupWindow.OnDismissListener Jz;
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
        this.HU = GravityCompat.START;
        this.Jz = new PopupWindow.OnDismissListener() { // from class: android.support.v7.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.onDismiss();
            }
        };
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.oa = view;
        this.HM = z;
        this.HK = i;
        this.HL = i2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.Id = onDismissListener;
    }

    public void setAnchorView(View view) {
        this.oa = view;
    }

    public void setForceShowIcon(boolean z) {
        this.HZ = z;
        if (this.Jy != null) {
            this.Jy.setForceShowIcon(z);
        }
    }

    public void setGravity(int i) {
        this.HU = i;
    }

    public int getGravity() {
        return this.HU;
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
        if (this.Jy == null) {
            this.Jy = fc();
        }
        return this.Jy;
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
            gVar = new CascadingMenuPopup(this.mContext, this.oa, this.HK, this.HL, this.HM);
        } else {
            gVar = new g(this.mContext, this.mMenu, this.oa, this.HK, this.HL, this.HM);
        }
        gVar.c(this.mMenu);
        gVar.setOnDismissListener(this.Jz);
        gVar.setAnchorView(this.oa);
        gVar.setCallback(this.Ib);
        gVar.setForceShowIcon(this.HZ);
        gVar.setGravity(this.HU);
        return gVar;
    }

    private void b(int i, int i2, boolean z, boolean z2) {
        e popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            if ((GravityCompat.getAbsoluteGravity(this.HU, ViewCompat.getLayoutDirection(this.oa)) & 7) == 5) {
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
            this.Jy.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDismiss() {
        this.Jy = null;
        if (this.Id != null) {
            this.Id.onDismiss();
        }
    }

    public boolean isShowing() {
        return this.Jy != null && this.Jy.isShowing();
    }

    public void setPresenterCallback(MenuPresenter.Callback callback) {
        this.Ib = callback;
        if (this.Jy != null) {
            this.Jy.setCallback(callback);
        }
    }
}
