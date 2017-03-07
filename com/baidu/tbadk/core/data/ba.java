package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class ba {
    private String Xl;
    private List<a> Xm = new ArrayList();

    public String ra() {
        return StringUtils.isNull(this.Xl) ? TbadkCoreApplication.m9getInst().getString(w.l.hot_topic_card_title) : this.Xl;
    }

    public com.baidu.tieba.card.data.r rb() {
        com.baidu.tieba.card.data.r rVar = new com.baidu.tieba.card.data.r();
        ArrayList arrayList = null;
        rVar.bvH = ra();
        if (this.Xm != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.Xm) {
                if (aVar != null) {
                    arrayList2.add(aVar.rd());
                }
            }
            arrayList = arrayList2;
        }
        rVar.bvI = arrayList;
        return rVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.Xl = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.x.p(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.Xm.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.rc() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long Xn;
        private String Xo;
        private long Xp;
        private String Xq;
        private String Xr;
        private int tag;
        private int type;

        public long rc() {
            return this.Xn;
        }

        public String getTopicName() {
            return this.Xo;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.Xn = recomTopicList.topic_id.longValue();
                this.Xo = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.Xp = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.Xq = recomTopicList.topic_desc;
                this.Xr = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.q rd() {
            com.baidu.tieba.card.data.q qVar = new com.baidu.tieba.card.data.q();
            qVar.tag = this.tag;
            qVar.desc = this.Xq;
            qVar.Xn = this.Xn;
            qVar.Xo = this.Xo;
            return qVar;
        }
    }
}
