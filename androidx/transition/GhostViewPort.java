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

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GhostViewPort(View view2) {
        super(view2.getContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                View view3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    ViewCompat.postInvalidateOnAnimation(this.this$0);
                    GhostViewPort ghostViewPort = this.this$0;
                    ViewGroup viewGroup = ghostViewPort.mStartParent;
                    if (viewGroup != null && (view3 = ghostViewPort.mStartView) != null) {
                        viewGroup.endViewTransition(view3);
                        ViewCompat.postInvalidateOnAnimation(this.this$0.mStartParent);
                        GhostViewPort ghostViewPort2 = this.this$0;
                        ghostViewPort2.mStartParent = null;
                        ghostViewPort2.mStartView = null;
                        return true;
                    }
                    return true;
                }
                return invokeV.booleanValue;
            }
        };
        this.mView = view2;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    public static GhostViewPort addGhost(View view2, ViewGroup viewGroup, Matrix matrix) {
        InterceptResult invokeLLL;
        GhostViewHolder ghostViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, view2, viewGroup, matrix)) == null) {
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
        return (GhostViewPort) invokeLLL.objValue;
    }

    public static void calculateMatrix(View view2, ViewGroup viewGroup, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, view2, viewGroup, matrix) == null) {
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            matrix.reset();
            ViewUtils.transformMatrixToGlobal(viewGroup2, matrix);
            matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
            ViewUtils.transformMatrixToLocal(viewGroup, matrix);
        }
    }

    public static void copySize(View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view2, view3) == null) {
            ViewUtils.setLeftTopRightBottom(view3, view3.getLeft(), view3.getTop(), view3.getLeft() + view2.getWidth(), view3.getTop() + view2.getHeight());
        }
    }

    public static void setGhostView(@NonNull View view2, @Nullable GhostViewPort ghostViewPort) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, view2, ghostViewPort) == null) {
            view2.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f090d42, ghostViewPort);
        }
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, viewGroup, view2) == null) {
            this.mStartParent = viewGroup;
            this.mStartView = view2;
        }
    }

    public static GhostViewPort getGhostView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) {
            return (GhostViewPort) view2.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f090d42);
        }
        return (GhostViewPort) invokeL.objValue;
    }

    public static void removeGhost(View view2) {
        GhostViewPort ghostView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, view2) == null) && (ghostView = getGhostView(view2)) != null) {
            int i = ghostView.mReferences - 1;
            ghostView.mReferences = i;
            if (i <= 0) {
                ((GhostViewHolder) ghostView.getParent()).removeView(ghostView);
            }
        }
    }

    public void setMatrix(@NonNull Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, matrix) == null) {
            this.mMatrix = matrix;
        }
    }

    @Override // android.view.View, androidx.transition.GhostView
    public void setVisibility(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
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
}
