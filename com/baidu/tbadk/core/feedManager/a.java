package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a eUs;
    private DataRes eUu;
    private FeedRecModel.a eUv = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.eUu = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void aF(int i, String str) {
            a.this.eUu = null;
        }
    };
    private FeedRecModel eUt = new FeedRecModel();

    public a() {
        this.eUt.a(this.eUv);
    }

    public static a bqK() {
        if (eUs == null) {
            synchronized (a.class) {
                if (eUs == null) {
                    eUs = new a();
                }
            }
        }
        return eUs;
    }

    public DataRes bqL() {
        return this.eUu;
    }
}
