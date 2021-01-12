package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class x {
    private String author;
    private String eKO;
    private String eKP;
    private String eKQ;
    private String eKR;
    private String eKS;
    private String eKT;
    private String eKU;
    private long eKV;
    private long eKW;
    private long eKX;
    private long eKY;
    private long eKZ;
    private int eKq;
    private long eLa;

    public String blB() {
        return this.eKO;
    }

    public int blC() {
        return this.eKq;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.eKO = forumBookInfo.book_id;
            this.eKq = forumBookInfo.book_type.intValue();
            this.eKP = forumBookInfo.book_title;
            this.eKQ = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.eKR = forumBookInfo.forum_pic;
            this.eKS = forumBookInfo.show_chapter_id;
            this.eKT = forumBookInfo.show_chapter_no;
            this.eKU = forumBookInfo.show_chapter_title;
            this.eKV = forumBookInfo.history_page_id.longValue();
            this.eKW = forumBookInfo.history_paragraph_id.longValue();
            this.eKX = forumBookInfo.history_word_id.longValue();
            this.eKY = forumBookInfo.history_percent.longValue();
            this.eKZ = forumBookInfo.show_page_id.longValue();
            this.eLa = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
