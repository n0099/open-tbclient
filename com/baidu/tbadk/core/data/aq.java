package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class aq extends PostData {
    public static final BdUniqueId bIa = BdUniqueId.gen();
    public int bGb;
    public String bGn;
    public String bGo;
    public String bGp;
    public String bIb;
    public String bIc;
    public String bId;
    public List<String> bIe;
    public String bIf;
    public String bIg;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bIb = recommendBook.recommend_text;
            this.bIc = recommendBook.suggest_text;
            this.bId = recommendBook.suggest_url;
            this.bGn = recommendBook.book_id;
            this.bGb = recommendBook.book_type.intValue();
            this.bGp = recommendBook.book_cover;
            this.bGo = recommendBook.book_title;
            this.bIe = recommendBook.book_tips;
            this.bIf = recommendBook.botton_text;
            this.bIg = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bGn)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bIa;
    }
}
