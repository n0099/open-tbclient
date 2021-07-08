package com.baidu.mobads.container.bridge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ExpandedLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float CLOSE_BUTTON_PADDING_DP = 8.0f;
    public static final float CLOSE_BUTTON_SIZE_DP = 30.0f;
    public static final float CLOSE_REGION_SIZE_DP = 50.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public final Rect mClosableLayoutRect;
    public boolean mCloseBoundChanged;
    public final Rect mCloseButtonBounds;
    public final int mCloseButtonPadding;
    public final int mCloseButtonSize;
    public final BitmapDrawable mCloseDrawable;
    public ClosePosition mClosePosition;
    public final Rect mCloseRegionBounds;
    public final int mCloseRegionSize;
    public final Rect mInsetCloseRegionBounds;
    public KeyDownListener mKeyDownListener;
    public OnCloseListener mOnCloseListener;
    public final int mTouchSlop;
    public UnsetPressedState mUnsetPressedState;

    /* renamed from: com.baidu.mobads.container.bridge.ExpandedLayout$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ClosePosition {
        public static final /* synthetic */ ClosePosition[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ClosePosition BOTTOM_CENTER;
        public static final ClosePosition BOTTOM_LEFT;
        public static final ClosePosition BOTTOM_RIGHT;
        public static final ClosePosition CENTER;
        public static final ClosePosition TOP_CENTER;
        public static final ClosePosition TOP_LEFT;
        public static final ClosePosition TOP_RIGHT;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mGravity;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1683567788, "Lcom/baidu/mobads/container/bridge/ExpandedLayout$ClosePosition;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1683567788, "Lcom/baidu/mobads/container/bridge/ExpandedLayout$ClosePosition;");
                    return;
                }
            }
            TOP_LEFT = new ClosePosition("TOP_LEFT", 0, 51);
            TOP_CENTER = new ClosePosition("TOP_CENTER", 1, 49);
            TOP_RIGHT = new ClosePosition("TOP_RIGHT", 2, 53);
            CENTER = new ClosePosition("CENTER", 3, 17);
            BOTTOM_LEFT = new ClosePosition("BOTTOM_LEFT", 4, 83);
            BOTTOM_CENTER = new ClosePosition("BOTTOM_CENTER", 5, 81);
            ClosePosition closePosition = new ClosePosition("BOTTOM_RIGHT", 6, 85);
            BOTTOM_RIGHT = closePosition;
            $VALUES = new ClosePosition[]{TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER, BOTTOM_LEFT, BOTTOM_CENTER, closePosition};
        }

        public ClosePosition(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mGravity = i3;
        }

        public static ClosePosition valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ClosePosition) Enum.valueOf(ClosePosition.class, str) : (ClosePosition) invokeL.objValue;
        }

        public static ClosePosition[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ClosePosition[]) $VALUES.clone() : (ClosePosition[]) invokeV.objValue;
        }

        public int getGravity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mGravity : invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface KeyDownListener {
        boolean handleKeyDown(int i2, KeyEvent keyEvent);
    }

    /* loaded from: classes2.dex */
    public interface OnCloseListener {
        void onClose();
    }

    /* loaded from: classes2.dex */
    public final class UnsetPressedState implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExpandedLayout this$0;

        public UnsetPressedState(ExpandedLayout expandedLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expandedLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = expandedLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.setClosePressed(false);
            }
        }

        public /* synthetic */ UnsetPressedState(ExpandedLayout expandedLayout, AnonymousClass1 anonymousClass1) {
            this(expandedLayout);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandedLayout(Context context, Bitmap bitmap) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bitmap};
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
        this.mClosableLayoutRect = new Rect();
        this.mCloseRegionBounds = new Rect();
        this.mCloseButtonBounds = new Rect();
        this.mInsetCloseRegionBounds = new Rect();
        this.mKeyDownListener = null;
        this.mCloseDrawable = new BitmapDrawable(context.getResources(), bitmap);
        this.mClosePosition = ClosePosition.TOP_RIGHT;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mCloseRegionSize = (int) (50.0f * f2);
        this.mCloseButtonSize = (int) (30.0f * f2);
        this.mCloseButtonPadding = (int) (f2 * 8.0f);
        setWillNotDraw(false);
    }

    private void applyCloseBoundsWithSize(ClosePosition closePosition, int i2, Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65538, this, closePosition, i2, rect, rect2) == null) {
            Gravity.apply(closePosition.getGravity(), i2, i2, rect, rect2);
        }
    }

    private void applyCloseButtonBounds(ClosePosition closePosition, Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, closePosition, rect, rect2) == null) {
            applyCloseBoundsWithSize(closePosition, this.mCloseButtonSize, rect, rect2);
        }
    }

    private void performClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            playSoundEffect(0);
            OnCloseListener onCloseListener = this.mOnCloseListener;
            if (onCloseListener != null) {
                onCloseListener.onClose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClosePressed(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) || z == isClosePressed()) {
            return;
        }
        this.mCloseDrawable.setState(z ? FrameLayout.SELECTED_STATE_SET : FrameLayout.EMPTY_STATE_SET);
        invalidate(this.mCloseRegionBounds);
    }

    public void applyCloseRegionBounds(ClosePosition closePosition, Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, closePosition, rect, rect2) == null) {
            applyCloseBoundsWithSize(closePosition, this.mCloseRegionSize, rect, rect2);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.draw(canvas);
            if (this.mCloseBoundChanged) {
                this.mCloseBoundChanged = false;
                this.mClosableLayoutRect.set(0, 0, getWidth(), getHeight());
                applyCloseRegionBounds(this.mClosePosition, this.mClosableLayoutRect, this.mCloseRegionBounds);
                this.mInsetCloseRegionBounds.set(this.mCloseRegionBounds);
                Rect rect = this.mInsetCloseRegionBounds;
                int i2 = this.mCloseButtonPadding;
                rect.inset(i2, i2);
                applyCloseButtonBounds(this.mClosePosition, this.mInsetCloseRegionBounds, this.mCloseButtonBounds);
                this.mCloseDrawable.setBounds(this.mCloseButtonBounds);
            }
            if (this.mCloseDrawable.isVisible()) {
                this.mCloseDrawable.draw(canvas);
            }
        }
    }

    public boolean isClosePressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCloseDrawable.getState() == FrameLayout.SELECTED_STATE_SET : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            return pointInCloseBounds((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, keyEvent)) == null) {
            KeyDownListener keyDownListener = this.mKeyDownListener;
            if (keyDownListener == null) {
                return false;
            }
            return keyDownListener.handleKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.mCloseBoundChanged = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (!pointInCloseBounds((int) motionEvent.getX(), (int) motionEvent.getY(), this.mTouchSlop)) {
                setClosePressed(false);
                super.onTouchEvent(motionEvent);
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                setClosePressed(true);
            } else if (action != 1) {
                if (action == 3) {
                    setClosePressed(false);
                }
            } else if (isClosePressed()) {
                if (this.mUnsetPressedState == null) {
                    this.mUnsetPressedState = new UnsetPressedState(this, null);
                }
                postDelayed(this.mUnsetPressedState, ViewConfiguration.getPressedStateDuration());
                performClose();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean pointInCloseBounds(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048583, this, i2, i3, i4)) == null) {
            Rect rect = this.mCloseRegionBounds;
            return i2 >= rect.left - i4 && i3 >= rect.top - i4 && i2 < rect.right + i4 && i3 < rect.bottom + i4;
        }
        return invokeIII.booleanValue;
    }

    public void setClosePosition(ClosePosition closePosition) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, closePosition) == null) || closePosition == null) {
            return;
        }
        this.mClosePosition = closePosition;
        this.mCloseBoundChanged = true;
        invalidate();
    }

    public void setCloseVisible(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && this.mCloseDrawable.setVisible(z, false)) {
            invalidate(this.mCloseRegionBounds);
        }
    }

    public void setKeyDownListener(KeyDownListener keyDownListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, keyDownListener) == null) {
            this.mKeyDownListener = keyDownListener;
        }
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onCloseListener) == null) {
            this.mOnCloseListener = onCloseListener;
        }
    }
}
