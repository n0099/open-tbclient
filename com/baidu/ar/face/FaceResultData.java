package com.baidu.ar.face;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FaceResultData implements Parcelable, IFaceResultData {
    public static final Parcelable.Creator<FaceResultData> CREATOR = new Parcelable.Creator<FaceResultData>() { // from class: com.baidu.ar.face.FaceResultData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FaceResultData createFromParcel(Parcel parcel) {
            return new FaceResultData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: w */
        public FaceResultData[] newArray(int i) {
            return new FaceResultData[i];
        }
    };
    private List<String[]> lW;
    private float[] mA;
    private List<PointF> mB;
    private boolean mFrontCamera;
    private long mTimestamp;
    private int mo;
    private int mp;
    private boolean mu;
    private float[] mv;
    private List<PointF> mw;
    private List<float[]> mx;
    private int[] my;
    private float[] mz;

    public FaceResultData() {
        this.mu = false;
        this.mv = null;
        this.mw = null;
        this.mx = null;
        this.my = null;
        this.mz = null;
        this.mFrontCamera = true;
        this.lW = null;
        this.mA = null;
        this.mB = null;
    }

    protected FaceResultData(Parcel parcel) {
        this.mu = false;
        this.mv = null;
        this.mw = null;
        this.mx = null;
        this.my = null;
        this.mz = null;
        this.mFrontCamera = true;
        this.lW = null;
        this.mA = null;
        this.mB = null;
        this.mu = parcel.readByte() != 0;
        this.mo = parcel.readInt();
        this.mp = parcel.readInt();
        this.mv = parcel.createFloatArray();
        this.mw = parcel.createTypedArrayList(PointF.CREATOR);
        this.my = parcel.createIntArray();
        this.mz = parcel.createFloatArray();
        this.mFrontCamera = parcel.readByte() != 0;
        this.mTimestamp = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt < 0) {
            this.mx = null;
        } else {
            this.mx = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                this.mx.add(parcel.createFloatArray());
            }
        }
        int readInt2 = parcel.readInt();
        if (readInt2 < 0) {
            this.lW = null;
            return;
        }
        this.lW = new ArrayList();
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.lW.add(parcel.createStringArray());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getAlgoImageHeight() {
        return this.mp;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getAlgoImageWidth() {
        return this.mo;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getFaceBoxes() {
        return this.mv;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getFaceCount() {
        if (this.mv == null) {
            return 0;
        }
        return this.mv.length / 4;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int[] getFaceIds() {
        return this.my;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getFacePoints() {
        return this.mw;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getGenders() {
        return this.mz;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<float[]> getHeadPoses() {
        return this.mx;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getNormalizedFaceBoxes() {
        if (this.mA == null && this.mv != null && this.mp > 0 && this.mo > 0) {
            this.mA = new float[this.mv.length];
            float f = this.mo;
            float f2 = this.mp;
            int length = this.mv.length;
            for (int i = 0; i < length; i++) {
                if (i % 2 == 0) {
                    this.mA[i] = this.mv[i] / f;
                } else {
                    this.mA[i] = this.mv[i] / f2;
                }
            }
        }
        return this.mA;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getNormalizedFacePoints() {
        if (this.mB == null && this.mw != null && this.mp > 0 && this.mo > 0) {
            this.mB = new ArrayList();
            float f = this.mo;
            float f2 = this.mp;
            int size = this.mw.size();
            for (int i = 0; i < size; i++) {
                PointF pointF = this.mw.get(i);
                this.mB.add(new PointF(pointF.x / f, pointF.y / f2));
            }
        }
        return this.mB;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getSingleFacePoints(int i) {
        int faceCount = getFaceCount();
        if (i < 0 || i >= faceCount || this.mw == null) {
            return null;
        }
        int size = this.mw.size() / faceCount;
        int i2 = i * size;
        return this.mw.subList(i2, size + i2);
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
        return this.lW;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public boolean isFrontCamera() {
        return this.mFrontCamera;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public boolean isTracked() {
        return this.mu;
    }

    public void setAlgoImageHeight(int i) {
        this.mp = i;
        this.mA = null;
        this.mB = null;
    }

    public void setAlgoImageWidth(int i) {
        this.mo = i;
        this.mA = null;
        this.mB = null;
    }

    public void setFaceBoxes(float[] fArr) {
        this.mv = fArr;
        this.mA = null;
    }

    public void setFaceIds(int[] iArr) {
        this.my = iArr;
    }

    public void setFacePoints(List<PointF> list) {
        this.mw = list;
        this.mB = null;
    }

    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setGenders(float[] fArr) {
        this.mz = fArr;
    }

    public void setHeadPoses(List<float[]> list) {
        this.mx = list;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    public void setTracked(boolean z) {
        this.mu = z;
    }

    public void setTriggers(List<String[]> list) {
        this.lW = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.mu ? 1 : 0));
        parcel.writeInt(this.mo);
        parcel.writeInt(this.mp);
        parcel.writeFloatArray(this.mv);
        parcel.writeTypedList(this.mw);
        parcel.writeIntArray(this.my);
        parcel.writeFloatArray(this.mz);
        parcel.writeByte((byte) (this.mFrontCamera ? 1 : 0));
        parcel.writeLong(this.mTimestamp);
        if (this.mx == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(this.mx.size());
            for (float[] fArr : this.mx) {
                parcel.writeFloatArray(fArr);
            }
        }
        int size = this.lW == null ? -1 : this.lW.size();
        parcel.writeInt(size);
        if (size <= 0 || this.lW == null) {
            return;
        }
        for (String[] strArr : this.lW) {
            parcel.writeStringArray(strArr);
        }
    }
}
