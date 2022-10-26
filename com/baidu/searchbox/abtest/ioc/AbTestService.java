package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public interface AbTestService {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("abtest", "service");

    String getExpInfos();

    ArrayList getExperimentInfoList();

    double getSwitch(String str, double d);

    int getSwitch(String str, int i);

    long getSwitch(String str, long j);

    Object getSwitch(String str);

    String getSwitch(String str, String str2);

    boolean getSwitch(String str, boolean z);
}
