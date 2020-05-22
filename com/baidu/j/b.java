package com.baidu.j;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.rtc.RTCSession;
import com.baidu.rtc.RtcConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bIH;
    private String dtj;
    private RTCSession dtn;

    public b(Context context, RtcConfig rtcConfig, String str, String str2) {
        this.dtj = "";
        this.bIH = "";
        this.dtj = str;
        this.bIH = str2;
        this.dtn = new RTCSession(context, rtcConfig, new RtcConfig.RtcHandler() { // from class: com.baidu.j.b.1
            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onStart(int i, int i2, String str3, String str4) {
                if (str3 == null) {
                    str3 = "";
                }
                if (str4 == null) {
                    str4 = "";
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("state", PayHelper.STATUS_SUCC);
                    jSONObject.putOpt("stateMsg", "connected");
                    jSONObject.putOpt("url", str3);
                    jSONObject.putOpt("remoteIP", str4);
                } catch (JSONException e) {
                    if (b.DEBUG) {
                        Log.d("SwanRTCContext", Log.getStackTraceString(e));
                    }
                }
                com.baidu.j.c.b.f(b.this.bIH, b.this.dtj, jSONObject);
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onConnectSuccess(int i, int i2, String str3, String str4) {
                if (str3 == null) {
                    str3 = "";
                }
                if (str4 == null) {
                    str4 = "";
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("state", PayHelper.STATUS_FAIL);
                    jSONObject.putOpt("stateMsg", "remote IP resolved");
                    jSONObject.putOpt("url", str3);
                    jSONObject.putOpt("remoteIP", str4);
                } catch (JSONException e) {
                    if (b.DEBUG) {
                        Log.d("SwanRTCContext", Log.getStackTraceString(e));
                    }
                }
                com.baidu.j.c.b.f(b.this.bIH, b.this.dtj, jSONObject);
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onConnectFailed(int i, int i2, String str3, int i3) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("state", "2001");
                    jSONObject.putOpt("stateMsg", "connect failed");
                    jSONObject.putOpt("rtcErr", Integer.valueOf(i3));
                } catch (JSONException e) {
                    if (b.DEBUG) {
                        Log.d("SwanRTCContext", Log.getStackTraceString(e));
                    }
                }
                com.baidu.j.c.b.f(b.this.bIH, b.this.dtj, jSONObject);
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onRemoteUserOnLine(int i, int i2) {
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onMuteStatusChanged(boolean z) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (z) {
                        jSONObject.putOpt("state", "4001");
                        jSONObject.putOpt("stateMsg", "change to mute");
                    } else {
                        jSONObject.putOpt("state", "4002");
                        jSONObject.putOpt("stateMsg", "change to unmute");
                    }
                } catch (JSONException e) {
                    if (b.DEBUG) {
                        Log.d("SwanRTCContext", Log.getStackTraceString(e));
                    }
                }
                com.baidu.j.c.b.f(b.this.bIH, b.this.dtj, jSONObject);
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onStop(int i, int i2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("state", "3001");
                    jSONObject.putOpt("stateMsg", "stopped");
                } catch (JSONException e) {
                    if (b.DEBUG) {
                        Log.d("SwanRTCContext", Log.getStackTraceString(e));
                    }
                }
                com.baidu.j.c.b.f(b.this.bIH, b.this.dtj, jSONObject);
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onFailed(int i) {
                if (i == RtcConfig.RTC_FAILED_INVALID_PUSHURL) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("state", "2102");
                        jSONObject.putOpt("stateMsg", "no push url");
                    } catch (JSONException e) {
                        if (b.DEBUG) {
                            Log.d("SwanRTCContext", Log.getStackTraceString(e));
                        }
                    }
                    com.baidu.j.c.b.f(b.this.bIH, b.this.dtj, jSONObject);
                }
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public boolean onLoadLibrary(String str3) {
                try {
                    System.loadLibrary(str3);
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            }
        });
    }

    public void bk(String str) {
        if (this.dtn != null) {
            this.dtn.start(str);
            if (DEBUG) {
                Log.d("SwanRTCContext", "===start RTC");
            }
        }
    }

    public void stop() {
        if (this.dtn != null) {
            this.dtn.stop();
            if (DEBUG) {
                Log.d("SwanRTCContext", "===stop RTC");
            }
        }
    }

    public void mute() {
        if (this.dtn != null) {
            this.dtn.mute();
            if (DEBUG) {
                Log.d("SwanRTCContext", "===mute RTC");
            }
        }
    }

    public void unMute() {
        if (this.dtn != null) {
            this.dtn.unMute();
            if (DEBUG) {
                Log.d("SwanRTCContext", "===unMute RTC");
            }
        }
    }

    public void switchCamera() {
        if (this.dtn != null) {
            this.dtn.switchCamera();
            if (DEBUG) {
                Log.d("SwanRTCContext", "===switchCamera RTC");
            }
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.dtn != null) {
            if (DEBUG) {
                Log.d("SwanRTCContext", "===updateRTCConfig RTC");
            }
            return this.dtn.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.dtn != null) {
            this.dtn.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.dtn != null) {
            return this.dtn.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.dtn != null) {
            return this.dtn.getPlayerView();
        }
        return null;
    }
}
