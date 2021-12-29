package com.baidu.searchbox.logsystem.exceptionhandler.api;

import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes10.dex */
public interface ExceptionHandler {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("logsystem", "exceptionhandler");

    void onException(Exception exc, String str, String str2, Map<String, String> map);
}
