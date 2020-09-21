package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class w {
    private String author;
    private int dZA;
    private String dZY;
    private String dZZ;
    private String eaa;
    private String eab;
    private String eac;
    private String ead;
    private String eae;
    private long eaf;
    private long eag;
    private long eah;
    private long eai;
    private long eaj;
    private long eak;

    public String bdE() {
        return this.dZY;
    }

    public int bdF() {
        return this.dZA;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.dZY = forumBookInfo.book_id;
            this.dZA = forumBookInfo.book_type.intValue();
            this.dZZ = forumBookInfo.book_title;
            this.eaa = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.eab = forumBookInfo.forum_pic;
            this.eac = forumBookInfo.show_chapter_id;
            this.ead = forumBookInfo.show_chapter_no;
            this.eae = forumBookInfo.show_chapter_title;
            this.eaf = forumBookInfo.history_page_id.longValue();
            this.eag = forumBookInfo.history_paragraph_id.longValue();
            this.eah = forumBookInfo.history_word_id.longValue();
            this.eai = forumBookInfo.history_percent.longValue();
            this.eaj = forumBookInfo.show_page_id.longValue();
            this.eak = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
