package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a ePe;
    private DataRes ePg;
    private FeedRecModel.a ePh = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.ePg = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void aC(int i, String str) {
            a.this.ePg = null;
        }
    };
    private FeedRecModel ePf = new FeedRecModel();

    public a() {
        this.ePf.a(this.ePh);
    }

    public static a bsb() {
        if (ePe == null) {
            synchronized (a.class) {
                if (ePe == null) {
                    ePe = new a();
                }
            }
        }
        return ePe;
    }

    public DataRes bsc() {
        return this.ePg;
    }
}
