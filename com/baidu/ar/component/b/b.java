package com.baidu.ar.component.b;

import android.util.Log;
import com.baidu.ar.util.Res;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.speech.EventListener;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements EventListener {
    private com.baidu.ar.speech.a.a a;

    public b(com.baidu.ar.speech.a.a aVar) {
        this.a = aVar;
    }

    public void a(int i) {
        int i2;
        String string;
        if (this.a != null) {
            Log.v("lua", "onRecognitionFail errorCode = " + i);
            switch (i) {
                case 1:
                case 2:
                    i2 = 2;
                    string = Res.getString("bdar_speech_error_network");
                    break;
                case 3:
                case 7:
                    i2 = 1;
                    string = Res.getString("bdar_speech_error_timeout");
                    break;
                case 4:
                case 5:
                case 6:
                case 8:
                default:
                    i2 = 0;
                    string = Res.getString("bdar_speech_error_other");
                    break;
                case 9:
                    i2 = 3;
                    string = Res.getString("bdar_speech_error_premission");
                    break;
            }
            this.a.a(i2, string);
        }
    }

    public void onEvent(String str, String str2, byte[] bArr, int i, int i2) {
        if (this.a == null) {
            return;
        }
        if (str.equals("asr.ready")) {
            this.a.a();
        }
        if (str.equals("asr.volume")) {
            try {
                this.a.a(new JSONObject(str2).getInt("volume-percent"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (str.equals("asr.end")) {
            this.a.c();
        }
        if (str.equals("asr.partial")) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.getString("result_type").equals("final_result")) {
                    this.a.a(false, jSONObject.getString("best_result"));
                } else if (!jSONObject.getString("result_type").equals("third_result")) {
                    this.a.a(true, jSONObject.getString("best_result"));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (str.equals("asr.finish")) {
            this.a.d();
            try {
                int i3 = new JSONObject(str2).getInt(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR);
                if (i3 != 0) {
                    a(i3);
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (str.equals("asr.audio")) {
        }
        if (str.equals("asr.cancel")) {
            this.a.e();
        }
    }
}
