package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class x {
    private String author;
    private String ePA;
    private String ePB;
    private String ePC;
    private String ePD;
    private String ePE;
    private String ePF;
    private long ePG;
    private long ePH;
    private long ePI;
    private long ePJ;
    private long ePK;
    private long ePL;
    private int ePb;
    private String ePz;

    public String bpv() {
        return this.ePz;
    }

    public int bpw() {
        return this.ePb;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.ePz = forumBookInfo.book_id;
            this.ePb = forumBookInfo.book_type.intValue();
            this.ePA = forumBookInfo.book_title;
            this.ePB = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.ePC = forumBookInfo.forum_pic;
            this.ePD = forumBookInfo.show_chapter_id;
            this.ePE = forumBookInfo.show_chapter_no;
            this.ePF = forumBookInfo.show_chapter_title;
            this.ePG = forumBookInfo.history_page_id.longValue();
            this.ePH = forumBookInfo.history_paragraph_id.longValue();
            this.ePI = forumBookInfo.history_word_id.longValue();
            this.ePJ = forumBookInfo.history_percent.longValue();
            this.ePK = forumBookInfo.show_page_id.longValue();
            this.ePL = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
