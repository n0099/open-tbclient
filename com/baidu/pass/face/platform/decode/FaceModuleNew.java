package com.baidu.pass.face.platform.decode;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FaceModuleNew {
    public static final String TAG = "FaceModuleNew";
    public FaceConfig mFaceConfig;
    public FaceExtInfo mFaceExtInfo;
    public FaceExtInfo[] mFaceExtInfos;

    public ArrayList<ImageInfo> getDetectBestCropImageList(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance) {
        if (faceExtInfo == null) {
            Log.e(TAG, "faceInfo == null");
            return null;
        } else if (bDFaceImageInstance == null) {
            Log.e(TAG, "cropInstance == null");
            return null;
        } else {
            ArrayList<ImageInfo> arrayList = new ArrayList<>();
            ImageInfo imageInfo = new ImageInfo();
            FaceConfig faceConfig = this.mFaceConfig;
            int secType = faceConfig != null ? faceConfig.getSecType() : 0;
            imageInfo.setBase64(bDFaceImageInstance.getBase64());
            if (secType == 1) {
                String imageSec = FaceSDKManager.getInstance().imageSec(bDFaceImageInstance);
                if (!TextUtils.isEmpty(imageSec)) {
                    imageInfo.setSecBase64(imageSec.replaceAll("\n", ""));
                }
            }
            arrayList.add(imageInfo);
            return arrayList;
        }
    }

    public ArrayList<ImageInfo> getDetectBestSrcImageList(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance) {
        if (faceExtInfo == null) {
            Log.e(TAG, "faceInfo == null");
            return null;
        } else if (bDFaceImageInstance == null) {
            Log.e(TAG, "cropInstance == null");
            return null;
        } else {
            ArrayList<ImageInfo> arrayList = new ArrayList<>();
            ImageInfo imageInfo = new ImageInfo();
            FaceConfig faceConfig = this.mFaceConfig;
            int secType = faceConfig != null ? faceConfig.getSecType() : 0;
            imageInfo.setBase64(bDFaceImageInstance.getBase64());
            if (secType == 1) {
                String imageSec = FaceSDKManager.getInstance().imageSec(bDFaceImageInstance);
                if (!TextUtils.isEmpty(imageSec)) {
                    imageInfo.setSecBase64(imageSec.replaceAll("\n", ""));
                }
            }
            arrayList.add(imageInfo);
            return arrayList;
        }
    }

    public FaceExtInfo[] getFaceExtInfo(FaceInfo[] faceInfoArr) {
        if (this.mFaceExtInfos == null) {
            this.mFaceExtInfos = new FaceExtInfo[1];
            this.mFaceExtInfo = new FaceExtInfo();
        }
        if (faceInfoArr != null && faceInfoArr.length > 0) {
            if (this.mFaceExtInfo == null) {
                this.mFaceExtInfo = new FaceExtInfo();
            }
            this.mFaceExtInfo.addFaceInfo(faceInfoArr[0]);
            this.mFaceExtInfos[0] = this.mFaceExtInfo;
        } else {
            this.mFaceExtInfos[0] = null;
        }
        return this.mFaceExtInfos;
    }

    public void setFaceConfig(FaceConfig faceConfig) {
        this.mFaceConfig = faceConfig;
    }
}
