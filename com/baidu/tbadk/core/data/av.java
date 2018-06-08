package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes2.dex */
public class av {
    private String ahn;
    private List<a> aho = new ArrayList();

    public String uH() {
        return StringUtils.isNull(this.ahn) ? TbadkCoreApplication.getInst().getString(d.k.hot_topic_card_title) : this.ahn;
    }

    public com.baidu.tieba.card.data.n uI() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.cCa = uH();
        if (this.aho != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.aho) {
                if (aVar != null) {
                    arrayList2.add(aVar.uK());
                }
            }
            arrayList = arrayList2;
        }
        nVar.cCb = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.ahn = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.w.y(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.aho.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.uJ() <= 0;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private long ahp;
        private String ahq;
        private long ahr;
        private String ahs;
        private String aht;
        private int tag;
        private int type;

        public long uJ() {
            return this.ahp;
        }

        public String getTopicName() {
            return this.ahq;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.ahp = recomTopicList.topic_id.longValue();
                this.ahq = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.ahr = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.ahs = recomTopicList.topic_desc;
                this.aht = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m uK() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.ahs;
            mVar.ahp = this.ahp;
            mVar.ahq = this.ahq;
            return mVar;
        }
    }
}
