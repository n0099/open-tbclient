package com.baidu.searchbox.ng.ai.apps.ar.manager;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.ar.view.ARCameraView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class ARCameraUtil {
    List<ARCameraView> cameraList;

    private ARCameraUtil() {
        this.cameraList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final ARCameraUtil sInstance = new ARCameraUtil();

        private SingletonHolder() {
        }
    }

    public static ARCameraUtil getInstance() {
        return SingletonHolder.sInstance;
    }

    public ARCameraView getCameraViewBySlaveId(String str) {
        if (TextUtils.isEmpty(str) || this.cameraList.isEmpty()) {
            return null;
        }
        for (ARCameraView aRCameraView : this.cameraList) {
            if (aRCameraView != null && TextUtils.equals(aRCameraView.getSlaveId(), str)) {
                return aRCameraView;
            }
        }
        return null;
    }

    public void addCameraView(ARCameraView aRCameraView) {
        this.cameraList.add(aRCameraView);
    }

    public void removeCameraViewBySlaveId(String str) {
        ARCameraView aRCameraView;
        if (!TextUtils.isEmpty(str) && !this.cameraList.isEmpty()) {
            Iterator<ARCameraView> it = this.cameraList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aRCameraView = null;
                    break;
                }
                aRCameraView = it.next();
                if (aRCameraView != null && TextUtils.equals(aRCameraView.getSlaveId(), str)) {
                    break;
                }
            }
            if (aRCameraView != null) {
                this.cameraList.remove(aRCameraView);
            }
        }
    }

    public void clearCameraList() {
        this.cameraList.clear();
    }
}
