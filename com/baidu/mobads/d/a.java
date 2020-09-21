package com.baidu.mobads.d;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader;
import com.baidu.mobads.openad.b.f;
import java.net.URL;
/* loaded from: classes3.dex */
public class a extends f implements IXAdStaticImgDownloader {
    public a(Context context, URL url, String str, String str2) {
        super(context, url, str, str2, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.openad.b.f
    public void a() {
        super.a();
    }

    @Override // com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader
    public Bitmap getBitmap() {
        return null;
    }
}
