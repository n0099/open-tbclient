package com.baidu.ar.face.attributes;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.f.b;
import com.baidu.ar.face.FaceResultData;
import com.baidu.ar.face.a.h;
import com.baidu.ar.face.algo.FAUFaceBox;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceFrame;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private HashMap<Integer, float[]> mD = new HashMap<>();
    private boolean mE = false;

    private static float[] a(ByteBuffer byteBuffer, FAUFaceBox fAUFaceBox, int i, int i2) {
        float[] fArr = new float[2];
        if (FaceAttributesJni.predictGenderDetect(byteBuffer, i, i2, new float[]{fAUFaceBox.getX(), fAUFaceBox.getY(), fAUFaceBox.getWidth(), fAUFaceBox.getHeight(), fAUFaceBox.getAngle()}, fArr) == 0) {
            return fArr;
        }
        return null;
    }

    private boolean f(h hVar) {
        if (this.mE) {
            if (hVar.isTracked()) {
                return true;
            }
            b.c("FaceAttributesManager", "faceResult.isTracked == false.");
            return false;
        }
        return false;
    }

    public void a(h hVar, FaceResultData faceResultData, int i, int i2) {
        if (f(hVar)) {
            FaceAlgoData cN = hVar.cN();
            FaceFrame faceFrame = cN == null ? null : cN.getFaceFrame();
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
            float[] fArr = this.mD.get(Integer.valueOf(i3));
            if (fArr != null) {
                faceResultData.setGenders(fArr);
                return;
            }
            float[] a = a(hVar.cM(), faceBoxes.get(0), i, i2);
            if (a == null || !this.mE) {
                return;
            }
            this.mD.put(Integer.valueOf(i3), a);
            faceResultData.setGenders(a);
        }
    }

    public int b(Context context, String str) {
        int initGenderDetect;
        if (TextUtils.isEmpty(str)) {
            b.b("FaceAttributesManager", "gender model path is empty.");
            return -1;
        } else if (this.mE) {
            return 0;
        } else {
            if (FaceAttributesJni.mC) {
                if (str.startsWith("file:///android_asset/")) {
                    String replace = str.replace("file:///android_asset/", "");
                    FaceAttributesJni.setAssetManager(context.getAssets());
                    initGenderDetect = FaceAttributesJni.initGenderDetectFromAssets(replace);
                } else {
                    initGenderDetect = FaceAttributesJni.initGenderDetect(str);
                }
                this.mE = initGenderDetect == 0;
                return initGenderDetect;
            }
            return -1;
        }
    }

    public void release() {
        if (this.mE) {
            this.mE = false;
            FaceAttributesJni.releaseGenderDetect();
        }
    }
}
