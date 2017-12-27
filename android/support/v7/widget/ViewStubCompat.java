package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.RestrictTo;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
@RestrictTo
/* loaded from: classes2.dex */
public final class ViewStubCompat extends View {
    private int Ys;
    private int Yt;
    private WeakReference<View> Yu;
    private OnInflateListener Yv;
    private LayoutInflater mInflater;

    /* loaded from: classes2.dex */
    public interface OnInflateListener {
        void onInflate(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ys = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewStubCompat, i, 0);
        this.Yt = obtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.Ys = obtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.Yt;
    }

    public void setInflatedId(int i) {
        this.Yt = i;
    }

    public int getLayoutResource() {
        return this.Ys;
    }

    public void setLayoutResource(int i) {
        this.Ys = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.mInflater = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.Yu != null) {
            View view = this.Yu.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            inflate();
        }
    }

    public View inflate() {
        LayoutInflater from;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            if (this.Ys != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (this.mInflater != null) {
                    from = this.mInflater;
                } else {
                    from = LayoutInflater.from(getContext());
                }
                View inflate = from.inflate(this.Ys, viewGroup, false);
                if (this.Yt != -1) {
                    inflate.setId(this.Yt);
                }
                int indexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(inflate, indexOfChild, layoutParams);
                } else {
                    viewGroup.addView(inflate, indexOfChild);
                }
                this.Yu = new WeakReference<>(inflate);
                if (this.Yv != null) {
                    this.Yv.onInflate(this, inflate);
                }
                return inflate;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        this.Yv = onInflateListener;
    }
}
