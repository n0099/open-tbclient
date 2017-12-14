package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class p {
    private int VO;
    private String Wa;
    private String Wb;
    private String Wc;
    private String Wd;
    private String We;
    private String Wf;
    private String Wg;
    private long Wh;
    private long Wi;
    private long Wj;
    private long Wk;
    private long Wl;
    private long Wm;
    private String author;

    public String pK() {
        return this.Wa;
    }

    public int pL() {
        return this.VO;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.Wa = forumBookInfo.book_id;
            this.VO = forumBookInfo.book_type.intValue();
            this.Wb = forumBookInfo.book_title;
            this.Wc = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Wd = forumBookInfo.forum_pic;
            this.We = forumBookInfo.show_chapter_id;
            this.Wf = forumBookInfo.show_chapter_no;
            this.Wg = forumBookInfo.show_chapter_title;
            this.Wh = forumBookInfo.history_page_id.longValue();
            this.Wi = forumBookInfo.history_paragraph_id.longValue();
            this.Wj = forumBookInfo.history_word_id.longValue();
            this.Wk = forumBookInfo.history_percent.longValue();
            this.Wl = forumBookInfo.show_page_id.longValue();
            this.Wm = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
