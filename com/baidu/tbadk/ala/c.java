package com.baidu.tbadk.ala;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    private static View.OnClickListener PT = new d();

    public static TextView ap(Context context) {
        if (context == null || MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
            return null;
        }
        TextView textView = (TextView) LayoutInflater.from(context).inflate(w.j.ala_tail_view_layout, (ViewGroup) null);
        textView.setOnClickListener(PT);
        return textView;
    }
}
