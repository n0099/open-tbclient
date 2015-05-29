package com.baidu.tbadk.aladin.b;

import java.net.InetAddress;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    private static final HashSet<String> Ns = new HashSet<>();

    static {
        Ns.add("127.0.0.1");
    }

    public static final boolean a(InetAddress inetAddress) {
        String hostAddress;
        return (inetAddress == null || (hostAddress = inetAddress.getHostAddress()) == null || !Ns.contains(hostAddress)) ? false : true;
    }
}
