package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class r {
    private String author;
    private String bYA;
    private String bYB;
    private String bYC;
    private long bYD;
    private long bYE;
    private long bYF;
    private long bYG;
    private long bYH;
    private long bYI;
    private int bYk;
    private String bYw;
    private String bYx;
    private String bYy;
    private String bYz;

    public String agY() {
        return this.bYw;
    }

    public int agZ() {
        return this.bYk;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bYw = forumBookInfo.book_id;
            this.bYk = forumBookInfo.book_type.intValue();
            this.bYx = forumBookInfo.book_title;
            this.bYy = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.bYz = forumBookInfo.forum_pic;
            this.bYA = forumBookInfo.show_chapter_id;
            this.bYB = forumBookInfo.show_chapter_no;
            this.bYC = forumBookInfo.show_chapter_title;
            this.bYD = forumBookInfo.history_page_id.longValue();
            this.bYE = forumBookInfo.history_paragraph_id.longValue();
            this.bYF = forumBookInfo.history_word_id.longValue();
            this.bYG = forumBookInfo.history_percent.longValue();
            this.bYH = forumBookInfo.show_page_id.longValue();
            this.bYI = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
