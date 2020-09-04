package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a egi;
    private DataRes egk;
    private FeedRecModel.a egl = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.egk = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void am(int i, String str) {
            a.this.egk = null;
        }
    };
    private FeedRecModel egj = new FeedRecModel();

    public a() {
        this.egj.a(this.egl);
    }

    public static a bhy() {
        if (egi == null) {
            synchronized (a.class) {
                if (egi == null) {
                    egi = new a();
                }
            }
        }
        return egi;
    }

    public DataRes bhz() {
        return this.egk;
    }
}
