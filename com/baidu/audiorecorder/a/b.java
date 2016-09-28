package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.audiorecorder.lib.voice.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, TbadkCoreApplication.m9getInst().getResources().getString(r.j.editor_record), 6);
        this.auA = r.f.btn_pb_add_microphone;
        this.auD = 6;
        this.auE = true;
        this.atI = s.O(context);
        this.auF = new int[]{1, 9};
    }
}
