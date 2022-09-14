package com.baidu.adp;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes.dex */
public interface TbadkCore {
    public static final String MODULE = "tbadkcore";
    public static final String NAME = "tbadkcore";
    @NonNull
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("tbadkcore", "tbadkcore");

    boolean permissionUtilCheckReadPhoneState(@NonNull Context context);

    boolean permissionUtilIsAgreePrivacyPolicy();

    @NonNull
    String tbConfigGetVersion();
}
