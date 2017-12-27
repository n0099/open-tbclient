package android.support.v4.net;

import android.os.Build;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
/* loaded from: classes2.dex */
public final class TrafficStatsCompat {
    private static final TrafficStatsCompatImpl IMPL;

    /* loaded from: classes2.dex */
    interface TrafficStatsCompatImpl {
        void clearThreadStatsTag();

        int getThreadStatsTag();

        void incrementOperationCount(int i);

        void incrementOperationCount(int i, int i2);

        void setThreadStatsTag(int i);

        void tagDatagramSocket(DatagramSocket datagramSocket) throws SocketException;

        void tagSocket(Socket socket) throws SocketException;

        void untagDatagramSocket(DatagramSocket datagramSocket) throws SocketException;

        void untagSocket(Socket socket) throws SocketException;
    }

    /* loaded from: classes2.dex */
    static class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        private ThreadLocal<SocketTags> mThreadSocketTags = new ThreadLocal<SocketTags>() { // from class: android.support.v4.net.TrafficStatsCompat.BaseTrafficStatsCompatImpl.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public SocketTags initialValue() {
                return new SocketTags();
            }
        };

        BaseTrafficStatsCompatImpl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class SocketTags {
            public int statsTag = -1;

            SocketTags() {
            }
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void clearThreadStatsTag() {
            this.mThreadSocketTags.get().statsTag = -1;
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public int getThreadStatsTag() {
            return this.mThreadSocketTags.get().statsTag;
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int i) {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int i, int i2) {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void setThreadStatsTag(int i) {
            this.mThreadSocketTags.get().statsTag = i;
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void tagSocket(Socket socket) {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void untagSocket(Socket socket) {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void tagDatagramSocket(DatagramSocket datagramSocket) {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void untagDatagramSocket(DatagramSocket datagramSocket) {
        }
    }

    /* loaded from: classes2.dex */
    static class IcsTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        IcsTrafficStatsCompatImpl() {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void clearThreadStatsTag() {
            TrafficStatsCompatIcs.clearThreadStatsTag();
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public int getThreadStatsTag() {
            return TrafficStatsCompatIcs.getThreadStatsTag();
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int i) {
            TrafficStatsCompatIcs.incrementOperationCount(i);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int i, int i2) {
            TrafficStatsCompatIcs.incrementOperationCount(i, i2);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void setThreadStatsTag(int i) {
            TrafficStatsCompatIcs.setThreadStatsTag(i);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void tagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.tagSocket(socket);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void untagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.untagSocket(socket);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void tagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
            TrafficStatsCompatIcs.tagDatagramSocket(datagramSocket);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void untagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
            TrafficStatsCompatIcs.untagDatagramSocket(datagramSocket);
        }
    }

    /* loaded from: classes2.dex */
    static class Api24TrafficStatsCompatImpl extends IcsTrafficStatsCompatImpl {
        Api24TrafficStatsCompatImpl() {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.IcsTrafficStatsCompatImpl, android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void tagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
            TrafficStatsCompatApi24.tagDatagramSocket(datagramSocket);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.IcsTrafficStatsCompatImpl, android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void untagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
            TrafficStatsCompatApi24.untagDatagramSocket(datagramSocket);
        }
    }

    static {
        if ("N".equals(Build.VERSION.CODENAME)) {
            IMPL = new Api24TrafficStatsCompatImpl();
        } else if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new IcsTrafficStatsCompatImpl();
        } else {
            IMPL = new BaseTrafficStatsCompatImpl();
        }
    }

    public static void clearThreadStatsTag() {
        IMPL.clearThreadStatsTag();
    }

    public static int getThreadStatsTag() {
        return IMPL.getThreadStatsTag();
    }

    public static void incrementOperationCount(int i) {
        IMPL.incrementOperationCount(i);
    }

    public static void incrementOperationCount(int i, int i2) {
        IMPL.incrementOperationCount(i, i2);
    }

    public static void setThreadStatsTag(int i) {
        IMPL.setThreadStatsTag(i);
    }

    public static void tagSocket(Socket socket) throws SocketException {
        IMPL.tagSocket(socket);
    }

    public static void untagSocket(Socket socket) throws SocketException {
        IMPL.untagSocket(socket);
    }

    public static void tagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
        IMPL.tagDatagramSocket(datagramSocket);
    }

    public static void untagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
        IMPL.untagDatagramSocket(datagramSocket);
    }

    private TrafficStatsCompat() {
    }
}
