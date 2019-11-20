package com.baidu.audiorecorder.a;

import android.content.Context;
import android.view.View;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends k {
    public a(Context context) {
        super(context, (String) null, 6);
        this.name = TbadkCoreApplication.getInst().getResources().getString(R.string.switch_to_voice);
        this.cFa = R.drawable.icon_pure_post_speak_n_svg;
        this.cFc = true;
        this.cFg = true;
        this.cFf = 5;
        this.cEn = new SendVoiceView(context);
        RawLayout.a aVar = new RawLayout.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.weight = 1.0f;
        ((View) this.cEn).setLayoutParams(aVar);
        this.cFh = new int[0];
    }
}
