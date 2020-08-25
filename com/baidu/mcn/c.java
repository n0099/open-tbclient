package com.baidu.mcn;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mcn.McnVideoAdView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes2.dex */
public class c {
    private McnVideoAdView bzY;
    private McnVideoAdView.a bzZ = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13404");
                aqVar.dD("tid", aVar.tid);
                aqVar.dD("fid", aVar.fid);
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.ai("obj_locate", aVar.bzU);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                aq aqVar = new aq("c13405");
                aqVar.dD("tid", aVar.tid);
                aqVar.dD("fid", aVar.fid);
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.ai("obj_locate", aVar.bzU);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bzT)) {
                b.SM().hH(aVar.bzT);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.bzY = new McnVideoAdView(context);
        this.bzY.setIMcnStatListener(this.bzZ);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.bzY != null) {
            this.bzY.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.bzY != null) {
            this.bzY.dismiss();
        }
    }

    public void reset() {
        if (this.bzY != null) {
            this.bzY.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.bzY != null) {
            this.bzY.b(aVar, viewGroup);
        }
    }

    public void SN() {
        if (this.bzY != null) {
            this.bzY.SN();
        }
    }

    public boolean isShowing() {
        if (this.bzY != null) {
            return this.bzY.isShowing();
        }
        return false;
    }
}
