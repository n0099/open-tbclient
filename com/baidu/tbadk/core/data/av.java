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
    private String Yl;
    private List<a> Ym = new ArrayList();

    public String qH() {
        return StringUtils.isNull(this.Yl) ? TbadkCoreApplication.getInst().getString(d.j.hot_topic_card_title) : this.Yl;
    }

    public com.baidu.tieba.card.data.p qI() {
        com.baidu.tieba.card.data.p pVar = new com.baidu.tieba.card.data.p();
        ArrayList arrayList = null;
        pVar.cdX = qH();
        if (this.Ym != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.Ym) {
                if (aVar != null) {
                    arrayList2.add(aVar.qK());
                }
            }
            arrayList = arrayList2;
        }
        pVar.cdY = arrayList;
        return pVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.Yl = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.v(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.Ym.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.qJ() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long Yn;
        private String Yo;
        private long Yp;
        private String Yq;
        private String Yr;
        private int tag;
        private int type;

        public long qJ() {
            return this.Yn;
        }

        public String getTopicName() {
            return this.Yo;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.Yn = recomTopicList.topic_id.longValue();
                this.Yo = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.Yp = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.Yq = recomTopicList.topic_desc;
                this.Yr = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.o qK() {
            com.baidu.tieba.card.data.o oVar = new com.baidu.tieba.card.data.o();
            oVar.tag = this.tag;
            oVar.desc = this.Yq;
            oVar.Yn = this.Yn;
            oVar.Yo = this.Yo;
            return oVar;
        }
    }
}
