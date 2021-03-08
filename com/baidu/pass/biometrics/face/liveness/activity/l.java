package com.baidu.pass.biometrics.face.liveness.activity;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.http.result.ContrastPortraitResult;
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class l extends AsyncTask<Void, Void, PassFaceRecogResult> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ContrastPortraitResult f2792a;
    final /* synthetic */ LivenessRecogActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LivenessRecogActivity livenessRecogActivity, ContrastPortraitResult contrastPortraitResult) {
        this.b = livenessRecogActivity;
        this.f2792a = contrastPortraitResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public PassFaceRecogResult doInBackground(Void... voidArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        PassFaceRecogDTO passFaceRecogDTO;
        ArrayList arrayList4;
        byte[] encode;
        List list;
        List list2;
        List list3;
        List list4;
        String a2;
        ArrayList arrayList5;
        int i = 0;
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        if (this.f2792a.isProcessPass()) {
            this.b.da.H = com.baidu.pass.biometrics.face.liveness.c.a.o;
            passFaceRecogResult.setResultCode(0);
        } else {
            this.b.da.H = com.baidu.pass.biometrics.face.liveness.c.a.p;
            passFaceRecogResult.setResultCode(-302);
        }
        ContrastPortraitResult contrastPortraitResult = this.f2792a;
        passFaceRecogResult.callbackkey = contrastPortraitResult.callbackkey;
        if (!TextUtils.isEmpty(contrastPortraitResult.imgdigests)) {
            arrayList = this.b.ga;
            if (arrayList != null) {
                arrayList2 = this.b.ga;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.b.ga;
                    int size = arrayList3.size();
                    while (true) {
                        if (i >= size) {
                            i = -1;
                            break;
                        }
                        arrayList5 = this.b.ga;
                        byte[] bArr = (byte[]) ((HashMap) arrayList5.get(i)).get("digest");
                        if (bArr != null && this.f2792a.imgdigests.equals(new String(bArr))) {
                            break;
                        }
                        i++;
                    }
                    if (i != -1 && (passFaceRecogDTO = this.b.passFaceRecogDTO) != null) {
                        if (passFaceRecogDTO.isReturnOriginImage()) {
                            list = this.b.X;
                            if (list != null) {
                                list2 = this.b.X;
                                if (list2.size() > 0) {
                                    LivenessRecogActivity livenessRecogActivity = this.b;
                                    list3 = livenessRecogActivity.X;
                                    list4 = this.b.X;
                                    a2 = livenessRecogActivity.a((int[]) list3.get((list4.size() - i) - 1));
                                    passFaceRecogResult.originalImage = a2;
                                }
                            }
                        }
                        if (this.b.passFaceRecogDTO.isReturnCutImage()) {
                            arrayList4 = this.b.ga;
                            byte[] bArr2 = (byte[]) ((HashMap) arrayList4.get(i)).get("data");
                            if (bArr2 != null && (encode = Base64Utils.encode(bArr2)) != null) {
                                passFaceRecogResult.faceimage = new String(encode);
                            }
                            passFaceRecogResult.imgdigests = new String(this.f2792a.imgdigests);
                        }
                    }
                }
            }
        }
        passFaceRecogResult.authSid = this.f2792a.authsid;
        return passFaceRecogResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(PassFaceRecogResult passFaceRecogResult) {
        PassFaceRecogCallback passFaceRecogCallback;
        PassFaceRecogCallback passFaceRecogCallback2;
        super.onPostExecute(passFaceRecogResult);
        if (this.f2792a.isProcessPass()) {
            passFaceRecogCallback2 = this.b.t;
            passFaceRecogCallback2.onSuccess(passFaceRecogResult);
        } else {
            passFaceRecogCallback = this.b.t;
            passFaceRecogCallback.onFailure(passFaceRecogResult);
        }
        this.b.a(passFaceRecogResult.getResultCode());
    }
}
