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
    private McnVideoAdView bKa;
    private McnVideoAdView.a bKb = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13404");
                aqVar.dK("tid", aVar.tid);
                aqVar.dK("fid", aVar.fid);
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.aj("obj_locate", aVar.bJW);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13405");
                aqVar.dK("tid", aVar.tid);
                aqVar.dK("fid", aVar.fid);
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.aj("obj_locate", aVar.bJW);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bJV)) {
                b.Vw().iF(aVar.bJV);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.bKa = new McnVideoAdView(context);
        this.bKa.setIMcnStatListener(this.bKb);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.bKa != null) {
            this.bKa.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.bKa != null) {
            this.bKa.dismiss();
        }
    }

    public void reset() {
        if (this.bKa != null) {
            this.bKa.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.bKa != null) {
            this.bKa.b(aVar, viewGroup);
        }
    }

    public void Vx() {
        if (this.bKa != null) {
            this.bKa.Vx();
        }
    }

    public boolean isShowing() {
        if (this.bKa != null) {
            return this.bKa.isShowing();
        }
        return false;
    }
}
