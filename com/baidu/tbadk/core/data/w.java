package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class w {
    private String author;
    private int elC;
    private String ema;
    private String emb;
    private String emc;
    private String emd;
    private String eme;
    private String emf;
    private String emg;
    private long emh;
    private long emi;
    private long emj;
    private long emk;
    private long eml;
    private long emm;

    public String bgn() {
        return this.ema;
    }

    public int bgo() {
        return this.elC;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.ema = forumBookInfo.book_id;
            this.elC = forumBookInfo.book_type.intValue();
            this.emb = forumBookInfo.book_title;
            this.emc = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.emd = forumBookInfo.forum_pic;
            this.eme = forumBookInfo.show_chapter_id;
            this.emf = forumBookInfo.show_chapter_no;
            this.emg = forumBookInfo.show_chapter_title;
            this.emh = forumBookInfo.history_page_id.longValue();
            this.emi = forumBookInfo.history_paragraph_id.longValue();
            this.emj = forumBookInfo.history_word_id.longValue();
            this.emk = forumBookInfo.history_percent.longValue();
            this.eml = forumBookInfo.show_page_id.longValue();
            this.emm = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
