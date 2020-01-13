package com.baidu.searchbox.network.core;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes12.dex */
public interface Dns {
    public static final Dns SYSTEM = new Dns() { // from class: com.baidu.searchbox.network.core.Dns.1
        @Override // com.baidu.searchbox.network.core.Dns
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
    };

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
