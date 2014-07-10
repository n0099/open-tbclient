package com.baidu.tbadk.core.data;

import tbclient.FrsPage.WorldCup;
/* loaded from: classes.dex */
public class p {
    private s a;
    private t b;
    private r c;
    private q d;

    public s a() {
        return this.a;
    }

    public t b() {
        return this.b;
    }

    public r c() {
        return this.c;
    }

    public q d() {
        return this.d;
    }

    public void a(WorldCup worldCup) {
        if (worldCup != null) {
            if (worldCup.game != null || worldCup.lottery != null || worldCup.news != null || worldCup.pk != null) {
                if (worldCup.news != null) {
                    this.a = new s();
                    this.a.a(worldCup.news);
                }
                if (worldCup.pk != null) {
                    this.b = new t();
                    this.b.a(worldCup.pk);
                }
                if (worldCup.lottery != null) {
                    this.c = new r();
                    this.c.a(worldCup.lottery);
                }
                if (worldCup.game != null) {
                    this.d = new q();
                    this.d.a(worldCup.game);
                }
            }
        }
    }
}
