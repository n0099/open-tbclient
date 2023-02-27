package com.baidu.ar.face.algo;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FaceFrame {
    public static final int FACE_ANIMATION_POINTS_COUNT = 95;
    public static final int FACE_LANDMARKS_COUNT = 190;
    public static final int FACE_MAX_COUNT = 4;
    public float[] animatePointsArray;
    public List<FAUPoint2D[]> animatePointsList;
    public List<float[]> animationValuesList;
    public List<FAUFaceBox> faceBoxes;
    public float[] faceBoxesArray;
    public int[] faceIDList;
    public List<float[]> headPoses;
    public int mProcessResult;
    public float[] trackedPointsArray;
    public List<FAUPoint2D[]> trackedPointsList;
    public List<String[]> triggersList;

    public List<FAUPoint2D[]> getAnimatePointsList() {
        if (this.animatePointsArray != null) {
            this.animatePointsList = new ArrayList();
            int length = this.animatePointsArray.length / 190;
            for (int i = 0; i < length; i++) {
                int i2 = i * 95 * 2;
                FAUPoint2D[] fAUPoint2DArr = new FAUPoint2D[95];
                for (int i3 = 0; i3 < 95; i3++) {
                    FAUPoint2D fAUPoint2D = new FAUPoint2D();
                    FAUPoint2D fAUPoint2D2 = fAUPoint2DArr[i3];
                    float[] fArr = this.animatePointsArray;
                    int i4 = (i3 * 2) + i2;
                    fAUPoint2D2.x = fArr[i4];
                    fAUPoint2DArr[i3].y = fArr[i4 + 1];
                    fAUPoint2DArr[i3] = fAUPoint2D;
                }
                this.animatePointsList.add(fAUPoint2DArr);
            }
            this.animatePointsArray = null;
        }
        return this.animatePointsList;
    }

    public List<float[]> getAnimationValuesList() {
        return this.animationValuesList;
    }

    public List<FAUFaceBox> getFaceBoxes() {
        if (this.faceBoxesArray != null) {
            this.faceBoxes = new ArrayList();
            int length = this.faceBoxesArray.length / 5;
            for (int i = 0; i < length; i++) {
                float[] fArr = this.faceBoxesArray;
                int i2 = i * 5;
                this.faceBoxes.add(new FAUFaceBox(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3], fArr[i2 + 4]));
            }
            this.faceBoxesArray = null;
        }
        return this.faceBoxes;
    }

    public int[] getFaceIDList() {
        return this.faceIDList;
    }

    public List<float[]> getHeadPoses() {
        return this.headPoses;
    }

    public int getProcessResult() {
        return this.mProcessResult;
    }

    public List<FAUPoint2D[]> getTrackedPointsList() {
        if (this.trackedPointsArray != null) {
            this.trackedPointsList = new ArrayList();
            int length = this.trackedPointsArray.length / 380;
            for (int i = 0; i < length; i++) {
                int i2 = i * 190 * 2;
                FAUPoint2D[] fAUPoint2DArr = new FAUPoint2D[190];
                for (int i3 = 0; i3 < 190; i3++) {
                    FAUPoint2D fAUPoint2D = new FAUPoint2D();
                    float[] fArr = this.trackedPointsArray;
                    int i4 = (i3 * 2) + i2;
                    fAUPoint2D.x = fArr[i4];
                    fAUPoint2D.y = fArr[i4 + 1];
                    fAUPoint2DArr[i3] = fAUPoint2D;
                }
                this.trackedPointsList.add(fAUPoint2DArr);
            }
            this.trackedPointsArray = null;
        }
        return this.trackedPointsList;
    }

    public List<String[]> getTriggersList() {
        return this.triggersList;
    }
}
