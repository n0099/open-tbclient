package com.baidu.ar.face;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FaceResultData implements Parcelable, IFaceResultData {
    public static final Parcelable.Creator<FaceResultData> CREATOR = new Parcelable.Creator<FaceResultData>() { // from class: com.baidu.ar.face.FaceResultData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: C */
        public FaceResultData[] newArray(int i) {
            return new FaceResultData[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FaceResultData createFromParcel(Parcel parcel) {
            return new FaceResultData(parcel);
        }
    };
    public boolean mFrontCamera;
    public long mTimestamp;
    public boolean nN;
    public int nO;
    public int nP;
    public float[] nQ;
    public List<PointF> nR;
    public List<float[]> nS;
    public int[] nT;
    public float[] nU;
    public float[] nV;
    public List<PointF> nW;
    public List<String[]> nr;

    public FaceResultData() {
        this.nN = false;
        this.nQ = null;
        this.nR = null;
        this.nS = null;
        this.nT = null;
        this.nU = null;
        this.mFrontCamera = true;
        this.nr = null;
        this.nV = null;
        this.nW = null;
    }

    public FaceResultData(Parcel parcel) {
        this.nN = false;
        this.nQ = null;
        this.nR = null;
        this.nS = null;
        this.nT = null;
        this.nU = null;
        this.mFrontCamera = true;
        this.nr = null;
        this.nV = null;
        this.nW = null;
        this.nN = parcel.readByte() != 0;
        this.nO = parcel.readInt();
        this.nP = parcel.readInt();
        this.nQ = parcel.createFloatArray();
        this.nR = parcel.createTypedArrayList(PointF.CREATOR);
        this.nT = parcel.createIntArray();
        this.nU = parcel.createFloatArray();
        this.mFrontCamera = parcel.readByte() != 0;
        this.mTimestamp = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt < 0) {
            this.nS = null;
        } else {
            this.nS = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                this.nS.add(parcel.createFloatArray());
            }
        }
        int readInt2 = parcel.readInt();
        if (readInt2 < 0) {
            this.nr = null;
            return;
        }
        this.nr = new ArrayList();
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.nr.add(parcel.createStringArray());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getAlgoImageHeight() {
        return this.nP;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getAlgoImageWidth() {
        return this.nO;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getFaceBoxes() {
        return this.nQ;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getFaceCount() {
        float[] fArr = this.nQ;
        if (fArr == null) {
            return 0;
        }
        return fArr.length / 4;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int[] getFaceIds() {
        return this.nT;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getFacePoints() {
        return this.nR;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getGenders() {
        return this.nU;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<float[]> getHeadPoses() {
        return this.nS;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getNormalizedFaceBoxes() {
        float[] fArr;
        int i;
        int i2;
        if (this.nV == null && (fArr = this.nQ) != null && (i = this.nP) > 0 && (i2 = this.nO) > 0) {
            this.nV = new float[fArr.length];
            float f = i2;
            float f2 = i;
            int length = fArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (i3 % 2 == 0) {
                    this.nV[i3] = this.nQ[i3] / f;
                } else {
                    this.nV[i3] = this.nQ[i3] / f2;
                }
            }
        }
        return this.nV;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getNormalizedFacePoints() {
        if (this.nW == null && this.nR != null && this.nP > 0 && this.nO > 0) {
            this.nW = new ArrayList();
            float f = this.nO;
            float f2 = this.nP;
            int size = this.nR.size();
            for (int i = 0; i < size; i++) {
                PointF pointF = this.nR.get(i);
                this.nW.add(new PointF(pointF.x / f, pointF.y / f2));
            }
        }
        return this.nW;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getSingleFacePoints(int i) {
        List<PointF> list;
        int faceCount = getFaceCount();
        if (i < 0 || i >= faceCount || (list = this.nR) == null) {
            return null;
        }
        int size = list.size() / faceCount;
        int i2 = i * size;
        return this.nR.subList(i2, size + i2);
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getSingleNormalizedFacePoints(int i) {
        int faceCount = getFaceCount();
        List<PointF> normalizedFacePoints = getNormalizedFacePoints();
        if (i < 0 || i >= faceCount || normalizedFacePoints == null) {
            return null;
        }
        int size = normalizedFacePoints.size() / faceCount;
        int i2 = i * size;
        return normalizedFacePoints.subList(i2, size + i2);
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public long getTimestamp() {
        return this.mTimestamp;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<String[]> getTriggers() {
        return this.nr;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public boolean isFrontCamera() {
        return this.mFrontCamera;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public boolean isTracked() {
        return this.nN;
    }

    public void setAlgoImageHeight(int i) {
        this.nP = i;
        this.nV = null;
        this.nW = null;
    }

    public void setAlgoImageWidth(int i) {
        this.nO = i;
        this.nV = null;
        this.nW = null;
    }

    public void setFaceBoxes(float[] fArr) {
        this.nQ = fArr;
        this.nV = null;
    }

    public void setFaceIds(int[] iArr) {
        this.nT = iArr;
    }

    public void setFacePoints(List<PointF> list) {
        this.nR = list;
        this.nW = null;
    }

    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setGenders(float[] fArr) {
        this.nU = fArr;
    }

    public void setHeadPoses(List<float[]> list) {
        this.nS = list;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    public void setTracked(boolean z) {
        this.nN = z;
    }

    public void setTriggers(List<String[]> list) {
        this.nr = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        List<String[]> list;
        parcel.writeByte(this.nN ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.nO);
        parcel.writeInt(this.nP);
        parcel.writeFloatArray(this.nQ);
        parcel.writeTypedList(this.nR);
        parcel.writeIntArray(this.nT);
        parcel.writeFloatArray(this.nU);
        parcel.writeByte(this.mFrontCamera ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.mTimestamp);
        List<float[]> list2 = this.nS;
        if (list2 == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(list2.size());
            for (float[] fArr : this.nS) {
                parcel.writeFloatArray(fArr);
            }
        }
        List<String[]> list3 = this.nr;
        int size = list3 != null ? list3.size() : -1;
        parcel.writeInt(size);
        if (size <= 0 || (list = this.nr) == null) {
            return;
        }
        for (String[] strArr : list) {
            parcel.writeStringArray(strArr);
        }
    }
}
