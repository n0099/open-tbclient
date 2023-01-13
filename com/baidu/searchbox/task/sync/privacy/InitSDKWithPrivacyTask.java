package com.baidu.searchbox.task.sync.privacy;

import android.content.Context;
import android.location.Address;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.fj0;
import com.baidu.tieba.k75;
import com.baidu.tieba.ms7;
import com.baidu.tieba.ns7;
import com.baidu.tieba.ps7;
import com.baidu.tieba.qs7;
import com.baidu.tieba.uf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class InitSDKWithPrivacyTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LBS_API_KEY = "ZcNrGBp4BZPVHSz6ODfQGHRAyPQoxc9E";
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "Ignore_InitSDKWithPrivacy" : (String) invokeV.objValue;
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

    public InitSDKWithPrivacyTask() {
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

    private void initAdRuntime() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            if (TbadkCoreApplication.getInst().isMainProcess(true) || TbadkCoreApplication.getInst().isRemoteProcess()) {
                fj0.c();
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            initAdRuntime();
            initBaiduMap();
        }
    }

    private void initBaiduMap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            uf.n().r(ns7.t());
            boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
            if (Build.VERSION.SDK_INT <= 4) {
                loadBoolean = false;
            }
            if (loadBoolean) {
                uf.n().r(ms7.j());
            }
            MessageManager.getInstance().registerListener(new CustomMessageListener(this, 2010044) { // from class: com.baidu.searchbox.task.sync.privacy.InitSDKWithPrivacyTask.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitSDKWithPrivacyTask this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                        EditorTools editorTools = (EditorTools) customResponsedMessage.getData();
                        if (editorTools.getCollectTools().indexOf(8) != -1) {
                            if (editorTools.v()) {
                                editorTools.d(new ps7(editorTools.getContext(), true));
                            } else {
                                editorTools.d(new ps7(editorTools.getContext()));
                            }
                        }
                    }
                }
            });
            CustomMessageTask customMessageTask = new CustomMessageTask(2016556, new CustomMessageTask.CustomRunnable<Context>(this) { // from class: com.baidu.searchbox.task.sync.privacy.InitSDKWithPrivacyTask.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitSDKWithPrivacyTask this$0;

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

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<k75> run(CustomMessage<Context> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        return new CustomResponsedMessage<>(2016556, new qs7(customMessage.getData(), 0));
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(2921363, new CustomMessageTask.CustomRunnable<Bundle>(this) { // from class: com.baidu.searchbox.task.sync.privacy.InitSDKWithPrivacyTask.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitSDKWithPrivacyTask this$0;

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

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<Bundle> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        if (customMessage != null && customMessage.getData() != null) {
                            Bundle data = customMessage.getData();
                            Address address = (Address) data.getParcelable("location");
                            String string = data.getString("coorType");
                            if (address != null && !StringUtils.isNULL(string)) {
                                BDLocation bDLocation = new BDLocation();
                                bDLocation.setLatitude(address.getLatitude());
                                bDLocation.setLongitude(address.getLongitude());
                                if (TextUtils.equals(string, "bd09")) {
                                    bDLocation = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_BD09LL_TO_GCJ02), "bd09");
                                } else if (TextUtils.equals(string, "gcj02")) {
                                    bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                                } else if (TextUtils.equals(string, "wgs84")) {
                                    bDLocation = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_BD09LL_TO_GCJ02), "gcj2wgs");
                                }
                                address.setLatitude(bDLocation.getLatitude());
                                address.setLongitude(bDLocation.getLongitude());
                                return new CustomResponsedMessage<>(2921363, address);
                            }
                        }
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            SDKInitializer.setAgreePrivacy(TbadkCoreApplication.getInst(), true);
            LocationClient.setAgreePrivacy(true);
            LocationClient.setKey(LBS_API_KEY);
            SDKInitializer.setApiKey(LBS_API_KEY);
            try {
                SDKInitializer.initialize(TbadkCoreApplication.getInst());
            } catch (BaiduMapSDKException unused) {
            }
        }
    }
}
