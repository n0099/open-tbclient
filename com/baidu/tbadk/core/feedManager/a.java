package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a eIT;
    private DataRes eIV;
    private FeedRecModel.a eIW = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.eIV = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void aE(int i, String str) {
            a.this.eIV = null;
        }
    };
    private FeedRecModel eIU = new FeedRecModel();

    public a() {
        this.eIU.a(this.eIW);
    }

    public static a bpu() {
        if (eIT == null) {
            synchronized (a.class) {
                if (eIT == null) {
                    eIT = new a();
                }
            }
        }
        return eIT;
    }

    public DataRes bpv() {
        return this.eIV;
    }
}
