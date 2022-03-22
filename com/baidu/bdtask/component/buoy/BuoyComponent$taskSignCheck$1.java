package com.baidu.bdtask.component.buoy;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class BuoyComponent$taskSignCheck$1 extends Lambda implements Function0<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Ref.ObjectRef $tempCurTaskInfo;
    public final /* synthetic */ BuoyComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuoyComponent$taskSignCheck$1(BuoyComponent buoyComponent, Ref.ObjectRef objectRef) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buoyComponent, objectRef};
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
        this.this$0 = buoyComponent;
        this.$tempCurTaskInfo = objectRef;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        InterceptResult invokeV;
        TaskInfo taskInfo;
        TaskInfo taskInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String singleKey = ((TaskInfo) this.$tempCurTaskInfo.element).getSingleKey();
            taskInfo = this.this$0.f24917h;
            if (!Intrinsics.areEqual(singleKey, taskInfo.getSingleKey())) {
                StringBuilder sb = new StringBuilder();
                sb.append("taskSignCheck fail:curTaskInfo:");
                sb.append((TaskInfo) this.$tempCurTaskInfo.element);
                sb.append(" bindTaskInfo:");
                taskInfo2 = this.this$0.f24917h;
                sb.append(taskInfo2);
                return sb.toString();
            }
            return "taskSignCheck pass";
        }
        return (String) invokeV.objValue;
    }
}
