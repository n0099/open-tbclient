package com.baidu.ar.algovo;

import com.baidu.ar.algo.ARAlgoJniClient;
import com.baidu.ar.algo.FrameType;
import com.baidu.ar.slam.TrackModel;
import com.baidu.ar.slam.TrackParams;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class ARVOJniClient {
    private static List<String> sModelIds;
    private static int sTrackerId;

    public static int calModelPosition(float[] fArr, float f, float[] fArr2, float[] fArr3) {
        return ARAlgoJniClient.calModelPosition(fArr, f, fArr2, fArr3);
    }

    public static synchronized ArrayList<TrackModel> fetchModelPose() {
        ArrayList<TrackModel> arrayList;
        synchronized (ARVOJniClient.class) {
            arrayList = new ArrayList<>();
            if (sModelIds != null) {
                for (String str : sModelIds) {
                    float[] fArr = new float[16];
                    if (ARAlgoJniClient.getAlgoInstance().getModelPose(sTrackerId, str, fArr) == 0) {
                        TrackModel trackModel = new TrackModel();
                        trackModel.setId(str);
                        trackModel.setPose(fArr);
                        arrayList.add(trackModel);
                    }
                }
            }
        }
        return arrayList;
    }

    public static synchronized int insertModel(String str, int i, int i2, float[] fArr, float f) {
        int insertModel;
        synchronized (ARVOJniClient.class) {
            insertModel = ARAlgoJniClient.getAlgoInstance().insertModel(sTrackerId, i, i2, str, f, fArr);
            if (insertModel == 0) {
                if (sModelIds == null) {
                    sModelIds = new ArrayList();
                }
                sModelIds.add(str);
            }
        }
        return insertModel;
    }

    public static synchronized int removeAllModel() {
        int removeAllModels;
        synchronized (ARVOJniClient.class) {
            removeAllModels = ARAlgoJniClient.getAlgoInstance().removeAllModels(sTrackerId);
            if (removeAllModels == 0 && sModelIds != null) {
                sModelIds.clear();
            }
        }
        return removeAllModels;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        com.baidu.ar.algovo.ARVOJniClient.sModelIds.remove(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized int removeModel(String str) {
        int removeModel;
        synchronized (ARVOJniClient.class) {
            removeModel = ARAlgoJniClient.getAlgoInstance().removeModel(sTrackerId, str);
            if (removeModel == 0 && sModelIds != null) {
                int size = sModelIds.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (sModelIds.get(i).equals(str)) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        return removeModel;
    }

    public static synchronized void reset() {
        synchronized (ARVOJniClient.class) {
            if (sTrackerId >= 0) {
                ARAlgoJniClient.getAlgoInstance().removeAllModels(sTrackerId);
            }
        }
    }

    public static synchronized boolean start(int i, int i2, float[] fArr, float[] fArr2) {
        boolean z = false;
        synchronized (ARVOJniClient.class) {
            if (ARAlgoJniClient.getAlgoInstance().createTrackingSystem(i, i2, fArr, fArr2) == 0) {
                sTrackerId = ARAlgoJniClient.getAlgoInstance().addTrackerVO("");
                if (sTrackerId >= 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static synchronized void stop() {
        synchronized (ARVOJniClient.class) {
            ARAlgoJniClient.getAlgoInstance().release();
            sModelIds = null;
        }
    }

    public static synchronized TrackParams track(ByteBuffer byteBuffer, float[] fArr) {
        TrackParams trackParams;
        synchronized (ARVOJniClient.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int trackFrame = ARAlgoJniClient.getAlgoInstance().trackFrame(byteBuffer, ((float) currentTimeMillis) * 1.0f, fArr, FrameType.TYPE_YUV);
            trackParams = new TrackParams();
            trackParams.processTime = (float) (System.currentTimeMillis() - currentTimeMillis);
            trackParams.trackQuality = trackFrame;
        }
        return trackParams;
    }
}
