package com.baidu.o;

import android.content.Context;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.rtc.AudioSession;
import com.baidu.rtc.RtcConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String ejB;
    private com.baidu.o.c.a ejC;
    private AudioSession ejD;

    public a(Context context, RtcConfig rtcConfig, String str) {
        this.ejB = "";
        this.ejB = str;
        this.ejD = new AudioSession(context, rtcConfig, new RtcConfig.RtcHandler() { // from class: com.baidu.o.a.1
            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onStart(int i, int i2, String str2, String str3) {
                if (a.this.ejC != null) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (str3 == null) {
                        str3 = "";
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("state", PayHelper.STATUS_SUCC);
                        jSONObject.putOpt("stateMsg", "connected");
                        jSONObject.putOpt("url", str2);
                        jSONObject.putOpt("remoteIP", str3);
                        a.this.ejC.e(MissionEvent.MESSAGE_START, jSONObject);
                    } catch (JSONException e) {
                        if (a.DEBUG) {
                            Log.d("SwanAudiodRTCContext", Log.getStackTraceString(e));
                        }
                    }
                }
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onConnectSuccess(int i, int i2, String str2, String str3) {
                if (a.this.ejC != null) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (str3 == null) {
                        str3 = "";
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("state", PayHelper.STATUS_FAIL);
                        jSONObject.putOpt("stateMsg", "remote IP resolved");
                        jSONObject.putOpt("url", str2);
                        jSONObject.putOpt("remoteIP", str3);
                        a.this.ejC.e("onStateChange", jSONObject);
                    } catch (JSONException e) {
                        if (a.DEBUG) {
                            Log.d("SwanAudiodRTCContext", Log.getStackTraceString(e));
                        }
                    }
                }
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onConnectFailed(int i, int i2, String str2, int i3) {
                if (a.this.ejC != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("state", "2001");
                        jSONObject.putOpt("stateMsg", "connect failed");
                        jSONObject.putOpt("rtcErr", Integer.valueOf(i3));
                        a.this.ejC.e("onStateChange", jSONObject);
                    } catch (JSONException e) {
                        if (a.DEBUG) {
                            Log.d("SwanAudiodRTCContext", Log.getStackTraceString(e));
                        }
                    }
                }
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onRemoteUserOnLine(int i, int i2) {
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onMuteStatusChanged(boolean z) {
                if (a.this.ejC != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (z) {
                            jSONObject.putOpt("state", "4001");
                            jSONObject.putOpt("stateMsg", "change to mute");
                        } else {
                            jSONObject.putOpt("state", "4002");
                            jSONObject.putOpt("stateMsg", "change to unmute");
                        }
                        a.this.ejC.e("onStateChange", jSONObject);
                    } catch (JSONException e) {
                        if (a.DEBUG) {
                            Log.d("SwanAudiodRTCContext", Log.getStackTraceString(e));
                        }
                    }
                }
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onStop(int i, int i2) {
                if (a.this.ejC != null) {
                    a.this.ejC.pI(MissionEvent.MESSAGE_STOP);
                }
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public void onFailed(int i) {
            }

            @Override // com.baidu.rtc.RtcConfig.RtcHandler
            public boolean onLoadLibrary(String str2) {
                try {
                    System.loadLibrary(str2);
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            }
        });
    }

    public void a(com.baidu.o.c.a aVar) {
        if (DEBUG) {
            Log.d("SwanAudiodRTCContext", "===open audioRTC");
        }
        this.ejC = aVar;
    }

    public void start() {
        if (this.ejD != null) {
            this.ejD.start();
            if (DEBUG) {
                Log.d("SwanAudiodRTCContext", "===start audioRTC");
            }
        }
    }

    public void stop() {
        if (this.ejD != null) {
            this.ejD.stop();
            if (DEBUG) {
                Log.d("SwanAudiodRTCContext", "===stop audioRTC");
            }
        }
    }

    public void mute() {
        if (this.ejD != null) {
            this.ejD.mute();
            if (DEBUG) {
                Log.d("SwanAudiodRTCContext", "===mute audioRTC");
            }
        }
    }

    public void unMute() {
        if (this.ejD != null) {
            this.ejD.unMute();
            if (DEBUG) {
                Log.d("SwanAudiodRTCContext", "===unMute audioRTC");
            }
        }
    }

    public void e(String str, JSONObject jSONObject) {
        if (this.ejC != null) {
            this.ejC.e(str, jSONObject);
        }
    }
}
