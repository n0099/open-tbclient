package com.baidu.sapi2.dto;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
/* loaded from: classes2.dex */
public class WebRegDTO extends SapiDTO {
    public static final String EXTRA_REGISTER_FAST = "extra_fast_reg";
    public static final String EXTRA_REGISTER_MOBILE = "extra_mobile_reg";
    public String regType = EXTRA_REGISTER_MOBILE;
    public List<NameValuePair> extraParams = new ArrayList();
}
