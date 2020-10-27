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
    private McnVideoAdView bSv;
    private McnVideoAdView.a bSw = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13404");
                aqVar.dR("tid", aVar.tid);
                aqVar.dR("fid", aVar.fid);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.aj("obj_locate", aVar.bSr);
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
                aqVar.aj("obj_locate", aVar.bSr);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bSq)) {
                b.Xq().iY(aVar.bSq);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.bSv = new McnVideoAdView(context);
        this.bSv.setIMcnStatListener(this.bSw);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.bSv != null) {
            this.bSv.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.bSv != null) {
            this.bSv.dismiss();
        }
    }

    public void reset() {
        if (this.bSv != null) {
            this.bSv.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.bSv != null) {
            this.bSv.b(aVar, viewGroup);
        }
    }

    public void Xr() {
        if (this.bSv != null) {
            this.bSv.Xr();
        }
    }

    public boolean isShowing() {
        if (this.bSv != null) {
            return this.bSv.isShowing();
        }
        return false;
    }
}
