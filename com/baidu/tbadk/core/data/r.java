package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class r {
    private String author;
    private int bGa;
    private String bGm;
    private String bGn;
    private String bGo;
    private String bGp;
    private String bGq;
    private String bGr;
    private String bGs;
    private long bGt;
    private long bGu;
    private long bGv;
    private long bGw;
    private long bGx;
    private long bGy;

    public String acN() {
        return this.bGm;
    }

    public int acO() {
        return this.bGa;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bGm = forumBookInfo.book_id;
            this.bGa = forumBookInfo.book_type.intValue();
            this.bGn = forumBookInfo.book_title;
            this.bGo = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.bGp = forumBookInfo.forum_pic;
            this.bGq = forumBookInfo.show_chapter_id;
            this.bGr = forumBookInfo.show_chapter_no;
            this.bGs = forumBookInfo.show_chapter_title;
            this.bGt = forumBookInfo.history_page_id.longValue();
            this.bGu = forumBookInfo.history_paragraph_id.longValue();
            this.bGv = forumBookInfo.history_word_id.longValue();
            this.bGw = forumBookInfo.history_percent.longValue();
            this.bGx = forumBookInfo.show_page_id.longValue();
            this.bGy = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
