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
/* loaded from: classes.dex */
public class d extends ExtractorProvider {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.cyberplayer.sdk.remote.a f4934a;

    public d(com.baidu.cyberplayer.sdk.remote.a aVar) {
        this.f4934a = aVar;
    }

    public static ExtractorProvider a() {
        com.baidu.cyberplayer.sdk.remote.a a2 = a.AbstractBinderC0073a.a(g.a().b());
        if (a2 != null) {
            return new d(a2);
        }
        return null;
    }

    private void a(Uri uri, Map<String, String> map) {
        com.baidu.cyberplayer.sdk.remote.a aVar = this.f4934a;
        if (aVar == null) {
            return;
        }
        try {
            aVar.a(new e(uri, map));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public Bundle getMediaMeta() {
        com.baidu.cyberplayer.sdk.remote.a aVar = this.f4934a;
        if (aVar == null) {
            return null;
        }
        try {
            return aVar.a();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void release() {
        CyberLog.i("RemoteExtractorProxy", "release");
        com.baidu.cyberplayer.sdk.remote.a aVar = this.f4934a;
        if (aVar == null) {
            return;
        }
        try {
            try {
                aVar.b();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } finally {
            this.f4934a = null;
        }
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
        com.baidu.cyberplayer.sdk.remote.a aVar = this.f4934a;
        if (aVar == null) {
            return;
        }
        try {
            aVar.a(i, str, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
