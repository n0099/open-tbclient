package com.baidu.ar.algo;

import com.baidu.ar.libloader.b;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class ARAlgoJniClient {
    static volatile ARAlgoJniClient arAlgoJniClient;
    private long trackSystemHandler = 0;

    static {
        b.as("module_basic");
    }

    public static native int calModelPosition(float[] fArr, float f, float[] fArr2, float[] fArr3);

    public static ARAlgoJniClient getAlgoInstance() {
        if (arAlgoJniClient == null) {
            synchronized (ARAlgoJniClient.class) {
                if (arAlgoJniClient == null) {
                    arAlgoJniClient = new ARAlgoJniClient();
                }
            }
        }
        return arAlgoJniClient;
    }

    public static String getVersion() {
        return nativeGetVersion();
    }

    private native int nativeAddTracker2D(long j, String str);

    private native int nativeAddTracker3D(long j, String str, int i);

    private native int nativeAddTrackerVO(long j, String str);

    private native int nativeAddTrackerVPS(long j, String str);

    private native int nativeCreateTrackingSystem(long j, int i, int i2, float[] fArr, float[] fArr2);

    private native int nativeGet2dMarkerSize(long j, int i, int[] iArr);

    private native int nativeGetModelPose(long j, int i, String str, float[] fArr);

    private native int nativeGetTrackerPose(long j, int i, float[] fArr);

    private static native String nativeGetVersion();

    private native long nativeInitTrackerSystem();

    private native int nativeInsertModel(long j, int i, int i2, int i3, String str, float f, float[] fArr);

    private native int nativeRelease(long j);

    private native int nativeRemoveAllModels(long j, int i);

    private native int nativeRemoveAllTrackers(long j);

    private native int nativeRemoveModel(long j, int i, String str);

    private native int nativeRemoveTracker(long j, int i);

    private native int nativeResetAllTrackers(long j);

    private native int nativeResetTracker(long j, int i);

    private native int nativeTrackFrame(long j, byte[] bArr, double d, float[] fArr, FrameType frameType);

    private native int nativeTrackFrameByteBuffer(long j, ByteBuffer byteBuffer, double d, float[] fArr, FrameType frameType);

    private native int nativeVpsServerReceiver(long j, int i, byte[] bArr);

    public int addTracker2D(String str) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeAddTracker2D(this.trackSystemHandler, str);
    }

    public int addTracker3D(String str, int i) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeAddTracker3D(this.trackSystemHandler, str, i);
    }

    public int addTrackerVO(String str) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeAddTrackerVO(this.trackSystemHandler, str);
    }

    public int addTrackerVPS(String str) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeAddTrackerVPS(this.trackSystemHandler, str);
    }

    public int createTrackingSystem(int i, int i2, float[] fArr, float[] fArr2) {
        this.trackSystemHandler = nativeInitTrackerSystem();
        return nativeCreateTrackingSystem(this.trackSystemHandler, i, i2, fArr, fArr2);
    }

    public int get2DMarkerSize(int i, int[] iArr) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeGet2dMarkerSize(this.trackSystemHandler, i, iArr);
    }

    public int getModelPose(int i, String str, float[] fArr) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeGetModelPose(this.trackSystemHandler, i, str, fArr);
    }

    public int getTrackerPose(int i, float[] fArr) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeGetTrackerPose(this.trackSystemHandler, i, fArr);
    }

    public int insertModel(int i, int i2, int i3, String str, float f, float[] fArr) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeInsertModel(this.trackSystemHandler, i, i2, i3, str, f, fArr);
    }

    public int release() {
        if (this.trackSystemHandler == 0) {
            return 0;
        }
        int nativeRelease = nativeRelease(this.trackSystemHandler);
        this.trackSystemHandler = 0L;
        return nativeRelease;
    }

    public int removeAllModels(int i) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeRemoveAllModels(this.trackSystemHandler, i);
    }

    public int removeAllTrackers() {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeRemoveAllTrackers(this.trackSystemHandler);
    }

    public int removeModel(int i, String str) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeRemoveModel(this.trackSystemHandler, i, str);
    }

    public int removeTracker(int i) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeRemoveTracker(this.trackSystemHandler, i);
    }

    public int resetAllTrackers() {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeResetAllTrackers(this.trackSystemHandler);
    }

    public int resetTracker(int i) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeResetTracker(this.trackSystemHandler, i);
    }

    public int trackFrame(ByteBuffer byteBuffer, double d, float[] fArr, FrameType frameType) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeTrackFrameByteBuffer(this.trackSystemHandler, byteBuffer, d, fArr, frameType);
    }

    public int trackFrame(byte[] bArr, double d, float[] fArr, FrameType frameType) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeTrackFrame(this.trackSystemHandler, bArr, d, fArr, frameType);
    }

    public int vpsServerReceiver(int i, byte[] bArr) {
        if (this.trackSystemHandler == 0) {
            return -2;
        }
        return nativeVpsServerReceiver(this.trackSystemHandler, i, bArr);
    }
}
