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
/* loaded from: classes6.dex */
public class d extends ExtractorProvider {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.cyberplayer.sdk.remote.a f1817a;

    public d(com.baidu.cyberplayer.sdk.remote.a aVar) {
        this.f1817a = aVar;
    }

    public static ExtractorProvider a() {
        com.baidu.cyberplayer.sdk.remote.a a2 = a.AbstractBinderC0103a.a(g.a().b());
        if (a2 != null) {
            return new d(a2);
        }
        return null;
    }

    private void a(Uri uri, Map<String, String> map) {
        if (this.f1817a == null) {
            return;
        }
        try {
            this.f1817a.a(new e(uri, map));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public Bundle getMediaMeta() {
        if (this.f1817a == null) {
            return null;
        }
        try {
            return this.f1817a.a();
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
            this.f1817a = null;
        }
        if (this.f1817a == null) {
            return;
        }
        this.f1817a.b();
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
        if (this.f1817a == null) {
            return;
        }
        try {
            this.f1817a.a(i, str, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
