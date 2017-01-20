package com.baidu.audiorecorder.a;

import android.content.Context;
import android.view.View;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.v;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends x {
    public a(Context context) {
        super(context, (String) null, 6);
        this.name = TbadkCoreApplication.m9getInst().getResources().getString(r.l.switch_to_voice);
        this.atW = r.g.selector_msgsend_btn_govoice;
        this.aua = true;
        this.atZ = 5;
        this.atm = new SendVoiceView(context);
        v.a aVar = new v.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(r.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(r.f.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(r.f.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(r.f.ds20);
        aVar.weight = 1.0f;
        ((View) this.atm).setLayoutParams(aVar);
        this.aub = new int[0];
    }
}
