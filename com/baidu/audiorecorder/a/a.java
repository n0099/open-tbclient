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
        this.avu = r.f.selector_msgsend_btn_govoice;
        this.avy = true;
        this.avx = 5;
        this.auC = new SendVoiceView(context);
        y.a aVar = new y.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(r.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(r.e.ds20);
        aVar.weight = 1.0f;
        ((View) this.auC).setLayoutParams(aVar);
        this.avz = new int[0];
    }
}
