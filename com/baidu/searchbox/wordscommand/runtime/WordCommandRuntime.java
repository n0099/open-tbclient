package com.baidu.searchbox.wordscommand.runtime;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.qha;
@Autowired
/* loaded from: classes4.dex */
public class WordCommandRuntime {
    public static boolean DEBUG = AppConfig.isDebug();

    @Inject(force = true)
    public static IWordCommandApp getWordCommandApp() {
        return qha.a();
    }
}
