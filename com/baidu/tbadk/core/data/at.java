package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class at extends PostData {
    public static final BdUniqueId cPU = BdUniqueId.gen();
    public int cOb;
    public String cOn;
    public String cOo;
    public String cOp;
    public String cPV;
    public String cPW;
    public String cPX;
    public List<String> cPY;
    public String cPZ;
    public String cQa;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.cPV = recommendBook.recommend_text;
            this.cPW = recommendBook.suggest_text;
            this.cPX = recommendBook.suggest_url;
            this.cOn = recommendBook.book_id;
            this.cOb = recommendBook.book_type.intValue();
            this.cOp = recommendBook.book_cover;
            this.cOo = recommendBook.book_title;
            this.cPY = recommendBook.book_tips;
            this.cPZ = recommendBook.botton_text;
            this.cQa = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.cOn)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cPU;
    }
}
