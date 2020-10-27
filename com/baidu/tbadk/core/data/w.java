package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class w {
    private String author;
    private String euA;
    private String euB;
    private String euC;
    private String euD;
    private String euE;
    private String euF;
    private String euG;
    private long euH;
    private long euI;
    private long euJ;
    private long euK;
    private long euL;
    private long euM;
    private int euc;

    public String big() {
        return this.euA;
    }

    public int bih() {
        return this.euc;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.euA = forumBookInfo.book_id;
            this.euc = forumBookInfo.book_type.intValue();
            this.euB = forumBookInfo.book_title;
            this.euC = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.euD = forumBookInfo.forum_pic;
            this.euE = forumBookInfo.show_chapter_id;
            this.euF = forumBookInfo.show_chapter_no;
            this.euG = forumBookInfo.show_chapter_title;
            this.euH = forumBookInfo.history_page_id.longValue();
            this.euI = forumBookInfo.history_paragraph_id.longValue();
            this.euJ = forumBookInfo.history_word_id.longValue();
            this.euK = forumBookInfo.history_percent.longValue();
            this.euL = forumBookInfo.show_page_id.longValue();
            this.euM = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
