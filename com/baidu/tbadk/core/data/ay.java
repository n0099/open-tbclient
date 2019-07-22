package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes3.dex */
public class ay {
    private String bIB;
    private List<a> bIC = new ArrayList();

    public String adG() {
        return StringUtils.isNull(this.bIB) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.bIB;
    }

    public com.baidu.tieba.card.data.n adH() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.eGs = adG();
        if (this.bIC != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.bIC) {
                if (aVar != null) {
                    arrayList2.add(aVar.adJ());
                }
            }
            arrayList = arrayList2;
        }
        nVar.eGt = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.bIB = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.Z(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.bIC.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.adI() <= 0;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private String bID;
        private long bIE;
        private String bIF;
        private String bIG;
        private int tag;
        private long topicId;
        private int type;

        public long adI() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.bID;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.bID = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.bIE = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.bIF = recomTopicList.topic_desc;
                this.bIG = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m adJ() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.bIF;
            mVar.topicId = this.topicId;
            mVar.bID = this.bID;
            return mVar;
        }
    }
}
