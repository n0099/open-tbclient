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
    private McnVideoAdView bWv;
    private McnVideoAdView.a bWw = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                ar arVar = new ar("c13404");
                arVar.dR("tid", aVar.tid);
                arVar.dR("fid", aVar.fid);
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.ak("obj_locate", aVar.bWr);
                TiebaStatic.log(arVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                ar arVar = new ar("c13405");
                arVar.dR("tid", aVar.tid);
                arVar.dR("fid", aVar.fid);
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.ak("obj_locate", aVar.bWr);
                TiebaStatic.log(arVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bWq)) {
                b.Zg().jf(aVar.bWq);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.bWv = new McnVideoAdView(context);
        this.bWv.setIMcnStatListener(this.bWw);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.bWv != null) {
            this.bWv.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.bWv != null) {
            this.bWv.dismiss();
        }
    }

    public void reset() {
        if (this.bWv != null) {
            this.bWv.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.bWv != null) {
            this.bWv.b(aVar, viewGroup);
        }
    }

    public void Zh() {
        if (this.bWv != null) {
            this.bWv.Zh();
        }
    }

    public boolean isShowing() {
        if (this.bWv != null) {
            return this.bWv.isShowing();
        }
        return false;
    }
}
