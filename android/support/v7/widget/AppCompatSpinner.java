package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
/* loaded from: classes2.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    static final boolean Np;
    private static final boolean Nq;
    private static final int[] Nr;
    private ForwardingListener HB;
    private d Mt;
    private SpinnerAdapter Ns;
    private boolean Nt;
    b Nu;
    int Nv;
    private Context mPopupContext;
    final Rect mTempRect;

    static {
        Np = Build.VERSION.SDK_INT >= 23;
        Nq = Build.VERSION.SDK_INT >= 16;
        Nr = new int[]{16843505};
    }

    public AppCompatSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatSpinner(Context context, int i) {
        this(context, null, R.attr.spinnerStyle, i);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [232=4] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2, Resources.Theme theme) {
        super(context, attributeSet, i);
        CharSequence[] textArray;
        TypedArray typedArray;
        this.mTempRect = new Rect();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.Spinner, i, 0);
        this.Mt = new d(this);
        if (theme != null) {
            this.mPopupContext = new ContextThemeWrapper(context, theme);
        } else {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Spinner_popupTheme, 0);
            if (resourceId != 0) {
                this.mPopupContext = new ContextThemeWrapper(context, resourceId);
            } else {
                this.mPopupContext = !Np ? context : null;
            }
        }
        if (this.mPopupContext != null) {
            if (i2 == -1) {
                if (Build.VERSION.SDK_INT >= 11) {
                    try {
                        typedArray = context.obtainStyledAttributes(attributeSet, Nr, i, 0);
                        try {
                            try {
                                i2 = typedArray.hasValue(0) ? typedArray.getInt(0, 0) : i2;
                                if (typedArray != null) {
                                    typedArray.recycle();
                                }
                            } catch (Exception e) {
                                e = e;
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (typedArray != null) {
                                    typedArray.recycle();
                                }
                                if (i2 == 1) {
                                }
                                textArray = obtainStyledAttributes.getTextArray(R.styleable.Spinner_android_entries);
                                if (textArray != null) {
                                }
                                obtainStyledAttributes.recycle();
                                this.Nt = true;
                                if (this.Ns != null) {
                                }
                                this.Mt.loadFromAttributes(attributeSet, i);
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (typedArray != null) {
                                typedArray.recycle();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        typedArray = null;
                    } catch (Throwable th2) {
                        th = th2;
                        typedArray = null;
                        if (typedArray != null) {
                        }
                        throw th;
                    }
                } else {
                    i2 = 1;
                }
            }
            if (i2 == 1) {
                final b bVar = new b(this.mPopupContext, attributeSet, i);
                TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(this.mPopupContext, attributeSet, R.styleable.Spinner, i, 0);
                this.Nv = obtainStyledAttributes2.getLayoutDimension(R.styleable.Spinner_android_dropDownWidth, -2);
                bVar.setBackgroundDrawable(obtainStyledAttributes2.getDrawable(R.styleable.Spinner_android_popupBackground));
                bVar.g(obtainStyledAttributes.getString(R.styleable.Spinner_android_prompt));
                obtainStyledAttributes2.recycle();
                this.Nu = bVar;
                this.HB = new ForwardingListener(this) { // from class: android.support.v7.widget.AppCompatSpinner.1
                    @Override // android.support.v7.widget.ForwardingListener
                    public ShowableListMenu getPopup() {
                        return bVar;
                    }

                    @Override // android.support.v7.widget.ForwardingListener
                    public boolean onForwardingStarted() {
                        if (!AppCompatSpinner.this.Nu.isShowing()) {
                            AppCompatSpinner.this.Nu.show();
                            return true;
                        }
                        return true;
                    }
                };
            }
        }
        textArray = obtainStyledAttributes.getTextArray(R.styleable.Spinner_android_entries);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        obtainStyledAttributes.recycle();
        this.Nt = true;
        if (this.Ns != null) {
            setAdapter(this.Ns);
            this.Ns = null;
        }
        this.Mt.loadFromAttributes(attributeSet, i);
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        if (this.Nu != null) {
            return this.mPopupContext;
        }
        if (Np) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.Nu != null) {
            this.Nu.setBackgroundDrawable(drawable);
        } else if (Nq) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        if (this.Nu != null) {
            return this.Nu.getBackground();
        }
        if (Nq) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        if (this.Nu != null) {
            this.Nu.setVerticalOffset(i);
        } else if (Nq) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        if (this.Nu != null) {
            return this.Nu.getVerticalOffset();
        }
        if (Nq) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        if (this.Nu != null) {
            this.Nu.setHorizontalOffset(i);
        } else if (Nq) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        if (this.Nu != null) {
            return this.Nu.getHorizontalOffset();
        }
        if (Nq) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.Nu != null) {
            this.Nv = i;
        } else if (Nq) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.Nu != null) {
            return this.Nv;
        }
        if (Nq) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.Nt) {
            this.Ns = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.Nu != null) {
            this.Nu.setAdapter(new a(spinnerAdapter, (this.mPopupContext == null ? getContext() : this.mPopupContext).getTheme()));
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Nu != null && this.Nu.isShowing()) {
            this.Nu.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HB == null || !this.HB.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Nu != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        if (this.Nu != null) {
            if (!this.Nu.isShowing()) {
                this.Nu.show();
            }
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        if (this.Nu != null) {
            this.Nu.g(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        return this.Nu != null ? this.Nu.fO() : super.getPrompt();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Mt != null) {
            this.Mt.be(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.Mt != null) {
            this.Mt.c(drawable);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.Mt != null) {
            this.Mt.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo
    public ColorStateList getSupportBackgroundTintList() {
        if (this.Mt != null) {
            return this.Mt.getSupportBackgroundTintList();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.Mt != null) {
            this.Mt.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.Mt != null) {
            return this.Mt.getSupportBackgroundTintMode();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Mt != null) {
            this.Mt.fI();
        }
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        View view;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view2 = null;
        int i = 0;
        int i2 = 0;
        while (max2 < min) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
            } else {
                itemViewType = i2;
                view = view2;
            }
            view2 = spinnerAdapter.getView(max2, view, this);
            if (view2.getLayoutParams() == null) {
                view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view2.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view2.getMeasuredWidth());
            max2++;
            i2 = itemViewType;
        }
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            return this.mTempRect.left + this.mTempRect.right + i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter Ny;
        private ListAdapter Nz;

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.Ny = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.Nz = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (AppCompatSpinner.Np && (spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter)) {
                    android.widget.ThemedSpinnerAdapter themedSpinnerAdapter = (android.widget.ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter2 = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                        themedSpinnerAdapter2.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.Ny == null) {
                return 0;
            }
            return this.Ny.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.Ny == null) {
                return null;
            }
            return this.Ny.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (this.Ny == null) {
                return -1L;
            }
            return this.Ny.getItemId(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.Ny == null) {
                return null;
            }
            return this.Ny.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return this.Ny != null && this.Ny.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.Ny != null) {
                this.Ny.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.Ny != null) {
                this.Ny.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.Nz;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.Nz;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends ListPopupWindow {
        private CharSequence NA;
        private final Rect NB;
        ListAdapter mAdapter;

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.NB = new Rect();
            setAnchorView(AppCompatSpinner.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.AppCompatSpinner.b.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i2, b.this.mAdapter.getItemId(i2));
                    }
                    b.this.dismiss();
                }
            });
        }

        @Override // android.support.v7.widget.ListPopupWindow
        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.mAdapter = listAdapter;
        }

        public CharSequence fO() {
            return this.NA;
        }

        public void g(CharSequence charSequence) {
            this.NA = charSequence;
        }

        void fP() {
            int i;
            int i2;
            Drawable background = getBackground();
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.mTempRect);
                i = ViewUtils.isLayoutRtl(AppCompatSpinner.this) ? AppCompatSpinner.this.mTempRect.right : -AppCompatSpinner.this.mTempRect.left;
            } else {
                Rect rect = AppCompatSpinner.this.mTempRect;
                AppCompatSpinner.this.mTempRect.right = 0;
                rect.left = 0;
                i = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.Nv == -2) {
                int a = AppCompatSpinner.this.a((SpinnerAdapter) this.mAdapter, getBackground());
                int i3 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left) - AppCompatSpinner.this.mTempRect.right;
                if (a <= i3) {
                    i3 = a;
                }
                setContentWidth(Math.max(i3, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.Nv == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(AppCompatSpinner.this.Nv);
            }
            if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
                i2 = ((width - paddingRight) - getWidth()) + i;
            } else {
                i2 = i + paddingLeft;
            }
            setHorizontalOffset(i2);
        }

        @Override // android.support.v7.widget.ListPopupWindow, android.support.v7.view.menu.ShowableListMenu
        public void show() {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            fP();
            setInputMethodMode(2);
            super.show();
            getListView().setChoiceMode(1);
            setSelection(AppCompatSpinner.this.getSelectedItemPosition());
            if (!isShowing && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.AppCompatSpinner.b.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (!b.this.W(AppCompatSpinner.this)) {
                            b.this.dismiss();
                            return;
                        }
                        b.this.fP();
                        b.super.show();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
                setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: android.support.v7.widget.AppCompatSpinner.b.3
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                        if (viewTreeObserver2 != null) {
                            viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                        }
                    }
                });
            }
        }

        boolean W(View view) {
            return ViewCompat.isAttachedToWindow(view) && view.getGlobalVisibleRect(this.NB);
        }
    }
}
