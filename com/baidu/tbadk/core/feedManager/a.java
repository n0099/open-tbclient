package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a euF;
    private DataRes euH;
    private FeedRecModel.a euI = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.euH = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void ay(int i, String str) {
            a.this.euH = null;
        }
    };
    private FeedRecModel euG = new FeedRecModel();

    public a() {
        this.euG.a(this.euI);
    }

    public static a blb() {
        if (euF == null) {
            synchronized (a.class) {
                if (euF == null) {
                    euF = new a();
                }
            }
        }
        return euF;
    }

    public DataRes blc() {
        return this.euH;
    }
}
