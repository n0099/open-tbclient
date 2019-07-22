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
    private McnVideoAdView afB;
    private McnVideoAdView.a afC = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13404");
                anVar.bT("tid", aVar.tid);
                anVar.bT("fid", aVar.fid);
                anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.P("obj_locate", aVar.afw);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13405");
                anVar.bT("tid", aVar.tid);
                anVar.bT("fid", aVar.fid);
                anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.P("obj_locate", aVar.afw);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.afv)) {
                b.uj().cI(aVar.afv);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.afB = new McnVideoAdView(context);
        this.afB.setIMcnStatListener(this.afC);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.afB != null) {
            this.afB.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.afB != null) {
            this.afB.dismiss();
        }
    }

    public void reset() {
        if (this.afB != null) {
            this.afB.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.afB != null) {
            this.afB.b(aVar, viewGroup);
        }
    }

    public void uk() {
        if (this.afB != null) {
            this.afB.uk();
        }
    }

    public boolean isShowing() {
        if (this.afB != null) {
            return this.afB.isShowing();
        }
        return false;
    }
}
