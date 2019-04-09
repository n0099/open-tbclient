package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class r {
    private String author;
    private int bxN;
    private String bxZ;
    private String bya;
    private String byb;
    private String byc;
    private String byd;
    private String bye;
    private String byf;
    private long byg;
    private long byh;
    private long byi;
    private long byj;
    private long byk;
    private long byl;

    public String Xd() {
        return this.bxZ;
    }

    public int Xe() {
        return this.bxN;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bxZ = forumBookInfo.book_id;
            this.bxN = forumBookInfo.book_type.intValue();
            this.bya = forumBookInfo.book_title;
            this.byb = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.byc = forumBookInfo.forum_pic;
            this.byd = forumBookInfo.show_chapter_id;
            this.bye = forumBookInfo.show_chapter_no;
            this.byf = forumBookInfo.show_chapter_title;
            this.byg = forumBookInfo.history_page_id.longValue();
            this.byh = forumBookInfo.history_paragraph_id.longValue();
            this.byi = forumBookInfo.history_word_id.longValue();
            this.byj = forumBookInfo.history_percent.longValue();
            this.byk = forumBookInfo.show_page_id.longValue();
            this.byl = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
