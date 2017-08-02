package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class bb {
    private String Xf;
    private List<a> Xg = new ArrayList();

    public String qE() {
        return StringUtils.isNull(this.Xf) ? TbadkCoreApplication.getInst().getString(d.l.hot_topic_card_title) : this.Xf;
    }

    public com.baidu.tieba.card.data.p qF() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.bIQ = qE();
        if (this.Xg != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.Xg) {
                if (aVar != null) {
                    arrayList2.add(aVar.qH());
                }
            }
            arrayList = arrayList2;
        }
        pVar.bIR = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.Xf = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.u.u(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.Xg.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qG() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long Xh;
        private String Xi;
        private long Xj;
        private String Xk;
        private String Xl;
        private int tag;
        private int type;

        public long qG() {
            return this.Xh;
        }

        public String getTopicName() {
            return this.Xi;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.Xh = recomTopicList.topic_id.longValue();
                this.Xi = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.Xj = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.Xk = recomTopicList.topic_desc;
                this.Xl = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qH() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.Xk;
            oVar.Xh = this.Xh;
            oVar.Xi = this.Xi;
            return oVar;
        }
    }
}
