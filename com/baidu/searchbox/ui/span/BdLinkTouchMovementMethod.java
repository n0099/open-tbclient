package com.baidu.searchbox.ui.span;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BdLinkTouchMovementMethod extends LinkMovementMethod {
    public static /* synthetic */ Interceptable $ic;
    public static BdLinkTouchMovementMethod instance;
    public transient /* synthetic */ FieldHolder $fh;
    public BdLinkTouchDecorHelper mBdLinkTouchDecorHelper;

    public BdLinkTouchMovementMethod() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBdLinkTouchDecorHelper = new BdLinkTouchDecorHelper();
    }

    public static BdLinkTouchMovementMethod getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (instance == null) {
                synchronized (BdLinkTouchMovementMethod.class) {
                    if (instance == null) {
                        instance = new BdLinkTouchMovementMethod();
                    }
                }
            }
            return instance;
        }
        return (BdLinkTouchMovementMethod) invokeV.objValue;
    }

    public void clearSpanUiStatus(@Nullable TextView textView) {
        BdLinkTouchDecorHelper bdLinkTouchDecorHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, textView) == null) && textView != null && (bdLinkTouchDecorHelper = this.mBdLinkTouchDecorHelper) != null) {
            bdLinkTouchDecorHelper.clearSpanState(textView);
        }
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, spannable, motionEvent)) == null) {
            if (!this.mBdLinkTouchDecorHelper.onTouchEvent(textView, spannable, motionEvent) && !Touch.onTouchEvent(textView, spannable, motionEvent)) {
                return false;
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
