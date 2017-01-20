package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class r {
    private String PJ;
    private String PK;
    private String PL;
    private String PM;
    private String PN;
    private String PO;
    private long PP;
    private long PQ;
    private long PR;
    private long PS;
    private long PT;
    private long PU;
    private int Pw;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int pu() {
        return this.Pw;
    }

    public String pv() {
        return this.PK;
    }

    public String pw() {
        return this.author;
    }

    public long px() {
        return this.PP;
    }

    public String py() {
        return this.PO;
    }

    public String pz() {
        return this.PN;
    }

    public String pA() {
        return this.PM;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.Pw = forumBookInfo.book_type.intValue();
            this.PJ = forumBookInfo.book_title;
            this.PK = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.PL = forumBookInfo.forum_pic;
            this.PM = forumBookInfo.show_chapter_id;
            this.PN = forumBookInfo.show_chapter_no;
            this.PO = forumBookInfo.show_chapter_title;
            this.PP = forumBookInfo.history_page_id.longValue();
            this.PQ = forumBookInfo.history_paragraph_id.longValue();
            this.PR = forumBookInfo.history_word_id.longValue();
            this.PS = forumBookInfo.history_percent.longValue();
            this.PT = forumBookInfo.show_page_id.longValue();
            this.PU = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
