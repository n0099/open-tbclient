package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId aMh = BdUniqueId.gen();
    public String aKA;
    public int aKm;
    public String aKy;
    public String aKz;
    public String aMi;
    public String aMj;
    public String aMk;
    public List<String> aMl;
    public String aMm;
    public String aMn;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aMi = recommendBook.recommend_text;
            this.aMj = recommendBook.suggest_text;
            this.aMk = recommendBook.suggest_url;
            this.aKy = recommendBook.book_id;
            this.aKm = recommendBook.book_type.intValue();
            this.aKA = recommendBook.book_cover;
            this.aKz = recommendBook.book_title;
            this.aMl = recommendBook.book_tips;
            this.aMm = recommendBook.botton_text;
            this.aMn = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.aKy)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMh;
    }
}
