package com.baidu.ala.tbadk.core;

import android.content.Context;
import com.baidu.ala.adp.lib.util.BackGroundSwitchListener;
import com.baidu.ala.recorder.IRecorderDependency;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes14.dex */
public class TbadkCoreApplicationProxy {
    private static volatile TbadkCoreApplicationProxy sApp = null;
    Context mApplicationContext;
    private Set<BackGroundSwitchListener> mBackGroundSwitchListenerSet;
    private IRecorderDependency mRecorderDependency;

    public static TbadkCoreApplicationProxy getInst() {
        if (sApp == null) {
            synchronized (TbadkCoreApplicationProxy.class) {
                if (sApp == null) {
                    sApp = new TbadkCoreApplicationProxy();
                }
            }
        }
        return sApp;
    }

    public void init(IRecorderDependency iRecorderDependency) {
        this.mApplicationContext = iRecorderDependency.getAppContext();
        this.mRecorderDependency = iRecorderDependency;
    }

    public Context getAppContext() {
        return this.mApplicationContext;
    }

    public boolean isDebugMode() {
        if (this.mRecorderDependency != null) {
            return this.mRecorderDependency.isDebugMode();
        }
        return false;
    }

    public String getClientId() {
        return this.mRecorderDependency != null ? this.mRecorderDependency.getClientId() : "";
    }

    public String getUid() {
        return this.mRecorderDependency != null ? this.mRecorderDependency.getUid() : "";
    }

    public boolean getIsPhoneCalling() {
        return this.mRecorderDependency.getIsPhoneCalling();
    }

    public boolean getIsBackCamera() {
        if (this.mRecorderDependency != null) {
            return this.mRecorderDependency.getIsBackCamera();
        }
        return false;
    }

    public void setIsBackCamera(boolean z) {
        if (this.mRecorderDependency != null) {
            this.mRecorderDependency.setIsBackCamera(z);
        }
    }

    public void notifyBackgroundSwitch(boolean z) {
        if (this.mBackGroundSwitchListenerSet != null) {
            for (BackGroundSwitchListener backGroundSwitchListener : this.mBackGroundSwitchListenerSet) {
                backGroundSwitchListener.onBackGroundSwitch(z);
            }
        }
    }

    public void addBackGroundSwitchListener(BackGroundSwitchListener backGroundSwitchListener) {
        if (this.mBackGroundSwitchListenerSet == null) {
            this.mBackGroundSwitchListenerSet = new HashSet();
        }
        this.mBackGroundSwitchListenerSet.add(backGroundSwitchListener);
    }

    public void removeBackGroundSwitchListener(BackGroundSwitchListener backGroundSwitchListener) {
        if (this.mBackGroundSwitchListenerSet != null) {
            this.mBackGroundSwitchListenerSet.remove(backGroundSwitchListener);
        }
    }

    public void release() {
        this.mApplicationContext = null;
        if (this.mBackGroundSwitchListenerSet != null) {
            this.mBackGroundSwitchListenerSet.clear();
            this.mBackGroundSwitchListenerSet = null;
        }
        this.mRecorderDependency = null;
    }
}
