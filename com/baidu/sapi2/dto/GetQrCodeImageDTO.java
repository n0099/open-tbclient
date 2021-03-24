package com.baidu.sapi2.dto;

import com.baidu.sapi2.NoProguard;
/* loaded from: classes2.dex */
public class GetQrCodeImageDTO implements NoProguard {
    public static final String LP_TYPE_APP = "app";
    public static final String LP_TYPE_PC = "pc";
    public String hostDeviceId;
    public String lp = "pc";
    public boolean needQrCodeContent;
    public String openPlatformId;
}
