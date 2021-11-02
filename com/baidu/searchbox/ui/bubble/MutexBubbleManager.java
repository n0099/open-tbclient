package com.baidu.searchbox.ui.bubble;

import com.baidu.android.ext.manage.MutexPopManager;
import com.baidu.android.ext.manage.PopItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MutexBubbleManager implements PopItem {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleManager mBubbleManager;

    public MutexBubbleManager(BubbleManager bubbleManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBubbleManager = bubbleManager;
    }

    public void dismissBubble() {
        BubbleManager bubbleManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bubbleManager = this.mBubbleManager) == null || bubbleManager.isDismissed()) {
            return;
        }
        this.mBubbleManager.dismissBubble();
        this.mBubbleManager = null;
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public void mutexDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dismissBubble();
        }
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public boolean mutexShow(String str, Object... objArr) throws ClassCastException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, objArr)) == null) {
            BubbleManager bubbleManager = this.mBubbleManager;
            if (bubbleManager == null) {
                return false;
            }
            this.mBubbleManager.setOnBubbleEventListener(new BubbleManager.OnBubbleEventListener(this, bubbleManager.getOnBubbleEventListener()) { // from class: com.baidu.searchbox.ui.bubble.MutexBubbleManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MutexBubbleManager this$0;
                public final /* synthetic */ BubbleManager.OnBubbleEventListener val$oldListener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$oldListener = r7;
                }

                @Override // com.baidu.searchbox.ui.bubble.BubbleManager.OnBubbleEventListener
                public void onBubbleClick() {
                    BubbleManager.OnBubbleEventListener onBubbleEventListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (onBubbleEventListener = this.val$oldListener) == null) {
                        return;
                    }
                    onBubbleEventListener.onBubbleClick();
                }

                @Override // com.baidu.searchbox.ui.bubble.BubbleManager.OnBubbleEventListener
                public void onBubbleDismiss() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        BubbleManager.OnBubbleEventListener onBubbleEventListener = this.val$oldListener;
                        if (onBubbleEventListener != null) {
                            onBubbleEventListener.onBubbleDismiss();
                        }
                        this.this$0.mBubbleManager = null;
                        MutexPopManager.doNextTask();
                    }
                }

                @Override // com.baidu.searchbox.ui.bubble.BubbleManager.OnBubbleEventListener
                public void onBubbleShow() {
                    BubbleManager.OnBubbleEventListener onBubbleEventListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (onBubbleEventListener = this.val$oldListener) == null) {
                        return;
                    }
                    onBubbleEventListener.onBubbleShow();
                }
            });
            this.mBubbleManager.showBubble();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
