package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes2.dex */
public class az extends PostData {
    public static final BdUniqueId dZr = BdUniqueId.gen();
    public String dXK;
    public String dXL;
    public String dXM;
    public int dXm;
    public String dZs;
    public String dZt;
    public String dZu;
    public List<String> dZv;
    public String dZw;
    public String dZx;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.dZs = recommendBook.recommend_text;
            this.dZt = recommendBook.suggest_text;
            this.dZu = recommendBook.suggest_url;
            this.dXK = recommendBook.book_id;
            this.dXm = recommendBook.book_type.intValue();
            this.dXM = recommendBook.book_cover;
            this.dXL = recommendBook.book_title;
            this.dZv = recommendBook.book_tips;
            this.dZw = recommendBook.botton_text;
            this.dZx = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.dXK)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dZr;
    }
}
