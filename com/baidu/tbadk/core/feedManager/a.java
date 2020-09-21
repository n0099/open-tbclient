package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a eix;
    private FeedRecModel.a eiA = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.eiz = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void an(int i, String str) {
            a.this.eiz = null;
        }
    };
    private FeedRecModel eiy = new FeedRecModel();
    private DataRes eiz;

    public a() {
        this.eiy.a(this.eiA);
    }

    public static a bis() {
        if (eix == null) {
            synchronized (a.class) {
                if (eix == null) {
                    eix = new a();
                }
            }
        }
        return eix;
    }

    public DataRes bit() {
        return this.eiz;
    }
}
