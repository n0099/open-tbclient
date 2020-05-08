package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private String author;
    private String dnK;
    private String dnL;
    private String dnM;
    private String dnN;
    private String dnO;
    private String dnP;
    private String dnQ;
    private long dnR;
    private long dnS;
    private long dnT;
    private long dnU;
    private long dnV;
    private long dnW;
    private int dny;

    public String aIN() {
        return this.dnK;
    }

    public int aIO() {
        return this.dny;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.dnK = forumBookInfo.book_id;
            this.dny = forumBookInfo.book_type.intValue();
            this.dnL = forumBookInfo.book_title;
            this.dnM = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.dnN = forumBookInfo.forum_pic;
            this.dnO = forumBookInfo.show_chapter_id;
            this.dnP = forumBookInfo.show_chapter_no;
            this.dnQ = forumBookInfo.show_chapter_title;
            this.dnR = forumBookInfo.history_page_id.longValue();
            this.dnS = forumBookInfo.history_paragraph_id.longValue();
            this.dnT = forumBookInfo.history_word_id.longValue();
            this.dnU = forumBookInfo.history_percent.longValue();
            this.dnV = forumBookInfo.show_page_id.longValue();
            this.dnW = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
