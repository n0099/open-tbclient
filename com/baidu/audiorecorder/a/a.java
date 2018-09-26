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
        this.aQh = e.f.btn_pb_voice;
        this.aQl = true;
        this.aQk = 5;
        this.aPu = new SendVoiceView(context);
        RawLayout.a aVar = new RawLayout.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(e.C0141e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(e.C0141e.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(e.C0141e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(e.C0141e.ds20);
        aVar.weight = 1.0f;
        ((View) this.aPu).setLayoutParams(aVar);
        this.aQm = new int[0];
    }
}
