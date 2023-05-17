package com.baidu.searchbox.live.chainlog;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.ubc.UBCManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NpsLoadChainLog {
    public static final int ERR_CODE_UNUSED = Integer.MIN_VALUE;
    public static final String FROM = "yysdk";
    public static final String PAGE = "liveroom";
    public static final int RESULT_FAIL = 0;
    public static final int RESULT_SUCCESS = 1;
    public static final int RESULT_UNUSED = -1;
    public static final String TYPE = "toload";
    public static final String UBC_ID_4347 = "4347";
    public static final String YY_NPS_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public static NpsLoadChainLog sInstance;
    public AppInfoService appService;
    public String entry;
    public String hostName;
    public String hostVersion;
    public int isMix;
    public HandlerThread mHandlerThread;
    public String mSSid;
    public String mSid;
    public Handler mSubHandler;
    public JSONObject pathJsonObj;
    public String pathTemp;
    public PluginInvokeService pluginService;
    public String pluginVersion;
    public String sessionId;
    public String tplId;
    public UBCManager ubcManager;
    public YYPluginProgressInvokeService yyService;
    public String yysdkVer;

    /* loaded from: classes3.dex */
    public static class Holder {
        public static final NpsLoadChainLog INSTANCE = new NpsLoadChainLog();
    }

    public NpsLoadChainLog() {
        this.ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.pluginService = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
        this.yyService = (YYPluginProgressInvokeService) ServiceManager.getService(YYPluginProgressInvokeService.Companion.getSERVICE_REFERENCE());
        this.sessionId = "";
        this.pluginVersion = "";
        this.hostName = "";
        this.hostVersion = "";
        this.entry = "";
        this.yysdkVer = "";
        this.mSid = "";
        this.mSSid = "";
        this.tplId = "";
        this.isMix = 0;
        HandlerThread handlerThread = new HandlerThread("nps_load_chain");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mSubHandler = new Handler(this.mHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notLogPathNode(String str) {
        String str2 = this.pathTemp;
        if (str2 == null) {
            return false;
        }
        if (str2.contains(str)) {
            dLog(str + " 节点已经打过了");
        }
        return this.pathTemp.contains(str);
    }

    private void postTask(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == this.mSubHandler.getLooper()) {
            dLog("********************主线程********************");
            runnable.run();
        } else if (this.mSubHandler != null) {
            dLog("@@@@@@@@@@@@@@@@@@@@子线程@@@@@@@@@@@@@@@@@@@@");
            this.mSubHandler.post(runnable);
        }
    }

    public void dLog(String str) {
        if (isDebug()) {
            Log.e("David990099", str);
        }
    }

    public void endInstallEntrance(final boolean z) {
        updateEntrancePluginVer();
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.15
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (!NpsLoadChainLog.this.notLogPathNode("entranceEndInstall") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "entranceEndInstall");
                    try {
                        JSONObject jSONObject = NpsLoadChainLog.this.pathJsonObj;
                        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.this;
                        if (z) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        jSONObject.put("entranceEndInstall", npsLoadChainLog.genNodeJsonObj(i, Integer.MIN_VALUE));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                    if (!z) {
                        NpsLoadChainLog.this.reset();
                    }
                }
            }
        });
    }

    public void setEntry(final String str) {
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.3
            @Override // java.lang.Runnable
            public void run() {
                if (!NpsLoadChainLog.this.notLogPathNode("entry") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.this.entry = str;
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "entry");
                    try {
                        NpsLoadChainLog.this.pathJsonObj.put("entry", NpsLoadChainLog.this.genNodeJsonObj(-1, Integer.MIN_VALUE));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                }
            }
        });
    }

    public void setPluginVersion(final String str) {
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.4
            @Override // java.lang.Runnable
            public void run() {
                NpsLoadChainLog.this.pluginVersion = str;
            }
        });
    }

    public static /* synthetic */ String access$1084(NpsLoadChainLog npsLoadChainLog, Object obj) {
        String str = npsLoadChainLog.pathTemp + obj;
        npsLoadChainLog.pathTemp = str;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject genNodeJsonObj(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", System.currentTimeMillis());
            if (-1 != i) {
                jSONObject.put("status", i);
            }
            if (1 != i && Integer.MIN_VALUE != i2) {
                jSONObject.put("errorCode", i2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void endDownloadLiveNps(final long j, final long j2) {
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.6
            @Override // java.lang.Runnable
            public void run() {
                if (!NpsLoadChainLog.this.notLogPathNode("livenpsEndDowlonad") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "livenpsEndDowlonad");
                    try {
                        NpsLoadChainLog.this.pathJsonObj.put("livenpsEndDowlonad", NpsLoadChainLog.this.genNodeJsonObj(1, Integer.MIN_VALUE, j, j2));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                }
            }
        });
    }

    public void endInitYY(final boolean z, final String str) {
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.22
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (!NpsLoadChainLog.this.notLogPathNode("initEnd") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "initEnd");
                    try {
                        JSONObject jSONObject = NpsLoadChainLog.this.pathJsonObj;
                        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.this;
                        if (z) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        jSONObject.put("initEnd", npsLoadChainLog.genNodeJsonObj(i, Integer.MIN_VALUE, str));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                    if (!z) {
                        NpsLoadChainLog.this.reset();
                    }
                }
            }
        });
    }

    public void endInstallLiveNps(final boolean z, final int i) {
        updateEntrancePluginVer();
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.8
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                if (!NpsLoadChainLog.this.notLogPathNode("endInstallLiveNps") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "endInstallLiveNps");
                    try {
                        JSONObject jSONObject = NpsLoadChainLog.this.pathJsonObj;
                        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.this;
                        if (z) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        jSONObject.put("livenpsEndInstall", npsLoadChainLog.genNodeJsonObj(i2, i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                    if (!z) {
                        NpsLoadChainLog.this.reset();
                    }
                }
            }
        });
    }

    public void endLoadClazzLiveNps(final boolean z, final int i) {
        updateEntrancePluginVer();
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.11
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                if (!NpsLoadChainLog.this.notLogPathNode("livenpsEndLoad") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "livenpsEndLoad");
                    try {
                        JSONObject jSONObject = NpsLoadChainLog.this.pathJsonObj;
                        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.this;
                        if (z) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        jSONObject.put("livenpsEndLoad", npsLoadChainLog.genNodeJsonObj(i2, i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                    if (!z) {
                        NpsLoadChainLog.this.reset();
                    }
                }
            }
        });
    }

    public void endMergeDexEntrance(final boolean z, final int i) {
        updateEntrancePluginVer();
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.17
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                if (!NpsLoadChainLog.this.notLogPathNode("entranceEndLoad") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "entranceEndLoad");
                    try {
                        JSONObject jSONObject = NpsLoadChainLog.this.pathJsonObj;
                        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.this;
                        if (z) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        jSONObject.put("entranceEndLoad", npsLoadChainLog.genNodeJsonObj(i2, i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                    if (!z) {
                        NpsLoadChainLog.this.reset();
                    }
                }
            }
        });
    }

    public void endPreloadClazzLiveNps(final boolean z, final int i) {
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.13
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                if (!NpsLoadChainLog.this.notLogPathNode("livenpsEndPreLoad") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "livenpsEndPreLoad");
                    try {
                        JSONObject jSONObject = NpsLoadChainLog.this.pathJsonObj;
                        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.this;
                        if (z) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        jSONObject.put("livenpsEndPreLoad", npsLoadChainLog.genNodeJsonObj(i2, i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                    if (!z) {
                        NpsLoadChainLog.this.reset();
                    }
                }
            }
        });
    }

    public void yyCompletionEvent(final String str, final JSONObject jSONObject) {
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.20
            @Override // java.lang.Runnable
            public void run() {
                if (!NpsLoadChainLog.this.notLogPathNode(str) && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, str);
                    try {
                        NpsLoadChainLog.this.pathJsonObj.put(str, jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject genNodeJsonObj(int i, int i2, String str) {
        JSONObject genNodeJsonObj = genNodeJsonObj(i, i2);
        try {
            genNodeJsonObj.put("errorMsg", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return genNodeJsonObj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject genNodeJsonObjWithTime(int i, int i2, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", j);
            if (-1 != i) {
                jSONObject.put("status", i);
            }
            if (1 != i && Integer.MIN_VALUE != i2) {
                jSONObject.put("errorCode", i2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject genNodeJsonObj(int i, int i2, long j, long j2) {
        JSONObject genNodeJsonObj = genNodeJsonObj(i, i2);
        try {
            genNodeJsonObj.put("downloadSize", j);
            genNodeJsonObj.put(CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE, j2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return genNodeJsonObj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject genNodeJsonObjWithTime(int i, int i2, String str, long j) {
        JSONObject genNodeJsonObjWithTime = genNodeJsonObjWithTime(i, i2, j);
        try {
            genNodeJsonObjWithTime.put("errorMsg", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return genNodeJsonObjWithTime;
    }

    public void yyMinilibUbc(final String str, final long j, @Nullable final Boolean bool, @Nullable final String str2) {
        if (bool == null) {
            postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.18
                @Override // java.lang.Runnable
                public void run() {
                    if (!NpsLoadChainLog.this.notLogPathNode(str) && NpsLoadChainLog.this.pathJsonObj != null) {
                        NpsLoadChainLog.access$1084(NpsLoadChainLog.this, str);
                        try {
                            NpsLoadChainLog.this.pathJsonObj.put(str, NpsLoadChainLog.this.genNodeJsonObjWithTime(-1, Integer.MIN_VALUE, j));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        NpsLoadChainLog.this.showPathAndDuration();
                        NpsLoadChainLog.this.ubcLog();
                    }
                }
            });
        } else {
            postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.19
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (!NpsLoadChainLog.this.notLogPathNode(str) && NpsLoadChainLog.this.pathJsonObj != null) {
                        NpsLoadChainLog.access$1084(NpsLoadChainLog.this, str);
                        try {
                            JSONObject jSONObject = NpsLoadChainLog.this.pathJsonObj;
                            String str3 = str;
                            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.this;
                            if (bool.booleanValue()) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            jSONObject.put(str3, npsLoadChainLog.genNodeJsonObjWithTime(i, Integer.MIN_VALUE, str2, j));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        NpsLoadChainLog.this.showPathAndDuration();
                        NpsLoadChainLog.this.ubcLog();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void genSessionId() {
        this.sessionId = this.appService.getCuid() + "-" + System.currentTimeMillis();
    }

    public static NpsLoadChainLog getInstance() {
        if (sInstance == null) {
            sInstance = Holder.INSTANCE;
        }
        return sInstance;
    }

    private boolean isDebug() {
        AppInfoService appInfoService = this.appService;
        if (appInfoService != null) {
            return appInfoService.isDebug();
        }
        return false;
    }

    private void updateEntrancePluginVer() {
        this.pluginVersion = String.valueOf(this.pluginService.getPluginVersionCode("com.baidu.searchbox.yylive.entrance"));
    }

    public String getEntry() {
        return this.entry;
    }

    public HandlerThread getHandlerThread() {
        return this.mHandlerThread;
    }

    public String getHostName() {
        return this.hostName;
    }

    public String getHostVersion() {
        return this.hostVersion;
    }

    public String getPath() {
        try {
            if (this.pathJsonObj == null) {
                return "";
            }
            return this.pathJsonObj.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getPluginVersion() {
        return this.pluginVersion;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void initAndStart() {
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.1
            @Override // java.lang.Runnable
            public void run() {
                NpsLoadChainLog.this.reset();
                NpsLoadChainLog.this.genSessionId();
                NpsLoadChainLog.this.pathJsonObj = new JSONObject();
                NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.this;
                npsLoadChainLog.hostName = npsLoadChainLog.appService.getLiveAppId();
                NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.this;
                npsLoadChainLog2.hostVersion = npsLoadChainLog2.appService.getVersionName();
            }
        });
    }

    public void reset() {
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.2
            @Override // java.lang.Runnable
            public void run() {
                NpsLoadChainLog.this.sessionId = "";
                NpsLoadChainLog.this.pluginVersion = "";
                NpsLoadChainLog.this.entry = "";
                NpsLoadChainLog.this.hostName = "";
                NpsLoadChainLog.this.hostVersion = "";
                NpsLoadChainLog.this.pathJsonObj = null;
                NpsLoadChainLog.this.pathTemp = "";
            }
        });
    }

    public void showPathAndDuration() {
        if (isDebug() && this.pathJsonObj != null) {
            Log.e("David990099", "path = " + getPath());
        }
    }

    public void startDownloadLiveNps() {
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.5
            @Override // java.lang.Runnable
            public void run() {
                if (!NpsLoadChainLog.this.notLogPathNode("livenpsStartDownload") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "livenpsStartDownload");
                    try {
                        NpsLoadChainLog.this.pathJsonObj.put("livenpsStartDownload", NpsLoadChainLog.this.genNodeJsonObj(-1, Integer.MIN_VALUE));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                }
            }
        });
    }

    public void startInitYY() {
        updateEntrancePluginVer();
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.21
            @Override // java.lang.Runnable
            public void run() {
                if (!NpsLoadChainLog.this.notLogPathNode("initStart") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "initStart");
                    try {
                        NpsLoadChainLog.this.pathJsonObj.put("initStart", NpsLoadChainLog.this.genNodeJsonObj(-1, Integer.MIN_VALUE));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                }
            }
        });
    }

    public void startInstallEntrance() {
        updateEntrancePluginVer();
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.14
            @Override // java.lang.Runnable
            public void run() {
                if (!NpsLoadChainLog.this.notLogPathNode("entranceStartInstall") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "entranceStartInstall");
                    try {
                        NpsLoadChainLog.this.pathJsonObj.put("entranceStartInstall", NpsLoadChainLog.this.genNodeJsonObj(-1, Integer.MIN_VALUE));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                }
            }
        });
    }

    public void startInstallLiveNps() {
        updateEntrancePluginVer();
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.7
            @Override // java.lang.Runnable
            public void run() {
                if (!NpsLoadChainLog.this.notLogPathNode("livenpsStartInstall") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "livenpsStartInstall");
                    try {
                        NpsLoadChainLog.this.pathJsonObj.put("livenpsStartInstall", NpsLoadChainLog.this.genNodeJsonObj(-1, Integer.MIN_VALUE));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                }
            }
        });
    }

    public void startLoadClazzLiveNps() {
        updateEntrancePluginVer();
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.9
            @Override // java.lang.Runnable
            public void run() {
                if (!NpsLoadChainLog.this.notLogPathNode("livenpsStartLoad") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "livenpsStartLoad");
                    try {
                        NpsLoadChainLog.this.pathJsonObj.put("livenpsStartLoad", NpsLoadChainLog.this.genNodeJsonObj(-1, Integer.MIN_VALUE));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                }
            }
        });
    }

    public void startLoadClazzLiveNpsPreload() {
        updateEntrancePluginVer();
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.10
            @Override // java.lang.Runnable
            public void run() {
                if (!NpsLoadChainLog.this.notLogPathNode("livenpsStartPreLoad") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "livenpsStartPreLoad");
                    try {
                        NpsLoadChainLog.this.pathJsonObj.put("livenpsStartPreLoad", NpsLoadChainLog.this.genNodeJsonObj(-1, Integer.MIN_VALUE));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                }
            }
        });
    }

    public void startMergeDexEntrance() {
        updateEntrancePluginVer();
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.16
            @Override // java.lang.Runnable
            public void run() {
                if (!NpsLoadChainLog.this.notLogPathNode("entranceStartLoad") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "entranceStartLoad");
                    try {
                        NpsLoadChainLog.this.pathJsonObj.put("entranceStartLoad", NpsLoadChainLog.this.genNodeJsonObj(-1, Integer.MIN_VALUE));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                }
            }
        });
    }

    public void startPreloadClazzLiveNps() {
        postTask(new Runnable() { // from class: com.baidu.searchbox.live.chainlog.NpsLoadChainLog.12
            @Override // java.lang.Runnable
            public void run() {
                if (!NpsLoadChainLog.this.notLogPathNode("livenpsStartPreLoad") && NpsLoadChainLog.this.pathJsonObj != null) {
                    NpsLoadChainLog.access$1084(NpsLoadChainLog.this, "livenpsStartPreLoad");
                    try {
                        NpsLoadChainLog.this.pathJsonObj.put("livenpsStartPreLoad", NpsLoadChainLog.this.genNodeJsonObj(-1, Integer.MIN_VALUE));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NpsLoadChainLog.this.showPathAndDuration();
                    NpsLoadChainLog.this.ubcLog();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ubcLog() {
        JSONObject jSONObject = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject.put("from", FROM);
            jSONObject.put("type", TYPE);
            jSONObject.put("page", PAGE);
            jSONObject.put("source", this.hostName);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("path", getPath());
            jSONObject2.put("entry", this.entry);
            jSONObject2.put("yysdk_ver", this.yysdkVer);
            jSONObject2.put("plugin_ver", this.pluginVersion);
            jSONObject2.put("is_end", 0);
            jSONObject2.put("session_id", this.sessionId);
            jSONObject2.put("hdid", "");
            jSONObject2.put("app_ver", this.hostVersion);
            jSONObject2.put("sid", this.mSid);
            jSONObject2.put(YyLiveRoomConfig.KEY_SSID, this.mSSid);
            jSONObject2.put("tpl_id", this.tplId);
            jSONObject2.put("is_Mix", this.isMix);
            jSONObject.put("ext", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dLog(jSONObject.toString());
        dLog("-----------------------\n");
        this.ubcManager.onEvent(UBC_ID_4347, jSONObject.toString());
        this.yyService.reportUbcReport(UBC_ID_4347, jSONObject);
        dLog("---report cost time = " + (System.currentTimeMillis() - currentTimeMillis) + "---\n");
    }

    public void updateParamsFromYY(Map<String, String> map) {
        if (map == null) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    String key = entry.getKey();
                    char c = 65535;
                    switch (key.hashCode()) {
                        case -1578585346:
                            if (key.equals("yysdk_ver")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1179794009:
                            if (key.equals("is_Mix")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -867239350:
                            if (key.equals("tpl_id")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 113870:
                            if (key.equals("sid")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 3539835:
                            if (key.equals(YyLiveRoomConfig.KEY_SSID)) {
                                c = 3;
                                break;
                            }
                            break;
                        case 96667762:
                            if (key.equals("entry")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    if (c != 0) {
                        if (c != 1) {
                            if (c != 2) {
                                if (c != 3) {
                                    if (c != 4) {
                                        if (c == 5) {
                                            this.isMix = Integer.parseInt(entry.getValue());
                                        }
                                    } else {
                                        this.tplId = entry.getValue();
                                    }
                                } else {
                                    this.mSSid = entry.getValue();
                                }
                            } else {
                                this.mSid = entry.getValue();
                            }
                        } else {
                            this.yysdkVer = entry.getValue();
                        }
                    } else {
                        this.entry = entry.getValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
