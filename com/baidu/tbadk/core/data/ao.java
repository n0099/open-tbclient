package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId asT = BdUniqueId.gen();
    public int aqS;
    public String are;
    public String arf;
    public String arg;
    public String asU;
    public String asV;
    public String asW;
    public List<String> asX;
    public String asY;
    public String asZ;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.asU = recommendBook.recommend_text;
            this.asV = recommendBook.suggest_text;
            this.asW = recommendBook.suggest_url;
            this.are = recommendBook.book_id;
            this.aqS = recommendBook.book_type.intValue();
            this.arg = recommendBook.book_cover;
            this.arf = recommendBook.book_title;
            this.asX = recommendBook.book_tips;
            this.asY = recommendBook.botton_text;
            this.asZ = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.are)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return asT;
    }
}
