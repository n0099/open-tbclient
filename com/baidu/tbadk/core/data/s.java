package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private String author;
    private String dnG;
    private String dnH;
    private String dnI;
    private String dnJ;
    private String dnK;
    private String dnL;
    private String dnM;
    private long dnN;
    private long dnO;
    private long dnP;
    private long dnQ;
    private long dnR;
    private long dnS;
    private int dnu;

    public String aIP() {
        return this.dnG;
    }

    public int aIQ() {
        return this.dnu;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.dnG = forumBookInfo.book_id;
            this.dnu = forumBookInfo.book_type.intValue();
            this.dnH = forumBookInfo.book_title;
            this.dnI = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.dnJ = forumBookInfo.forum_pic;
            this.dnK = forumBookInfo.show_chapter_id;
            this.dnL = forumBookInfo.show_chapter_no;
            this.dnM = forumBookInfo.show_chapter_title;
            this.dnN = forumBookInfo.history_page_id.longValue();
            this.dnO = forumBookInfo.history_paragraph_id.longValue();
            this.dnP = forumBookInfo.history_word_id.longValue();
            this.dnQ = forumBookInfo.history_percent.longValue();
            this.dnR = forumBookInfo.show_page_id.longValue();
            this.dnS = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
