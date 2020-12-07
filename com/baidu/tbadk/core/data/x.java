package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class x {
    private String author;
    private String eFJ;
    private String eFK;
    private String eFL;
    private String eFM;
    private String eFN;
    private String eFO;
    private String eFP;
    private long eFQ;
    private long eFR;
    private long eFS;
    private long eFT;
    private long eFU;
    private long eFV;
    private int eFl;

    public String bmV() {
        return this.eFJ;
    }

    public int bmW() {
        return this.eFl;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.eFJ = forumBookInfo.book_id;
            this.eFl = forumBookInfo.book_type.intValue();
            this.eFK = forumBookInfo.book_title;
            this.eFL = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.eFM = forumBookInfo.forum_pic;
            this.eFN = forumBookInfo.show_chapter_id;
            this.eFO = forumBookInfo.show_chapter_no;
            this.eFP = forumBookInfo.show_chapter_title;
            this.eFQ = forumBookInfo.history_page_id.longValue();
            this.eFR = forumBookInfo.history_paragraph_id.longValue();
            this.eFS = forumBookInfo.history_word_id.longValue();
            this.eFT = forumBookInfo.history_percent.longValue();
            this.eFU = forumBookInfo.show_page_id.longValue();
            this.eFV = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
