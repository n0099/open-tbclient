package com.baidu.searchbox.live.shell.list.basic;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$OrientationChangeCallBack;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixYYFakeShell$orientationChangeCallBack$2 extends Lambda implements Function0<MixYYFakeShell.OrientationChangeCallBack> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ Context $context;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MixYYFakeShell$orientationChangeCallBack$2(Context context) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MixYYFakeShell.OrientationChangeCallBack invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Context context = this.$context;
            if (context != null) {
                return new MixYYFakeShell.OrientationChangeCallBack(new WeakReference((Activity) context));
            }
            throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
        return (MixYYFakeShell.OrientationChangeCallBack) invokeV.objValue;
    }
}
