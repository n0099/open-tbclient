package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.audiorecorder.lib.voice.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, TbadkCoreApplication.m10getInst().getResources().getString(u.j.editor_record), 6);
        this.arQ = u.f.btn_pb_add_microphone;
        this.arT = 6;
        this.arU = true;
        this.aqX = s.E(context);
        this.arV = new int[]{1, 9};
    }
}
