package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    public HashMap<String, Object> elw = new HashMap<>();
    private Context mContext;

    public o(Context context) {
        this.mContext = context;
    }

    public void ab(String str, String str2, String str3) {
        this.elw.put("forumID", str);
        this.elw.put(TbTitleActivityConfig.FORUM_NAME, str2);
        this.elw.put("obj_source", str3);
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.elw.put("broadcastID", str);
        this.elw.put(TbTitleActivityConfig.FORUM_NAME, str2);
        this.elw.put("forumID", str3);
        this.elw.put("threadID", str4);
        this.elw.put("title", str5);
        this.elw.put("content", str6);
        this.elw.put("image", str7);
        this.elw.put("from", str8);
        this.elw.put("obj_source", str9);
        this.elw.put("threadLink", "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share");
    }

    public void Ar(String str) {
        com.baidu.adp.lib.util.a.copyToClipboard("http://tieba.baidu.com/p/" + str + "?share=9105&fr=share");
    }

    public void bju() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921472, UtilHelper.getClipBoardContent()));
    }

    public void start() {
        this.elw.put("swipeback", false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(this.mContext, "BarBroadcastEdit", this.elw)));
    }
}
