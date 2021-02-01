package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class y {
    private String author;
    private int eMC;
    private String eNa;
    private String eNb;
    private String eNc;
    private String eNd;
    private String eNe;
    private String eNf;
    private String eNg;
    private long eNh;
    private long eNi;
    private long eNj;
    private long eNk;
    private long eNl;
    private long eNm;

    public String blT() {
        return this.eNa;
    }

    public int blU() {
        return this.eMC;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.eNa = forumBookInfo.book_id;
            this.eMC = forumBookInfo.book_type.intValue();
            this.eNb = forumBookInfo.book_title;
            this.eNc = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.eNd = forumBookInfo.forum_pic;
            this.eNe = forumBookInfo.show_chapter_id;
            this.eNf = forumBookInfo.show_chapter_no;
            this.eNg = forumBookInfo.show_chapter_title;
            this.eNh = forumBookInfo.history_page_id.longValue();
            this.eNi = forumBookInfo.history_paragraph_id.longValue();
            this.eNj = forumBookInfo.history_word_id.longValue();
            this.eNk = forumBookInfo.history_percent.longValue();
            this.eNl = forumBookInfo.show_page_id.longValue();
            this.eNm = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
