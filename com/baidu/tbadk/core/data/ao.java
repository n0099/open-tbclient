package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId asU = BdUniqueId.gen();
    public int aqT;
    public String arf;
    public String arg;
    public String arh;
    public String asV;
    public String asW;
    public String asX;
    public List<String> asY;
    public String asZ;
    public String ata;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.asV = recommendBook.recommend_text;
            this.asW = recommendBook.suggest_text;
            this.asX = recommendBook.suggest_url;
            this.arf = recommendBook.book_id;
            this.aqT = recommendBook.book_type.intValue();
            this.arh = recommendBook.book_cover;
            this.arg = recommendBook.book_title;
            this.asY = recommendBook.book_tips;
            this.asZ = recommendBook.botton_text;
            this.ata = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.arf)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return asU;
    }
}
