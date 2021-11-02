package com.baidu.searchbox.ui.wheelview3d.timer;

import android.os.Handler;
import android.os.Message;
import com.baidu.searchbox.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class MessageHandler extends Handler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_ITEM_SELECTED = 3000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;
    public transient /* synthetic */ FieldHolder $fh;
    public final WheelView3d wheelView;

    public MessageHandler(WheelView3d wheelView3d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView3d};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wheelView = wheelView3d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            int i2 = message.what;
            if (i2 == 1000) {
                this.wheelView.invalidate();
            } else if (i2 == 2000) {
                this.wheelView.smoothScroll(WheelView3d.ACTION.FLING);
            } else if (i2 != 3000) {
            } else {
                this.wheelView.onItemSelected();
            }
        }
    }
}
