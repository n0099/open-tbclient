package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.widget.ActivityChooserModel;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
@RestrictTo
/* loaded from: classes2.dex */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {
    PopupWindow.OnDismissListener Ij;
    final a LN;
    private final b LO;
    private final LinearLayoutCompat LP;
    private final Drawable LQ;
    final FrameLayout LR;
    private final ImageView LS;
    final FrameLayout LT;
    private final ImageView LU;
    private final int LV;
    ActionProvider LW;
    final DataSetObserver LX;
    private final ViewTreeObserver.OnGlobalLayoutListener LY;
    private ListPopupWindow LZ;
    boolean Ma;
    int Mb;
    private int Mc;
    private boolean nL;

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.LX = new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.LN.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.LN.notifyDataSetInvalidated();
            }
        };
        this.LY = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.ActivityChooserView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.isShowingPopup()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().dismiss();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().show();
                    if (ActivityChooserView.this.LW != null) {
                        ActivityChooserView.this.LW.subUiVisibilityChanged(true);
                    }
                }
            }
        };
        this.Mb = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityChooserView, i, 0);
        this.Mb = obtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        this.LO = new b();
        this.LP = (LinearLayoutCompat) findViewById(R.id.activity_chooser_view_content);
        this.LQ = this.LP.getBackground();
        this.LT = (FrameLayout) findViewById(R.id.default_activity_button);
        this.LT.setOnClickListener(this.LO);
        this.LT.setOnLongClickListener(this.LO);
        this.LU = (ImageView) this.LT.findViewById(R.id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout.setOnClickListener(this.LO);
        frameLayout.setOnTouchListener(new ForwardingListener(frameLayout) { // from class: android.support.v7.widget.ActivityChooserView.3
            @Override // android.support.v7.widget.ForwardingListener
            public ShowableListMenu getPopup() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            @Override // android.support.v7.widget.ForwardingListener
            protected boolean onForwardingStarted() {
                ActivityChooserView.this.showPopup();
                return true;
            }

            @Override // android.support.v7.widget.ForwardingListener
            protected boolean onForwardingStopped() {
                ActivityChooserView.this.dismissPopup();
                return true;
            }
        });
        this.LR = frameLayout;
        this.LS = (ImageView) frameLayout.findViewById(R.id.image);
        this.LS.setImageDrawable(drawable);
        this.LN = new a();
        this.LN.registerDataSetObserver(new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.4
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.fx();
            }
        });
        Resources resources = context.getResources();
        this.LV = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    @Override // android.support.v7.widget.ActivityChooserModel.ActivityChooserModelClient
    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.LN.a(activityChooserModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.LS.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.LS.setContentDescription(getContext().getString(i));
    }

    @RestrictTo
    public void setProvider(ActionProvider actionProvider) {
        this.LW = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.nL) {
            return false;
        }
        this.Ma = false;
        aX(this.Mb);
        return true;
    }

    void aX(int i) {
        if (this.LN.getDataModel() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.LY);
        boolean z = this.LT.getVisibility() == 0;
        int fn = this.LN.fn();
        int i2 = z ? 1 : 0;
        if (i != Integer.MAX_VALUE && fn > i2 + i) {
            this.LN.E(true);
            this.LN.aY(i - 1);
        } else {
            this.LN.E(false);
            this.LN.aY(i);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.isShowing()) {
            if (this.Ma || !z) {
                this.LN.b(true, z);
            } else {
                this.LN.b(false, false);
            }
            listPopupWindow.setContentWidth(Math.min(this.LN.fy(), this.LV));
            listPopupWindow.show();
            if (this.LW != null) {
                this.LW.subUiVisibilityChanged(true);
            }
            listPopupWindow.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
        }
    }

    public boolean dismissPopup() {
        if (isShowingPopup()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.LY);
                return true;
            }
            return true;
        }
        return true;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel dataModel = this.LN.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(this.LX);
        }
        this.nL = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel = this.LN.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.LX);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.LY);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.nL = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat = this.LP;
        if (this.LT.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(linearLayoutCompat, i, i2);
        setMeasuredDimension(linearLayoutCompat.getMeasuredWidth(), linearLayoutCompat.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.LP.layout(0, 0, i3 - i, i4 - i2);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.LN.getDataModel();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.Ij = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.Mb = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.Mc = i;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.LZ == null) {
            this.LZ = new ListPopupWindow(getContext());
            this.LZ.setAdapter(this.LN);
            this.LZ.setAnchorView(this);
            this.LZ.setModal(true);
            this.LZ.setOnItemClickListener(this.LO);
            this.LZ.setOnDismissListener(this.LO);
        }
        return this.LZ;
    }

    void fx() {
        if (this.LN.getCount() > 0) {
            this.LR.setEnabled(true);
        } else {
            this.LR.setEnabled(false);
        }
        int fn = this.LN.fn();
        int historySize = this.LN.getHistorySize();
        if (fn == 1 || (fn > 1 && historySize > 0)) {
            this.LT.setVisibility(0);
            ResolveInfo fo = this.LN.fo();
            PackageManager packageManager = getContext().getPackageManager();
            this.LU.setImageDrawable(fo.loadIcon(packageManager));
            if (this.Mc != 0) {
                this.LT.setContentDescription(getContext().getString(this.Mc, fo.loadLabel(packageManager)));
            }
        } else {
            this.LT.setVisibility(8);
        }
        if (this.LT.getVisibility() == 0) {
            this.LP.setBackgroundDrawable(this.LQ);
        } else {
            this.LP.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    ActivityChooserView.this.dismissPopup();
                    if (ActivityChooserView.this.Ma) {
                        if (i > 0) {
                            ActivityChooserView.this.LN.getDataModel().aW(i);
                            return;
                        }
                        return;
                    }
                    if (!ActivityChooserView.this.LN.fz()) {
                        i++;
                    }
                    Intent aV = ActivityChooserView.this.LN.getDataModel().aV(i);
                    if (aV != null) {
                        aV.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(aV);
                        return;
                    }
                    return;
                case 1:
                    ActivityChooserView.this.aX(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == ActivityChooserView.this.LT) {
                ActivityChooserView.this.dismissPopup();
                Intent aV = ActivityChooserView.this.LN.getDataModel().aV(ActivityChooserView.this.LN.getDataModel().a(ActivityChooserView.this.LN.fo()));
                if (aV != null) {
                    aV.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(aV);
                }
            } else if (view == ActivityChooserView.this.LR) {
                ActivityChooserView.this.Ma = false;
                ActivityChooserView.this.aX(ActivityChooserView.this.Mb);
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.LT) {
                if (ActivityChooserView.this.LN.getCount() > 0) {
                    ActivityChooserView.this.Ma = true;
                    ActivityChooserView.this.aX(ActivityChooserView.this.Mb);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            fA();
            if (ActivityChooserView.this.LW != null) {
                ActivityChooserView.this.LW.subUiVisibilityChanged(false);
            }
        }

        private void fA() {
            if (ActivityChooserView.this.Ij != null) {
                ActivityChooserView.this.Ij.onDismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private ActivityChooserModel Me;
        private int Mf = 4;
        private boolean Mg;
        private boolean Mh;
        private boolean Mi;

        a() {
        }

        public void a(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel dataModel = ActivityChooserView.this.LN.getDataModel();
            if (dataModel != null && ActivityChooserView.this.isShown()) {
                dataModel.unregisterObserver(ActivityChooserView.this.LX);
            }
            this.Me = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.LX);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.Mi && i == getCount() + (-1)) ? 1 : 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int fn = this.Me.fn();
            if (!this.Mg && this.Me.fo() != null) {
                fn--;
            }
            int min = Math.min(fn, this.Mf);
            if (this.Mi) {
                return min + 1;
            }
            return min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.Mg && this.Me.fo() != null) {
                        i++;
                    }
                    return this.Me.aU(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != R.id.list_item) {
                        view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(R.id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.Mg && i == 0 && this.Mh) {
                        ViewCompat.setActivated(view, true);
                        return view;
                    }
                    ViewCompat.setActivated(view, false);
                    return view;
                case 1:
                    if (view == null || view.getId() != 1) {
                        View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                        inflate.setId(1);
                        ((TextView) inflate.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                        return inflate;
                    }
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int fy() {
            int i = this.Mf;
            this.Mf = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.Mf = i;
            return i2;
        }

        public void aY(int i) {
            if (this.Mf != i) {
                this.Mf = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo fo() {
            return this.Me.fo();
        }

        public void E(boolean z) {
            if (this.Mi != z) {
                this.Mi = z;
                notifyDataSetChanged();
            }
        }

        public int fn() {
            return this.Me.fn();
        }

        public int getHistorySize() {
            return this.Me.getHistorySize();
        }

        public ActivityChooserModel getDataModel() {
            return this.Me;
        }

        public void b(boolean z, boolean z2) {
            if (this.Mg != z || this.Mh != z2) {
                this.Mg = z;
                this.Mh = z2;
                notifyDataSetChanged();
            }
        }

        public boolean fz() {
            return this.Mg;
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class InnerLayout extends LinearLayoutCompat {
        private static final int[] Ir = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, Ir);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }
}
