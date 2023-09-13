package com.baidu.bdtask.ui.components.buoy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.zu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/baidu/bdtask/ui/components/buoy/BuoyContainer;", "Landroid/widget/FrameLayout;", "", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Lcom/baidu/bdtask/ui/components/buoy/BuoyContainerLifecycleCallback;", "lifecycleCallback", "Lcom/baidu/bdtask/ui/components/buoy/BuoyContainerLifecycleCallback;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/baidu/bdtask/ui/components/buoy/BuoyContainerLifecycleCallback;)V", "lib-bdtask-ui-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class BuoyContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zu a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuoyContainer(Context context, zu zuVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, zuVar};
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
        this.a = zuVar;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAttachedToWindow();
            zu zuVar = this.a;
            if (zuVar != null) {
                zuVar.onAttachedToWindow();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDetachedFromWindow();
            zu zuVar = this.a;
            if (zuVar != null) {
                zuVar.onDetachedFromWindow();
            }
        }
    }
}
