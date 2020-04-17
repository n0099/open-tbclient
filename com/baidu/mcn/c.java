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
    private McnVideoAdView bhn;
    private McnVideoAdView.a bho = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13404");
                anVar.cI("tid", aVar.tid);
                anVar.cI("fid", aVar.fid);
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.af("obj_locate", aVar.bhj);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13405");
                anVar.cI("tid", aVar.tid);
                anVar.cI("fid", aVar.fid);
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.af("obj_locate", aVar.bhj);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bhi)) {
                b.JF().ft(aVar.bhi);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.bhn = new McnVideoAdView(context);
        this.bhn.setIMcnStatListener(this.bho);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.bhn != null) {
            this.bhn.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.bhn != null) {
            this.bhn.dismiss();
        }
    }

    public void reset() {
        if (this.bhn != null) {
            this.bhn.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.bhn != null) {
            this.bhn.b(aVar, viewGroup);
        }
    }

    public void JG() {
        if (this.bhn != null) {
            this.bhn.JG();
        }
    }

    public boolean isShowing() {
        if (this.bhn != null) {
            return this.bhn.isShowing();
        }
        return false;
    }
}
