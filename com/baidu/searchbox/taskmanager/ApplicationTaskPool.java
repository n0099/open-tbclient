package com.baidu.searchbox.taskmanager;

import b.a.e.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.BaseTaskPool;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.task.item.CheckRepackagingTask;
import com.baidu.searchbox.task.item.DeleteApkTask;
import com.baidu.searchbox.task.item.InitAccountAndPersonalizePageDataTask;
import com.baidu.searchbox.task.item.InitAccountChangeTask;
import com.baidu.searchbox.task.item.InitAdTask;
import com.baidu.searchbox.task.item.InitAllTask;
import com.baidu.searchbox.task.item.InitArTask;
import com.baidu.searchbox.task.item.InitDimenAdaptTask;
import com.baidu.searchbox.task.item.InitIdleHandlerTask;
import com.baidu.searchbox.task.item.InitMessageTask;
import com.baidu.searchbox.task.item.InitSapiTask;
import com.baidu.searchbox.task.item.InitSyncStaticTask;
import com.baidu.searchbox.task.item.LogoTask;
import com.baidu.searchbox.task.item.NightPluginTask;
import com.baidu.searchbox.task.item.PermissionUtilTask;
import com.baidu.searchbox.task.item.SyncAccountTask;
import com.baidu.tbadk.switchs.LaunchDelayHandlerSwitch;
import com.baidu.tbadk.switchs.LaunchUpSpeedSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ApplicationTaskPool extends BaseTaskPool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ApplicationTaskPool() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void addTbLaunchStatsTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            a.f().d("InitAccountChangeTask", new Runnable(this) { // from class: com.baidu.searchbox.taskmanager.ApplicationTaskPool.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ApplicationTaskPool this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        new InitAccountChangeTask().execute();
                    }
                }
            });
            a.f().d("PermissionUtilTask", new Runnable(this) { // from class: com.baidu.searchbox.taskmanager.ApplicationTaskPool.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ApplicationTaskPool this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        new PermissionUtilTask().execute();
                    }
                }
            });
            a.f().d("InitDimenAdaptTask", new Runnable(this) { // from class: com.baidu.searchbox.taskmanager.ApplicationTaskPool.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ApplicationTaskPool this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        new InitDimenAdaptTask().execute();
                    }
                }
            });
            a.f().d("InitArTask", new Runnable(this) { // from class: com.baidu.searchbox.taskmanager.ApplicationTaskPool.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ApplicationTaskPool this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        new InitArTask().execute();
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> beforeAppCreate(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(new InitAdTask());
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> onAppCreate(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (z && LaunchUpSpeedSwitch.getIsOn()) {
                arrayList.add(new InitAccountAndPersonalizePageDataTask());
                arrayList.add(new InitAllTask());
                arrayList.add(new InitSapiTask());
                arrayList.add(new InitMessageTask());
                if (LaunchDelayHandlerSwitch.getIsOn()) {
                    addTbLaunchStatsTask();
                } else {
                    arrayList.add(new InitAccountChangeTask());
                    arrayList.add(new PermissionUtilTask());
                    arrayList.add(new InitDimenAdaptTask());
                    arrayList.add(new InitArTask());
                }
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> onPrivacyPolicyGranted(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(new DeleteApkTask());
                arrayList.add(new NightPluginTask());
                arrayList.add(new LogoTask());
            } else {
                arrayList.add(new SyncAccountTask());
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> onSecondaryPageEnter(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!z) {
                arrayList.add(new InitSyncStaticTask());
                arrayList.add(new InitIdleHandlerTask());
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.BaseTaskPool
    public List<LaunchTask> onUiReady(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(new CheckRepackagingTask());
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }
}
