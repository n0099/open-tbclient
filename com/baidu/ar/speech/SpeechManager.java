package com.baidu.ar.speech;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import com.baidu.speech.VoiceRecognitionService;
/* loaded from: classes3.dex */
public class SpeechManager {
    private static SpeechManager a;
    private Context b;
    private SpeechRecognizer c;

    private SpeechManager(Context context) {
        this.b = context;
        this.c = SpeechRecognizer.createSpeechRecognizer(this.b, new ComponentName(this.b, VoiceRecognitionService.class));
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

    public void cancel() {
        if (this.c != null) {
            this.c.cancel();
        }
    }

    public void destroy() {
        this.c.destroy();
        this.c = null;
        a = null;
    }

    public void setARRecognitionListener(RecognitionListener recognitionListener) {
        if (this.c != null) {
            this.c.setRecognitionListener(recognitionListener);
        }
    }

    public void startARListener(Intent intent) {
        if (this.c != null) {
            this.c.startListening(intent);
        }
    }

    public void stopARListening() {
        if (this.c != null) {
            this.c.stopListening();
        }
    }
}
