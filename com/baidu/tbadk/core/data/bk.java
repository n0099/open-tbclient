package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class bk {
    private String dKu;
    private List<a> dKv = new ArrayList();

    public String aRx() {
        return StringUtils.isNull(this.dKu) ? TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title) : this.dKu;
    }

    public com.baidu.tieba.card.data.n aRy() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.gVd = aRx();
        if (this.dKv != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.dKv) {
                if (aVar != null) {
                    arrayList2.add(aVar.aRz());
                }
            }
            arrayList = arrayList2;
        }
        nVar.gVe = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.dKu = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.w.getCount(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.dKv.add(aVar);
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
        private String dKw;
        private long dKx;
        private String dKy;
        private String dKz;
        private int tag;
        private long topicId;
        private int type;

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.dKw;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.topicId = recomTopicList.topic_id.longValue();
                this.dKw = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.dKx = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.dKy = recomTopicList.topic_desc;
                this.dKz = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m aRz() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.dKy;
            mVar.topicId = this.topicId;
            mVar.dKw = this.dKw;
            return mVar;
        }
    }
}
