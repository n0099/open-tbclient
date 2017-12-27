package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.ActivityChooserModel;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* loaded from: classes2.dex */
public class ShareActionProvider extends ActionProvider {
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    private int Vl;
    private final b Vm;
    String Vn;
    OnShareTargetSelectedListener Vo;
    private ActivityChooserModel.OnChooseActivityListener Vp;
    final Context mContext;

    /* loaded from: classes2.dex */
    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.Vl = 4;
        this.Vm = new b();
        this.Vn = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.mContext = context;
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.Vo = onShareTargetSelectedListener;
        hP();
    }

    @Override // android.support.v4.view.ActionProvider
    public View onCreateActionView() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.mContext);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.H(this.mContext, this.Vn));
        }
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.mContext, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    @Override // android.support.v4.view.ActionProvider
    public boolean hasSubMenu() {
        return true;
    }

    @Override // android.support.v4.view.ActionProvider
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel H = ActivityChooserModel.H(this.mContext, this.Vn);
        PackageManager packageManager = this.mContext.getPackageManager();
        int fn = H.fn();
        int min = Math.min(fn, this.Vl);
        for (int i = 0; i < min; i++) {
            ResolveInfo aU = H.aU(i);
            subMenu.add(0, i, i, aU.loadLabel(packageManager)).setIcon(aU.loadIcon(packageManager)).setOnMenuItemClickListener(this.Vm);
        }
        if (min < fn) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.mContext.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i2 = 0; i2 < fn; i2++) {
                ResolveInfo aU2 = H.aU(i2);
                addSubMenu.add(0, i2, i2, aU2.loadLabel(packageManager)).setIcon(aU2.loadIcon(packageManager)).setOnMenuItemClickListener(this.Vm);
            }
        }
    }

    public void setShareHistoryFileName(String str) {
        this.Vn = str;
        hP();
    }

    public void setShareIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                A(intent);
            }
        }
        ActivityChooserModel.H(this.mContext, this.Vn).setIntent(intent);
    }

    /* loaded from: classes2.dex */
    private class b implements MenuItem.OnMenuItemClickListener {
        b() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            Intent aV = ActivityChooserModel.H(ShareActionProvider.this.mContext, ShareActionProvider.this.Vn).aV(menuItem.getItemId());
            if (aV != null) {
                String action = aV.getAction();
                if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                    ShareActionProvider.this.A(aV);
                }
                ShareActionProvider.this.mContext.startActivity(aV);
                return true;
            }
            return true;
        }
    }

    private void hP() {
        if (this.Vo != null) {
            if (this.Vp == null) {
                this.Vp = new a();
            }
            ActivityChooserModel.H(this.mContext, this.Vn).a(this.Vp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements ActivityChooserModel.OnChooseActivityListener {
        a() {
        }

        @Override // android.support.v7.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
            if (ShareActionProvider.this.Vo != null) {
                ShareActionProvider.this.Vo.onShareTargetSelected(ShareActionProvider.this, intent);
                return false;
            }
            return false;
        }
    }

    void A(Intent intent) {
        if (Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }
}
