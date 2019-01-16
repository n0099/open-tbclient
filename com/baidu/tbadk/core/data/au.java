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
    private String atl;
    private List<a> atm = new ArrayList();

    public String zl() {
        return StringUtils.isNull(this.atl) ? TbadkCoreApplication.getInst().getString(e.j.hot_topic_card_title) : this.atl;
    }

    public com.baidu.tieba.card.data.n zm() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.dbX = zl();
        if (this.atm != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.atm) {
                if (aVar != null) {
                    arrayList2.add(aVar.zo());
                }
            }
            arrayList = arrayList2;
        }
        nVar.dbY = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.atl = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.H(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.atm.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.zn() <= 0;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private long atn;
        private String ato;
        private long atp;
        private String atq;
        private String atr;
        private int tag;
        private int type;

        public long zn() {
            return this.atn;
        }

        public String getTopicName() {
            return this.ato;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.atn = recomTopicList.topic_id.longValue();
                this.ato = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.atp = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.atq = recomTopicList.topic_desc;
                this.atr = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m zo() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.atq;
            mVar.atn = this.atn;
            mVar.ato = this.ato;
            return mVar;
        }
    }
}
