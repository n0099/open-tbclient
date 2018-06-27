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
    private String ahG;
    private List<a> ahH = new ArrayList();

    public String uP() {
        return StringUtils.isNull(this.ahG) ? TbadkCoreApplication.getInst().getString(d.k.hot_topic_card_title) : this.ahG;
    }

    public com.baidu.tieba.card.data.n uQ() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.czU = uP();
        if (this.ahH != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.ahH) {
                if (aVar != null) {
                    arrayList2.add(aVar.uS());
                }
            }
            arrayList = arrayList2;
        }
        nVar.czV = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.ahG = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.w.z(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.ahH.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.uR() <= 0;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private long ahI;
        private String ahJ;
        private long ahK;
        private String ahL;
        private String ahM;
        private int tag;
        private int type;

        public long uR() {
            return this.ahI;
        }

        public String getTopicName() {
            return this.ahJ;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.ahI = recomTopicList.topic_id.longValue();
                this.ahJ = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.ahK = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.ahL = recomTopicList.topic_desc;
                this.ahM = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m uS() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.ahL;
            mVar.ahI = this.ahI;
            mVar.ahJ = this.ahJ;
            return mVar;
        }
    }
}
