package com.baidu.sapi2.dto;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class PhoneRegDTO extends SapiDTO {
    public Map<String, String> extraParams = new HashMap();
    public boolean noPwd;
    public String password;
    public String phoneNumber;
    public String regCode;
}
