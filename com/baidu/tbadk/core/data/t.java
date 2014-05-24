package com.baidu.tbadk.core.data;

import tbclient.FrsPage.WorldCupNews;
/* loaded from: classes.dex */
public class t {
    String a;
    String b;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void a(WorldCupNews worldCupNews) {
        if (worldCupNews != null) {
            this.a = worldCupNews.url;
            this.b = worldCupNews.title;
        }
    }
}
