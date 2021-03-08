package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class y {
    private String author;
    private String eOB;
    private String eOC;
    private String eOD;
    private String eOE;
    private String eOF;
    private String eOG;
    private String eOH;
    private long eOI;
    private long eOJ;
    private long eOK;
    private long eOL;
    private long eOM;
    private long eON;
    private int eOd;

    public String blV() {
        return this.eOB;
    }

    public int blW() {
        return this.eOd;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.eOB = forumBookInfo.book_id;
            this.eOd = forumBookInfo.book_type.intValue();
            this.eOC = forumBookInfo.book_title;
            this.eOD = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.eOE = forumBookInfo.forum_pic;
            this.eOF = forumBookInfo.show_chapter_id;
            this.eOG = forumBookInfo.show_chapter_no;
            this.eOH = forumBookInfo.show_chapter_title;
            this.eOI = forumBookInfo.history_page_id.longValue();
            this.eOJ = forumBookInfo.history_paragraph_id.longValue();
            this.eOK = forumBookInfo.history_word_id.longValue();
            this.eOL = forumBookInfo.history_percent.longValue();
            this.eOM = forumBookInfo.show_page_id.longValue();
            this.eON = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
