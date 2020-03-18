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
    private McnVideoAdView aLG;
    private McnVideoAdView.a aLH = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13404");
                anVar.cx("tid", aVar.tid);
                anVar.cx("fid", aVar.fid);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.X("obj_locate", aVar.aLC);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13405");
                anVar.cx("tid", aVar.tid);
                anVar.cx("fid", aVar.fid);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.X("obj_locate", aVar.aLC);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.aLB)) {
                b.DN().ez(aVar.aLB);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.aLG = new McnVideoAdView(context);
        this.aLG.setIMcnStatListener(this.aLH);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.aLG != null) {
            this.aLG.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.aLG != null) {
            this.aLG.dismiss();
        }
    }

    public void reset() {
        if (this.aLG != null) {
            this.aLG.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.aLG != null) {
            this.aLG.b(aVar, viewGroup);
        }
    }

    public void DO() {
        if (this.aLG != null) {
            this.aLG.DO();
        }
    }

    public boolean isShowing() {
        if (this.aLG != null) {
            return this.aLG.isShowing();
        }
        return false;
    }
}
