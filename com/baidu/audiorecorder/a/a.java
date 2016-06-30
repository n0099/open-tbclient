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
        this.name = TbadkCoreApplication.m9getInst().getResources().getString(u.j.switch_to_voice);
        this.arb = u.f.selector_msgsend_btn_govoice;
        this.arf = true;
        this.are = 5;
        this.aqi = new SendVoiceView(context);
        y.a aVar = new y.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(u.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(u.e.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(u.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(u.e.ds20);
        aVar.weight = 1.0f;
        ((View) this.aqi).setLayoutParams(aVar);
        this.arg = new int[0];
    }
}
