package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a eDe;
    private DataRes eDg;
    private FeedRecModel.a eDh = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.eDg = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void aA(int i, String str) {
            a.this.eDg = null;
        }
    };
    private FeedRecModel eDf = new FeedRecModel();

    public a() {
        this.eDf.a(this.eDh);
    }

    public static a bmU() {
        if (eDe == null) {
            synchronized (a.class) {
                if (eDe == null) {
                    eDe = new a();
                }
            }
        }
        return eDe;
    }

    public DataRes bmV() {
        return this.eDg;
    }
}
