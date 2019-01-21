package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes6.dex */
public class p {
    private int aqT;
    private String arf;
    private String arg;
    private String arh;
    private String ari;
    private String arj;
    private String ark;
    private String arl;
    private long arm;
    private long arn;
    private long aro;
    private long arp;
    private long arq;
    private long arr;
    private String author;

    public String yy() {
        return this.arf;
    }

    public int yz() {
        return this.aqT;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.arf = forumBookInfo.book_id;
            this.aqT = forumBookInfo.book_type.intValue();
            this.arg = forumBookInfo.book_title;
            this.arh = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.ari = forumBookInfo.forum_pic;
            this.arj = forumBookInfo.show_chapter_id;
            this.ark = forumBookInfo.show_chapter_no;
            this.arl = forumBookInfo.show_chapter_title;
            this.arm = forumBookInfo.history_page_id.longValue();
            this.arn = forumBookInfo.history_paragraph_id.longValue();
            this.aro = forumBookInfo.history_word_id.longValue();
            this.arp = forumBookInfo.history_percent.longValue();
            this.arq = forumBookInfo.show_page_id.longValue();
            this.arr = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
