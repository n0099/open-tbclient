package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tieba.r8;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public interface AbTestService {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("abtest", "service");

    String getExpInfos();

    ArrayList<r8> getExperimentInfoList();

    double getSwitch(String str, double d);

    int getSwitch(String str, int i);

    long getSwitch(String str, long j);

    Object getSwitch(String str);

    String getSwitch(String str, String str2);

    boolean getSwitch(String str, boolean z);
}
