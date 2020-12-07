package com.baidu.pass.biometrics.face.liveness.activity;

import android.os.AsyncTask;
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import java.util.List;
/* loaded from: classes12.dex */
class h extends AsyncTask<Void, Void, PassFaceRecogResult> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PassFaceRecogResult f2739a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, PassFaceRecogResult passFaceRecogResult) {
        this.b = iVar;
        this.f2739a = passFaceRecogResult;
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
        String a2;
        LivenessRecogActivity livenessRecogActivity = this.b.f2740a;
        if (livenessRecogActivity.passFaceRecogDTO != null) {
            list = livenessRecogActivity.X;
            if (list != null) {
                list2 = this.b.f2740a.X;
                if (list2.size() > 0) {
                    PassFaceRecogResult passFaceRecogResult = this.f2739a;
                    LivenessRecogActivity livenessRecogActivity2 = this.b.f2740a;
                    list3 = livenessRecogActivity2.X;
                    list4 = this.b.f2740a.X;
                    int size = list4.size();
                    i = this.b.f2740a.fa;
                    a2 = livenessRecogActivity2.a((int[]) list3.get(size - i));
                    passFaceRecogResult.originalImage = a2;
                }
            }
            bArr = this.b.f2740a.ia;
            if (bArr != null) {
                bArr4 = this.b.f2740a.ia;
                byte[] encode = Base64Utils.encode(bArr4);
                if (encode != null) {
                    this.f2739a.faceimage = new String(encode);
                }
            }
            bArr2 = this.b.f2740a.ja;
            if (bArr2 != null) {
                PassFaceRecogResult passFaceRecogResult2 = this.f2739a;
                bArr3 = this.b.f2740a.ja;
                passFaceRecogResult2.imgdigests = new String(bArr3);
            }
        }
        return this.f2739a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(PassFaceRecogResult passFaceRecogResult) {
        PassFaceRecogCallback passFaceRecogCallback;
        super.onPostExecute(passFaceRecogResult);
        passFaceRecogResult.setResultCode(0);
        passFaceRecogCallback = this.b.f2740a.t;
        passFaceRecogCallback.onSuccess(passFaceRecogResult);
        this.b.f2740a.da.H = com.baidu.pass.biometrics.face.liveness.c.a.o;
        this.b.f2740a.a(passFaceRecogResult.getResultCode());
    }
}
