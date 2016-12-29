package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.audiorecorder.lib.voice.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends x {
    public b(Context context) {
        super(context, TbadkCoreApplication.m9getInst().getResources().getString(r.j.editor_record), 6);
        this.auR = r.f.btn_pb_add_microphone;
        this.auU = 6;
        this.auV = true;
        this.auh = s.M(context);
        this.auW = new int[]{1, 9};
    }
}
