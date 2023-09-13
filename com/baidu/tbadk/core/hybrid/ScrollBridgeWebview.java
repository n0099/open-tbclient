package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ScrollBridgeWebview extends BridgeWebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public boolean b;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, int i2, int i3, int i4);

        void c(int i, int i2, int i3, int i4);

        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollBridgeWebview(Context context) {
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
        this.b = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollBridgeWebview(Context context, AttributeSet attributeSet) {
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
        this.b = false;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            if (this.a != null) {
                if (Math.abs((getContentHeight() * getScale()) - (getHeight() + getScrollY())) < 1.0f) {
                    this.a.c(i, i2, i3, i4);
                } else if (getScrollY() == 0) {
                    this.a.b(i, i2, i3, i4);
                } else {
                    this.a.onScrollChanged(i, i2, i3, i4);
                }
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (this.b) {
                if (motionEvent.getAction() == 0) {
                    requestDisallowInterceptTouchEvent(false);
                } else {
                    requestDisallowInterceptTouchEvent(true);
                }
            }
            return onTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.b = z;
        }
    }

    public void setOnScrollChangeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.a = aVar;
        }
    }
}
