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
    private String api;
    private List<a> apj = new ArrayList();

    public String xU() {
        return StringUtils.isNull(this.api) ? TbadkCoreApplication.getInst().getString(e.j.hot_topic_card_title) : this.api;
    }

    public com.baidu.tieba.card.data.n xV() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.cRM = xU();
        if (this.apj != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.apj) {
                if (aVar != null) {
                    arrayList2.add(aVar.xX());
                }
            }
            arrayList = arrayList2;
        }
        nVar.cRN = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.api = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.H(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.apj.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.xW() <= 0;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private long apk;
        private String apl;
        private long apm;
        private String apn;
        private String apo;
        private int tag;
        private int type;

        public long xW() {
            return this.apk;
        }

        public String getTopicName() {
            return this.apl;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.apk = recomTopicList.topic_id.longValue();
                this.apl = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.apm = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.apn = recomTopicList.topic_desc;
                this.apo = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m xX() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.apn;
            mVar.apk = this.apk;
            mVar.apl = this.apl;
            return mVar;
        }
    }
}
