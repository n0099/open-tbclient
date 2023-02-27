package com.baidu.searchbox.bddownload.core.exception;

import java.io.IOException;
/* loaded from: classes2.dex */
public class NetworkPolicyException extends IOException {
    public NetworkPolicyException() {
        super("Only allows downloading this task on the wifi network type!");
    }
}
