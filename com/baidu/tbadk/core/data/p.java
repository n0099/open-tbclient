package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes6.dex */
public class p {
    private int amP;
    private String anb;
    private String anc;
    private String and;
    private String ane;
    private String anf;
    private String ang;
    private String anh;
    private long ani;
    private long anj;
    private long ank;
    private long anl;
    private long anm;
    private long ann;
    private String author;

    public String xg() {
        return this.anb;
    }

    public int xh() {
        return this.amP;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.anb = forumBookInfo.book_id;
            this.amP = forumBookInfo.book_type.intValue();
            this.anc = forumBookInfo.book_title;
            this.and = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.ane = forumBookInfo.forum_pic;
            this.anf = forumBookInfo.show_chapter_id;
            this.ang = forumBookInfo.show_chapter_no;
            this.anh = forumBookInfo.show_chapter_title;
            this.ani = forumBookInfo.history_page_id.longValue();
            this.anj = forumBookInfo.history_paragraph_id.longValue();
            this.ank = forumBookInfo.history_word_id.longValue();
            this.anl = forumBookInfo.history_percent.longValue();
            this.anm = forumBookInfo.show_page_id.longValue();
            this.ann = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
