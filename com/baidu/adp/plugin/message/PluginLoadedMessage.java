package com.baidu.adp.plugin.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class PluginLoadedMessage extends CustomResponsedMessage<a> {
    public PluginLoadedMessage(a aVar) {
        super(2000997, aVar);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String aqQ;
        public int aqR;
        public String errMsg;

        public a(String str, int i, String str2) {
            this.aqQ = str;
            this.aqR = i;
            this.errMsg = str2;
        }
    }
}
