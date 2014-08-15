package com.baidu.tbadk.core.data;

import tbclient.FrsPage.WorldCup;
/* loaded from: classes.dex */
public class q {
    private t a;
    private u b;
    private s c;
    private r d;

    public t a() {
        return this.a;
    }

    public u b() {
        return this.b;
    }

    public s c() {
        return this.c;
    }

    public r d() {
        return this.d;
    }

    public void a(WorldCup worldCup) {
        if (worldCup != null) {
            if (worldCup.game != null || worldCup.lottery != null || worldCup.news != null || worldCup.pk != null) {
                if (worldCup.news != null) {
                    this.a = new t();
                    this.a.a(worldCup.news);
                }
                if (worldCup.pk != null) {
                    this.b = new u();
                    this.b.a(worldCup.pk);
                }
                if (worldCup.lottery != null) {
                    this.c = new s();
                    this.c.a(worldCup.lottery);
                }
                if (worldCup.game != null) {
                    this.d = new r();
                    this.d.a(worldCup.game);
                }
            }
        }
    }
}
