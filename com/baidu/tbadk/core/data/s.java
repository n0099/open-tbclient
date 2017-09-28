package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private String VD;
    private String VE;
    private String VF;
    private String VG;
    private String VH;
    private String VI;
    private String VJ;
    private long VK;
    private long VL;
    private long VM;
    private long VN;
    private long VO;
    private long VP;
    private int Vh;
    private String author;

    public String pL() {
        return this.VD;
    }

    public int pM() {
        return this.Vh;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.VD = forumBookInfo.book_id;
            this.Vh = forumBookInfo.book_type.intValue();
            this.VE = forumBookInfo.book_title;
            this.VF = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.VG = forumBookInfo.forum_pic;
            this.VH = forumBookInfo.show_chapter_id;
            this.VI = forumBookInfo.show_chapter_no;
            this.VJ = forumBookInfo.show_chapter_title;
            this.VK = forumBookInfo.history_page_id.longValue();
            this.VL = forumBookInfo.history_paragraph_id.longValue();
            this.VM = forumBookInfo.history_word_id.longValue();
            this.VN = forumBookInfo.history_percent.longValue();
            this.VO = forumBookInfo.show_page_id.longValue();
            this.VP = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
