package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class a {
    private static volatile a ege;
    private DataRes egg;
    private FeedRecModel.a egh = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.egg = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void am(int i, String str) {
            a.this.egg = null;
        }
    };
    private FeedRecModel egf = new FeedRecModel();

    public a() {
        this.egf.a(this.egh);
    }

    public static a bhy() {
        if (ege == null) {
            synchronized (a.class) {
                if (ege == null) {
                    ege = new a();
                }
            }
        }
        return ege;
    }

    public DataRes bhz() {
        return this.egg;
    }
}
