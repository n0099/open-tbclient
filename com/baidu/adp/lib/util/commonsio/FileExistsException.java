package com.baidu.adp.lib.util.commonsio;

import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public class FileExistsException extends IOException {
    private static final long serialVersionUID = 1;

    public FileExistsException() {
    }

    public FileExistsException(String str) {
        super(str);
    }

    public FileExistsException(File file) {
        super("File " + file + " exists");
    }
}
