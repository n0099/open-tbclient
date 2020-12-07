package com.baidu.ar.face.attributes;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.arrender.l;
import com.baidu.ar.face.FaceResultData;
import com.baidu.ar.face.algo.FAUFaceBox;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceFrame;
import com.baidu.ar.face.detector.m;
import com.baidu.ar.h.b;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private HashMap<Integer, float[]> nY = new HashMap<>();
    private boolean nZ = false;
    private l oa;

    public a(l lVar) {
        this.oa = lVar;
    }

    private boolean Z(String str) {
        if (new File(str).exists()) {
            return true;
        }
        b.b("FaceAttributesManager", "open model path error:" + str);
        return false;
    }

    private static float[] a(ByteBuffer byteBuffer, FAUFaceBox fAUFaceBox, int i, int i2) {
        float[] fArr = new float[2];
        if (FaceAttributesJni.predictGenderDetect(byteBuffer, i, i2, new float[]{fAUFaceBox.getX(), fAUFaceBox.getY(), fAUFaceBox.getWidth(), fAUFaceBox.getHeight(), fAUFaceBox.getAngle()}, fArr) == 0) {
            return fArr;
        }
        return null;
    }

    private boolean c(Context context, String str) {
        try {
            context.getAssets().open(str).close();
            return true;
        } catch (Exception e) {
            b.b("FaceAttributesManager", "open asset model path error:" + str);
            return false;
        }
    }

    private boolean d(m mVar) {
        if (this.nZ) {
            if (mVar.isTracked()) {
                return true;
            }
            b.c("FaceAttributesManager", "faceResult.isTracked == false.");
            return false;
        }
        return false;
    }

    public void a(m mVar, FaceResultData faceResultData, int i, int i2) {
        if (d(mVar)) {
            FaceAlgoData eC = mVar.eC();
            FaceFrame faceFrame = eC == null ? null : eC.getFaceFrame();
            if (faceFrame == null) {
                b.c("FaceAttributesManager", "faceFrame == null.");
                return;
            }
            List<FAUFaceBox> faceBoxes = faceFrame.getFaceBoxes();
            int[] faceIDList = faceFrame.getFaceIDList();
            if (faceBoxes == null || faceBoxes.size() == 0 || faceIDList == null || faceIDList.length == 0) {
                b.c("FaceAttributesManager", "fauFaceBoxes is empty.");
                return;
            }
            faceResultData.setFaceIds(faceIDList);
            int i3 = faceIDList[0];
            float[] fArr = this.nY.get(Integer.valueOf(i3));
            if (fArr != null) {
                faceResultData.setGenders(fArr);
                return;
            }
            float[] a2 = a(mVar.eB(), faceBoxes.get(0), i, i2);
            if (a2 == null || !this.nZ) {
                return;
            }
            this.nY.put(Integer.valueOf(i3), a2);
            faceResultData.setGenders(a2);
            if (this.oa != null) {
                this.oa.a("face_gender_predict", Float.valueOf(a2[0]));
            }
        }
    }

    public int b(Context context, String str) {
        int initGenderDetect;
        if (TextUtils.isEmpty(str)) {
            b.b("FaceAttributesManager", "gender model path is empty.");
            return -1;
        } else if (this.nZ) {
            return 0;
        } else {
            if (FaceAttributesJni.nX) {
                if (str.startsWith("file:///android_asset/")) {
                    String replace = str.replace("file:///android_asset/", "");
                    if (!c(context, replace)) {
                        return -1;
                    }
                    FaceAttributesJni.setAssetManager(context.getAssets());
                    initGenderDetect = FaceAttributesJni.initGenderDetectFromAssets(replace);
                } else if (!Z(str)) {
                    return -1;
                } else {
                    initGenderDetect = FaceAttributesJni.initGenderDetect(str);
                }
                this.nZ = initGenderDetect == 0;
                return initGenderDetect;
            }
            return -1;
        }
    }

    public void release() {
        this.oa = null;
        if (this.nZ) {
            this.nZ = false;
            FaceAttributesJni.releaseGenderDetect();
        }
    }

    public void reset() {
        this.nY.clear();
    }
}
