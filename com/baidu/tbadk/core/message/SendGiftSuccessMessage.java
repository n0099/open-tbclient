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
        private int XK;
        private String XL;
        private int count;
        private String name;
        private String url;

        public void setId(int i) {
            this.XK = i;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setCount(int i) {
            this.count = i;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void cq(String str) {
            this.XL = str;
        }
    }
}
