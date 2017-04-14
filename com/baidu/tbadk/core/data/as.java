package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class as extends PostData {
    public static final BdUniqueId Xg = BdUniqueId.gen();
    public int UT;
    public String Vp;
    public String Vq;
    public String Xh;
    public String Xi;
    public String Xj;
    public List<String> Xk;
    public String Xl;
    public String Xm;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Xh = recommendBook.recommend_text;
            this.Xi = recommendBook.suggest_text;
            this.Xj = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.UT = recommendBook.book_type.intValue();
            this.Vq = recommendBook.book_cover;
            this.Vp = recommendBook.book_title;
            this.Xk = recommendBook.book_tips;
            this.Xl = recommendBook.botton_text;
            this.Xm = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Xg;
    }
}
