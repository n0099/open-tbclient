package com.baidu.adp.plugin.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class PluginLoadedMessage extends CustomResponsedMessage<a> {
    public PluginLoadedMessage(a aVar) {
        super(2000997, aVar);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int IA;
        public String Iz;
        public String errMsg;

        public a(String str, int i, String str2) {
            this.Iz = str;
            this.IA = i;
            this.errMsg = str2;
        }
    }
}
