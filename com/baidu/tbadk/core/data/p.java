package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class p {
    private String aKB;
    private String aKC;
    private String aKD;
    private String aKE;
    private String aKF;
    private String aKG;
    private String aKH;
    private long aKI;
    private long aKJ;
    private long aKK;
    private long aKL;
    private long aKM;
    private long aKN;
    private int aKp;
    private String author;

    public String xn() {
        return this.aKB;
    }

    public int xo() {
        return this.aKp;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.aKB = forumBookInfo.book_id;
            this.aKp = forumBookInfo.book_type.intValue();
            this.aKC = forumBookInfo.book_title;
            this.aKD = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.aKE = forumBookInfo.forum_pic;
            this.aKF = forumBookInfo.show_chapter_id;
            this.aKG = forumBookInfo.show_chapter_no;
            this.aKH = forumBookInfo.show_chapter_title;
            this.aKI = forumBookInfo.history_page_id.longValue();
            this.aKJ = forumBookInfo.history_paragraph_id.longValue();
            this.aKK = forumBookInfo.history_word_id.longValue();
            this.aKL = forumBookInfo.history_percent.longValue();
            this.aKM = forumBookInfo.show_page_id.longValue();
            this.aKN = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
