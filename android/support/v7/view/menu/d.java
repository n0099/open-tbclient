package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(16)
@RestrictTo
/* loaded from: classes2.dex */
public class d extends MenuItemWrapperICS {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    @Override // android.support.v7.view.menu.MenuItemWrapperICS
    MenuItemWrapperICS.a a(ActionProvider actionProvider) {
        return new a(this.mContext, actionProvider);
    }

    /* loaded from: classes2.dex */
    class a extends MenuItemWrapperICS.a implements ActionProvider.VisibilityListener {
        ActionProvider.VisibilityListener JB;

        public a(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // android.support.v4.view.ActionProvider
        public View onCreateActionView(MenuItem menuItem) {
            return this.Jy.onCreateActionView(menuItem);
        }

        @Override // android.support.v4.view.ActionProvider
        public boolean overridesItemVisibility() {
            return this.Jy.overridesItemVisibility();
        }

        @Override // android.support.v4.view.ActionProvider
        public boolean isVisible() {
            return this.Jy.isVisible();
        }

        @Override // android.support.v4.view.ActionProvider
        public void refreshVisibility() {
            this.Jy.refreshVisibility();
        }

        @Override // android.support.v4.view.ActionProvider
        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            this.JB = visibilityListener;
            android.view.ActionProvider actionProvider = this.Jy;
            if (visibilityListener == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.JB != null) {
                this.JB.onActionProviderVisibilityChanged(z);
            }
        }
    }
}
