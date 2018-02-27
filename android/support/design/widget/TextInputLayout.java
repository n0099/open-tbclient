package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.widget.s;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.Space;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.TintTypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {
    private final Rect mTmpRect;
    final d nh;
    private s qm;
    private final FrameLayout rC;
    EditText rD;
    private boolean rE;
    private CharSequence rF;
    private Paint rG;
    private LinearLayout rH;
    private int rI;
    private boolean rJ;
    TextView rK;
    private int rL;
    private boolean rM;
    private CharSequence rN;
    boolean rO;
    private TextView rP;
    private int rQ;
    private int rR;
    private int rS;
    private boolean rT;
    private boolean rU;
    private Drawable rV;
    private CharSequence rW;
    private CheckableImageButton rX;
    private boolean rY;
    private Drawable rZ;
    private Drawable sa;
    private ColorStateList sb;
    private boolean sc;
    private PorterDuff.Mode sd;
    private boolean se;
    private ColorStateList sf;
    private ColorStateList sg;
    private boolean sh;
    private boolean si;
    private boolean sj;
    private boolean sk;

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mTmpRect = new Rect();
        this.nh = new d(this);
        r.R(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.rC = new FrameLayout(context);
        this.rC.setAddStatesFromChildren(true);
        addView(this.rC);
        this.nh.a(android.support.design.widget.a.kB);
        this.nh.b(new AccelerateInterpolator());
        this.nh.s(8388659);
        this.sh = this.nh.bg() == 1.0f;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TextInputLayout, i, R.style.Widget_Design_TextInputLayout);
        this.rE = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(obtainStyledAttributes.getText(R.styleable.TextInputLayout_android_hint));
        this.si = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        if (obtainStyledAttributes.hasValue(R.styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
            this.sg = colorStateList;
            this.sf = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        this.rL = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(obtainStyledAttributes.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.rR = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.rS = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.rU = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, true);
        this.rV = obtainStyledAttributes.getDrawable(R.styleable.TextInputLayout_passwordToggleDrawable);
        this.rW = obtainStyledAttributes.getText(R.styleable.TextInputLayout_passwordToggleContentDescription);
        if (obtainStyledAttributes.hasValue(R.styleable.TextInputLayout_passwordToggleTint)) {
            this.sc = true;
            this.sb = obtainStyledAttributes.getColorStateList(R.styleable.TextInputLayout_passwordToggleTint);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode)) {
            this.se = true;
            this.sd = z.a(obtainStyledAttributes.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        obtainStyledAttributes.recycle();
        setErrorEnabled(z);
        setCounterEnabled(z2);
        cz();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setAccessibilityDelegate(this, new a());
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            this.rC.addView(view, new FrameLayout.LayoutParams(layoutParams));
            this.rC.setLayoutParams(layoutParams);
            cr();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(Typeface typeface) {
        this.nh.c(typeface);
    }

    public Typeface getTypeface() {
        return this.nh.be();
    }

    private void setEditText(EditText editText) {
        if (this.rD != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.rD = editText;
        if (!cx()) {
            this.nh.c(this.rD.getTypeface());
        }
        this.nh.g(this.rD.getTextSize());
        int gravity = this.rD.getGravity();
        this.nh.s((8388615 & gravity) | 48);
        this.nh.r(gravity);
        this.rD.addTextChangedListener(new TextWatcher() { // from class: android.support.design.widget.TextInputLayout.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.p(true);
                if (TextInputLayout.this.rO) {
                    TextInputLayout.this.P(editable.length());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        if (this.sf == null) {
            this.sf = this.rD.getHintTextColors();
        }
        if (this.rE && TextUtils.isEmpty(this.rF)) {
            setHint(this.rD.getHint());
            this.rD.setHint((CharSequence) null);
        }
        if (this.rP != null) {
            P(this.rD.getText().length());
        }
        if (this.rH != null) {
            cs();
        }
        cv();
        p(false);
    }

    private void cr() {
        int i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.rC.getLayoutParams();
        if (this.rE) {
            if (this.rG == null) {
                this.rG = new Paint();
            }
            this.rG.setTypeface(this.nh.be());
            this.rG.setTextSize(this.nh.bh());
            i = (int) (-this.rG.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.rC.requestLayout();
        }
    }

    void p(boolean z) {
        boolean isEnabled = isEnabled();
        boolean z2 = (this.rD == null || TextUtils.isEmpty(this.rD.getText())) ? false : true;
        boolean b = b(getDrawableState(), 16842908);
        boolean z3 = TextUtils.isEmpty(getError()) ? false : true;
        if (this.sf != null) {
            this.nh.c(this.sf);
        }
        if (isEnabled && this.rT && this.rP != null) {
            this.nh.b(this.rP.getTextColors());
        } else if (isEnabled && b && this.sg != null) {
            this.nh.b(this.sg);
        } else if (this.sf != null) {
            this.nh.b(this.sf);
        }
        if (z2 || (isEnabled() && (b || z3))) {
            q(z);
        } else {
            s(z);
        }
    }

    public EditText getEditText() {
        return this.rD;
    }

    public void setHint(CharSequence charSequence) {
        if (this.rE) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        this.rF = charSequence;
        this.nh.setText(charSequence);
    }

    public CharSequence getHint() {
        if (this.rE) {
            return this.rF;
        }
        return null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.rE) {
            this.rE = z;
            CharSequence hint = this.rD.getHint();
            if (!this.rE) {
                if (!TextUtils.isEmpty(this.rF) && TextUtils.isEmpty(hint)) {
                    this.rD.setHint(this.rF);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.rF)) {
                    setHint(hint);
                }
                this.rD.setHint((CharSequence) null);
            }
            if (this.rD != null) {
                cr();
            }
        }
    }

    public boolean isHintEnabled() {
        return this.rE;
    }

    public void setHintTextAppearance(int i) {
        this.nh.t(i);
        this.sg = this.nh.bp();
        if (this.rD != null) {
            p(false);
            cr();
        }
    }

    private void a(TextView textView, int i) {
        if (this.rH == null) {
            this.rH = new LinearLayout(getContext());
            this.rH.setOrientation(0);
            addView(this.rH, -1, -2);
            this.rH.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.rD != null) {
                cs();
            }
        }
        this.rH.setVisibility(0);
        this.rH.addView(textView, i);
        this.rI++;
    }

    private void cs() {
        ViewCompat.setPaddingRelative(this.rH, ViewCompat.getPaddingStart(this.rD), 0, ViewCompat.getPaddingEnd(this.rD), this.rD.getPaddingBottom());
    }

    private void b(TextView textView) {
        if (this.rH != null) {
            this.rH.removeView(textView);
            int i = this.rI - 1;
            this.rI = i;
            if (i == 0) {
                this.rH.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setErrorEnabled(boolean z) {
        boolean z2;
        if (this.rJ != z) {
            if (this.rK != null) {
                ViewCompat.animate(this.rK).cancel();
            }
            if (z) {
                this.rK = new TextView(getContext());
                try {
                    TextViewCompat.setTextAppearance(this.rK, this.rL);
                } catch (Exception e) {
                    z2 = true;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    if (this.rK.getTextColors().getDefaultColor() == -65281) {
                        z2 = true;
                        if (z2) {
                            TextViewCompat.setTextAppearance(this.rK, android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption);
                            this.rK.setTextColor(ContextCompat.getColor(getContext(), R.color.design_textinput_error_color_light));
                        }
                        this.rK.setVisibility(4);
                        ViewCompat.setAccessibilityLiveRegion(this.rK, 1);
                        a(this.rK, 0);
                    }
                }
                z2 = false;
                if (z2) {
                }
                this.rK.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(this.rK, 1);
                a(this.rK, 0);
            } else {
                this.rM = false;
                ct();
                b(this.rK);
                this.rK = null;
            }
            this.rJ = z;
        }
    }

    public boolean isErrorEnabled() {
        return this.rJ;
    }

    public void setError(CharSequence charSequence) {
        a(charSequence, ViewCompat.isLaidOut(this) && isEnabled() && (this.rK == null || !TextUtils.equals(this.rK.getText(), charSequence)));
    }

    private void a(final CharSequence charSequence, boolean z) {
        this.rN = charSequence;
        if (!this.rJ) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        this.rM = TextUtils.isEmpty(charSequence) ? false : true;
        ViewCompat.animate(this.rK).cancel();
        if (this.rM) {
            this.rK.setText(charSequence);
            this.rK.setVisibility(0);
            if (z) {
                if (ViewCompat.getAlpha(this.rK) == 1.0f) {
                    ViewCompat.setAlpha(this.rK, 0.0f);
                }
                ViewCompat.animate(this.rK).alpha(1.0f).setDuration(200L).setInterpolator(android.support.design.widget.a.kD).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.design.widget.TextInputLayout.2
                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                    public void onAnimationStart(View view) {
                        view.setVisibility(0);
                    }
                }).start();
            } else {
                ViewCompat.setAlpha(this.rK, 1.0f);
            }
        } else if (this.rK.getVisibility() == 0) {
            if (z) {
                ViewCompat.animate(this.rK).alpha(0.0f).setDuration(200L).setInterpolator(android.support.design.widget.a.kC).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.design.widget.TextInputLayout.3
                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(View view) {
                        TextInputLayout.this.rK.setText(charSequence);
                        view.setVisibility(4);
                    }
                }).start();
            } else {
                this.rK.setText(charSequence);
                this.rK.setVisibility(4);
            }
        }
        ct();
        p(z);
    }

    public void setCounterEnabled(boolean z) {
        if (this.rO != z) {
            if (z) {
                this.rP = new TextView(getContext());
                this.rP.setMaxLines(1);
                try {
                    TextViewCompat.setTextAppearance(this.rP, this.rR);
                } catch (Exception e) {
                    TextViewCompat.setTextAppearance(this.rP, android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption);
                    this.rP.setTextColor(ContextCompat.getColor(getContext(), R.color.design_textinput_error_color_light));
                }
                a(this.rP, -1);
                if (this.rD == null) {
                    P(0);
                } else {
                    P(this.rD.getText().length());
                }
            } else {
                b(this.rP);
                this.rP = null;
            }
            this.rO = z;
        }
    }

    public boolean isCounterEnabled() {
        return this.rO;
    }

    public void setCounterMaxLength(int i) {
        if (this.rQ != i) {
            if (i > 0) {
                this.rQ = i;
            } else {
                this.rQ = -1;
            }
            if (this.rO) {
                P(this.rD == null ? 0 : this.rD.getText().length());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        b(this, z);
        super.setEnabled(z);
    }

    private static void b(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                b((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.rQ;
    }

    void P(int i) {
        boolean z = this.rT;
        if (this.rQ == -1) {
            this.rP.setText(String.valueOf(i));
            this.rT = false;
        } else {
            this.rT = i > this.rQ;
            if (z != this.rT) {
                TextViewCompat.setTextAppearance(this.rP, this.rT ? this.rS : this.rR);
            }
            this.rP.setText(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.rQ)));
        }
        if (this.rD != null && z != this.rT) {
            p(false);
            ct();
        }
    }

    private void ct() {
        Drawable background;
        if (this.rD != null && (background = this.rD.getBackground()) != null) {
            cu();
            if (DrawableUtils.canSafelyMutateDrawable(background)) {
                background = background.mutate();
            }
            if (this.rM && this.rK != null) {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.rK.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            } else if (this.rT && this.rP != null) {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.rP.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            } else {
                DrawableCompat.clearColorFilter(background);
                this.rD.refreshDrawableState();
            }
        }
    }

    private void cu() {
        Drawable background;
        int i = Build.VERSION.SDK_INT;
        if ((i == 21 || i == 22) && (background = this.rD.getBackground()) != null && !this.sj) {
            Drawable newDrawable = background.getConstantState().newDrawable();
            if (background instanceof DrawableContainer) {
                this.sj = f.a((DrawableContainer) background, newDrawable.getConstantState());
            }
            if (!this.sj) {
                ViewCompat.setBackground(this.rD, newDrawable);
                this.sj = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: android.support.design.widget.TextInputLayout.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: f */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: Q */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        CharSequence so;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.so = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.so, parcel, i);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.so) + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.rM) {
            savedState.so = getError();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.so);
        requestLayout();
    }

    public CharSequence getError() {
        if (this.rJ) {
            return this.rN;
        }
        return null;
    }

    public boolean isHintAnimationEnabled() {
        return this.si;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.si = z;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.rE) {
            this.nh.draw(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        cv();
        super.onMeasure(i, i2);
    }

    private void cv() {
        if (this.rD != null) {
            if (cy()) {
                if (this.rX == null) {
                    this.rX = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_password_icon, (ViewGroup) this.rC, false);
                    this.rX.setImageDrawable(this.rV);
                    this.rX.setContentDescription(this.rW);
                    this.rC.addView(this.rX);
                    this.rX.setOnClickListener(new View.OnClickListener() { // from class: android.support.design.widget.TextInputLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            TextInputLayout.this.cw();
                        }
                    });
                }
                this.rX.setVisibility(0);
                if (this.rZ == null) {
                    this.rZ = new ColorDrawable();
                }
                this.rZ.setBounds(0, 0, this.rX.getMeasuredWidth(), 1);
                Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.rD);
                if (compoundDrawablesRelative[2] != this.rZ) {
                    this.sa = compoundDrawablesRelative[2];
                }
                TextViewCompat.setCompoundDrawablesRelative(this.rD, compoundDrawablesRelative[0], compoundDrawablesRelative[1], this.rZ, compoundDrawablesRelative[3]);
                this.rX.setPadding(this.rD.getPaddingLeft(), this.rD.getPaddingTop(), this.rD.getPaddingRight(), this.rD.getPaddingBottom());
                return;
            }
            if (this.rX != null && this.rX.getVisibility() == 0) {
                this.rX.setVisibility(8);
            }
            Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.rD);
            if (compoundDrawablesRelative2[2] == this.rZ) {
                TextViewCompat.setCompoundDrawablesRelative(this.rD, compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], this.sa, compoundDrawablesRelative2[3]);
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.rV = drawable;
        if (this.rX != null) {
            this.rX.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.rW = charSequence;
        if (this.rX != null) {
            this.rX.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.rV;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.rW;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.rU;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.rU != z) {
            this.rU = z;
            if (!z && this.rY && this.rD != null) {
                this.rD.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.rY = false;
            cv();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.sb = colorStateList;
        this.sc = true;
        cz();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.sd = mode;
        this.se = true;
        cz();
    }

    void cw() {
        if (this.rU) {
            int selectionEnd = this.rD.getSelectionEnd();
            if (cx()) {
                this.rD.setTransformationMethod(null);
                this.rY = true;
            } else {
                this.rD.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.rY = false;
            }
            this.rX.setChecked(this.rY);
            this.rD.setSelection(selectionEnd);
        }
    }

    private boolean cx() {
        return this.rD != null && (this.rD.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean cy() {
        return this.rU && (cx() || this.rY);
    }

    private void cz() {
        if (this.rV != null) {
            if (this.sc || this.se) {
                this.rV = DrawableCompat.wrap(this.rV).mutate();
                if (this.sc) {
                    DrawableCompat.setTintList(this.rV, this.sb);
                }
                if (this.se) {
                    DrawableCompat.setTintMode(this.rV, this.sd);
                }
                if (this.rX != null && this.rX.getDrawable() != this.rV) {
                    this.rX.setImageDrawable(this.rV);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.rE && this.rD != null) {
            Rect rect = this.mTmpRect;
            v.b(this, this.rD, rect);
            int compoundPaddingLeft = rect.left + this.rD.getCompoundPaddingLeft();
            int compoundPaddingRight = rect.right - this.rD.getCompoundPaddingRight();
            this.nh.c(compoundPaddingLeft, rect.top + this.rD.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.rD.getCompoundPaddingBottom());
            this.nh.d(compoundPaddingLeft, getPaddingTop(), compoundPaddingRight, (i4 - i2) - getPaddingBottom());
            this.nh.bn();
        }
    }

    private void q(boolean z) {
        if (this.qm != null && this.qm.isRunning()) {
            this.qm.cancel();
        }
        if (z && this.si) {
            p(1.0f);
        } else {
            this.nh.h(1.0f);
        }
        this.sh = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        boolean z = true;
        if (!this.sk) {
            this.sk = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                z = false;
            }
            p(z);
            ct();
            if (this.nh != null ? this.nh.setState(drawableState) | false : false) {
                invalidate();
            }
            this.sk = false;
        }
    }

    private void s(boolean z) {
        if (this.qm != null && this.qm.isRunning()) {
            this.qm.cancel();
        }
        if (z && this.si) {
            p(0.0f);
        } else {
            this.nh.h(0.0f);
        }
        this.sh = true;
    }

    private void p(float f) {
        if (this.nh.bg() != f) {
            if (this.qm == null) {
                this.qm = z.cE();
                this.qm.setInterpolator(android.support.design.widget.a.LINEAR_INTERPOLATOR);
                this.qm.setDuration(200L);
                this.qm.a(new s.c() { // from class: android.support.design.widget.TextInputLayout.5
                    @Override // android.support.design.widget.s.c
                    public void a(s sVar) {
                        TextInputLayout.this.nh.h(sVar.cB());
                    }
                });
            }
            this.qm.e(this.nh.bg(), f);
            this.qm.start();
        }
    }

    /* loaded from: classes2.dex */
    private class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence text = TextInputLayout.this.nh.getText();
            if (!TextUtils.isEmpty(text)) {
                accessibilityEvent.getText().add(text);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(TextInputLayout.class.getSimpleName());
            CharSequence text = TextInputLayout.this.nh.getText();
            if (!TextUtils.isEmpty(text)) {
                accessibilityNodeInfoCompat.setText(text);
            }
            if (TextInputLayout.this.rD != null) {
                accessibilityNodeInfoCompat.setLabelFor(TextInputLayout.this.rD);
            }
            CharSequence text2 = TextInputLayout.this.rK != null ? TextInputLayout.this.rK.getText() : null;
            if (!TextUtils.isEmpty(text2)) {
                accessibilityNodeInfoCompat.setContentInvalid(true);
                accessibilityNodeInfoCompat.setError(text2);
            }
        }
    }

    private static boolean b(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
