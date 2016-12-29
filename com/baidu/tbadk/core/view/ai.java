package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.bc;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements c.b {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.ahk = threadCommentAndPraiseInfoLayout;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        List list;
        TbPageContext<?> tbPageContext;
        list = this.ahk.agY;
        String str = (String) com.baidu.tbadk.core.util.x.c(list, i);
        if (!StringUtils.isNull(str)) {
            bc vz = bc.vz();
            tbPageContext = this.ahk.GO;
            vz.c(tbPageContext, new String[]{str});
        }
        cVar.dismiss();
    }
}
