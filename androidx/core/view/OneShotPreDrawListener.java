package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Runnable mRunnable;
    public final View mView;
    public ViewTreeObserver mViewTreeObserver;

    public OneShotPreDrawListener(View view2, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, runnable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mView = view2;
        this.mViewTreeObserver = view2.getViewTreeObserver();
        this.mRunnable = runnable;
    }

    public static OneShotPreDrawListener add(View view2, Runnable runnable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, view2, runnable)) == null) {
            if (view2 != null) {
                if (runnable != null) {
                    OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view2, runnable);
                    view2.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
                    view2.addOnAttachStateChangeListener(oneShotPreDrawListener);
                    return oneShotPreDrawListener;
                }
                throw new NullPointerException("runnable == null");
            }
            throw new NullPointerException("view == null");
        }
        return (OneShotPreDrawListener) invokeLL.objValue;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            removeListener();
            this.mRunnable.run();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void removeListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.mViewTreeObserver.isAlive()) {
                this.mViewTreeObserver.removeOnPreDrawListener(this);
            } else {
                this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            this.mView.removeOnAttachStateChangeListener(this);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.mViewTreeObserver = view2.getViewTreeObserver();
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            removeListener();
        }
    }
}
