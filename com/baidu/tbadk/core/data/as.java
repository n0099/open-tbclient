package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class as extends PostData {
    public static final BdUniqueId Xh = BdUniqueId.gen();
    public int UV;
    public String Vr;
    public String Vs;
    public String Xi;
    public String Xj;
    public String Xk;
    public List<String> Xl;
    public String Xm;
    public String Xn;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Xi = recommendBook.recommend_text;
            this.Xj = recommendBook.suggest_text;
            this.Xk = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.UV = recommendBook.book_type.intValue();
            this.Vs = recommendBook.book_cover;
            this.Vr = recommendBook.book_title;
            this.Xl = recommendBook.book_tips;
            this.Xm = recommendBook.botton_text;
            this.Xn = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Xh;
    }
}
