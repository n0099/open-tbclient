package com.baidu.audiorecorder.a;

import android.content.Context;
import android.view.View;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends k {
    public a(Context context) {
        super(context, (String) null, 6);
        this.name = TbadkCoreApplication.getInst().getResources().getString(d.k.switch_to_voice);
        this.aLW = d.f.btn_pb_voice;
        this.aMa = true;
        this.aLZ = 5;
        this.aLj = new SendVoiceView(context);
        RawLayout.a aVar = new RawLayout.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(d.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(d.e.ds20);
        aVar.weight = 1.0f;
        ((View) this.aLj).setLayoutParams(aVar);
        this.aMb = new int[0];
    }
}
