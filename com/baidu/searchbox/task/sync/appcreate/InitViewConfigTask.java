package com.baidu.searchbox.task.sync.appcreate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.R;
import com.baidu.tieba.noa;
import com.baidu.tieba.on5;
import com.baidu.tieba.uu4;
/* loaded from: classes4.dex */
public class InitViewConfigTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_InitViewConfig";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    private void initCustomToastView() {
        long currentTimeMillis = System.currentTimeMillis();
        if (TbadkCoreApplication.getInst().mToast == null && BdUtilHelper.getToastView() == null) {
            TbadkCoreApplication.getInst().mToast = new BdUtilHelper.d() { // from class: com.baidu.searchbox.task.sync.appcreate.InitViewConfigTask.1
                @Override // com.baidu.adp.lib.util.BdUtilHelper.d
                public void createToastView(boolean z) {
                    if (z) {
                        TbadkCoreApplication.getInst().mCustomToastView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.custom_toast_textview_center, (ViewGroup) null);
                        return;
                    }
                    TbadkCoreApplication.getInst().mCustomToastView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.custom_toast_textview, (ViewGroup) null);
                }

                @Override // com.baidu.adp.lib.util.BdUtilHelper.d
                public void setToastString(String str) {
                    if (getToastContentView() instanceof TextView) {
                        ((TextView) getToastContentView()).setText(str);
                    }
                }

                @Override // com.baidu.adp.lib.util.BdUtilHelper.d
                public View getToastContentView() {
                    return TbadkCoreApplication.getInst().mCustomToastView;
                }
            };
            BdUtilHelper.setToastView(TbadkCoreApplication.getInst().mToast);
            on5.a().G(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        ViewHelper.initSkinDataOnStartup(AppRuntime.getAppContext());
        uu4.c().f();
        TbConfig.initBigImageWidth(TbadkCoreApplication.getInst());
        TbConfig.initBigImageMaxUsedMemory(TbadkCoreApplication.getInst().getContext());
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbImageMemoryCache.B().I(TbConfig.getMaxPhotoMemoryCache(), TbConfig.getBigImageMaxUsedMemory());
        } else {
            TbImageMemoryCache.B().I(TbConfig.getMaxPhotoMemoryCacheForRemoteProcess(), TbConfig.getBigImageMaxUsedMemoryForRemoteProcess());
        }
        TbConfig.initFriendPhotoConfig(TbadkCoreApplication.getInst());
        TbadkCoreApplication.getInst().setFontSize(TbadkSettings.getInst().loadInt("font_size", 2));
        TbDimenManager.getInstance().init(AppRuntime.getApplication());
        noa.c();
        initCustomToastView();
    }
}
