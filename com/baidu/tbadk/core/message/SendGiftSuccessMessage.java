package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class SendGiftSuccessMessage extends CustomResponsedMessage {
    private a mGiftInfo;

    public SendGiftSuccessMessage() {
        super(CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    }

    public SendGiftSuccessMessage(int i, Object obj) {
        super(i, obj);
    }

    public a getGiftInfo() {
        return this.mGiftInfo;
    }

    public void setGiftInfo(a aVar) {
        this.mGiftInfo = aVar;
    }

    /* loaded from: classes.dex */
    public static class a {
        private int ZC;
        private String ZD;
        private int count;
        private String name;
        private String threadId;
        private String url;

        public void setId(int i) {
            this.ZC = i;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int i) {
            this.count = i;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void cH(String str) {
            this.ZD = str;
        }

        public void setThreadId(String str) {
            this.threadId = str;
        }
    }
}
