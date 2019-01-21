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
    private String atm;
    private List<a> atn = new ArrayList();

    public String zl() {
        return StringUtils.isNull(this.atm) ? TbadkCoreApplication.getInst().getString(e.j.hot_topic_card_title) : this.atm;
    }

    public com.baidu.tieba.card.data.n zm() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.dbY = zl();
        if (this.atn != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.atn) {
                if (aVar != null) {
                    arrayList2.add(aVar.zo());
                }
            }
            arrayList = arrayList2;
        }
        nVar.dbZ = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.atm = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.H(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.atn.add(aVar);
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
        private long ato;
        private String atp;
        private long atq;
        private String atr;
        private String ats;
        private int tag;
        private int type;

        public long zn() {
            return this.ato;
        }

        public String getTopicName() {
            return this.atp;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.ato = recomTopicList.topic_id.longValue();
                this.atp = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.atq = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.atr = recomTopicList.topic_desc;
                this.ats = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m zo() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.atr;
            mVar.ato = this.ato;
            mVar.atp = this.atp;
            return mVar;
        }
    }
}
