package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes6.dex */
public class p {
    private long amA;
    private int amc;
    private String amo;
    private String amp;
    private String amq;
    private String amr;
    private String ams;
    private String amt;
    private String amu;
    private long amv;
    private long amw;
    private long amx;
    private long amy;
    private long amz;
    private String author;

    public String wY() {
        return this.amo;
    }

    public int wZ() {
        return this.amc;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.amo = forumBookInfo.book_id;
            this.amc = forumBookInfo.book_type.intValue();
            this.amp = forumBookInfo.book_title;
            this.amq = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.amr = forumBookInfo.forum_pic;
            this.ams = forumBookInfo.show_chapter_id;
            this.amt = forumBookInfo.show_chapter_no;
            this.amu = forumBookInfo.show_chapter_title;
            this.amv = forumBookInfo.history_page_id.longValue();
            this.amw = forumBookInfo.history_paragraph_id.longValue();
            this.amx = forumBookInfo.history_word_id.longValue();
            this.amy = forumBookInfo.history_percent.longValue();
            this.amz = forumBookInfo.show_page_id.longValue();
            this.amA = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
