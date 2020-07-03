package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a dQm;
    private DataRes dQo;
    private FeedRecModel.a dQp = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.dQo = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void an(int i, String str) {
            a.this.dQo = null;
        }
    };
    private FeedRecModel dQn = new FeedRecModel();

    public a() {
        this.dQn.a(this.dQp);
    }

    public static a aVd() {
        if (dQm == null) {
            synchronized (a.class) {
                if (dQm == null) {
                    dQm = new a();
                }
            }
        }
        return dQm;
    }

    public DataRes aVe() {
        return this.dQo;
    }
}
