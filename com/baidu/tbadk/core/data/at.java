package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class at extends PostData {
    public static final BdUniqueId cLQ = BdUniqueId.gen();
    public int cJX;
    public String cKj;
    public String cKk;
    public String cKl;
    public String cLR;
    public String cLS;
    public String cLT;
    public List<String> cLU;
    public String cLV;
    public String cLW;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.cLR = recommendBook.recommend_text;
            this.cLS = recommendBook.suggest_text;
            this.cLT = recommendBook.suggest_url;
            this.cKj = recommendBook.book_id;
            this.cJX = recommendBook.book_type.intValue();
            this.cKl = recommendBook.book_cover;
            this.cKk = recommendBook.book_title;
            this.cLU = recommendBook.book_tips;
            this.cLV = recommendBook.botton_text;
            this.cLW = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.cKj)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cLQ;
    }
}
