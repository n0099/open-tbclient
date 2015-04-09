package com.baidu.tbadk.aladin.b;

import java.net.InetAddress;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    private static final HashSet<String> Ne = new HashSet<>();

    static {
        Ne.add("127.0.0.1");
    }

    public static final boolean a(InetAddress inetAddress) {
        String hostAddress;
        return (inetAddress == null || (hostAddress = inetAddress.getHostAddress()) == null || !Ne.contains(hostAddress)) ? false : true;
    }
}
