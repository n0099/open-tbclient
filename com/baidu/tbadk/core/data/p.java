package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes2.dex */
public class p {
    private int aeF;
    private String aeR;
    private String aeS;
    private String aeT;
    private String aeU;
    private String aeV;
    private String aeW;
    private String aeX;
    private long aeY;
    private long aeZ;
    private long afa;
    private long afb;
    private long afc;
    private long afd;
    private String author;

    public String tM() {
        return this.aeR;
    }

    public int tN() {
        return this.aeF;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.aeR = forumBookInfo.book_id;
            this.aeF = forumBookInfo.book_type.intValue();
            this.aeS = forumBookInfo.book_title;
            this.aeT = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.aeU = forumBookInfo.forum_pic;
            this.aeV = forumBookInfo.show_chapter_id;
            this.aeW = forumBookInfo.show_chapter_no;
            this.aeX = forumBookInfo.show_chapter_title;
            this.aeY = forumBookInfo.history_page_id.longValue();
            this.aeZ = forumBookInfo.history_paragraph_id.longValue();
            this.afa = forumBookInfo.history_word_id.longValue();
            this.afb = forumBookInfo.history_percent.longValue();
            this.afc = forumBookInfo.show_page_id.longValue();
            this.afd = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
