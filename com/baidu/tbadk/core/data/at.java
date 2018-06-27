package com.baidu.tbadk.core.data;

import tbclient.RecomPostTopic;
/* loaded from: classes.dex */
public class at {
    public long ahD;
    public String recom_title;
    public String recom_topic;

    public void a(RecomPostTopic recomPostTopic) {
        if (recomPostTopic != null) {
            this.recom_title = recomPostTopic.recom_title;
            this.recom_topic = recomPostTopic.recom_topic;
            this.ahD = recomPostTopic.uniq_topicid.longValue();
        }
    }
}
