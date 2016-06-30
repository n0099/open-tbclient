package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.audiorecorder.lib.voice.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, TbadkCoreApplication.m9getInst().getResources().getString(u.j.editor_record), 6);
        this.arb = u.f.btn_pb_add_microphone;
        this.are = 6;
        this.arf = true;
        this.aqi = s.E(context);
        this.arg = new int[]{1, 9};
    }
}
