package com.baidu.searchbox.videoplayer.interfaces;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.pyramid.annotation.Singleton;
/* loaded from: classes4.dex */
public interface ILastVideoUrlOrNid {
    public static final ILastVideoUrlOrNid EMPTY = new ILastVideoUrlOrNid() { // from class: com.baidu.searchbox.videoplayer.interfaces.ILastVideoUrlOrNid.1
        @Override // com.baidu.searchbox.videoplayer.interfaces.ILastVideoUrlOrNid
        public String getLastNid() {
            return null;
        }

        @Override // com.baidu.searchbox.videoplayer.interfaces.ILastVideoUrlOrNid
        public String getLastUrl() {
            return null;
        }
    };

    String getLastNid();

    String getLastUrl();

    @Autowired
    /* loaded from: classes4.dex */
    public static class Impl {
        @Singleton
        @Inject(force = false)
        public static ILastVideoUrlOrNid getInstance() {
            return ILastVideoUrlOrNid.EMPTY;
        }
    }
}
