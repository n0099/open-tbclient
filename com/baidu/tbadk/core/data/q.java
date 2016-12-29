package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class q {
    private String QA;
    private String QB;
    private String QC;
    private String QD;
    private String QE;
    private long QF;
    private long QG;
    private long QH;
    private long QI;
    private long QJ;
    private long QK;
    private int Qn;
    private String Qz;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int pB() {
        return this.Qn;
    }

    public String pC() {
        return this.QA;
    }

    public String pD() {
        return this.author;
    }

    public long pE() {
        return this.QF;
    }

    public String pF() {
        return this.QE;
    }

    public String pG() {
        return this.QD;
    }

    public String pH() {
        return this.QC;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.Qn = forumBookInfo.book_type.intValue();
            this.Qz = forumBookInfo.book_title;
            this.QA = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.QB = forumBookInfo.forum_pic;
            this.QC = forumBookInfo.show_chapter_id;
            this.QD = forumBookInfo.show_chapter_no;
            this.QE = forumBookInfo.show_chapter_title;
            this.QF = forumBookInfo.history_page_id.longValue();
            this.QG = forumBookInfo.history_paragraph_id.longValue();
            this.QH = forumBookInfo.history_word_id.longValue();
            this.QI = forumBookInfo.history_percent.longValue();
            this.QJ = forumBookInfo.show_page_id.longValue();
            this.QK = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
