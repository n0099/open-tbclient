package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.audiorecorder.lib.voice.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, TbadkCoreApplication.m11getInst().getResources().getString(t.j.editor_record), 6);
        this.aql = t.f.btn_pb_add_microphone;
        this.aqo = 6;
        this.aqp = true;
        this.aps = s.F(context);
        this.aqq = new int[]{1, 9};
    }
}
