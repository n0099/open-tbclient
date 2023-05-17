package com.baidu.pass.face.platform.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    public FaceExtInfo[] a;
    public FaceExtInfo b;
    public FaceConfig c;

    public ArrayList<ImageInfo> a(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance) {
        boolean z;
        String str;
        if (faceExtInfo == null) {
            str = "faceInfo == null";
        } else if (bDFaceImageInstance != null) {
            ArrayList<ImageInfo> arrayList = new ArrayList<>();
            ImageInfo imageInfo = new ImageInfo();
            int i = 0;
            int i2 = 300;
            FaceConfig faceConfig = this.c;
            if (faceConfig != null) {
                i = faceConfig.getSecType();
                i2 = this.c.getCompressValue();
                z = this.c.isCompressImage();
            } else {
                z = true;
            }
            if (i == 0) {
                imageInfo.setBase64(bDFaceImageInstance.getBase64());
            }
            if (i == 1) {
                String imageSec = FaceSDKManager.getInstance().imageSec(bDFaceImageInstance, z, i2);
                if (!TextUtils.isEmpty(imageSec)) {
                    imageInfo.setSecBase64(imageSec.replaceAll("\n", ""));
                }
            }
            arrayList.add(imageInfo);
            return arrayList;
        } else {
            str = "cropInstance == null";
        }
        Log.e("FaceModuleNew", str);
        return null;
    }

    public void a(FaceConfig faceConfig) {
        this.c = faceConfig;
    }

    public FaceExtInfo[] a(FaceInfo[] faceInfoArr) {
        if (this.a == null) {
            this.a = new FaceExtInfo[1];
            this.b = new FaceExtInfo();
        }
        if (faceInfoArr == null || faceInfoArr.length <= 0) {
            this.a[0] = null;
        } else {
            if (this.b == null) {
                this.b = new FaceExtInfo();
            }
            this.b.addFaceInfo(faceInfoArr[0]);
            this.a[0] = this.b;
        }
        return this.a;
    }

    public ArrayList<ImageInfo> b(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance) {
        boolean z;
        String str;
        if (faceExtInfo == null) {
            str = "faceInfo == null";
        } else if (bDFaceImageInstance != null) {
            ArrayList<ImageInfo> arrayList = new ArrayList<>();
            ImageInfo imageInfo = new ImageInfo();
            int i = 0;
            int i2 = 300;
            FaceConfig faceConfig = this.c;
            if (faceConfig != null) {
                i = faceConfig.getSecType();
                i2 = this.c.getCompressValue();
                z = this.c.isCompressImage();
            } else {
                z = true;
            }
            if (i == 0) {
                imageInfo.setBase64(bDFaceImageInstance.getBase64());
            }
            if (i == 1) {
                String imageSec = FaceSDKManager.getInstance().imageSec(bDFaceImageInstance, z, i2);
                if (!TextUtils.isEmpty(imageSec)) {
                    imageInfo.setSecBase64(imageSec.replaceAll("\n", ""));
                }
            }
            arrayList.add(imageInfo);
            return arrayList;
        } else {
            str = "cropInstance == null";
        }
        Log.e("FaceModuleNew", str);
        return null;
    }
}
