package com.baidu.audiorecorder.a;

import android.content.Context;
import android.view.View;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a extends k {
    public a(Context context) {
        super(context, (String) null, 6);
        this.name = TbadkCoreApplication.getInst().getResources().getString(f.j.switch_to_voice);
        this.aMP = f.C0146f.btn_pb_voice;
        this.aMT = true;
        this.aMS = 5;
        this.aMc = new SendVoiceView(context);
        RawLayout.a aVar = new RawLayout.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(f.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(f.e.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(f.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(f.e.ds20);
        aVar.weight = 1.0f;
        ((View) this.aMc).setLayoutParams(aVar);
        this.aMU = new int[0];
    }
}
