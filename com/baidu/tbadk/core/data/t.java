package com.baidu.tbadk.core.data;

import tbclient.FrsPage.WorldCupPk;
/* loaded from: classes.dex */
public class t {
    String a;
    String b;
    String c;
    String d;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public void a(WorldCupPk worldCupPk) {
        if (worldCupPk != null) {
            this.d = worldCupPk.url;
            this.b = worldCupPk.sum_bonus;
            this.a = worldCupPk.sum_game;
            this.c = worldCupPk.prize_url;
        }
    }
}
