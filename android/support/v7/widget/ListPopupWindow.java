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
    private static Method Qj = null;
    private static Method Qk = null;
    private static Method Ql = null;
    public static final int WRAP_CONTENT = -2;
    private int HZ;
    private Rect JC;
    private int Nv;
    private Drawable QA;
    private AdapterView.OnItemClickListener QB;
    private AdapterView.OnItemSelectedListener QC;
    final e QD;
    private final d QE;
    private final c QF;
    private final a QG;
    private Runnable QH;
    private boolean QI;
    PopupWindow QJ;
    l Qm;
    private int Qn;
    private int Qo;
    private int Qp;
    private int Qq;
    private boolean Qr;
    private boolean Qs;
    private boolean Qt;
    private boolean Qu;
    int Qv;
    private View Qw;
    private int Qx;
    private DataSetObserver Qy;
    private View Qz;
    private ListAdapter mAdapter;
    private Context mContext;
    final Handler mHandler;
    private final Rect mTempRect;

    static {
        try {
            Qj = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            Qk = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            Ql = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
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
        this.Qn = -2;
        this.Nv = -2;
        this.Qq = 1002;
        this.Qs = true;
        this.HZ = 0;
        this.Qt = false;
        this.Qu = false;
        this.Qv = Integer.MAX_VALUE;
        this.Qx = 0;
        this.QD = new e();
        this.QE = new d();
        this.QF = new c();
        this.QG = new a();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.Qo = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.Qp = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.Qp != 0) {
            this.Qr = true;
        }
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 11) {
            this.QJ = new f(context, attributeSet, i, i2);
        } else {
            this.QJ = new f(context, attributeSet, i);
        }
        this.QJ.setInputMethodMode(1);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.Qy == null) {
            this.Qy = new b();
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.Qy);
        }
        this.mAdapter = listAdapter;
        if (this.mAdapter != null) {
            listAdapter.registerDataSetObserver(this.Qy);
        }
        if (this.Qm != null) {
            this.Qm.setAdapter(this.mAdapter);
        }
    }

    public void setPromptPosition(int i) {
        this.Qx = i;
    }

    public int getPromptPosition() {
        return this.Qx;
    }

    public void setModal(boolean z) {
        this.QI = z;
        this.QJ.setFocusable(z);
    }

    public boolean isModal() {
        return this.QI;
    }

    @RestrictTo
    public void setForceIgnoreOutsideTouch(boolean z) {
        this.Qu = z;
    }

    @RestrictTo
    public void setDropDownAlwaysVisible(boolean z) {
        this.Qt = z;
    }

    @RestrictTo
    public boolean isDropDownAlwaysVisible() {
        return this.Qt;
    }

    public void setSoftInputMode(int i) {
        this.QJ.setSoftInputMode(i);
    }

    public int getSoftInputMode() {
        return this.QJ.getSoftInputMode();
    }

    public void setListSelector(Drawable drawable) {
        this.QA = drawable;
    }

    public Drawable getBackground() {
        return this.QJ.getBackground();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.QJ.setBackgroundDrawable(drawable);
    }

    public void setAnimationStyle(int i) {
        this.QJ.setAnimationStyle(i);
    }

    public int getAnimationStyle() {
        return this.QJ.getAnimationStyle();
    }

    public View getAnchorView() {
        return this.Qz;
    }

    public void setAnchorView(View view) {
        this.Qz = view;
    }

    public int getHorizontalOffset() {
        return this.Qo;
    }

    public void setHorizontalOffset(int i) {
        this.Qo = i;
    }

    public int getVerticalOffset() {
        if (this.Qr) {
            return this.Qp;
        }
        return 0;
    }

    public void setVerticalOffset(int i) {
        this.Qp = i;
        this.Qr = true;
    }

    @RestrictTo
    public void setEpicenterBounds(Rect rect) {
        this.JC = rect;
    }

    public void setDropDownGravity(int i) {
        this.HZ = i;
    }

    public int getWidth() {
        return this.Nv;
    }

    public void setWidth(int i) {
        this.Nv = i;
    }

    public void setContentWidth(int i) {
        Drawable background = this.QJ.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.Nv = this.mTempRect.left + this.mTempRect.right + i;
            return;
        }
        setWidth(i);
    }

    public int getHeight() {
        return this.Qn;
    }

    public void setHeight(int i) {
        this.Qn = i;
    }

    public void setWindowLayoutType(int i) {
        this.Qq = i;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.QB = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.QC = onItemSelectedListener;
    }

    public void setPromptView(View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            gq();
        }
        this.Qw = view;
        if (isShowing) {
            show();
        }
    }

    public void postShow() {
        this.mHandler.post(this.QH);
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
        PopupWindowCompat.setWindowLayoutType(this.QJ, this.Qq);
        if (this.QJ.isShowing()) {
            if (this.Nv == -1) {
                i2 = -1;
            } else if (this.Nv == -2) {
                i2 = getAnchorView().getWidth();
            } else {
                i2 = this.Nv;
            }
            if (this.Qn == -1) {
                if (!isInputMethodNotNeeded) {
                    gr = -1;
                }
                if (isInputMethodNotNeeded) {
                    this.QJ.setWidth(this.Nv == -1 ? -1 : 0);
                    this.QJ.setHeight(0);
                    i3 = gr;
                } else {
                    this.QJ.setWidth(this.Nv == -1 ? -1 : 0);
                    this.QJ.setHeight(-1);
                    i3 = gr;
                }
            } else {
                i3 = this.Qn == -2 ? gr : this.Qn;
            }
            PopupWindow popupWindow = this.QJ;
            if (!this.Qu && !this.Qt) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            PopupWindow popupWindow2 = this.QJ;
            View anchorView = getAnchorView();
            int i4 = this.Qo;
            int i5 = this.Qp;
            if (i2 < 0) {
                i2 = -1;
            }
            popupWindow2.update(anchorView, i4, i5, i2, i3 >= 0 ? i3 : -1);
            return;
        }
        if (this.Nv == -1) {
            i = -1;
        } else if (this.Nv == -2) {
            i = getAnchorView().getWidth();
        } else {
            i = this.Nv;
        }
        if (this.Qn == -1) {
            gr = -1;
        } else if (this.Qn != -2) {
            gr = this.Qn;
        }
        this.QJ.setWidth(i);
        this.QJ.setHeight(gr);
        I(true);
        PopupWindow popupWindow3 = this.QJ;
        if (this.Qu || this.Qt) {
            z = false;
        }
        popupWindow3.setOutsideTouchable(z);
        this.QJ.setTouchInterceptor(this.QE);
        if (Ql != null) {
            try {
                Ql.invoke(this.QJ, this.JC);
            } catch (Exception e2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        PopupWindowCompat.showAsDropDown(this.QJ, getAnchorView(), this.Qo, this.Qp, this.HZ);
        this.Qm.setSelection(-1);
        if (!this.QI || this.Qm.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.QI) {
            this.mHandler.post(this.QG);
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void dismiss() {
        this.QJ.dismiss();
        gq();
        this.QJ.setContentView(null);
        this.Qm = null;
        this.mHandler.removeCallbacks(this.QD);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.QJ.setOnDismissListener(onDismissListener);
    }

    private void gq() {
        if (this.Qw != null) {
            ViewParent parent = this.Qw.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.Qw);
            }
        }
    }

    public void setInputMethodMode(int i) {
        this.QJ.setInputMethodMode(i);
    }

    public int getInputMethodMode() {
        return this.QJ.getInputMethodMode();
    }

    public void setSelection(int i) {
        l lVar = this.Qm;
        if (isShowing() && lVar != null) {
            lVar.setListSelectionHidden(false);
            lVar.setSelection(i);
            if (Build.VERSION.SDK_INT >= 11 && lVar.getChoiceMode() != 0) {
                lVar.setItemChecked(i, true);
            }
        }
    }

    public void clearListSelection() {
        l lVar = this.Qm;
        if (lVar != null) {
            lVar.setListSelectionHidden(true);
            lVar.requestLayout();
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.QJ.isShowing();
    }

    public boolean isInputMethodNotNeeded() {
        return this.QJ.getInputMethodMode() == 2;
    }

    public boolean performItemClick(int i) {
        if (isShowing()) {
            if (this.QB != null) {
                l lVar = this.Qm;
                this.QB.onItemClick(lVar, lVar.getChildAt(i - lVar.getFirstVisiblePosition()), i, lVar.getAdapter().getItemId(i));
            }
            return true;
        }
        return false;
    }

    public Object getSelectedItem() {
        if (isShowing()) {
            return this.Qm.getSelectedItem();
        }
        return null;
    }

    public int getSelectedItemPosition() {
        if (isShowing()) {
            return this.Qm.getSelectedItemPosition();
        }
        return -1;
    }

    public long getSelectedItemId() {
        if (isShowing()) {
            return this.Qm.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public View getSelectedView() {
        if (isShowing()) {
            return this.Qm.getSelectedView();
        }
        return null;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.Qm;
    }

    l s(Context context, boolean z) {
        return new l(context, z);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isShowing() && i != 62 && (this.Qm.getSelectedItemPosition() >= 0 || !bq(i))) {
            int selectedItemPosition = this.Qm.getSelectedItemPosition();
            boolean z = !this.QJ.isAboveAnchor();
            ListAdapter listAdapter = this.mAdapter;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                i2 = areAllItemsEnabled ? 0 : this.Qm.lookForSelectablePosition(0, true);
                i3 = areAllItemsEnabled ? listAdapter.getCount() - 1 : this.Qm.lookForSelectablePosition(listAdapter.getCount() - 1, false);
            }
            if ((z && i == 19 && selectedItemPosition <= i2) || (!z && i == 20 && selectedItemPosition >= i3)) {
                clearListSelection();
                this.QJ.setInputMethodMode(1);
                show();
                return true;
            }
            this.Qm.setListSelectionHidden(false);
            if (this.Qm.onKeyDown(i, keyEvent)) {
                this.QJ.setInputMethodMode(2);
                this.Qm.requestFocusFromTouch();
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
        if (!isShowing() || this.Qm.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.Qm.onKeyUp(i, keyEvent);
        if (onKeyUp && bq(i)) {
            dismiss();
            return onKeyUp;
        }
        return onKeyUp;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && isShowing()) {
            View view = this.Qz;
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
        if (this.Qm == null) {
            Context context = this.mContext;
            this.QH = new Runnable() { // from class: android.support.v7.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View anchorView = ListPopupWindow.this.getAnchorView();
                    if (anchorView != null && anchorView.getWindowToken() != null) {
                        ListPopupWindow.this.show();
                    }
                }
            };
            this.Qm = s(context, !this.QI);
            if (this.QA != null) {
                this.Qm.setSelector(this.QA);
            }
            this.Qm.setAdapter(this.mAdapter);
            this.Qm.setOnItemClickListener(this.QB);
            this.Qm.setFocusable(true);
            this.Qm.setFocusableInTouchMode(true);
            this.Qm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view2, int i6, long j) {
                    l lVar;
                    if (i6 != -1 && (lVar = ListPopupWindow.this.Qm) != null) {
                        lVar.setListSelectionHidden(false);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.Qm.setOnScrollListener(this.QF);
            if (this.QC != null) {
                this.Qm.setOnItemSelectedListener(this.QC);
            }
            View view2 = this.Qm;
            View view3 = this.Qw;
            if (view3 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.Qx) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.Qx);
                        break;
                }
                if (this.Nv >= 0) {
                    i5 = this.Nv;
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
            this.QJ.setContentView(view);
            i = i3;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.QJ.getContentView();
            View view4 = this.Qw;
            if (view4 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view4.getLayoutParams();
                i = layoutParams3.bottomMargin + view4.getMeasuredHeight() + layoutParams3.topMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.QJ.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            int i6 = this.mTempRect.top + this.mTempRect.bottom;
            if (this.Qr) {
                i2 = i6;
            } else {
                this.Qp = -this.mTempRect.top;
                i2 = i6;
            }
        } else {
            this.mTempRect.setEmpty();
            i2 = 0;
        }
        int maxAvailableHeight = getMaxAvailableHeight(getAnchorView(), this.Qp, this.QJ.getInputMethodMode() == 2);
        if (this.Qt || this.Qn == -1) {
            return maxAvailableHeight + i2;
        }
        switch (this.Nv) {
            case -2:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
                break;
            default:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.Nv, 1073741824);
                break;
        }
        int measureHeightOfChildrenCompat = this.Qm.measureHeightOfChildrenCompat(makeMeasureSpec, 0, -1, maxAvailableHeight - i, -1);
        if (measureHeightOfChildrenCompat > 0) {
            i += this.Qm.getPaddingTop() + this.Qm.getPaddingBottom() + i2;
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
            if (ListPopupWindow.this.Qm != null && ViewCompat.isAttachedToWindow(ListPopupWindow.this.Qm) && ListPopupWindow.this.Qm.getCount() > ListPopupWindow.this.Qm.getChildCount() && ListPopupWindow.this.Qm.getChildCount() <= ListPopupWindow.this.Qv) {
                ListPopupWindow.this.QJ.setInputMethodMode(2);
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
            if (action == 0 && ListPopupWindow.this.QJ != null && ListPopupWindow.this.QJ.isShowing() && x >= 0 && x < ListPopupWindow.this.QJ.getWidth() && y >= 0 && y < ListPopupWindow.this.QJ.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.QD, 250L);
                return false;
            } else if (action == 1) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.QD);
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
            if (i == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.QJ.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.QD);
                ListPopupWindow.this.QD.run();
            }
        }
    }

    private static boolean bq(int i) {
        return i == 66 || i == 23;
    }

    private void I(boolean z) {
        if (Qj != null) {
            try {
                Qj.invoke(this.QJ, Boolean.valueOf(z));
            } catch (Exception e2) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int getMaxAvailableHeight(View view, int i, boolean z) {
        if (Qk != null) {
            try {
                return ((Integer) Qk.invoke(this.QJ, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception e2) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.QJ.getMaxAvailableHeight(view, i);
    }
}
