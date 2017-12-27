package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ap extends PostData {
    public static final BdUniqueId aMl = BdUniqueId.gen();
    public String aKA;
    public String aKB;
    public String aKC;
    public int aKo;
    public String aMm;
    public String aMn;
    public String aMo;
    public List<String> aMp;
    public String aMq;
    public String aMr;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aMm = recommendBook.recommend_text;
            this.aMn = recommendBook.suggest_text;
            this.aMo = recommendBook.suggest_url;
            this.aKA = recommendBook.book_id;
            this.aKo = recommendBook.book_type.intValue();
            this.aKC = recommendBook.book_cover;
            this.aKB = recommendBook.book_title;
            this.aMp = recommendBook.book_tips;
            this.aMq = recommendBook.botton_text;
            this.aMr = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.aKA)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMl;
    }
}
