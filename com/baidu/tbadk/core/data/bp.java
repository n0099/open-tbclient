package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class bp {
    private String eNf;
    private List<a> eNg = new ArrayList();

    public String bmF() {
        return StringUtils.isNull(this.eNf) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.eNf;
    }

    public com.baidu.tieba.card.data.n bmG() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.ivw = bmF();
        if (this.eNg != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.eNg) {
                if (aVar != null) {
                    arrayList2.add(aVar.bmH());
                }
            }
            arrayList = arrayList2;
        }
        nVar.ivx = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.eNf = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.x.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.eNg.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.getTopicId() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String eNh;
        private long eNi;
        private String eNj;
        private String eNk;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.eNh;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.eNh = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.eNi = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.eNj = recomTopicList.topic_desc;
                this.eNk = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m bmH() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.eNj;
            mVar.topicId = this.topicId;
            mVar.eNh = this.eNh;
            return mVar;
        }
    }
}
