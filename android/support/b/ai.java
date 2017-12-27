package android.support.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ai {
    protected a vO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(Context context, ViewGroup viewGroup, View view) {
        this.vO = new a(context, viewGroup, view, this);
    }

    static ViewGroup P(View view) {
        View view2 = view;
        while (view2 != null) {
            if (view2.getId() == 16908290 && (view2 instanceof ViewGroup)) {
                return (ViewGroup) view2;
            }
            if (view2.getParent() instanceof ViewGroup) {
                view2 = (ViewGroup) view2.getParent();
            }
        }
        return null;
    }

    public static ai Q(View view) {
        ViewGroup P = P(view);
        if (P != null) {
            int childCount = P.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = P.getChildAt(i);
                if (childAt instanceof a) {
                    return ((a) childAt).vT;
                }
            }
            return new ah(P.getContext(), P, view);
        }
        return null;
    }

    public void add(Drawable drawable) {
        this.vO.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.vO.remove(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends ViewGroup {
        static Method vP;
        ViewGroup vQ;
        View vR;
        ArrayList<Drawable> vS;
        ai vT;

        static {
            try {
                vP = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException e) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, ai aiVar) {
            super(context);
            this.vS = null;
            this.vQ = viewGroup;
            this.vR = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.vT = aiVar;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public void add(Drawable drawable) {
            if (this.vS == null) {
                this.vS = new ArrayList<>();
            }
            if (!this.vS.contains(drawable)) {
                this.vS.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void remove(Drawable drawable) {
            if (this.vS != null) {
                this.vS.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            return super.verifyDrawable(drawable) || (this.vS != null && this.vS.contains(drawable));
        }

        public void add(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.vQ && viewGroup.getParent() != null) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.vQ.getLocationOnScreen(iArr2);
                    ViewCompat.offsetLeftAndRight(view, iArr[0] - iArr2[0]);
                    ViewCompat.offsetTopAndBottom(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        public void remove(View view) {
            super.removeView(view);
            if (isEmpty()) {
                this.vQ.removeView(this);
            }
        }

        boolean isEmpty() {
            return getChildCount() == 0 && (this.vS == null || this.vS.size() == 0);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            ViewGroup viewGroup = (ViewGroup) getParent();
            this.vQ.getLocationOnScreen(iArr);
            this.vR.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.vR.getWidth(), this.vR.getHeight()));
            super.dispatchDraw(canvas);
            int size = this.vS == null ? 0 : this.vS.size();
            for (int i = 0; i < size; i++) {
                this.vS.get(i).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        private void d(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            ViewGroup viewGroup = (ViewGroup) getParent();
            this.vQ.getLocationOnScreen(iArr2);
            this.vR.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.vQ != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.vQ instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    d(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
            }
            return null;
        }
    }
}
