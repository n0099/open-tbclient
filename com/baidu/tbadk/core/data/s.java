package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes5.dex */
public class s {
    private String author;
    private int cJM;
    private String cJY;
    private String cJZ;
    private String cKa;
    private String cKb;
    private String cKc;
    private String cKd;
    private String cKe;
    private long cKf;
    private long cKg;
    private long cKh;
    private long cKi;
    private long cKj;
    private long cKk;

    public String axQ() {
        return this.cJY;
    }

    public int axR() {
        return this.cJM;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.cJY = forumBookInfo.book_id;
            this.cJM = forumBookInfo.book_type.intValue();
            this.cJZ = forumBookInfo.book_title;
            this.cKa = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.cKb = forumBookInfo.forum_pic;
            this.cKc = forumBookInfo.show_chapter_id;
            this.cKd = forumBookInfo.show_chapter_no;
            this.cKe = forumBookInfo.show_chapter_title;
            this.cKf = forumBookInfo.history_page_id.longValue();
            this.cKg = forumBookInfo.history_paragraph_id.longValue();
            this.cKh = forumBookInfo.history_word_id.longValue();
            this.cKi = forumBookInfo.history_percent.longValue();
            this.cKj = forumBookInfo.show_page_id.longValue();
            this.cKk = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
