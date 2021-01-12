package com.baidu.audiorecorder.a;

import android.content.Context;
import android.view.View;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends m {
    public a(Context context) {
        super(context, (String) null, 6);
        this.name = TbadkCoreApplication.getInst().getResources().getString(R.string.switch_to_voice);
        this.fzM = R.drawable.icon_pure_post_speak24;
        this.fzP = false;
        this.fzQ = true;
        this.fzU = true;
        this.fzT = 5;
        this.fyZ = new SendVoiceView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        layoutParams.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        layoutParams.weight = 1.0f;
        ((View) this.fyZ).setLayoutParams(layoutParams);
        this.fzV = new int[0];
    }
}
