package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class q {
    private int PY;
    private String Qk;
    private String Ql;
    private String Qm;
    private String Qn;
    private String Qo;
    private String Qp;
    private long Qq;
    private long Qr;
    private long Qs;
    private long Qt;
    private long Qu;
    private long Qv;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int py() {
        return this.PY;
    }

    public String pz() {
        return this.Ql;
    }

    public String pA() {
        return this.author;
    }

    public long pB() {
        return this.Qq;
    }

    public String pC() {
        return this.Qp;
    }

    public String pD() {
        return this.Qo;
    }

    public String pE() {
        return this.Qn;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.PY = forumBookInfo.book_type.intValue();
            this.Qk = forumBookInfo.book_title;
            this.Ql = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Qm = forumBookInfo.forum_pic;
            this.Qn = forumBookInfo.show_chapter_id;
            this.Qo = forumBookInfo.show_chapter_no;
            this.Qp = forumBookInfo.show_chapter_title;
            this.Qq = forumBookInfo.history_page_id.longValue();
            this.Qr = forumBookInfo.history_paragraph_id.longValue();
            this.Qs = forumBookInfo.history_word_id.longValue();
            this.Qt = forumBookInfo.history_percent.longValue();
            this.Qu = forumBookInfo.show_page_id.longValue();
            this.Qv = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
