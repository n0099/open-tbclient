package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class r {
    private String author;
    private int bGb;
    private String bGn;
    private String bGo;
    private String bGp;
    private String bGq;
    private String bGr;
    private String bGs;
    private String bGt;
    private long bGu;
    private long bGv;
    private long bGw;
    private long bGx;
    private long bGy;
    private long bGz;

    public String acO() {
        return this.bGn;
    }

    public int acP() {
        return this.bGb;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bGn = forumBookInfo.book_id;
            this.bGb = forumBookInfo.book_type.intValue();
            this.bGo = forumBookInfo.book_title;
            this.bGp = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.bGq = forumBookInfo.forum_pic;
            this.bGr = forumBookInfo.show_chapter_id;
            this.bGs = forumBookInfo.show_chapter_no;
            this.bGt = forumBookInfo.show_chapter_title;
            this.bGu = forumBookInfo.history_page_id.longValue();
            this.bGv = forumBookInfo.history_paragraph_id.longValue();
            this.bGw = forumBookInfo.history_word_id.longValue();
            this.bGx = forumBookInfo.history_percent.longValue();
            this.bGy = forumBookInfo.show_page_id.longValue();
            this.bGz = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
