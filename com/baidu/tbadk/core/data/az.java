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
    private String bIG;
    private List<a> bIH = new ArrayList();

    public String adH() {
        return StringUtils.isNull(this.bIG) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.bIG;
    }

    public com.baidu.tieba.card.data.n adI() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.eGz = adH();
        if (this.bIH != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.bIH) {
                if (aVar != null) {
                    arrayList2.add(aVar.adK());
                }
            }
            arrayList = arrayList2;
        }
        nVar.eGA = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.bIG = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.Z(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.bIH.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.adJ() <= 0;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private String bII;
        private long bIJ;
        private String bIK;
        private String bIL;
        private int tag;
        private long topicId;
        private int type;

        public long adJ() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.bII;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.bII = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.bIJ = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.bIK = recomTopicList.topic_desc;
                this.bIL = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m adK() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.bIK;
            mVar.topicId = this.topicId;
            mVar.bII = this.bII;
            return mVar;
        }
    }
}
