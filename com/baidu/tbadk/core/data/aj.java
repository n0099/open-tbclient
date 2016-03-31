package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes.dex */
public class aj {
    private String Us;
    private List<a> Ut = new ArrayList();

    public String sD() {
        return StringUtils.isNull(this.Us) ? TbadkCoreApplication.m411getInst().getString(t.j.hot_topic_card_title) : this.Us;
    }

    public com.baidu.tieba.card.a.x sE() {
        com.baidu.tieba.card.a.x xVar = new com.baidu.tieba.card.a.x();
        ArrayList arrayList = null;
        xVar.aWu = sD();
        if (this.Ut != null) {
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : this.Ut) {
                if (aVar != null) {
                    arrayList2.add(aVar.sG());
                }
            }
            arrayList = arrayList2;
        }
        xVar.aWv = arrayList;
        return xVar;
    }

    public void a(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo != null) {
            this.Us = recomTopicInfo.recom_title;
            if (com.baidu.tbadk.core.util.y.p(recomTopicInfo.topic_list) > 0) {
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    if (recomTopicList != null) {
                        a aVar = new a();
                        aVar.a(recomTopicList);
                        if (!a(aVar)) {
                            this.Ut.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private boolean a(a aVar) {
        return aVar == null || StringUtils.isNull(aVar.getTopicName()) || aVar.sF() <= 0;
    }

    /* loaded from: classes.dex */
    public static class a {
        private long Uu;
        private String Uv;
        private long Uw;
        private String Ux;
        private String Uy;
        private int tag;
        private int type;

        public long sF() {
            return this.Uu;
        }

        public String getTopicName() {
            return this.Uv;
        }

        public void a(RecomTopicList recomTopicList) {
            if (recomTopicList != null) {
                this.Uu = recomTopicList.topic_id.longValue();
                this.Uv = recomTopicList.topic_name;
                this.type = recomTopicList.type.intValue();
                this.Uw = recomTopicList.discuss_num.longValue();
                this.tag = recomTopicList.tag.intValue();
                this.Ux = recomTopicList.topic_desc;
                this.Uy = recomTopicList.topic_pic;
            }
        }

        public com.baidu.tieba.card.a.w sG() {
            com.baidu.tieba.card.a.w wVar = new com.baidu.tieba.card.a.w();
            wVar.tag = this.tag;
            wVar.desc = this.Ux;
            wVar.Uu = this.Uu;
            wVar.Uv = this.Uv;
            return wVar;
        }
    }
}
