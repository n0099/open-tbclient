package com.baidu.audiorecorder.a;

import android.content.Context;
import android.view.View;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends aa {
    public a(Context context) {
        super(context, (String) null, 6);
        this.name = TbadkCoreApplication.m9getInst().getResources().getString(t.j.switch_to_voice);
        this.auX = t.f.selector_msgsend_btn_govoice;
        this.avb = true;
        this.ava = 5;
        this.aue = new SendVoiceView(context);
        y.a aVar = new y.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(t.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(t.e.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(t.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(t.e.ds20);
        aVar.weight = 1.0f;
        ((View) this.aue).setLayoutParams(aVar);
        this.avc = new int[0];
    }
}
