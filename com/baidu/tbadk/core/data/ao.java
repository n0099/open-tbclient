package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId asr = BdUniqueId.gen();
    public String aqC;
    public String aqD;
    public String aqE;
    public int aqq;
    public String ass;
    public String ast;
    public String asu;
    public List<String> asv;
    public String asw;
    public String asx;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.ass = recommendBook.recommend_text;
            this.ast = recommendBook.suggest_text;
            this.asu = recommendBook.suggest_url;
            this.aqC = recommendBook.book_id;
            this.aqq = recommendBook.book_type.intValue();
            this.aqE = recommendBook.book_cover;
            this.aqD = recommendBook.book_title;
            this.asv = recommendBook.book_tips;
            this.asw = recommendBook.botton_text;
            this.asx = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.aqC)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return asr;
    }
}
