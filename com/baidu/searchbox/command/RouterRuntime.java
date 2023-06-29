package com.baidu.searchbox.command;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.su9;
@Autowired
/* loaded from: classes3.dex */
public class RouterRuntime {
    @Inject
    public static ICommandIoc getICommandIoc() {
        return su9.a();
    }
}
