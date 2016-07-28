package com.baidu.audiorecorder.a;

import android.content.Context;
import android.view.View;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends aa {
    public a(Context context) {
        super(context, (String) null, 6);
        this.name = TbadkCoreApplication.m10getInst().getResources().getString(u.j.switch_to_voice);
        this.arQ = u.f.selector_msgsend_btn_govoice;
        this.arU = true;
        this.arT = 5;
        this.aqX = new SendVoiceView(context);
        y.a aVar = new y.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(u.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(u.e.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(u.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(u.e.ds20);
        aVar.weight = 1.0f;
        ((View) this.aqX).setLayoutParams(aVar);
        this.arV = new int[0];
    }
}
