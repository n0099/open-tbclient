package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a eZd;
    private DataRes eZf;
    private FeedRecModel.a eZg = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.eZf = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void aE(int i, String str) {
            a.this.eZf = null;
        }
    };
    private FeedRecModel eZe = new FeedRecModel();

    public a() {
        this.eZe.a(this.eZg);
    }

    public static a buD() {
        if (eZd == null) {
            synchronized (a.class) {
                if (eZd == null) {
                    eZd = new a();
                }
            }
        }
        return eZd;
    }

    public DataRes buE() {
        return this.eZf;
    }
}
