package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class au extends PostData {
    public static final BdUniqueId Yj = BdUniqueId.gen();
    public int VQ;
    public String Wl;
    public String Wm;
    public String Yk;
    public String Yl;
    public String Ym;
    public List<String> Yn;
    public String Yo;
    public String Yp;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Yk = recommendBook.recommend_text;
            this.Yl = recommendBook.suggest_text;
            this.Ym = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.VQ = recommendBook.book_type.intValue();
            this.Wm = recommendBook.book_cover;
            this.Wl = recommendBook.book_title;
            this.Yn = recommendBook.book_tips;
            this.Yo = recommendBook.botton_text;
            this.Yp = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yj;
    }
}
