package com.baidu.audiorecorder.a;

import android.content.Context;
import android.view.View;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends k {
    public a(Context context) {
        super(context, (String) null, 6);
        this.name = TbadkCoreApplication.getInst().getResources().getString(e.j.switch_to_voice);
        this.aUI = e.f.btn_pb_voice;
        this.aUM = true;
        this.aUL = 5;
        this.aTV = new SendVoiceView(context);
        RawLayout.a aVar = new RawLayout.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(e.C0175e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(e.C0175e.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(e.C0175e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(e.C0175e.ds20);
        aVar.weight = 1.0f;
        ((View) this.aTV).setLayoutParams(aVar);
        this.aUN = new int[0];
    }
}
