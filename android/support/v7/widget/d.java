package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
class d {
    private a Mx;
    private a My;
    private a Mz;
    private final View mView;
    private int Mw = -1;
    private final AppCompatDrawableManager Mv = AppCompatDrawableManager.get();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(View view) {
        this.mView = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_android_background)) {
                this.Mw = obtainStyledAttributes.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList k = this.Mv.k(this.mView.getContext(), this.Mw);
                if (k != null) {
                    d(k);
                }
            }
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(this.mView, obtainStyledAttributes.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.a(obtainStyledAttributes.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void be(int i) {
        this.Mw = i;
        d(this.Mv != null ? this.Mv.k(this.mView.getContext(), i) : null);
        if (fH()) {
            fI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Drawable drawable) {
        this.Mw = -1;
        d((ColorStateList) null);
        if (fH()) {
            fI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.My == null) {
            this.My = new a();
        }
        this.My.MA = colorStateList;
        this.My.Xi = null;
        this.My.Xk = true;
        if (fH()) {
            fI();
        }
    }

    private boolean fH() {
        ColorStateList b;
        if (this.My != null && this.My.Xk) {
            if (this.Mw >= 0 && (b = this.Mv.b(this.mView.getContext(), this.Mw, this.My.MA)) != null) {
                this.My.Xi = b;
                return true;
            } else if (this.My.Xi != this.My.MA) {
                this.My.Xi = this.My.MA;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getSupportBackgroundTintList() {
        if (this.My != null) {
            return this.My.Xi;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.My == null) {
            this.My = new a();
        }
        this.My.uq = mode;
        this.My.Xj = true;
        fI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.My != null) {
            return this.My.uq;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fI() {
        Drawable background = this.mView.getBackground();
        if (background != null) {
            if (Build.VERSION.SDK_INT != 21 || !d(background)) {
                if (this.My != null) {
                    AppCompatDrawableManager.a(background, this.My, this.mView.getDrawableState());
                } else if (this.Mx != null) {
                    AppCompatDrawableManager.a(background, this.Mx, this.mView.getDrawableState());
                }
            }
        }
    }

    void d(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.Mx == null) {
                this.Mx = new a();
            }
            this.Mx.Xi = colorStateList;
            this.Mx.Xk = true;
        } else {
            this.Mx = null;
        }
        fI();
    }

    private boolean d(Drawable drawable) {
        if (this.Mz == null) {
            this.Mz = new a();
        }
        a aVar = this.Mz;
        aVar.clear();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.mView);
        if (backgroundTintList != null) {
            aVar.Xk = true;
            aVar.Xi = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.mView);
        if (backgroundTintMode != null) {
            aVar.Xj = true;
            aVar.uq = backgroundTintMode;
        }
        if (aVar.Xk || aVar.Xj) {
            AppCompatDrawableManager.a(drawable, aVar, this.mView.getDrawableState());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends t {
        public ColorStateList MA;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.v7.widget.t
        public void clear() {
            super.clear();
            this.MA = null;
        }
    }
}
