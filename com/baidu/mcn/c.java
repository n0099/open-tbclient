package com.baidu.mcn;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mcn.McnVideoAdView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class c {
    private McnVideoAdView bun;
    private McnVideoAdView.a buo = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                ap apVar = new ap("c13404");
                apVar.dn("tid", aVar.tid);
                apVar.dn("fid", aVar.fid);
                apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                apVar.ah("obj_locate", aVar.buj);
                TiebaStatic.log(apVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                ap apVar = new ap("c13405");
                apVar.dn("tid", aVar.tid);
                apVar.dn("fid", aVar.fid);
                apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                apVar.ah("obj_locate", aVar.buj);
                TiebaStatic.log(apVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bui)) {
                b.MN().gm(aVar.bui);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.bun = new McnVideoAdView(context);
        this.bun.setIMcnStatListener(this.buo);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.bun != null) {
            this.bun.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.bun != null) {
            this.bun.dismiss();
        }
    }

    public void reset() {
        if (this.bun != null) {
            this.bun.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.bun != null) {
            this.bun.b(aVar, viewGroup);
        }
    }

    public void MO() {
        if (this.bun != null) {
            this.bun.MO();
        }
    }

    public boolean isShowing() {
        if (this.bun != null) {
            return this.bun.isShowing();
        }
        return false;
    }
}
