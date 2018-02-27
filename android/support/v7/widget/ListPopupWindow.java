package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class ListPopupWindow implements ShowableListMenu {
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static Method Qe = null;
    private static Method Qf = null;
    private static Method Qg = null;
    public static final int WRAP_CONTENT = -2;
    private int HU;
    private Rect Jx;
    private int Nq;
    private final c QA;
    private final a QB;
    private Runnable QC;
    private boolean QD;
    PopupWindow QE;
    l Qh;
    private int Qi;
    private int Qj;
    private int Qk;
    private int Ql;
    private boolean Qm;
    private boolean Qn;
    private boolean Qo;
    private boolean Qp;
    int Qq;
    private View Qr;
    private int Qs;
    private DataSetObserver Qt;
    private View Qu;
    private Drawable Qv;
    private AdapterView.OnItemClickListener Qw;
    private AdapterView.OnItemSelectedListener Qx;
    final e Qy;
    private final d Qz;
    private ListAdapter mAdapter;
    private Context mContext;
    final Handler mHandler;
    private final Rect mTempRect;

    static {
        try {
            Qe = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            Qf = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            Qg = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException e4) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.Qi = -2;
        this.Nq = -2;
        this.Ql = 1002;
        this.Qn = true;
        this.HU = 0;
        this.Qo = false;
        this.Qp = false;
        this.Qq = Integer.MAX_VALUE;
        this.Qs = 0;
        this.Qy = new e();
        this.Qz = new d();
        this.QA = new c();
        this.QB = new a();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.Qj = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.Qk = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.Qk != 0) {
            this.Qm = true;
        }
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 11) {
            this.QE = new f(context, attributeSet, i, i2);
        } else {
            this.QE = new f(context, attributeSet, i);
        }
        this.QE.setInputMethodMode(1);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.Qt == null) {
            this.Qt = new b();
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.Qt);
        }
        this.mAdapter = listAdapter;
        if (this.mAdapter != null) {
            listAdapter.registerDataSetObserver(this.Qt);
        }
        if (this.Qh != null) {
            this.Qh.setAdapter(this.mAdapter);
        }
    }

    public void setPromptPosition(int i) {
        this.Qs = i;
    }

    public int getPromptPosition() {
        return this.Qs;
    }

    public void setModal(boolean z) {
        this.QD = z;
        this.QE.setFocusable(z);
    }

    public boolean isModal() {
        return this.QD;
    }

    @RestrictTo
    public void setForceIgnoreOutsideTouch(boolean z) {
        this.Qp = z;
    }

    @RestrictTo
    public void setDropDownAlwaysVisible(boolean z) {
        this.Qo = z;
    }

    @RestrictTo
    public boolean isDropDownAlwaysVisible() {
        return this.Qo;
    }

    public void setSoftInputMode(int i) {
        this.QE.setSoftInputMode(i);
    }

    public int getSoftInputMode() {
        return this.QE.getSoftInputMode();
    }

    public void setListSelector(Drawable drawable) {
        this.Qv = drawable;
    }

    public Drawable getBackground() {
        return this.QE.getBackground();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.QE.setBackgroundDrawable(drawable);
    }

    public void setAnimationStyle(int i) {
        this.QE.setAnimationStyle(i);
    }

    public int getAnimationStyle() {
        return this.QE.getAnimationStyle();
    }

    public View getAnchorView() {
        return this.Qu;
    }

    public void setAnchorView(View view) {
        this.Qu = view;
    }

    public int getHorizontalOffset() {
        return this.Qj;
    }

    public void setHorizontalOffset(int i) {
        this.Qj = i;
    }

    public int getVerticalOffset() {
        if (this.Qm) {
            return this.Qk;
        }
        return 0;
    }

    public void setVerticalOffset(int i) {
        this.Qk = i;
        this.Qm = true;
    }

    @RestrictTo
    public void setEpicenterBounds(Rect rect) {
        this.Jx = rect;
    }

    public void setDropDownGravity(int i) {
        this.HU = i;
    }

    public int getWidth() {
        return this.Nq;
    }

    public void setWidth(int i) {
        this.Nq = i;
    }

    public void setContentWidth(int i) {
        Drawable background = this.QE.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.Nq = this.mTempRect.left + this.mTempRect.right + i;
            return;
        }
        setWidth(i);
    }

    public int getHeight() {
        return this.Qi;
    }

    public void setHeight(int i) {
        this.Qi = i;
    }

    public void setWindowLayoutType(int i) {
        this.Ql = i;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Qw = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.Qx = onItemSelectedListener;
    }

    public void setPromptView(View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            gq();
        }
        this.Qr = view;
        if (isShowing) {
            show();
        }
    }

    public void postShow() {
        this.mHandler.post(this.QC);
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void show() {
        int i;
        int i2;
        int i3;
        boolean z = true;
        boolean z2 = false;
        int gr = gr();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.QE, this.Ql);
        if (this.QE.isShowing()) {
            if (this.Nq == -1) {
                i2 = -1;
            } else if (this.Nq == -2) {
                i2 = getAnchorView().getWidth();
            } else {
                i2 = this.Nq;
            }
            if (this.Qi == -1) {
                if (!isInputMethodNotNeeded) {
                    gr = -1;
                }
                if (isInputMethodNotNeeded) {
                    this.QE.setWidth(this.Nq == -1 ? -1 : 0);
                    this.QE.setHeight(0);
                    i3 = gr;
                } else {
                    this.QE.setWidth(this.Nq == -1 ? -1 : 0);
                    this.QE.setHeight(-1);
                    i3 = gr;
                }
            } else {
                i3 = this.Qi == -2 ? gr : this.Qi;
            }
            PopupWindow popupWindow = this.QE;
            if (!this.Qp && !this.Qo) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            PopupWindow popupWindow2 = this.QE;
            View anchorView = getAnchorView();
            int i4 = this.Qj;
            int i5 = this.Qk;
            if (i2 < 0) {
                i2 = -1;
            }
            popupWindow2.update(anchorView, i4, i5, i2, i3 >= 0 ? i3 : -1);
            return;
        }
        if (this.Nq == -1) {
            i = -1;
        } else if (this.Nq == -2) {
            i = getAnchorView().getWidth();
        } else {
            i = this.Nq;
        }
        if (this.Qi == -1) {
            gr = -1;
        } else if (this.Qi != -2) {
            gr = this.Qi;
        }
        this.QE.setWidth(i);
        this.QE.setHeight(gr);
        I(true);
        PopupWindow popupWindow3 = this.QE;
        if (this.Qp || this.Qo) {
            z = false;
        }
        popupWindow3.setOutsideTouchable(z);
        this.QE.setTouchInterceptor(this.Qz);
        if (Qg != null) {
            try {
                Qg.invoke(this.QE, this.Jx);
            } catch (Exception e2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        PopupWindowCompat.showAsDropDown(this.QE, getAnchorView(), this.Qj, this.Qk, this.HU);
        this.Qh.setSelection(-1);
        if (!this.QD || this.Qh.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.QD) {
            this.mHandler.post(this.QB);
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void dismiss() {
        this.QE.dismiss();
        gq();
        this.QE.setContentView(null);
        this.Qh = null;
        this.mHandler.removeCallbacks(this.Qy);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.QE.setOnDismissListener(onDismissListener);
    }

    private void gq() {
        if (this.Qr != null) {
            ViewParent parent = this.Qr.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.Qr);
            }
        }
    }

    public void setInputMethodMode(int i) {
        this.QE.setInputMethodMode(i);
    }

    public int getInputMethodMode() {
        return this.QE.getInputMethodMode();
    }

    public void setSelection(int i) {
        l lVar = this.Qh;
        if (isShowing() && lVar != null) {
            lVar.setListSelectionHidden(false);
            lVar.setSelection(i);
            if (Build.VERSION.SDK_INT >= 11 && lVar.getChoiceMode() != 0) {
                lVar.setItemChecked(i, true);
            }
        }
    }

    public void clearListSelection() {
        l lVar = this.Qh;
        if (lVar != null) {
            lVar.setListSelectionHidden(true);
            lVar.requestLayout();
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.QE.isShowing();
    }

    public boolean isInputMethodNotNeeded() {
        return this.QE.getInputMethodMode() == 2;
    }

    public boolean performItemClick(int i) {
        if (isShowing()) {
            if (this.Qw != null) {
                l lVar = this.Qh;
                this.Qw.onItemClick(lVar, lVar.getChildAt(i - lVar.getFirstVisiblePosition()), i, lVar.getAdapter().getItemId(i));
            }
            return true;
        }
        return false;
    }

    public Object getSelectedItem() {
        if (isShowing()) {
            return this.Qh.getSelectedItem();
        }
        return null;
    }

    public int getSelectedItemPosition() {
        if (isShowing()) {
            return this.Qh.getSelectedItemPosition();
        }
        return -1;
    }

    public long getSelectedItemId() {
        if (isShowing()) {
            return this.Qh.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public View getSelectedView() {
        if (isShowing()) {
            return this.Qh.getSelectedView();
        }
        return null;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.Qh;
    }

    l s(Context context, boolean z) {
        return new l(context, z);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isShowing() && i != 62 && (this.Qh.getSelectedItemPosition() >= 0 || !bq(i))) {
            int selectedItemPosition = this.Qh.getSelectedItemPosition();
            boolean z = !this.QE.isAboveAnchor();
            ListAdapter listAdapter = this.mAdapter;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                i2 = areAllItemsEnabled ? 0 : this.Qh.lookForSelectablePosition(0, true);
                i3 = areAllItemsEnabled ? listAdapter.getCount() - 1 : this.Qh.lookForSelectablePosition(listAdapter.getCount() - 1, false);
            }
            if ((z && i == 19 && selectedItemPosition <= i2) || (!z && i == 20 && selectedItemPosition >= i3)) {
                clearListSelection();
                this.QE.setInputMethodMode(1);
                show();
                return true;
            }
            this.Qh.setListSelectionHidden(false);
            if (this.Qh.onKeyDown(i, keyEvent)) {
                this.QE.setInputMethodMode(2);
                this.Qh.requestFocusFromTouch();
                show();
                switch (i) {
                    case 19:
                    case 20:
                    case 23:
                    case 66:
                        return true;
                }
            } else if (z && i == 20) {
                if (selectedItemPosition == i3) {
                    return true;
                }
            } else if (!z && i == 19 && selectedItemPosition == i2) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!isShowing() || this.Qh.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.Qh.onKeyUp(i, keyEvent);
        if (onKeyUp && bq(i)) {
            dismiss();
            return onKeyUp;
        }
        return onKeyUp;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && isShowing()) {
            View view = this.Qu;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                }
                return true;
            } else if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    dismiss();
                    return true;
                }
            }
        }
        return false;
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new ForwardingListener(view) { // from class: android.support.v7.widget.ListPopupWindow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v7.widget.ForwardingListener
            /* renamed from: gs */
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    private int gr() {
        int i;
        int i2;
        int makeMeasureSpec;
        View view;
        int i3;
        int i4;
        int i5;
        if (this.Qh == null) {
            Context context = this.mContext;
            this.QC = new Runnable() { // from class: android.support.v7.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View anchorView = ListPopupWindow.this.getAnchorView();
                    if (anchorView != null && anchorView.getWindowToken() != null) {
                        ListPopupWindow.this.show();
                    }
                }
            };
            this.Qh = s(context, !this.QD);
            if (this.Qv != null) {
                this.Qh.setSelector(this.Qv);
            }
            this.Qh.setAdapter(this.mAdapter);
            this.Qh.setOnItemClickListener(this.Qw);
            this.Qh.setFocusable(true);
            this.Qh.setFocusableInTouchMode(true);
            this.Qh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view2, int i6, long j) {
                    l lVar;
                    if (i6 != -1 && (lVar = ListPopupWindow.this.Qh) != null) {
                        lVar.setListSelectionHidden(false);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.Qh.setOnScrollListener(this.QA);
            if (this.Qx != null) {
                this.Qh.setOnItemSelectedListener(this.Qx);
            }
            View view2 = this.Qh;
            View view3 = this.Qr;
            if (view3 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.Qs) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.Qs);
                        break;
                }
                if (this.Nq >= 0) {
                    i5 = this.Nq;
                    i4 = Integer.MIN_VALUE;
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                view3.measure(View.MeasureSpec.makeMeasureSpec(i5, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i3 = layoutParams2.bottomMargin + view3.getMeasuredHeight() + layoutParams2.topMargin;
                view = linearLayout;
            } else {
                view = view2;
                i3 = 0;
            }
            this.QE.setContentView(view);
            i = i3;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.QE.getContentView();
            View view4 = this.Qr;
            if (view4 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view4.getLayoutParams();
                i = layoutParams3.bottomMargin + view4.getMeasuredHeight() + layoutParams3.topMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.QE.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            int i6 = this.mTempRect.top + this.mTempRect.bottom;
            if (this.Qm) {
                i2 = i6;
            } else {
                this.Qk = -this.mTempRect.top;
                i2 = i6;
            }
        } else {
            this.mTempRect.setEmpty();
            i2 = 0;
        }
        int maxAvailableHeight = getMaxAvailableHeight(getAnchorView(), this.Qk, this.QE.getInputMethodMode() == 2);
        if (this.Qo || this.Qi == -1) {
            return maxAvailableHeight + i2;
        }
        switch (this.Nq) {
            case -2:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
                break;
            default:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.Nq, 1073741824);
                break;
        }
        int measureHeightOfChildrenCompat = this.Qh.measureHeightOfChildrenCompat(makeMeasureSpec, 0, -1, maxAvailableHeight - i, -1);
        if (measureHeightOfChildrenCompat > 0) {
            i += this.Qh.getPaddingTop() + this.Qh.getPaddingBottom() + i2;
        }
        return measureHeightOfChildrenCompat + i;
    }

    /* loaded from: classes2.dex */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ListPopupWindow.this.Qh != null && ViewCompat.isAttachedToWindow(ListPopupWindow.this.Qh) && ListPopupWindow.this.Qh.getCount() > ListPopupWindow.this.Qh.getChildCount() && ListPopupWindow.this.Qh.getChildCount() <= ListPopupWindow.this.Qq) {
                ListPopupWindow.this.QE.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.QE != null && ListPopupWindow.this.QE.isShowing() && x >= 0 && x < ListPopupWindow.this.QE.getWidth() && y >= 0 && y < ListPopupWindow.this.QE.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.Qy, 250L);
                return false;
            } else if (action == 1) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.Qy);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.QE.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.Qy);
                ListPopupWindow.this.Qy.run();
            }
        }
    }

    private static boolean bq(int i) {
        return i == 66 || i == 23;
    }

    private void I(boolean z) {
        if (Qe != null) {
            try {
                Qe.invoke(this.QE, Boolean.valueOf(z));
            } catch (Exception e2) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int getMaxAvailableHeight(View view, int i, boolean z) {
        if (Qf != null) {
            try {
                return ((Integer) Qf.invoke(this.QE, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception e2) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.QE.getMaxAvailableHeight(view, i);
    }
}
