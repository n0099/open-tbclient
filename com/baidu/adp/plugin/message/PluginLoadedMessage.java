package com.baidu.adp.plugin.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class PluginLoadedMessage extends CustomResponsedMessage<a> {
    public PluginLoadedMessage(a aVar) {
        super(2000997, aVar);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String errMsg;
        public int errNo;
        public String uo;

        public a(String str, int i, String str2) {
            this.uo = str;
            this.errNo = i;
            this.errMsg = str2;
        }
    }
}
