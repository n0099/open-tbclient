package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import tbclient.FrsPage.PostTopic;
/* loaded from: classes3.dex */
public class PostTopicData extends OrmObject implements Serializable {
    public String contentTopic;
    public String titleTopic;

    public String getContentTopic() {
        return this.contentTopic;
    }

    public String getTitleTopic() {
        return this.titleTopic;
    }

    public void parserProtobuf(PostTopic postTopic) {
        if (postTopic == null) {
            return;
        }
        this.titleTopic = postTopic.title_topic;
        this.contentTopic = postTopic.content_topic;
    }

    public void setContentTopic(String str) {
        this.contentTopic = str;
    }

    public void setTitleTopic(String str) {
        this.titleTopic = str;
    }
}
