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
    private McnVideoAdView aGt;
    private McnVideoAdView.a aGu = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                an anVar = new an("c13404");
                anVar.cp("tid", aVar.tid);
                anVar.cp("fid", aVar.fid);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.Z("obj_locate", aVar.aGp);
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
                anVar.Z("obj_locate", aVar.aGp);
                TiebaStatic.log(anVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.aGo)) {
                b.AS().ei(aVar.aGo);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.aGt = new McnVideoAdView(context);
        this.aGt.setIMcnStatListener(this.aGu);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.aGt != null) {
            this.aGt.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.aGt != null) {
            this.aGt.dismiss();
        }
    }

    public void reset() {
        if (this.aGt != null) {
            this.aGt.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.aGt != null) {
            this.aGt.b(aVar, viewGroup);
        }
    }

    public void AT() {
        if (this.aGt != null) {
            this.aGt.AT();
        }
    }

    public boolean isShowing() {
        if (this.aGt != null) {
            return this.aGt.isShowing();
        }
        return false;
    }
}
