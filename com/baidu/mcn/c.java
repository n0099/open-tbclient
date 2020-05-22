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
    private McnVideoAdView boQ;
    private McnVideoAdView.a boR = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13404");
                anVar.dh("tid", aVar.tid);
                anVar.dh("fid", aVar.fid);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.ag("obj_locate", aVar.boM);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13405");
                anVar.dh("tid", aVar.tid);
                anVar.dh("fid", aVar.fid);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.ag("obj_locate", aVar.boM);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.boL)) {
                b.Lx().gf(aVar.boL);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.boQ = new McnVideoAdView(context);
        this.boQ.setIMcnStatListener(this.boR);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.boQ != null) {
            this.boQ.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.boQ != null) {
            this.boQ.dismiss();
        }
    }

    public void reset() {
        if (this.boQ != null) {
            this.boQ.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.boQ != null) {
            this.boQ.b(aVar, viewGroup);
        }
    }

    public void Ly() {
        if (this.boQ != null) {
            this.boQ.Ly();
        }
    }

    public boolean isShowing() {
        if (this.boQ != null) {
            return this.boQ.isShowing();
        }
        return false;
    }
}
