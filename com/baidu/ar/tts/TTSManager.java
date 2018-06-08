package com.baidu.ar.tts;

import android.content.Context;
import android.util.Log;
import com.baidu.ar.util.NetworkUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TTSManager {
    public static final String PACKAGE_NAME = "com.baidu.searchbox.tts.plugin";
    public static final int SYNTHESIZER_AUTO = 2;
    public static final int SYNTHESIZER_SERVER = 0;
    public static final String TTS_CONFIG_KEY_SPEAKER = "speaker";
    public static final String TTS_PRODUCTID_SEARCH = "17";
    private static TTSManager d;
    private Context a;
    private boolean b;
    private SpeechSynthesizer c;

    private TTSManager(Context context) {
        this.a = context;
        a();
    }

    private void a() {
        if (NetworkUtil.isNetworkConnected(this.a)) {
            if (this.a.getApplicationContext().getPackageName().equals("com.baidu.searchbox")) {
                this.b = true;
            }
            if (this.b) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("productId", "17");
                    jSONObject.put("ttsMode", 0);
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            this.c = SpeechSynthesizer.getInstance();
            this.c.setContext(this.a);
            this.c.setAppId("10315470");
            this.c.setApiKey("bgW5575sEj5m9CHEatxTGln6", "kD9VCx8q56s3lAaAk0juQtkFfXj3Xsp4");
            AuthInfo auth = this.c.auth(TtsMode.ONLINE);
            if (auth.isSuccess()) {
                Log.e("tts", "auth success");
            } else {
                Log.e("tts", "auth failed errorMsg=" + auth.getTtsError().getDetailMessage());
            }
            this.c.initTts(TtsMode.ONLINE);
        }
    }

    private void a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("paramKey", str);
            jSONObject.put("paramValue", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static TTSManager getTTSManager(Context context) {
        if (d == null) {
            d = new TTSManager(context);
        }
        return d;
    }

    public void initTts(String str, String str2, String str3) {
        if (NetworkUtil.isNetworkConnected(this.a)) {
            if (this.b) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("productId", "17");
                    jSONObject.put("ttsMode", 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a(TTS_CONFIG_KEY_SPEAKER, str);
                return;
            }
            this.c = SpeechSynthesizer.getInstance();
            this.c.setContext(this.a);
            this.c.setParam(SpeechSynthesizer.PARAM_SPEED, str2);
            this.c.setParam(SpeechSynthesizer.PARAM_SPEAKER, str);
            this.c.setStereoVolume(Float.parseFloat(str3), Float.parseFloat(str3));
            AuthInfo auth = this.c.auth(TtsMode.ONLINE);
            if (auth.isSuccess()) {
                Log.e("tts", "auth success");
            } else {
                Log.e("tts", "auth failed errorMsg=" + auth.getTtsError().getDetailMessage());
            }
            this.c.initTts(TtsMode.ONLINE);
        }
    }

    public void pause() {
        if (this.b) {
            Log.d("TTSManager", "pause");
        } else if (this.c != null) {
            this.c.pause();
        }
    }

    public void release() {
        this.a = null;
        d = null;
    }

    public void resume() {
        if (this.b) {
            Log.d("TTSManager", "resume");
        } else if (this.c != null) {
            this.c.resume();
        }
    }

    public void speak(String str, final TTSCallback tTSCallback) {
        if (NetworkUtil.isNetworkConnected(this.a)) {
            JSONObject jSONObject = new JSONObject();
            if (this.b) {
                try {
                    jSONObject.put("text", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (this.c != null) {
                this.c.speak(str);
                this.c.setSpeechSynthesizerListener(new SpeechSynthesizerListener() { // from class: com.baidu.ar.tts.TTSManager.1
                    public void onError(String str2, SpeechError speechError) {
                        if (tTSCallback != null) {
                            tTSCallback.onTtsError(speechError.code);
                        }
                        Log.d("TTSManager", "speak i:  onError " + str2 + "speechError = " + speechError.code + "--" + speechError.description);
                    }

                    public void onSpeechFinish(String str2) {
                        if (tTSCallback != null) {
                            tTSCallback.onTtsFinish();
                        }
                        Log.d("TTSManager", "speak i:  onSpeechFinish " + str2);
                    }

                    public void onSpeechProgressChanged(String str2, int i) {
                        Log.d("TTSManager", "speak i:  onSpeechProgressChanged " + str2);
                    }

                    public void onSpeechStart(String str2) {
                        if (tTSCallback != null) {
                            tTSCallback.onTtsStarted();
                        }
                        Log.d("TTSManager", "speak i:  onSpeechStart " + str2);
                    }

                    public void onSynthesizeDataArrived(String str2, byte[] bArr, int i) {
                        Log.d("TTSManager", "speak i:  onSynthesizeDataArrived " + str2);
                    }

                    public void onSynthesizeFinish(String str2) {
                        Log.d("TTSManager", "speak i:  onSynthesizeFinish " + str2);
                    }

                    public void onSynthesizeStart(String str2) {
                        Log.d("TTSManager", "speak i:  onSynthesizeStart " + str2);
                    }
                });
            }
        }
    }

    public void stop() {
        if (this.b) {
            Log.d("TTSManager", IntentConfig.STOP);
        } else if (this.c != null) {
            this.c.stop();
        }
    }
}
