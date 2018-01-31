package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId aMk = BdUniqueId.gen();
    public String aKB;
    public String aKC;
    public String aKD;
    public int aKp;
    public String aMl;
    public String aMm;
    public String aMn;
    public List<String> aMo;
    public String aMp;
    public String aMq;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aMl = recommendBook.recommend_text;
            this.aMm = recommendBook.suggest_text;
            this.aMn = recommendBook.suggest_url;
            this.aKB = recommendBook.book_id;
            this.aKp = recommendBook.book_type.intValue();
            this.aKD = recommendBook.book_cover;
            this.aKC = recommendBook.book_title;
            this.aMo = recommendBook.book_tips;
            this.aMp = recommendBook.botton_text;
            this.aMq = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.aKB)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMk;
    }
}
