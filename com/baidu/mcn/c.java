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
    private McnVideoAdView aLr;
    private McnVideoAdView.a aLs = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13404");
                anVar.cy("tid", aVar.tid);
                anVar.cy("fid", aVar.fid);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.X("obj_locate", aVar.aLn);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13405");
                anVar.cy("tid", aVar.tid);
                anVar.cy("fid", aVar.fid);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.X("obj_locate", aVar.aLn);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.aLm)) {
                b.DG().eA(aVar.aLm);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.aLr = new McnVideoAdView(context);
        this.aLr.setIMcnStatListener(this.aLs);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.aLr != null) {
            this.aLr.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.aLr != null) {
            this.aLr.dismiss();
        }
    }

    public void reset() {
        if (this.aLr != null) {
            this.aLr.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.aLr != null) {
            this.aLr.b(aVar, viewGroup);
        }
    }

    public void DH() {
        if (this.aLr != null) {
            this.aLr.DH();
        }
    }

    public boolean isShowing() {
        if (this.aLr != null) {
            return this.aLr.isShowing();
        }
        return false;
    }
}
