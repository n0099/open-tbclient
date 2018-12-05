package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes6.dex */
public class p {
    private String aqC;
    private String aqD;
    private String aqE;
    private String aqF;
    private String aqG;
    private String aqH;
    private String aqI;
    private long aqJ;
    private long aqK;
    private long aqL;
    private long aqM;
    private long aqN;
    private long aqO;
    private int aqq;
    private String author;

    public String yl() {
        return this.aqC;
    }

    public int ym() {
        return this.aqq;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.aqC = forumBookInfo.book_id;
            this.aqq = forumBookInfo.book_type.intValue();
            this.aqD = forumBookInfo.book_title;
            this.aqE = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.aqF = forumBookInfo.forum_pic;
            this.aqG = forumBookInfo.show_chapter_id;
            this.aqH = forumBookInfo.show_chapter_no;
            this.aqI = forumBookInfo.show_chapter_title;
            this.aqJ = forumBookInfo.history_page_id.longValue();
            this.aqK = forumBookInfo.history_paragraph_id.longValue();
            this.aqL = forumBookInfo.history_word_id.longValue();
            this.aqM = forumBookInfo.history_percent.longValue();
            this.aqN = forumBookInfo.show_page_id.longValue();
            this.aqO = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
