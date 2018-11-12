package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId aoQ = BdUniqueId.gen();
    public int amP;
    public String anb;
    public String anc;
    public String and;
    public String aoR;
    public String aoS;
    public String aoT;
    public List<String> aoU;
    public String aoV;
    public String aoW;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aoR = recommendBook.recommend_text;
            this.aoS = recommendBook.suggest_text;
            this.aoT = recommendBook.suggest_url;
            this.anb = recommendBook.book_id;
            this.amP = recommendBook.book_type.intValue();
            this.and = recommendBook.book_cover;
            this.anc = recommendBook.book_title;
            this.aoU = recommendBook.book_tips;
            this.aoV = recommendBook.botton_text;
            this.aoW = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.anb)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aoQ;
    }
}
