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
    private McnVideoAdView aHl;
    private McnVideoAdView.a aHm = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13404");
                anVar.cp("tid", aVar.tid);
                anVar.cp("fid", aVar.fid);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.Z("obj_locate", aVar.aHh);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13405");
                anVar.cp("tid", aVar.tid);
                anVar.cp("fid", aVar.fid);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.Z("obj_locate", aVar.aHh);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.aHg)) {
                b.Bo().el(aVar.aHg);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.aHl = new McnVideoAdView(context);
        this.aHl.setIMcnStatListener(this.aHm);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.aHl != null) {
            this.aHl.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.aHl != null) {
            this.aHl.dismiss();
        }
    }

    public void reset() {
        if (this.aHl != null) {
            this.aHl.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.aHl != null) {
            this.aHl.b(aVar, viewGroup);
        }
    }

    public void Bp() {
        if (this.aHl != null) {
            this.aHl.Bp();
        }
    }

    public boolean isShowing() {
        if (this.aHl != null) {
            return this.aHl.isShowing();
        }
        return false;
    }
}
