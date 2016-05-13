package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.Adkiller;
import tbclient.FrsPage.AdkillerAd;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId My = BdUniqueId.gen();
    private int MA;
    private String MB;
    private int MC;
    private List<a> MD;
    private int Mz;

    public void a(Adkiller adkiller) {
        if (adkiller != null) {
            try {
                this.Mz = adkiller.show_hint.intValue();
                this.MA = adkiller.show_ad.intValue();
                this.MB = adkiller.hint_url;
                this.MC = adkiller.ad_left_num.intValue();
                if (adkiller.ad_list != null) {
                    this.MD = new ArrayList();
                    for (AdkillerAd adkillerAd : adkiller.ad_list) {
                        a aVar = new a();
                        aVar.a(adkillerAd);
                        this.MD.add(aVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return My;
    }

    public String oA() {
        return this.MB;
    }

    public int oB() {
        return this.MC;
    }

    public void bp(int i) {
        this.MC = i;
    }

    public List<a> oC() {
        return this.MD;
    }

    /* loaded from: classes.dex */
    public static class a {
        private int ME;
        private c MF;
        private String tag;
        private String url;

        public String getTag() {
            return this.tag;
        }

        public String getUrl() {
            return this.url;
        }

        public int oD() {
            return this.ME;
        }

        public c oE() {
            return this.MF;
        }

        public void a(AdkillerAd adkillerAd) {
            if (adkillerAd != null) {
                try {
                    this.tag = adkillerAd.tag;
                    this.url = adkillerAd.game_url;
                    this.ME = adkillerAd.can_close.intValue();
                    this.MF = new c();
                    this.MF.a(adkillerAd.app);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
