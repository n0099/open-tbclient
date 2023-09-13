package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class GhostViewPort extends ViewGroup implements GhostView {
    @Nullable
    public Matrix mMatrix;
    public final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    public int mReferences;
    public ViewGroup mStartParent;
    public View mStartView;
    public final View mView;

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public GhostViewPort(View view2) {
        super(view2.getContext());
        this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.transition.GhostViewPort.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                View view3;
                ViewCompat.postInvalidateOnAnimation(GhostViewPort.this);
                GhostViewPort ghostViewPort = GhostViewPort.this;
                ViewGroup viewGroup = ghostViewPort.mStartParent;
                if (viewGroup != null && (view3 = ghostViewPort.mStartView) != null) {
                    viewGroup.endViewTransition(view3);
                    ViewCompat.postInvalidateOnAnimation(GhostViewPort.this.mStartParent);
                    GhostViewPort ghostViewPort2 = GhostViewPort.this;
                    ghostViewPort2.mStartParent = null;
                    ghostViewPort2.mStartView = null;
                    return true;
                }
                return true;
            }
        };
        this.mView = view2;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    public static GhostViewPort getGhostView(View view2) {
        return (GhostViewPort) view2.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f090e27);
    }

    public static void removeGhost(View view2) {
        GhostViewPort ghostView = getGhostView(view2);
        if (ghostView != null) {
            int i = ghostView.mReferences - 1;
            ghostView.mReferences = i;
            if (i <= 0) {
                ((GhostViewHolder) ghostView.getParent()).removeView(ghostView);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        CanvasUtils.enableZ(canvas, true);
        canvas.setMatrix(this.mMatrix);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        this.mView.invalidate();
        ViewUtils.setTransitionVisibility(this.mView, 4);
        drawChild(canvas, this.mView, getDrawingTime());
        CanvasUtils.enableZ(canvas, false);
    }

    public void setMatrix(@NonNull Matrix matrix) {
        this.mMatrix = matrix;
    }

    @Override // android.view.View, androidx.transition.GhostView
    public void setVisibility(int i) {
        int i2;
        super.setVisibility(i);
        if (getGhostView(this.mView) == this) {
            if (i == 0) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            ViewUtils.setTransitionVisibility(this.mView, i2);
        }
    }

    public static GhostViewPort addGhost(View view2, ViewGroup viewGroup, Matrix matrix) {
        GhostViewHolder ghostViewHolder;
        if (view2.getParent() instanceof ViewGroup) {
            GhostViewHolder holder = GhostViewHolder.getHolder(viewGroup);
            GhostViewPort ghostView = getGhostView(view2);
            int i = 0;
            if (ghostView != null && (ghostViewHolder = (GhostViewHolder) ghostView.getParent()) != holder) {
                i = ghostView.mReferences;
                ghostViewHolder.removeView(ghostView);
                ghostView = null;
            }
            if (ghostView == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    calculateMatrix(view2, viewGroup, matrix);
                }
                ghostView = new GhostViewPort(view2);
                ghostView.setMatrix(matrix);
                if (holder == null) {
                    holder = new GhostViewHolder(viewGroup);
                } else {
                    holder.popToOverlayTop();
                }
                copySize(viewGroup, holder);
                copySize(viewGroup, ghostView);
                holder.addGhostView(ghostView);
                ghostView.mReferences = i;
            } else if (matrix != null) {
                ghostView.setMatrix(matrix);
            }
            ghostView.mReferences++;
            return ghostView;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    public static void calculateMatrix(View view2, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
        matrix.reset();
        ViewUtils.transformMatrixToGlobal(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        ViewUtils.transformMatrixToLocal(viewGroup, matrix);
    }

    public static void copySize(View view2, View view3) {
        ViewUtils.setLeftTopRightBottom(view3, view3.getLeft(), view3.getTop(), view3.getLeft() + view2.getWidth(), view3.getTop() + view2.getHeight());
    }

    public static void setGhostView(@NonNull View view2, @Nullable GhostViewPort ghostViewPort) {
        view2.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f090e27, ghostViewPort);
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view2) {
        this.mStartParent = viewGroup;
        this.mStartView = view2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setGhostView(this.mView, this);
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 4);
        if (this.mView.getParent() != null) {
            ((View) this.mView.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        setGhostView(this.mView, null);
        if (this.mView.getParent() != null) {
            ((View) this.mView.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }
}
