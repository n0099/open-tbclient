package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.WorldCupGame;
import tbclient.FrsPage.WorldCupGameTeam;
/* loaded from: classes.dex */
public class q {
    ArrayList<u> a;
    String b;
    String c;
    String d;

    public ArrayList<u> a() {
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

    public void a(WorldCupGame worldCupGame) {
        if (worldCupGame != null) {
            this.d = worldCupGame.url;
            this.b = worldCupGame.title;
            this.c = worldCupGame.status;
            this.a = new ArrayList<>();
            List<WorldCupGameTeam> list = worldCupGame.team;
            if (list != null) {
                for (WorldCupGameTeam worldCupGameTeam : list) {
                    u uVar = new u();
                    uVar.a(worldCupGameTeam);
                    this.a.add(uVar);
                }
            }
        }
    }
}
