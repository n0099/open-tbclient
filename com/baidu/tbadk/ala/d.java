package com.baidu.tbadk.ala;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d {
    private static View.OnClickListener QT = new e();

    public static TextView ap(Context context) {
        if (context == null || MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setBackgroundDrawable(context.getResources().getDrawable(w.g.live_tail_selector));
        textView.setOnClickListener(QT);
        return textView;
    }
}
