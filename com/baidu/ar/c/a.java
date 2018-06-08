package com.baidu.ar.c;

import com.baidu.ar.DuMixCallback;
import com.baidu.ar.base.RequestController;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.msghandler.DownloadMsgHandler;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.util.UiThreadUtil;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a implements DuMixCallback {
    private DuMixCallback a;
    private b b;
    private d c;
    private e d;
    private c e;

    public void a(DuMixCallback duMixCallback) {
        this.a = duMixCallback;
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    public void a(c cVar) {
        this.e = cVar;
    }

    public void a(d dVar) {
        this.c = dVar;
    }

    public void a(e eVar) {
        this.d = eVar;
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onCaseChange(boolean z) {
        if (this.a != null) {
            this.a.onCaseChange(z);
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onCaseCreated(ARResource aRResource) {
        if (this.c != null) {
            this.c.a(aRResource);
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onLuaMessage(HashMap<String, Object> hashMap) {
        if (this.a != null) {
            this.a.onLuaMessage(hashMap);
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onPause(boolean z) {
        if (this.a != null) {
            this.a.onPause(z);
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onRelease(boolean z) {
        this.c = null;
        this.b = null;
        this.d = null;
        this.e = null;
        if (this.a != null) {
            this.a.onRelease(z);
            this.a = null;
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onReset(boolean z) {
        if (this.a != null) {
            this.a.onReset(z);
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onResume(boolean z) {
        if (this.a != null) {
            this.a.onResume(z);
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onSetup(boolean z) {
        if (this.a != null) {
            this.a.onSetup(z);
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onStateChange(int i, final Object obj) {
        if (this.a != null) {
            this.a.onStateChange(i, obj);
        }
        if (i == 2299) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.a((RequestController) obj);
                    }
                }
            });
        } else if (i == 2300) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.FIRST_LOAD_START_QUERY);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.12
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.a();
                    }
                }
            });
        } else if (i == 1801) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.16
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.b((String) obj);
                    }
                }
            });
        } else if (i == 1802) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.17
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.a((String) obj);
                    }
                }
            });
        } else if (i == 2301) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.18
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.b((RequestController) obj);
                    }
                }
            });
        } else if (i == 30001) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.19
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.a((ARResource) obj);
                    }
                }
            });
        } else if (i == 30002) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.20
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.c((RequestController) obj);
                    }
                }
            });
        } else if (i == 2600) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.21
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.a((DownloadMsgHandler) obj);
                    }
                }
            });
        } else if (i == 2302) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.22
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.b();
                    }
                }
            });
        } else if (i == 2303) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.d((RequestController) obj);
                    }
                }
            });
        } else if (i == 23031) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.e((RequestController) obj);
                    }
                }
            });
        } else if (i == 2304) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.c();
                    }
                }
            });
        } else if (i == 2305) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.f((RequestController) obj);
                    }
                }
            });
        } else if (i == 2504) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.d != null) {
                        a.this.d.g((RequestController) obj);
                    }
                }
            });
        } else if (i == 2200) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.b != null) {
                        a.this.b.a((ARResource) obj);
                    }
                }
            });
        } else if (i == 2201) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.b != null) {
                        a.this.b.b((ARResource) obj);
                    }
                }
            });
        } else if (i == 100) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.a();
                    }
                }
            });
        } else if (i == 101) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.b();
                    }
                }
            });
        } else if (i == 102) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.11
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.c();
                    }
                }
            });
        } else if (i == 103) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.13
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.d();
                    }
                }
            });
        } else if (i == 110) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.14
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.e();
                    }
                }
            });
        } else if (i == 111) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.c.a.15
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.f();
                    }
                }
            });
        } else if (i == 9000) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.FIRST_LOAD_START_FILE_MANAGE);
        } else if (i == 9001) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.FIRST_LOAD_FILE_MANAGE_SUCCESS);
        } else if (i == 9002) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.FIRST_LOAD_FILE_MANAGE_FAILURE);
        } else if (i == 9003) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.START_DOWNLOAD_3D_RES);
        } else if (i == 9004) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.DOWNLOAD_3D_RES_SUCCESS);
        } else if (i == 9005) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.DOWNLOAD_3D_RES_FAILURE);
        } else if (i == 9006) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.FIRST_LOAD_QUERY_FAILURE);
        } else if (i == 9007) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.FIRST_LOAD_QUERY_SUCCESS);
        } else if (i == 9008) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.SOLOAD_START);
        } else if (i == 9009) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.SOLOAD_LOAD_FAILURE);
        } else if (i == 9010) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.SOLOAD_LOAD_SUCCESS);
        } else if (i == 9011) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.SOLOAD_DOWNLOAD_SUCCESS);
        } else if (i == 9012) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.SOLOAD_DOWNLOAD_FAILURE);
        } else if (i == 9013) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.SOLOAD_START_DOWNLOAD);
        }
    }

    @Override // com.baidu.ar.DuMixCallback
    public void onStateError(int i, String str) {
        if (this.a != null) {
            this.a.onStateError(i, str);
        }
    }
}
