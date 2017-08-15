package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class au extends PostData {
    public static final BdUniqueId Yi = BdUniqueId.gen();
    public int VP;
    public String Wk;
    public String Wl;
    public String Yj;
    public String Yk;
    public String Yl;
    public List<String> Ym;
    public String Yn;
    public String Yo;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Yj = recommendBook.recommend_text;
            this.Yk = recommendBook.suggest_text;
            this.Yl = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.VP = recommendBook.book_type.intValue();
            this.Wl = recommendBook.book_cover;
            this.Wk = recommendBook.book_title;
            this.Ym = recommendBook.book_tips;
            this.Yn = recommendBook.botton_text;
            this.Yo = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yi;
    }
}
