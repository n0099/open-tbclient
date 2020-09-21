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
    private McnVideoAdView bDy;
    private McnVideoAdView.a bDz = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13404");
                aqVar.dF("tid", aVar.tid);
                aqVar.dF("fid", aVar.fid);
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.ai("obj_locate", aVar.bDu);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13405");
                aqVar.dF("tid", aVar.tid);
                aqVar.dF("fid", aVar.fid);
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.ai("obj_locate", aVar.bDu);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bDt)) {
                b.TD().ie(aVar.bDt);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.bDy = new McnVideoAdView(context);
        this.bDy.setIMcnStatListener(this.bDz);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.bDy != null) {
            this.bDy.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.bDy != null) {
            this.bDy.dismiss();
        }
    }

    public void reset() {
        if (this.bDy != null) {
            this.bDy.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.bDy != null) {
            this.bDy.b(aVar, viewGroup);
        }
    }

    public void TE() {
        if (this.bDy != null) {
            this.bDy.TE();
        }
    }

    public boolean isShowing() {
        if (this.bDy != null) {
            return this.bDy.isShowing();
        }
        return false;
    }
}
