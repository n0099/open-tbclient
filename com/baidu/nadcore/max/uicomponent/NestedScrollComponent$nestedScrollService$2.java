package com.baidu.nadcore.max.uicomponent;

import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.max.uiwidget.basic.WebViewContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fn0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/nadcore/max/uicomponent/NestedScrollComponent$nestedScrollService$2$1", "invoke", "()Lcom/baidu/nadcore/max/uicomponent/NestedScrollComponent$nestedScrollService$2$1;"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NestedScrollComponent$nestedScrollService$2 extends Lambda implements Function0<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ NestedScrollComponent this$0;

    /* loaded from: classes2.dex */
    public static final class a implements fn0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollComponent$nestedScrollService$2 a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(NestedScrollComponent$nestedScrollService$2 nestedScrollComponent$nestedScrollService$2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollComponent$nestedScrollService$2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nestedScrollComponent$nestedScrollService$2;
        }

        @Override // com.repackage.fn0
        public WebViewContainer b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.this$0.x() : (WebViewContainer) invokeV.objValue;
        }

        @Override // com.repackage.fn0
        public void f(boolean z, boolean z2, boolean z3, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i)}) == null) {
                this.a.this$0.J(z, z2, z3, i);
            }
        }

        @Override // com.repackage.fn0
        public boolean g() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                z = this.a.this$0.g;
                return z;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.fn0
        public void i(MotionEvent event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.a.this$0.x().dispatchTouchEvent(event);
            }
        }

        @Override // com.repackage.fn0
        public void j(boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
                this.a.this$0.C(z, z2, z3);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollComponent$nestedScrollService$2(NestedScrollComponent nestedScrollComponent) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nestedScrollComponent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = nestedScrollComponent;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }
}
