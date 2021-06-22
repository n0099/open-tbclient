package com.baidu.pass.face.platform.model;

import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
/* loaded from: classes2.dex */
public class FaceModel {
    public BDFaceImageInstance BitmapInstance;
    public BDFaceImageInstance cropInstance;
    public FaceExtInfo[] faceInfos;
    public FaceStatusNewEnum faceNewStatus;
    public FaceInfo[] faceSDKInfos;
    public long frameTime;
    public BDFaceImageInstance imageInstance;

    public BDFaceImageInstance getBitmapInstance() {
        return this.BitmapInstance;
    }

    public BDFaceImageInstance getCropInstance() {
        return this.cropInstance;
    }

    public FaceExtInfo[] getFaceInfos() {
        return this.faceInfos;
    }

    public FaceStatusNewEnum getFaceModuleStateNew() {
        return this.faceNewStatus;
    }

    public FaceInfo[] getFaceSDKInfos() {
        return this.faceSDKInfos;
    }

    public long getFrameTime() {
        return this.frameTime;
    }

    public BDFaceImageInstance getImageInstance() {
        return this.imageInstance;
    }

    public void setBitmapInstance(BDFaceImageInstance bDFaceImageInstance) {
        this.BitmapInstance = bDFaceImageInstance;
    }

    public void setCropInstance(BDFaceImageInstance bDFaceImageInstance) {
        this.cropInstance = bDFaceImageInstance;
    }

    public void setFaceInfos(FaceExtInfo[] faceExtInfoArr) {
        this.faceInfos = faceExtInfoArr;
    }

    public void setFaceModuleStateNew(FaceStatusNewEnum faceStatusNewEnum) {
        this.faceNewStatus = faceStatusNewEnum;
    }

    public void setFaceSDKInfos(FaceInfo[] faceInfoArr) {
        this.faceSDKInfos = faceInfoArr;
    }

    public void setFrameTime(long j) {
        this.frameTime = j;
    }

    public void setImageInstance(BDFaceImageInstance bDFaceImageInstance) {
        this.imageInstance = bDFaceImageInstance;
    }
}
