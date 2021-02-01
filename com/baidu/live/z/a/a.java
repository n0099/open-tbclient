package com.baidu.live.z.a;

import android.content.Context;
import com.baidu.ala.recorder.IRecorderDependency;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
/* loaded from: classes11.dex */
public class a implements IRecorderDependency {
    @Override // com.baidu.ala.recorder.IRecorderDependency
    public Context getAppContext() {
        return TbadkCoreApplication.getInst().getApp();
    }

    @Override // com.baidu.ala.recorder.IRecorderDependency
    public String getClientId() {
        return TbadkCoreApplication.getClientId();
    }

    @Override // com.baidu.ala.recorder.IRecorderDependency
    public String getUid() {
        return TbadkCoreApplication.getCurrentAccount();
    }

    @Override // com.baidu.ala.recorder.IRecorderDependency
    public boolean getIsPhoneCalling() {
        return TbadkCoreApplication.getInst().getIsPhoneCalling();
    }

    @Override // com.baidu.ala.recorder.IRecorderDependency
    public boolean isDebugMode() {
        return TbadkCoreApplication.getInst().isDebugMode();
    }

    @Override // com.baidu.ala.recorder.IRecorderDependency
    public boolean getIsBackCamera() {
        return SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("ala_carema_is_back"), false);
    }

    @Override // com.baidu.ala.recorder.IRecorderDependency
    public void setIsBackCamera(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("ala_carema_is_back"), z);
    }
}
