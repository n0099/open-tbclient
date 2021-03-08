package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a eYh;
    private DataRes eYj;
    private FeedRecModel.a eYk = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.eYj = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void aJ(int i, String str) {
            a.this.eYj = null;
        }
    };
    private FeedRecModel eYi = new FeedRecModel();

    public a() {
        this.eYi.a(this.eYk);
    }

    public static a bre() {
        if (eYh == null) {
            synchronized (a.class) {
                if (eYh == null) {
                    eYh = new a();
                }
            }
        }
        return eYh;
    }

    public DataRes brf() {
        return this.eYj;
    }
}
