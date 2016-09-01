package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.audiorecorder.lib.voice.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, TbadkCoreApplication.m9getInst().getResources().getString(t.j.editor_record), 6);
        this.auX = t.f.btn_pb_add_microphone;
        this.ava = 6;
        this.avb = true;
        this.aue = s.O(context);
        this.avc = new int[]{1, 9};
    }
}
