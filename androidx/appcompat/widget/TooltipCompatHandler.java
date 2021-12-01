package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

    public TooltipCompatHandler(View view, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, charSequence};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.hide();
                }
            }
        };
        this.mAnchor = view;
        this.mTooltipText = charSequence;
        this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view.getContext()));
        clearAnchorPos();
        this.mAnchor.setOnLongClickListener(this);
        this.mAnchor.setOnHoverListener(this);
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

    public static void setTooltipText(View view, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, view, charSequence) == null) {
            TooltipCompatHandler tooltipCompatHandler = sPendingHandler;
            if (tooltipCompatHandler != null && tooltipCompatHandler.mAnchor == view) {
                setPendingHandler(null);
            }
            if (TextUtils.isEmpty(charSequence)) {
                TooltipCompatHandler tooltipCompatHandler2 = sActiveHandler;
                if (tooltipCompatHandler2 != null && tooltipCompatHandler2.mAnchor == view) {
                    tooltipCompatHandler2.hide();
                }
                view.setOnLongClickListener(null);
                view.setLongClickable(false);
                view.setOnHoverListener(null);
                return;
            }
            new TooltipCompatHandler(view, charSequence);
        }
    }

    private boolean updateAnchorPos(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (Math.abs(x - this.mAnchorX) > this.mHoverSlop || Math.abs(y - this.mAnchorY) > this.mHoverSlop) {
                this.mAnchorX = x;
                this.mAnchorY = y;
                return true;
            }
            return false;
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
                }
            }
            if (sPendingHandler == this) {
                setPendingHandler(null);
            }
            this.mAnchor.removeCallbacks(this.mHideRunnable);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
            if (this.mPopup == null || !this.mFromTouch) {
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
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            this.mAnchorX = view.getWidth() / 2;
            this.mAnchorY = view.getHeight() / 2;
            show(true);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            hide();
        }
    }

    public void show(boolean z) {
        long j2;
        int longPressTimeout;
        long j3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && ViewCompat.isAttachedToWindow(this.mAnchor)) {
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
                j3 = LONG_CLICK_HIDE_TIMEOUT_MS;
            } else {
                if ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 1) == 1) {
                    j2 = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j3 = j2 - longPressTimeout;
            }
            this.mAnchor.removeCallbacks(this.mHideRunnable);
            this.mAnchor.postDelayed(this.mHideRunnable, j3);
        }
    }
}
