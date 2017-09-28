package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class as extends PostData {
    public static final BdUniqueId Xs = BdUniqueId.gen();
    public String VD;
    public String VE;
    public String VF;
    public int Vh;
    public String Xt;
    public String Xu;
    public String Xv;
    public List<String> Xw;
    public String Xx;
    public String Xy;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Xt = recommendBook.recommend_text;
            this.Xu = recommendBook.suggest_text;
            this.Xv = recommendBook.suggest_url;
            this.VD = recommendBook.book_id;
            this.Vh = recommendBook.book_type.intValue();
            this.VF = recommendBook.book_cover;
            this.VE = recommendBook.book_title;
            this.Xw = recommendBook.book_tips;
            this.Xx = recommendBook.botton_text;
            this.Xy = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.VD)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Xs;
    }
}
