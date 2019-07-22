package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class aq extends PostData {
    public static final BdUniqueId bHZ = BdUniqueId.gen();
    public int bGa;
    public String bGm;
    public String bGn;
    public String bGo;
    public String bIa;
    public String bIb;
    public String bIc;
    public List<String> bId;
    public String bIe;
    public String bIf;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bIa = recommendBook.recommend_text;
            this.bIb = recommendBook.suggest_text;
            this.bIc = recommendBook.suggest_url;
            this.bGm = recommendBook.book_id;
            this.bGa = recommendBook.book_type.intValue();
            this.bGo = recommendBook.book_cover;
            this.bGn = recommendBook.book_title;
            this.bId = recommendBook.book_tips;
            this.bIe = recommendBook.botton_text;
            this.bIf = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bGm)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bHZ;
    }
}
