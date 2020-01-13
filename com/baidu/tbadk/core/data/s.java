package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes6.dex */
public class s {
    private String author;
    private int cJX;
    private String cKj;
    private String cKk;
    private String cKl;
    private String cKm;
    private String cKn;
    private String cKo;
    private String cKp;
    private long cKq;
    private long cKr;
    private long cKs;
    private long cKt;
    private long cKu;
    private long cKv;

    public String ayj() {
        return this.cKj;
    }

    public int ayk() {
        return this.cJX;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.cKj = forumBookInfo.book_id;
            this.cJX = forumBookInfo.book_type.intValue();
            this.cKk = forumBookInfo.book_title;
            this.cKl = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.cKm = forumBookInfo.forum_pic;
            this.cKn = forumBookInfo.show_chapter_id;
            this.cKo = forumBookInfo.show_chapter_no;
            this.cKp = forumBookInfo.show_chapter_title;
            this.cKq = forumBookInfo.history_page_id.longValue();
            this.cKr = forumBookInfo.history_paragraph_id.longValue();
            this.cKs = forumBookInfo.history_word_id.longValue();
            this.cKt = forumBookInfo.history_percent.longValue();
            this.cKu = forumBookInfo.show_page_id.longValue();
            this.cKv = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
