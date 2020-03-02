package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes8.dex */
public class s {
    private String author;
    private int cOb;
    private String cOn;
    private String cOo;
    private String cOp;
    private String cOq;
    private String cOr;
    private String cOs;
    private String cOt;
    private long cOu;
    private long cOv;
    private long cOw;
    private long cOx;
    private long cOy;
    private long cOz;

    public String aAz() {
        return this.cOn;
    }

    public int aAA() {
        return this.cOb;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.cOn = forumBookInfo.book_id;
            this.cOb = forumBookInfo.book_type.intValue();
            this.cOo = forumBookInfo.book_title;
            this.cOp = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.cOq = forumBookInfo.forum_pic;
            this.cOr = forumBookInfo.show_chapter_id;
            this.cOs = forumBookInfo.show_chapter_no;
            this.cOt = forumBookInfo.show_chapter_title;
            this.cOu = forumBookInfo.history_page_id.longValue();
            this.cOv = forumBookInfo.history_paragraph_id.longValue();
            this.cOw = forumBookInfo.history_word_id.longValue();
            this.cOx = forumBookInfo.history_percent.longValue();
            this.cOy = forumBookInfo.show_page_id.longValue();
            this.cOz = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
