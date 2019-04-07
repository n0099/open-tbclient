package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class r {
    private String author;
    private int bxM;
    private String bxY;
    private String bxZ;
    private String bya;
    private String byb;
    private String byc;
    private String byd;
    private String bye;
    private long byf;
    private long byg;
    private long byh;
    private long byi;
    private long byj;
    private long byk;

    public String Xd() {
        return this.bxY;
    }

    public int Xe() {
        return this.bxM;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bxY = forumBookInfo.book_id;
            this.bxM = forumBookInfo.book_type.intValue();
            this.bxZ = forumBookInfo.book_title;
            this.bya = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.byb = forumBookInfo.forum_pic;
            this.byc = forumBookInfo.show_chapter_id;
            this.byd = forumBookInfo.show_chapter_no;
            this.bye = forumBookInfo.show_chapter_title;
            this.byf = forumBookInfo.history_page_id.longValue();
            this.byg = forumBookInfo.history_paragraph_id.longValue();
            this.byh = forumBookInfo.history_word_id.longValue();
            this.byi = forumBookInfo.history_percent.longValue();
            this.byj = forumBookInfo.show_page_id.longValue();
            this.byk = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
