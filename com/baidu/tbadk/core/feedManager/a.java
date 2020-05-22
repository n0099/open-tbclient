package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a dJw;
    private DataRes dJy;
    private FeedRecModel.a dJz = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.dJy = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void al(int i, String str) {
            a.this.dJy = null;
        }
    };
    private FeedRecModel dJx = new FeedRecModel();

    public a() {
        this.dJx.a(this.dJz);
    }

    public static a aTj() {
        if (dJw == null) {
            synchronized (a.class) {
                if (dJw == null) {
                    dJw = new a();
                }
            }
        }
        return dJw;
    }

    public DataRes aTk() {
        return this.dJy;
    }
}
