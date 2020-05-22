package com.baidu.audiorecorder.a;

import android.content.Context;
import android.view.View;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class a extends l {
    public a(Context context) {
        super(context, (String) null, 6);
        this.name = TbadkCoreApplication.getInst().getResources().getString(R.string.switch_to_voice);
        this.elH = R.drawable.icon_pure_post_speak24_svg;
        this.elJ = true;
        this.elN = true;
        this.elM = 5;
        this.ekV = new SendVoiceView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        layoutParams.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        layoutParams.weight = 1.0f;
        ((View) this.ekV).setLayoutParams(layoutParams);
        this.elO = new int[0];
    }
}
