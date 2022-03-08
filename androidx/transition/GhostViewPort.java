package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class GhostViewPort extends ViewGroup implements GhostView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Matrix mMatrix;
    public final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    public int mReferences;
    public ViewGroup mStartParent;
    public View mStartView;
    public final View mView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GhostViewPort(View view) {
        super(view.getContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener(this) { // from class: androidx.transition.GhostViewPort.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GhostViewPort this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                InterceptResult invokeV;
                View view2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    ViewCompat.postInvalidateOnAnimation(this.this$0);
                    GhostViewPort ghostViewPort = this.this$0;
                    ViewGroup viewGroup = ghostViewPort.mStartParent;
                    if (viewGroup == null || (view2 = ghostViewPort.mStartView) == null) {
                        return true;
                    }
                    viewGroup.endViewTransition(view2);
                    ViewCompat.postInvalidateOnAnimation(this.this$0.mStartParent);
                    GhostViewPort ghostViewPort2 = this.this$0;
                    ghostViewPort2.mStartParent = null;
                    ghostViewPort2.mStartView = null;
                    return true;
                }
                return invokeV.booleanValue;
            }
        };
        this.mView = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    public static GhostViewPort addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        InterceptResult invokeLLL;
        GhostViewHolder ghostViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, view, viewGroup, matrix)) == null) {
            if (view.getParent() instanceof ViewGroup) {
                GhostViewHolder holder = GhostViewHolder.getHolder(viewGroup);
                GhostViewPort ghostView = getGhostView(view);
                int i2 = 0;
                if (ghostView != null && (ghostViewHolder = (GhostViewHolder) ghostView.getParent()) != holder) {
                    i2 = ghostView.mReferences;
                    ghostViewHolder.removeView(ghostView);
                    ghostView = null;
                }
                if (ghostView == null) {
                    if (matrix == null) {
                        matrix = new Matrix();
                        calculateMatrix(view, viewGroup, matrix);
                    }
                    ghostView = new GhostViewPort(view);
                    ghostView.setMatrix(matrix);
                    if (holder == null) {
                        holder = new GhostViewHolder(viewGroup);
                    } else {
                        holder.popToOverlayTop();
                    }
                    copySize(viewGroup, holder);
                    copySize(viewGroup, ghostView);
                    holder.addGhostView(ghostView);
                    ghostView.mReferences = i2;
                } else if (matrix != null) {
                    ghostView.setMatrix(matrix);
                }
                ghostView.mReferences++;
                return ghostView;
            }
            throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        }
        return (GhostViewPort) invokeLLL.objValue;
    }

    public static void calculateMatrix(View view, ViewGroup viewGroup, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, view, viewGroup, matrix) == null) {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            matrix.reset();
            ViewUtils.transformMatrixToGlobal(viewGroup2, matrix);
            matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
            ViewUtils.transformMatrixToLocal(viewGroup, matrix);
        }
    }

    public static void copySize(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view, view2) == null) {
            ViewUtils.setLeftTopRightBottom(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
        }
    }

    public static GhostViewPort getGhostView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view)) == null) ? (GhostViewPort) view.getTag(R$id.ghost_view) : (GhostViewPort) invokeL.objValue;
    }

    public static void removeGhost(View view) {
        GhostViewPort ghostView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, view) == null) || (ghostView = getGhostView(view)) == null) {
            return;
        }
        int i2 = ghostView.mReferences - 1;
        ghostView.mReferences = i2;
        if (i2 <= 0) {
            ((GhostViewHolder) ghostView.getParent()).removeView(ghostView);
        }
    }

    public static void setGhostView(@NonNull View view, @Nullable GhostViewPort ghostViewPort) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, view, ghostViewPort) == null) {
            view.setTag(R$id.ghost_view, ghostViewPort);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAttachedToWindow();
            setGhostView(this.mView, this);
            this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
            ViewUtils.setTransitionVisibility(this.mView, 4);
            if (this.mView.getParent() != null) {
                ((View) this.mView.getParent()).invalidate();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
            ViewUtils.setTransitionVisibility(this.mView, 0);
            setGhostView(this.mView, null);
            if (this.mView.getParent() != null) {
                ((View) this.mView.getParent()).invalidate();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            CanvasUtils.enableZ(canvas, true);
            canvas.setMatrix(this.mMatrix);
            ViewUtils.setTransitionVisibility(this.mView, 0);
            this.mView.invalidate();
            ViewUtils.setTransitionVisibility(this.mView, 4);
            drawChild(canvas, this.mView, getDrawingTime());
            CanvasUtils.enableZ(canvas, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
        }
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, viewGroup, view) == null) {
            this.mStartParent = viewGroup;
            this.mStartView = view;
        }
    }

    public void setMatrix(@NonNull Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, matrix) == null) {
            this.mMatrix = matrix;
        }
    }

    @Override // android.view.View, androidx.transition.GhostView
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.setVisibility(i2);
            if (getGhostView(this.mView) == this) {
                ViewUtils.setTransitionVisibility(this.mView, i2 == 0 ? 4 : 0);
            }
        }
    }
}
