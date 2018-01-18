package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class p {
    private String aKA;
    private String aKB;
    private String aKC;
    private String aKD;
    private String aKE;
    private long aKF;
    private long aKG;
    private long aKH;
    private long aKI;
    private long aKJ;
    private long aKK;
    private int aKm;
    private String aKy;
    private String aKz;
    private String author;

    public String xm() {
        return this.aKy;
    }

    public int xn() {
        return this.aKm;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.aKy = forumBookInfo.book_id;
            this.aKm = forumBookInfo.book_type.intValue();
            this.aKz = forumBookInfo.book_title;
            this.aKA = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.aKB = forumBookInfo.forum_pic;
            this.aKC = forumBookInfo.show_chapter_id;
            this.aKD = forumBookInfo.show_chapter_no;
            this.aKE = forumBookInfo.show_chapter_title;
            this.aKF = forumBookInfo.history_page_id.longValue();
            this.aKG = forumBookInfo.history_paragraph_id.longValue();
            this.aKH = forumBookInfo.history_word_id.longValue();
            this.aKI = forumBookInfo.history_percent.longValue();
            this.aKJ = forumBookInfo.show_page_id.longValue();
            this.aKK = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
