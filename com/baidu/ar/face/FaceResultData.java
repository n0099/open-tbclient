package com.baidu.ar.face;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
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
    private int mL;
    private int mM;
    private boolean mR;
    private float[] mS;
    private List<PointF> mT;
    private long mTimestamp;
    private List<float[]> mU;
    private int[] mV;
    private float[] mW;
    private float[] mX;
    private List<PointF> mY;
    private List<String[]> mt;

    public FaceResultData() {
        this.mR = false;
        this.mS = null;
        this.mT = null;
        this.mU = null;
        this.mV = null;
        this.mW = null;
        this.mFrontCamera = true;
        this.mt = null;
        this.mX = null;
        this.mY = null;
    }

    protected FaceResultData(Parcel parcel) {
        this.mR = false;
        this.mS = null;
        this.mT = null;
        this.mU = null;
        this.mV = null;
        this.mW = null;
        this.mFrontCamera = true;
        this.mt = null;
        this.mX = null;
        this.mY = null;
        this.mR = parcel.readByte() != 0;
        this.mL = parcel.readInt();
        this.mM = parcel.readInt();
        this.mS = parcel.createFloatArray();
        this.mT = parcel.createTypedArrayList(PointF.CREATOR);
        this.mV = parcel.createIntArray();
        this.mW = parcel.createFloatArray();
        this.mFrontCamera = parcel.readByte() != 0;
        this.mTimestamp = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt < 0) {
            this.mU = null;
        } else {
            this.mU = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                this.mU.add(parcel.createFloatArray());
            }
        }
        int readInt2 = parcel.readInt();
        if (readInt2 < 0) {
            this.mt = null;
            return;
        }
        this.mt = new ArrayList();
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.mt.add(parcel.createStringArray());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getAlgoImageHeight() {
        return this.mM;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getAlgoImageWidth() {
        return this.mL;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getFaceBoxes() {
        return this.mS;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getFaceCount() {
        if (this.mS == null) {
            return 0;
        }
        return this.mS.length / 4;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int[] getFaceIds() {
        return this.mV;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getFacePoints() {
        return this.mT;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getGenders() {
        return this.mW;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<float[]> getHeadPoses() {
        return this.mU;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getNormalizedFaceBoxes() {
        if (this.mX == null && this.mS != null && this.mM > 0 && this.mL > 0) {
            this.mX = new float[this.mS.length];
            float f = this.mL;
            float f2 = this.mM;
            int length = this.mS.length;
            for (int i = 0; i < length; i++) {
                if (i % 2 == 0) {
                    this.mX[i] = this.mS[i] / f;
                } else {
                    this.mX[i] = this.mS[i] / f2;
                }
            }
        }
        return this.mX;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getNormalizedFacePoints() {
        if (this.mY == null && this.mT != null && this.mM > 0 && this.mL > 0) {
            this.mY = new ArrayList();
            float f = this.mL;
            float f2 = this.mM;
            int size = this.mT.size();
            for (int i = 0; i < size; i++) {
                PointF pointF = this.mT.get(i);
                this.mY.add(new PointF(pointF.x / f, pointF.y / f2));
            }
        }
        return this.mY;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getSingleFacePoints(int i) {
        int faceCount = getFaceCount();
        if (i < 0 || i >= faceCount || this.mT == null) {
            return null;
        }
        int size = this.mT.size() / faceCount;
        int i2 = i * size;
        return this.mT.subList(i2, size + i2);
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
        return this.mt;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public boolean isFrontCamera() {
        return this.mFrontCamera;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public boolean isTracked() {
        return this.mR;
    }

    public void setAlgoImageHeight(int i) {
        this.mM = i;
        this.mX = null;
        this.mY = null;
    }

    public void setAlgoImageWidth(int i) {
        this.mL = i;
        this.mX = null;
        this.mY = null;
    }

    public void setFaceBoxes(float[] fArr) {
        this.mS = fArr;
        this.mX = null;
    }

    public void setFaceIds(int[] iArr) {
        this.mV = iArr;
    }

    public void setFacePoints(List<PointF> list) {
        this.mT = list;
        this.mY = null;
    }

    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setGenders(float[] fArr) {
        this.mW = fArr;
    }

    public void setHeadPoses(List<float[]> list) {
        this.mU = list;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    public void setTracked(boolean z) {
        this.mR = z;
    }

    public void setTriggers(List<String[]> list) {
        this.mt = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.mR ? 1 : 0));
        parcel.writeInt(this.mL);
        parcel.writeInt(this.mM);
        parcel.writeFloatArray(this.mS);
        parcel.writeTypedList(this.mT);
        parcel.writeIntArray(this.mV);
        parcel.writeFloatArray(this.mW);
        parcel.writeByte((byte) (this.mFrontCamera ? 1 : 0));
        parcel.writeLong(this.mTimestamp);
        if (this.mU == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(this.mU.size());
            for (float[] fArr : this.mU) {
                parcel.writeFloatArray(fArr);
            }
        }
        int size = this.mt == null ? -1 : this.mt.size();
        parcel.writeInt(size);
        if (size <= 0 || this.mt == null) {
            return;
        }
        for (String[] strArr : this.mt) {
            parcel.writeStringArray(strArr);
        }
    }
}
