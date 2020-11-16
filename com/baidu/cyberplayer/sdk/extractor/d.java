package com.baidu.cyberplayer.sdk.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.remote.a;
import com.baidu.cyberplayer.sdk.remote.e;
import com.baidu.cyberplayer.sdk.remote.g;
import java.io.FileDescriptor;
import java.util.Map;
/* loaded from: classes17.dex */
public class d extends ExtractorProvider {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.cyberplayer.sdk.remote.a f1388a;

    public d(com.baidu.cyberplayer.sdk.remote.a aVar) {
        this.f1388a = aVar;
    }

    public static ExtractorProvider a() {
        com.baidu.cyberplayer.sdk.remote.a a2 = a.AbstractBinderC0110a.a(g.a().b());
        if (a2 != null) {
            return new d(a2);
        }
        return null;
    }

    private void a(Uri uri, Map<String, String> map) {
        if (this.f1388a == null) {
            return;
        }
        try {
            this.f1388a.a(new e(uri, map));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public Bundle getMediaMeta() {
        if (this.f1388a == null) {
            return null;
        }
        try {
            return this.f1388a.a();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void release() {
        CyberLog.i("RemoteExtractorProxy", "release");
        try {
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            this.f1388a = null;
        }
        if (this.f1388a == null) {
            return;
        }
        this.f1388a.b();
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri) {
        a(uri, null);
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        a(uri, map);
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(String str) {
        a(Uri.parse(str), null);
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setOption(int i, String str, long j) {
        if (this.f1388a == null) {
            return;
        }
        try {
            this.f1388a.a(i, str, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
