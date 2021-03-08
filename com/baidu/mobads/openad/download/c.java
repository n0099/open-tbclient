package com.baidu.mobads.openad.download;

import android.graphics.Bitmap;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes4.dex */
class c extends com.baidu.mobads.f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2442a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2442a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.f.a
    /* renamed from: d */
    public Void a() {
        BufferedOutputStream bufferedOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f2442a.j.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        this.f2442a.i = byteArrayOutputStream.toByteArray();
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.f2442a.c + this.f2442a.d + ".tmp"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            bufferedOutputStream = null;
        }
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.write(this.f2442a.i);
                bufferedOutputStream.flush();
                XAdSDKFoundationFacade.getInstance().getIoUtils().renameFile(this.f2442a.c + this.f2442a.d + ".tmp", this.f2442a.c + this.f2442a.d);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
