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
/* loaded from: classes15.dex */
public class l extends AsyncTask<Void, Void, PassFaceRecogResult> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ContrastPortraitResult f4023a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4024b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LivenessRecogActivity livenessRecogActivity, ContrastPortraitResult contrastPortraitResult) {
        this.f4024b = livenessRecogActivity;
        this.f4023a = contrastPortraitResult;
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
        if (this.f4023a.isProcessPass()) {
            this.f4024b.da.H = com.baidu.pass.biometrics.face.liveness.c.a.o;
            passFaceRecogResult.setResultCode(0);
        } else {
            this.f4024b.da.H = com.baidu.pass.biometrics.face.liveness.c.a.p;
            passFaceRecogResult.setResultCode(-302);
        }
        ContrastPortraitResult contrastPortraitResult = this.f4023a;
        passFaceRecogResult.callbackkey = contrastPortraitResult.callbackkey;
        if (!TextUtils.isEmpty(contrastPortraitResult.imgdigests)) {
            arrayList = this.f4024b.ga;
            if (arrayList != null) {
                arrayList2 = this.f4024b.ga;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.f4024b.ga;
                    int size = arrayList3.size();
                    while (true) {
                        if (i >= size) {
                            i = -1;
                            break;
                        }
                        arrayList5 = this.f4024b.ga;
                        byte[] bArr = (byte[]) ((HashMap) arrayList5.get(i)).get("digest");
                        if (bArr != null && this.f4023a.imgdigests.equals(new String(bArr))) {
                            break;
                        }
                        i++;
                    }
                    if (i != -1 && (passFaceRecogDTO = this.f4024b.passFaceRecogDTO) != null) {
                        if (passFaceRecogDTO.isReturnOriginImage()) {
                            list = this.f4024b.X;
                            if (list != null) {
                                list2 = this.f4024b.X;
                                if (list2.size() > 0) {
                                    LivenessRecogActivity livenessRecogActivity = this.f4024b;
                                    list3 = livenessRecogActivity.X;
                                    list4 = this.f4024b.X;
                                    a2 = livenessRecogActivity.a((int[]) list3.get((list4.size() - i) - 1));
                                    passFaceRecogResult.originalImage = a2;
                                }
                            }
                        }
                        if (this.f4024b.passFaceRecogDTO.isReturnCutImage()) {
                            arrayList4 = this.f4024b.ga;
                            byte[] bArr2 = (byte[]) ((HashMap) arrayList4.get(i)).get("data");
                            if (bArr2 != null && (encode = Base64Utils.encode(bArr2)) != null) {
                                passFaceRecogResult.faceimage = new String(encode);
                            }
                            passFaceRecogResult.imgdigests = new String(this.f4023a.imgdigests);
                        }
                    }
                }
            }
        }
        passFaceRecogResult.authSid = this.f4023a.authsid;
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
        if (this.f4023a.isProcessPass()) {
            passFaceRecogCallback2 = this.f4024b.t;
            passFaceRecogCallback2.onSuccess(passFaceRecogResult);
        } else {
            passFaceRecogCallback = this.f4024b.t;
            passFaceRecogCallback.onFailure(passFaceRecogResult);
        }
        this.f4024b.a(passFaceRecogResult.getResultCode());
    }
}
