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
    private McnVideoAdView cdI;
    private McnVideoAdView.a cdJ = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13404");
                aqVar.dW("tid", aVar.tid);
                aqVar.dW("fid", aVar.fid);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.an("obj_locate", aVar.cdE);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13405");
                aqVar.dW("tid", aVar.tid);
                aqVar.dW("fid", aVar.fid);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.an("obj_locate", aVar.cdE);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.cdD)) {
                b.ZC().ir(aVar.cdD);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.cdI = new McnVideoAdView(context);
        this.cdI.setIMcnStatListener(this.cdJ);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.cdI != null) {
            this.cdI.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.cdI != null) {
            this.cdI.dismiss();
        }
    }

    public void reset() {
        if (this.cdI != null) {
            this.cdI.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.cdI != null) {
            this.cdI.b(aVar, viewGroup);
        }
    }

    public void ZD() {
        if (this.cdI != null) {
            this.cdI.ZD();
        }
    }

    public boolean isShowing() {
        if (this.cdI != null) {
            return this.cdI.isShowing();
        }
        return false;
    }
}
