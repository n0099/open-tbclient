package com.baidu.searchbox.bddownload.core.exception;

import java.io.IOException;
/* loaded from: classes3.dex */
public class FileBusyAfterRunException extends IOException {
    public static final FileBusyAfterRunException SIGNAL = new FileBusyAfterRunException() { // from class: com.baidu.searchbox.bddownload.core.exception.FileBusyAfterRunException.1
    };

    public FileBusyAfterRunException() {
        super("File busy after run");
    }
}
