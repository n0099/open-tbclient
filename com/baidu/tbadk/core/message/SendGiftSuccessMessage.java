package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class SendGiftSuccessMessage extends CustomResponsedMessage {
    public a mGiftInfo;

    /* loaded from: classes3.dex */
    public static class a {
        public void a(int i2) {
        }

        public void b(int i2) {
        }

        public void c(String str) {
        }

        public void d(String str) {
        }

        public void e(String str) {
        }
    }

    public SendGiftSuccessMessage() {
        super(2001232);
    }

    public a getGiftInfo() {
        return this.mGiftInfo;
    }

    public void setGiftInfo(a aVar) {
        this.mGiftInfo = aVar;
    }

    public SendGiftSuccessMessage(int i2, Object obj) {
        super(i2, obj);
    }
}
