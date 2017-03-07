package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private String UW;
    private String UX;
    private String UY;
    private String UZ;
    private int Uy;
    private String Va;
    private String Vb;
    private long Vc;
    private long Vd;
    private long Ve;
    private long Vf;
    private long Vg;
    private long Vh;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int pM() {
        return this.Uy;
    }

    public String pN() {
        return this.UX;
    }

    public String pO() {
        return this.author;
    }

    public long pP() {
        return this.Vc;
    }

    public String pQ() {
        return this.Vb;
    }

    public String pR() {
        return this.Va;
    }

    public String pS() {
        return this.UZ;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.Uy = forumBookInfo.book_type.intValue();
            this.UW = forumBookInfo.book_title;
            this.UX = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.UY = forumBookInfo.forum_pic;
            this.UZ = forumBookInfo.show_chapter_id;
            this.Va = forumBookInfo.show_chapter_no;
            this.Vb = forumBookInfo.show_chapter_title;
            this.Vc = forumBookInfo.history_page_id.longValue();
            this.Vd = forumBookInfo.history_paragraph_id.longValue();
            this.Ve = forumBookInfo.history_word_id.longValue();
            this.Vf = forumBookInfo.history_percent.longValue();
            this.Vg = forumBookInfo.show_page_id.longValue();
            this.Vh = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
