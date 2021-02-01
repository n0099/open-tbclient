package com.baidu.mcn;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mcn.McnVideoAdView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class c {
    private McnVideoAdView chQ;
    private McnVideoAdView.a chR = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                ar arVar = new ar("c13404");
                arVar.dR("tid", aVar.tid);
                arVar.dR("fid", aVar.fid);
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.ap("obj_locate", aVar.chM);
                TiebaStatic.log(arVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                ar arVar = new ar("c13405");
                arVar.dR("tid", aVar.tid);
                arVar.dR("fid", aVar.fid);
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.ap("obj_locate", aVar.chM);
                TiebaStatic.log(arVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.chL)) {
                b.abr().iX(aVar.chL);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.chQ = new McnVideoAdView(context);
        this.chQ.setIMcnStatListener(this.chR);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.chQ != null) {
            this.chQ.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.chQ != null) {
            this.chQ.dismiss();
        }
    }

    public void reset() {
        if (this.chQ != null) {
            this.chQ.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.chQ != null) {
            this.chQ.b(aVar, viewGroup);
        }
    }

    public void abs() {
        if (this.chQ != null) {
            this.chQ.abs();
        }
    }

    public boolean isShowing() {
        if (this.chQ != null) {
            return this.chQ.isShowing();
        }
        return false;
    }
}
