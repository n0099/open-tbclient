package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class q {
    private int aeW;
    private String afi;
    private String afj;
    private String afk;
    private String afl;
    private String afm;
    private String afn;
    private String afo;
    private long afp;
    private long afq;
    private long afr;
    private long afs;
    private long aft;
    private long afu;
    private String author;

    public String tV() {
        return this.afi;
    }

    public int getBookType() {
        return this.aeW;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.afi = forumBookInfo.book_id;
            this.aeW = forumBookInfo.book_type.intValue();
            this.afj = forumBookInfo.book_title;
            this.afk = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.afl = forumBookInfo.forum_pic;
            this.afm = forumBookInfo.show_chapter_id;
            this.afn = forumBookInfo.show_chapter_no;
            this.afo = forumBookInfo.show_chapter_title;
            this.afp = forumBookInfo.history_page_id.longValue();
            this.afq = forumBookInfo.history_paragraph_id.longValue();
            this.afr = forumBookInfo.history_word_id.longValue();
            this.afs = forumBookInfo.history_percent.longValue();
            this.aft = forumBookInfo.show_page_id.longValue();
            this.afu = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
