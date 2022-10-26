package com.baidu.ar.face;

import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public interface IFaceResultData extends Parcelable {
    int getAlgoImageHeight();

    int getAlgoImageWidth();

    float[] getFaceBoxes();

    int getFaceCount();

    int[] getFaceIds();

    List getFacePoints();

    float[] getGenders();

    List getHeadPoses();

    float[] getNormalizedFaceBoxes();

    List getNormalizedFacePoints();

    List getSingleFacePoints(int i);

    List getSingleNormalizedFacePoints(int i);

    long getTimestamp();

    List getTriggers();

    boolean isFrontCamera();

    boolean isTracked();
}
