package com.baidu.tbadk.core.data;

import tbclient.RecomPostTopic;
/* loaded from: classes.dex */
public class bg {
    public long ece;
    public String recom_title;
    public String recom_topic;

    public void a(RecomPostTopic recomPostTopic) {
        if (recomPostTopic != null) {
            this.recom_title = recomPostTopic.recom_title;
            this.recom_topic = recomPostTopic.recom_topic;
            this.ece = recomPostTopic.uniq_topicid.longValue();
        }
    }
}
