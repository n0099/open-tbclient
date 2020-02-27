package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes8.dex */
public class s {
    private String author;
    private int cOa;
    private String cOm;
    private String cOn;
    private String cOo;
    private String cOp;
    private String cOq;
    private String cOr;
    private String cOs;
    private long cOt;
    private long cOu;
    private long cOv;
    private long cOw;
    private long cOx;
    private long cOy;

    public String aAx() {
        return this.cOm;
    }

    public int aAy() {
        return this.cOa;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.cOm = forumBookInfo.book_id;
            this.cOa = forumBookInfo.book_type.intValue();
            this.cOn = forumBookInfo.book_title;
            this.cOo = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.cOp = forumBookInfo.forum_pic;
            this.cOq = forumBookInfo.show_chapter_id;
            this.cOr = forumBookInfo.show_chapter_no;
            this.cOs = forumBookInfo.show_chapter_title;
            this.cOt = forumBookInfo.history_page_id.longValue();
            this.cOu = forumBookInfo.history_paragraph_id.longValue();
            this.cOv = forumBookInfo.history_word_id.longValue();
            this.cOw = forumBookInfo.history_percent.longValue();
            this.cOx = forumBookInfo.show_page_id.longValue();
            this.cOy = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
