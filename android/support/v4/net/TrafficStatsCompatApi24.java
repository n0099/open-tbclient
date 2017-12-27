package android.support.v4.net;

import android.net.TrafficStats;
import android.support.annotation.RestrictTo;
import java.net.DatagramSocket;
import java.net.SocketException;
@RestrictTo
/* loaded from: classes2.dex */
public class TrafficStatsCompatApi24 {
    public static void tagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
        TrafficStats.tagDatagramSocket(datagramSocket);
    }

    public static void untagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
        TrafficStats.untagDatagramSocket(datagramSocket);
    }
}
