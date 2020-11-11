package com.baidu.swan.games.y.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.swan.apps.ap.ae;
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
/* loaded from: classes10.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private String cOc;
    private b.a dZH;
    private String dZI;
    private c<g> dZJ = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.games.y.b.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: e */
        public String U(g gVar) {
            return com.baidu.swan.apps.core.pms.f.b.nu(a.this.cOc);
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
            a.this.in(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3);
            com.baidu.swan.apps.core.pms.c.aqj().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.am.a().cv(12L).cw(aVar.errorNo).tY("分包下载失败").ua(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: k */
        public void R(g gVar) {
            super.R(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + gVar.size + ":" + gVar.currentSize);
            }
            a.this.q(gVar.currentSize, gVar.size);
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
        this.dZI = str3;
        this.dZH = aVar;
        this.cOc = a.c.bN(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanGameSubPkgDownload", "onFetchError: " + aVar.toString());
        }
        in(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3);
    }

    @Override // com.baidu.swan.pms.a.g
    public void anq() {
        super.anq();
        if (DEBUG) {
            Log.i("SwanGameSubPkgDownload", "onNoPackage");
        }
        in(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> aqo() {
        return this.dZJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        if (!ae.e(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            in(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4);
            com.baidu.swan.apps.core.pms.c.aqj().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.am.a().cv(12L).cw(2300L).tY("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.f.b.h(new File(gVar.filePath), new File(this.cOc, this.dZI))) {
            if (DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            aqH();
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.bbh().c(gVar);
            com.baidu.swan.apps.core.pms.c.aqj().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            in(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5);
            com.baidu.swan.apps.core.pms.c.aqj().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.am.a().cv(12L).cw(2320L).tY("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(g gVar) {
        com.baidu.swan.apps.core.pms.c.aqj().a(gVar, new c.b() { // from class: com.baidu.swan.games.y.b.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.aqH();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                a.this.in(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(int i) {
        if (this.dZH != null) {
            this.dZH.hw(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqH() {
        if (this.dZH != null) {
            this.dZH.aXp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j, long j2) {
        if (this.dZH != null) {
            if (j2 <= 0 || j > j2) {
                in(2114);
                return;
            }
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (DEBUG) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.dZH.e(floor, j, j2);
            }
        }
    }
}
