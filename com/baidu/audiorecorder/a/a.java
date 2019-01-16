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
        this.aZI = e.f.btn_pb_voice;
        this.aZM = true;
        this.aZL = 5;
        this.aYV = new SendVoiceView(context);
        RawLayout.a aVar = new RawLayout.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(e.C0210e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(e.C0210e.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(e.C0210e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(e.C0210e.ds20);
        aVar.weight = 1.0f;
        ((View) this.aYV).setLayoutParams(aVar);
        this.aZN = new int[0];
    }
}
