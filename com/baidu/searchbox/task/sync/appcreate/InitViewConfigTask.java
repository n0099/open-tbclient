package com.baidu.searchbox.task.sync.appcreate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.hx4;
import com.baidu.tieba.im5;
import com.baidu.tieba.me9;
/* loaded from: classes3.dex */
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
        if (TbadkCoreApplication.getInst().mToast == null && ej.x() == null) {
            TbadkCoreApplication.getInst().mToast = new ej.d() { // from class: com.baidu.searchbox.task.sync.appcreate.InitViewConfigTask.1
                @Override // com.baidu.tieba.ej.d
                public void createToastView(boolean z) {
                    if (z) {
                        TbadkCoreApplication.getInst().mCustomToastView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.custom_toast_textview_center, (ViewGroup) null);
                        return;
                    }
                    TbadkCoreApplication.getInst().mCustomToastView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.custom_toast_textview, (ViewGroup) null);
                }

                @Override // com.baidu.tieba.ej.d
                public void setToastString(String str) {
                    if (getToastContentView() instanceof TextView) {
                        ((TextView) getToastContentView()).setText(str);
                    }
                }

                @Override // com.baidu.tieba.ej.d
                public View getToastContentView() {
                    return TbadkCoreApplication.getInst().mCustomToastView;
                }
            };
            ej.K(TbadkCoreApplication.getInst().mToast);
            im5.b().H(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        ViewHelper.initSkinDataOnStartup(AppRuntime.getAppContext());
        hx4.c().f();
        TbConfig.initBigImageWidth(TbadkCoreApplication.getInst());
        TbConfig.initBigImageMaxUsedMemory(TbadkCoreApplication.getInst().getContext());
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbImageMemoryCache.p().C(TbConfig.getMaxPhotoMemoryCache(), TbConfig.getBigImageMaxUsedMemory());
        } else {
            TbImageMemoryCache.p().C(TbConfig.getMaxPhotoMemoryCacheForRemoteProcess(), TbConfig.getBigImageMaxUsedMemoryForRemoteProcess());
        }
        TbConfig.initFriendPhotoConfig(TbadkCoreApplication.getInst());
        TbadkCoreApplication.getInst().setFontSize(TbadkSettings.getInst().loadInt("font_size", 2));
        TbDimenManager.getInstance().init(AppRuntime.getApplication());
        me9.c();
        initCustomToastView();
    }
}
