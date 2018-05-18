package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class q {
    private int WV;
    private String Xh;
    private String Xi;
    private String Xj;
    private String Xk;
    private String Xl;
    private String Xm;
    private String Xn;
    private long Xo;
    private long Xp;
    private long Xq;
    private long Xr;
    private long Xs;
    private long Xt;
    private String author;

    public String qz() {
        return this.Xh;
    }

    public int getBookType() {
        return this.WV;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.Xh = forumBookInfo.book_id;
            this.WV = forumBookInfo.book_type.intValue();
            this.Xi = forumBookInfo.book_title;
            this.Xj = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Xk = forumBookInfo.forum_pic;
            this.Xl = forumBookInfo.show_chapter_id;
            this.Xm = forumBookInfo.show_chapter_no;
            this.Xn = forumBookInfo.show_chapter_title;
            this.Xo = forumBookInfo.history_page_id.longValue();
            this.Xp = forumBookInfo.history_paragraph_id.longValue();
            this.Xq = forumBookInfo.history_word_id.longValue();
            this.Xr = forumBookInfo.history_percent.longValue();
            this.Xs = forumBookInfo.show_page_id.longValue();
            this.Xt = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
