package com.baidu.searchbox.task.sync.appcreate;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.basic.LogSystemProcessor;
import com.baidu.searchbox.logsystem.basic.Loki;
import com.baidu.searchbox.logsystem.basic.javacrash.BaseProcessExceptionListener;
import com.baidu.searchbox.logsystem.basic.javacrash.BaseUncaughtExceptionHandler;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ForwardingDeviceEventSceneHandler;
import com.baidu.searchbox.logsystem.util.AppExtraUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.track.Track;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.bn;
import com.baidu.tieba.bq4;
import com.baidu.tieba.h20;
import com.baidu.tieba.lx4;
import com.baidu.tieba.mx4;
import com.baidu.tieba.nx4;
import com.baidu.tieba.rx4;
import com.baidu.tieba.ve1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class InitLokiTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "AppCreate_InitLoki" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public InitLokiTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private boolean userIgnore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if ("AE3AA5A9D272F7A397A7AA454D2DB2DE|AD8A01E500000A".equals(TbadkCoreApplication.getInst().getCuid())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            initLoki();
        }
    }

    private void initLoki() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && !bq4.e() && !userIgnore()) {
            if (Loki.isLokiService(ve1.b())) {
                ForwardingDeviceEventSceneHandler forwardingDeviceEventSceneHandler = new ForwardingDeviceEventSceneHandler();
                forwardingDeviceEventSceneHandler.addEventHandleCallback(new mx4());
                LinkedList linkedList = new LinkedList();
                linkedList.add(new LogSystemUploaderStrategy(true, true));
                Loki.initService(new LogSystemProcessor(forwardingDeviceEventSceneHandler, linkedList));
                Loki.setAppExtraCall(new AppExtraUtil.AppExtraCall(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ InitLokiTask this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.searchbox.logsystem.util.AppExtraUtil.AppExtraCall
                    public JSONObject getAppExtraInfo() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tieba", " extraInfo");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            return jSONObject;
                        }
                        return (JSONObject) invokeV.objValue;
                    }
                });
                return;
            }
            lokiAdvancedInit(TbadkCoreApplication.getInst());
        }
    }

    private void lokiAdvancedInit(Context context) {
        Supplier supplier;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            Supplier supplier2 = new Supplier(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitLokiTask this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.common.others.java.Supplier
                public List get() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(new nx4());
                        return linkedList;
                    }
                    return (List) invokeV.objValue;
                }
            };
            LinkedList linkedList = new LinkedList();
            linkedList.add(new BaseProcessExceptionListener(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitLokiTask this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.searchbox.logsystem.basic.javacrash.BaseProcessExceptionListener, com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
                public void onProcessExceptionFail(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th, Throwable th2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, uncaughtExceptionHandler, th, th2) == null) {
                        super.onProcessExceptionFail(uncaughtExceptionHandler, th, th2);
                    }
                }

                @Override // com.baidu.searchbox.logsystem.basic.javacrash.BaseProcessExceptionListener, com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
                public void onProcessExceptionStart(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uncaughtExceptionHandler, th) == null) {
                        super.onProcessExceptionStart(uncaughtExceptionHandler, th);
                    }
                }

                @Override // com.baidu.searchbox.logsystem.basic.javacrash.BaseProcessExceptionListener, com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
                public void onProcessExceptionSuccess(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uncaughtExceptionHandler, th) == null) {
                        super.onProcessExceptionSuccess(uncaughtExceptionHandler, th);
                    }
                }
            });
            BaseUncaughtExceptionHandler baseUncaughtExceptionHandler = new BaseUncaughtExceptionHandler(this, context, linkedList, supplier2) { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitLokiTask this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(context, linkedList, supplier2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, linkedList, supplier2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (List) objArr2[1], (Supplier) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.searchbox.logsystem.basic.javacrash.BUncaughtExceptionHandler
                public void onAttachExtra(Context context2, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, jSONObject) == null) {
                        super.onAttachExtra(context2, jSONObject);
                        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                            rx4.q().h();
                        }
                        lx4.a(jSONObject);
                    }
                }

                @Override // com.baidu.searchbox.logsystem.basic.javacrash.BUncaughtExceptionHandler
                public void onDisasterRecovery(Context context2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context2) == null) {
                        super.onDisasterRecovery(context2);
                    }
                }
            };
            baseUncaughtExceptionHandler.setProcessLaunchTime(System.currentTimeMillis());
            Loki.init(context, baseUncaughtExceptionHandler);
            Track.getInstance().startTrack(AppRuntime.getAppContext());
            if (Build.VERSION.SDK_INT > 19) {
                supplier = new Supplier(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ InitLokiTask this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.android.common.others.java.Supplier
                    public List get() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            LinkedList linkedList2 = new LinkedList();
                            linkedList2.add(new nx4());
                            return linkedList2;
                        }
                        return (List) invokeV.objValue;
                    }
                };
            } else {
                supplier = null;
            }
            BdAsyncTask bdAsyncTask = new BdAsyncTask(this, new h20(this, context, supplier) { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitLokiTask this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(context, supplier);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, supplier};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (Supplier) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.tieba.h20
                public void onAttachExtra(Context context2, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, jSONObject) == null) {
                        super.onAttachExtra(context2, jSONObject);
                        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                            rx4.q().h();
                        }
                        lx4.a(jSONObject);
                    }
                }

                @Override // com.baidu.tieba.h20
                public void onDisasterRecovery(Context context2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context2) == null) {
                        super.onDisasterRecovery(context2);
                    }
                }
            }) { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitLokiTask this$0;
                public final /* synthetic */ h20 val$nativeCrashHandler;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$nativeCrashHandler = r7;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                        Loki.initNative(AppRuntime.getAppContext(), this.val$nativeCrashHandler, true);
                        return null;
                    }
                    return (Void) invokeL.objValue;
                }
            };
            bdAsyncTask.setSelfExecute(true);
            bdAsyncTask.setPriority(4);
            bdAsyncTask.execute(new Void[0]);
            Thread.setDefaultUncaughtExceptionHandler(new bn(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }
}
