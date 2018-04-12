package com.baidu.ar.arspeech;

import android.content.Context;
import android.os.Bundle;
import android.speech.RecognitionListener;
import com.baidu.baiduarsdk.ArBridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ARRecognitionListener implements RecognitionListener {
    public static final int MSG_TYPE_VOICE_CLOSE = 2002;
    public static final int MSG_TYPE_VOICE_START = 2001;
    private Context a;
    private boolean b = false;

    public ARRecognitionListener(Context context) {
        this.a = context;
    }

    private void a(int i) {
        a(i, null, -1);
    }

    private void a(int i, String str, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 2001);
        hashMap.put("status", Integer.valueOf(i));
        if (str != null) {
            hashMap.put("voice_result", str);
        }
        if (i2 != -1) {
            hashMap.put("error_id", Integer.valueOf(i2));
        }
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    @Override // android.speech.RecognitionListener
    public void onBeginningOfSpeech() {
        this.b = false;
        a(1);
    }

    @Override // android.speech.RecognitionListener
    public void onBufferReceived(byte[] bArr) {
    }

    @Override // android.speech.RecognitionListener
    public void onEndOfSpeech() {
        a(2);
    }

    @Override // android.speech.RecognitionListener
    public void onError(int i) {
        int i2;
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 8:
                i2 = 2;
                break;
            case 3:
            case 5:
            case 7:
            default:
                i2 = 0;
                break;
            case 6:
                i2 = 1;
                break;
            case 9:
                i2 = 3;
                break;
        }
        a(3, null, i2);
    }

    @Override // android.speech.RecognitionListener
    public void onEvent(int i, Bundle bundle) {
    }

    @Override // android.speech.RecognitionListener
    public void onPartialResults(Bundle bundle) {
        if (this.b) {
            return;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
        if (stringArrayList.size() > 0) {
            a(6, stringArrayList.get(0), -1);
            String str = stringArrayList.get(0);
            JSONObject a = b.a(this.a).a();
            if (a != null) {
                Iterator<String> keys = a.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        JSONArray jSONArray = new JSONArray(a.getString(next));
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            if (str.contains(string) || string.contains(str)) {
                                this.b = true;
                                a(4, next, -1);
                                return;
                            }
                        }
                        continue;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // android.speech.RecognitionListener
    public void onReadyForSpeech(Bundle bundle) {
        a(0);
    }

    @Override // android.speech.RecognitionListener
    public void onResults(Bundle bundle) {
        if (this.b) {
            return;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
        if (stringArrayList.size() > 0) {
            String str = stringArrayList.get(0);
            JSONObject a = b.a(this.a).a();
            if (a == null) {
                a(4, str, -1);
                return;
            }
            Iterator<String> keys = a.keys();
            String str2 = null;
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONArray jSONArray = new JSONArray(a.getString(next));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (str.contains(string) || string.contains(str)) {
                            str2 = next;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    a(5, null, -1);
                }
            }
            if (str2 == null) {
                a(5, null, -1);
                return;
            }
            this.b = true;
            a(4, str2, -1);
        }
    }

    @Override // android.speech.RecognitionListener
    public void onRmsChanged(float f) {
    }
}
