package com.baidu.fsg.base.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class g implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardPopupWindow f39798a;

    public g(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {safeKeyBoardPopupWindow};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39798a = safeKeyBoardPopupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        ImageButton imageButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                this.f39798a.b();
                return false;
            }
            if (motionEvent.getAction() != 1) {
                if (motionEvent.getAction() != 2) {
                    return false;
                }
                imageButton = this.f39798a.k;
                if (imageButton.isPressed()) {
                    return false;
                }
            }
            this.f39798a.a();
            return false;
        }
        return invokeLL.booleanValue;
    }
}
