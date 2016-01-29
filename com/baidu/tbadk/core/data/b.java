package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.Adkiller;
import tbclient.FrsPage.AdkillerAd;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId Ue = BdUniqueId.gen();
    private int Uf;
    private int Ug;
    private String Uh;
    private int Ui;
    private List<a> Uj;

    public void a(Adkiller adkiller) {
        if (adkiller != null) {
            try {
                this.Uf = adkiller.show_hint.intValue();
                this.Ug = adkiller.show_ad.intValue();
                this.Uh = adkiller.hint_url;
                this.Ui = adkiller.ad_left_num.intValue();
                if (adkiller.ad_list != null) {
                    this.Uj = new ArrayList();
                    for (AdkillerAd adkillerAd : adkiller.ad_list) {
                        a aVar = new a();
                        aVar.a(adkillerAd);
                        this.Uj.add(aVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Ue;
    }

    public String rH() {
        return this.Uh;
    }

    public int rI() {
        return this.Ui;
    }

    public void bE(int i) {
        this.Ui = i;
    }

    public List<a> rJ() {
        return this.Uj;
    }

    /* loaded from: classes.dex */
    public static class a {
        private int Uk;
        private c Ul;
        private String tag;
        private String url;

        public String getTag() {
            return this.tag;
        }

        public String getUrl() {
            return this.url;
        }

        public int rK() {
            return this.Uk;
        }

        public c rL() {
            return this.Ul;
        }

        public void a(AdkillerAd adkillerAd) {
            if (adkillerAd != null) {
                try {
                    this.tag = adkillerAd.tag;
                    this.url = adkillerAd.game_url;
                    this.Uk = adkillerAd.can_close.intValue();
                    this.Ul = new c();
                    this.Ul.a(adkillerAd.app);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
