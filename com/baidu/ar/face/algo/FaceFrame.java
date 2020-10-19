package com.baidu.ar.face.algo;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class FaceFrame {
    static final int FACE_ANIMATION_POINTS_COUNT = 95;
    static final int FACE_LANDMARKS_COUNT = 190;
    static final int FACE_MAX_COUNT = 4;
    float[] animatePointsArray;
    List<FAUPoint2D[]> animatePointsList;
    List<float[]> animationValuesList;
    List<FAUFaceBox> faceBoxes;
    float[] faceBoxesArray;
    int[] faceIDList;
    List<float[]> headPoses;
    int mProcessResult;
    float[] trackedPointsArray;
    List<FAUPoint2D[]> trackedPointsList;
    List<String[]> triggersList;

    public List<FAUPoint2D[]> getAnimatePointsList() {
        if (this.animatePointsArray != null) {
            this.animatePointsList = new ArrayList();
            int length = this.animatePointsArray.length / 190;
            for (int i = 0; i < length; i++) {
                int i2 = i * 95 * 2;
                FAUPoint2D[] fAUPoint2DArr = new FAUPoint2D[95];
                for (int i3 = 0; i3 < 95; i3++) {
                    FAUPoint2D fAUPoint2D = new FAUPoint2D();
                    fAUPoint2DArr[i3].x = this.animatePointsArray[(i3 * 2) + i2];
                    fAUPoint2DArr[i3].y = this.animatePointsArray[(i3 * 2) + i2 + 1];
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
                this.faceBoxes.add(new FAUFaceBox(this.faceBoxesArray[i * 5], this.faceBoxesArray[(i * 5) + 1], this.faceBoxesArray[(i * 5) + 2], this.faceBoxesArray[(i * 5) + 3], this.faceBoxesArray[(i * 5) + 4]));
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
                    fAUPoint2D.x = this.trackedPointsArray[(i3 * 2) + i2];
                    fAUPoint2D.y = this.trackedPointsArray[(i3 * 2) + i2 + 1];
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
