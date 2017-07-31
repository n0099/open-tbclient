package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private int VN;
    private String Wi;
    private String Wj;
    private String Wk;
    private String Wl;
    private String Wm;
    private String Wn;
    private long Wo;
    private long Wp;
    private long Wq;
    private long Wr;
    private long Ws;
    private long Wt;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int pP() {
        return this.VN;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.VN = forumBookInfo.book_type.intValue();
            this.Wi = forumBookInfo.book_title;
            this.Wj = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Wk = forumBookInfo.forum_pic;
            this.Wl = forumBookInfo.show_chapter_id;
            this.Wm = forumBookInfo.show_chapter_no;
            this.Wn = forumBookInfo.show_chapter_title;
            this.Wo = forumBookInfo.history_page_id.longValue();
            this.Wp = forumBookInfo.history_paragraph_id.longValue();
            this.Wq = forumBookInfo.history_word_id.longValue();
            this.Wr = forumBookInfo.history_percent.longValue();
            this.Ws = forumBookInfo.show_page_id.longValue();
            this.Wt = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
