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
    private McnVideoAdView bAb;
    private McnVideoAdView.a bAc = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13404");
                aqVar.dD("tid", aVar.tid);
                aqVar.dD("fid", aVar.fid);
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.ai("obj_locate", aVar.bzX);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13405");
                aqVar.dD("tid", aVar.tid);
                aqVar.dD("fid", aVar.fid);
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.ai("obj_locate", aVar.bzX);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bzW)) {
                b.SM().hI(aVar.bzW);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.bAb = new McnVideoAdView(context);
        this.bAb.setIMcnStatListener(this.bAc);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.bAb != null) {
            this.bAb.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.bAb != null) {
            this.bAb.dismiss();
        }
    }

    public void reset() {
        if (this.bAb != null) {
            this.bAb.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.bAb != null) {
            this.bAb.b(aVar, viewGroup);
        }
    }

    public void SN() {
        if (this.bAb != null) {
            this.bAb.SN();
        }
    }

    public boolean isShowing() {
        if (this.bAb != null) {
            return this.bAb.isShowing();
        }
        return false;
    }
}
