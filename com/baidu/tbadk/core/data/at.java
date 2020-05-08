package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class at extends PostData {
    public static final BdUniqueId dps = BdUniqueId.gen();
    public String dnK;
    public String dnL;
    public String dnM;
    public int dny;
    public String dpt;
    public String dpu;
    public String dpv;
    public List<String> dpw;
    public String dpx;
    public String dpy;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.dpt = recommendBook.recommend_text;
            this.dpu = recommendBook.suggest_text;
            this.dpv = recommendBook.suggest_url;
            this.dnK = recommendBook.book_id;
            this.dny = recommendBook.book_type.intValue();
            this.dnM = recommendBook.book_cover;
            this.dnL = recommendBook.book_title;
            this.dpw = recommendBook.book_tips;
            this.dpx = recommendBook.botton_text;
            this.dpy = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.dnK)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dps;
    }
}
