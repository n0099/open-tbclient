package com.baidu.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ForbidParentSwipeBackRelativeLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_POINTER = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isIntercept;
    public int mActivePointerId;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public SwipeBackLayout.c mSwipeControlInterface;
    public int mTouchSlop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForbidParentSwipeBackRelativeLayout(Context context) {
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
        this.mActivePointerId = -1;
        this.isIntercept = false;
        init();
    }

    private void determinIntercept(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, motionEvent) == null) {
            int i = this.mActivePointerId;
            int pointerIndex = getPointerIndex(motionEvent, i);
            if (i == -1) {
                return;
            }
            try {
                float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                float y = MotionEventCompat.getY(motionEvent, pointerIndex);
                float abs = Math.abs(x - this.mInitialMotionX);
                float abs2 = Math.abs(y - this.mInitialMotionY);
                if (abs <= this.mTouchSlop || abs <= abs2) {
                    return;
                }
                this.isIntercept = true;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, motionEvent, i)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
            if (findPointerIndex == -1) {
                this.mActivePointerId = -1;
            }
            return findPointerIndex;
        }
        return invokeLI.intValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
        }
    }

    @Override // android.view.View
    public boolean onFilterTouchEventForSecurity(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.isIntercept) {
                return true;
            }
            int action = motionEvent.getAction() & 255;
            if (action != 3 && action != 1) {
                if (action == 0) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    int pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    this.mActivePointerId = pointerId;
                    if (pointerId != -1) {
                        this.mInitialMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                        this.mInitialMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                        SwipeBackLayout.c cVar = this.mSwipeControlInterface;
                        if (cVar != null) {
                            cVar.disableSwipeBack();
                        }
                    }
                } else if (action != 2) {
                    SwipeBackLayout.c cVar2 = this.mSwipeControlInterface;
                    if (cVar2 != null) {
                        cVar2.enableSwipeBack();
                    }
                } else {
                    SwipeBackLayout.c cVar3 = this.mSwipeControlInterface;
                    if (cVar3 != null) {
                        cVar3.disableSwipeBack();
                    }
                    determinIntercept(motionEvent);
                    if (this.isIntercept) {
                        return true;
                    }
                }
                return super.onFilterTouchEventForSecurity(motionEvent);
            }
            this.isIntercept = false;
            SwipeBackLayout.c cVar4 = this.mSwipeControlInterface;
            if (cVar4 != null) {
                cVar4.enableSwipeBack();
            }
            return super.onFilterTouchEventForSecurity(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                SwipeBackLayout.c cVar = this.mSwipeControlInterface;
                if (cVar != null) {
                    cVar.disableSwipeBack();
                }
            } else if (action == 1) {
                this.isIntercept = false;
                SwipeBackLayout.c cVar2 = this.mSwipeControlInterface;
                if (cVar2 != null) {
                    cVar2.enableSwipeBack();
                }
            } else if (action != 2) {
                SwipeBackLayout.c cVar3 = this.mSwipeControlInterface;
                if (cVar3 != null) {
                    cVar3.enableSwipeBack();
                }
            } else {
                SwipeBackLayout.c cVar4 = this.mSwipeControlInterface;
                if (cVar4 != null) {
                    cVar4.disableSwipeBack();
                }
                if (!this.isIntercept) {
                    determinIntercept(motionEvent);
                }
                if (this.isIntercept && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.mSwipeControlInterface = cVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForbidParentSwipeBackRelativeLayout(Context context, AttributeSet attributeSet) {
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
        this.mActivePointerId = -1;
        this.isIntercept = false;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForbidParentSwipeBackRelativeLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.mActivePointerId = -1;
        this.isIntercept = false;
        init();
    }
}
