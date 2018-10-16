package com.baidu.searchbox.ng.ai.apps.runtime;

import java.io.File;
/* loaded from: classes2.dex */
public interface Persistability<ReferencesT, DataBaseT> extends Ability {
    DataBaseT getDataBase();

    ReferencesT getReferences();

    File getStorageDir();
}
