package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes2.dex */
public class PopupMenu {
    private final View QX;
    final MenuPopupHelper QY;
    OnMenuItemClickListener QZ;
    OnDismissListener Ra;
    private View.OnTouchListener Rb;
    private final Context mContext;
    private final MenuBuilder mMenu;

    /* loaded from: classes2.dex */
    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    /* loaded from: classes2.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(Context context, View view) {
        this(context, view, 0);
    }

    public PopupMenu(Context context, View view, int i) {
        this(context, view, i, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View view, int i, int i2, int i3) {
        this.mContext = context;
        this.QX = view;
        this.mMenu = new MenuBuilder(context);
        this.mMenu.setCallback(new MenuBuilder.Callback() { // from class: android.support.v7.widget.PopupMenu.1
            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                if (PopupMenu.this.QZ != null) {
                    return PopupMenu.this.QZ.onMenuItemClick(menuItem);
                }
                return false;
            }

            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }
        });
        this.QY = new MenuPopupHelper(context, this.mMenu, view, false, i2, i3);
        this.QY.setGravity(i);
        this.QY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: android.support.v7.widget.PopupMenu.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (PopupMenu.this.Ra != null) {
                    PopupMenu.this.Ra.onDismiss(PopupMenu.this);
                }
            }
        });
    }

    public void setGravity(int i) {
        this.QY.setGravity(i);
    }

    public int getGravity() {
        return this.QY.getGravity();
    }

    public View.OnTouchListener getDragToOpenListener() {
        if (this.Rb == null) {
            this.Rb = new ForwardingListener(this.QX) { // from class: android.support.v7.widget.PopupMenu.3
                @Override // android.support.v7.widget.ForwardingListener
                protected boolean onForwardingStarted() {
                    PopupMenu.this.show();
                    return true;
                }

                @Override // android.support.v7.widget.ForwardingListener
                protected boolean onForwardingStopped() {
                    PopupMenu.this.dismiss();
                    return true;
                }

                @Override // android.support.v7.widget.ForwardingListener
                public ShowableListMenu getPopup() {
                    return PopupMenu.this.QY.getPopup();
                }
            };
        }
        return this.Rb;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    public void inflate(int i) {
        getMenuInflater().inflate(i, this.mMenu);
    }

    public void show() {
        this.QY.show();
    }

    public void dismiss() {
        this.QY.dismiss();
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.QZ = onMenuItemClickListener;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.Ra = onDismissListener;
    }
}
