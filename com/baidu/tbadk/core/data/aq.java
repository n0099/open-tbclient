package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class aq extends PostData {
    public static final BdUniqueId bIy = BdUniqueId.gen();
    public String bGL;
    public String bGM;
    public String bGN;
    public int bGz;
    public String bIA;
    public String bIB;
    public List<String> bIC;
    public String bID;
    public String bIE;
    public String bIz;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bIz = recommendBook.recommend_text;
            this.bIA = recommendBook.suggest_text;
            this.bIB = recommendBook.suggest_url;
            this.bGL = recommendBook.book_id;
            this.bGz = recommendBook.book_type.intValue();
            this.bGN = recommendBook.book_cover;
            this.bGM = recommendBook.book_title;
            this.bIC = recommendBook.book_tips;
            this.bID = recommendBook.botton_text;
            this.bIE = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bGL)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bIy;
    }
}
