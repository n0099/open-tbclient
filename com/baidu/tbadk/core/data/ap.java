package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ap extends PostData {
    public static final BdUniqueId agW = BdUniqueId.gen();
    public int aeW;
    public String afi;
    public String afj;
    public String afk;
    public String agX;
    public String agY;
    public String agZ;
    public List<String> aha;
    public String ahb;
    public String ahc;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.agX = recommendBook.recommend_text;
            this.agY = recommendBook.suggest_text;
            this.agZ = recommendBook.suggest_url;
            this.afi = recommendBook.book_id;
            this.aeW = recommendBook.book_type.intValue();
            this.afk = recommendBook.book_cover;
            this.afj = recommendBook.book_title;
            this.aha = recommendBook.book_tips;
            this.ahb = recommendBook.botton_text;
            this.ahc = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.afi)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return agW;
    }
}
