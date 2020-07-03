package com.baidu.tbadk.core.data;

import tbclient.RecomPostTopic;
/* loaded from: classes.dex */
public class be {
    public long dKl;
    public String recom_title;
    public String recom_topic;

    public void a(RecomPostTopic recomPostTopic) {
        if (recomPostTopic != null) {
            this.recom_title = recomPostTopic.recom_title;
            this.recom_topic = recomPostTopic.recom_topic;
            this.dKl = recomPostTopic.uniq_topicid.longValue();
        }
    }
}
