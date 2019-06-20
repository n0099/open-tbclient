package com.baidu.mcn;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mcn.McnVideoAdView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class c {
    private McnVideoAdView afe;
    private McnVideoAdView.a aff = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                am amVar = new am("c13404");
                amVar.bT("tid", aVar.tid);
                amVar.bT("fid", aVar.fid);
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.P("obj_locate", aVar.aeZ);
                TiebaStatic.log(amVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                am amVar = new am("c13405");
                amVar.bT("tid", aVar.tid);
                amVar.bT("fid", aVar.fid);
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.P("obj_locate", aVar.aeZ);
                TiebaStatic.log(amVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.aeY)) {
                b.tJ().cD(aVar.aeY);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.afe = new McnVideoAdView(context);
        this.afe.setIMcnStatListener(this.aff);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.afe != null) {
            this.afe.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.afe != null) {
            this.afe.dismiss();
        }
    }

    public void reset() {
        if (this.afe != null) {
            this.afe.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.afe != null) {
            this.afe.b(aVar, viewGroup);
        }
    }

    public void tK() {
        if (this.afe != null) {
            this.afe.tK();
        }
    }

    public boolean isShowing() {
        if (this.afe != null) {
            return this.afe.isShowing();
        }
        return false;
    }
}
