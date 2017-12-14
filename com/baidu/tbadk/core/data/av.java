package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class av {
    private String Yf;
    private List<a> Yg = new ArrayList();

    public String qF() {
        return StringUtils.isNull(this.Yf) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.Yf;
    }

    public com.baidu.tieba.card.data.p qG() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.cel = qF();
        if (this.Yg != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.Yg) {
                if (aVar != null) {
                    arrayList2.add(aVar.qI());
                }
            }
            arrayList = arrayList2;
        }
        pVar.cem = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.Yf = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.v(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.Yg.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qH() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long Yh;
        private String Yi;
        private long Yj;
        private String Yk;
        private String Yl;
        private int tag;
        private int type;

        public long qH() {
            return this.Yh;
        }

        public String getTopicName() {
            return this.Yi;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.Yh = recomTopicList.topic_id.longValue();
                this.Yi = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.Yj = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.Yk = recomTopicList.topic_desc;
                this.Yl = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qI() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.Yk;
            oVar.Yh = this.Yh;
            oVar.Yi = this.Yi;
            return oVar;
        }
    }
}
