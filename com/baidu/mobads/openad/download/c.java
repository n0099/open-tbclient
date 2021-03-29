package com.baidu.mobads.openad.download;

import android.graphics.Bitmap;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class c extends com.baidu.mobads.f.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f8429a;

    public c(b bVar) {
        this.f8429a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.f.a
    /* renamed from: d */
    public Void a() {
        BufferedOutputStream bufferedOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f8429a.j.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        this.f8429a.i = byteArrayOutputStream.toByteArray();
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.f8429a.f8423c + this.f8429a.f8424d + ".tmp"));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            bufferedOutputStream = null;
        }
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.write(this.f8429a.i);
                bufferedOutputStream.flush();
                XAdSDKFoundationFacade.getInstance().getIoUtils().renameFile(this.f8429a.f8423c + this.f8429a.f8424d + ".tmp", this.f8429a.f8423c + this.f8429a.f8424d);
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }
}
