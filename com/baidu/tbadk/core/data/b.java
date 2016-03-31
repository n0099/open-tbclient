package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.Adkiller;
import tbclient.FrsPage.AdkillerAd;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId RJ = BdUniqueId.gen();
    private int RK;
    private int RL;
    private String RM;
    private int RO;
    private List<a> RP;

    public void a(Adkiller adkiller) {
        if (adkiller != null) {
            try {
                this.RK = adkiller.show_hint.intValue();
                this.RL = adkiller.show_ad.intValue();
                this.RM = adkiller.hint_url;
                this.RO = adkiller.ad_left_num.intValue();
                if (adkiller.ad_list != null) {
                    this.RP = new ArrayList();
                    for (AdkillerAd adkillerAd : adkiller.ad_list) {
                        a aVar = new a();
                        aVar.a(adkillerAd);
                        this.RP.add(aVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return RJ;
    }

    public String rf() {
        return this.RM;
    }

    public int rg() {
        return this.RO;
    }

    public void bD(int i) {
        this.RO = i;
    }

    public List<a> rh() {
        return this.RP;
    }

    /* loaded from: classes.dex */
    public static class a {
        private int RQ;
        private c RR;
        private String tag;
        private String url;

        public String getTag() {
            return this.tag;
        }

        public String getUrl() {
            return this.url;
        }

        public int ri() {
            return this.RQ;
        }

        public c rj() {
            return this.RR;
        }

        public void a(AdkillerAd adkillerAd) {
            if (adkillerAd != null) {
                try {
                    this.tag = adkillerAd.tag;
                    this.url = adkillerAd.game_url;
                    this.RQ = adkillerAd.can_close.intValue();
                    this.RR = new c();
                    this.RR.a(adkillerAd.app);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
