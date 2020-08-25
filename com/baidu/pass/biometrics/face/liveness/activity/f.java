package com.baidu.pass.biometrics.face.liveness.activity;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.idl.facesdk.FaceVerifyData;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f extends AsyncTask<FaceVerifyData, Void, ArrayList<HashMap<String, byte[]>>> {
    final /* synthetic */ LivenessRecogActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LivenessRecogActivity livenessRecogActivity) {
        this.a = livenessRecogActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public ArrayList<HashMap<String, byte[]>> doInBackground(FaceVerifyData... faceVerifyDataArr) {
        int i;
        int i2;
        Bitmap createBitmap;
        this.a.ea = 0;
        this.a.fa = 0;
        ArrayList<HashMap<String, byte[]>> arrayList = new ArrayList<>();
        for (FaceVerifyData faceVerifyData : faceVerifyDataArr) {
            int[] iArr = faceVerifyData.mRegImg;
            byte[] bArr = faceVerifyData.mRegDigest;
            if (iArr != null && iArr.length > 0 && bArr != null && bArr.length > 0 && (createBitmap = Bitmap.createBitmap((i2 = faceVerifyData.cols), (i = faceVerifyData.rows), Bitmap.Config.ARGB_8888)) != null) {
                createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                if (!createBitmap.isRecycled()) {
                    createBitmap.recycle();
                }
                HashMap<String, byte[]> hashMap = new HashMap<>();
                hashMap.put("data", byteArrayOutputStream.toByteArray());
                hashMap.put("digest", bArr);
                arrayList.add(hashMap);
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(ArrayList<HashMap<String, byte[]>> arrayList) {
        PassFaceRecogCallback passFaceRecogCallback;
        PassFaceRecogCallback passFaceRecogCallback2;
        SdkConfigOptions.LivenessConfigOption livenessConfigOption;
        SdkConfigOptions.LivenessConfigOption livenessConfigOption2;
        int i;
        if (arrayList == null || arrayList.size() <= 0) {
            passFaceRecogCallback = this.a.t;
            if (passFaceRecogCallback != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-306);
                passFaceRecogResult.setResultMsg(PassFaceRecogResult.ERROR_MSG_IMAGE_FILE_EMPTY);
                passFaceRecogCallback2 = this.a.t;
                passFaceRecogCallback2.onFailure(passFaceRecogResult);
            }
            this.a.a(-306);
            return;
        }
        this.a.ea = arrayList.size();
        this.a.ga = arrayList;
        LivenessRecogActivity livenessRecogActivity = this.a;
        PassFaceRecogDTO passFaceRecogDTO = livenessRecogActivity.passFaceRecogDTO;
        if (passFaceRecogDTO != null) {
            if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
                livenessConfigOption = livenessRecogActivity.aa;
                if (livenessConfigOption != null) {
                    LivenessRecogActivity livenessRecogActivity2 = this.a;
                    livenessConfigOption2 = livenessRecogActivity2.aa;
                    i = this.a.ea;
                    livenessRecogActivity2.ea = livenessConfigOption2.getRecogUploadPortraitCount(i);
                }
                this.a.c();
                return;
            }
            livenessRecogActivity.d();
        }
    }
}
