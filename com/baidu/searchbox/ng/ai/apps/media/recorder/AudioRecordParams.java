package com.baidu.searchbox.ng.ai.apps.media.recorder;

import android.text.TextUtils;
import com.baidu.ar.audio.AudioParams;
import com.baidu.searchbox.ng.ai.apps.media.recorder.utils.AiAppsRecordConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AudioRecordParams {
    private static final int CHANNELS_ONE = 1;
    private static final int CHANNELS_TWO = 2;
    protected static final boolean DEBUG = false;
    private static final int DEFAULT_DURATION = 60000;
    private static final String KEY_CALLBACKS = "cb";
    private static final String KEY_CHANNELS = "numberOfChannels";
    private static final String KEY_DURATION = "duration";
    private static final String KEY_ENCODE_BIT_RATE = "encodeBitRate";
    private static final String KEY_FORMAT = "format";
    private static final String KEY_SAMPLE_RATE = "sampleRate";
    private static final int MAX_DURATION = 600000;
    private static final int SAMPLE_16000_ENCODE_MAX = 96000;
    private static final int SAMPLE_16000_ENCODE_MIN = 24000;
    private static final int SAMPLE_44100_ENCODE_MAX = 320000;
    private static final int SAMPLE_44100_ENCODE_MIN = 64000;
    private static final int SAMPLE_8000_ENCODE_MAX = 48000;
    private static final int SAMPLE_8000_ENCODE_MIN = 16000;
    private static final int SAMPLE_RATE_16000 = 16000;
    private static final int SAMPLE_RATE_44100 = 44100;
    private static final int SAMPLE_RATE_8000 = 8000;
    protected static final String TAG = "AudioRecordParams";
    public String audioFormat;
    public int bitRate;
    public String callbacks;
    public int channel;
    public int recordTime;
    public int sampleRate;

    public static AudioRecordParams createFromJSON(JSONObject jSONObject, AudioRecordParams audioRecordParams) {
        if (jSONObject != null) {
            audioRecordParams = new AudioRecordParams();
            audioRecordParams.recordTime = jSONObject.optInt("duration", 60000);
            audioRecordParams.audioFormat = jSONObject.optString("format");
            if (TextUtils.isEmpty(audioRecordParams.audioFormat)) {
                audioRecordParams.audioFormat = AiAppsRecordConstants.FORMAT_AAC;
            }
            audioRecordParams.channel = jSONObject.optInt(KEY_CHANNELS, 1);
            audioRecordParams.sampleRate = jSONObject.optInt(KEY_SAMPLE_RATE, SAMPLE_RATE_8000);
            audioRecordParams.bitRate = jSONObject.optInt(KEY_ENCODE_BIT_RATE);
            if (audioRecordParams.bitRate == 0) {
                switch (audioRecordParams.sampleRate) {
                    case SAMPLE_RATE_8000 /* 8000 */:
                        audioRecordParams.bitRate = AudioParams.DEFAULT_SAMPLE_RATE;
                        break;
                    case AudioParams.DEFAULT_SAMPLE_RATE /* 16000 */:
                        audioRecordParams.bitRate = SAMPLE_16000_ENCODE_MIN;
                        break;
                    case SAMPLE_RATE_44100 /* 44100 */:
                        audioRecordParams.bitRate = SAMPLE_44100_ENCODE_MIN;
                        break;
                }
            }
            audioRecordParams.callbacks = jSONObject.optString("cb");
        }
        return audioRecordParams;
    }

    public JSONObject getParamsWrongCode() {
        if (this.recordTime > MAX_DURATION || this.recordTime <= 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, AiAppsRecordConstants.ERROR_DURATION);
        }
        if (this.channel != 1 && this.channel != 2) {
            return UnitedSchemeUtility.wrapCallbackParams(202, AiAppsRecordConstants.ERROR_CHANNELS);
        }
        if (!TextUtils.equals(this.audioFormat, AiAppsRecordConstants.FORMAT_AAC) && !TextUtils.equals(this.audioFormat, AiAppsRecordConstants.FORMAT_PCM)) {
            return UnitedSchemeUtility.wrapCallbackParams(202, AiAppsRecordConstants.ERROR_FORMAT);
        }
        if (this.sampleRate != SAMPLE_RATE_8000 && this.sampleRate != 16000 && this.sampleRate != SAMPLE_RATE_44100) {
            return UnitedSchemeUtility.wrapCallbackParams(202, AiAppsRecordConstants.ERROR_SAMPLE_RATE);
        }
        if (!TextUtils.equals(this.audioFormat, AiAppsRecordConstants.FORMAT_PCM)) {
            boolean z = false;
            switch (this.sampleRate) {
                case SAMPLE_RATE_8000 /* 8000 */:
                    if (this.bitRate > SAMPLE_8000_ENCODE_MAX || this.bitRate < 16000) {
                        z = true;
                        break;
                    }
                    break;
                case AudioParams.DEFAULT_SAMPLE_RATE /* 16000 */:
                    if (this.bitRate > SAMPLE_16000_ENCODE_MAX || this.bitRate < SAMPLE_16000_ENCODE_MIN) {
                        z = true;
                        break;
                    }
                    break;
                case SAMPLE_RATE_44100 /* 44100 */:
                    if (this.bitRate > SAMPLE_44100_ENCODE_MAX || this.bitRate < SAMPLE_44100_ENCODE_MIN) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z) {
                return UnitedSchemeUtility.wrapCallbackParams(202, AiAppsRecordConstants.ERROR_BIT_RATE);
            }
        }
        if (TextUtils.isEmpty(this.callbacks)) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "none cb");
        }
        return null;
    }

    public String toString() {
        return "recordTime : " + this.recordTime + "; channel : " + this.channel + "; audioFormat : " + this.audioFormat + "; sampleRate : " + this.sampleRate + "; bitRate : " + this.bitRate + "; callbacks : " + this.callbacks;
    }
}
