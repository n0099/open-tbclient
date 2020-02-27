package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class at extends PostData {
    public static final BdUniqueId cPT = BdUniqueId.gen();
    public int cOa;
    public String cOm;
    public String cOn;
    public String cOo;
    public String cPU;
    public String cPV;
    public String cPW;
    public List<String> cPX;
    public String cPY;
    public String cPZ;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.cPU = recommendBook.recommend_text;
            this.cPV = recommendBook.suggest_text;
            this.cPW = recommendBook.suggest_url;
            this.cOm = recommendBook.book_id;
            this.cOa = recommendBook.book_type.intValue();
            this.cOo = recommendBook.book_cover;
            this.cOn = recommendBook.book_title;
            this.cPX = recommendBook.book_tips;
            this.cPY = recommendBook.botton_text;
            this.cPZ = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.cOm)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cPT;
    }
}
