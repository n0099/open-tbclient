package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class z {
    private String Wj;
    private List<a> Wk = new ArrayList();

    public String sI() {
        return StringUtils.isNull(this.Wj) ? TbadkCoreApplication.m411getInst().getString(t.j.hot_topic_card_title) : this.Wj;
    }

    public com.baidu.tieba.card.a.u sJ() {
        com.baidu.tieba.card.a.u uVar = new com.baidu.tieba.card.a.u();
        ArrayList arrayList = null;
        uVar.aSI = sI();
        if (this.Wk != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.Wk) {
                if (aVar != null) {
                    arrayList2.add(aVar.sL());
                }
            }
            arrayList = arrayList2;
        }
        uVar.aSJ = arrayList;
        return uVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.Wj = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.x.o(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.Wk.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.sK() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long Wl;
        private String Wm;
        private long Wn;
        private String Wo;
        private String Wp;
        private int tag;
        private int type;

        public long sK() {
            return this.Wl;
        }

        public String getTopicName() {
            return this.Wm;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.Wl = recomTopicList.topic_id.longValue();
                this.Wm = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.Wn = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.Wo = recomTopicList.topic_desc;
                this.Wp = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.a.t sL() {
            com.baidu.tieba.card.a.t tVar = new com.baidu.tieba.card.a.t();
            tVar.tag = this.tag;
            tVar.desc = this.Wo;
            tVar.Wl = this.Wl;
            tVar.Wm = this.Wm;
            return tVar;
        }
    }
}
