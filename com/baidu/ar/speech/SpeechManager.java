package com.baidu.ar.speech;

import android.content.Context;
import android.util.Log;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.mms.voicesearch.invoke.VoiceSearchInvoker;
import com.baidu.mms.voicesearch.invoke.voicerecognition.IVoiceRecognitionCallback;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.EventManagerFactory;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SpeechManager {
    private static SpeechManager a;
    private Context b;
    private EventManager c;
    private boolean d = true;
    private SpeechStatus e = SpeechStatus.SPEECH_IDLE;

    /* loaded from: classes3.dex */
    public enum SpeechStatus {
        SPEECH_IDLE,
        SPEECH_INIT,
        SPEECH_OPEN,
        SPEECH_CANCEL
    }

    private SpeechManager(Context context) {
        this.b = context;
    }

    private static void a() {
        a = null;
    }

    private void a(IVoiceRecognitionCallback iVoiceRecognitionCallback) {
        try {
            Log.e("lua = ", "cancelVoiceRecognition");
            VoiceSearchInvoker.invoke("cancelVoiceRecognition", (Class[]) null, (Object[]) null, iVoiceRecognitionCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized SpeechManager getInstance(Context context) {
        SpeechManager speechManager;
        synchronized (SpeechManager.class) {
            if (a == null) {
                a = new SpeechManager(context);
            }
            speechManager = a;
        }
        return speechManager;
    }

    public static void releaseAudioInputStream() {
        if (SpeechDataFactory.create8kInputStream() != null) {
            ((AudioInputStream) SpeechDataFactory.create8kInputStream()).closeByUser();
        }
        SpeechDataFactory.release();
    }

    public void cancel(IVoiceRecognitionCallback iVoiceRecognitionCallback) {
        if (ARConfig.isBox()) {
            a(iVoiceRecognitionCallback);
        } else if (this.c != null) {
            this.c.send("asr.cancel", new JSONObject().toString(), (byte[]) null, 0, 0);
        }
    }

    public void destroy() {
        this.c = null;
        releaseAudioInputStream();
        a();
        this.b = null;
    }

    public SpeechStatus getSpeechStatus() {
        return this.e;
    }

    public boolean isShowErrorTips() {
        return this.d;
    }

    public void setARRecognitionListener(IVoiceRecognitionCallback iVoiceRecognitionCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("needRecordData", false);
            jSONObject.put("voiceFrom", ARFileUtils.AR_UNZIP_ROOT_DIR);
            jSONObject.put("systemMicPermissionClick", "deny");
            jSONObject.put("isShowMicPermissionDialog", false);
            jSONObject.put("isRecognizeFromMicInputStream", true);
            jSONObject.put("micInputStreamName", "#com.baidu.ar.speech.SpeechDataFactory.create8kInputStream()");
            VoiceSearchInvoker.invoke("startVoiceRecognition", new Class[]{Context.class, String.class}, new Object[]{this.b, jSONObject.toString()}, iVoiceRecognitionCallback);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("lua JSONException", e.toString());
        }
    }

    public void setARRecognitionListener(EventListener eventListener) {
        if (this.c == null) {
            this.c = EventManagerFactory.create(this.b, "asr");
        }
        this.c.registerListener(eventListener);
    }

    public void setShowErrorTips(boolean z) {
        this.d = z;
    }

    public void setSpeechStatus(SpeechStatus speechStatus) {
        this.e = speechStatus;
    }

    public void startARListener(HashMap hashMap) {
        if (this.c != null) {
            this.c.send("asr.start", new JSONObject(hashMap).toString(), (byte[]) null, 0, 0);
        }
    }

    public void stopARListening(IVoiceRecognitionCallback iVoiceRecognitionCallback) {
        try {
            VoiceSearchInvoker.invoke("finishVoiceRecognition", (Class[]) null, (Object[]) null, iVoiceRecognitionCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
