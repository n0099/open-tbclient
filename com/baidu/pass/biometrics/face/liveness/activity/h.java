package com.baidu.pass.biometrics.face.liveness.activity;

import android.os.AsyncTask;
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import java.util.List;
/* loaded from: classes4.dex */
class h extends AsyncTask<Void, Void, PassFaceRecogResult> {
    final /* synthetic */ PassFaceRecogResult a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, PassFaceRecogResult passFaceRecogResult) {
        this.b = iVar;
        this.a = passFaceRecogResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public PassFaceRecogResult doInBackground(Void... voidArr) {
        List list;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        List list2;
        List list3;
        List list4;
        int i;
        String a;
        LivenessRecogActivity livenessRecogActivity = this.b.a;
        if (livenessRecogActivity.passFaceRecogDTO != null) {
            list = livenessRecogActivity.X;
            if (list != null) {
                list2 = this.b.a.X;
                if (list2.size() > 0) {
                    PassFaceRecogResult passFaceRecogResult = this.a;
                    LivenessRecogActivity livenessRecogActivity2 = this.b.a;
                    list3 = livenessRecogActivity2.X;
                    list4 = this.b.a.X;
                    int size = list4.size();
                    i = this.b.a.fa;
                    a = livenessRecogActivity2.a((int[]) list3.get(size - i));
                    passFaceRecogResult.originalImage = a;
                }
            }
            bArr = this.b.a.ia;
            if (bArr != null) {
                bArr4 = this.b.a.ia;
                byte[] encode = Base64Utils.encode(bArr4);
                if (encode != null) {
                    this.a.faceimage = new String(encode);
                }
            }
            bArr2 = this.b.a.ja;
            if (bArr2 != null) {
                PassFaceRecogResult passFaceRecogResult2 = this.a;
                bArr3 = this.b.a.ja;
                passFaceRecogResult2.imgdigests = new String(bArr3);
            }
        }
        return this.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(PassFaceRecogResult passFaceRecogResult) {
        PassFaceRecogCallback passFaceRecogCallback;
        super.onPostExecute(passFaceRecogResult);
        passFaceRecogResult.setResultCode(0);
        passFaceRecogCallback = this.b.a.t;
        passFaceRecogCallback.onSuccess(passFaceRecogResult);
        this.b.a.da.H = com.baidu.pass.biometrics.face.liveness.c.a.o;
        this.b.a.a(passFaceRecogResult.getResultCode());
    }
}
