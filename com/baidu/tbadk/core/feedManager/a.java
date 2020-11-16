package com.baidu.tbadk.core.feedManager;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a {
    private static volatile a eHT;
    private DataRes eHV;
    private FeedRecModel.a eHW = new FeedRecModel.a() { // from class: com.baidu.tbadk.core.feedManager.a.1
        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            a.this.eHV = dataRes;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.a
        public void aC(int i, String str) {
            a.this.eHV = null;
        }
    };
    private FeedRecModel eHU = new FeedRecModel();

    public a() {
        this.eHU.a(this.eHW);
    }

    public static a boH() {
        if (eHT == null) {
            synchronized (a.class) {
                if (eHT == null) {
                    eHT = new a();
                }
            }
        }
        return eHT;
    }

    public DataRes boI() {
        return this.eHV;
    }
}
