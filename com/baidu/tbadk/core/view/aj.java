package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.ba;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements c.b {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout agx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.agx = threadCommentAndPraiseInfoLayout;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        List list;
        TbPageContext<?> tbPageContext;
        list = this.agx.agl;
        String str = (String) com.baidu.tbadk.core.util.w.c(list, i);
        if (!StringUtils.isNull(str)) {
            ba vt = ba.vt();
            tbPageContext = this.agx.FY;
            vt.c(tbPageContext, new String[]{str});
        }
        cVar.dismiss();
    }
}
