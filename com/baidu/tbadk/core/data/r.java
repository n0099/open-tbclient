package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class r {
    private String author;
    private int bxH;
    private String bxT;
    private String bxU;
    private String bxV;
    private String bxW;
    private String bxX;
    private String bxY;
    private String bxZ;
    private long bya;
    private long byb;
    private long byc;
    private long byd;
    private long bye;
    private long byf;

    public String Xg() {
        return this.bxT;
    }

    public int Xh() {
        return this.bxH;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bxT = forumBookInfo.book_id;
            this.bxH = forumBookInfo.book_type.intValue();
            this.bxU = forumBookInfo.book_title;
            this.bxV = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.bxW = forumBookInfo.forum_pic;
            this.bxX = forumBookInfo.show_chapter_id;
            this.bxY = forumBookInfo.show_chapter_no;
            this.bxZ = forumBookInfo.show_chapter_title;
            this.bya = forumBookInfo.history_page_id.longValue();
            this.byb = forumBookInfo.history_paragraph_id.longValue();
            this.byc = forumBookInfo.history_word_id.longValue();
            this.byd = forumBookInfo.history_percent.longValue();
            this.bye = forumBookInfo.show_page_id.longValue();
            this.byf = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
