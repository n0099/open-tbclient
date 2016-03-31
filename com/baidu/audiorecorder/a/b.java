package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.audiorecorder.lib.voice.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, TbadkCoreApplication.m411getInst().getResources().getString(t.j.editor_record), 6);
        this.launcherIcon = t.f.btn_pb_add_microphone;
        this.toolPosition = 6;
        this.toolNeedAction = true;
        this.toolView = s.F(context);
        this.toolLaunchAction = new int[]{1, 9};
    }
}
