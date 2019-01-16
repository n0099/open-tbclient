package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes6.dex */
public class p {
    private int aqS;
    private String are;
    private String arf;
    private String arg;
    private String arh;
    private String ari;
    private String arj;
    private String ark;
    private long arl;
    private long arm;
    private long arn;
    private long aro;
    private long arp;
    private long arq;
    private String author;

    public String yy() {
        return this.are;
    }

    public int yz() {
        return this.aqS;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.are = forumBookInfo.book_id;
            this.aqS = forumBookInfo.book_type.intValue();
            this.arf = forumBookInfo.book_title;
            this.arg = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.arh = forumBookInfo.forum_pic;
            this.ari = forumBookInfo.show_chapter_id;
            this.arj = forumBookInfo.show_chapter_no;
            this.ark = forumBookInfo.show_chapter_title;
            this.arl = forumBookInfo.history_page_id.longValue();
            this.arm = forumBookInfo.history_paragraph_id.longValue();
            this.arn = forumBookInfo.history_word_id.longValue();
            this.aro = forumBookInfo.history_percent.longValue();
            this.arp = forumBookInfo.show_page_id.longValue();
            this.arq = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
