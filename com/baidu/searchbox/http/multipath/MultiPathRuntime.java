package com.baidu.searchbox.http.multipath;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Autowired
/* loaded from: classes4.dex */
public class MultiPathRuntime {
    public static final String BIND_MOBILE = "1";
    public static final String BIND_MOBILE_SUCCESS = "1";
    public static final String CLOSE_BIND_MOBILE = "0";
    public static final String FORBID_BIND_MOBILE = "-1";
    public static final String MASTER_REQUEST_BIND_MOBILE = "2";
    public static IMultiPath sMultiPath = getMultiPath();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface BindMobilePolicy {
    }

    @Inject(force = false)
    public static IMultiPath getMultiPath() {
        return IMultiPath.EMPTY;
    }
}
