package com.baidu.mcn;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mcn.McnVideoAdView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class c {
    private McnVideoAdView civ;
    private McnVideoAdView.a ciw = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13404");
                aqVar.dX("tid", aVar.tid);
                aqVar.dX("fid", aVar.fid);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.an("obj_locate", aVar.cir);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13405");
                aqVar.dX("tid", aVar.tid);
                aqVar.dX("fid", aVar.fid);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.an("obj_locate", aVar.cir);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.ciq)) {
                b.adv().jC(aVar.ciq);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.civ = new McnVideoAdView(context);
        this.civ.setIMcnStatListener(this.ciw);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.civ != null) {
            this.civ.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.civ != null) {
            this.civ.dismiss();
        }
    }

    public void reset() {
        if (this.civ != null) {
            this.civ.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.civ != null) {
            this.civ.b(aVar, viewGroup);
        }
    }

    public void adw() {
        if (this.civ != null) {
            this.civ.adw();
        }
    }

    public boolean isShowing() {
        if (this.civ != null) {
            return this.civ.isShowing();
        }
        return false;
    }
}
