package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import tbclient.Voice;
/* loaded from: classes.dex */
public class VoiceData {

    /* loaded from: classes.dex */
    public static class VoiceModel extends OrmObject implements Serializable {
        private static final long serialVersionUID = 5684687527058675291L;
        public int duration;
        public int duration2;
        public String from;
        public String voiceId;
        public boolean isLocal = false;
        public int elapse = 0;
        public int curr_time = 0;
        public Integer voice_status = 1;

        public String getId() {
            return this.voiceId;
        }

        public void init() {
            this.voice_status = 1;
            this.elapse = 0;
            this.isLocal = false;
        }

        public void parserProtobuf(Voice voice) {
            if (voice != null) {
                init();
                this.duration = voice.during_time.intValue() / 1000;
                this.voiceId = voice.voice_md5;
            }
        }
    }
}
