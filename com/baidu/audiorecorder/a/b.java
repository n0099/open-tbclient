package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.audiorecorder.lib.voice.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends x {
    public b(Context context) {
        super(context, TbadkCoreApplication.m9getInst().getResources().getString(w.l.editor_record), 6);
        this.azJ = w.g.btn_pb_add_microphone;
        this.azM = 6;
        this.azN = true;
        this.ayZ = s.aj(context);
        this.azO = new int[]{1, 9};
    }
}
