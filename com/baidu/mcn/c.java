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
    private McnVideoAdView bhs;
    private McnVideoAdView.a bht = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13404");
                anVar.cI("tid", aVar.tid);
                anVar.cI("fid", aVar.fid);
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.af("obj_locate", aVar.bho);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13405");
                anVar.cI("tid", aVar.tid);
                anVar.cI("fid", aVar.fid);
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.af("obj_locate", aVar.bho);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bhn)) {
                b.JE().ft(aVar.bhn);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.bhs = new McnVideoAdView(context);
        this.bhs.setIMcnStatListener(this.bht);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.bhs != null) {
            this.bhs.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.bhs != null) {
            this.bhs.dismiss();
        }
    }

    public void reset() {
        if (this.bhs != null) {
            this.bhs.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.bhs != null) {
            this.bhs.b(aVar, viewGroup);
        }
    }

    public void JF() {
        if (this.bhs != null) {
            this.bhs.JF();
        }
    }

    public boolean isShowing() {
        if (this.bhs != null) {
            return this.bhs.isShowing();
        }
        return false;
    }
}
