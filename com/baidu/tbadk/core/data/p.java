package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class p {
    private String aLK;
    private String aLL;
    private String aLM;
    private String aLN;
    private String aLO;
    private String aLP;
    private String aLQ;
    private long aLR;
    private long aLS;
    private long aLT;
    private long aLU;
    private long aLV;
    private long aLW;
    private int aLy;
    private String author;

    public String xT() {
        return this.aLK;
    }

    public int xU() {
        return this.aLy;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.aLK = forumBookInfo.book_id;
            this.aLy = forumBookInfo.book_type.intValue();
            this.aLL = forumBookInfo.book_title;
            this.aLM = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.aLN = forumBookInfo.forum_pic;
            this.aLO = forumBookInfo.show_chapter_id;
            this.aLP = forumBookInfo.show_chapter_no;
            this.aLQ = forumBookInfo.show_chapter_title;
            this.aLR = forumBookInfo.history_page_id.longValue();
            this.aLS = forumBookInfo.history_paragraph_id.longValue();
            this.aLT = forumBookInfo.history_word_id.longValue();
            this.aLU = forumBookInfo.history_percent.longValue();
            this.aLV = forumBookInfo.show_page_id.longValue();
            this.aLW = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
