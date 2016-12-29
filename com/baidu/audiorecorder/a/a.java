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
        this.name = TbadkCoreApplication.m9getInst().getResources().getString(r.j.switch_to_voice);
        this.auR = r.f.selector_msgsend_btn_govoice;
        this.auV = true;
        this.auU = 5;
        this.auh = new SendVoiceView(context);
        v.a aVar = new v.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(r.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(r.e.ds20);
        aVar.weight = 1.0f;
        ((View) this.auh).setLayoutParams(aVar);
        this.auW = new int[0];
    }
}
