package com.baidu.searchbox.common.security.ioc;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.gaa;
@Autowired
/* loaded from: classes3.dex */
public class HostAbilityRuntime {
    @Inject
    public static IHostStateAbiltiy getHostAbility() {
        return new gaa();
    }
}
