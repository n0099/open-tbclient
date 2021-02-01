package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a eWI;
    private DataRes eWK;
    private FeedRecModel.a eWL = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.eWK = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void aJ(int i, String str) {
            a.this.eWK = null;
        }
    };
    private FeedRecModel eWJ = new FeedRecModel();

    public a() {
        this.eWJ.a(this.eWL);
    }

    public static a brd() {
        if (eWI == null) {
            synchronized (a.class) {
                if (eWI == null) {
                    eWI = new a();
                }
            }
        }
        return eWI;
    }

    public DataRes bre() {
        return this.eWK;
    }
}
