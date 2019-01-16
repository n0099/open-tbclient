package com.baidu.browser.sailor.a;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.browser.sailor.a.b;
import com.baidu.browser.sailor.a.n;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c implements n.a, com.baidu.browser.sailor.feature.a.e, com.baidu.browser.sailor.feature.b {
    private MediaRecorder Wj;
    private File Wk;
    private File Wl;
    private MediaPlayer Wm;
    private String Wn;
    private final SparseArray<n> Wo;
    private boolean Wp;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private WebView mWebView;

    public static boolean a(String str, n nVar, String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (String str2 : strArr) {
                String optString = jSONObject.optString(str2);
                if (!TextUtils.isEmpty(optString)) {
                    nVar.qP().put(str2, optString);
                }
            }
            return true;
        } catch (JSONException e) {
            Log.e("BdLightappKernelClient", "json parse error");
            return false;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, CHECK_CAST]}, finally: {[IGET, INVOKE, CHECK_CAST, INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public void cy(String str) {
        n nVar;
        qO();
        MediaPlayer mediaPlayer = this.Wm;
        if (this.mAudioManager.getStreamVolume(2) != 0) {
            mediaPlayer.setAudioStreamType(2);
            mediaPlayer.setLooping(false);
        }
        try {
            try {
                try {
                    try {
                        try {
                            mediaPlayer.reset();
                            if (!new File(str).exists()) {
                                str = com.baidu.browser.sailor.util.c.a(qL(), str);
                                if (!new File(str).exists() && (nVar = this.Wo.get(4)) != null) {
                                    nVar.bD(101);
                                    this.Wo.remove(4);
                                }
                            }
                            mediaPlayer.setDataSource(str);
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                            n nVar2 = this.Wo.get(4);
                            if (nVar2 != null) {
                                nVar2.bD(1);
                                this.Wo.remove(4);
                            }
                        }
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                        n nVar3 = this.Wo.get(4);
                        if (nVar3 != null) {
                            nVar3.bD(1);
                            this.Wo.remove(4);
                        }
                    }
                } catch (IllegalStateException e3) {
                    e3.printStackTrace();
                    n nVar4 = this.Wo.get(4);
                    if (nVar4 != null) {
                        nVar4.bD(1);
                        this.Wo.remove(4);
                    }
                }
            } catch (SecurityException e4) {
                e4.printStackTrace();
                n nVar5 = this.Wo.get(4);
                if (nVar5 != null) {
                    nVar5.bD(1);
                    this.Wo.remove(4);
                }
            }
        } catch (Throwable th) {
            n nVar6 = this.Wo.get(4);
            if (nVar6 != null) {
                nVar6.bD(1);
                this.Wo.remove(4);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qN() {
        if (this.Wj != null) {
            this.Wj.stop();
            this.Wj.reset();
            this.Wj.release();
        }
        if (this.Wk != null) {
            this.Wk.delete();
        }
        if (this.Wl != null) {
            this.Wl.delete();
        }
        this.Wk = null;
        this.Wl = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qO() {
        if (this.mAudioManager == null || this.Wm == null) {
            this.mAudioManager = (AudioManager) com.baidu.browser.sailor.b.a.qS().getAppContext().getSystemService("audio");
            this.Wm = new MediaPlayer();
            this.Wm.setOnCompletionListener(new m(this));
            this.Wm.setOnErrorListener(new d(this));
        }
    }

    public void a(WebView webView) {
        this.mWebView = webView;
    }

    public abstract void addseniorWz(String str, String str2, String str3);

    public void audioSeekTo(String str, String str2, String str3) {
        n nVar = new n(str2, str3);
        nVar.a(this);
        try {
            com.baidu.browser.sailor.util.c.a(new j(this, Integer.parseInt(str), nVar));
        } catch (NumberFormatException e) {
            nVar.cB(e.getMessage());
        }
    }

    public void audioSpeedFF(String str, String str2) {
        n nVar = new n(str, str2);
        nVar.a(this);
        com.baidu.browser.sailor.util.c.a(new l(this, nVar));
    }

    protected void b(Intent intent, int i) {
        com.baidu.browser.sailor.util.c.a(new e(this, intent, i));
    }

    public abstract void bdLogin(String str, String str2, String str3);

    public abstract void callShare(String str, String str2, String str3);

    public abstract void closeWindow();

    public void cloudaLaunchCamera(String str, String str2, String str3) {
        Intent intent;
        n nVar = new n(str2, str3);
        nVar.a(this);
        if (!a(str, nVar, b.a.Wi)) {
            nVar.bD(2);
            return;
        }
        if (!(com.baidu.browser.sailor.util.c.a() && com.baidu.browser.sailor.util.c.b())) {
            nVar.bD(101);
            return;
        }
        String str4 = nVar.qP().get("mediaType");
        this.Wn = null;
        if ("lightapp.device.MEDIA_TYPE.IMAGE".equals(str4)) {
            if (Build.VERSION.SDK_INT >= 24) {
                File a = com.baidu.browser.sailor.feature.a.d.a(str4);
                Uri a2 = com.baidu.browser.sailor.feature.a.d.a(a);
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", a2);
                this.Wn = a.getPath();
            } else {
                File a3 = com.baidu.browser.sailor.feature.a.d.a(str4);
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", Uri.fromFile(a3));
                this.Wn = a3.getPath();
            }
        } else if ("lightapp.device.MEDIA_TYPE.VIDEO".equals(str4)) {
            File a4 = com.baidu.browser.sailor.feature.a.d.a(str4);
            intent = new Intent("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("android.intent.extra.videoQuality", 1);
            this.Wn = a4.getPath();
        } else {
            nVar.bD(2);
            Log.e("BdLightappKernelClient", "error camera type: " + str4);
            intent = null;
        }
        if (intent != null) {
            this.Wo.put(7, nVar);
            intent.putExtra("jsaction_key", 7);
            b(intent, ArBridge.MessageType.MSG_TYPE_LUA_CALL_SDK_FUC);
        }
    }

    public void cloudaLaunchGallery(String str, String str2, String str3) {
        n nVar = new n(str2, str3);
        nVar.a(this);
        if (!a(str, nVar, b.a.Wi)) {
            nVar.bD(2);
            return;
        }
        if (!(com.baidu.browser.sailor.util.c.a() && com.baidu.browser.sailor.util.c.b())) {
            nVar.bD(101);
            return;
        }
        String str4 = nVar.qP().get("mediaType");
        this.Wo.put(8, nVar);
        Intent intent = new Intent("android.intent.action.PICK");
        if ("lightapp.device.MEDIA_TYPE.IMAGE".equals(str4)) {
            intent.setType("image/*");
        } else if (!"lightapp.device.MEDIA_TYPE.VIDEO".equals(str4)) {
            Log.e("BdLightappKernelClient", "error media type: " + str4);
            nVar.bD(2);
            return;
        } else {
            intent.setType("video/*");
        }
        intent.putExtra("jsaction_key", 8);
        b(intent, 3003);
    }

    public abstract void consult(String str, String str2, String str3);

    public abstract void doPolymerPay(String str, String str2, String str3);

    public abstract void doThirdPay(String str, String str2, String str3);

    public abstract void dopay(String str, String str2, String str3, boolean z);

    public abstract void followSite(String str, String str2);

    public abstract void followZhida(String str, String str2, String str3);

    public void getBattery(String str, String str2) {
        com.baidu.browser.sailor.b.b.a.e(str, str2, this);
    }

    public abstract void getCurrentPosition(String str, String str2);

    public void getDeviceInfo(String str, String str2) {
        com.baidu.browser.sailor.b.b.a.a(str, str2, this);
    }

    public String getGlobalizationInfo() {
        return com.baidu.browser.sailor.b.b.a.a();
    }

    public void getNetworkType(String str, String str2) {
        com.baidu.browser.sailor.b.b.a.b(str, str2, this);
    }

    public abstract void getPushToken(String str, String str2);

    public abstract void getWebKitPluginInfo(String str, String str2);

    public abstract void initpay(String str, String str2, String str3);

    public void invokeThirdApp(String str, String str2, String str3) {
        n nVar = new n(str2, str3);
        nVar.a(this);
        this.Wo.put(12, nVar);
        JSONObject a = com.baidu.browser.sailor.util.e.a(str);
        try {
            String string = a.getString("action");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            Intent intent = new Intent(string);
            Iterator<String> keys = a.keys();
            Bundle bundle = new Bundle();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!"action".equals(next)) {
                    String string2 = a.getString(next);
                    if ("type".equals(next)) {
                        intent.setType(string2);
                    } else if ("data".equals(next) || "uri".equals(next)) {
                        intent.setData(Uri.parse(string2));
                    } else {
                        bundle.putString(next, string2);
                        intent.putExtra(next, string2);
                    }
                }
            }
            intent.putExtras(bundle);
            intent.putExtra("jsaction_key", 12);
            z(intent);
        } catch (JSONException e) {
            nVar.cB(e.getMessage());
            e.printStackTrace();
        }
    }

    public abstract void isLogin(String str, String str2, String str3);

    public abstract void launchSeniorVoiceRecognition(String str, String str2, String str3);

    public abstract void login(String str, String str2, String str3);

    public void playAudio(String str, String str2, String str3, String str4) {
        n nVar = new n(str3, str4);
        nVar.a(this);
        com.baidu.browser.sailor.util.c.a(new i(this, str2, nVar, str));
    }

    public void postFile(String str, String str2, String str3, String str4) {
        com.baidu.browser.sailor.b.b.a.a(str, str2, str3, str4, this, qL(), this.mWebView != null ? this.mWebView.getSettings().getUserAgentString() : "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String qL();

    /* JADX INFO: Access modifiers changed from: protected */
    public void qM() {
        com.baidu.browser.sailor.feature.a cD = com.baidu.browser.sailor.b.a.qS().cD("LIGHT_APP");
        if (cD == null || this.mActivity == null) {
            Log.w("BdLightappKernelClient", "lightAppFeature or mActivity null");
        } else {
            cD.a(this.mActivity.toString(), this);
        }
    }

    public abstract void queryWzStatus(String str, String str2);

    public abstract void queryZhidaStatus(String str, String str2, String str3);

    public void setVolume(String str, String str2, String str3) {
        n nVar = new n(str2, str3);
        nVar.a(this);
        try {
            float parseFloat = Float.parseFloat(str);
            if (parseFloat < 0.0d || parseFloat > 1.0d) {
                nVar.cB("Volume out of range, should between [0.0,1.0]");
            } else {
                com.baidu.browser.sailor.util.c.a(new k(this, parseFloat, nVar));
            }
        } catch (Exception e) {
            nVar.cB(e.getMessage());
        }
    }

    public abstract void shareB64Img(String str);

    public void startListenBattery(String str, String str2) {
        com.baidu.browser.sailor.b.b.a.c(str, str2, this);
        this.Wp = true;
    }

    public abstract void startListenKeyboard(String str, String str2, String str3);

    public abstract void startListenLocation(String str, String str2);

    public abstract void startQRcode(String str, String str2, String str3);

    public void startRecording(String str, String str2, String str3) {
        com.baidu.browser.sailor.util.c.a(new g(this, str2, str3, str));
    }

    public void stopListenBattery(String str, String str2) {
        com.baidu.browser.sailor.b.b.a.d(str, str2, this);
        this.Wp = false;
    }

    public abstract void stopListenKeyboard(String str, String str2, String str3);

    public abstract void stopListenLocation(String str, String str2);

    public void stopRecording(String str, String str2) {
        com.baidu.browser.sailor.util.c.a(new h(this, str, str2));
    }

    public abstract void unSubscribeZhida(String str, String str2, String str3);

    protected void z(Intent intent) {
        com.baidu.browser.sailor.util.c.a(new f(this, intent));
    }
}
