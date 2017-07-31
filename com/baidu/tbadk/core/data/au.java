package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class au extends PostData {
    public static final BdUniqueId Yg = BdUniqueId.gen();
    public int VN;
    public String Wi;
    public String Wj;
    public String Yh;
    public String Yi;
    public String Yj;
    public List<String> Yk;
    public String Yl;
    public String Ym;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Yh = recommendBook.recommend_text;
            this.Yi = recommendBook.suggest_text;
            this.Yj = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.VN = recommendBook.book_type.intValue();
            this.Wj = recommendBook.book_cover;
            this.Wi = recommendBook.book_title;
            this.Yk = recommendBook.book_tips;
            this.Yl = recommendBook.botton_text;
            this.Ym = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yg;
    }
}
