package com.baidu.adp.plugin.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class PluginLoadedMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f2197a;

        /* renamed from: b  reason: collision with root package name */
        public int f2198b;

        public a(String str, int i, String str2) {
            this.f2197a = str;
            this.f2198b = i;
        }
    }

    public PluginLoadedMessage(a aVar) {
        super(2000997, aVar);
    }
}
