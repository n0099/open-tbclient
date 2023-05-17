package com.baidu.searchbox.afx.business;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Autowired
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/afx/business/AFXBusinessRuntime;", "", "()V", "getAFXCommand", "Lcom/baidu/searchbox/afx/business/IAFXCommand;", "library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AFXBusinessRuntime {
    public static final AFXBusinessRuntime INSTANCE = new AFXBusinessRuntime();

    @JvmStatic
    @Inject(force = false)
    public static final IAFXCommand getAFXCommand() {
        return IAFXCommand.EMPTY;
    }
}
