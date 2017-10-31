package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import tbclient.FrsPage.PostTopic;
/* loaded from: classes.dex */
public class PostTopicData extends OrmObject implements Serializable {
    private String contentTopic;
    private String titleTopic;

    public void parserProtobuf(PostTopic postTopic) {
        if (postTopic != null) {
            this.titleTopic = postTopic.title_topic;
            this.contentTopic = postTopic.content_topic;
        }
    }

    public String getTitleTopic() {
        return this.titleTopic;
    }

    public String getContentTopic() {
        return this.contentTopic;
    }

    public void setTitleTopic(String str) {
        this.titleTopic = str;
    }

    public void setContentTopic(String str) {
        this.contentTopic = str;
    }
}
