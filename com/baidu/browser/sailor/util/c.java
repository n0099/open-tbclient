package com.baidu.browser.sailor.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class c {

    /* loaded from: classes9.dex */
    public interface a {
        void a(JSONObject jSONObject);
    }

    public static String a() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    InetAddress inetAddress = (InetAddress) it2.next();
                    String hostAddress = inetAddress.getHostAddress();
                    if (!inetAddress.isLoopbackAddress() && a(hostAddress)) {
                        return hostAddress;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean a(String str) {
        try {
            return Inet4Address.getByName(str) != null;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
