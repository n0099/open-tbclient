package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private String author;
    private String cOB;
    private String cOC;
    private String cOD;
    private String cOE;
    private String cOF;
    private String cOG;
    private String cOH;
    private long cOI;
    private long cOJ;
    private long cOK;
    private long cOL;
    private long cOM;
    private long cON;
    private int cOp;

    public String aAC() {
        return this.cOB;
    }

    public int aAD() {
        return this.cOp;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.cOB = forumBookInfo.book_id;
            this.cOp = forumBookInfo.book_type.intValue();
            this.cOC = forumBookInfo.book_title;
            this.cOD = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.cOE = forumBookInfo.forum_pic;
            this.cOF = forumBookInfo.show_chapter_id;
            this.cOG = forumBookInfo.show_chapter_no;
            this.cOH = forumBookInfo.show_chapter_title;
            this.cOI = forumBookInfo.history_page_id.longValue();
            this.cOJ = forumBookInfo.history_paragraph_id.longValue();
            this.cOK = forumBookInfo.history_word_id.longValue();
            this.cOL = forumBookInfo.history_percent.longValue();
            this.cOM = forumBookInfo.show_page_id.longValue();
            this.cON = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
