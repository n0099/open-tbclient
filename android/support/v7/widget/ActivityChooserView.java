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
    PopupWindow.OnDismissListener Ii;
    final a LM;
    private final b LN;
    private final LinearLayoutCompat LO;
    private final Drawable LP;
    final FrameLayout LQ;
    private final ImageView LR;
    final FrameLayout LS;
    private final ImageView LT;
    private final int LU;
    ActionProvider LV;
    final DataSetObserver LW;
    private final ViewTreeObserver.OnGlobalLayoutListener LX;
    private ListPopupWindow LY;
    boolean LZ;
    int Ma;
    private int Mb;
    private boolean nL;

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.LW = new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.LM.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.LM.notifyDataSetInvalidated();
            }
        };
        this.LX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.ActivityChooserView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.isShowingPopup()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().dismiss();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().show();
                    if (ActivityChooserView.this.LV != null) {
                        ActivityChooserView.this.LV.subUiVisibilityChanged(true);
                    }
                }
            }
        };
        this.Ma = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityChooserView, i, 0);
        this.Ma = obtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        this.LN = new b();
        this.LO = (LinearLayoutCompat) findViewById(R.id.activity_chooser_view_content);
        this.LP = this.LO.getBackground();
        this.LS = (FrameLayout) findViewById(R.id.default_activity_button);
        this.LS.setOnClickListener(this.LN);
        this.LS.setOnLongClickListener(this.LN);
        this.LT = (ImageView) this.LS.findViewById(R.id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout.setOnClickListener(this.LN);
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
        this.LQ = frameLayout;
        this.LR = (ImageView) frameLayout.findViewById(R.id.image);
        this.LR.setImageDrawable(drawable);
        this.LM = new a();
        this.LM.registerDataSetObserver(new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.4
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.fx();
            }
        });
        Resources resources = context.getResources();
        this.LU = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    @Override // android.support.v7.widget.ActivityChooserModel.ActivityChooserModelClient
    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.LM.a(activityChooserModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.LR.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.LR.setContentDescription(getContext().getString(i));
    }

    @RestrictTo
    public void setProvider(ActionProvider actionProvider) {
        this.LV = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.nL) {
            return false;
        }
        this.LZ = false;
        aX(this.Ma);
        return true;
    }

    void aX(int i) {
        if (this.LM.getDataModel() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.LX);
        boolean z = this.LS.getVisibility() == 0;
        int fn = this.LM.fn();
        int i2 = z ? 1 : 0;
        if (i != Integer.MAX_VALUE && fn > i2 + i) {
            this.LM.G(true);
            this.LM.aY(i - 1);
        } else {
            this.LM.G(false);
            this.LM.aY(i);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.isShowing()) {
            if (this.LZ || !z) {
                this.LM.b(true, z);
            } else {
                this.LM.b(false, false);
            }
            listPopupWindow.setContentWidth(Math.min(this.LM.fy(), this.LU));
            listPopupWindow.show();
            if (this.LV != null) {
                this.LV.subUiVisibilityChanged(true);
            }
            listPopupWindow.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
        }
    }

    public boolean dismissPopup() {
        if (isShowingPopup()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.LX);
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
        ActivityChooserModel dataModel = this.LM.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(this.LW);
        }
        this.nL = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel = this.LM.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.LW);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.LX);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.nL = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat = this.LO;
        if (this.LS.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(linearLayoutCompat, i, i2);
        setMeasuredDimension(linearLayoutCompat.getMeasuredWidth(), linearLayoutCompat.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.LO.layout(0, 0, i3 - i, i4 - i2);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.LM.getDataModel();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.Ii = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.Ma = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.Mb = i;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.LY == null) {
            this.LY = new ListPopupWindow(getContext());
            this.LY.setAdapter(this.LM);
            this.LY.setAnchorView(this);
            this.LY.setModal(true);
            this.LY.setOnItemClickListener(this.LN);
            this.LY.setOnDismissListener(this.LN);
        }
        return this.LY;
    }

    void fx() {
        if (this.LM.getCount() > 0) {
            this.LQ.setEnabled(true);
        } else {
            this.LQ.setEnabled(false);
        }
        int fn = this.LM.fn();
        int historySize = this.LM.getHistorySize();
        if (fn == 1 || (fn > 1 && historySize > 0)) {
            this.LS.setVisibility(0);
            ResolveInfo fo = this.LM.fo();
            PackageManager packageManager = getContext().getPackageManager();
            this.LT.setImageDrawable(fo.loadIcon(packageManager));
            if (this.Mb != 0) {
                this.LS.setContentDescription(getContext().getString(this.Mb, fo.loadLabel(packageManager)));
            }
        } else {
            this.LS.setVisibility(8);
        }
        if (this.LS.getVisibility() == 0) {
            this.LO.setBackgroundDrawable(this.LP);
        } else {
            this.LO.setBackgroundDrawable(null);
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
                    if (ActivityChooserView.this.LZ) {
                        if (i > 0) {
                            ActivityChooserView.this.LM.getDataModel().aW(i);
                            return;
                        }
                        return;
                    }
                    if (!ActivityChooserView.this.LM.fz()) {
                        i++;
                    }
                    Intent aV = ActivityChooserView.this.LM.getDataModel().aV(i);
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
            if (view == ActivityChooserView.this.LS) {
                ActivityChooserView.this.dismissPopup();
                Intent aV = ActivityChooserView.this.LM.getDataModel().aV(ActivityChooserView.this.LM.getDataModel().a(ActivityChooserView.this.LM.fo()));
                if (aV != null) {
                    aV.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(aV);
                }
            } else if (view == ActivityChooserView.this.LQ) {
                ActivityChooserView.this.LZ = false;
                ActivityChooserView.this.aX(ActivityChooserView.this.Ma);
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.LS) {
                if (ActivityChooserView.this.LM.getCount() > 0) {
                    ActivityChooserView.this.LZ = true;
                    ActivityChooserView.this.aX(ActivityChooserView.this.Ma);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            fA();
            if (ActivityChooserView.this.LV != null) {
                ActivityChooserView.this.LV.subUiVisibilityChanged(false);
            }
        }

        private void fA() {
            if (ActivityChooserView.this.Ii != null) {
                ActivityChooserView.this.Ii.onDismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private ActivityChooserModel Md;
        private int Me = 4;
        private boolean Mf;
        private boolean Mg;
        private boolean Mh;

        a() {
        }

        public void a(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel dataModel = ActivityChooserView.this.LM.getDataModel();
            if (dataModel != null && ActivityChooserView.this.isShown()) {
                dataModel.unregisterObserver(ActivityChooserView.this.LW);
            }
            this.Md = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.LW);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.Mh && i == getCount() + (-1)) ? 1 : 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int fn = this.Md.fn();
            if (!this.Mf && this.Md.fo() != null) {
                fn--;
            }
            int min = Math.min(fn, this.Me);
            if (this.Mh) {
                return min + 1;
            }
            return min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.Mf && this.Md.fo() != null) {
                        i++;
                    }
                    return this.Md.aU(i);
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
                    if (this.Mf && i == 0 && this.Mg) {
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
            int i = this.Me;
            this.Me = Integer.MAX_VALUE;
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
            this.Me = i;
            return i2;
        }

        public void aY(int i) {
            if (this.Me != i) {
                this.Me = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo fo() {
            return this.Md.fo();
        }

        public void G(boolean z) {
            if (this.Mh != z) {
                this.Mh = z;
                notifyDataSetChanged();
            }
        }

        public int fn() {
            return this.Md.fn();
        }

        public int getHistorySize() {
            return this.Md.getHistorySize();
        }

        public ActivityChooserModel getDataModel() {
            return this.Md;
        }

        public void b(boolean z, boolean z2) {
            if (this.Mf != z || this.Mg != z2) {
                this.Mf = z;
                this.Mg = z2;
                notifyDataSetChanged();
            }
        }

        public boolean fz() {
            return this.Mf;
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class InnerLayout extends LinearLayoutCompat {
        private static final int[] Iq = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, Iq);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }
}
