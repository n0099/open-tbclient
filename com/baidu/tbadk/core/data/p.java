package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class p {
    private String aLL;
    private String aLM;
    private String aLN;
    private String aLO;
    private String aLP;
    private String aLQ;
    private String aLR;
    private long aLS;
    private long aLT;
    private long aLU;
    private long aLV;
    private long aLW;
    private long aLX;
    private int aLz;
    private String author;

    public String xT() {
        return this.aLL;
    }

    public int xU() {
        return this.aLz;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.aLL = forumBookInfo.book_id;
            this.aLz = forumBookInfo.book_type.intValue();
            this.aLM = forumBookInfo.book_title;
            this.aLN = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.aLO = forumBookInfo.forum_pic;
            this.aLP = forumBookInfo.show_chapter_id;
            this.aLQ = forumBookInfo.show_chapter_no;
            this.aLR = forumBookInfo.show_chapter_title;
            this.aLS = forumBookInfo.history_page_id.longValue();
            this.aLT = forumBookInfo.history_paragraph_id.longValue();
            this.aLU = forumBookInfo.history_word_id.longValue();
            this.aLV = forumBookInfo.history_percent.longValue();
            this.aLW = forumBookInfo.show_page_id.longValue();
            this.aLX = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
