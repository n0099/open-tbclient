package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class p {
    private int aLJ;
    private String aLV;
    private String aLW;
    private String aLX;
    private String aLY;
    private String aLZ;
    private String aMa;
    private String aMb;
    private long aMc;
    private long aMd;
    private long aMe;
    private long aMf;
    private long aMg;
    private long aMh;
    private String author;

    public String xT() {
        return this.aLV;
    }

    public int xU() {
        return this.aLJ;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.aLV = forumBookInfo.book_id;
            this.aLJ = forumBookInfo.book_type.intValue();
            this.aLW = forumBookInfo.book_title;
            this.aLX = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.aLY = forumBookInfo.forum_pic;
            this.aLZ = forumBookInfo.show_chapter_id;
            this.aMa = forumBookInfo.show_chapter_no;
            this.aMb = forumBookInfo.show_chapter_title;
            this.aMc = forumBookInfo.history_page_id.longValue();
            this.aMd = forumBookInfo.history_paragraph_id.longValue();
            this.aMe = forumBookInfo.history_word_id.longValue();
            this.aMf = forumBookInfo.history_percent.longValue();
            this.aMg = forumBookInfo.show_page_id.longValue();
            this.aMh = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
