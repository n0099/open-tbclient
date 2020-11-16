package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class x {
    private String author;
    private String eyK;
    private String eyL;
    private String eyM;
    private String eyN;
    private String eyO;
    private String eyP;
    private String eyQ;
    private long eyR;
    private long eyS;
    private long eyT;
    private long eyU;
    private long eyV;
    private long eyW;
    private int eyl;

    public String bjI() {
        return this.eyK;
    }

    public int bjJ() {
        return this.eyl;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.eyK = forumBookInfo.book_id;
            this.eyl = forumBookInfo.book_type.intValue();
            this.eyL = forumBookInfo.book_title;
            this.eyM = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.eyN = forumBookInfo.forum_pic;
            this.eyO = forumBookInfo.show_chapter_id;
            this.eyP = forumBookInfo.show_chapter_no;
            this.eyQ = forumBookInfo.show_chapter_title;
            this.eyR = forumBookInfo.history_page_id.longValue();
            this.eyS = forumBookInfo.history_paragraph_id.longValue();
            this.eyT = forumBookInfo.history_word_id.longValue();
            this.eyU = forumBookInfo.history_percent.longValue();
            this.eyV = forumBookInfo.show_page_id.longValue();
            this.eyW = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
