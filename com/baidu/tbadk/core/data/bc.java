package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class bc {
    private String dDU;
    private List<a> dDV = new ArrayList();

    public String aPI() {
        return StringUtils.isNull(this.dDU) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.dDU;
    }

    public com.baidu.tieba.card.data.n aPJ() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.gId = aPI();
        if (this.dDV != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.dDV) {
                if (aVar != null) {
                    arrayList2.add(aVar.aPK());
                }
            }
            arrayList = arrayList2;
        }
        nVar.gIe = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.dDU = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.dDV.add(aVar);
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
        private String dDW;
        private long dDX;
        private String dDY;
        private String dDZ;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.dDW;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.dDW = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.dDX = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.dDY = recomTopicList.topic_desc;
                this.dDZ = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m aPK() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.dDY;
            mVar.topicId = this.topicId;
            mVar.dDW = this.dDW;
            return mVar;
        }
    }
}
