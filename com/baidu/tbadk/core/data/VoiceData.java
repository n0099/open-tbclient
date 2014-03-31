package com.baidu.tbadk.core.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class VoiceData {

    /* loaded from: classes.dex */
    public class VoiceModel implements Serializable {
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
    }
}
