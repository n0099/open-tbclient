package com.baidu.searchbox.ui.animview.praise.ioc;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Autowired
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/ui/animview/praise/ioc/InteractionEncourageRuntime;", "", "()V", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "Lcom/baidu/searchbox/ui/animview/praise/ioc/IEncourage;", "lib-praise_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InteractionEncourageRuntime {
    public static final InteractionEncourageRuntime INSTANCE = new InteractionEncourageRuntime();

    @JvmStatic
    @Inject(force = false)
    public static final IEncourage get() {
        return IEncourage.empty;
    }
}
