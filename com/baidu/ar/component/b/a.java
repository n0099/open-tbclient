package com.baidu.ar.component.b;

import android.util.Log;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.util.Res;
import com.baidu.mms.voicesearch.invoke.voicerecognition.IVoiceRecognitionCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements IVoiceRecognitionCallback {
    private com.baidu.ar.speech.a.a a;

    public a(com.baidu.ar.speech.a.a aVar) {
        this.a = aVar;
    }

    public void onIntermediateResultChange(String str, String str2) {
        String str3 = str + " \r\n " + str2;
        if (this.a != null) {
            this.a.a(true, str3);
        }
    }

    public void onMicNoPermissionButtonClick(int i) {
    }

    public void onMicRelease() {
        if (this.a != null) {
            this.a.b();
        }
    }

    public void onRecognitionFail(String str) {
        String string;
        int i = 0;
        Integer num = 0;
        try {
            num = Integer.valueOf(Integer.parseInt(str));
        } catch (Exception e) {
            Log.e("ARboxRecognitionListner", " onRecognitionFail");
        }
        switch (num.intValue()) {
            case 103:
                i = 3;
                string = Res.getString("bdar_speech_error_premission");
                break;
            case 201:
            case 202:
            case 203:
            case 205:
            case 603:
                i = 2;
                string = Res.getString("bdar_speech_error_network");
                break;
            case 301:
            case 302:
            case 404:
                i = 1;
                string = Res.getString("bdar_speech_error_timeout");
                break;
            default:
                string = Res.getString("bdar_speech_error_other");
                break;
        }
        this.a.a(i, string);
    }

    public void onRecognitionStatusChanged(String str) {
    }

    public void onRecognitionSuccess(String str) {
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.SPEECH_TYPE_RESULT);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("status_code") == 0) {
                String string = jSONObject.getString("data");
                Log.v("lua", "result = " + string);
                if (this.a != null) {
                    this.a.a(false, string);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onVoiceRecogniitonCancel() {
        this.a.e();
    }

    public void onVoiceRecognitionStarted() {
        this.a.c();
    }

    public void onVoiceRecordData(byte[] bArr, int i) {
    }

    public void onVoiceRecordStarted() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public void onVolumeChange(double d) {
        if (this.a != null) {
            this.a.a(d);
        }
    }
}
