package com.baidu.audiorecorder.a;

import android.content.Context;
import android.view.View;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends aa {
    public a(Context context) {
        super(context, (String) null, 6);
        this.name = TbadkCoreApplication.m9getInst().getResources().getString(r.j.switch_to_voice);
        this.auA = r.f.selector_msgsend_btn_govoice;
        this.auE = true;
        this.auD = 5;
        this.atI = new SendVoiceView(context);
        y.a aVar = new y.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(r.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(r.e.ds20);
        aVar.weight = 1.0f;
        ((View) this.atI).setLayoutParams(aVar);
        this.auF = new int[0];
    }
}
