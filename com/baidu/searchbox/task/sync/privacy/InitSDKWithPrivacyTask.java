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
import com.baidu.adp.lib.lbs.BdLocationMananger;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.if0;
import com.baidu.tieba.ue5;
import com.baidu.tieba.vh9;
import com.baidu.tieba.wh9;
import com.baidu.tieba.yh9;
import com.baidu.tieba.zh9;
/* loaded from: classes4.dex */
public class InitSDKWithPrivacyTask extends LaunchTask {
    public static final String LBS_API_KEY = "ZcNrGBp4BZPVHSz6ODfQGHRAyPQoxc9E";

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_InitSDKWithPrivacy";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    private void initAdRuntime() {
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            if (TbadkCoreApplication.getInst().isMainProcess(true) || TbadkCoreApplication.getInst().isRemoteProcess()) {
                if0.c();
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initAdRuntime();
        initBaiduMap();
    }

    private void initBaiduMap() {
        if (!PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        BdLocationMananger.getInstance().registerProvider(wh9.t());
        MessageManager.getInstance().registerListener(new CustomMessageListener(2010044) { // from class: com.baidu.searchbox.task.sync.privacy.InitSDKWithPrivacyTask.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EditorTools editorTools = (EditorTools) customResponsedMessage.getData();
                if (editorTools.getCollectTools().indexOf(8) != -1) {
                    if (editorTools.C()) {
                        editorTools.f(new yh9(editorTools.getContext(), true));
                    } else {
                        editorTools.f(new yh9(editorTools.getContext()));
                    }
                }
            }
        });
        CustomMessageTask customMessageTask = new CustomMessageTask(2016556, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.searchbox.task.sync.privacy.InitSDKWithPrivacyTask.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ue5> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2016556, new zh9(customMessage.getData(), 0));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921363, new CustomMessageTask.CustomRunnable<Bundle>() { // from class: com.baidu.searchbox.task.sync.privacy.InitSDKWithPrivacyTask.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Bundle> customMessage) {
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
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        if (loadBoolean) {
            BdLocationMananger.getInstance().registerProvider(vh9.j());
        }
    }
}
