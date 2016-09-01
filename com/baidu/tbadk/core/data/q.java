package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class q {
    private int Qa;
    private String Qm;
    private String Qn;
    private String Qo;
    private String Qp;
    private String Qq;
    private String Qr;
    private long Qs;
    private long Qt;
    private long Qu;
    private long Qv;
    private long Qw;
    private long Qx;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int px() {
        return this.Qa;
    }

    public String py() {
        return this.Qn;
    }

    public String pz() {
        return this.author;
    }

    public long pA() {
        return this.Qs;
    }

    public String pB() {
        return this.Qr;
    }

    public String pC() {
        return this.Qq;
    }

    public String pD() {
        return this.Qp;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.Qa = forumBookInfo.book_type.intValue();
            this.Qm = forumBookInfo.book_title;
            this.Qn = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Qo = forumBookInfo.forum_pic;
            this.Qp = forumBookInfo.show_chapter_id;
            this.Qq = forumBookInfo.show_chapter_no;
            this.Qr = forumBookInfo.show_chapter_title;
            this.Qs = forumBookInfo.history_page_idhistory_page_id.longValue();
            this.Qt = forumBookInfo.history_paragraph_id.longValue();
            this.Qu = forumBookInfo.history_word_id.longValue();
            this.Qv = forumBookInfo.history_percent.longValue();
            this.Qw = forumBookInfo.show_page_id.longValue();
            this.Qx = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
