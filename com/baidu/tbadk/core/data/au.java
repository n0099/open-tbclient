package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes2.dex */
public class au {
    private String aha;
    private List<a> ahb = new ArrayList();

    public String uB() {
        return StringUtils.isNull(this.aha) ? TbadkCoreApplication.getInst().getString(f.j.hot_topic_card_title) : this.aha;
    }

    public com.baidu.tieba.card.data.n uC() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.cCw = uB();
        if (this.ahb != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.ahb) {
                if (aVar != null) {
                    arrayList2.add(aVar.uE());
                }
            }
            arrayList = arrayList2;
        }
        nVar.cCx = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.aha = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.w.y(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.ahb.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.uD() <= 0;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private long ahc;
        private String ahd;
        private long ahe;
        private String ahf;
        private String ahg;
        private int tag;
        private int type;

        public long uD() {
            return this.ahc;
        }

        public String getTopicName() {
            return this.ahd;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.ahc = recomTopicList.topic_id.longValue();
                this.ahd = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.ahe = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.ahf = recomTopicList.topic_desc;
                this.ahg = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m uE() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.ahf;
            mVar.ahc = this.ahc;
            mVar.ahd = this.ahd;
            return mVar;
        }
    }
}
