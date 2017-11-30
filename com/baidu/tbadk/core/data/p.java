package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class p {
    private int VU;
    private String Wg;
    private String Wh;
    private String Wi;
    private String Wj;
    private String Wk;
    private String Wl;
    private String Wm;
    private long Wn;
    private long Wo;
    private long Wp;
    private long Wq;
    private long Wr;
    private long Ws;
    private String author;

    public String pM() {
        return this.Wg;
    }

    public int pN() {
        return this.VU;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.Wg = forumBookInfo.book_id;
            this.VU = forumBookInfo.book_type.intValue();
            this.Wh = forumBookInfo.book_title;
            this.Wi = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Wj = forumBookInfo.forum_pic;
            this.Wk = forumBookInfo.show_chapter_id;
            this.Wl = forumBookInfo.show_chapter_no;
            this.Wm = forumBookInfo.show_chapter_title;
            this.Wn = forumBookInfo.history_page_id.longValue();
            this.Wo = forumBookInfo.history_paragraph_id.longValue();
            this.Wp = forumBookInfo.history_word_id.longValue();
            this.Wq = forumBookInfo.history_percent.longValue();
            this.Wr = forumBookInfo.show_page_id.longValue();
            this.Ws = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
