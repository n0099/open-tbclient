package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes6.dex */
public class au {
    private String asJ;
    private List<a> asK = new ArrayList();

    public String yY() {
        return StringUtils.isNull(this.asJ) ? TbadkCoreApplication.getInst().getString(e.j.hot_topic_card_title) : this.asJ;
    }

    public com.baidu.tieba.card.data.n yZ() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.dbl = yY();
        if (this.asK != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.asK) {
                if (aVar != null) {
                    arrayList2.add(aVar.zb());
                }
            }
            arrayList = arrayList2;
        }
        nVar.dbm = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.asJ = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.H(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.asK.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.za() <= 0;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private long asL;
        private String asM;
        private long asN;
        private String asO;
        private String asP;
        private int tag;
        private int type;

        public long za() {
            return this.asL;
        }

        public String getTopicName() {
            return this.asM;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.asL = recomTopicList.topic_id.longValue();
                this.asM = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.asN = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.asO = recomTopicList.topic_desc;
                this.asP = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m zb() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.asO;
            mVar.asL = this.asL;
            mVar.asM = this.asM;
            return mVar;
        }
    }
}
