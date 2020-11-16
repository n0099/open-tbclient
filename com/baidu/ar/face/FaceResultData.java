package com.baidu.ar.face;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class FaceResultData implements Parcelable, IFaceResultData {
    public static final Parcelable.Creator<FaceResultData> CREATOR = new Parcelable.Creator<FaceResultData>() { // from class: com.baidu.ar.face.FaceResultData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: A */
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
    private boolean mFrontCamera;
    private long mTimestamp;
    private float[] nA;
    private List<PointF> nB;
    private List<float[]> nC;
    private int[] nD;
    private float[] nE;
    private float[] nF;
    private List<PointF> nG;
    private List<String[]> nb;
    private boolean nx;
    private int ny;
    private int nz;

    public FaceResultData() {
        this.nx = false;
        this.nA = null;
        this.nB = null;
        this.nC = null;
        this.nD = null;
        this.nE = null;
        this.mFrontCamera = true;
        this.nb = null;
        this.nF = null;
        this.nG = null;
    }

    protected FaceResultData(Parcel parcel) {
        this.nx = false;
        this.nA = null;
        this.nB = null;
        this.nC = null;
        this.nD = null;
        this.nE = null;
        this.mFrontCamera = true;
        this.nb = null;
        this.nF = null;
        this.nG = null;
        this.nx = parcel.readByte() != 0;
        this.ny = parcel.readInt();
        this.nz = parcel.readInt();
        this.nA = parcel.createFloatArray();
        this.nB = parcel.createTypedArrayList(PointF.CREATOR);
        this.nD = parcel.createIntArray();
        this.nE = parcel.createFloatArray();
        this.mFrontCamera = parcel.readByte() != 0;
        this.mTimestamp = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt < 0) {
            this.nC = null;
        } else {
            this.nC = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                this.nC.add(parcel.createFloatArray());
            }
        }
        int readInt2 = parcel.readInt();
        if (readInt2 < 0) {
            this.nb = null;
            return;
        }
        this.nb = new ArrayList();
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.nb.add(parcel.createStringArray());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getAlgoImageHeight() {
        return this.nz;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getAlgoImageWidth() {
        return this.ny;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getFaceBoxes() {
        return this.nA;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getFaceCount() {
        if (this.nA == null) {
            return 0;
        }
        return this.nA.length / 4;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int[] getFaceIds() {
        return this.nD;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getFacePoints() {
        return this.nB;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getGenders() {
        return this.nE;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<float[]> getHeadPoses() {
        return this.nC;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getNormalizedFaceBoxes() {
        if (this.nF == null && this.nA != null && this.nz > 0 && this.ny > 0) {
            this.nF = new float[this.nA.length];
            float f = this.ny;
            float f2 = this.nz;
            int length = this.nA.length;
            for (int i = 0; i < length; i++) {
                if (i % 2 == 0) {
                    this.nF[i] = this.nA[i] / f;
                } else {
                    this.nF[i] = this.nA[i] / f2;
                }
            }
        }
        return this.nF;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getNormalizedFacePoints() {
        if (this.nG == null && this.nB != null && this.nz > 0 && this.ny > 0) {
            this.nG = new ArrayList();
            float f = this.ny;
            float f2 = this.nz;
            int size = this.nB.size();
            for (int i = 0; i < size; i++) {
                PointF pointF = this.nB.get(i);
                this.nG.add(new PointF(pointF.x / f, pointF.y / f2));
            }
        }
        return this.nG;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getSingleFacePoints(int i) {
        int faceCount = getFaceCount();
        if (i < 0 || i >= faceCount || this.nB == null) {
            return null;
        }
        int size = this.nB.size() / faceCount;
        int i2 = i * size;
        return this.nB.subList(i2, size + i2);
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
        return this.nb;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public boolean isFrontCamera() {
        return this.mFrontCamera;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public boolean isTracked() {
        return this.nx;
    }

    public void setAlgoImageHeight(int i) {
        this.nz = i;
        this.nF = null;
        this.nG = null;
    }

    public void setAlgoImageWidth(int i) {
        this.ny = i;
        this.nF = null;
        this.nG = null;
    }

    public void setFaceBoxes(float[] fArr) {
        this.nA = fArr;
        this.nF = null;
    }

    public void setFaceIds(int[] iArr) {
        this.nD = iArr;
    }

    public void setFacePoints(List<PointF> list) {
        this.nB = list;
        this.nG = null;
    }

    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setGenders(float[] fArr) {
        this.nE = fArr;
    }

    public void setHeadPoses(List<float[]> list) {
        this.nC = list;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    public void setTracked(boolean z) {
        this.nx = z;
    }

    public void setTriggers(List<String[]> list) {
        this.nb = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.nx ? 1 : 0));
        parcel.writeInt(this.ny);
        parcel.writeInt(this.nz);
        parcel.writeFloatArray(this.nA);
        parcel.writeTypedList(this.nB);
        parcel.writeIntArray(this.nD);
        parcel.writeFloatArray(this.nE);
        parcel.writeByte((byte) (this.mFrontCamera ? 1 : 0));
        parcel.writeLong(this.mTimestamp);
        if (this.nC == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(this.nC.size());
            for (float[] fArr : this.nC) {
                parcel.writeFloatArray(fArr);
            }
        }
        int size = this.nb == null ? -1 : this.nb.size();
        parcel.writeInt(size);
        if (size <= 0 || this.nb == null) {
            return;
        }
        for (String[] strArr : this.nb) {
            parcel.writeStringArray(strArr);
        }
    }
}
