package com.baidu.ar.face;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class FaceResultData implements Parcelable, IFaceResultData {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<FaceResultData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1497143701, "Lcom/baidu/ar/face/FaceResultData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1497143701, "Lcom/baidu/ar/face/FaceResultData;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<FaceResultData>() { // from class: com.baidu.ar.face.FaceResultData.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: C */
            public FaceResultData[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? new FaceResultData[i2] : (FaceResultData[]) invokeI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public FaceResultData createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel)) == null) ? new FaceResultData(parcel) : (FaceResultData) invokeL.objValue;
            }
        };
    }

    public FaceResultData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
            for (int i4 = 0; i4 < readInt; i4++) {
                this.nS.add(parcel.createFloatArray());
            }
        }
        int readInt2 = parcel.readInt();
        if (readInt2 < 0) {
            this.nr = null;
            return;
        }
        this.nr = new ArrayList();
        for (int i5 = 0; i5 < readInt2; i5++) {
            this.nr.add(parcel.createStringArray());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getAlgoImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.nP : invokeV.intValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getAlgoImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.nO : invokeV.intValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getFaceBoxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.nQ : (float[]) invokeV.objValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int getFaceCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float[] fArr = this.nQ;
            if (fArr == null) {
                return 0;
            }
            return fArr.length / 4;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public int[] getFaceIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.nT : (int[]) invokeV.objValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getFacePoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.nR : (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getGenders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.nU : (float[]) invokeV.objValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<float[]> getHeadPoses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.nS : (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public float[] getNormalizedFaceBoxes() {
        InterceptResult invokeV;
        float[] fArr;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.nV == null && (fArr = this.nQ) != null && (i2 = this.nP) > 0 && (i3 = this.nO) > 0) {
                this.nV = new float[fArr.length];
                float f2 = i3;
                float f3 = i2;
                int length = fArr.length;
                for (int i4 = 0; i4 < length; i4++) {
                    if (i4 % 2 == 0) {
                        this.nV[i4] = this.nQ[i4] / f2;
                    } else {
                        this.nV[i4] = this.nQ[i4] / f3;
                    }
                }
            }
            return this.nV;
        }
        return (float[]) invokeV.objValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getNormalizedFacePoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.nW == null && this.nR != null && this.nP > 0 && this.nO > 0) {
                this.nW = new ArrayList();
                float f2 = this.nO;
                float f3 = this.nP;
                int size = this.nR.size();
                for (int i2 = 0; i2 < size; i2++) {
                    PointF pointF = this.nR.get(i2);
                    this.nW.add(new PointF(pointF.x / f2, pointF.y / f3));
                }
            }
            return this.nW;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getSingleFacePoints(int i2) {
        InterceptResult invokeI;
        List<PointF> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            int faceCount = getFaceCount();
            if (i2 < 0 || i2 >= faceCount || (list = this.nR) == null) {
                return null;
            }
            int size = list.size() / faceCount;
            int i3 = i2 * size;
            return this.nR.subList(i3, size + i3);
        }
        return (List) invokeI.objValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<PointF> getSingleNormalizedFacePoints(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            int faceCount = getFaceCount();
            List<PointF> normalizedFacePoints = getNormalizedFacePoints();
            if (i2 < 0 || i2 >= faceCount || normalizedFacePoints == null) {
                return null;
            }
            int size = normalizedFacePoints.size() / faceCount;
            int i3 = i2 * size;
            return normalizedFacePoints.subList(i3, size + i3);
        }
        return (List) invokeI.objValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public long getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mTimestamp : invokeV.longValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public List<String[]> getTriggers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.nr : (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public boolean isFrontCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mFrontCamera : invokeV.booleanValue;
    }

    @Override // com.baidu.ar.face.IFaceResultData
    public boolean isTracked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.nN : invokeV.booleanValue;
    }

    public void setAlgoImageHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.nP = i2;
            this.nV = null;
            this.nW = null;
        }
    }

    public void setAlgoImageWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.nO = i2;
            this.nV = null;
            this.nW = null;
        }
    }

    public void setFaceBoxes(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fArr) == null) {
            this.nQ = fArr;
            this.nV = null;
        }
    }

    public void setFaceIds(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, iArr) == null) {
            this.nT = iArr;
        }
    }

    public void setFacePoints(List<PointF> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            this.nR = list;
            this.nW = null;
        }
    }

    public void setFrontCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.mFrontCamera = z;
        }
    }

    public void setGenders(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, fArr) == null) {
            this.nU = fArr;
        }
    }

    public void setHeadPoses(List<float[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            this.nS = list;
        }
    }

    public void setTimestamp(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) {
            this.mTimestamp = j2;
        }
    }

    public void setTracked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.nN = z;
        }
    }

    public void setTriggers(List<String[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
            this.nr = list;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        List<String[]> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048604, this, parcel, i2) == null) {
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
}
