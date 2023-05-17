package com.baidu.searchbox.afx.business;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/afx/business/IAFXCommand;", "", "getMPControllerSwitch", "", "Companion", "library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAFXCommand {
    public static final Companion Companion = Companion.$$INSTANCE;
    @JvmField
    public static final IAFXCommand EMPTY = new IAFXCommand() { // from class: com.baidu.searchbox.afx.business.IAFXCommand$Companion$EMPTY$1
        @Override // com.baidu.searchbox.afx.business.IAFXCommand
        public boolean getMPControllerSwitch() {
            return false;
        }
    };

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/afx/business/IAFXCommand$Companion;", "", "()V", "EMPTY", "Lcom/baidu/searchbox/afx/business/IAFXCommand;", "library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
    }

    boolean getMPControllerSwitch();
}
