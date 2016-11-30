package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class r {
    private String QC;
    private String QD;
    private String QE;
    private String QF;
    private String QG;
    private String QH;
    private long QI;
    private long QJ;
    private long QK;
    private long QL;
    private long QM;
    private long QN;
    private int Qq;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int pB() {
        return this.Qq;
    }

    public String pC() {
        return this.QD;
    }

    public String pD() {
        return this.author;
    }

    public long pE() {
        return this.QI;
    }

    public String pF() {
        return this.QH;
    }

    public String pG() {
        return this.QG;
    }

    public String pH() {
        return this.QF;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.Qq = forumBookInfo.book_type.intValue();
            this.QC = forumBookInfo.book_title;
            this.QD = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.QE = forumBookInfo.forum_pic;
            this.QF = forumBookInfo.show_chapter_id;
            this.QG = forumBookInfo.show_chapter_no;
            this.QH = forumBookInfo.show_chapter_title;
            this.QI = forumBookInfo.history_page_id.longValue();
            this.QJ = forumBookInfo.history_paragraph_id.longValue();
            this.QK = forumBookInfo.history_word_id.longValue();
            this.QL = forumBookInfo.history_percent.longValue();
            this.QM = forumBookInfo.show_page_id.longValue();
            this.QN = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
