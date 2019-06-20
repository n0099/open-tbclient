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
    private String bHB;
    private List<a> bHC = new ArrayList();

    public String acE() {
        return StringUtils.isNull(this.bHB) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.bHB;
    }

    public com.baidu.tieba.card.data.n acF() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.eBw = acE();
        if (this.bHC != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.bHC) {
                if (aVar != null) {
                    arrayList2.add(aVar.acH());
                }
            }
            arrayList = arrayList2;
        }
        nVar.eBx = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.bHB = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.Z(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.bHC.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.acG() <= 0;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private String bHD;
        private long bHE;
        private String bHF;
        private String bHG;
        private int tag;
        private long topicId;
        private int type;

        public long acG() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.bHD;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.bHD = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.bHE = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.bHF = recomTopicList.topic_desc;
                this.bHG = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m acH() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.bHF;
            mVar.topicId = this.topicId;
            mVar.bHD = this.bHD;
            return mVar;
        }
    }
}
