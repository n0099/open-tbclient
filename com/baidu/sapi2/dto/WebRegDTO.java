package com.baidu.sapi2.dto;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class WebRegDTO extends SapiWebDTO {
    @Deprecated
    public static final String EXTRA_REGISTER_FAST = "extra_fast_reg";
    public static final String EXTRA_REGISTER_MOBILE = "extra_mobile_reg";
    public String regType = EXTRA_REGISTER_MOBILE;
    public boolean finishActivityAfterSuc = true;
    public List<PassNameValuePair> extraParams = new ArrayList();
}
