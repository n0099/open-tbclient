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
    PopupWindow.OnDismissListener Id;
    final a LG;
    private final b LH;
    private final LinearLayoutCompat LI;
    private final Drawable LJ;
    final FrameLayout LK;
    private final ImageView LM;
    final FrameLayout LN;
    private final ImageView LO;
    private final int LP;
    ActionProvider LQ;
    final DataSetObserver LR;
    private final ViewTreeObserver.OnGlobalLayoutListener LS;
    private ListPopupWindow LT;
    boolean LU;
    int LV;
    private int LW;
    private boolean nL;

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.LR = new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.LG.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.LG.notifyDataSetInvalidated();
            }
        };
        this.LS = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.ActivityChooserView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.isShowingPopup()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().dismiss();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().show();
                    if (ActivityChooserView.this.LQ != null) {
                        ActivityChooserView.this.LQ.subUiVisibilityChanged(true);
                    }
                }
            }
        };
        this.LV = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityChooserView, i, 0);
        this.LV = obtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        this.LH = new b();
        this.LI = (LinearLayoutCompat) findViewById(R.id.activity_chooser_view_content);
        this.LJ = this.LI.getBackground();
        this.LN = (FrameLayout) findViewById(R.id.default_activity_button);
        this.LN.setOnClickListener(this.LH);
        this.LN.setOnLongClickListener(this.LH);
        this.LO = (ImageView) this.LN.findViewById(R.id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout.setOnClickListener(this.LH);
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
        this.LK = frameLayout;
        this.LM = (ImageView) frameLayout.findViewById(R.id.image);
        this.LM.setImageDrawable(drawable);
        this.LG = new a();
        this.LG.registerDataSetObserver(new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.4
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.fx();
            }
        });
        Resources resources = context.getResources();
        this.LP = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    @Override // android.support.v7.widget.ActivityChooserModel.ActivityChooserModelClient
    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.LG.a(activityChooserModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.LM.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.LM.setContentDescription(getContext().getString(i));
    }

    @RestrictTo
    public void setProvider(ActionProvider actionProvider) {
        this.LQ = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.nL) {
            return false;
        }
        this.LU = false;
        aX(this.LV);
        return true;
    }

    void aX(int i) {
        if (this.LG.getDataModel() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.LS);
        boolean z = this.LN.getVisibility() == 0;
        int fn = this.LG.fn();
        int i2 = z ? 1 : 0;
        if (i != Integer.MAX_VALUE && fn > i2 + i) {
            this.LG.G(true);
            this.LG.aY(i - 1);
        } else {
            this.LG.G(false);
            this.LG.aY(i);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.isShowing()) {
            if (this.LU || !z) {
                this.LG.b(true, z);
            } else {
                this.LG.b(false, false);
            }
            listPopupWindow.setContentWidth(Math.min(this.LG.fy(), this.LP));
            listPopupWindow.show();
            if (this.LQ != null) {
                this.LQ.subUiVisibilityChanged(true);
            }
            listPopupWindow.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
        }
    }

    public boolean dismissPopup() {
        if (isShowingPopup()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.LS);
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
        ActivityChooserModel dataModel = this.LG.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(this.LR);
        }
        this.nL = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel = this.LG.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.LR);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.LS);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.nL = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat = this.LI;
        if (this.LN.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(linearLayoutCompat, i, i2);
        setMeasuredDimension(linearLayoutCompat.getMeasuredWidth(), linearLayoutCompat.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.LI.layout(0, 0, i3 - i, i4 - i2);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.LG.getDataModel();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.Id = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.LV = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.LW = i;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.LT == null) {
            this.LT = new ListPopupWindow(getContext());
            this.LT.setAdapter(this.LG);
            this.LT.setAnchorView(this);
            this.LT.setModal(true);
            this.LT.setOnItemClickListener(this.LH);
            this.LT.setOnDismissListener(this.LH);
        }
        return this.LT;
    }

    void fx() {
        if (this.LG.getCount() > 0) {
            this.LK.setEnabled(true);
        } else {
            this.LK.setEnabled(false);
        }
        int fn = this.LG.fn();
        int historySize = this.LG.getHistorySize();
        if (fn == 1 || (fn > 1 && historySize > 0)) {
            this.LN.setVisibility(0);
            ResolveInfo fo = this.LG.fo();
            PackageManager packageManager = getContext().getPackageManager();
            this.LO.setImageDrawable(fo.loadIcon(packageManager));
            if (this.LW != 0) {
                this.LN.setContentDescription(getContext().getString(this.LW, fo.loadLabel(packageManager)));
            }
        } else {
            this.LN.setVisibility(8);
        }
        if (this.LN.getVisibility() == 0) {
            this.LI.setBackgroundDrawable(this.LJ);
        } else {
            this.LI.setBackgroundDrawable(null);
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
                    if (ActivityChooserView.this.LU) {
                        if (i > 0) {
                            ActivityChooserView.this.LG.getDataModel().aW(i);
                            return;
                        }
                        return;
                    }
                    if (!ActivityChooserView.this.LG.fz()) {
                        i++;
                    }
                    Intent aV = ActivityChooserView.this.LG.getDataModel().aV(i);
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
            if (view == ActivityChooserView.this.LN) {
                ActivityChooserView.this.dismissPopup();
                Intent aV = ActivityChooserView.this.LG.getDataModel().aV(ActivityChooserView.this.LG.getDataModel().a(ActivityChooserView.this.LG.fo()));
                if (aV != null) {
                    aV.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(aV);
                }
            } else if (view == ActivityChooserView.this.LK) {
                ActivityChooserView.this.LU = false;
                ActivityChooserView.this.aX(ActivityChooserView.this.LV);
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.LN) {
                if (ActivityChooserView.this.LG.getCount() > 0) {
                    ActivityChooserView.this.LU = true;
                    ActivityChooserView.this.aX(ActivityChooserView.this.LV);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            fA();
            if (ActivityChooserView.this.LQ != null) {
                ActivityChooserView.this.LQ.subUiVisibilityChanged(false);
            }
        }

        private void fA() {
            if (ActivityChooserView.this.Id != null) {
                ActivityChooserView.this.Id.onDismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private ActivityChooserModel LY;
        private int LZ = 4;
        private boolean Ma;
        private boolean Mb;
        private boolean Mc;

        a() {
        }

        public void a(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel dataModel = ActivityChooserView.this.LG.getDataModel();
            if (dataModel != null && ActivityChooserView.this.isShown()) {
                dataModel.unregisterObserver(ActivityChooserView.this.LR);
            }
            this.LY = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.LR);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.Mc && i == getCount() + (-1)) ? 1 : 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int fn = this.LY.fn();
            if (!this.Ma && this.LY.fo() != null) {
                fn--;
            }
            int min = Math.min(fn, this.LZ);
            if (this.Mc) {
                return min + 1;
            }
            return min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.Ma && this.LY.fo() != null) {
                        i++;
                    }
                    return this.LY.aU(i);
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
                    if (this.Ma && i == 0 && this.Mb) {
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
            int i = this.LZ;
            this.LZ = Integer.MAX_VALUE;
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
            this.LZ = i;
            return i2;
        }

        public void aY(int i) {
            if (this.LZ != i) {
                this.LZ = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo fo() {
            return this.LY.fo();
        }

        public void G(boolean z) {
            if (this.Mc != z) {
                this.Mc = z;
                notifyDataSetChanged();
            }
        }

        public int fn() {
            return this.LY.fn();
        }

        public int getHistorySize() {
            return this.LY.getHistorySize();
        }

        public ActivityChooserModel getDataModel() {
            return this.LY;
        }

        public void b(boolean z, boolean z2) {
            if (this.Ma != z || this.Mb != z2) {
                this.Ma = z;
                this.Mb = z2;
                notifyDataSetChanged();
            }
        }

        public boolean fz() {
            return this.Ma;
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class InnerLayout extends LinearLayoutCompat {
        private static final int[] Il = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, Il);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }
}
