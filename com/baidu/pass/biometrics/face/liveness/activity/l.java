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
/* loaded from: classes6.dex */
public class l extends AsyncTask<Void, Void, PassFaceRecogResult> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ContrastPortraitResult f4020a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4021b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LivenessRecogActivity livenessRecogActivity, ContrastPortraitResult contrastPortraitResult) {
        this.f4021b = livenessRecogActivity;
        this.f4020a = contrastPortraitResult;
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
        if (this.f4020a.isProcessPass()) {
            this.f4021b.da.H = com.baidu.pass.biometrics.face.liveness.c.a.o;
            passFaceRecogResult.setResultCode(0);
        } else {
            this.f4021b.da.H = com.baidu.pass.biometrics.face.liveness.c.a.p;
            passFaceRecogResult.setResultCode(-302);
        }
        ContrastPortraitResult contrastPortraitResult = this.f4020a;
        passFaceRecogResult.callbackkey = contrastPortraitResult.callbackkey;
        if (!TextUtils.isEmpty(contrastPortraitResult.imgdigests)) {
            arrayList = this.f4021b.ga;
            if (arrayList != null) {
                arrayList2 = this.f4021b.ga;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.f4021b.ga;
                    int size = arrayList3.size();
                    while (true) {
                        if (i >= size) {
                            i = -1;
                            break;
                        }
                        arrayList5 = this.f4021b.ga;
                        byte[] bArr = (byte[]) ((HashMap) arrayList5.get(i)).get("digest");
                        if (bArr != null && this.f4020a.imgdigests.equals(new String(bArr))) {
                            break;
                        }
                        i++;
                    }
                    if (i != -1 && (passFaceRecogDTO = this.f4021b.passFaceRecogDTO) != null) {
                        if (passFaceRecogDTO.isReturnOriginImage()) {
                            list = this.f4021b.X;
                            if (list != null) {
                                list2 = this.f4021b.X;
                                if (list2.size() > 0) {
                                    LivenessRecogActivity livenessRecogActivity = this.f4021b;
                                    list3 = livenessRecogActivity.X;
                                    list4 = this.f4021b.X;
                                    a2 = livenessRecogActivity.a((int[]) list3.get((list4.size() - i) - 1));
                                    passFaceRecogResult.originalImage = a2;
                                }
                            }
                        }
                        if (this.f4021b.passFaceRecogDTO.isReturnCutImage()) {
                            arrayList4 = this.f4021b.ga;
                            byte[] bArr2 = (byte[]) ((HashMap) arrayList4.get(i)).get("data");
                            if (bArr2 != null && (encode = Base64Utils.encode(bArr2)) != null) {
                                passFaceRecogResult.faceimage = new String(encode);
                            }
                            passFaceRecogResult.imgdigests = new String(this.f4020a.imgdigests);
                        }
                    }
                }
            }
        }
        passFaceRecogResult.authSid = this.f4020a.authsid;
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
        if (this.f4020a.isProcessPass()) {
            passFaceRecogCallback2 = this.f4021b.t;
            passFaceRecogCallback2.onSuccess(passFaceRecogResult);
        } else {
            passFaceRecogCallback = this.f4021b.t;
            passFaceRecogCallback.onFailure(passFaceRecogResult);
        }
        this.f4021b.a(passFaceRecogResult.getResultCode());
    }
}
