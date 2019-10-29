package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes3.dex */
public class az {
    private String caL;
    private List<a> caM = new ArrayList();

    public String ahP() {
        return StringUtils.isNull(this.caL) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.caL;
    }

    public com.baidu.tieba.card.data.n ahQ() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.eQN = ahP();
        if (this.caM != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.caM) {
                if (aVar != null) {
                    arrayList2.add(aVar.ahS());
                }
            }
            arrayList = arrayList2;
        }
        nVar.eQO = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.caL = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.caM.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.ahR() <= 0;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private String caN;
        private long caO;
        private String caP;
        private String caQ;
        private int tag;
        private long topicId;
        private int type;

        public long ahR() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.caN;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.caN = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.caO = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.caP = recomTopicList.topic_desc;
                this.caQ = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m ahS() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.caP;
            mVar.topicId = this.topicId;
            mVar.caN = this.caN;
            return mVar;
        }
    }
}
