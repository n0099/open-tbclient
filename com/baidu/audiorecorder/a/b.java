package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.audiorecorder.lib.voice.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b extends y {
    public b(Context context) {
        super(context, TbadkCoreApplication.m411getInst().getResources().getString(n.j.editor_record), 6);
        this.launcherIcon = n.f.btn_pb_add_microphone;
        this.toolPosition = 6;
        this.toolNeedAction = true;
        this.toolView = s.O(context);
        this.toolLaunchAction = new int[]{1, 9};
    }
}
