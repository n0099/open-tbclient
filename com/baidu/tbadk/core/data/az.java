package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class az {
    private String XT;
    private List<a> XU = new ArrayList();

    public String qC() {
        return StringUtils.isNull(this.XT) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.XT;
    }

    public com.baidu.tieba.card.data.p qD() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.bVD = qC();
        if (this.XU != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.XU) {
                if (aVar != null) {
                    arrayList2.add(aVar.qF());
                }
            }
            arrayList = arrayList2;
        }
        pVar.bVE = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.XT = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.u(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.XU.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qE() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long XV;
        private String XW;
        private long XX;
        private String XY;
        private String XZ;
        private int tag;
        private int type;

        public long qE() {
            return this.XV;
        }

        public String getTopicName() {
            return this.XW;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.XV = recomTopicList.topic_id.longValue();
                this.XW = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.XX = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.XY = recomTopicList.topic_desc;
                this.XZ = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qF() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.XY;
            oVar.XV = this.XV;
            oVar.XW = this.XW;
            return oVar;
        }
    }
}
