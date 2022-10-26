package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long HOVER_HIDE_TIMEOUT_MS = 15000;
    public static final long HOVER_HIDE_TIMEOUT_SHORT_MS = 3000;
    public static final long LONG_CLICK_HIDE_TIMEOUT_MS = 2500;
    public static final String TAG = "TooltipCompatHandler";
    public static TooltipCompatHandler sActiveHandler;
    public static TooltipCompatHandler sPendingHandler;
    public transient /* synthetic */ FieldHolder $fh;
    public final View mAnchor;
    public int mAnchorX;
    public int mAnchorY;
    public boolean mFromTouch;
    public final Runnable mHideRunnable;
    public final int mHoverSlop;
    public TooltipPopup mPopup;
    public final Runnable mShowRunnable;
    public final CharSequence mTooltipText;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    public TooltipCompatHandler(View view2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, charSequence};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mShowRunnable = new Runnable(this) { // from class: androidx.appcompat.widget.TooltipCompatHandler.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TooltipCompatHandler this$0;

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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.show(false);
                }
            }
        };
        this.mHideRunnable = new Runnable(this) { // from class: androidx.appcompat.widget.TooltipCompatHandler.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TooltipCompatHandler this$0;

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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.hide();
                }
            }
        };
        this.mAnchor = view2;
        this.mTooltipText = charSequence;
        this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view2.getContext()));
        clearAnchorPos();
        this.mAnchor.setOnLongClickListener(this);
        this.mAnchor.setOnHoverListener(this);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
            if (this.mPopup != null && this.mFromTouch) {
                return false;
            }
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.mAnchor.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    clearAnchorPos();
                    hide();
                }
            } else if (this.mAnchor.isEnabled() && this.mPopup == null && updateAnchorPos(motionEvent)) {
                setPendingHandler(this);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void cancelPendingShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mAnchor.removeCallbacks(this.mShowRunnable);
        }
    }

    private void clearAnchorPos() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mAnchorX = Integer.MAX_VALUE;
            this.mAnchorY = Integer.MAX_VALUE;
        }
    }

    private void scheduleShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mAnchor.postDelayed(this.mShowRunnable, ViewConfiguration.getLongPressTimeout());
        }
    }

    public static void setPendingHandler(TooltipCompatHandler tooltipCompatHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tooltipCompatHandler) == null) {
            TooltipCompatHandler tooltipCompatHandler2 = sPendingHandler;
            if (tooltipCompatHandler2 != null) {
                tooltipCompatHandler2.cancelPendingShow();
            }
            sPendingHandler = tooltipCompatHandler;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.scheduleShow();
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            this.mAnchorX = view2.getWidth() / 2;
            this.mAnchorY = view2.getHeight() / 2;
            show(true);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            hide();
        }
    }

    public static void setTooltipText(View view2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, view2, charSequence) == null) {
            TooltipCompatHandler tooltipCompatHandler = sPendingHandler;
            if (tooltipCompatHandler != null && tooltipCompatHandler.mAnchor == view2) {
                setPendingHandler(null);
            }
            if (TextUtils.isEmpty(charSequence)) {
                TooltipCompatHandler tooltipCompatHandler2 = sActiveHandler;
                if (tooltipCompatHandler2 != null && tooltipCompatHandler2.mAnchor == view2) {
                    tooltipCompatHandler2.hide();
                }
                view2.setOnLongClickListener(null);
                view2.setLongClickable(false);
                view2.setOnHoverListener(null);
                return;
            }
            new TooltipCompatHandler(view2, charSequence);
        }
    }

    private boolean updateAnchorPos(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (Math.abs(x - this.mAnchorX) <= this.mHoverSlop && Math.abs(y - this.mAnchorY) <= this.mHoverSlop) {
                return false;
            }
            this.mAnchorX = x;
            this.mAnchorY = y;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (sActiveHandler == this) {
                sActiveHandler = null;
                TooltipPopup tooltipPopup = this.mPopup;
                if (tooltipPopup != null) {
                    tooltipPopup.hide();
                    this.mPopup = null;
                    clearAnchorPos();
                    this.mAnchor.removeOnAttachStateChangeListener(this);
                } else {
                    Log.e(TAG, "sActiveHandler.mPopup == null");
                }
            }
            if (sPendingHandler == this) {
                setPendingHandler(null);
            }
            this.mAnchor.removeCallbacks(this.mHideRunnable);
        }
    }

    public void show(boolean z) {
        long j;
        int longPressTimeout;
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || !ViewCompat.isAttachedToWindow(this.mAnchor)) {
            return;
        }
        setPendingHandler(null);
        TooltipCompatHandler tooltipCompatHandler = sActiveHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.hide();
        }
        sActiveHandler = this;
        this.mFromTouch = z;
        TooltipPopup tooltipPopup = new TooltipPopup(this.mAnchor.getContext());
        this.mPopup = tooltipPopup;
        tooltipPopup.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
        this.mAnchor.addOnAttachStateChangeListener(this);
        if (this.mFromTouch) {
            j2 = LONG_CLICK_HIDE_TIMEOUT_MS;
        } else {
            if ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 1) == 1) {
                j = 3000;
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
            } else {
                j = 15000;
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
            }
            j2 = j - longPressTimeout;
        }
        this.mAnchor.removeCallbacks(this.mHideRunnable);
        this.mAnchor.postDelayed(this.mHideRunnable, j2);
    }
}
