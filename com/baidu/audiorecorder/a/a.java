package com.baidu.audiorecorder.a;

import android.content.Context;
import android.view.View;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.p;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends r {
    public a(Context context) {
        super(context, (String) null, 6);
        this.name = TbadkCoreApplication.getInst().getResources().getString(d.l.switch_to_voice);
        this.aBh = d.g.btn_pb_voice;
        this.aBl = true;
        this.aBk = 5;
        this.aAv = new SendVoiceView(context);
        p.a aVar = new p.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.f.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(d.f.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(d.f.ds20);
        aVar.weight = 1.0f;
        ((View) this.aAv).setLayoutParams(aVar);
        this.aBm = new int[0];
    }
}
