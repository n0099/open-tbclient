package com.baidu.mcn;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mcn.McnVideoAdView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class c {
    private McnVideoAdView ayZ;
    private McnVideoAdView.a aza = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13404");
                anVar.bS("tid", aVar.tid);
                anVar.bS("fid", aVar.fid);
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.O("obj_locate", aVar.ayU);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13405");
                anVar.bS("tid", aVar.tid);
                anVar.bS("fid", aVar.fid);
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.O("obj_locate", aVar.ayU);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.ayT)) {
                b.zd().dt(aVar.ayT);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.ayZ = new McnVideoAdView(context);
        this.ayZ.setIMcnStatListener(this.aza);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.ayZ != null) {
            this.ayZ.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.ayZ != null) {
            this.ayZ.dismiss();
        }
    }

    public void reset() {
        if (this.ayZ != null) {
            this.ayZ.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.ayZ != null) {
            this.ayZ.b(aVar, viewGroup);
        }
    }

    public void ze() {
        if (this.ayZ != null) {
            this.ayZ.ze();
        }
    }

    public boolean isShowing() {
        if (this.ayZ != null) {
            return this.ayZ.isShowing();
        }
        return false;
    }
}
