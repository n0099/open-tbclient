package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a dWE;
    private DataRes dWG;
    private FeedRecModel.a dWH = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.dWG = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void ao(int i, String str) {
            a.this.dWG = null;
        }
    };
    private FeedRecModel dWF = new FeedRecModel();

    public a() {
        this.dWF.a(this.dWH);
    }

    public static a aZd() {
        if (dWE == null) {
            synchronized (a.class) {
                if (dWE == null) {
                    dWE = new a();
                }
            }
        }
        return dWE;
    }

    public DataRes aZe() {
        return this.dWG;
    }
}
