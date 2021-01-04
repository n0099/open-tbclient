package com.baidu.swan.games.y.b;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.swan.apps.ao.ae;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.c;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.games.l.a;
import com.baidu.swan.games.y.b;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes9.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private String cYi;
    private b.a enZ;
    private String eoa;
    private c<g> eob = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.games.y.b.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: e */
        public String U(g gVar) {
            return com.baidu.swan.apps.core.pms.f.b.nO(a.this.cYi);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void T(g gVar) {
            super.T(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloading");
            }
            a.this.i(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(g gVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) gVar, aVar);
            if (a.DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadError: " + aVar.toString());
            }
            a.this.iC(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3);
            com.baidu.swan.apps.core.pms.c.aua().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.al.a().cV(12L).cW(aVar.errorNo).ux("分包下载失败").uz(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: k */
        public void R(g gVar) {
            super.R(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + gVar.size + ":" + gVar.currentSize);
            }
            a.this.t(gVar.currentSize, gVar.size);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(g gVar) {
            super.Q(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + gVar.toString());
            }
            a.this.h(gVar);
        }
    };
    private String mAppId;

    public a(String str, String str2, String str3, b.a aVar) {
        this.mAppId = str;
        this.eoa = str3;
        this.enZ = aVar;
        this.cYi = a.c.bS(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanGameSubPkgDownload", "onFetchError: " + aVar.toString());
        }
        iC(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3);
    }

    @Override // com.baidu.swan.pms.a.g
    public void arc() {
        super.arc();
        if (DEBUG) {
            Log.i("SwanGameSubPkgDownload", "onNoPackage");
        }
        iC(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> auf() {
        return this.eob;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        if (!ae.f(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            iC(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4);
            com.baidu.swan.apps.core.pms.c.aua().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.al.a().cV(12L).cW(2300L).ux("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.f.b.h(new File(gVar.filePath), new File(this.cYi, this.eoa))) {
            if (DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            auy();
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.bgb().c(gVar);
            com.baidu.swan.apps.core.pms.c.aua().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            iC(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5);
            com.baidu.swan.apps.core.pms.c.aua().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.al.a().cV(12L).cW(2320L).ux("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(g gVar) {
        com.baidu.swan.apps.core.pms.c.aua().a(gVar, new c.b() { // from class: com.baidu.swan.games.y.b.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.auy();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                a.this.iC(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iC(int i) {
        if (this.enZ != null) {
            this.enZ.hK(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auy() {
        if (this.enZ != null) {
            this.enZ.bcg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(long j, long j2) {
        if (this.enZ != null) {
            if (j2 <= 0 || j > j2) {
                iC(2114);
                return;
            }
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (DEBUG) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.enZ.f(floor, j, j2);
            }
        }
    }
}
