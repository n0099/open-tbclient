package com.baidu.tbadk.core.data;

import tbclient.FrsPage.WorldCupGameTeam;
/* loaded from: classes.dex */
public class v {
    String a;
    String b;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void a(WorldCupGameTeam worldCupGameTeam) {
        if (worldCupGameTeam != null) {
            this.a = worldCupGameTeam.name;
            this.b = worldCupGameTeam.logo_url;
        }
    }
}
