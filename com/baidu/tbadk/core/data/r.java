package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class r {
    private String author;
    private int bxJ;
    private String bxV;
    private String bxW;
    private String bxX;
    private String bxY;
    private String bxZ;
    private String bya;
    private String byb;
    private long byc;
    private long byd;
    private long bye;
    private long byf;
    private long byg;
    private long byh;

    public String Xg() {
        return this.bxV;
    }

    public int Xh() {
        return this.bxJ;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bxV = forumBookInfo.book_id;
            this.bxJ = forumBookInfo.book_type.intValue();
            this.bxW = forumBookInfo.book_title;
            this.bxX = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.bxY = forumBookInfo.forum_pic;
            this.bxZ = forumBookInfo.show_chapter_id;
            this.bya = forumBookInfo.show_chapter_no;
            this.byb = forumBookInfo.show_chapter_title;
            this.byc = forumBookInfo.history_page_id.longValue();
            this.byd = forumBookInfo.history_paragraph_id.longValue();
            this.bye = forumBookInfo.history_word_id.longValue();
            this.byf = forumBookInfo.history_percent.longValue();
            this.byg = forumBookInfo.show_page_id.longValue();
            this.byh = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
