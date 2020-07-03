package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class v {
    private String author;
    private int dHS;
    private String dIg;
    private String dIh;
    private String dIi;
    private String dIj;
    private String dIk;
    private String dIl;
    private String dIm;
    private long dIn;
    private long dIo;
    private long dIp;
    private long dIq;
    private long dIr;
    private long dIs;

    public String aQv() {
        return this.dIg;
    }

    public int aQw() {
        return this.dHS;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.dIg = forumBookInfo.book_id;
            this.dHS = forumBookInfo.book_type.intValue();
            this.dIh = forumBookInfo.book_title;
            this.dIi = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.dIj = forumBookInfo.forum_pic;
            this.dIk = forumBookInfo.show_chapter_id;
            this.dIl = forumBookInfo.show_chapter_no;
            this.dIm = forumBookInfo.show_chapter_title;
            this.dIn = forumBookInfo.history_page_id.longValue();
            this.dIo = forumBookInfo.history_paragraph_id.longValue();
            this.dIp = forumBookInfo.history_word_id.longValue();
            this.dIq = forumBookInfo.history_percent.longValue();
            this.dIr = forumBookInfo.show_page_id.longValue();
            this.dIs = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
