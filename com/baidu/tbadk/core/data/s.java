package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes8.dex */
public class s {
    private String author;
    private long cOA;
    private int cOc;
    private String cOo;
    private String cOp;
    private String cOq;
    private String cOr;
    private String cOs;
    private String cOt;
    private String cOu;
    private long cOv;
    private long cOw;
    private long cOx;
    private long cOy;
    private long cOz;

    public String aAz() {
        return this.cOo;
    }

    public int aAA() {
        return this.cOc;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.cOo = forumBookInfo.book_id;
            this.cOc = forumBookInfo.book_type.intValue();
            this.cOp = forumBookInfo.book_title;
            this.cOq = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.cOr = forumBookInfo.forum_pic;
            this.cOs = forumBookInfo.show_chapter_id;
            this.cOt = forumBookInfo.show_chapter_no;
            this.cOu = forumBookInfo.show_chapter_title;
            this.cOv = forumBookInfo.history_page_id.longValue();
            this.cOw = forumBookInfo.history_paragraph_id.longValue();
            this.cOx = forumBookInfo.history_word_id.longValue();
            this.cOy = forumBookInfo.history_percent.longValue();
            this.cOz = forumBookInfo.show_page_id.longValue();
            this.cOA = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
