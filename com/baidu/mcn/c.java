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
    private McnVideoAdView aLs;
    private McnVideoAdView.a aLt = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13404");
                anVar.cy("tid", aVar.tid);
                anVar.cy("fid", aVar.fid);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.X("obj_locate", aVar.aLo);
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
                anVar.X("obj_locate", aVar.aLo);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.aLn)) {
                b.DG().eA(aVar.aLn);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.aLs = new McnVideoAdView(context);
        this.aLs.setIMcnStatListener(this.aLt);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.aLs != null) {
            this.aLs.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.aLs != null) {
            this.aLs.dismiss();
        }
    }

    public void reset() {
        if (this.aLs != null) {
            this.aLs.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.aLs != null) {
            this.aLs.b(aVar, viewGroup);
        }
    }

    public void DH() {
        if (this.aLs != null) {
            this.aLs.DH();
        }
    }

    public boolean isShowing() {
        if (this.aLs != null) {
            return this.aLs.isShowing();
        }
        return false;
    }
}
