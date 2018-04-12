package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class q {
    private int WU;
    private String Xg;
    private String Xh;
    private String Xi;
    private String Xj;
    private String Xk;
    private String Xl;
    private String Xm;
    private long Xn;
    private long Xo;
    private long Xp;
    private long Xq;
    private long Xr;
    private long Xs;
    private String author;

    public String qA() {
        return this.Xg;
    }

    public int getBookType() {
        return this.WU;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.Xg = forumBookInfo.book_id;
            this.WU = forumBookInfo.book_type.intValue();
            this.Xh = forumBookInfo.book_title;
            this.Xi = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Xj = forumBookInfo.forum_pic;
            this.Xk = forumBookInfo.show_chapter_id;
            this.Xl = forumBookInfo.show_chapter_no;
            this.Xm = forumBookInfo.show_chapter_title;
            this.Xn = forumBookInfo.history_page_id.longValue();
            this.Xo = forumBookInfo.history_paragraph_id.longValue();
            this.Xp = forumBookInfo.history_word_id.longValue();
            this.Xq = forumBookInfo.history_percent.longValue();
            this.Xr = forumBookInfo.show_page_id.longValue();
            this.Xs = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
