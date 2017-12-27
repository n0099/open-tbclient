package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class p {
    private String aKA;
    private String aKB;
    private String aKC;
    private String aKD;
    private String aKE;
    private String aKF;
    private String aKG;
    private long aKH;
    private long aKI;
    private long aKJ;
    private long aKK;
    private long aKL;
    private long aKM;
    private int aKo;
    private String author;

    public String xn() {
        return this.aKA;
    }

    public int xo() {
        return this.aKo;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.aKA = forumBookInfo.book_id;
            this.aKo = forumBookInfo.book_type.intValue();
            this.aKB = forumBookInfo.book_title;
            this.aKC = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.aKD = forumBookInfo.forum_pic;
            this.aKE = forumBookInfo.show_chapter_id;
            this.aKF = forumBookInfo.show_chapter_no;
            this.aKG = forumBookInfo.show_chapter_title;
            this.aKH = forumBookInfo.history_page_id.longValue();
            this.aKI = forumBookInfo.history_paragraph_id.longValue();
            this.aKJ = forumBookInfo.history_word_id.longValue();
            this.aKK = forumBookInfo.history_percent.longValue();
            this.aKL = forumBookInfo.show_page_id.longValue();
            this.aKM = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
