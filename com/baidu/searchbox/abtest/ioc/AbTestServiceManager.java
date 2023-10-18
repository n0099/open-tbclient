package com.baidu.searchbox.abtest.ioc;

import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.tieba.r3;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AbTestServiceManager implements AbTestService {
    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public String getExpInfos() {
        return AbTestManager.getInstance().getExpInfos();
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public ArrayList<r3> getExperimentInfoList() {
        return AbTestManager.getInstance().getExperimentInfoList();
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public double getSwitch(String str, double d) {
        return AbTestManager.getInstance().getSwitch(str, d);
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public int getSwitch(String str, int i) {
        return AbTestManager.getInstance().getSwitch(str, i);
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public long getSwitch(String str, long j) {
        return AbTestManager.getInstance().getSwitch(str, j);
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public Object getSwitch(String str) {
        return AbTestManager.getInstance().getSwitch(str);
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public String getSwitch(String str, String str2) {
        return AbTestManager.getInstance().getSwitch(str, str2);
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public boolean getSwitch(String str, boolean z) {
        return AbTestManager.getInstance().getSwitch(str, z);
    }
}
