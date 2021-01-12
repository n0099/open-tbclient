package com.baidu.pass.biometrics.face.liveness.activity;

import android.os.AsyncTask;
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import java.util.List;
/* loaded from: classes6.dex */
class h extends AsyncTask<Void, Void, PassFaceRecogResult> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PassFaceRecogResult f4015a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i f4016b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, PassFaceRecogResult passFaceRecogResult) {
        this.f4016b = iVar;
        this.f4015a = passFaceRecogResult;
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
        LivenessRecogActivity livenessRecogActivity = this.f4016b.f4017a;
        if (livenessRecogActivity.passFaceRecogDTO != null) {
            list = livenessRecogActivity.X;
            if (list != null) {
                list2 = this.f4016b.f4017a.X;
                if (list2.size() > 0) {
                    PassFaceRecogResult passFaceRecogResult = this.f4015a;
                    LivenessRecogActivity livenessRecogActivity2 = this.f4016b.f4017a;
                    list3 = livenessRecogActivity2.X;
                    list4 = this.f4016b.f4017a.X;
                    int size = list4.size();
                    i = this.f4016b.f4017a.fa;
                    a2 = livenessRecogActivity2.a((int[]) list3.get(size - i));
                    passFaceRecogResult.originalImage = a2;
                }
            }
            bArr = this.f4016b.f4017a.ia;
            if (bArr != null) {
                bArr4 = this.f4016b.f4017a.ia;
                byte[] encode = Base64Utils.encode(bArr4);
                if (encode != null) {
                    this.f4015a.faceimage = new String(encode);
                }
            }
            bArr2 = this.f4016b.f4017a.ja;
            if (bArr2 != null) {
                PassFaceRecogResult passFaceRecogResult2 = this.f4015a;
                bArr3 = this.f4016b.f4017a.ja;
                passFaceRecogResult2.imgdigests = new String(bArr3);
            }
        }
        return this.f4015a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(PassFaceRecogResult passFaceRecogResult) {
        PassFaceRecogCallback passFaceRecogCallback;
        super.onPostExecute(passFaceRecogResult);
        passFaceRecogResult.setResultCode(0);
        passFaceRecogCallback = this.f4016b.f4017a.t;
        passFaceRecogCallback.onSuccess(passFaceRecogResult);
        this.f4016b.f4017a.da.H = com.baidu.pass.biometrics.face.liveness.c.a.o;
        this.f4016b.f4017a.a(passFaceRecogResult.getResultCode());
    }
}
