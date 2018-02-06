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
    private s qn;
    private final FrameLayout rD;
    EditText rE;
    private boolean rF;
    private CharSequence rG;
    private Paint rH;
    private LinearLayout rI;
    private int rJ;
    private boolean rK;
    TextView rL;
    private int rM;
    private boolean rN;
    private CharSequence rO;
    boolean rP;
    private TextView rQ;
    private int rR;
    private int rS;
    private int rT;
    private boolean rU;
    private boolean rV;
    private Drawable rW;
    private CharSequence rX;
    private CheckableImageButton rY;
    private boolean rZ;
    private Drawable sa;
    private Drawable sb;
    private ColorStateList sc;
    private boolean sd;
    private PorterDuff.Mode se;
    private boolean sf;
    private ColorStateList sg;
    private ColorStateList sh;
    private boolean si;
    private boolean sj;
    private boolean sk;
    private boolean sl;

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
        this.rD = new FrameLayout(context);
        this.rD.setAddStatesFromChildren(true);
        addView(this.rD);
        this.nh.a(android.support.design.widget.a.kB);
        this.nh.b(new AccelerateInterpolator());
        this.nh.s(8388659);
        this.si = this.nh.bg() == 1.0f;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TextInputLayout, i, R.style.Widget_Design_TextInputLayout);
        this.rF = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(obtainStyledAttributes.getText(R.styleable.TextInputLayout_android_hint));
        this.sj = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        if (obtainStyledAttributes.hasValue(R.styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
            this.sh = colorStateList;
            this.sg = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        this.rM = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(obtainStyledAttributes.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.rS = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.rT = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.rV = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, true);
        this.rW = obtainStyledAttributes.getDrawable(R.styleable.TextInputLayout_passwordToggleDrawable);
        this.rX = obtainStyledAttributes.getText(R.styleable.TextInputLayout_passwordToggleContentDescription);
        if (obtainStyledAttributes.hasValue(R.styleable.TextInputLayout_passwordToggleTint)) {
            this.sd = true;
            this.sc = obtainStyledAttributes.getColorStateList(R.styleable.TextInputLayout_passwordToggleTint);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode)) {
            this.sf = true;
            this.se = z.a(obtainStyledAttributes.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
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
            this.rD.addView(view, new FrameLayout.LayoutParams(layoutParams));
            this.rD.setLayoutParams(layoutParams);
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
        if (this.rE != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.rE = editText;
        if (!cx()) {
            this.nh.c(this.rE.getTypeface());
        }
        this.nh.g(this.rE.getTextSize());
        int gravity = this.rE.getGravity();
        this.nh.s((8388615 & gravity) | 48);
        this.nh.r(gravity);
        this.rE.addTextChangedListener(new TextWatcher() { // from class: android.support.design.widget.TextInputLayout.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.p(true);
                if (TextInputLayout.this.rP) {
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
        if (this.sg == null) {
            this.sg = this.rE.getHintTextColors();
        }
        if (this.rF && TextUtils.isEmpty(this.rG)) {
            setHint(this.rE.getHint());
            this.rE.setHint((CharSequence) null);
        }
        if (this.rQ != null) {
            P(this.rE.getText().length());
        }
        if (this.rI != null) {
            cs();
        }
        cv();
        p(false);
    }

    private void cr() {
        int i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.rD.getLayoutParams();
        if (this.rF) {
            if (this.rH == null) {
                this.rH = new Paint();
            }
            this.rH.setTypeface(this.nh.be());
            this.rH.setTextSize(this.nh.bh());
            i = (int) (-this.rH.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.rD.requestLayout();
        }
    }

    void p(boolean z) {
        boolean isEnabled = isEnabled();
        boolean z2 = (this.rE == null || TextUtils.isEmpty(this.rE.getText())) ? false : true;
        boolean b = b(getDrawableState(), 16842908);
        boolean z3 = TextUtils.isEmpty(getError()) ? false : true;
        if (this.sg != null) {
            this.nh.c(this.sg);
        }
        if (isEnabled && this.rU && this.rQ != null) {
            this.nh.b(this.rQ.getTextColors());
        } else if (isEnabled && b && this.sh != null) {
            this.nh.b(this.sh);
        } else if (this.sg != null) {
            this.nh.b(this.sg);
        }
        if (z2 || (isEnabled() && (b || z3))) {
            q(z);
        } else {
            s(z);
        }
    }

    public EditText getEditText() {
        return this.rE;
    }

    public void setHint(CharSequence charSequence) {
        if (this.rF) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        this.rG = charSequence;
        this.nh.setText(charSequence);
    }

    public CharSequence getHint() {
        if (this.rF) {
            return this.rG;
        }
        return null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.rF) {
            this.rF = z;
            CharSequence hint = this.rE.getHint();
            if (!this.rF) {
                if (!TextUtils.isEmpty(this.rG) && TextUtils.isEmpty(hint)) {
                    this.rE.setHint(this.rG);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.rG)) {
                    setHint(hint);
                }
                this.rE.setHint((CharSequence) null);
            }
            if (this.rE != null) {
                cr();
            }
        }
    }

    public boolean isHintEnabled() {
        return this.rF;
    }

    public void setHintTextAppearance(int i) {
        this.nh.t(i);
        this.sh = this.nh.bp();
        if (this.rE != null) {
            p(false);
            cr();
        }
    }

    private void a(TextView textView, int i) {
        if (this.rI == null) {
            this.rI = new LinearLayout(getContext());
            this.rI.setOrientation(0);
            addView(this.rI, -1, -2);
            this.rI.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.rE != null) {
                cs();
            }
        }
        this.rI.setVisibility(0);
        this.rI.addView(textView, i);
        this.rJ++;
    }

    private void cs() {
        ViewCompat.setPaddingRelative(this.rI, ViewCompat.getPaddingStart(this.rE), 0, ViewCompat.getPaddingEnd(this.rE), this.rE.getPaddingBottom());
    }

    private void b(TextView textView) {
        if (this.rI != null) {
            this.rI.removeView(textView);
            int i = this.rJ - 1;
            this.rJ = i;
            if (i == 0) {
                this.rI.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setErrorEnabled(boolean z) {
        boolean z2;
        if (this.rK != z) {
            if (this.rL != null) {
                ViewCompat.animate(this.rL).cancel();
            }
            if (z) {
                this.rL = new TextView(getContext());
                try {
                    TextViewCompat.setTextAppearance(this.rL, this.rM);
                } catch (Exception e) {
                    z2 = true;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    if (this.rL.getTextColors().getDefaultColor() == -65281) {
                        z2 = true;
                        if (z2) {
                            TextViewCompat.setTextAppearance(this.rL, android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption);
                            this.rL.setTextColor(ContextCompat.getColor(getContext(), R.color.design_textinput_error_color_light));
                        }
                        this.rL.setVisibility(4);
                        ViewCompat.setAccessibilityLiveRegion(this.rL, 1);
                        a(this.rL, 0);
                    }
                }
                z2 = false;
                if (z2) {
                }
                this.rL.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(this.rL, 1);
                a(this.rL, 0);
            } else {
                this.rN = false;
                ct();
                b(this.rL);
                this.rL = null;
            }
            this.rK = z;
        }
    }

    public boolean isErrorEnabled() {
        return this.rK;
    }

    public void setError(CharSequence charSequence) {
        a(charSequence, ViewCompat.isLaidOut(this) && isEnabled() && (this.rL == null || !TextUtils.equals(this.rL.getText(), charSequence)));
    }

    private void a(final CharSequence charSequence, boolean z) {
        this.rO = charSequence;
        if (!this.rK) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        this.rN = TextUtils.isEmpty(charSequence) ? false : true;
        ViewCompat.animate(this.rL).cancel();
        if (this.rN) {
            this.rL.setText(charSequence);
            this.rL.setVisibility(0);
            if (z) {
                if (ViewCompat.getAlpha(this.rL) == 1.0f) {
                    ViewCompat.setAlpha(this.rL, 0.0f);
                }
                ViewCompat.animate(this.rL).alpha(1.0f).setDuration(200L).setInterpolator(android.support.design.widget.a.kD).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.design.widget.TextInputLayout.2
                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                    public void onAnimationStart(View view) {
                        view.setVisibility(0);
                    }
                }).start();
            } else {
                ViewCompat.setAlpha(this.rL, 1.0f);
            }
        } else if (this.rL.getVisibility() == 0) {
            if (z) {
                ViewCompat.animate(this.rL).alpha(0.0f).setDuration(200L).setInterpolator(android.support.design.widget.a.kC).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.design.widget.TextInputLayout.3
                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(View view) {
                        TextInputLayout.this.rL.setText(charSequence);
                        view.setVisibility(4);
                    }
                }).start();
            } else {
                this.rL.setText(charSequence);
                this.rL.setVisibility(4);
            }
        }
        ct();
        p(z);
    }

    public void setCounterEnabled(boolean z) {
        if (this.rP != z) {
            if (z) {
                this.rQ = new TextView(getContext());
                this.rQ.setMaxLines(1);
                try {
                    TextViewCompat.setTextAppearance(this.rQ, this.rS);
                } catch (Exception e) {
                    TextViewCompat.setTextAppearance(this.rQ, android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption);
                    this.rQ.setTextColor(ContextCompat.getColor(getContext(), R.color.design_textinput_error_color_light));
                }
                a(this.rQ, -1);
                if (this.rE == null) {
                    P(0);
                } else {
                    P(this.rE.getText().length());
                }
            } else {
                b(this.rQ);
                this.rQ = null;
            }
            this.rP = z;
        }
    }

    public boolean isCounterEnabled() {
        return this.rP;
    }

    public void setCounterMaxLength(int i) {
        if (this.rR != i) {
            if (i > 0) {
                this.rR = i;
            } else {
                this.rR = -1;
            }
            if (this.rP) {
                P(this.rE == null ? 0 : this.rE.getText().length());
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
        return this.rR;
    }

    void P(int i) {
        boolean z = this.rU;
        if (this.rR == -1) {
            this.rQ.setText(String.valueOf(i));
            this.rU = false;
        } else {
            this.rU = i > this.rR;
            if (z != this.rU) {
                TextViewCompat.setTextAppearance(this.rQ, this.rU ? this.rT : this.rS);
            }
            this.rQ.setText(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.rR)));
        }
        if (this.rE != null && z != this.rU) {
            p(false);
            ct();
        }
    }

    private void ct() {
        Drawable background;
        if (this.rE != null && (background = this.rE.getBackground()) != null) {
            cu();
            if (DrawableUtils.canSafelyMutateDrawable(background)) {
                background = background.mutate();
            }
            if (this.rN && this.rL != null) {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.rL.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            } else if (this.rU && this.rQ != null) {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.rQ.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            } else {
                DrawableCompat.clearColorFilter(background);
                this.rE.refreshDrawableState();
            }
        }
    }

    private void cu() {
        Drawable background;
        int i = Build.VERSION.SDK_INT;
        if ((i == 21 || i == 22) && (background = this.rE.getBackground()) != null && !this.sk) {
            Drawable newDrawable = background.getConstantState().newDrawable();
            if (background instanceof DrawableContainer) {
                this.sk = f.a((DrawableContainer) background, newDrawable.getConstantState());
            }
            if (!this.sk) {
                ViewCompat.setBackground(this.rE, newDrawable);
                this.sk = true;
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
        CharSequence sq;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.sq = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.sq, parcel, i);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.sq) + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.rN) {
            savedState.sq = getError();
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
        setError(savedState.sq);
        requestLayout();
    }

    public CharSequence getError() {
        if (this.rK) {
            return this.rO;
        }
        return null;
    }

    public boolean isHintAnimationEnabled() {
        return this.sj;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.sj = z;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.rF) {
            this.nh.draw(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        cv();
        super.onMeasure(i, i2);
    }

    private void cv() {
        if (this.rE != null) {
            if (cy()) {
                if (this.rY == null) {
                    this.rY = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_password_icon, (ViewGroup) this.rD, false);
                    this.rY.setImageDrawable(this.rW);
                    this.rY.setContentDescription(this.rX);
                    this.rD.addView(this.rY);
                    this.rY.setOnClickListener(new View.OnClickListener() { // from class: android.support.design.widget.TextInputLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            TextInputLayout.this.cw();
                        }
                    });
                }
                this.rY.setVisibility(0);
                if (this.sa == null) {
                    this.sa = new ColorDrawable();
                }
                this.sa.setBounds(0, 0, this.rY.getMeasuredWidth(), 1);
                Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.rE);
                if (compoundDrawablesRelative[2] != this.sa) {
                    this.sb = compoundDrawablesRelative[2];
                }
                TextViewCompat.setCompoundDrawablesRelative(this.rE, compoundDrawablesRelative[0], compoundDrawablesRelative[1], this.sa, compoundDrawablesRelative[3]);
                this.rY.setPadding(this.rE.getPaddingLeft(), this.rE.getPaddingTop(), this.rE.getPaddingRight(), this.rE.getPaddingBottom());
                return;
            }
            if (this.rY != null && this.rY.getVisibility() == 0) {
                this.rY.setVisibility(8);
            }
            Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.rE);
            if (compoundDrawablesRelative2[2] == this.sa) {
                TextViewCompat.setCompoundDrawablesRelative(this.rE, compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], this.sb, compoundDrawablesRelative2[3]);
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.rW = drawable;
        if (this.rY != null) {
            this.rY.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.rX = charSequence;
        if (this.rY != null) {
            this.rY.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.rW;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.rX;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.rV;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.rV != z) {
            this.rV = z;
            if (!z && this.rZ && this.rE != null) {
                this.rE.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.rZ = false;
            cv();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.sc = colorStateList;
        this.sd = true;
        cz();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.se = mode;
        this.sf = true;
        cz();
    }

    void cw() {
        if (this.rV) {
            int selectionEnd = this.rE.getSelectionEnd();
            if (cx()) {
                this.rE.setTransformationMethod(null);
                this.rZ = true;
            } else {
                this.rE.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.rZ = false;
            }
            this.rY.setChecked(this.rZ);
            this.rE.setSelection(selectionEnd);
        }
    }

    private boolean cx() {
        return this.rE != null && (this.rE.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean cy() {
        return this.rV && (cx() || this.rZ);
    }

    private void cz() {
        if (this.rW != null) {
            if (this.sd || this.sf) {
                this.rW = DrawableCompat.wrap(this.rW).mutate();
                if (this.sd) {
                    DrawableCompat.setTintList(this.rW, this.sc);
                }
                if (this.sf) {
                    DrawableCompat.setTintMode(this.rW, this.se);
                }
                if (this.rY != null && this.rY.getDrawable() != this.rW) {
                    this.rY.setImageDrawable(this.rW);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.rF && this.rE != null) {
            Rect rect = this.mTmpRect;
            v.b(this, this.rE, rect);
            int compoundPaddingLeft = rect.left + this.rE.getCompoundPaddingLeft();
            int compoundPaddingRight = rect.right - this.rE.getCompoundPaddingRight();
            this.nh.c(compoundPaddingLeft, rect.top + this.rE.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.rE.getCompoundPaddingBottom());
            this.nh.d(compoundPaddingLeft, getPaddingTop(), compoundPaddingRight, (i4 - i2) - getPaddingBottom());
            this.nh.bn();
        }
    }

    private void q(boolean z) {
        if (this.qn != null && this.qn.isRunning()) {
            this.qn.cancel();
        }
        if (z && this.sj) {
            p(1.0f);
        } else {
            this.nh.h(1.0f);
        }
        this.si = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        boolean z = true;
        if (!this.sl) {
            this.sl = true;
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
            this.sl = false;
        }
    }

    private void s(boolean z) {
        if (this.qn != null && this.qn.isRunning()) {
            this.qn.cancel();
        }
        if (z && this.sj) {
            p(0.0f);
        } else {
            this.nh.h(0.0f);
        }
        this.si = true;
    }

    private void p(float f) {
        if (this.nh.bg() != f) {
            if (this.qn == null) {
                this.qn = z.cE();
                this.qn.setInterpolator(android.support.design.widget.a.LINEAR_INTERPOLATOR);
                this.qn.setDuration(200L);
                this.qn.a(new s.c() { // from class: android.support.design.widget.TextInputLayout.5
                    @Override // android.support.design.widget.s.c
                    public void a(s sVar) {
                        TextInputLayout.this.nh.h(sVar.cB());
                    }
                });
            }
            this.qn.e(this.nh.bg(), f);
            this.qn.start();
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
            if (TextInputLayout.this.rE != null) {
                accessibilityNodeInfoCompat.setLabelFor(TextInputLayout.this.rE);
            }
            CharSequence text2 = TextInputLayout.this.rL != null ? TextInputLayout.this.rL.getText() : null;
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
