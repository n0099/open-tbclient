package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class as extends PostData {
    public static final BdUniqueId Xy = BdUniqueId.gen();
    public String VJ;
    public String VK;
    public String VL;
    public int Vn;
    public String XA;
    public String XB;
    public List<String> XC;
    public String XD;
    public String XE;
    public String Xz;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Xz = recommendBook.recommend_text;
            this.XA = recommendBook.suggest_text;
            this.XB = recommendBook.suggest_url;
            this.VJ = recommendBook.book_id;
            this.Vn = recommendBook.book_type.intValue();
            this.VL = recommendBook.book_cover;
            this.VK = recommendBook.book_title;
            this.XC = recommendBook.book_tips;
            this.XD = recommendBook.botton_text;
            this.XE = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.VJ)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Xy;
    }
}
