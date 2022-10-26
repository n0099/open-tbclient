package com.baidu.adp;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes.dex */
public interface TbadkCore {
    public static final String MODULE = "tbadkcore";
    public static final String NAME = "tbadkcore";
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("tbadkcore", "tbadkcore");

    boolean permissionUtilCheckReadPhoneState(Context context);

    boolean permissionUtilIsAgreePrivacyPolicy();

    String tbConfigGetVersion();
}
