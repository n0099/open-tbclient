package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class br {
    private String ePr;
    private List<a> ePs = new ArrayList();

    public String bmY() {
        return StringUtils.isNull(this.ePr) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.ePr;
    }

    public com.baidu.tieba.card.data.n bmZ() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.iBu = bmY();
        if (this.ePs != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.ePs) {
                if (aVar != null) {
                    arrayList2.add(aVar.bna());
                }
            }
            arrayList = arrayList2;
        }
        nVar.iBv = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.ePr = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.ePs.add(aVar);
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
        private String ePt;
        private long ePu;
        private String ePv;
        private String ePw;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.ePt;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.ePt = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.ePu = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.ePv = recomTopicList.topic_desc;
                this.ePw = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m bna() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.ePv;
            mVar.topicId = this.topicId;
            mVar.ePt = this.ePt;
            return mVar;
        }
    }
}
