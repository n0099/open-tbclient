package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class w {
    private String author;
    private long eAA;
    private long eAB;
    private long eAC;
    private long eAD;
    private long eAE;
    private long eAF;
    private String eAt;
    private String eAu;
    private String eAv;
    private String eAw;
    private String eAx;
    private String eAy;
    private String eAz;
    private int ezV;

    public String bkG() {
        return this.eAt;
    }

    public int bkH() {
        return this.ezV;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.eAt = forumBookInfo.book_id;
            this.ezV = forumBookInfo.book_type.intValue();
            this.eAu = forumBookInfo.book_title;
            this.eAv = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.eAw = forumBookInfo.forum_pic;
            this.eAx = forumBookInfo.show_chapter_id;
            this.eAy = forumBookInfo.show_chapter_no;
            this.eAz = forumBookInfo.show_chapter_title;
            this.eAA = forumBookInfo.history_page_id.longValue();
            this.eAB = forumBookInfo.history_paragraph_id.longValue();
            this.eAC = forumBookInfo.history_word_id.longValue();
            this.eAD = forumBookInfo.history_percent.longValue();
            this.eAE = forumBookInfo.show_page_id.longValue();
            this.eAF = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
