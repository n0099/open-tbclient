package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class az extends PostData {
    public static final BdUniqueId eCa = BdUniqueId.gen();
    public String eAt;
    public String eAu;
    public String eAv;
    public String eCb;
    public String eCc;
    public String eCd;
    public List<String> eCe;
    public String eCf;
    public String eCg;
    public int ezV;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.eCb = recommendBook.recommend_text;
            this.eCc = recommendBook.suggest_text;
            this.eCd = recommendBook.suggest_url;
            this.eAt = recommendBook.book_id;
            this.ezV = recommendBook.book_type.intValue();
            this.eAv = recommendBook.book_cover;
            this.eAu = recommendBook.book_title;
            this.eCe = recommendBook.book_tips;
            this.eCf = recommendBook.botton_text;
            this.eCg = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.eAt)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eCa;
    }
}
