package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class aq extends PostData {
    public static final BdUniqueId bZo = BdUniqueId.gen();
    public String bXF;
    public String bXG;
    public String bXH;
    public int bXt;
    public String bZp;
    public String bZq;
    public String bZr;
    public List<String> bZs;
    public String bZt;
    public String bZu;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bZp = recommendBook.recommend_text;
            this.bZq = recommendBook.suggest_text;
            this.bZr = recommendBook.suggest_url;
            this.bXF = recommendBook.book_id;
            this.bXt = recommendBook.book_type.intValue();
            this.bXH = recommendBook.book_cover;
            this.bXG = recommendBook.book_title;
            this.bZs = recommendBook.book_tips;
            this.bZt = recommendBook.botton_text;
            this.bZu = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bXF)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bZo;
    }
}
