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
    private McnVideoAdView ayH;
    private McnVideoAdView.a ayI = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13404");
                anVar.bS("tid", aVar.tid);
                anVar.bS("fid", aVar.fid);
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.O("obj_locate", aVar.ayC);
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
                anVar.O("obj_locate", aVar.ayC);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.ayB)) {
                b.ze().dt(aVar.ayB);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.ayH = new McnVideoAdView(context);
        this.ayH.setIMcnStatListener(this.ayI);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.ayH != null) {
            this.ayH.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.ayH != null) {
            this.ayH.dismiss();
        }
    }

    public void reset() {
        if (this.ayH != null) {
            this.ayH.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.ayH != null) {
            this.ayH.b(aVar, viewGroup);
        }
    }

    public void zf() {
        if (this.ayH != null) {
            this.ayH.zf();
        }
    }

    public boolean isShowing() {
        if (this.ayH != null) {
            return this.ayH.isShowing();
        }
        return false;
    }
}
