package com.baidu.searchbox.live.gesture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.util.ImmersionUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ItemRootView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int downY;
    public boolean isInterceptAllTouch;
    public ItemGestureListener listener;
    public GestureDetector mGestureDetector;

    /* loaded from: classes2.dex */
    public static class SimpleGestureListener implements ItemGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onDoubleTap(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onDown(@Nullable MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onLongPress(@Nullable MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onMove(@Nullable MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onSingleTap(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onSlid(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onTouchCancel(@Nullable MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, motionEvent) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onTouchUp(@Nullable MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, motionEvent) == null) {
            }
        }

        public SimpleGestureListener() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemRootView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener(this) { // from class: com.baidu.searchbox.live.gesture.ItemRootView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ItemRootView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
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

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (this.this$0.listener != null) {
                        this.this$0.listener.onDoubleTap(x, y);
                    }
                    return super.onDoubleTap(motionEvent);
                }
                return invokeL.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                    if (this.this$0.listener != null) {
                        this.this$0.listener.onDown(motionEvent);
                    }
                    return super.onDown(motionEvent);
                }
                return invokeL.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                    if (this.this$0.listener != null) {
                        this.this$0.listener.onLongPress(motionEvent);
                    }
                    super.onLongPress(motionEvent);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048579, this, motionEvent)) == null) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (this.this$0.listener != null) {
                        this.this$0.listener.onSingleTap(x, y);
                    }
                    return super.onSingleTapConfirmed(motionEvent);
                }
                return invokeL.booleanValue;
            }
        });
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.isInterceptAllTouch) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setGestureListener(ItemGestureListener itemGestureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, itemGestureListener) == null) {
            this.listener = itemGestureListener;
        }
    }

    public void setInterceptAllTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.isInterceptAllTouch = z;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        ItemGestureListener itemGestureListener;
        ItemGestureListener itemGestureListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (this.isInterceptAllTouch) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 0) {
                this.downY = (int) motionEvent.getY();
            } else if (motionEvent.getAction() == 2) {
                ItemGestureListener itemGestureListener3 = this.listener;
                if (itemGestureListener3 != null) {
                    itemGestureListener3.onMove(motionEvent);
                }
            } else if (motionEvent.getAction() == 1) {
                if (Math.abs(((int) motionEvent.getY()) - this.downY) > ImmersionUtils.dp2px(3.0f) && (itemGestureListener2 = this.listener) != null) {
                    itemGestureListener2.onSlid(0);
                }
                ItemGestureListener itemGestureListener4 = this.listener;
                if (itemGestureListener4 != null) {
                    itemGestureListener4.onTouchUp(motionEvent);
                }
            } else if (motionEvent.getAction() == 3 && (itemGestureListener = this.listener) != null) {
                itemGestureListener.onTouchCancel(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
