package com.baidu.searchbox.logsystem.basic.javacrash;

import android.content.Context;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.LogSystemServiceUtil;
import com.baidu.searchbox.logsystem.basic.eventhandler.DefaultProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.basic.eventhandler.OOMEventSceneSceneHandler;
import com.baidu.searchbox.logsystem.basic.eventhandler.RssOOMEventSceneSceneHandler;
import com.baidu.searchbox.logsystem.basic.eventhandler.VssOOMEventSceneSceneHandler;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ForwardingProcessEventSceneHandler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class BaseUncaughtExceptionHandler extends BUncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Supplier mSupplier;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseUncaughtExceptionHandler(Context context) {
        this(context, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (List) objArr2[1], (Supplier) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseUncaughtExceptionHandler(Context context, Supplier supplier) {
        this(context, null, supplier);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, supplier};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (List) objArr2[1], (Supplier) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseUncaughtExceptionHandler(Context context, List list, Supplier supplier) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, supplier};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mSupplier = supplier;
    }

    @Override // com.baidu.searchbox.logsystem.basic.javacrash.BUncaughtExceptionHandler
    public final ForwardingProcessEventSceneHandler getForwardingHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ForwardingProcessEventSceneHandler forwardingProcessEventSceneHandler = new ForwardingProcessEventSceneHandler();
            forwardingProcessEventSceneHandler.addEventHandleCallback(new DefaultProcessEventSceneHandler());
            forwardingProcessEventSceneHandler.addEventHandleCallback(new VssOOMEventSceneSceneHandler());
            forwardingProcessEventSceneHandler.addEventHandleCallback(new OOMEventSceneSceneHandler());
            forwardingProcessEventSceneHandler.addEventHandleCallback(new RssOOMEventSceneSceneHandler());
            Supplier supplier = this.mSupplier;
            if (supplier != null) {
                forwardingProcessEventSceneHandler.addEventHandleCallback((List) supplier.get());
            }
            return forwardingProcessEventSceneHandler;
        }
        return (ForwardingProcessEventSceneHandler) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.basic.javacrash.BUncaughtExceptionHandler
    public void onReport(Context context, String str, File file, LogExtra logExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, file, logExtra) == null) {
            LogSystemServiceUtil.startLogHandlerService(context, LogType.JAVA_CRASH, str, file, logExtra);
        }
    }
}
