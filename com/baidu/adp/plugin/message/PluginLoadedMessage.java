package com.baidu.adp.plugin.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class PluginLoadedMessage extends CustomResponsedMessage<a> {
    public PluginLoadedMessage(a aVar) {
        super(MessageConfig.PLUGIN_LOADED, aVar);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String Rm;
        public int Rn;
        public String errMsg;

        public a(String str, int i, String str2) {
            this.Rm = str;
            this.Rn = i;
            this.errMsg = str2;
        }
    }
}
