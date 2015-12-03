package com.baidu.audiorecorder.a;

import android.content.Context;
import android.view.View;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.editortools.w;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends y {
    public a(Context context) {
        super(context, (String) null, 6);
        this.launcherIcon = n.e.selector_msgsend_btn_govoice;
        this.toolNeedAction = true;
        this.toolPosition = 5;
        this.toolView = new SendVoiceView(context);
        w.a aVar = new w.a(0, -2);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(n.d.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(n.d.ds10);
        aVar.topMargin = context.getResources().getDimensionPixelSize(n.d.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(n.d.ds20);
        aVar.weight = 1.0f;
        ((View) this.toolView).setLayoutParams(aVar);
        this.toolLaunchAction = new int[0];
    }
}
