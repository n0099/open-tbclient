package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class bb extends PostData {
    public static final BdUniqueId eHq = BdUniqueId.gen();
    public String eFJ;
    public String eFK;
    public String eFL;
    public int eFl;
    public String eHr;
    public String eHs;
    public String eHt;
    public List<String> eHu;
    public String eHv;
    public String eHw;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.eHr = recommendBook.recommend_text;
            this.eHs = recommendBook.suggest_text;
            this.eHt = recommendBook.suggest_url;
            this.eFJ = recommendBook.book_id;
            this.eFl = recommendBook.book_type.intValue();
            this.eFL = recommendBook.book_cover;
            this.eFK = recommendBook.book_title;
            this.eHu = recommendBook.book_tips;
            this.eHv = recommendBook.botton_text;
            this.eHw = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.eFJ)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eHq;
    }
}
