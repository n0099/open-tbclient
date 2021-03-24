package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Voice;
/* loaded from: classes3.dex */
public class VoiceData$VoiceModel extends OrmObject implements Serializable {
    public static final long serialVersionUID = 5684687527058675291L;
    public int duration;
    public int duration2;
    public String from;
    public String voiceId;
    public boolean isLocal = false;
    public int elapse = 0;
    public int curr_time = 0;
    public Integer voice_status = 1;

    public void copy(VoiceData$VoiceModel voiceData$VoiceModel) {
        if (voiceData$VoiceModel == null) {
            return;
        }
        this.from = voiceData$VoiceModel.from;
        this.voiceId = voiceData$VoiceModel.voiceId;
        this.isLocal = voiceData$VoiceModel.isLocal;
        this.duration = voiceData$VoiceModel.duration;
        this.duration2 = voiceData$VoiceModel.duration2;
        this.elapse = voiceData$VoiceModel.elapse;
        this.curr_time = voiceData$VoiceModel.curr_time;
        this.voice_status = voiceData$VoiceModel.voice_status;
    }

    public String getId() {
        return this.voiceId;
    }

    public void init() {
        this.voice_status = 1;
        this.elapse = 0;
        this.isLocal = false;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        init();
        this.duration = jSONObject.optInt("during_time") / 1000;
        this.voiceId = jSONObject.optString("voice_md5");
    }

    public void parserProtobuf(Voice voice) {
        if (voice == null) {
            return;
        }
        init();
        this.duration = voice.during_time.intValue() / 1000;
        this.voiceId = voice.voice_md5;
    }
}
