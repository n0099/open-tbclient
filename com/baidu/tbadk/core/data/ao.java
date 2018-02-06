package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId aND = BdUniqueId.gen();
    public int aLJ;
    public String aLV;
    public String aLW;
    public String aLX;
    public String aNE;
    public String aNF;
    public String aNG;
    public List<String> aNH;
    public String aNI;
    public String aNJ;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aNE = recommendBook.recommend_text;
            this.aNF = recommendBook.suggest_text;
            this.aNG = recommendBook.suggest_url;
            this.aLV = recommendBook.book_id;
            this.aLJ = recommendBook.book_type.intValue();
            this.aLX = recommendBook.book_cover;
            this.aLW = recommendBook.book_title;
            this.aNH = recommendBook.book_tips;
            this.aNI = recommendBook.botton_text;
            this.aNJ = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.aLV)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aND;
    }
}
