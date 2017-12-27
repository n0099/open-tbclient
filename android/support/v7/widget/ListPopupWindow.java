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
    private static Method Qk = null;
    private static Method Ql = null;
    private static Method Qm = null;
    public static final int WRAP_CONTENT = -2;
    private int Ia;
    private Rect JD;
    private int Nw;
    private View QA;
    private Drawable QB;
    private AdapterView.OnItemClickListener QC;
    private AdapterView.OnItemSelectedListener QD;
    final e QE;
    private final d QF;
    private final c QG;
    private final a QH;
    private Runnable QI;
    private boolean QJ;
    PopupWindow QK;
    l Qn;
    private int Qo;
    private int Qp;
    private int Qq;
    private int Qr;
    private boolean Qs;
    private boolean Qt;
    private boolean Qu;
    private boolean Qv;
    int Qw;
    private View Qx;
    private int Qy;
    private DataSetObserver Qz;
    private ListAdapter mAdapter;
    private Context mContext;
    final Handler mHandler;
    private final Rect mTempRect;

    static {
        try {
            Qk = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            Ql = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            Qm = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
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
        this.Qo = -2;
        this.Nw = -2;
        this.Qr = 1002;
        this.Qt = true;
        this.Ia = 0;
        this.Qu = false;
        this.Qv = false;
        this.Qw = Integer.MAX_VALUE;
        this.Qy = 0;
        this.QE = new e();
        this.QF = new d();
        this.QG = new c();
        this.QH = new a();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.Qp = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.Qq = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.Qq != 0) {
            this.Qs = true;
        }
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 11) {
            this.QK = new f(context, attributeSet, i, i2);
        } else {
            this.QK = new f(context, attributeSet, i);
        }
        this.QK.setInputMethodMode(1);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.Qz == null) {
            this.Qz = new b();
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.Qz);
        }
        this.mAdapter = listAdapter;
        if (this.mAdapter != null) {
            listAdapter.registerDataSetObserver(this.Qz);
        }
        if (this.Qn != null) {
            this.Qn.setAdapter(this.mAdapter);
        }
    }

    public void setPromptPosition(int i) {
        this.Qy = i;
    }

    public int getPromptPosition() {
        return this.Qy;
    }

    public void setModal(boolean z) {
        this.QJ = z;
        this.QK.setFocusable(z);
    }

    public boolean isModal() {
        return this.QJ;
    }

    @RestrictTo
    public void setForceIgnoreOutsideTouch(boolean z) {
        this.Qv = z;
    }

    @RestrictTo
    public void setDropDownAlwaysVisible(boolean z) {
        this.Qu = z;
    }

    @RestrictTo
    public boolean isDropDownAlwaysVisible() {
        return this.Qu;
    }

    public void setSoftInputMode(int i) {
        this.QK.setSoftInputMode(i);
    }

    public int getSoftInputMode() {
        return this.QK.getSoftInputMode();
    }

    public void setListSelector(Drawable drawable) {
        this.QB = drawable;
    }

    public Drawable getBackground() {
        return this.QK.getBackground();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.QK.setBackgroundDrawable(drawable);
    }

    public void setAnimationStyle(int i) {
        this.QK.setAnimationStyle(i);
    }

    public int getAnimationStyle() {
        return this.QK.getAnimationStyle();
    }

    public View getAnchorView() {
        return this.QA;
    }

    public void setAnchorView(View view) {
        this.QA = view;
    }

    public int getHorizontalOffset() {
        return this.Qp;
    }

    public void setHorizontalOffset(int i) {
        this.Qp = i;
    }

    public int getVerticalOffset() {
        if (this.Qs) {
            return this.Qq;
        }
        return 0;
    }

    public void setVerticalOffset(int i) {
        this.Qq = i;
        this.Qs = true;
    }

    @RestrictTo
    public void setEpicenterBounds(Rect rect) {
        this.JD = rect;
    }

    public void setDropDownGravity(int i) {
        this.Ia = i;
    }

    public int getWidth() {
        return this.Nw;
    }

    public void setWidth(int i) {
        this.Nw = i;
    }

    public void setContentWidth(int i) {
        Drawable background = this.QK.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.Nw = this.mTempRect.left + this.mTempRect.right + i;
            return;
        }
        setWidth(i);
    }

    public int getHeight() {
        return this.Qo;
    }

    public void setHeight(int i) {
        this.Qo = i;
    }

    public void setWindowLayoutType(int i) {
        this.Qr = i;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.QC = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.QD = onItemSelectedListener;
    }

    public void setPromptView(View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            gq();
        }
        this.Qx = view;
        if (isShowing) {
            show();
        }
    }

    public void postShow() {
        this.mHandler.post(this.QI);
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
        PopupWindowCompat.setWindowLayoutType(this.QK, this.Qr);
        if (this.QK.isShowing()) {
            if (this.Nw == -1) {
                i2 = -1;
            } else if (this.Nw == -2) {
                i2 = getAnchorView().getWidth();
            } else {
                i2 = this.Nw;
            }
            if (this.Qo == -1) {
                if (!isInputMethodNotNeeded) {
                    gr = -1;
                }
                if (isInputMethodNotNeeded) {
                    this.QK.setWidth(this.Nw == -1 ? -1 : 0);
                    this.QK.setHeight(0);
                    i3 = gr;
                } else {
                    this.QK.setWidth(this.Nw == -1 ? -1 : 0);
                    this.QK.setHeight(-1);
                    i3 = gr;
                }
            } else {
                i3 = this.Qo == -2 ? gr : this.Qo;
            }
            PopupWindow popupWindow = this.QK;
            if (!this.Qv && !this.Qu) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            PopupWindow popupWindow2 = this.QK;
            View anchorView = getAnchorView();
            int i4 = this.Qp;
            int i5 = this.Qq;
            if (i2 < 0) {
                i2 = -1;
            }
            popupWindow2.update(anchorView, i4, i5, i2, i3 >= 0 ? i3 : -1);
            return;
        }
        if (this.Nw == -1) {
            i = -1;
        } else if (this.Nw == -2) {
            i = getAnchorView().getWidth();
        } else {
            i = this.Nw;
        }
        if (this.Qo == -1) {
            gr = -1;
        } else if (this.Qo != -2) {
            gr = this.Qo;
        }
        this.QK.setWidth(i);
        this.QK.setHeight(gr);
        G(true);
        PopupWindow popupWindow3 = this.QK;
        if (this.Qv || this.Qu) {
            z = false;
        }
        popupWindow3.setOutsideTouchable(z);
        this.QK.setTouchInterceptor(this.QF);
        if (Qm != null) {
            try {
                Qm.invoke(this.QK, this.JD);
            } catch (Exception e2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        PopupWindowCompat.showAsDropDown(this.QK, getAnchorView(), this.Qp, this.Qq, this.Ia);
        this.Qn.setSelection(-1);
        if (!this.QJ || this.Qn.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.QJ) {
            this.mHandler.post(this.QH);
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void dismiss() {
        this.QK.dismiss();
        gq();
        this.QK.setContentView(null);
        this.Qn = null;
        this.mHandler.removeCallbacks(this.QE);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.QK.setOnDismissListener(onDismissListener);
    }

    private void gq() {
        if (this.Qx != null) {
            ViewParent parent = this.Qx.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.Qx);
            }
        }
    }

    public void setInputMethodMode(int i) {
        this.QK.setInputMethodMode(i);
    }

    public int getInputMethodMode() {
        return this.QK.getInputMethodMode();
    }

    public void setSelection(int i) {
        l lVar = this.Qn;
        if (isShowing() && lVar != null) {
            lVar.setListSelectionHidden(false);
            lVar.setSelection(i);
            if (Build.VERSION.SDK_INT >= 11 && lVar.getChoiceMode() != 0) {
                lVar.setItemChecked(i, true);
            }
        }
    }

    public void clearListSelection() {
        l lVar = this.Qn;
        if (lVar != null) {
            lVar.setListSelectionHidden(true);
            lVar.requestLayout();
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.QK.isShowing();
    }

    public boolean isInputMethodNotNeeded() {
        return this.QK.getInputMethodMode() == 2;
    }

    public boolean performItemClick(int i) {
        if (isShowing()) {
            if (this.QC != null) {
                l lVar = this.Qn;
                this.QC.onItemClick(lVar, lVar.getChildAt(i - lVar.getFirstVisiblePosition()), i, lVar.getAdapter().getItemId(i));
            }
            return true;
        }
        return false;
    }

    public Object getSelectedItem() {
        if (isShowing()) {
            return this.Qn.getSelectedItem();
        }
        return null;
    }

    public int getSelectedItemPosition() {
        if (isShowing()) {
            return this.Qn.getSelectedItemPosition();
        }
        return -1;
    }

    public long getSelectedItemId() {
        if (isShowing()) {
            return this.Qn.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public View getSelectedView() {
        if (isShowing()) {
            return this.Qn.getSelectedView();
        }
        return null;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.Qn;
    }

    l s(Context context, boolean z) {
        return new l(context, z);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isShowing() && i != 62 && (this.Qn.getSelectedItemPosition() >= 0 || !bq(i))) {
            int selectedItemPosition = this.Qn.getSelectedItemPosition();
            boolean z = !this.QK.isAboveAnchor();
            ListAdapter listAdapter = this.mAdapter;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                i2 = areAllItemsEnabled ? 0 : this.Qn.lookForSelectablePosition(0, true);
                i3 = areAllItemsEnabled ? listAdapter.getCount() - 1 : this.Qn.lookForSelectablePosition(listAdapter.getCount() - 1, false);
            }
            if ((z && i == 19 && selectedItemPosition <= i2) || (!z && i == 20 && selectedItemPosition >= i3)) {
                clearListSelection();
                this.QK.setInputMethodMode(1);
                show();
                return true;
            }
            this.Qn.setListSelectionHidden(false);
            if (this.Qn.onKeyDown(i, keyEvent)) {
                this.QK.setInputMethodMode(2);
                this.Qn.requestFocusFromTouch();
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
        if (!isShowing() || this.Qn.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.Qn.onKeyUp(i, keyEvent);
        if (onKeyUp && bq(i)) {
            dismiss();
            return onKeyUp;
        }
        return onKeyUp;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && isShowing()) {
            View view = this.QA;
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
        if (this.Qn == null) {
            Context context = this.mContext;
            this.QI = new Runnable() { // from class: android.support.v7.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View anchorView = ListPopupWindow.this.getAnchorView();
                    if (anchorView != null && anchorView.getWindowToken() != null) {
                        ListPopupWindow.this.show();
                    }
                }
            };
            this.Qn = s(context, !this.QJ);
            if (this.QB != null) {
                this.Qn.setSelector(this.QB);
            }
            this.Qn.setAdapter(this.mAdapter);
            this.Qn.setOnItemClickListener(this.QC);
            this.Qn.setFocusable(true);
            this.Qn.setFocusableInTouchMode(true);
            this.Qn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view2, int i6, long j) {
                    l lVar;
                    if (i6 != -1 && (lVar = ListPopupWindow.this.Qn) != null) {
                        lVar.setListSelectionHidden(false);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.Qn.setOnScrollListener(this.QG);
            if (this.QD != null) {
                this.Qn.setOnItemSelectedListener(this.QD);
            }
            View view2 = this.Qn;
            View view3 = this.Qx;
            if (view3 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.Qy) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.Qy);
                        break;
                }
                if (this.Nw >= 0) {
                    i5 = this.Nw;
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
            this.QK.setContentView(view);
            i = i3;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.QK.getContentView();
            View view4 = this.Qx;
            if (view4 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view4.getLayoutParams();
                i = layoutParams3.bottomMargin + view4.getMeasuredHeight() + layoutParams3.topMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.QK.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            int i6 = this.mTempRect.top + this.mTempRect.bottom;
            if (this.Qs) {
                i2 = i6;
            } else {
                this.Qq = -this.mTempRect.top;
                i2 = i6;
            }
        } else {
            this.mTempRect.setEmpty();
            i2 = 0;
        }
        int maxAvailableHeight = getMaxAvailableHeight(getAnchorView(), this.Qq, this.QK.getInputMethodMode() == 2);
        if (this.Qu || this.Qo == -1) {
            return maxAvailableHeight + i2;
        }
        switch (this.Nw) {
            case -2:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
                break;
            default:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.Nw, 1073741824);
                break;
        }
        int measureHeightOfChildrenCompat = this.Qn.measureHeightOfChildrenCompat(makeMeasureSpec, 0, -1, maxAvailableHeight - i, -1);
        if (measureHeightOfChildrenCompat > 0) {
            i += this.Qn.getPaddingTop() + this.Qn.getPaddingBottom() + i2;
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
            if (ListPopupWindow.this.Qn != null && ViewCompat.isAttachedToWindow(ListPopupWindow.this.Qn) && ListPopupWindow.this.Qn.getCount() > ListPopupWindow.this.Qn.getChildCount() && ListPopupWindow.this.Qn.getChildCount() <= ListPopupWindow.this.Qw) {
                ListPopupWindow.this.QK.setInputMethodMode(2);
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
            if (action == 0 && ListPopupWindow.this.QK != null && ListPopupWindow.this.QK.isShowing() && x >= 0 && x < ListPopupWindow.this.QK.getWidth() && y >= 0 && y < ListPopupWindow.this.QK.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.QE, 250L);
                return false;
            } else if (action == 1) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.QE);
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
            if (i == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.QK.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.QE);
                ListPopupWindow.this.QE.run();
            }
        }
    }

    private static boolean bq(int i) {
        return i == 66 || i == 23;
    }

    private void G(boolean z) {
        if (Qk != null) {
            try {
                Qk.invoke(this.QK, Boolean.valueOf(z));
            } catch (Exception e2) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int getMaxAvailableHeight(View view, int i, boolean z) {
        if (Ql != null) {
            try {
                return ((Integer) Ql.invoke(this.QK, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception e2) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.QK.getMaxAvailableHeight(view, i);
    }
}
