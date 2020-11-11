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
    private McnVideoAdView bYf;
    private McnVideoAdView.a bYg = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13404");
                aqVar.dR("tid", aVar.tid);
                aqVar.dR("fid", aVar.fid);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.al("obj_locate", aVar.bYb);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13405");
                aqVar.dR("tid", aVar.tid);
                aqVar.dR("fid", aVar.fid);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.al("obj_locate", aVar.bYb);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bYa)) {
                b.ZP().jl(aVar.bYa);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.bYf = new McnVideoAdView(context);
        this.bYf.setIMcnStatListener(this.bYg);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.bYf != null) {
            this.bYf.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.bYf != null) {
            this.bYf.dismiss();
        }
    }

    public void reset() {
        if (this.bYf != null) {
            this.bYf.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.bYf != null) {
            this.bYf.b(aVar, viewGroup);
        }
    }

    public void ZQ() {
        if (this.bYf != null) {
            this.bYf.ZQ();
        }
    }

    public boolean isShowing() {
        if (this.bYf != null) {
            return this.bYf.isShowing();
        }
        return false;
    }
}
