package com.baidu.o;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.rtc.RTCSession;
import com.baidu.rtc.RtcConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bTN;
    private String dNb;
    private RTCSession dNf;

    public b(Context context, RtcConfig rtcConfig, String str, String str2) {
        this.dNb = "";
        this.bTN = "";
        this.dNb = str;
        this.bTN = str2;
        this.dNf = new RTCSession(context, rtcConfig, new RtcConfig.RtcHandler() { // from class: com.baidu.o.b.1
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
                com.baidu.o.c.b.i(b.this.bTN, b.this.dNb, jSONObject);
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
                com.baidu.o.c.b.i(b.this.bTN, b.this.dNb, jSONObject);
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
                com.baidu.o.c.b.i(b.this.bTN, b.this.dNb, jSONObject);
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
                com.baidu.o.c.b.i(b.this.bTN, b.this.dNb, jSONObject);
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
                com.baidu.o.c.b.i(b.this.bTN, b.this.dNb, jSONObject);
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
                    com.baidu.o.c.b.i(b.this.bTN, b.this.dNb, jSONObject);
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

    public void bq(String str) {
        if (this.dNf != null) {
            this.dNf.start(str);
            if (DEBUG) {
                Log.d("SwanRTCContext", "===start RTC");
            }
        }
    }

    public void stop() {
        if (this.dNf != null) {
            this.dNf.stop();
            if (DEBUG) {
                Log.d("SwanRTCContext", "===stop RTC");
            }
        }
    }

    public void mute() {
        if (this.dNf != null) {
            this.dNf.mute();
            if (DEBUG) {
                Log.d("SwanRTCContext", "===mute RTC");
            }
        }
    }

    public void unMute() {
        if (this.dNf != null) {
            this.dNf.unMute();
            if (DEBUG) {
                Log.d("SwanRTCContext", "===unMute RTC");
            }
        }
    }

    public void switchCamera() {
        if (this.dNf != null) {
            this.dNf.switchCamera();
            if (DEBUG) {
                Log.d("SwanRTCContext", "===switchCamera RTC");
            }
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.dNf != null) {
            if (DEBUG) {
                Log.d("SwanRTCContext", "===updateRTCConfig RTC");
            }
            return this.dNf.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.dNf != null) {
            this.dNf.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.dNf != null) {
            return this.dNf.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.dNf != null) {
            return this.dNf.getPlayerView();
        }
        return null;
    }
}
