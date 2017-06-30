package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class av extends PostData {
    public static final BdUniqueId Wu = BdUniqueId.gen();
    public int TY;
    public String Uu;
    public String Uv;
    public String WA;
    public String Wv;
    public String Ww;
    public String Wx;
    public List<String> Wy;
    public String Wz;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Wv = recommendBook.recommend_text;
            this.Ww = recommendBook.suggest_text;
            this.Wx = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.TY = recommendBook.book_type.intValue();
            this.Uv = recommendBook.book_cover;
            this.Uu = recommendBook.book_title;
            this.Wy = recommendBook.book_tips;
            this.Wz = recommendBook.botton_text;
            this.WA = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Wu;
    }
}
