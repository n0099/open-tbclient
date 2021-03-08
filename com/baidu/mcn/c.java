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
    private McnVideoAdView cjr;
    private McnVideoAdView.a cjs = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                ar arVar = new ar("c13404");
                arVar.dR("tid", aVar.tid);
                arVar.dR("fid", aVar.fid);
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.aq("obj_locate", aVar.cjn);
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
                arVar.aq("obj_locate", aVar.cjn);
                TiebaStatic.log(arVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.cjm)) {
                b.abu().jd(aVar.cjm);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.cjr = new McnVideoAdView(context);
        this.cjr.setIMcnStatListener(this.cjs);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.cjr != null) {
            this.cjr.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.cjr != null) {
            this.cjr.dismiss();
        }
    }

    public void reset() {
        if (this.cjr != null) {
            this.cjr.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.cjr != null) {
            this.cjr.b(aVar, viewGroup);
        }
    }

    public void abv() {
        if (this.cjr != null) {
            this.cjr.abv();
        }
    }

    public boolean isShowing() {
        if (this.cjr != null) {
            return this.cjr.isShowing();
        }
        return false;
    }
}
