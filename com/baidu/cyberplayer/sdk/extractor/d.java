package com.baidu.cyberplayer.sdk.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.remote.b;
import com.baidu.cyberplayer.sdk.remote.f;
import com.baidu.cyberplayer.sdk.remote.h;
import java.io.FileDescriptor;
import java.util.Map;
/* loaded from: classes3.dex */
public class d extends ExtractorProvider {
    public com.baidu.cyberplayer.sdk.remote.b a;

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
    }

    public d(com.baidu.cyberplayer.sdk.remote.b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(String str) {
        a(Uri.parse(str), null);
    }

    public static ExtractorProvider a() {
        com.baidu.cyberplayer.sdk.remote.b a = b.a.a(h.a().c());
        if (a != null) {
            return new d(a);
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public Bundle getMediaMeta() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return null;
        }
        try {
            return bVar.a();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void release() {
        CyberLog.i("RemoteExtractorProxy", "release");
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            try {
                bVar.b();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } finally {
            this.a = null;
        }
    }

    private void a(Uri uri, Map<String, String> map) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(new f(uri, map));
        } catch (RemoteException e) {
            e.printStackTrace();
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
    public void setOption(int i, String str, long j) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(i, str, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
