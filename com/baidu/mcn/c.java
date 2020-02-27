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
    private McnVideoAdView aLq;
    private McnVideoAdView.a aLr = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13404");
                anVar.cy("tid", aVar.tid);
                anVar.cy("fid", aVar.fid);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.X("obj_locate", aVar.aLm);
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
                anVar.X("obj_locate", aVar.aLm);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.aLl)) {
                b.DE().eA(aVar.aLl);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.aLq = new McnVideoAdView(context);
        this.aLq.setIMcnStatListener(this.aLr);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.aLq != null) {
            this.aLq.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.aLq != null) {
            this.aLq.dismiss();
        }
    }

    public void reset() {
        if (this.aLq != null) {
            this.aLq.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.aLq != null) {
            this.aLq.b(aVar, viewGroup);
        }
    }

    public void DF() {
        if (this.aLq != null) {
            this.aLq.DF();
        }
    }

    public boolean isShowing() {
        if (this.aLq != null) {
            return this.aLq.isShowing();
        }
        return false;
    }
}
