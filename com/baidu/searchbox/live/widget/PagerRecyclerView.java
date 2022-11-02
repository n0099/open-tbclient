package com.baidu.searchbox.live.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PagerRecyclerView extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CanScrollListener listener;
    public int mInitMotionX;
    public int mInitMotionY;
    public boolean mIsCanSwitchPage;
    public View.OnTouchListener mTouchListener;

    /* loaded from: classes2.dex */
    public interface CanScrollListener {
        boolean isCanScrollable(MotionEvent motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerRecyclerView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.mIsCanSwitchPage = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsCanSwitchPage = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIsCanSwitchPage = true;
    }

    public boolean isCanScrollable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            CanScrollListener canScrollListener = this.listener;
            if (canScrollListener != null) {
                return canScrollListener.isCanScrollable(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setCanScrollListener(CanScrollListener canScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canScrollListener) == null) {
            this.listener = canScrollListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, layoutManager) == null) {
            super.setLayoutManager(layoutManager);
            if (layoutManager instanceof View.OnTouchListener) {
                this.mTouchListener = (View.OnTouchListener) layoutManager;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (!isCanScrollable(motionEvent)) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    if (Math.abs(((int) motionEvent.getY()) - this.mInitMotionY) * 0.5f > Math.abs(((int) motionEvent.getX()) - this.mInitMotionX)) {
                        z = true;
                        if (!z && super.onInterceptTouchEvent(motionEvent)) {
                            return true;
                        }
                    }
                }
                z = false;
                return !z ? false : false;
            }
            this.mIsCanSwitchPage = true;
            this.mInitMotionY = (int) motionEvent.getY();
            this.mInitMotionX = (int) motionEvent.getX();
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 && !this.mIsCanSwitchPage) {
                    View.OnTouchListener onTouchListener = this.mTouchListener;
                    if (onTouchListener instanceof PagerLayoutManager) {
                        smoothScrollToPosition(((PagerLayoutManager) onTouchListener).getPosition());
                        return true;
                    }
                }
            } else {
                this.mIsCanSwitchPage = true;
            }
            if (!isCanScrollable(motionEvent)) {
                this.mIsCanSwitchPage = false;
                return false;
            }
            View.OnTouchListener onTouchListener2 = this.mTouchListener;
            if (onTouchListener2 != null) {
                onTouchListener2.onTouch(this, motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
