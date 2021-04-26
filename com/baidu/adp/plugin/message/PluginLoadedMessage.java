package com.baidu.adp.plugin.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class PluginLoadedMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f2202a;

        /* renamed from: b  reason: collision with root package name */
        public int f2203b;

        public a(String str, int i2, String str2) {
            this.f2202a = str;
            this.f2203b = i2;
        }
    }

    public PluginLoadedMessage(a aVar) {
        super(2000997, aVar);
    }
}
