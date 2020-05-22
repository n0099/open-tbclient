package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class r {
    private String author;
    private String dBL;
    private String dBM;
    private String dBN;
    private String dBO;
    private String dBP;
    private String dBQ;
    private String dBR;
    private long dBS;
    private long dBT;
    private long dBU;
    private long dBV;
    private long dBW;
    private long dBX;
    private int dBz;

    public String aOI() {
        return this.dBL;
    }

    public int aOJ() {
        return this.dBz;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.dBL = forumBookInfo.book_id;
            this.dBz = forumBookInfo.book_type.intValue();
            this.dBM = forumBookInfo.book_title;
            this.dBN = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.dBO = forumBookInfo.forum_pic;
            this.dBP = forumBookInfo.show_chapter_id;
            this.dBQ = forumBookInfo.show_chapter_no;
            this.dBR = forumBookInfo.show_chapter_title;
            this.dBS = forumBookInfo.history_page_id.longValue();
            this.dBT = forumBookInfo.history_paragraph_id.longValue();
            this.dBU = forumBookInfo.history_word_id.longValue();
            this.dBV = forumBookInfo.history_percent.longValue();
            this.dBW = forumBookInfo.show_page_id.longValue();
            this.dBX = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
