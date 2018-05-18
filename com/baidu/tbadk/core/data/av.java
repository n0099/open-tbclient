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
    private String Zl;
    private List<a> Zm = new ArrayList();

    public String rl() {
        return StringUtils.isNull(this.Zl) ? TbadkCoreApplication.getInst().getString(d.k.hot_topic_card_title) : this.Zl;
    }

    public com.baidu.tieba.card.data.n rm() {
        com.baidu.tieba.card.data.n nVar = new com.baidu.tieba.card.data.n();
        ArrayList arrayList = null;
        nVar.ctv = rl();
        if (this.Zm != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.Zm) {
                if (aVar != null) {
                    arrayList2.add(aVar.ro());
                }
            }
            arrayList = arrayList2;
        }
        nVar.ctw = arrayList;
        return nVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.Zl = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.v.v(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.Zm.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.rn() <= 0;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private long Zn;
        private String Zo;
        private long Zp;
        private String Zq;
        private String Zr;
        private int tag;
        private int type;

        public long rn() {
            return this.Zn;
        }

        public String getTopicName() {
            return this.Zo;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.Zn = recomTopicList.topic_id.longValue();
                this.Zo = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.Zp = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.Zq = recomTopicList.topic_desc;
                this.Zr = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.data.m ro() {
            com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m();
            mVar.tag = this.tag;
            mVar.desc = this.Zq;
            mVar.Zn = this.Zn;
            mVar.Zo = this.Zo;
            return mVar;
        }
    }
}
