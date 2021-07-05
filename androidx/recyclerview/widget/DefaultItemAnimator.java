package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public static TimeInterpolator sDefaultInterpolator;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<RecyclerView.ViewHolder> mAddAnimations;
    public ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList;
    public ArrayList<RecyclerView.ViewHolder> mChangeAnimations;
    public ArrayList<ArrayList<ChangeInfo>> mChangesList;
    public ArrayList<RecyclerView.ViewHolder> mMoveAnimations;
    public ArrayList<ArrayList<MoveInfo>> mMovesList;
    public ArrayList<RecyclerView.ViewHolder> mPendingAdditions;
    public ArrayList<ChangeInfo> mPendingChanges;
    public ArrayList<MoveInfo> mPendingMoves;
    public ArrayList<RecyclerView.ViewHolder> mPendingRemovals;
    public ArrayList<RecyclerView.ViewHolder> mRemoveAnimations;

    /* loaded from: classes.dex */
    public static class MoveInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int toX;
        public int toY;

        public MoveInfo(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewHolder, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.holder = viewHolder;
            this.fromX = i2;
            this.fromY = i3;
            this.toX = i4;
            this.toY = i5;
        }
    }

    public DefaultItemAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPendingRemovals = new ArrayList<>();
        this.mPendingAdditions = new ArrayList<>();
        this.mPendingMoves = new ArrayList<>();
        this.mPendingChanges = new ArrayList<>();
        this.mAdditionsList = new ArrayList<>();
        this.mMovesList = new ArrayList<>();
        this.mChangesList = new ArrayList<>();
        this.mAddAnimations = new ArrayList<>();
        this.mMoveAnimations = new ArrayList<>();
        this.mRemoveAnimations = new ArrayList<>();
        this.mChangeAnimations = new ArrayList<>();
    }

    private void animateRemoveImpl(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, viewHolder) == null) {
            View view = viewHolder.itemView;
            ViewPropertyAnimator animate = view.animate();
            this.mRemoveAnimations.add(viewHolder);
            animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new AnimatorListenerAdapter(this, viewHolder, animate, view) { // from class: androidx.recyclerview.widget.DefaultItemAnimator.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DefaultItemAnimator this$0;
                public final /* synthetic */ ViewPropertyAnimator val$animation;
                public final /* synthetic */ RecyclerView.ViewHolder val$holder;
                public final /* synthetic */ View val$view;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, viewHolder, animate, view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$holder = viewHolder;
                    this.val$animation = animate;
                    this.val$view = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.val$animation.setListener(null);
                        this.val$view.setAlpha(1.0f);
                        this.this$0.dispatchRemoveFinished(this.val$holder);
                        this.this$0.mRemoveAnimations.remove(this.val$holder);
                        this.this$0.dispatchFinishedWhenDone();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        this.this$0.dispatchRemoveStarting(this.val$holder);
                    }
                }
            }).start();
        }
    }

    private void endChangeAnimation(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, list, viewHolder) == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ChangeInfo changeInfo = list.get(size);
                if (endChangeAnimationIfNecessary(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                    list.remove(changeInfo);
                }
            }
        }
    }

    private void endChangeAnimationIfNecessary(ChangeInfo changeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, changeInfo) == null) {
            RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
            if (viewHolder != null) {
                endChangeAnimationIfNecessary(changeInfo, viewHolder);
            }
            RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
            if (viewHolder2 != null) {
                endChangeAnimationIfNecessary(changeInfo, viewHolder2);
            }
        }
    }

    private void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, viewHolder) == null) {
            if (sDefaultInterpolator == null) {
                sDefaultInterpolator = new ValueAnimator().getInterpolator();
            }
            viewHolder.itemView.animate().setInterpolator(sDefaultInterpolator);
            endAnimation(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewHolder)) == null) {
            resetAnimation(viewHolder);
            viewHolder.itemView.setAlpha(0.0f);
            this.mPendingAdditions.add(viewHolder);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void animateAddImpl(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) {
            View view = viewHolder.itemView;
            ViewPropertyAnimator animate = view.animate();
            this.mAddAnimations.add(viewHolder);
            animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new AnimatorListenerAdapter(this, viewHolder, view, animate) { // from class: androidx.recyclerview.widget.DefaultItemAnimator.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DefaultItemAnimator this$0;
                public final /* synthetic */ ViewPropertyAnimator val$animation;
                public final /* synthetic */ RecyclerView.ViewHolder val$holder;
                public final /* synthetic */ View val$view;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, viewHolder, view, animate};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$holder = viewHolder;
                    this.val$view = view;
                    this.val$animation = animate;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.val$view.setAlpha(1.0f);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        this.val$animation.setListener(null);
                        this.this$0.dispatchAddFinished(this.val$holder);
                        this.this$0.mAddAnimations.remove(this.val$holder);
                        this.this$0.dispatchFinishedWhenDone();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                        this.this$0.dispatchAddStarting(this.val$holder);
                    }
                }
            }).start();
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{viewHolder, viewHolder2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (viewHolder == viewHolder2) {
                return animateMove(viewHolder, i2, i3, i4, i5);
            }
            float translationX = viewHolder.itemView.getTranslationX();
            float translationY = viewHolder.itemView.getTranslationY();
            float alpha = viewHolder.itemView.getAlpha();
            resetAnimation(viewHolder);
            int i6 = (int) ((i4 - i2) - translationX);
            int i7 = (int) ((i5 - i3) - translationY);
            viewHolder.itemView.setTranslationX(translationX);
            viewHolder.itemView.setTranslationY(translationY);
            viewHolder.itemView.setAlpha(alpha);
            if (viewHolder2 != null) {
                resetAnimation(viewHolder2);
                viewHolder2.itemView.setTranslationX(-i6);
                viewHolder2.itemView.setTranslationY(-i7);
                viewHolder2.itemView.setAlpha(0.0f);
            }
            this.mPendingChanges.add(new ChangeInfo(viewHolder, viewHolder2, i2, i3, i4, i5));
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void animateChangeImpl(ChangeInfo changeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, changeInfo) == null) {
            RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
            View view = viewHolder == null ? null : viewHolder.itemView;
            RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
            View view2 = viewHolder2 != null ? viewHolder2.itemView : null;
            if (view != null) {
                ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
                this.mChangeAnimations.add(changeInfo.oldHolder);
                duration.translationX(changeInfo.toX - changeInfo.fromX);
                duration.translationY(changeInfo.toY - changeInfo.fromY);
                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter(this, changeInfo, duration, view) { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DefaultItemAnimator this$0;
                    public final /* synthetic */ ChangeInfo val$changeInfo;
                    public final /* synthetic */ ViewPropertyAnimator val$oldViewAnim;
                    public final /* synthetic */ View val$view;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, changeInfo, duration, view};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$changeInfo = changeInfo;
                        this.val$oldViewAnim = duration;
                        this.val$view = view;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            this.val$oldViewAnim.setListener(null);
                            this.val$view.setAlpha(1.0f);
                            this.val$view.setTranslationX(0.0f);
                            this.val$view.setTranslationY(0.0f);
                            this.this$0.dispatchChangeFinished(this.val$changeInfo.oldHolder, true);
                            this.this$0.mChangeAnimations.remove(this.val$changeInfo.oldHolder);
                            this.this$0.dispatchFinishedWhenDone();
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                            this.this$0.dispatchChangeStarting(this.val$changeInfo.oldHolder, true);
                        }
                    }
                }).start();
            }
            if (view2 != null) {
                ViewPropertyAnimator animate = view2.animate();
                this.mChangeAnimations.add(changeInfo.newHolder);
                animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnimatorListenerAdapter(this, changeInfo, animate, view2) { // from class: androidx.recyclerview.widget.DefaultItemAnimator.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DefaultItemAnimator this$0;
                    public final /* synthetic */ ChangeInfo val$changeInfo;
                    public final /* synthetic */ View val$newView;
                    public final /* synthetic */ ViewPropertyAnimator val$newViewAnimation;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, changeInfo, animate, view2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$changeInfo = changeInfo;
                        this.val$newViewAnimation = animate;
                        this.val$newView = view2;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            this.val$newViewAnimation.setListener(null);
                            this.val$newView.setAlpha(1.0f);
                            this.val$newView.setTranslationX(0.0f);
                            this.val$newView.setTranslationY(0.0f);
                            this.this$0.dispatchChangeFinished(this.val$changeInfo.newHolder, false);
                            this.this$0.mChangeAnimations.remove(this.val$changeInfo.newHolder);
                            this.this$0.dispatchFinishedWhenDone();
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                            this.this$0.dispatchChangeStarting(this.val$changeInfo.newHolder, false);
                        }
                    }
                }).start();
            }
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{viewHolder, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            View view = viewHolder.itemView;
            int translationX = i2 + ((int) view.getTranslationX());
            int translationY = i3 + ((int) viewHolder.itemView.getTranslationY());
            resetAnimation(viewHolder);
            int i6 = i4 - translationX;
            int i7 = i5 - translationY;
            if (i6 == 0 && i7 == 0) {
                dispatchMoveFinished(viewHolder);
                return false;
            }
            if (i6 != 0) {
                view.setTranslationX(-i6);
            }
            if (i7 != 0) {
                view.setTranslationY(-i7);
            }
            this.mPendingMoves.add(new MoveInfo(viewHolder, translationX, translationY, i4, i5));
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void animateMoveImpl(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{viewHolder, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            View view = viewHolder.itemView;
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            if (i6 != 0) {
                view.animate().translationX(0.0f);
            }
            if (i7 != 0) {
                view.animate().translationY(0.0f);
            }
            ViewPropertyAnimator animate = view.animate();
            this.mMoveAnimations.add(viewHolder);
            animate.setDuration(getMoveDuration()).setListener(new AnimatorListenerAdapter(this, viewHolder, i6, view, i7, animate) { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DefaultItemAnimator this$0;
                public final /* synthetic */ ViewPropertyAnimator val$animation;
                public final /* synthetic */ int val$deltaX;
                public final /* synthetic */ int val$deltaY;
                public final /* synthetic */ RecyclerView.ViewHolder val$holder;
                public final /* synthetic */ View val$view;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, viewHolder, Integer.valueOf(i6), view, Integer.valueOf(i7), animate};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i8 = newInitContext.flag;
                        if ((i8 & 1) != 0) {
                            int i9 = i8 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$holder = viewHolder;
                    this.val$deltaX = i6;
                    this.val$view = view;
                    this.val$deltaY = i7;
                    this.val$animation = animate;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        if (this.val$deltaX != 0) {
                            this.val$view.setTranslationX(0.0f);
                        }
                        if (this.val$deltaY != 0) {
                            this.val$view.setTranslationY(0.0f);
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        this.val$animation.setListener(null);
                        this.this$0.dispatchMoveFinished(this.val$holder);
                        this.this$0.mMoveAnimations.remove(this.val$holder);
                        this.this$0.dispatchFinishedWhenDone();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                        this.this$0.dispatchMoveStarting(this.val$holder);
                    }
                }
            }).start();
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewHolder)) == null) {
            resetAnimation(viewHolder);
            this.mPendingRemovals.add(viewHolder);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, viewHolder, list)) == null) ? !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list) : invokeLL.booleanValue;
    }

    public void cancelAll(List<RecyclerView.ViewHolder> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                list.get(size).itemView.animate().cancel();
            }
        }
    }

    public void dispatchFinishedWhenDone() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viewHolder) == null) {
            View view = viewHolder.itemView;
            view.animate().cancel();
            int size = this.mPendingMoves.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else if (this.mPendingMoves.get(size).holder == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    this.mPendingMoves.remove(size);
                }
            }
            endChangeAnimation(this.mPendingChanges, viewHolder);
            if (this.mPendingRemovals.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchRemoveFinished(viewHolder);
            }
            if (this.mPendingAdditions.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
            }
            for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
                ArrayList<ChangeInfo> arrayList = this.mChangesList.get(size2);
                endChangeAnimation(arrayList, viewHolder);
                if (arrayList.isEmpty()) {
                    this.mChangesList.remove(size2);
                }
            }
            for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
                ArrayList<MoveInfo> arrayList2 = this.mMovesList.get(size3);
                int size4 = arrayList2.size() - 1;
                while (true) {
                    if (size4 < 0) {
                        break;
                    } else if (arrayList2.get(size4).holder == viewHolder) {
                        view.setTranslationY(0.0f);
                        view.setTranslationX(0.0f);
                        dispatchMoveFinished(viewHolder);
                        arrayList2.remove(size4);
                        if (arrayList2.isEmpty()) {
                            this.mMovesList.remove(size3);
                        }
                    } else {
                        size4--;
                    }
                }
            }
            for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
                ArrayList<RecyclerView.ViewHolder> arrayList3 = this.mAdditionsList.get(size5);
                if (arrayList3.remove(viewHolder)) {
                    view.setAlpha(1.0f);
                    dispatchAddFinished(viewHolder);
                    if (arrayList3.isEmpty()) {
                        this.mAdditionsList.remove(size5);
                    }
                }
            }
            this.mRemoveAnimations.remove(viewHolder);
            this.mAddAnimations.remove(viewHolder);
            this.mChangeAnimations.remove(viewHolder);
            this.mMoveAnimations.remove(viewHolder);
            dispatchFinishedWhenDone();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int size = this.mPendingMoves.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                MoveInfo moveInfo = this.mPendingMoves.get(size);
                View view = moveInfo.holder.itemView;
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(moveInfo.holder);
                this.mPendingMoves.remove(size);
            }
            for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
                dispatchRemoveFinished(this.mPendingRemovals.get(size2));
                this.mPendingRemovals.remove(size2);
            }
            int size3 = this.mPendingAdditions.size();
            while (true) {
                size3--;
                if (size3 < 0) {
                    break;
                }
                RecyclerView.ViewHolder viewHolder = this.mPendingAdditions.get(size3);
                viewHolder.itemView.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                this.mPendingAdditions.remove(size3);
            }
            for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
                endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
            }
            this.mPendingChanges.clear();
            if (isRunning()) {
                for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                    ArrayList<MoveInfo> arrayList = this.mMovesList.get(size5);
                    for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                        MoveInfo moveInfo2 = arrayList.get(size6);
                        View view2 = moveInfo2.holder.itemView;
                        view2.setTranslationY(0.0f);
                        view2.setTranslationX(0.0f);
                        dispatchMoveFinished(moveInfo2.holder);
                        arrayList.remove(size6);
                        if (arrayList.isEmpty()) {
                            this.mMovesList.remove(arrayList);
                        }
                    }
                }
                for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                    ArrayList<RecyclerView.ViewHolder> arrayList2 = this.mAdditionsList.get(size7);
                    for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                        RecyclerView.ViewHolder viewHolder2 = arrayList2.get(size8);
                        viewHolder2.itemView.setAlpha(1.0f);
                        dispatchAddFinished(viewHolder2);
                        arrayList2.remove(size8);
                        if (arrayList2.isEmpty()) {
                            this.mAdditionsList.remove(arrayList2);
                        }
                    }
                }
                for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                    ArrayList<ChangeInfo> arrayList3 = this.mChangesList.get(size9);
                    for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                        endChangeAnimationIfNecessary(arrayList3.get(size10));
                        if (arrayList3.isEmpty()) {
                            this.mChangesList.remove(arrayList3);
                        }
                    }
                }
                cancelAll(this.mRemoveAnimations);
                cancelAll(this.mMoveAnimations);
                cancelAll(this.mAddAnimations);
                cancelAll(this.mChangeAnimations);
                dispatchAnimationsFinished();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true : invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            boolean z = !this.mPendingRemovals.isEmpty();
            boolean z2 = !this.mPendingMoves.isEmpty();
            boolean z3 = !this.mPendingChanges.isEmpty();
            boolean z4 = !this.mPendingAdditions.isEmpty();
            if (z || z2 || z4 || z3) {
                Iterator<RecyclerView.ViewHolder> it = this.mPendingRemovals.iterator();
                while (it.hasNext()) {
                    animateRemoveImpl(it.next());
                }
                this.mPendingRemovals.clear();
                if (z2) {
                    ArrayList<MoveInfo> arrayList = new ArrayList<>();
                    arrayList.addAll(this.mPendingMoves);
                    this.mMovesList.add(arrayList);
                    this.mPendingMoves.clear();
                    Runnable runnable = new Runnable(this, arrayList) { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultItemAnimator this$0;
                        public final /* synthetic */ ArrayList val$moves;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$moves = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Iterator it2 = this.val$moves.iterator();
                                while (it2.hasNext()) {
                                    MoveInfo moveInfo = (MoveInfo) it2.next();
                                    this.this$0.animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
                                }
                                this.val$moves.clear();
                                this.this$0.mMovesList.remove(this.val$moves);
                            }
                        }
                    };
                    if (z) {
                        ViewCompat.postOnAnimationDelayed(arrayList.get(0).holder.itemView, runnable, getRemoveDuration());
                    } else {
                        runnable.run();
                    }
                }
                if (z3) {
                    ArrayList<ChangeInfo> arrayList2 = new ArrayList<>();
                    arrayList2.addAll(this.mPendingChanges);
                    this.mChangesList.add(arrayList2);
                    this.mPendingChanges.clear();
                    Runnable runnable2 = new Runnable(this, arrayList2) { // from class: androidx.recyclerview.widget.DefaultItemAnimator.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultItemAnimator this$0;
                        public final /* synthetic */ ArrayList val$changes;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$changes = arrayList2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Iterator it2 = this.val$changes.iterator();
                                while (it2.hasNext()) {
                                    this.this$0.animateChangeImpl((ChangeInfo) it2.next());
                                }
                                this.val$changes.clear();
                                this.this$0.mChangesList.remove(this.val$changes);
                            }
                        }
                    };
                    if (z) {
                        ViewCompat.postOnAnimationDelayed(arrayList2.get(0).oldHolder.itemView, runnable2, getRemoveDuration());
                    } else {
                        runnable2.run();
                    }
                }
                if (z4) {
                    ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
                    arrayList3.addAll(this.mPendingAdditions);
                    this.mAdditionsList.add(arrayList3);
                    this.mPendingAdditions.clear();
                    Runnable runnable3 = new Runnable(this, arrayList3) { // from class: androidx.recyclerview.widget.DefaultItemAnimator.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultItemAnimator this$0;
                        public final /* synthetic */ ArrayList val$additions;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList3};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$additions = arrayList3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Iterator it2 = this.val$additions.iterator();
                                while (it2.hasNext()) {
                                    this.this$0.animateAddImpl((RecyclerView.ViewHolder) it2.next());
                                }
                                this.val$additions.clear();
                                this.this$0.mAdditionsList.remove(this.val$additions);
                            }
                        }
                    };
                    if (!z && !z2 && !z3) {
                        runnable3.run();
                    } else {
                        ViewCompat.postOnAnimationDelayed(arrayList3.get(0).itemView, runnable3, (z ? getRemoveDuration() : 0L) + Math.max(z2 ? getMoveDuration() : 0L, z3 ? getChangeDuration() : 0L));
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ChangeInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public int toX;
        public int toY;

        public ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewHolder, viewHolder2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.oldHolder = viewHolder;
            this.newHolder = viewHolder2;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
            this(viewHolder, viewHolder2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewHolder, viewHolder2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((RecyclerView.ViewHolder) objArr2[0], (RecyclerView.ViewHolder) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.fromX = i2;
            this.fromY = i3;
            this.toX = i4;
            this.toY = i5;
        }
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, changeInfo, viewHolder)) == null) {
            boolean z = false;
            if (changeInfo.newHolder == viewHolder) {
                changeInfo.newHolder = null;
            } else if (changeInfo.oldHolder != viewHolder) {
                return false;
            } else {
                changeInfo.oldHolder = null;
                z = true;
            }
            viewHolder.itemView.setAlpha(1.0f);
            viewHolder.itemView.setTranslationX(0.0f);
            viewHolder.itemView.setTranslationY(0.0f);
            dispatchChangeFinished(viewHolder, z);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
