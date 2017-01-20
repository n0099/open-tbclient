package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.audiorecorder.lib.voice.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends x {
    public b(Context context) {
        super(context, TbadkCoreApplication.m9getInst().getResources().getString(r.l.editor_record), 6);
        this.atW = r.g.btn_pb_add_microphone;
        this.atZ = 6;
        this.aua = true;
        this.atm = s.M(context);
        this.aub = new int[]{1, 9};
    }
}
